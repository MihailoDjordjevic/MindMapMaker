package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public class Term extends Element{

    private Point location;
    private Dimension dimension;
    private int fontSize;

    public Term(String name, MapNode parent) {
        super(name, parent);

        location = new Point(40, 40);   //default values
        fontSize = 14;
        dimension = new Dimension(fontSize*getName().length(), (int) (fontSize *1.5));
    }

}
