package rs.raf.gerumap.centralizedProjectView;

import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.ISubscriber;

import javax.swing.*;

public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;

    @Override
    public void update(Object notification) {

    }
}
