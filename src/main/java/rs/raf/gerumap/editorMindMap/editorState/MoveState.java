package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.LinkPainter;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState implements IState{

    @Override
    public void mouseClickAction(Object event) {

    }

    @Override
    public void mouseDraggedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        if (mindMapView.getSelectionModel().getSingleSelectionElement() != null && !(mindMapView.getSelectionModel().getSingleSelectionElement() instanceof LinkPainter)){

            Term term = ((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel());

            term.setLocation(new Point(
                    mouseEvent.getPoint().x - term.getEllipseDimension().width/2,
                    mouseEvent.getPoint().y - term.getEllipseDimension().height/2
                    ));
        }

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mousePressedAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(mouseEvent.getPoint());
        mindMapView.getSelectionModel().setSingleSelectionElement(elementPainter);
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
