package rs.raf.gerumap.tree.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import javax.swing.tree.DefaultMutableTreeNode;
@Getter
@Setter
@NoArgsConstructor
public class MapTreeItem extends DefaultMutableTreeNode {
    private MapNode model;
    public MapTreeItem(MapNode nodeModel){
        this.model = nodeModel;
    }
    @Override
    public String toString() {
        return model.getName();
    }

    public void setName(String name) {
        this.model.setName(name);
    }
}
