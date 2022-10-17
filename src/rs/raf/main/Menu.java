package rs.raf.main;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
    public Menu() {
        JMenu jMenuFile = new JMenu("File");
        JMenu jMenuNew = new JMenu("New");
        JMenu jMenuEdit = new JMenu("Edit");
        JMenuItem jMenuItemProject = new JMenuItem("Project");
        JMenuItem jMenuItemPackage = new JMenuItem("Package");
        jMenuNew.add(jMenuItemProject);
        jMenuNew.addSeparator();
        jMenuNew.add(jMenuItemPackage);
        MainFrame.getInstance();

        JMenuItem jMenuItemOpen = new JMenuItem("Open");
        JMenuItem jMenuItemClose = new JMenuItem("Close");
        JMenuItem jMenuItemCloseAll = new JMenuItem("Close All");

        jMenuFile.add(jMenuNew);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemOpen);
        jMenuFile.addSeparator();
        jMenuFile.add(jMenuItemClose);
        jMenuFile.add(jMenuItemCloseAll);
        jMenuFile.addSeparator();

        add(jMenuFile);
        add(jMenuEdit);
    }
}