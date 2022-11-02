package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;

public class ProjectExplorerTreeItem extends MapTreeItem implements ISubscriber {

    public ProjectExplorerTreeItem(MapNode nodeModel) {
        super(nodeModel);
        nodeModel.addSubscriber(this);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case ADD: {
                ProjectTreeItem projectTreeItem = new ProjectTreeItem((MapNode) notification);
                add(projectTreeItem);
                SwingUtilities.updateComponentTreeUI(((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame());
            } break;
            case DELETE: {

            } break;
        }
    }
}
