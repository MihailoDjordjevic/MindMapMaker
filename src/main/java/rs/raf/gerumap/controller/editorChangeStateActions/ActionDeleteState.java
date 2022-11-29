package rs.raf.gerumap.controller.editorChangeStateActions;

import rs.raf.gerumap.mindMapEditor.editorState.IState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionDeleteState extends AbstractAction {

    public ActionDeleteState() {
        super("deleteIcon.png");
        putValue(NAME, "Delete elements");
        putValue(SHORT_DESCRIPTION, "Delete elements from mind map");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'D');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
