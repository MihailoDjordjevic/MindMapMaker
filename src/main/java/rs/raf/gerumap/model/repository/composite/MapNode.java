package rs.raf.gerumap.model.repository.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.observer.IPublisher;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class MapNode implements IPublisher {
    private String name;
    private MapNode parent;

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof MapNode) {
            MapNode otherObj = (MapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
}