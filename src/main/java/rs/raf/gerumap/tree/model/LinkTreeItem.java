package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;

public class LinkTreeItem extends ElementTreeItem{

    public LinkTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {


        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getMapTreeView());
    }
}
