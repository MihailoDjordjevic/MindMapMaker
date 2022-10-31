package rs.raf.gerumap.model.geRuMapRepository.implementation;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNodeComposite;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode;
@Getter
@Setter
@NoArgsConstructor
public class ProjectExplorer extends GeRuMapNodeComposite {
    private String name;
    public ProjectExplorer(String name){
        this.name = name;
    }
    @Override
    public void addChild(GeRuMapNode child) {

    }

    @Override
    public void deleteChild(GeRuMapNode child) {
        
    }
}
