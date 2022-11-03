package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
public class ProjectView extends JTabbedPane implements ISubscriber {

    private Project project;

    public ProjectView(Project project) {
        this.project = project;
        setPreferredSize(new Dimension(800, 700));
        setBorder(BorderFactory.createTitledBorder(project.getAuthor() + " - " + project.getName()));

        initAllTabs();

        project.addSubscriber(this);
    }

    private void initAllTabs(){

        for (MapNode mindMap : project.getChildren()){
            addTab(mindMap.toString(), new MindMapView((MindMap) mindMap));
        }

    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case ADD -> {
                MindMapView mindMapView = new MindMapView((MindMap) notification);
                addTab(((MindMap) notification).getName(), mindMapView);
                setSelectedComponent(mindMapView);

                SwingUtilities.updateComponentTreeUI(this);
            }case DELETE -> {
                removeTab(notification);
                SwingUtilities.updateComponentTreeUI(this);
            }
        }
    }

    private void removeTab(Object o){
        for (Component tab : getComponents()){
            if (((MindMapView) tab).getMindMap() == ((MindMap) o)) {
                remove(tab);
                break;
            }
        }
    }
}
