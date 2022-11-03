package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
@Getter
@Setter
public class ProjectView extends JTabbedPane implements ISubscriber {

    private Project project;

    public ProjectView(Project project) {
        this.project = project;
        project.addSubscriber(this);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

    }
}
