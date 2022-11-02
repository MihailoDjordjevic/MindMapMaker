package rs.raf.gerumap.globalView.gui;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;

@Getter
@Setter
@NoArgsConstructor
public class SwingGui implements Gui {
    private MainFrame instance;
    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}