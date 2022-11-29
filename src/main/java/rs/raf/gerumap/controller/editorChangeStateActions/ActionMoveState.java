package rs.raf.gerumap.controller.editorChangeStateActions;

import rs.raf.gerumap.mindMapEditor.editorState.IState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionMoveState extends AbstractAction {

    public ActionMoveState() {
        super("deleteIcon.png");
        putValue(NAME, "Move terms");
        putValue(SHORT_DESCRIPTION, "Click to move terms");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'M');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
