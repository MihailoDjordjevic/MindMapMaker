package rs.raf.gerumap.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class ActionManager {

    private ActionNew actionNew;
    private ActionInfo actionInfo;
    private ActionNewProject actionNewProject;
    private ActionNewMindMap actionNewMindMap;
    private ActionDelete actionDelete;
    private ActionNewElement actionNewElement;
    public ActionManager(){
        actionNew = new ActionNew();
        actionInfo = new ActionInfo();
        actionNewProject = new ActionNewProject();
        actionNewMindMap = new ActionNewMindMap();
        actionDelete = new ActionDelete();
        actionNewElement = new ActionNewElement();
    }
}
