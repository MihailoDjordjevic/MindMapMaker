package rs.raf.gerumap.controller.globalActions;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.ProjectView;
import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class ActionZoomOut extends AbstractMapAction {

    public ActionZoomOut() {
        super("zoomOutIcon.png");
        putValue(NAME, "Zoom out");
        putValue(SHORT_DESCRIPTION, "Zoom out this mind map");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = MainFrame.getInstance().getCurrentProjectView();

        MindMapView mindMapView = (MindMapView) ((JScrollPane) projectView.getSelectedComponent()).getViewport().getView();
        MindMap mindMap = mindMapView.getMindMap();

        mindMap.setZoom((float) 0.80);

        System.out.println(mindMap.getZoom());

        mindMap.notifySubscribers(null, NotificationType.ZOOM);
    }
}
