package rs.raf.gerumap.controller;

import rs.raf.gerumap.gui.dialog.BasicDialog;
import rs.raf.gerumap.gui.general.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActionInfo implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        BasicDialog jDialog = new BasicDialog(MainFrame.getInstance(), "Info", true, 400, 400);
        JPanel jPanel = new JPanel();
        GridLayout gridLayout = new GridLayout(4, 2, 2, 1);
        jPanel.setLayout(gridLayout);

        JLabel jLabelIme = new JLabel("Ime:");
        JLabel jLabelPrezime = new JLabel("Prezime:");
        JLabel jLabelIndeks = new JLabel("Indeks:");
        JLabel jLabelSlika = new JLabel("Slika:");

        JLabel jLabelImeContent = new JLabel("Lazar");
        JLabel jLabelPrezimeContent = new JLabel("Bojanic");
        JLabel jLabelIndeksContent = new JLabel("116/21/RN:");
        JLabel jLabelSlikaContent = new JLabel(new ImageIcon(new ImageIcon("D:\\JavaProjects\\gerumap-tim_lazarbojanic_mihailodordevic\\src\\rs\\raf\\gerumap\\assets\\linus.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));

        jPanel.add(jLabelIme); jPanel.add(jLabelImeContent);
        jPanel.add(jLabelPrezime); jPanel.add(jLabelPrezimeContent);
        jPanel.add(jLabelIndeks); jPanel.add(jLabelIndeksContent);
        jPanel.add(jLabelSlika); jPanel.add(jLabelSlikaContent);
        jDialog.add(jPanel);
        jDialog.setVisible(true);
    }
}