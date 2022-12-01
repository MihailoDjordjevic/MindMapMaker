package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.MindMap;

import java.awt.event.MouseEvent;

public class DeleteState implements IState{

    @Override
    public void mouseClickAction(Object event) {
        MouseEvent e = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) ((MouseEvent) event).getSource();

        ElementPainter elementPainter = mindMapView.getGraphicsAtLocation(e.getPoint());

        if (elementPainter != null){
            ((MapNodeComposite) elementPainter.getModel().getParent()).deleteChild(elementPainter.getModel());
        }
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
