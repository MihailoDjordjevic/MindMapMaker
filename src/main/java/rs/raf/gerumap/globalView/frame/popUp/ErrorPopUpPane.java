package rs.raf.gerumap.globalView.frame.popUp;

import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;
import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.EventType;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;

public class ErrorPopUpPane extends PopUpPane{
    @Override
    public void showPopUp(AbstractMessageEvent eventMessage) {
        if(eventMessage.getEventType().equals(EventType.ERROR)){
            JOptionPane.showConfirmDialog(MainFrame.getInstance(), eventMessage.getText(), eventMessage.getEventType().name(), JOptionPane.DEFAULT_OPTION);
        }
    }
}