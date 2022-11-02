package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

public class ProjectExplorerTreeItem extends MapTreeItem implements ISubscriber {

    public ProjectExplorerTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification) {

    }
}
