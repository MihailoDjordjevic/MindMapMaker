package rs.raf.gerumap.globalView.frame.popUp;

import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.core.log.message.EventType;

import javax.swing.*;

public abstract class PopUpPane extends JOptionPane {
    public PopUpPane(){
        super();
    }
    public abstract void showPopUp(EventMessage eventMessage);
}