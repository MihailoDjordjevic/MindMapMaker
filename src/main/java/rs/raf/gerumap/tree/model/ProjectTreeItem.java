package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeNode;

public class ProjectTreeItem extends MapTreeItem {
    public ProjectTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType) {
            case ADD -> {
                MindMapTreeItem mindMapTreeItem = new MindMapTreeItem((MapNode) notification);
                add(mindMapTreeItem);
            }
            case DELETE -> {
                deleteItem(notification);
            }
        }

        SwingUtilities.updateComponentTreeUI(((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame());
    }
}
