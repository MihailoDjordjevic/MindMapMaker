package rs.raf.gerumap.controller.globalActions;

import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionRedo extends AbstractMapAction {

    public ActionRedo() {
        super("/rs/raf/gerumap/tree/view/elementIcon.png");
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
