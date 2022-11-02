package rs.raf.gerumap.model.repository.implementation;

import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.observer.ISubscriber;

public class Element extends MapNode {

    public Element(String name, MapNode parent) {
        super(name, parent);
    }

}
