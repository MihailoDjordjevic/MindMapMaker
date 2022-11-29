package rs.raf.gerumap.mindMapEditor;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.mindMapEditor.editorState.*;

@Getter
@Setter
public class StateManager {

    private IState currentState;

    private AddTermState addTermState;
    private LinkElementsState linkElementsState;
    private DeleteState deleteState;
    private MoveState moveState;
    private SelectState selectState;


    public StateManager() {

        currentState = selectState;   //default state on startup
        initStates();

    }

    private void initStates(){
        addTermState = new AddTermState();
        linkElementsState = new LinkElementsState();
        deleteState = new DeleteState();
        moveState = new MoveState();
        selectState = new SelectState();
    }

    public void setAddTermState(){
        currentState = addTermState;
    }

    public void setDeleteState(){
        currentState = deleteState;
    }

    public void setLinkElementsState(){
        currentState = linkElementsState;
    }

    public void setMoveState(){
        currentState = moveState;
    }

    public void setSelectState(){
        currentState = selectState;
    }
}
