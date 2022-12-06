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

public class ActionZoomIn extends AbstractMapAction {

    public ActionZoomIn() {
        super("zoomInIcon.png");
        putValue(NAME, "Zoom in");
        putValue(SHORT_DESCRIPTION, "Zoom in this mind map");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_PLUS, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProjectView projectView = MainFrame.getInstance().getCurrentProjectView();

        MindMapView mindMapView = (MindMapView) ((JScrollPane) projectView.getSelectedComponent()).getViewport().getView();
        MindMap mindMap = mindMapView.getMindMap();

        mindMap.setZoom(1.25F);

        mindMap.notifySubscribers(null, NotificationType.ZOOM);
    }
}
