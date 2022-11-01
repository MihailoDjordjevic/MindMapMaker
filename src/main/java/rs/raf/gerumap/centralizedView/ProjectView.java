package rs.raf.gerumap.centralizedView;

import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.observer.ISubscriber;

import javax.swing.*;

public class ProjectView extends JTabbedPane implements ISubscriber {

    private Project project;

    @Override
    public void update(Object notification) {

    }
}
