package rs.raf.gerumap.controller;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
public class ActionManager {
    private ActionNew actionNew;
    private ActionInfo actionInfo;
    public ActionManager(){
        actionNew = new ActionNew();
        actionInfo = new ActionInfo();
    }
}
