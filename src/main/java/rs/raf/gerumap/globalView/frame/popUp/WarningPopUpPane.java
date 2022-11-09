package rs.raf.gerumap.globalView.frame.popUp;

import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.EventType;

public class WarningPopUpPane extends PopUpPane{
    @Override
    public void showPopUp(AbstractMessageEvent eventMessage) {
        if(eventMessage.getEventType().equals(EventType.WARNING)){

        }
    }
}
