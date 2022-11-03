package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.tree.model.ProjectExplorerTreeItem;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionDelete extends AbstractMapAction {

    public ActionDelete() {
        super("deleteIcon.png");
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete selected item");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'D');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeView mapTreeView = ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView();
        MapTreeItem mapTreeItem = ((MapTreeItem) mapTreeView.getLastSelectedPathComponent());

        if (mapTreeItem != null && !(mapTreeItem instanceof ProjectExplorerTreeItem)) {
            MapNode mapNode = mapTreeItem.getModel();
            MapNodeComposite mapNodeComposite = ((MapNodeComposite) mapNode.getParent());  //Map Node that is to be deleted must have a parent so its safe to cast
            mapNodeComposite.deleteChild(mapNode);
        }
    }
}
