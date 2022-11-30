package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.model.repository.implementation.Element;

import java.awt.*;

public class LinkPainter extends ElementPainter {

    public LinkPainter(Element model) {
        super(model);
    }

    @Override
    public void paintElement(Graphics2D g) {

    }

    @Override
    public boolean isContained(Point p) {
        return false;
    }
}
