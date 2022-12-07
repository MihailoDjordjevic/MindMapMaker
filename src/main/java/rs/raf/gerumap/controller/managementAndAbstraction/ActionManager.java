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
    private ActionZoomIn actionZoomIn;
    private ActionZoomOut actionZoomOut;

    private ActionAddTermState actionAddTermState;
    private ActionDeleteState actionDeleteState;
    private ActionLinkElementsState actionLinkElementsState;
    private ActionMoveState actionMoveState;
    private ActionSelectState actionSelectState;
    private ActionEditElementProperties actionEditElementProperties;

    public ActionManager(){
        actionNew = new ActionNew();
        actionInfo = new ActionInfo();
        actionNewProject = new ActionNewProject();
        actionNewMindMap = new ActionNewMindMap();
        actionDelete = new ActionDelete();
        actionNewTerm = new ActionNewTerm();
        actionRename = new ActionRename();
        actionSetAuthor = new ActionSetAuthor();
        actionZoomIn = new ActionZoomIn();
        actionZoomOut = new ActionZoomOut();

        actionAddTermState = new ActionAddTermState();
        actionDeleteState = new ActionDeleteState();
        actionLinkElementsState = new ActionLinkElementsState();
        actionMoveState = new ActionMoveState();
        actionSelectState = new ActionSelectState();
        actionEditElementProperties = new ActionEditElementProperties();
    }
}
