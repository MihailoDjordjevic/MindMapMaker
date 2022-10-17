package rs.raf.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class MainFrame extends JFrame {
    private static MainFrame instance = null;
    Menu menu;
    Toolbar toolbar;
    private MainFrame() {

    }
    private void initialise() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        setSize(screenWidth / 2, screenHeight / 2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("GeRuMap");

        menu = new Menu();
        setJMenuBar(menu);

        toolbar = new Toolbar();
        add(toolbar, BorderLayout.NORTH);
    }
    public Menu getMenu() {
        return menu;
    }
    public Toolbar getToolbar() {
        return toolbar;
    }
    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialise();
        }
        return instance;
    }
}