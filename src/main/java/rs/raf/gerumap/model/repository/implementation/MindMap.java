package rs.raf.gerumap.model.repository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MindMap extends MapNodeComposite implements IPublisher {
    private boolean isTemplate;
    @Override
    public void addChild(final MapNode child) {

    }

    @Override
    public void deleteChild(final MapNode child) {

    }

    @Override
    public void addSubscriber(ISubscriber sub) {

    }

    @Override
    public void removeSubscriber(ISubscriber sub) {

    }

    @Override
    public void notifySubscribers(Object notification) {

    }
}
