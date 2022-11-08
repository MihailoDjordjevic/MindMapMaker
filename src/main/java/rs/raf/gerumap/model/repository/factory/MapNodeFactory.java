package rs.raf.gerumap.model.repository.factory;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;

public abstract class MapNodeFactory {
    public abstract MapNode createMapNode(MapNodeComposite parent);
    public MapNode getMapNode(MapNodeComposite parent){
        MapNode mapNode = createMapNode(parent);
        parent.addChild(mapNode);
        mapNode.setName(mapNode.getName() + " " + (parent.getChildren().size() + 1));
        return mapNode;
    }
}