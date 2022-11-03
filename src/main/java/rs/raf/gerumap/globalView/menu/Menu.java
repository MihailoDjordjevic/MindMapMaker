package rs.raf.gerumap.globalView.menu;

import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {
    public Menu() {
        JMenu file = new JMenu("File");
        file.setMnemonic('F');

        JMenu newItem = new JMenu(MainFrame.getInstance().getActionManager().getActionNew());
        newItem.setMnemonic('N');
        JMenuItem newProject = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewProject());
        JMenuItem newMindMap = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewMindMap());
        JMenuItem newElement = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewElement());

        JMenu help = new JMenu("Help");
        JMenuItem info = new JMenuItem(MainFrame.getInstance().getActionManager().getActionInfo());

        file.add(newItem);
        newItem.add(newProject);
        newItem.addSeparator();
        newItem.add(newMindMap);
        newItem.add(newElement);

        help.add(info);

        add(file);
        add(help);
    }
}