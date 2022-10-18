package rs.raf.gerumap.controller;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGeRuMapAction extends AbstractAction {

    public AbstractGeRuMapAction(String imgUrl) {
        putValue(SMALL_ICON, loadIcon(imgUrl));
    }

    public Icon loadIcon(String fileName){

        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            icon = new ImageIcon(imageURL);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }
}
