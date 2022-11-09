package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.MapTree;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
import rs.raf.gerumap.tree.model.treeNodeFactory.SimpleTreeNodeFactory;

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
                add(SimpleTreeNodeFactory.getNode((MapNode) notification));
            }
            case DELETE -> deleteItem(notification);
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());
    }
}
