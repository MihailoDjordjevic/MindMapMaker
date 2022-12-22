package rs.raf.gerumap.controller.globalActions;

import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.core.ApplicationFramework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionUndo extends AbstractMapAction {

    public ActionUndo() {
        super("undo.png");
        putValue(NAME, "Undo");
        putValue(SHORT_DESCRIPTION, "Undo");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ApplicationFramework.getInstance().getCommandManager().undoCommand();
    }

}
