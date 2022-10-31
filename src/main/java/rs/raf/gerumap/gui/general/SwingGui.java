package rs.raf.gerumap.gui.general;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SwingGui{
    public void start(SwingGui swingGui) {
        MainFrame.getInstance().setVisible(true);
    }
}