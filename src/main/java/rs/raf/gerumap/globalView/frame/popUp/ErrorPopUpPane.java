package rs.raf.gerumap.globalView.frame.popUp;

import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.core.log.message.EventType;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;

public class ErrorPopUpPane extends PopUpPane{
    @Override
    public void showPopUp(EventMessage eventMessage) {
        if(eventMessage.getEventType().equals(EventType.ERROR)){
            JOptionPane.showConfirmDialog(MainFrame.getInstance(), eventMessage.getText(), eventMessage.getEventType().name(), JOptionPane.DEFAULT_OPTION);
        }
    }
}