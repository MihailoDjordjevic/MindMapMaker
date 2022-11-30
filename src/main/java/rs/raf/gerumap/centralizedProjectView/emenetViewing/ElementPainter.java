package rs.raf.gerumap.centralizedProjectView.emenetViewing;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.IPainter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter implements IPainter {

    private Shape shape;
    private Element model;

    public ElementPainter(Element model) {
        this.model = model;
    }
}
