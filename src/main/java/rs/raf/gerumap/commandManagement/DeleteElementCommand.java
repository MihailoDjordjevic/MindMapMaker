package rs.raf.gerumap.commandManagement;

import rs.raf.gerumap.commandManagement.abstraction.AbstractCommand;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;

public class DeleteElementCommand extends AbstractCommand {

    private MapNodeComposite parent;
    private MapNode child;

    public DeleteElementCommand(MapNodeComposite parent, MapNode child) {
        this.parent = parent;
        this.child = child;
    }

    @Override
    public void doCommand() {
        parent.deleteChild(child);
    }

    @Override
    public void undoCommand() {
        parent.addChild(child);
    }

}
