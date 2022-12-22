package rs.raf.gerumap.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import rs.raf.gerumap.centralizedProjectView.MindMapView;
import rs.raf.gerumap.globalView.frame.MainFrame;
import rs.raf.gerumap.model.repository.implementation.Project;
import rs.raf.gerumap.tree.view.MapTreeView;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JacksonSerializer implements ISerializer{

    @Override
    public void serialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        Project project = MainFrame.getInstance().getCurrentProjectView().getProject();
        try {
            objectMapper.writeValue(new File("export/project.json"), project);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deserialize() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Project project = objectMapper.readValue(new File("src/test/resources/json_car.json"), Project.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
