package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;

    public MindMapView(MindMap mindMap) {
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);
        setBackground(mindMap.getBackgroundColor());
        setPreferredSize(new Dimension(800, 700));
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case NAME_CHANGE -> {
                ProjectView projectView = ((ProjectView) this.getParent());
                projectView.setTitleAt(projectView.indexOfComponent(this), mindMap.getName());
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspacePanel());
    }
}