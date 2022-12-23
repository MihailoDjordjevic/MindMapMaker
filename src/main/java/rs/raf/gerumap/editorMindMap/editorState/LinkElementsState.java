package rs.raf.gerumap.editorMindMap.editorState;


import rs.raf.gerumap.centralizedProjectView.LinkPainter;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.commandManagement.AddLinkCommand;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;

public class LinkElementsState implements IState{
    @Override
    public void mouseClickAction(Object event) {

    }

    @Override
    public void mouseDraggedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(IState.getScaledPoint(mouseEvent.getPoint(), mindMap.getSavedZoom()));

        if(mindMapView.getSelectionModel().getSingleSelectionElement() != null &&
                mindMapView.getSelectionModel().getSingleSelectionElement() != elementPainter &&
                !(elementPainter instanceof LinkPainter)
        ){
            mindMapView.getSelectionModel().setSecondarySelectionElement(elementPainter);
        }

        if (mindMapView.getSelectionModel().getSingleSelectionElement() != null) {
            Point point = new Point(
                    (int) (((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel()).getLocation().getX() +
                            ((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel()).getEllipseDimension().width / 2),
                    (int) (((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel()).getLocation().getY() +
                            ((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel()).getEllipseDimension().height / 2)
            );

            mindMapView.setTemporaryLink(new Line2D.Double(point, IState.getScaledPoint(mouseEvent.getPoint(), mindMapView.getMindMap().getSavedZoom())));
        }

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mousePressedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(IState.getScaledPoint(mouseEvent.getPoint(), mindMap.getSavedZoom()));

        if (!(elementPainter instanceof LinkPainter))
            mindMapView.getSelectionModel().setSingleSelectionElement(elementPainter);

        mindMapView.setTemporaryLink(new Line2D.Double(0,0,0,0));

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mouseReleasedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        MindMap mindMap = mindMapView.getMindMap();

        if (mindMapView.getSelectionModel().getSingleSelectionElement() != null && mindMapView.getSelectionModel().getSecondarySelectionElement() != null )
            setNewLink(mindMapView);

        mindMapView.getSelectionModel().setSingleSelectionElement(null);
        mindMapView.getSelectionModel().setSecondarySelectionElement(null);

        mindMapView.setTemporaryLink(null);

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

    private void setNewLink(MindMapView mindMapView){

        Term term1 = ((Term) mindMapView.getSelectionModel().getSingleSelectionElement().getModel());
        Term term2 = ((Term) mindMapView.getSelectionModel().getSecondarySelectionElement().getModel());

        Link link = new Link(term1 + " with " + term2, term1, term2);

        mindMapView.getMindMap().getCommandManager().addCommand(new AddLinkCommand(term1, term2, link, mindMapView));
    }
}


