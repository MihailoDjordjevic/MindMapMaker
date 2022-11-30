package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

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
        g.draw(createShape());

        g.setColor(term.getBackgroundColor());
        g.fill(getShape());

        g.setColor(term.getTextColor());
        g.setFont(new Font("Basic font", Font.PLAIN, term.getFontSize()));
        g.drawString(term.getName(), term.getLocation().x + 3, term.getLocation().y + 18);
    }

    @Override
    public boolean isContained(Point p) {
        if (getShape().contains(p)) return true;
        return false;
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

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
}
