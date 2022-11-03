package rs.raf.gerumap.globalView.menu;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.BeanProperty;

@Getter
@Setter
public class Menu extends JMenuBar {

    private JMenu file;
    private JMenu newItem;
    private JMenuItem newProject;
    private JMenuItem newMindMap;
    private JMenuItem newElement;

    JMenu help;
    JMenuItem info;

    public Menu() {
        file = new JMenu("File");
        file.setMnemonic('F');

        newItem = new JMenu(MainFrame.getInstance().getActionManager().getActionNew());
        newItem.setMnemonic('N');
        newProject = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewProject());
        newMindMap = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewMindMap());
        newElement = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewElement());

        JMenu help = new JMenu("Help");
        info = new JMenuItem(MainFrame.getInstance().getActionManager().getActionInfo());

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