package rs.raf.gerumap.tree.controller;

import rs.raf.gerumap.centralizedProjectView.ProjectView;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.tree.MapTree;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;
import rs.raf.gerumap.tree.view.MapTreeView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapTreeViewMouseListener implements MouseListener {
    private MapTreeItem mapTreeItem;
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2){

            MapNode mapNode = getModelOfCurrentlyOpeningTreeItem(e);

            if (mapNode instanceof Project){

                ProjectView projectView = new ProjectView((Project) mapNode);
                MainFrame.getInstance().displayProject(projectView, -1);

            } else if (mapNode instanceof MindMap){

                ProjectView projectView = new ProjectView((Project) mapNode.getParent());
                int nodeOrdinal = ((Project) mapNode.getParent()).getChildren().indexOf(mapNode);

                MainFrame.getInstance().displayProject(projectView, nodeOrdinal);

            } else if (mapNode instanceof Element){

                ProjectView projectView = new ProjectView((Project) mapNode.getParent().getParent());
                int nodeOrdinal = ((Project) mapNode.getParent().getParent()).getChildren().indexOf(mapNode.getParent());

                MainFrame.getInstance().displayProject(projectView, nodeOrdinal);

            }
        }
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

    private MapNode getModelOfCurrentlyOpeningTreeItem(MouseEvent e){

        MapTreeView mapTreeView = ((MapTreeView) e.getSource());
        mapTreeItem = (MapTreeItem) mapTreeView.getLastSelectedPathComponent();
        return mapTreeItem.getModel();

    }
}
