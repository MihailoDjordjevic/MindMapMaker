package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.TermPainter;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class AddTermState implements IState{
    @Override
    public void mouseClickAction(Object event) {
        MouseEvent e = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) ((MouseEvent) event).getSource();
        MindMap mindMap = mindMapView.getMindMap();

        Term term = new Term("Term " + (mindMap.getChildren().size() + 1), mindMap);
        mindMap.addChild(term);

        int x = e.getX() - term.getEllipseDimension().width/2;
        int y = e.getY() - term.getEllipseDimension().height/2;

        term.getLocation().setLocation(x, y);

        TermPainter termPainter = new TermPainter(term);
        mindMapView.getElementPainters().add(termPainter);
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
