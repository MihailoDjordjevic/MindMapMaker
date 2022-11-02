package rs.raf.gerumap.view.frame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.controller.ActionManager;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.model.repository.MapRepositoryImplementation;
import rs.raf.gerumap.tree.view.MapTreeView;
import rs.raf.gerumap.view.menu.Menu;
import rs.raf.gerumap.view.toolbar.Toolbar;

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
    private Toolbar toolbar;
    private ActionManager actionManager;

    private JPanel mainPanel;
    private JPanel workspacePanel;
    private JScrollPane treeHolderScrollPane;
    private MapTreeView mapTreeView;
    private JSplitPane treeAndWorkspaceSplitPane;

    private void initialise() {

        initialiseFrameComponents();  //calls new for every component

        initialiseMainFrameProperties();

        initialiseComponentsProperties();

        addComponentsToMainFrame();

    }
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }

    private void initialiseFrameComponents(){
        mainPanel = new JPanel();
        actionManager = new ActionManager();
        menu = new Menu();
        toolbar = new Toolbar();
        mapTreeView = ((MapRepositoryImplementation) ApplicationFramework.getInstance().getIMapRepository()).takeGeneratedTree();
        treeHolderScrollPane = new JScrollPane(mapTreeView);
        workspacePanel = new JPanel();
        treeAndWorkspaceSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeHolderScrollPane, workspacePanel);
    }

    private void addComponentsToMainFrame(){
        setJMenuBar(menu);
        mainPanel.add(treeAndWorkspaceSplitPane, BorderLayout.CENTER);
        mainPanel.add(toolbar, BorderLayout.NORTH);
        add(mainPanel);
    }

    private void initialiseMainFrameProperties(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");
    }

    private void initialiseComponentsProperties(){
        mainPanel.setLayout(new BorderLayout());

        treeHolderScrollPane.setAutoscrolls(true);

        Dimension minimumSize = new Dimension(100, 50);
        treeHolderScrollPane.setPreferredSize(new Dimension(400, 400));
        workspacePanel.setMinimumSize(minimumSize);
        workspacePanel.setPreferredSize(new Dimension(400, 400));

        treeAndWorkspaceSplitPane.setOneTouchExpandable(true);
        treeAndWorkspaceSplitPane.setDividerLocation(120);
    }
}