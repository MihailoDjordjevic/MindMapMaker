package rs.raf.gerumap.model.repository.implementation;

import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

public class Term extends Element{

    private int thickness;
    private Color color;
    private Point location;

    public Term(String name, MapNode parent) {
        super(name, parent);

        thickness = 1;
        color = Color.BLACK;
        location = new Point(40, 40);   //default values
    }

}
