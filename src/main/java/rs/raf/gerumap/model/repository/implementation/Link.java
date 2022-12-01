package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public class Link extends MapNode{

    private int thickness;
    private Color borderColor;

    private Term sourceTerm;
    private Term destinationTerm;

    public Link(String name, MapNode parent) {
        super(name, parent);

        thickness = 3;
        borderColor = Color.BLACK;

        setName("with");
    }

    @Override
    public String toString() {
        return sourceTerm + " " + getName() + " " + destinationTerm;
    }
}
