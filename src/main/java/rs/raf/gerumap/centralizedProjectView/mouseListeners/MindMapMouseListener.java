package rs.raf.gerumap.centralizedProjectView.mouseListeners;

import rs.raf.gerumap.globalView.frame.MainFrame;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MindMapMouseListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        MainFrame.getInstance().getCurrentProjectView().getStateManager().getCurrentState().performAction(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
