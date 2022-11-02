package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.MapTree;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class ProjectExplorerTreeItem extends MapTreeItem {

    public ProjectExplorerTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType) {
            case ADD -> {
                ProjectTreeItem projectTreeItem = new ProjectTreeItem((MapNode) notification);
                add(projectTreeItem);
            }
            case DELETE -> {
                deleteItem(notification);
            }
        }

        SwingUtilities.updateComponentTreeUI(((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame());
    }
}
