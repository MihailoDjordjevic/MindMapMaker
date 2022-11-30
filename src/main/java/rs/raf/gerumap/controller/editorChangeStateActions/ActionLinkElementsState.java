package rs.raf.gerumap.controller.editorChangeStateActions;

import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionLinkElementsState extends AbstractMapAction {

    public ActionLinkElementsState() {
        super("linkElementsStateIcon.png");
        putValue(NAME, "Link terms");
        putValue(SHORT_DESCRIPTION, "Click to link terms");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'L');
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCurrentProjectView().getStateManager().setLinkElementsState();
    }
}
