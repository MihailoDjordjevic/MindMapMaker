package rs.raf.gerumap.model.geRuMapRepository.composite;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class GeRuMapNode {
    private String name;
    private GeRuMapNode parent;

    @Override
    public boolean equals(final Object obj) {
        if (obj != null && obj instanceof GeRuMapNode) {
            GeRuMapNode otherObj = (GeRuMapNode) obj;
            return this.getName().equals(otherObj.getName());
        }
        return false;
    }
}