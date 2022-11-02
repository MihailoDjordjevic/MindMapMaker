package rs.raf.gerumap.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNewMindMap extends AbstractMapAction{

    public ActionNewMindMap() {
        super("newMindMap.png");
        putValue(NAME, "New Mind Map");
        putValue(SHORT_DESCRIPTION, "Create new mind map");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
