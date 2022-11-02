package rs.raf.gerumap.globalView.toolbar;

import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class Toolbar extends JToolBar {

    public Toolbar() {
        initToolbar();
        initComponents();
    }

    private void initToolbar(){
        setPreferredSize(new Dimension(600, 45));
        setBackground(Color.PINK);
        setBorder(new LineBorder(Color.BLACK, 2, true));
    }

    private void initComponents(){
        add(Box.createHorizontalStrut(3));
        add(MainFrame.getInstance().getActionManager().getActionNew());
    }
}
