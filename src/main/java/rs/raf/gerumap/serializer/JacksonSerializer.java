package rs.raf.gerumap.serializer;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.io.FileUtils;
import rs.raf.gerumap.Main;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.core.ApplicationFramework;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.composite.MapNode;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.tree.view.MapTreeView;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class JacksonSerializer implements ISerializer{

    @Override
    public void saveProject() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        Project project = MainFrame.getInstance().getCurrentProjectView().getProject();
        File exportFile = new File("export/project.json");
        exportFile.getParentFile().mkdirs();
        try {
            exportFile.createNewFile();
            if(project != null){
                objectMapper.writeValue(new File("export/project.json"), project);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void loadProject() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);
        try {
            Project project = objectMapper.readValue(new File("export/project.json"), Project.class);
            project.printAllChildren();
            project.setChildrenParents();
            System.out.println("-----------------");
            project.printAllChildren();
            ApplicationFramework.getInstance().getIMapRepository().getProjectExplorer().addChild(project);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
