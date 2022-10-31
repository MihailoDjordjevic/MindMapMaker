package rs.raf.gerumap.tree.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;
@Getter
@Setter
@NoArgsConstructor
public class MapTreeItem extends DefaultMutableTreeNode {
    private MapNode mapNode;
    public MapTreeItem(MapNode nodeModel){
        this.mapNode = nodeModel;
    }
    @Override
    public String toString() {
        return mapNode.getName();
    }

    public void setName(String name) {
        this.mapNode.setName(name);
    }
}
