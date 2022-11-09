package rs.raf.gerumap.tree.model.treeNodeFactory;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.tree.model.ElementTreeItem;
import rs.raf.gerumap.tree.model.MindMapTreeItem;
import rs.raf.gerumap.tree.model.ProjectTreeItem;
import rs.raf.gerumap.tree.model.abstraction.MapTreeItem;

public class SimpleTreeNodeFactory {

    public static MapTreeItem getNode(MapNode mapNode){

        switch (mapNode.getClass().getSimpleName()){
            case "Project": return new ProjectTreeItem(mapNode);
            case "MindMap": return new MindMapTreeItem(mapNode);
            case "Element": return new ElementTreeItem(mapNode);

        }
        return null;
    }

}
