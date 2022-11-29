package rs.raf.gerumap.mindMapEditor.editorState;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.centralizedProjectView.TermPainter;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class AddTermState implements IState{
    @Override
    public void performAction(Object event) {
        MindMapView mindMapView = (MindMapView) ((MouseEvent) event).getSource();
        MindMap mindMap = mindMapView.getMindMap();

        Term term = new Term("Term " + (mindMap.getChildren().size() + 1), mindMap);
        mindMap.addChild(term);
        term.setLocation(((MouseEvent) event).getPoint());

        TermPainter termPainter = new TermPainter(term);
        mindMapView.getElementPainters().add(termPainter);
        SwingUtilities.updateComponentTreeUI(mindMapView);
    }
}
