package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

public class ElementTreeItem extends MapTreeItem {

    public ElementTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

    }
}
