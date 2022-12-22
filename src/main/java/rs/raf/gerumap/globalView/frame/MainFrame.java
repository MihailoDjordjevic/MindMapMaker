package rs.raf.gerumap.globalView.frame;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.ProjectView;
import rs.raf.gerumap.controller.managementAndAbstraction.ActionManager;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.menu.Menu;
import rs.raf.gerumap.globalView.toolbars.EditorToolbar;
import rs.raf.gerumap.globalView.toolbars.GlobalToolbar;
import rs.raf.gerumap.model.repository.MapRepositoryImplementation;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.awt.*;

@Getter
@Setter
@NoArgsConstructor
public class MainFrame extends JFrame {

    private static MainFrame instance = null;
    private Menu menu;
    private GlobalToolbar globalToolbar;
    private EditorToolbar editorToolbar;
    private ActionManager actionManager;

    private JPanel mainPanel;
    private JPanel workspacePanel;
    private JScrollPane treeHolderScrollPane;
    private MapTreeView mapTreeView;
    private JSplitPane treeAndWorkspaceSplitPane;
    private ProjectView currentProjectView;

    private JLabel noProjectLabel;
    private JLabel noMindMapLabel;

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
        globalToolbar = new GlobalToolbar();
        editorToolbar = new EditorToolbar();
        mapTreeView = ((MapRepositoryImplementation) ApplicationFramework.getInstance().getIMapRepository()).takeGeneratedTree();
        treeHolderScrollPane = new JScrollPane(mapTreeView);
        workspacePanel = new JPanel();
        treeAndWorkspaceSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treeHolderScrollPane, workspacePanel);
        noMindMapLabel = new JLabel("This project doesnt have any mind maps yet");
        noProjectLabel = new JLabel("No project is currently selected to display");
    }

    private void addComponentsToMainFrame(){
        setJMenuBar(menu);
        workspacePanel.add(noProjectLabel);
        mainPanel.add(treeAndWorkspaceSplitPane, BorderLayout.CENTER);
        mainPanel.add(globalToolbar, BorderLayout.NORTH);
        add(mainPanel);
    }

    private void initialiseMainFrameProperties(){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize((int) (screenWidth / 1.4), (int) (screenHeight / 1.4));
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
        workspacePanel.setBackground(Color.lightGray);
        workspacePanel.setLayout(null);

        treeAndWorkspaceSplitPane.setOneTouchExpandable(true);
        treeAndWorkspaceSplitPane.setDividerLocation(200);

        noProjectLabel.setBounds(workspacePanel.getPreferredSize().width/2, workspacePanel.getPreferredSize().height/2, 280, 20);
        noProjectLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 13));

        noMindMapLabel.setBounds(workspacePanel.getPreferredSize().width/2, workspacePanel.getPreferredSize().height/2, 280, 20);
        noMindMapLabel.setFont(new Font(Font.DIALOG, Font.ITALIC, 13));
    }

    public void displayProject(JTabbedPane project, int nodeOrdinal){

        workspacePanel.removeAll();
        workspacePanel.setLayout(new BorderLayout());
        workspacePanel.add(project, BorderLayout.CENTER);
        workspacePanel.add(editorToolbar, BorderLayout.EAST);

        currentProjectView = (ProjectView) project;

        if (nodeOrdinal > -1)
            project.setSelectedIndex(nodeOrdinal);

        SwingUtilities.updateComponentTreeUI(this);
    }

    public void removeDisplayedProject(){
        //this.getCurrentProjectView().getProject().getSubscribers().remove(this.getCurrentProjectView());
        this.getWorkspacePanel().removeAll();
        this.getWorkspacePanel().setLayout(null);
        this.getWorkspacePanel().add(this.getNoProjectLabel());
        this.setCurrentProjectView(null);
    }
}