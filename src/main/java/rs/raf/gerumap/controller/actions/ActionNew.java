package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.errorHandling.MessageGenerator;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.MessageDescription;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.factory.MapNodeFactory;
import rs.raf.gerumap.model.repository.factory.MapNodeFactoryManager;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.model.repository.implementation.ProjectExplorer;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNew extends AbstractMapAction{

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

        if (mapTreeItem == null) {
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generateMessage(MessageDescription.NO_NODE_SELECTED, null);
            return;
        }
        if (mapTreeItem.getModel() instanceof ProjectExplorer) {
            String author = JOptionPane.showInputDialog("Please enter the name of the author");

            if (author != null) {
                MapNodeFactory mapNodeFactory = MapNodeFactoryManager.getMapNodeFactory(mapTreeItem.getModel());
                ((Project) mapNodeFactory.getMapNode((MapNodeComposite) mapTreeItem.getModel())).setAuthor(author);
            }
        } else {
            MapNodeFactory mapNodeFactory = MapNodeFactoryManager.getMapNodeFactory(mapTreeItem.getModel());
            mapNodeFactory.getMapNode((MapNodeComposite) mapTreeItem.getModel());
        }

        ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView().expandSelectedNode();

    }
}