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
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;

@Getter
@Setter
public class MindMapView extends JPanel implements ISubscriber, AdjustmentListener {

    private MindMap mindMap;
    private JScrollPane parentPane;
    private LinkedList<ElementPainter> elementPainters;
    private SelectionModel selectionModel;
    private AffineTransform affineTransform;
    private Line2D temporaryLink;
    private Rectangle2D lassoRectangle;

    public MindMapView(MindMap mindMap) {

        this.mindMap = mindMap;
        elementPainters = new LinkedList<>();
        selectionModel = new SelectionModel();
        affineTransform = new AffineTransform();
        affineTransform.scale(getMindMap().getSavedZoom(), getMindMap().getSavedZoom());
        mindMap.addSubscriber(this);

        setBackground(mindMap.getBackgroundColor());
        setSize(new Dimension((int) (3000 * Math.pow(1.25, 7)), (int) (3000 * Math.pow(1.25, 7))));
        setPreferredSize(new Dimension((int) (3000 * Math.pow(1.25, 7)), (int) (3000 * Math.pow(1.25, 7))));

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

    public void selectElementsLasso(){

        ElementPainter elementPainter;

        for (int i = this.getElementPainters().size() - 1; i >= 0; i--){

            if (this.getElementPainters().get(i).isContainedLasso(lassoRectangle)) {
                elementPainter = this.getElementPainters().get(i);

                if (!getSelectionModel().getMultipleSelectionElements().contains(elementPainter)) {
                    getSelectionModel().getMultipleSelectionElements().add(elementPainter);
                    elementPainter.setSelected(true);
                }

            }
        }

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

        if (lassoRectangle != null){
            BasicStroke stroke = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1, new float[]{5,5}, 0);
            graphics2D.setStroke(stroke);
            graphics2D.setColor(Color.BLACK);
            graphics2D.draw(lassoRectangle);
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
                ProjectView projectView = ((ProjectView) this.getParentPane().getParent());
                projectView.setTitleAt(projectView.indexOfComponent(this.getParentPane()), mindMap.getName());
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

            case ZOOM -> {
                affineTransform.scale(getMindMap().getZoom(), getMindMap().getZoom());
            }
        }
        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

        if (e.getAdjustable().getOrientation() == Adjustable.HORIZONTAL)
            e.getAdjustable().setMaximum((int) (3000 * getMindMap().getSavedZoom()));
        else if (e.getAdjustable().getOrientation() == Adjustable.VERTICAL)
            e.getAdjustable().setMaximum((int) (2000 * getMindMap().getSavedZoom()));

        System.out.println(System.currentTimeMillis());
    }
}