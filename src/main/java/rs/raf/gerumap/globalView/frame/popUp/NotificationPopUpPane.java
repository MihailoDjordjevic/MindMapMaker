package rs.raf.gerumap.globalView.frame.popUp;

import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.core.log.message.EventType;

public class NotificationPopUpPane extends PopUpPane{
    @Override
    public void showPopUp(EventMessage eventMessage) {
        if(eventMessage.getEventType().equals(EventType.NOTIFICATION)){

        }
    }
}
