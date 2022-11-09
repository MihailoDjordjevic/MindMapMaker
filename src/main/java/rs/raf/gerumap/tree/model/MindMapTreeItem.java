package rs.raf.gerumap.tree.model;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;

@Getter
@Setter
public class MindMapTreeItem extends MapTreeItem {

    public MindMapTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType) {
            case ADD -> {
                ElementTreeItem elementTreeItem = new ElementTreeItem((MapNode) notification);
                add(elementTreeItem);
            }
            case DELETE -> deleteItem(notification);
            case NAME_CHANGE -> setName((String) notification);
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());

    }
}
