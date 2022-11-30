package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class SelectState implements IState{

    @Override
    public void mouseClickAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        for (int i = mindMapView.getElementPainters().size() - 1; i >= 0; i--){
            if (mindMapView.getElementPainters().get(i).isContained(mouseEvent.getPoint())) {

                ElementPainter elementPainter = mindMapView.getElementPainters().get(i);
                elementPainter.getModel().setBorderColor(Color.RED);
                System.out.println("Selected: " + elementPainter.getModel().getName());
                break;

            }
        }
    }

    @Override
    public void mouseDraggedAction(Object event) {

    }
}
