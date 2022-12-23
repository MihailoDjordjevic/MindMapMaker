package rs.raf.gerumap.commandManagement;

import rs.raf.gerumap.commandManagement.abstraction.AbstractCommand;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;
import java.awt.*;

public class MoveCommand extends AbstractCommand {

    private Point oldPoint;
    private Point newPoint;
    private Term term;

    public MoveCommand(Point oldPoint, Point newPoint, Term term) {
        this.oldPoint = oldPoint;
        this.newPoint = newPoint;
        this.term = term;
    }

    @Override
    public void doCommand() {

        term.setLocation(new Point(
                newPoint.x - term.getEllipseDimension().width/2,
                newPoint.y - term.getEllipseDimension().height/2
        ));

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }

    @Override
    public void undoCommand() {

        term.setLocation(new Point(
                oldPoint.x - term.getEllipseDimension().width/2,
                oldPoint.y - term.getEllipseDimension().height/2
        ));

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getCurrentProjectView());
    }
}
