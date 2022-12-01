package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.observer.NotificationType;

import java.awt.*;
import java.util.Random;

@Getter
@Setter
public class Term extends MapNodeComposite {

    private Point location;
    private Dimension dimension;
    private Dimension ellipseDimension;
    private int fontSize;
    private int thickness;

    private Color borderColor;
    private Color backgroundColor;
    private Color textColor;

    public Term(String name, MapNode parent) {
        super(name, parent);

        location = randomPoint();   //default values
        fontSize = 14;
        dimension = new Dimension((int) (fontSize*getName().length()*0.5), (int) (fontSize *1.5));

        ellipseDimension = new Dimension((int) (dimension.width*1.33), (int) (dimension.height*1.33));

        backgroundColor = Color.LIGHT_GRAY;
        textColor = Color.BLACK;
        thickness = 3;
        borderColor = Color.BLACK;
    }

    private Point randomPoint(){

        int x = new Random().nextInt(MainFrame.getInstance().getWorkspacePanel().getComponent(0).getWidth());
        int y = new Random().nextInt(MainFrame.getInstance().getWorkspacePanel().getComponent(0).getHeight());

        return new Point(x, y);
    }
    @Override
    public void addChild(MapNode child) {
        if (child instanceof Link) {
            getChildren().add(child);
            notifySubscribers(child, NotificationType.ADD);
        }
    }

    @Override
    public void deleteChild(MapNode child) {

    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
}
