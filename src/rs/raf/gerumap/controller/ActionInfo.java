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

        addDeveloperInfo(jDialog);

        jDialog.setVisible(true);
    }

    private void addDeveloperInfo(BasicDialog jDialog){

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new GridLayout(4, 2, 2, 1));

        JLabel jLabelIme = new JLabel("Ime: Lazar");
        JLabel jLabelPrezime = new JLabel("Prezime: Bojanic");
        JLabel jLabelIndeks = new JLabel("Indeks: 116/21/RN");
        JLabel jLabelSlika = new JLabel("Slika:");

        JLabel jLabelIme2 = new JLabel("Ime: Mihailo");
        JLabel jLabelPrezime2 = new JLabel("Prezime: Djordjevic");
        JLabel jLabelIndeks2 = new JLabel("Indeks: 30/20/RN");
        JLabel jLabelSlika2 = new JLabel("Slika:");

        JLabel jLabelSlikaContent = new JLabel(new ImageIcon(new ImageIcon("src/rs/raf/gerumap/assets/dev1.jpg").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT)));
        JLabel jLabelSlikaContent2 = new JLabel(new ImageIcon(new ImageIcon("src/rs/raf/gerumap/assets/dev2.png").getImage().getScaledInstance(-1, 100, Image.SCALE_DEFAULT)));


        jPanel.add(jLabelIme); jPanel.add(jLabelIme2);
        jPanel.add(jLabelPrezime); jPanel.add(jLabelPrezime2);
        jPanel.add(jLabelIndeks); jPanel.add(jLabelIndeks2);
        jPanel.add(jLabelSlikaContent); jPanel.add(jLabelSlikaContent2);

        jDialog.add(jPanel);
    }
}