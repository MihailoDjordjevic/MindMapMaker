package rs.raf.gerumap.commandManagement;

import rs.raf.gerumap.centralizedProjectView.LinkPainter;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.commandManagement.abstraction.AbstractCommand;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import javax.swing.*;

public class AddLinkCommand extends AbstractCommand {

    private Term source;
    private Term destination;
    private Link link;
    private MindMapView mindMapView;

    public AddLinkCommand(Term source, Term destination, Link link, MindMapView mindMapView) {
        this.source = source;
        this.destination = destination;
        this.link = link;
        this.mindMapView = mindMapView;
    }

    @Override
    public void doCommand() {
        source.addChild(link);
    }

    @Override
    public void undoCommand() {
        source.deleteChild(link);
    }
}
