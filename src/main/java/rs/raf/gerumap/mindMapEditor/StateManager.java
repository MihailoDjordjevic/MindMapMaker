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
        System.out.println("Editor state set to: add term");
    }

    public void setDeleteState(){
        currentState = deleteState;
        System.out.println("Editor state set to: delete");
    }

    public void setLinkElementsState(){
        currentState = linkElementsState;
        System.out.println("Editor state set to: link");
    }

    public void setMoveState(){
        currentState = moveState;
        System.out.println("Editor state set to: move");
    }

    public void setSelectState(){
        currentState = selectState;
        System.out.println("Editor state set to: select");
    }
}
