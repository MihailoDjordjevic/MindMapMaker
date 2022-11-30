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
    private Dimension ellipseDimension;
    private int fontSize;

    public Term(String name, MapNode parent) {
        super(name, parent);

        location = new Point(40, 40);   //default values
        fontSize = 14;
        dimension = new Dimension((int) (fontSize*getName().length()*0.5), (int) (fontSize *1.5));

        ellipseDimension = new Dimension((int) (dimension.width*1.33), (int) (dimension.height*1.33));
    }

    private void initValuesForDrawing(){
        dimension = new Dimension((int) (fontSize*getName().length()*0.5), (int) (fontSize *1.5));

        ellipseDimension = new Dimension((int) (dimension.width*1.33), (int) (dimension.height*1.33));
    }

    @Override
    public void setName(String name) {
       // initValuesForDrawing();
        super.setName(name);
    }
}
