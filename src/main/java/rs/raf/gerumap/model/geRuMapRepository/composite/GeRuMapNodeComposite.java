package rs.raf.gerumap.model.geRuMapRepository.composite;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class GeRuMapNodeComposite extends GeRuMapNode {
    private List<GeRuMapNode> children;

    public GeRuMapNodeComposite(final String name, final GeRuMapNode parent, final ArrayList<GeRuMapNode> children) {
        super(name, parent);
        this.children = children;
    }
    public GeRuMapNodeComposite(final String name, final GeRuMapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public abstract void addChild(final GeRuMapNode child);
    public abstract void deleteChild(final GeRuMapNode child);

    public GeRuMapNode getChildByName(final String name) {
        for (GeRuMapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }
}