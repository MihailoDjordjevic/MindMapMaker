package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import java.awt.*;

public class LinkPainter extends ElementPainter {

    public LinkPainter(Element model) {
        super(model);
    }

    @Override
    public void paintElement(Graphics2D g) {
        Link link = ((Link) getModel());

        g.setColor(link.getBorderColor());
        g.setStroke(new BasicStroke(link.getThickness()));

        g.drawLine(
                link.getSourceTerm().getLocation().x + link.getSourceTerm().getEllipseDimension().width/2,
                 link.getSourceTerm().getLocation().y + link.getSourceTerm().getEllipseDimension().height/2,
                 link.getDestinationTerm().getLocation().x + link.getDestinationTerm().getEllipseDimension().width/2,
                 link.getDestinationTerm().getLocation().y + link.getDestinationTerm().getEllipseDimension().height/2
        );

    }

    @Override
    public boolean isContained(Point p) {
        return false;
    }
}
