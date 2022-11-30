package rs.raf.gerumap.centralizedProjectView.selectionModel;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.centralizedProjectView.elementViewing.ElementPainter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SelectionModel {

    private ElementPainter singleSelectionElement;
    private ElementPainter secondarySelectionElement;
    private List<ElementPainter> multipleSelectionElements;

    public SelectionModel() {

        multipleSelectionElements = new ArrayList<>();
        singleSelectionElement = null;

    }

    public void setSingleSelectionElement(ElementPainter singleSelectionElement) {
        if (this.singleSelectionElement != null)
            this.singleSelectionElement.setSelected(false);

        this.singleSelectionElement = singleSelectionElement;

        if (this.singleSelectionElement != null)
            this.singleSelectionElement.setSelected(true);

    }

    public void setSecondarySelectionElement(ElementPainter secondarySelectionElement) {
        if (this.secondarySelectionElement != null)
            this.secondarySelectionElement.setSelected(false);

        this.secondarySelectionElement = secondarySelectionElement;

        if (this.secondarySelectionElement != null)
            this.secondarySelectionElement.setSelected(true);
    }
}
