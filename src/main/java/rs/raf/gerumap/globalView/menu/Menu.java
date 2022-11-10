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

    private JMenu edit;
    private JMenuItem delete;
    private JMenuItem rename;
    private JMenuItem setAuthor;

    private JMenu help;
    private JMenuItem info;

    public Menu() {
        file = new JMenu("File");
        file.setMnemonic('F');

        newItem = new JMenu(MainFrame.getInstance().getActionManager().getActionNew());
        newItem.setMnemonic('N');
        newProject = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewProject());
        newMindMap = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewMindMap());
        newElement = new JMenuItem(MainFrame.getInstance().getActionManager().getActionNewElement());

        edit = new JMenu("Edit");
        edit.setMnemonic('E');
        delete = new JMenuItem(MainFrame.getInstance().getActionManager().getActionDelete());
        rename = new JMenuItem(MainFrame.getInstance().getActionManager().getActionRename());
        setAuthor = new JMenuItem(MainFrame.getInstance().getActionManager().getActionSetAuthor());

        help = new JMenu("Help");
        info = new JMenuItem(MainFrame.getInstance().getActionManager().getActionInfo());

        file.add(newItem);
        newItem.add(newProject);
        newItem.addSeparator();
        newItem.add(newMindMap);
        newItem.addSeparator();
        newItem.add(newElement);

        edit.add(delete);
        edit.addSeparator();
        edit.add(rename);
        edit.add(setAuthor);

        help.add(info);

        add(file);
        add(edit);
        add(help);
    }
}