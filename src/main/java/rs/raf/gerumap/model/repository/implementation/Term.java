package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Term extends Element{

    private Point location;
    private Dimension dimension;
    private Dimension ellipseDimension;
    private int fontSize;

    private Color backgroundColor;
    private Color textColor;

    private List<Link> links;
    public Term(String name, MapNode parent) {
        super(name, parent);

        links = new ArrayList<>();

        location = new Point(40, 40);   //default values
        fontSize = 14;
        dimension = new Dimension((int) (fontSize*getName().length()*0.5), (int) (fontSize *1.5));

        ellipseDimension = new Dimension((int) (dimension.width*1.33), (int) (dimension.height*1.33));

        backgroundColor = Color.LIGHT_GRAY;
        textColor = Color.BLACK;
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
