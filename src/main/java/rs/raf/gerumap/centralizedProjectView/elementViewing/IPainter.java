package rs.raf.gerumap.centralizedProjectView.elementViewing;

import rs.raf.gerumap.observer.ISubscriber;

import java.awt.*;

public interface IPainter extends ISubscriber {

    void paintElement(Graphics2D g);

    boolean isContained(Point p);

    void setSelectionBorder(Graphics2D graphics2D);

    Shape createShape();
}
