package rs.raf.gerumap.controller;

import com.sun.tools.javac.Main;

import javax.swing.*;
import java.net.URL;

public abstract class AbstractGeRuMapAction extends AbstractAction {
    public AbstractGeRuMapAction(String fileName) {
        putValue(SMALL_ICON, loadIcon(fileName));
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