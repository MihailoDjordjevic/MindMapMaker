package rs.raf.gerumap.model.geRuMapRepository.composite;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public abstract class GeRuMapComposite extends GeRuMapNode {
    private List<GeRuMapNode> children;

    public GeRuMapComposite(String name, GeRuMapNode parent) {
        super(name, parent);
        this.children = new ArrayList<>();
    }

    public GeRuMapComposite(String name, GeRuMapNode parent, ArrayList<GeRuMapNode> children) {
        super(name, parent);
        this.children = children;
    }

    public abstract void addChild(GeRuMapNode child);
    public abstract void deleteChild(GeRuMapNode child);

    public GeRuMapNode getChildByName(String name) {
        for (GeRuMapNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }
}