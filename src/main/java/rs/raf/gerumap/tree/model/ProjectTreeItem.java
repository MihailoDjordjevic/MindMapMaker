package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;

public class ProjectTreeItem extends MapTreeItem {
    public ProjectTreeItem(MapNode nodeModel) {
        super(nodeModel);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case ADD: {
                MindMapTreeItem mindMapTreeItem = new MindMapTreeItem((MapNode) notification);
                add(mindMapTreeItem);
                SwingUtilities.updateComponentTreeUI(((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame());
            } break;
            case DELETE: {

            } break;
        }
    }
}
