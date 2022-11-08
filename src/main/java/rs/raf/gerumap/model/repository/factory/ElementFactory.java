package rs.raf.gerumap.model.repository.factory;

import rs.raf.gerumap.model.repository.MapNodeTypes;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.Element;
import rs.raf.gerumap.model.repository.implementation.Project;

public class ElementFactory extends MapNodeFactory{
    @Override
    public MapNode createMapNode(MapNodeComposite parent) {
        return new Element("Element", parent);
    }
}