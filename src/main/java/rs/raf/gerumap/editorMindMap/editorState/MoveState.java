package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.LinkPainter;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.TermPainter;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.centralizedProjectView.selectionModel.SelectionModel;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import javax.swing.text.Element;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MoveState implements IState{
    private Point startMovePoint;
    private Point endMovePoint;
    private int newX;
    private int newY;
    @Override
    public void mouseClickAction(Object event) {

    }

    @Override
    public void mouseDraggedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        endMovePoint = mouseEvent.getPoint();
        newX = endMovePoint.x - startMovePoint.x;
        newY = endMovePoint.y - startMovePoint.y;

        if (mindMapView.getSelectionModel().getSingleSelectionElement() != null && !(mindMapView.getSelectionModel().getSingleSelectionElement() instanceof LinkPainter)){

            Term term = ((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel());

            term.setLocation(new Point(
                    mouseEvent.getPoint().x - term.getEllipseDimension().width/2,
                    mouseEvent.getPoint().y - term.getEllipseDimension().height/2
                    ));
        }
        if (!mindMapView.getSelectionModel().getMultipleSelectionElements().isEmpty()){
            for(ElementPainter elementPainter : mindMapView.getSelectionModel().getMultipleSelectionElements()){
                if(elementPainter instanceof TermPainter){
                    Term term = (Term)(elementPainter.getModel());
                    term.setLocation(new Point(term.getLocation().x + newX, term.getLocation().y + newY));
                }
            }
        }
        startMovePoint = endMovePoint;
        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mousePressedAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        startMovePoint = mouseEvent.getPoint();

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
