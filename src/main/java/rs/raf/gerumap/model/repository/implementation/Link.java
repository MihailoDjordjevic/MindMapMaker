package rs.raf.gerumap.model.repository.implementation;

import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

public class Link extends Element{

    private Color color;

    private Term sourceTerm;
    private Term destinationTerm;

    public Link(String name, MapNode parent) {
        super(name, parent);

        color = Color.BLACK;
    }

}
