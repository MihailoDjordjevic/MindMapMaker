package rs.raf.gerumap.centralizedProjectView.elementViewing;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.implementation.Element;

import java.awt.*;

@Getter
@Setter
public abstract class ElementPainter implements IPainter {

    private Shape shape;
    private Element model;
    private boolean isSelected;

    public ElementPainter(Element model) {
        this.model = model;
    }
}
