package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.MessageDescription;
import rs.raf.gerumap.globalView.frame.BasicDialog;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.popUpPanes.RenameUpdateOnInputPopUpPane;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class ActionSetAuthor extends AbstractMapAction {

    public ActionSetAuthor() {
        super("setAuthorIcon.png");
        putValue(NAME, "Set author");
        putValue(SHORT_DESCRIPTION, "Set author fot selected node");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
    }

    public void actionPerformed(ActionEvent e) {

        RenameUpdateOnInputPopUpPane renameUpdateOnInputPopUpPane = new RenameUpdateOnInputPopUpPane(MainFrame.getInstance(), "Rename", true, 200, 200, NotificationType.AUTHOR_CHANGE);

        MapTreeItem mapTreeItem = ((MapTreeItem) MainFrame.getInstance().getMapTreeView().getLastSelectedPathComponent());

        if (mapTreeItem == null || !(mapTreeItem.getModel() instanceof Project)){
            ApplicationFramework.getInstance().getMessageGeneratorImplementation().generateMessage(MessageDescription.CANNOT_CHANGE_AUTHOR, null);
            return;
        }

        String name = ((Project) mapTreeItem.getModel()).getAuthor();
        renameUpdateOnInputPopUpPane.setOriginalName(name);

        renameUpdateOnInputPopUpPane.getTextField().setText(name);
        renameUpdateOnInputPopUpPane.getTextField().setEditable(true);

        renameUpdateOnInputPopUpPane.setVisible(true);
    }

}
