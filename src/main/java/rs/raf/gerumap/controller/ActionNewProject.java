package rs.raf.gerumap.controller;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.model.repository.implementation.ProjectExplorer;
import rs.raf.gerumap.observer.NotificationType;

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
        ProjectExplorer projectExplorer = ApplicationFramework.getInstance().getIMapRepository().getProjectExplorer();
        String name = "Project" + (projectExplorer.getChildren().size() + 1);
        Project project = new Project(name, projectExplorer);
        projectExplorer.addChild(project);
        projectExplorer.notifySubscribers(project, NotificationType.ADD);
    }
}
