package rs.raf.gerumap.errorHandling.message;

import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.EventType;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.MessageDescription;

public class CannotRemoveNodeMessage extends AbstractMessageEvent {
    public CannotRemoveNodeMessage(Object source){
        super(EventType.ERROR);
        this.setMessageDescription(MessageDescription.CANNOT_REMOVE_NODE);
        String objectStr = source == null ? "No item is selected to remove" : source.toString();
        this.setText("Cannot remove: " + objectStr);
    }
}