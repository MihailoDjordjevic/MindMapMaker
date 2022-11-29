package rs.raf.gerumap.centralizedProjectView.emenetViewing;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.IPainter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter implements IPainter {

    private Shape shape;
    private MapNode model;

    public ElementPainter(MapNode model) {
        this.model = model;
    }
}
