package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;

public class ElementTreeItem extends MapTreeItem {

    public ElementTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType) {
           // case NAME_CHANGE -> SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());
    }
}
