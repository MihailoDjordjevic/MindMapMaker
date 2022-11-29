package rs.raf.gerumap.globalView.toolbars;

import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class EditorToolbar extends JToolBar {

    public EditorToolbar() {

        initToolbar();
        initComponents();

    }

    private void initToolbar(){
        setPreferredSize(new Dimension(60, 400));
        setBackground(Color.PINK);
        setBorder(new LineBorder(Color.BLACK, 2, true));
        setOrientation(VERTICAL);
        setFloatable(false);
    }

    private void initComponents(){

        add(Box.createVerticalStrut(3));
        add(MainFrame.getInstance().getActionManager().getActionAddTermState());
//        add(MainFrame.getInstance().getActionManager().getActionDelete());
//        add(MainFrame.getInstance().getActionManager().getActionRename());
//        add(MainFrame.getInstance().getActionManager().getActionSetAuthor());

    }
}
