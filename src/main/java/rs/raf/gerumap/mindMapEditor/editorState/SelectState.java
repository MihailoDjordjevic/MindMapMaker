package rs.raf.gerumap.mindMapEditor.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;

import java.awt.event.MouseEvent;

public class SelectState implements IState{

    @Override
    public void performAction(Object event) {
        MouseEvent mouseEvent = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) mouseEvent.getSource();

        for (ElementPainter elementPainter : mindMapView.getElementPainters()){
            if (elementPainter.isContained(mouseEvent.getPoint()))
                System.out.println(elementPainter.getModel().getName());
        }
    }
}
