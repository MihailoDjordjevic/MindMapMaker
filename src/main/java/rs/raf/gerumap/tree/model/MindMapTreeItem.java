package rs.raf.gerumap.tree.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
@Getter
@Setter
public class MindMapTreeItem extends MapTreeItem {

    public MindMapTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }
}
