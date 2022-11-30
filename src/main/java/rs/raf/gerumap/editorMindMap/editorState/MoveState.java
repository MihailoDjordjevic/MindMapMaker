package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class MoveState implements IState{

    @Override
    public void mouseClickAction(Object event) {

    }

    @Override
    public void mouseDraggedAction(Object event) {

        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();
        ElementPainter clickedElement;

        for (ElementPainter elementPainter : mindMapView.getElementPainters()){
            if (elementPainter.isContained(mouseEvent.getPoint())){
                System.out.println("Selected element " + elementPainter.getModel().getName());
                clickedElement = elementPainter;
                ((Term) clickedElement.getModel()).getLocation().setLocation(mouseEvent.getPoint().getX() - 10, mouseEvent.getPoint().getY() - 15);
                SwingUtilities.updateComponentTreeUI(mindMapView);
                break;
            }
        }
    }
}
