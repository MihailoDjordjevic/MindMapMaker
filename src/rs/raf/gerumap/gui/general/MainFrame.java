package rs.raf.gerumap.gui.general;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.controller.ActionManager;
import rs.raf.gerumap.gui.menu.Menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

@Getter
@Setter
@NoArgsConstructor
public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    private Menu menu;
    private ActionManager actionManager;
    private void initialise() {
        JPanel jPanel = new JPanel();
        actionManager = new ActionManager();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        jPanel.setLayout(new BorderLayout());
        jPanel.add(new Menu(), BorderLayout.NORTH);
        JScrollPane jScrollPane = new JScrollPane(new JTree());
        jScrollPane.setAutoscrolls(true);
        jPanel.add(jScrollPane, BorderLayout.WEST);
        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        Dimension minimumSize = new Dimension(100, 50);
        leftPanel.setMinimumSize(minimumSize);
        leftPanel.setPreferredSize(new Dimension(400, 400));
        rightPanel.setMinimumSize(minimumSize);
        rightPanel.setPreferredSize(new Dimension(400, 400));
        JSplitPane jSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        jSplitPane.setOneTouchExpandable(true);
        jPanel.add(jSplitPane, BorderLayout.EAST);

        add(jPanel);

    }
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }
}