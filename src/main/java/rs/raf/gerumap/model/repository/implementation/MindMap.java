package rs.raf.gerumap.model.repository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import java.awt.*;
import java.util.Random;

@Getter
@Setter
@AllArgsConstructor
public class MindMap extends MapNodeComposite {

    private boolean isTemplate;
    private Color backgroundColor;

    private double zoom;
    private double savedZoom;
    private int zoomInCount = 0;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        backgroundColor = null;
        zoom = 1;
        savedZoom = 1;
    }

    @Override
    public void addChild(final MapNode child) {
        if (child instanceof Term) {
            getChildren().add(child);
            notifySubscribers(child, NotificationType.ADD);
        }
    }

    @Override
    public void deleteChild(final MapNode child) {

        if (child instanceof Term) {
            getChildren().remove(child);

            Term term = ((Term) child);

            while (!term.getChildren().isEmpty()){    //to prevent concurrent modification no iteration through list is possible so this is a solution
                term.deleteChild(term.getChildren().get(0));
            }

            notifySubscribers(child, NotificationType.DELETE);   //remove elementPainter
        }
    }

    public Color getBackgroundColor() {
        Random r = new Random();
        if (backgroundColor == null)
            setBackgroundColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        return backgroundColor;
    }
}
