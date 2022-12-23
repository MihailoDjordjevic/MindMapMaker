package rs.raf.gerumap.serializer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import rs.raf.gerumap.Main;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.MindMap;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.model.repository.implementation.Term;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

public class JacksonSerializer implements ISerializer{

    @Override
    public void saveProject(File mindMapTemplate) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        Project project = MainFrame.getInstance().getCurrentProjectView().getProject();
        mindMapTemplate.getParentFile().mkdirs();
        try {
            mindMapTemplate.createNewFile();
            if(project != null){
                objectMapper.writeValue(mindMapTemplate, project);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void loadProject(File mindMapTemplate) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        try {
            Project project = objectMapper.readValue(mindMapTemplate, Project.class);
            project.setParent(ApplicationFramework.getInstance().getIMapRepository().getProjectExplorer());
            project.setChildrenParents();
            ApplicationFramework.getInstance().getIMapRepository().getProjectExplorer().addChild(project);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveMindMapTemplate(File mindMapTemplate) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        MindMapView mindMapView = (MindMapView) ((JScrollPane) MainFrame.getInstance().getCurrentProjectView().getSelectedComponent()).getViewport().getView();
        MindMap currentMindMap = mindMapView.getMindMap();
        mindMapTemplate.getParentFile().mkdirs();
        try {
            mindMapTemplate.createNewFile();
            if(currentMindMap != null){
                objectMapper.writeValue(mindMapTemplate, currentMindMap);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void loadMindMapTemplate(File mindMapTemplate) {
        MindMapView mindMapView = (MindMapView) ((JScrollPane) MainFrame.getInstance().getCurrentProjectView().getSelectedComponent()).getViewport().getView();
        MindMap currentMindMap = mindMapView.getMindMap();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        try {
            MindMap mindMap = objectMapper.readValue(mindMapTemplate, MindMap.class);
            mindMap.setChildrenParents();

            currentMindMap.mergeMindMaps(mindMap);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SwingUtilities.updateComponentTreeUI(mindMapView);
    }
}
