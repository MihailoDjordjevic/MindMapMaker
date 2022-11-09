package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;

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
            notifySubscribers(child, NotificationType.ADD);
        }
    }

    @Override
    public void deleteChild(MapNode child) {
        if (child instanceof Project) {
            getChildren().remove(child);
            child.notifySubscribers(child, NotificationType.DELETE_PROJECT); //to delete project from centralized view
            notifySubscribers(child, NotificationType.DELETE);
        }
    }
}
