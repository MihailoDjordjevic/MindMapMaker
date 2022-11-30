package rs.raf.gerumap.editorMindMap.editorState;


import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.model.repository.implementation.MindMap;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.util.Objects;

public class LinkElementsState implements IState{
    @Override
    public void mouseClickAction(Object event) {

    }

    @Override
    public void mouseDraggedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(mouseEvent.getPoint());

        if(mindMapView.getSelectionModel().getSingleSelectionElement() != null && mindMapView.getSelectionModel().getSingleSelectionElement() != elementPainter){
            mindMapView.getSelectionModel().setSecondarySelectionElement(elementPainter);
        }

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mousePressedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(mouseEvent.getPoint());
        mindMapView.getSelectionModel().setSingleSelectionElement(elementPainter);

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mouseReleasedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        mindMapView.getSelectionModel().setSingleSelectionElement(null);
        mindMapView.getSelectionModel().setSecondarySelectionElement(null);


        SwingUtilities.updateComponentTreeUI(mindMapView);
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


