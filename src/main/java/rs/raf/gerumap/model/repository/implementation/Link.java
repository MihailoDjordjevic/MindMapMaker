package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

@Getter
@Setter
public class Link extends Element{

    private Term sourceTerm;
    private Term destinationTerm;

    public Link(String name, MapNode parent) {
        super(name, parent);
    }

}
