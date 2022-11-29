package rs.raf.gerumap.controller.editorChangeStateActions;

import rs.raf.gerumap.mindMapEditor.editorState.IState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionSelectState extends AbstractAction {


    public ActionSelectState() {
        super("deleteIcon.png");
        putValue(NAME, "Select elements");
        putValue(SHORT_DESCRIPTION, "Click to select elements");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'S');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
