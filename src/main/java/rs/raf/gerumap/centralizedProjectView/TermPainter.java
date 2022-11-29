package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class TermPainter extends ElementPainter implements ISubscriber {

    public TermPainter(MapNode model) {
        super(model);
        model.getSubscribers().add(this);
        setShape();
    }

    @Override
    public void paintElement(Graphics2D g) {
        Term term = ((Term) getModel());
        g.setColor(term.getColor());
        g.setStroke(new BasicStroke(term.getThickness()));
        g.draw(getShape());
       // g.drawRect(term.getLocation().x - term.getDimension().width/2, term.getLocation().y - term.getDimension().height/2, term.getDimension().width, term.getDimension().height);
        g.drawString(term.getName(), term.getLocation().x - term.getDimension().width/2, term.getLocation().y - term.getDimension().height/2 + 13);
    }

    @Override
    public boolean isContained(Point p) {
        if (getShape().contains(p)) return true;
        return false;
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

    }

    private void setShape(){
        Term term = ((Term) getModel());

        GeneralPath generalPath = new GeneralPath();
        generalPath.moveTo(term.getLocation().x, term.getLocation().y);
        generalPath.lineTo(term.getLocation().x + term.getDimension().width, term.getLocation().y);
        generalPath.lineTo(term.getLocation().x + term.getDimension().width, term.getLocation().y + term.getDimension().height);
        generalPath.lineTo(term.getLocation().x, term.getLocation().y + term.getDimension().height);
        generalPath.closePath();

        setShape(generalPath);

    }
}
