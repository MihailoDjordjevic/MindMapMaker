package rs.raf.gerumap.model.repository.implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.composite.MapNode;
@Getter
@Setter
@NoArgsConstructor
public class ProjectExplorer extends MapNodeComposite {
    private String name;
    public ProjectExplorer(String name){
        this.name = name;
    }
    @Override
    public void addChild(MapNode child) {

    }

    @Override
    public void deleteChild(MapNode child) {
        
    }
}
