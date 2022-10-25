package rs.raf.gerumap.model.geRuMapRepository.implementation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapComposite;
import rs.raf.gerumap.model.geRuMapRepository.composite.GeRuMapNode;

import java.nio.file.Path;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Project extends GeRuMapComposite {
    private String name;
    private String author;
    private Path resourcesPath;
    @Override
    public void addChild(GeRuMapNode child) {

    }

    @Override
    public void deleteChild(GeRuMapNode child) {

    }

}
