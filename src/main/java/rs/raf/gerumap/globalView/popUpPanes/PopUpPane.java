package rs.raf.gerumap.globalView.popUpPanes;

import rs.raf.gerumap.errorHandling.message.abstractionAndEnums.AbstractMessageEvent;

import javax.swing.*;

public abstract class PopUpPane extends JOptionPane {
    public PopUpPane(){
        super();
    }
    public abstract void showPopUp(AbstractMessageEvent eventMessage);
}