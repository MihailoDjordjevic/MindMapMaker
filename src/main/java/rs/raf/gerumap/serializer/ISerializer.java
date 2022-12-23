package rs.raf.gerumap.serializer;

import rs.raf.gerumap.model.repository.implementation.MindMap;

import java.io.File;
import java.nio.file.Path;
import java.util.UUID;

public interface ISerializer {
    void saveProject(File mindMapTemplate);
    void loadProject(File mindMapTemplate);
    void saveMindMapTemplate(File sourceMindMapTemplate);
    void loadMindMapTemplate(File destinationMindMapTemplate);
}
