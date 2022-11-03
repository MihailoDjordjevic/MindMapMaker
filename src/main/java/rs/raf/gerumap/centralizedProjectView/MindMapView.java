package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;

    public MindMapView(MindMap mindMap) {
        this.mindMap = mindMap;
        mindMap.addSubscriber(this);

        Random r = new Random();
        setBackground(new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        setPreferredSize(new Dimension(600, 600));
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

    }
}
