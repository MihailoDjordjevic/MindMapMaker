package rs.raf.gerumap.model.repository.implementation;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNode;

import java.awt.*;

@Getter
@Setter
public class Link extends MapNode{

    private int thickness;
    private int borderColor;

    private transient Term sourceTerm;
    private transient Term destinationTerm;

    public Link(String name, MapNode parent) {
        super(name, parent);

        thickness = 3;
        borderColor = Color.BLACK.getRGB();

        setName("with");
    }
    public Link(){
    }

    @Override
    public String toString() {
        return sourceTerm + " " + getName() + " " + destinationTerm;
    }
}
