package rs.raf.gerumap.gui.menu;

import rs.raf.gerumap.controller.ActionInfo;
import rs.raf.gerumap.controller.ActionNew;
import rs.raf.gerumap.gui.general.MainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
    public Menu() {
        JMenu jMenuFile = new JMenu("File");
        JMenu jMenuNew = new JMenu(MainFrame.getInstance().getActionManager().getActionNew());
        JMenu jMenuHelp = new JMenu("Help");
        JMenuItem jMenuItemInfo = new JMenuItem(MainFrame.getInstance().getActionManager().getActionInfo());

        jMenuFile.add(jMenuNew);
        jMenuFile.addSeparator();

        jMenuHelp.add(jMenuItemInfo);

        add(jMenuFile);
        add(jMenuHelp);
        jMenuItemInfo.addActionListener(MainFrame.getInstance().getActionManager().getActionInfo());
    }
}