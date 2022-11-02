package rs.raf.gerumap.globalView.gui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;

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
}