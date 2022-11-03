package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.tree.model.MindMapTreeItem;
import rs.raf.gerumap.tree.model.ProjectExplorerTreeItem;
import rs.raf.gerumap.tree.model.ProjectTreeItem;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNew extends AbstractMapAction {

    public ActionNew() {
        super("newIcon.png");
        putValue(NAME, "New");
        putValue(SHORT_DESCRIPTION, "Create new item");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'N');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeItem mapTreeItem = ((MapTreeItem) MainFrame.getInstance().getMapTreeView().getLastSelectedPathComponent());

        if (mapTreeItem == null || mapTreeItem instanceof ProjectExplorerTreeItem)
            MainFrame.getInstance().getMenu().getNewProject().doClick();
        else if (mapTreeItem instanceof ProjectTreeItem)
            MainFrame.getInstance().getMenu().getNewMindMap().doClick();
        else if (mapTreeItem instanceof MindMapTreeItem)
            MainFrame.getInstance().getMenu().getNewElement().doClick();

    }
}
