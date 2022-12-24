package rs.raf.gerumap.controller.globalActions;

import rs.raf.gerumap.controller.managementAndAbstraction.AbstractMapAction;
import rs.raf.gerumap.globalView.frame.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ActionExportMindMap extends AbstractMapAction {

    public ActionExportMindMap() {
        super("exportMindMap.png");
        putValue(NAME, "Export Mind Map Image");
        putValue(SHORT_DESCRIPTION, "Export Mind Map as Image");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int width = MainFrame.getInstance().getWorkspacePanel().getWidth();
        int height = MainFrame.getInstance().getWorkspacePanel().getHeight();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        MainFrame.getInstance().getWorkspacePanel().paint(graphics2D);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("export/mindMap.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}