package rs.raf.gerumap.view.menu;

import rs.raf.gerumap.view.frame.MainFrame;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
    public Menu() {
        JMenu File = new JMenu("File");

        JMenu New = new JMenu(MainFrame.getInstance().getActionManager().getActionNew());
        JMenuItem NewProject = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewProject());
        JMenuItem NewMindMap = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewMindMap());

        JMenu Help = new JMenu("Help");
        JMenuItem Info = new JMenuItem(MainFrame.getInstance().getActionManager().getActionInfo());

        File.add(New);
        New.add(NewProject);
        New.addSeparator();
        New.add(NewMindMap);

        Help.add(Info);

        add(File);
        add(Help);
    }
}