package rs.raf.gerumap.globalView.popUpPanes;

import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.EventType;
import rs.raf.gerumap.globalView.popUpPanes.abstraction.PopUpPane;

public class NotificationPopUpPane extends PopUpPane {
    @Override
    public Object showPopUp(AbstractMessageEvent eventMessage) {
        if(eventMessage.getEventType().equals(EventType.NOTIFICATION)){

        }

        return null;
    }
}
