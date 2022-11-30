package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;

import java.awt.*;

@Getter
@Setter
public class Element extends MapNode {

    private int thickness;
    private Color borderColor;
    private Color backgroundColor;
    private Color textColor;

    public Element(String name, MapNode parent) {
        super(name, parent);

        thickness = 3;
        borderColor = Color.BLACK;
        backgroundColor = Color.LIGHT_GRAY;
        textColor = Color.BLACK;
    }

}
