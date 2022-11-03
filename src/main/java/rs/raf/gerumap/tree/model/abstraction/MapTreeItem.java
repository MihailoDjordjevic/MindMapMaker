package rs.raf.gerumap.tree.model.abstraction;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;
import java.util.Objects;

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

    protected void deleteItem(Object notification){    //An item can be deleted only if memory address of its model matches the address of forwarded model
        for (TreeNode mapTreeItem : children){              //notification is of type Map Node
            if (((MapTreeItem) mapTreeItem).getModel() == notification) {
                ((MapTreeItem) mapTreeItem.getParent()).remove((MutableTreeNode) mapTreeItem);
                break;
            }
        }
    }
}
