package rs.raf.gerumap.model.repository;

import rs.raf.gerumap.core.IMapRepository;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.composite.MapNodeComposite;
import rs.raf.gerumap.model.repository.implementation.ProjectExplorer;

public class MapRepositoryImplementation implements IMapRepository {
    private ProjectExplorer projectExplorer;

    public MapRepositoryImplementation(){
        projectExplorer = new ProjectExplorer("New Project Explorer");
    }
    @Override
    public ProjectExplorer getProjectExplorer() {
        return projectExplorer;
    }

    @Override
    public void addChild(MapNodeComposite parent, MapNode child) {

    }
}
