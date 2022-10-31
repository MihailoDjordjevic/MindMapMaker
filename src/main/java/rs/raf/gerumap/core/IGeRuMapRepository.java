package rs.raf.gerumap.core;

import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNodeComposite;
import rs.raf.gerumap.model.geRuMapRepository.implementation.ProjectExplorer;

public interface IGeRuMapRepository {
    ProjectExplorer getProjectExplorer();
    void addChild(GeRuMapNodeComposite parent, GeRuMapNode child);
}
