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

@Getter
@Setter
@AllArgsConstructor
public class MindMap extends MapNodeComposite {
    private boolean isTemplate;

    public MindMap(String name, MapNode parent) {
        super(name, parent);
    }

    @Override
    public void addChild(final MapNode child) {
        if (child instanceof Element) {
            getChildren().add(child);
            //TO DO notify subscribers
        }
    }

    @Override
    public void deleteChild(final MapNode child) {
        if (child instanceof Element) {
            getChildren().remove(child);
            notifySubscribers(child, NotificationType.DELETE);
        }
    }

}
