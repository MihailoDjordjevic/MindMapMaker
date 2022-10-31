package rs.raf.gerumap.model.geRuMapRepository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNodeComposite;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeRuMapNode extends GeRuMapNodeComposite {
    private boolean isTemplate;
    @Override
    public void addChild(final rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode child) {

    }

    @Override
    public void deleteChild(final rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode child) {

    }
}
