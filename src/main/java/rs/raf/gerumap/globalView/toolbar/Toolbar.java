package rs.raf.gerumap.globalView.toolbar;

import rs.raf.gerumap.Main;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.JTextComponent;
import java.awt.*;

public class Toolbar extends JToolBar {

    private JTextField editNameTextField;

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
        add(MainFrame.getInstance().getActionManager().getActionDelete());
        add(MainFrame.getInstance().getActionManager().getActionRename());

        initEditNameTextField();
    }

    private void initEditNameTextField(){
        editNameTextField = new JTextField();
        editNameTextField.setMaximumSize(new Dimension(150, 32));
        editNameTextField.setToolTipText("edit node name");

        add(editNameTextField);
    }
}
