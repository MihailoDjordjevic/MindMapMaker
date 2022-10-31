package rs.raf.gerumap.model.repository.composite;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class MapNodeComposite extends MapNode {
    private List<MapNode> children;

    public MapNodeComposite(final String name, final MapNode parent, final ArrayList<MapNode> children) {
        super(name, parent);
        this.children = children;
    }
    public MapNodeComposite(final String name, final MapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public abstract void addChild(final MapNode child);
    public abstract void deleteChild(final MapNode child);

    public MapNode getChildByName(final String name) {
        for (MapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }
}