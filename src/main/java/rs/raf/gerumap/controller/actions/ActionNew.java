package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.factory.MapNodeFactory;
import rs.raf.gerumap.model.repository.factory.MapNodeFactoryManager;
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

        MapNodeFactory mapNodeFactory = MapNodeFactoryManager.getMapNodeFactory(mapTreeItem.getModel());
        mapNodeFactory.getMapNode((MapNodeComposite) mapTreeItem.getModel());

        ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView().expandSelectedNode();

    }
}