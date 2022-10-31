package rs.raf.gerumap.tree;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.model.repository.implementation.ProjectExplorer;
import rs.raf.gerumap.tree.model.MapTreeItem;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

import java.util.Random;

public class MapTreeImplementation implements MapTree{
    private MapTreeView mapTreeView;
    private DefaultTreeModel defaultTreeModel;
    @Override
    public MapTreeView generateTree(ProjectExplorer projectExplorer) {
        MapTreeItem root = new MapTreeItem(projectExplorer);
        defaultTreeModel = new DefaultTreeModel(root);
        mapTreeView = new MapTreeView(defaultTreeModel);
        return mapTreeView;
    }

    @Override
    public void addChild(MapTreeItem parent) {
        if (!(parent.getMapNode() instanceof MapNodeComposite)){
            return;
        }
        MapNode child = createChild(parent.getMapNode());
        parent.add(new MapTreeItem(child));
        ((MapNodeComposite) parent.getMapNode()).addChild(child);
        mapTreeView.expandPath(mapTreeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(mapTreeView);
    }
    private MapNode createChild(MapNode parent) {
        if (parent instanceof ProjectExplorer){
            return new Project("Project" + new Random().nextInt(100), parent);
        }
        return null;
    }
    @Override
    public MapTreeItem getSelectedNode() {
        return null;
    }
}