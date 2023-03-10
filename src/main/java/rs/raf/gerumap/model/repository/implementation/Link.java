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

    private long sourceTermHash;
    private long destinationTermHash;

    public Link(String name, MapNode parent, MapNode destination) {
        super(name, parent);

        thickness = 3;
        borderColor = Color.BLACK.getRGB();

        setSourceTerm((Term) parent);
        setDestinationTerm((Term) destination);

        setName("with");
    }
    public Link(){
    }

    public void setSourceTerm(Term sourceTerm) {
        this.sourceTerm = sourceTerm;
        this.sourceTermHash = sourceTerm.getHashValue();
    }

    public void setDestinationTerm(Term destinationTerm) {
        this.destinationTerm = destinationTerm;
        this.destinationTermHash = destinationTerm.getHashValue();
    }

    @Override
    public String toString() {
        return sourceTerm + " " + getName() + " " + destinationTerm;
    }
}
