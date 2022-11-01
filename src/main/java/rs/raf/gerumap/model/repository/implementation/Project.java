package rs.raf.gerumap.model.repository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;

import java.nio.file.Path;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends MapNodeComposite implements IPublisher {
    private String name;
    private String author;
    private Path resourcesPath;
    @Override
    public void addChild(final MapNode child) {

    }
    @Override
    public void deleteChild(final MapNode child) {

    }
    public Project(String name, MapNode parent){
        super(name, parent);
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
