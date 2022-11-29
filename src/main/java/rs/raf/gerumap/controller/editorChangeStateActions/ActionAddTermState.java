package rs.raf.gerumap.controller.editorChangeStateActions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionAddTermState extends AbstractAction {


    public ActionAddTermState() {
        super("addStateIcon.png");
        putValue(NAME, "Add Term");
        putValue(SHORT_DESCRIPTION, "Click to add new terms");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'A');
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
