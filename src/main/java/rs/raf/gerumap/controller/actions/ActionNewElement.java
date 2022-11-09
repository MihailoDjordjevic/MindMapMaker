package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.MessageDescription;
import rs.raf.gerumap.globalView.gui.SwingGui;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.factory.MapNodeFactory;
import rs.raf.gerumap.model.repository.factory.MapNodeFactoryManager;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNewElement extends AbstractMapAction {
    public ActionNewElement() {
        super("/rs/raf/gerumap/tree/view/elementIcon.png");
        putValue(NAME, "New Element");
        putValue(SHORT_DESCRIPTION, "Create new element");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MapTreeView mapTreeView = ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView();
        MapTreeItem mindMapTreeItem = ((MapTreeItem) mapTreeView.getLastSelectedPathComponent());

        if (mindMapTreeItem == null){
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generateMessage(MessageDescription.NO_NODE_SELECTED, null);
            return;
        } else if (!(mindMapTreeItem.getModel() instanceof MindMap)){
            String[] str = new String[]{"Element", mindMapTreeItem.getModel().toString(), "MindMap"};
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generateMessage(MessageDescription.WRONG_NODE_SELECTED, str);
            return;
        }

        MapNodeFactory mapNodeFactory = MapNodeFactoryManager.getMapNodeFactory(mindMapTreeItem.getModel());
        mapNodeFactory.getMapNode((MapNodeComposite) mindMapTreeItem.getModel());

        ((SwingGui) ApplicationFramework.getInstance().getGui()).getMainFrame().getMapTreeView().expandSelectedNode();
    }
}
