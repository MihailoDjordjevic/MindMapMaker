package rs.raf.gerumap.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionNewProject extends AbstractMapAction{

    public ActionNewProject() {
        super("newProject.png");
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "Create new project");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
