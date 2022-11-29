package rs.raf.gerumap.controller.editorChangeStateActions;

import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.mindMapEditor.editorState.IState;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionSelectState extends AbstractMapAction {


    public ActionSelectState() {
        super("selectStateIcon.png");
        putValue(NAME, "Select elements");
        putValue(SHORT_DESCRIPTION, "Click to select elements");

        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        putValue(MNEMONIC_KEY, (int) 'S');
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getCurrentProjectView().getStateManager().setSelectState();
    }
}
