package rs.raf.gerumap.tree.model.abstraction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;

import javax.swing.tree.DefaultMutableTreeNode;
@Getter
@Setter
@NoArgsConstructor
public abstract class MapTreeItem extends DefaultMutableTreeNode implements ISubscriber {
    private MapNode model;
    public MapTreeItem(MapNode nodeModel){
        this.model = nodeModel;
        nodeModel.addSubscriber(this);
    }
    @Override
    public String toString() {
        return model.getName();
    }

    public void setName(String name) {
        this.model.setName(name);
    }
}
