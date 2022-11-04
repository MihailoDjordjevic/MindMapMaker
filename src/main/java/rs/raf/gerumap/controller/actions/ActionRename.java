package rs.raf.gerumap.controller.actions;

import rs.raf.gerumap.controller.actions.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.BasicDialog;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.NotificationType;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ActionRename extends AbstractMapAction {

    private BasicDialog dialog;
    private JPanel mainPanel;
    private JPanel buttonPanel;
    private JTextField textField;
    private JButton okButton;
    private JButton cancelButton;
    private String originalName;

    public ActionRename() {
        super("renameIcon.png");
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename selected node");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F6, ActionEvent.ALT_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        initDialog();
        initListeners();

        MapNode mapNode = ((MapTreeItem) MainFrame.getInstance().getMapTreeView().getLastSelectedPathComponent()).getModel();
        String name = mapNode.getName();
        originalName = name;

        textField.setText(name);
        textField.setEditable(true);

        dialog.setVisible(true);
    }

    private void initDialog(){
        dialog = new BasicDialog(MainFrame.getInstance(), "Rename", true, 200, 200);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBorder(new EmptyBorder(10,10,10,10));

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.setBorder(new EmptyBorder(10,10,10,10));

        textField = new JTextField();
        textField.setMaximumSize(new Dimension(180, 32));

        okButton = new JButton("Ok");
        okButton.setMaximumSize(new Dimension(60, 32));
        cancelButton = new JButton("Cancel");
        cancelButton.setMaximumSize(new Dimension(60, 32));

        buttonPanel.add(okButton);
        buttonPanel.add(Box.createHorizontalStrut(10));
        buttonPanel.add(cancelButton);

        mainPanel.add(textField);
        mainPanel.add(buttonPanel);

        dialog.add(mainPanel);
    }

    private void initListeners(){
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {
                updateNodeName(textField.getText());
            }
        });
        okButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dialog.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        cancelButton.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                MapNode mapNode = ((MapTreeItem) MainFrame.getInstance().getMapTreeView().getLastSelectedPathComponent()).getModel();
                mapNode.setName(originalName);
                mapNode.notifySubscribers(originalName, NotificationType.NAMECHANGE);
                dialog.dispose();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
    }

    private void updateNodeName(String name){

        MapNode mapNode = ((MapTreeItem) MainFrame.getInstance().getMapTreeView().getLastSelectedPathComponent()).getModel();
        mapNode.setName(name);
        mapNode.notifySubscribers(name, NotificationType.NAMECHANGE);

    }
}
