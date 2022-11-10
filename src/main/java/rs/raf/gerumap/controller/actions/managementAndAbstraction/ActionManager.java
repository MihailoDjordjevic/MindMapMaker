package rs.raf.gerumap.controller.actions.managementAndAbstraction;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.controller.actions.*;

@Getter
@Setter
public class ActionManager {

    private ActionNew actionNew;
    private ActionInfo actionInfo;
    private ActionNewProject actionNewProject;
    private ActionNewMindMap actionNewMindMap;
    private ActionDelete actionDelete;
    private ActionNewElement actionNewElement;
    private ActionRename actionRename;
    private ActionSetAuthor actionSetAuthor;
    public ActionManager(){
        actionNew = new ActionNew();
        actionInfo = new ActionInfo();
        actionNewProject = new ActionNewProject();
        actionNewMindMap = new ActionNewMindMap();
        actionDelete = new ActionDelete();
        actionNewElement = new ActionNewElement();
        actionRename = new ActionRename();
        actionSetAuthor = new ActionSetAuthor();
    }
}
