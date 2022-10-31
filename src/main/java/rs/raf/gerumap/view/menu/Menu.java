package rs.raf.gerumap.view.menu;

import rs.raf.gerumap.view.frame.MainFrame;

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
    }
}