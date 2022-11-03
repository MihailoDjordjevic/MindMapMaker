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

    public MindMap(String name, MapNode parent) {
        super(name, parent);
        backgroundColor = null;
    }

    @Override
    public void addChild(final MapNode child) {
        if (child instanceof Element) {
            getChildren().add(child);
            notifySubscribers(child, NotificationType.ADD);
        }
    }

    @Override
    public void deleteChild(final MapNode child) {
        if (child instanceof Element) {
            getChildren().remove(child);
            notifySubscribers(child, NotificationType.DELETE);
        }
    }

    public Color getBackgroundColor() {
        Random r = new Random();
        if (backgroundColor == null)
            setBackgroundColor(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        return backgroundColor;
    }
}
