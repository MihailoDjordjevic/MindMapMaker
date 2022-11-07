package rs.raf.gerumap.model.repository.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class MapNode implements IPublisher {
    private String name;
    private MapNode parent;
    private List<ISubscriber> subscribers;

    public MapNode(String name, MapNode parent) {
        this.name = name;
        this.parent = parent;
        subscribers = new ArrayList<>(7);
    }

//    @Override
//    public boolean equals(final Object obj) {
//
//        if (obj != null && obj instanceof MapNode) {
//            MapNode otherObj = (MapNode) obj;
//            return this.getName().equals(otherObj.getName());
//        }
//        return false;
//    }
    @Override
    public String toString() {
        return name;
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        this.getSubscribers().add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        this.getSubscribers().remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification, NotificationType notificationType) {
        for (ISubscriber subscriber : subscribers)
            subscriber.update(notification, notificationType);
    }
}