package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.mindMapCursorFactory.MindMapCursorFactory;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.editorMindMap.StateManager;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

@Getter
@Setter
public class ProjectView extends JTabbedPane implements ISubscriber {

    private Project project;
    private StateManager stateManager;

    public ProjectView(Project project) {

        this.project = project;
        setPreferredSize(new Dimension(800, 700));
        setBorder(BorderFactory.createTitledBorder(project.getAuthor() + " - " + project.getName()));
        stateManager = new StateManager(this);

        initAllTabs();

        project.addSubscriber(this);

    }

    private void initAllTabs(){

        for (MapNode mindMap : project.getChildren()){
            MindMapView mindMapView = new MindMapView((MindMap) mindMap);

            JScrollPane jScrollPane = new JScrollPane(mindMapView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            jScrollPane.setPreferredSize(new Dimension(800, 700));
            jScrollPane.setSize(new Dimension(1000, 1000));

            mindMapView.setParentPane(jScrollPane);

            addTab(mindMap.toString(), jScrollPane);
        }
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType){

            case ADD -> {

                MindMapView mindMapView = new MindMapView((MindMap) notification);
//                addTab(((MindMap) notification).getName(), mindMapView);
//                setSelectedComponent(mindMapView);

                JScrollPane jScrollPane = new JScrollPane(mindMapView, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                jScrollPane.setPreferredSize(new Dimension(800, 700));
                jScrollPane.setSize(new Dimension(1000, 1000));

                mindMapView.setParentPane(jScrollPane);

                addTab(notification.toString(), jScrollPane);
                setSelectedComponent(jScrollPane);

            }
            case DELETE -> removeTab(notification);

            case DELETE_PROJECT -> MainFrame.getInstance().removeDisplayedProject();

            case NAME_CHANGE -> ((TitledBorder) getBorder()).setTitle(project.getAuthor() + " - " + notification);

            case AUTHOR_CHANGE -> ((TitledBorder) getBorder()).setTitle(project.getAuthor() + " - " + project.getName());
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspacePanel());
    }

    private void removeTab(Object o){
        for (Component tab : getComponents()){
            if (((MindMapView) ((JScrollPane) tab).getViewport().getView()).getMindMap() == o) {
                remove(tab);
                break;
            }
        }
    }

    public void setCursorForProject(Cursor cursor){
        for (int i = 0; i < getTabCount(); i++){
            ((JScrollPane) getComponentAt(i)).getViewport().getView().setCursor(cursor);
        }
    }

}
