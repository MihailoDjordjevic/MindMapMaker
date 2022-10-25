package rs.raf.gerumap.model.geRuMapRepository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapComposite;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeRuMap extends GeRuMapComposite {
    private boolean isTemplate;
    @Override
    public void addChild(GeRuMapNode child) {

    }

    @Override
    public void deleteChild(GeRuMapNode child) {

    }
}
