package rs.raf.gerumap.globalView.gui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.core.log.message.EventMessage;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.globalView.frame.popUp.ErrorPopUpPane;
import rs.raf.gerumap.observer.NotificationType;

@Getter
@Setter
@NoArgsConstructor
public class SwingGui implements Gui {
    private MainFrame mainFrame;
    @Override
    public void start() {
        mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
    @Override
    public void update(Object notification, NotificationType notificationType) {
        new ErrorPopUpPane().showPopUp((EventMessage) notification);
    }
}