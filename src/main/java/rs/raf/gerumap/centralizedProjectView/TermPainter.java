package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class TermPainter extends ElementPainter implements ISubscriber {

    public TermPainter(Element model) {
        super(model);
        model.getSubscribers().add(this);
    }

    @Override
    public void paintElement(Graphics2D g) {

        Term term = ((Term) getModel());

        g.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.8f));

        g.setColor(term.getBorderColor());
        g.setStroke(new BasicStroke(term.getThickness()));
        getWidthFromText(g, term);
        g.drawOval(term.getLocation().x, term.getLocation().y, term.getEllipseDimension().width, term.getEllipseDimension().height);

        g.setColor(term.getBackgroundColor());
        g.fillOval(term.getLocation().x, term.getLocation().y, term.getEllipseDimension().width, term.getEllipseDimension().height);

        g.setColor(term.getTextColor());
        g.setFont(new Font("Basic font", Font.PLAIN, term.getFontSize()));
        int offsetX = (term.getEllipseDimension().width - term.getDimension().width)/2;
        g.drawString(term.getName(), term.getLocation().x + offsetX, term.getLocation().y + 18);

    }

    @Override
    public boolean isContained(Point p) {
        if (getShape().contains(p)) return true;
        return false;
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case NAME_CHANGE -> SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView().getSelectedComponent());
        }
    }

    private Shape createShape(){
        Term term = ((Term) getModel());

        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(term.getLocation().x, term.getLocation().y);
        generalPath.lineTo(term.getLocation().x + term.getDimension().width, term.getLocation().y);
        generalPath.lineTo(term.getLocation().x + term.getDimension().width, term.getLocation().y + term.getDimension().height);
        generalPath.lineTo(term.getLocation().x, term.getLocation().y + term.getDimension().height);
        generalPath.closePath();

        setShape(generalPath);

        return getShape();
    }

    private void getWidthFromText(Graphics2D graphics2D, Term term){

        int width = graphics2D.getFontMetrics().stringWidth(term.getName());
        term.getDimension().width = Math.max(width, 10);
        term.getEllipseDimension().width = Math.max((int) (term.getDimension().width*1.33), 10);

    }
}
