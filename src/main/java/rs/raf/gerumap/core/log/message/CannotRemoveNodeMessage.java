package rs.raf.gerumap.core.log.message;

public class CannotRemoveNodeMessage extends EventMessage{
    public CannotRemoveNodeMessage(){
        super(EventType.ERROR);
        this.setMessageDescription(MessageDescription.CANNOT_REMOVE_NODE);
        this.setText("Cannot remove node");
    }
}