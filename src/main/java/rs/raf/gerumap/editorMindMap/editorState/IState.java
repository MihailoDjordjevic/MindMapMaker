package rs.raf.gerumap.editorMindMap.editorState;

import rs.raf.gerumap.globalView.frame.MainFrame;

import java.awt.event.MouseEvent;

public interface IState {
    void mouseClickAction(Object event);

    void mouseDraggedAction(Object event);

    void mousePressedAction(Object event);

    void mouseReleasedAction(Object event);

    void mouseEnteredAction(Object event);

    void mouseExitedAction(Object event);

    void mouseMovedAction(Object event
    );

}
