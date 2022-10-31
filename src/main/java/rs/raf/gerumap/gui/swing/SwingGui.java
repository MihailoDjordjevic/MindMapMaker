package rs.raf.gerumap.gui.swing;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.core.Gui;

@Getter
@Setter
@NoArgsConstructor
public class SwingGui implements Gui {
    private MainFrame instance;
    public void start(SwingGui swingGui) {
        MainFrame.getInstance().setVisible(true);
    }

    @Override
    public void start() {
        instance = MainFrame.getInstance();
        instance.setVisible(true);
    }
}