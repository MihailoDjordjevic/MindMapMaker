package rs.raf.gerumap.tree.view;

import lombok.NoArgsConstructor;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.model.repository.implementation.ProjectExplorer;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

@NoArgsConstructor
public class MapTreeCellRenderer extends DefaultTreeCellRenderer {

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {

            super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
            URL imageURL = null;

            if (((MapTreeItem) value).getModel() instanceof ProjectExplorer) {
                imageURL = getClass().getResource("projectExplorer.png");
            } else if (((MapTreeItem) value).getModel() instanceof Project) {
                imageURL = getClass().getResource("newProject.png");
            } else if (((MapTreeItem) value).getModel() instanceof MindMap) {
                imageURL = getClass().getResource("/rs/raf/gerumap/controller/actions/newMindMap.png");
            } else if (((MapTreeItem) value).getModel() instanceof Element) {
                imageURL = getClass().getResource("elementIcon.png");
            }

            Icon icon;
            if (imageURL != null){
                icon = new ImageIcon(imageURL);
            setIcon(icon);
            } else {
                System.err.println("Resource not found: " + value.getClass());
            }

            this.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    System.out.println("right click");
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

            return this;
        }

}


