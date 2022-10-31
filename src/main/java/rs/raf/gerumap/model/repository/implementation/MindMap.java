package rs.raf.gerumap.model.repository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MindMap extends MapNodeComposite {
    private boolean isTemplate;
    @Override
    public void addChild(final MapNode child) {

    }

    @Override
    public void deleteChild(final MapNode child) {

    }
}
