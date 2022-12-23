package rs.raf.gerumap.commandManagement;

import rs.raf.gerumap.commandManagement.abstraction.AbstractCommand;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.Link;
import rs.raf.gerumap.model.repository.implementation.Term;

import java.util.ArrayList;
import java.util.Collections;

public class DeleteElementCommand extends AbstractCommand {

    private MapNodeComposite parent;
    private MapNode child;
    private ArrayList<MapNode> deletedLinks;

    public DeleteElementCommand(MapNodeComposite parent, MapNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {

        if (child instanceof Term)
            deletedLinks = new ArrayList<>(((Term) child).getChildren());

        parent.deleteChild(child);
    }

    @Override
    public void undoCommand() {
        parent.addChild(child);

        if (child instanceof Term){
            for (MapNode mapNode : deletedLinks) {
                ((Link) mapNode).getSourceTerm().addChild(mapNode);
            }

        }
    }

}
