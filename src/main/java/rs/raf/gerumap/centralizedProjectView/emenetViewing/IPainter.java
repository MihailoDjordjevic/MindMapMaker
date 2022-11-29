package rs.raf.gerumap.centralizedProjectView.emenetViewing;

import java.awt.*;

public interface IPainter {

    void paintElement(Graphics2D g);

    boolean isContained(Point p);

}
