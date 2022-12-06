package rs.raf.gerumap.centralizedProjectView;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.centralizedProjectView.mouseListeners.MindMapMouseListener;
import rs.raf.gerumap.centralizedProjectView.mouseListeners.MindMapMouseMotionLsnr;
import rs.raf.gerumap.centralizedProjectView.selectionModel.SelectionModel;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.observer.ISubscriber;
import rs.raf.gerumap.observer.NotificationType;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.util.LinkedList;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber {

    private MindMap mindMap;
    private LinkedList<ElementPainter> elementPainters;
    private SelectionModel selectionModel;
    private AffineTransform affineTransform;
    private Line2D temporaryLink;

    public MindMapView(MindMap mindMap) {

        this.mindMap = mindMap;
        elementPainters = new LinkedList<>();
        selectionModel = new SelectionModel();
        affineTransform = new AffineTransform();
        affineTransform.scale(getMindMap().getSavedZoom(), getMindMap().getSavedZoom());
        mindMap.addSubscriber(this);

        setBackground(mindMap.getBackgroundColor());
        setPreferredSize(new Dimension(3000, 2000));
        setSize(new Dimension(3000, 2000));

        addPaintersFromModel();

        addMouseListener(new MindMapMouseListener());
        addMouseMotionListener(new MindMapMouseMotionLsnr());
    }

    private void addPaintersFromModel(){

        for (MapNode mapNode : getMindMap().getChildren()){
            if (mapNode instanceof Term){
                TermPainter termPainter = new TermPainter(mapNode);
                getElementPainters().add(termPainter);
            }
            for (MapNode mapNode1 : ((MapNodeComposite) mapNode).getChildren()){
                LinkPainter linkPainter = new LinkPainter(mapNode1);
                getElementPainters().add(0, linkPainter);
            }
        }


        SwingUtilities.updateComponentTreeUI(this);
    }

    public ElementPainter getGraphicsAtLocation(Point p){

        ElementPainter elementPainter;

        for (int i = this.getElementPainters().size() - 1; i >= 0; i--){

            if (this.getElementPainters().get(i).isContained(p)) {
                elementPainter = this.getElementPainters().get(i);
                return elementPainter;
            }
        }

        return null;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D graphics2D = (Graphics2D) g;
        AffineTransform tmp = graphics2D.getTransform();
        graphics2D.transform(affineTransform);

        if (temporaryLink != null) {
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(temporaryLink);
        }

        for (ElementPainter elementPainter : elementPainters){
            elementPainter.paintElement(graphics2D);
        }

        graphics2D.setTransform(tmp);
    }

    @Override
    public void update(Object notification, NotificationType notificationType) {

        switch (notificationType){

            case NAME_CHANGE -> {
                ProjectView projectView = ((ProjectView) this.getParent());
                projectView.setTitleAt(projectView.indexOfComponent(this), mindMap.getName());
            }

            case DELETE -> {
                for (ElementPainter elementPainter : elementPainters){
                    if (elementPainter.getModel() == notification) {
                        elementPainters.remove(elementPainter);
                        break;
                    }
                }
            }

            case ADD -> {
                TermPainter termPainter = new TermPainter(((Term) notification));
                getElementPainters().add((termPainter));
            }

            case ZOOM -> affineTransform.scale(getMindMap().getZoom(), getMindMap().getZoom());
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }
}