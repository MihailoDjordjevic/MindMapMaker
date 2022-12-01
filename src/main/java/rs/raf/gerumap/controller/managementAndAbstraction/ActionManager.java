package rs.raf.gerumap.controller.managementAndAbstraction;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.controller.editorChangeStateActions.*;
import rs.raf.gerumap.controller.globalActions.*;

@Getter
@Setter
public class ActionManager {

    private ActionNew actionNew;
    private ActionInfo actionInfo;
    private ActionNewProject actionNewProject;
    private ActionNewMindMap actionNewMindMap;
    private ActionDelete actionDelete;
    private ActionNewTerm actionNewTerm;
    private ActionRename actionRename;
    private ActionSetAuthor actionSetAuthor;

    private ActionAddTermState actionAddTermState;
    private ActionDeleteState actionDeleteState;
    private ActionLinkElementsState actionLinkElementsState;
    private ActionMoveState actionMoveState;
    private ActionSelectState actionSelectState;

    public ActionManager(){
        actionNew = new ActionNew();
        actionInfo = new ActionInfo();
        actionNewProject = new ActionNewProject();
        actionNewMindMap = new ActionNewMindMap();
        actionDelete = new ActionDelete();
        actionNewTerm = new ActionNewTerm();
        actionRename = new ActionRename();
        actionSetAuthor = new ActionSetAuthor();

        actionAddTermState = new ActionAddTermState();
        actionDeleteState = new ActionDeleteState();
        actionLinkElementsState = new ActionLinkElementsState();
        actionMoveState = new ActionMoveState();
        actionSelectState = new ActionSelectState();
    }
}
