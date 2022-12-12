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
        fontSize = 20;
        dimension = new Dimension((int) (fontSize*getName().length()*0.5), (int) (fontSize *1.8));

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
        if (child instanceof Link) {

            Link link = ((Link) child);

            link.getSourceTerm().getChildren().remove(link);
            link.getSourceTerm().notifySubscribers(link, NotificationType.DELETE);

            link.getDestinationTerm().getChildren().remove(link);
            link.getDestinationTerm().notifySubscribers(link, NotificationType.DELETE);

        }
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }
    /*public Point getLocation(){
        return new Point((int) (this.location.x * ((MindMap)getParent()).getSavedZoom()), (int) (this.location.y * ((MindMap)getParent()).getSavedZoom()));
    }
    public Dimension getDimension(){
        return new Dimension((int) (this.dimension.width * ((MindMap)getParent()).getSavedZoom()), (int) (this.dimension.height * ((MindMap)getParent()).getSavedZoom()));
    }
    public Dimension getEllipseDimension(){
        return new Dimension((int) (this.ellipseDimension.width * ((MindMap)getParent()).getSavedZoom()), (int) (this.ellipseDimension.height * ((MindMap)getParent()).getSavedZoom()));
    }*/

    public void setLocation(Point location){

        if (location.getLocation().x < 2){
            location.setLocation(2, location.getLocation().y);
        }
        if (location.getLocation().x > 3000 - getEllipseDimension().width){
            location.setLocation(3000 - getEllipseDimension().width, location.getLocation().y);
        }
        if (location.getLocation().y < 2){
            location.setLocation(location.getLocation().x, 2);
        }
        if (location.getLocation().y > 2000 - getEllipseDimension().height){
            location.setLocation( location.getLocation().x, 2000 - getEllipseDimension().height);
        }

        this.location = location;
    }
}
