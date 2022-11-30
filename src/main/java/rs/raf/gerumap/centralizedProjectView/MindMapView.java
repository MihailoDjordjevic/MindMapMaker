package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.emenetViewing.ElementPainter;
import rs.raf.gerumap.centralizedProjectView.mouseListeners.MindMapMouseListener;
import rs.raf.gerumap.centralizedProjectView.mouseListeners.MindMapMouseMotionLsnr;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private ArrayList<ElementPainter> elementPainters;

    public MindMapView(MindMap mindMap) {

        this.mindMap = mindMap;
        elementPainters = new ArrayList<>(10);
        mindMap.addSubscriber(this);

        setBackground(mindMap.getBackgroundColor());
        setPreferredSize(new Dimension(800, 700));

        addPaintersFromModel();

        addMouseListener(new MindMapMouseListener());
        addMouseMotionListener(new MindMapMouseMotionLsnr());
    }

    private void addPaintersFromModel(){

        for (MapNode mapNode : getMindMap().getChildren()){
            if (mapNode instanceof Term){
                TermPainter termPainter = new TermPainter((Element) mapNode);
                getElementPainters().add(termPainter);
            }
        }


        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;

        for (ElementPainter elementPainter : elementPainters){
            elementPainter.paintElement(graphics2D);
        }
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {
        switch (notificationType){
            case NAME_CHANGE -> {
                ProjectView projectView = ((ProjectView) this.getParent());
                projectView.setTitleAt(projectView.indexOfComponent(this), mindMap.getName());
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getWorkspacePanel());
    }
}