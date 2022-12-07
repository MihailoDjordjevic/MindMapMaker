package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.popUpPanes.editElementsPane.EditElementsPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public class SelectState implements IState{

    private Point startSelectionPoint;
    private Point endSelectionPoint;

    @Override
    public void mouseClickAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        mindMapView.getSelectionModel().unselectCurrentSelection();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(mouseEvent.getPoint());

        if (mouseEvent.getClickCount() == 2 && elementPainter != null){
            new EditElementsPane(MainFrame.getInstance(), elementPainter.getModel(), "Modify element", true, 190, 270);
        }
        mindMapView.getSelectionModel().setSingleSelectionElement(elementPainter);

        SwingUtilities.updateComponentTreeUI(mindMapView);

        startSelectionPoint = mouseEvent.getPoint();
    }

    @Override
    public void mouseDraggedAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = ((MindMapView) mouseEvent.getSource());

        endSelectionPoint = mouseEvent.getPoint();

        mindMapView.getSelectionModel().unselectCurrentSelection();

        mindMapView.setLassoRectangle(new Rectangle2D.Double(
                Math.min(startSelectionPoint.x, endSelectionPoint.x),
                Math.min(startSelectionPoint.y, endSelectionPoint.y),
                Math.abs(startSelectionPoint.x - endSelectionPoint.x),
                Math.abs(startSelectionPoint.y - endSelectionPoint.y)
        ));

        mindMapView.selectElementsLasso();

        SwingUtilities.updateComponentTreeUI(mindMapView);
    }

    @Override
    public void mousePressedAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        mindMapView.getSelectionModel().unselectCurrentSelection();

        startSelectionPoint = ((MouseEvent) event).getPoint();
    }

    @Override
    public void mouseReleasedAction(Object event) {
        startSelectionPoint = null;
        endSelectionPoint = null;

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = ((MindMapView) mouseEvent.getSource());
        mindMapView.setLassoRectangle(null);

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
