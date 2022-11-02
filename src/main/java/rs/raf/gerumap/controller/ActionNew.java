package rs.raf.gerumap.controller;

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
    }
}
