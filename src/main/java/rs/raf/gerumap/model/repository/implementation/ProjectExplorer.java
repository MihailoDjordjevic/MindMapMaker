package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.IPublisher;
import rs.raf.gerumap.observer.ISubscriber;

@Getter
@Setter
public class ProjectExplorer extends MapNodeComposite {

    public ProjectExplorer(String name){
        super(name, null);
    }
    @Override
    public void addChild(MapNode child) {
        if (child instanceof Project) {
            getChildren().add(child);
            //TO DO notify subscribers
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Project) {
            getChildren().remove(child);
            //TO DO notify subscribers
        }
    }
}
