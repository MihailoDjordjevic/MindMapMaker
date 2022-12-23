package rs.raf.gerumap.commandManagement;

import rs.raf.gerumap.centralizedProjectView.TermPainter;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;
import rs.raf.gerumap.commandManagement.abstraction.AbstractCommand;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class MoveCommand extends AbstractCommand {

    private Point oldPoint;
    private Point newPoint;
    private Term term;
    private LinkedList<ElementPainter> elementPainters;

    public MoveCommand(Point oldPoint, Point newPoint, Term term) {
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
        this.term = term;
    }

    public MoveCommand(Point oldPoint, Point newPoint, LinkedList<ElementPainter> elementPainters) {
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
        this.elementPainters = elementPainters;
        undoCommand();
    }

    @Override
    public void doCommand() {

        if (elementPainters == null) {
            term.setLocation(new Point(
                    newPoint.x - term.getEllipseDimension().width/2,
                    newPoint.y - term.getEllipseDimension().height/2
            ));
        } else {
            for(ElementPainter elementPainter : elementPainters){
                if(elementPainter instanceof TermPainter){
                    Term term = (Term)(elementPainter.getModel());
                    term.setLocation(new Point(term.getLocation().x + newPoint.x - oldPoint.x, term.getLocation().y + newPoint.y - oldPoint.y));
                }
            }
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }

    @Override
    public void undoCommand() {

        if (elementPainters == null) {
            term.setLocation(new Point(
                    oldPoint.x - term.getEllipseDimension().width/2,
                    oldPoint.y - term.getEllipseDimension().height/2
            ));
        } else {
            for(ElementPainter elementPainter : elementPainters){
                if(elementPainter instanceof TermPainter){
                    Term term = (Term)(elementPainter.getModel());
                    term.setLocation(new Point(term.getLocation().x - newPoint.x + oldPoint.x, term.getLocation().y - newPoint.y + oldPoint.y));
                }
            }
        }

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }
}
