package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.TermPainter;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class AddTermState implements IState{
    @Override
    public void mouseClickAction(Object event) {
        MouseEvent e = ((MouseEvent) event);
        MindMapView mindMapView = (MindMapView) ((MouseEvent) event).getSource();
        MindMap mindMap = mindMapView.getMindMap();

        Term term = new Term("Term " + (mindMap.getChildren().size() + 1), mindMap);
        mindMap.addChild(term);

        Point point = IState.getScaledPoint(e.getPoint(), mindMap.getSavedZoom());

        int x = point.x - term.getEllipseDimension().width/2;
        int y = point.y - term.getEllipseDimension().height/2;

        term.getLocation().setLocation(x, y);

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
