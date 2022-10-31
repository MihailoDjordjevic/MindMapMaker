package rs.raf.gerumap.model.geRuMapRepository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.core.IGeRuMapRepository;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNodeComposite;
import rs.raf.gerumap.model.geRuMapRepository.implementation.ProjectExplorer;

public class GeRuMapRepositoryImplementation implements IGeRuMapRepository {
    private ProjectExplorer projectExplorer;

    public GeRuMapRepositoryImplementation(){
        projectExplorer = new ProjectExplorer("New Project Explorer");
    }
    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(GeRuMapNodeComposite parent, GeRuMapNode child) {

    }
}
