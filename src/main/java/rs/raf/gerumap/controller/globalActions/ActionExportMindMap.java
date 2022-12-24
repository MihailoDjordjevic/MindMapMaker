package rs.raf.gerumap.controller.globalActions;

import rs.raf.gerumap.centralizedProjectView.MindMapView;
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
        putValue(NAME, "Export Mind Map");
        putValue(SHORT_DESCRIPTION, "Export Mind Map as Image");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_J, ActionEvent.CTRL_MASK));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        double savedZoom = ((MindMapView) ((JScrollPane) MainFrame.getInstance().getCurrentProjectView().getSelectedComponent()).getViewport().getView()).getMindMap().getSavedZoom();

        int width = (int) (3000 * savedZoom);
        int height = (int) (2000 * savedZoom);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        ((JScrollPane) MainFrame.getInstance().getCurrentProjectView().getSelectedComponent()).getViewport().getView().paint(graphics2D);
        graphics2D.dispose();
        try {
            ImageIO.write(bufferedImage, "png", new File("export/mindMap.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}