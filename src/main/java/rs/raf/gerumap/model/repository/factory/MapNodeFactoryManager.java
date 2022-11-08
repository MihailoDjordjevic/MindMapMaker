package rs.raf.gerumap.model.repository.factory;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.MindMap;

public class MapNodeFactoryManager {
    public static MapNodeFactory getMapNodeFactory(final MapNode parent) {
        if(parent instanceof Element){
            return new ElementFactory();
        }
        else if(parent instanceof MindMap){
            return new MindMapFactory();
        }
        else{
            return new ProjectFactory();
        }
    }
}