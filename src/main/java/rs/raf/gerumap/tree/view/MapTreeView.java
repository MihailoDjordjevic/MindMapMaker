package rs.raf.gerumap.tree.view;

import lombok.Getter;
import lombok.Setter;
import rs.raf.gerumap.tree.controller.MapTreeCellEditor;
import rs.raf.gerumap.tree.controller.MapTreeSelectionListener;
import rs.raf.gerumap.tree.controller.MapTreeViewMouseListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

@Getter
@Setter
public class MapTreeView extends JTree {
    public MapTreeView(DefaultTreeModel defaultTreeModel){

        setModel(defaultTreeModel);

        MapTreeCellRenderer ruTreeCellRenderer = new MapTreeCellRenderer();
        setCellEditor(new MapTreeCellEditor(this, ruTreeCellRenderer));

        addTreeSelectionListener(new MapTreeSelectionListener());

        setCellRenderer(ruTreeCellRenderer);
        setEditable(true);

        addMouseListener(new MapTreeViewMouseListener());
    }

    public void expandSelectedNode(){
        expandPath(getSelectionPath());
    }
}