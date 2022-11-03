package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNewMindMap extends AbstractMapAction {

    public ActionNewMindMap() {
        super("newMindMap.png");
        putValue(NAME, "New Mind Map");
        putValue(SHORT_DESCRIPTION, "Create new mind map");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        MapTreeView mapTreeView = ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView();
        MapTreeItem projectTreeItem = ((MapTreeItem) mapTreeView.getLastSelectedPathComponent());

        String name = "Mind Map" + (projectTreeItem.getChildCount() + 1);
        MindMap mindMap = new MindMap(name, projectTreeItem.getModel());

        ((MapNodeComposite) projectTreeItem.getModel()).addChild(mindMap);

        ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView().expandSelectedNode();
    }
}
