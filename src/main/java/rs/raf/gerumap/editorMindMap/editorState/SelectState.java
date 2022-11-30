package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements IState{

    @Override
    public void mouseClickAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(mouseEvent.getPoint());

        if (elementPainter != null)
            mindMapView.getSelectionModel().setSingleSelectionElement(elementPainter);
        else mindMapView.getSelectionModel().setSingleSelectionElement(null);

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mouseDraggedAction(Object event) {

    }

    @Override
    public void mousePressedAction(Object event) {

    }

    @Override
    public void mouseReleasedAction(Object event) {

    }

    @Override
    public void mouseEnteredAction(Object event) {

    }

    @Override
    public void mouseExitedAction(Object event) {

    }

    @Override
    public void mouseMovedAction(Object event) {

    }
}
