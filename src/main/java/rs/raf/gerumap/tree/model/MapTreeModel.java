package rs.raf.gerumap.tree.model;

import rs.raf.gerumap.model.repository.implementation.Project;

import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;

public class MapTreeModel extends DefaultTreeModel {
    public MapTreeModel(TreeNode root) {
        super(root);
    }
    public MapTreeModel(TreeNode root, boolean asksAllowsChildren) {
        super(root, asksAllowsChildren);
    }
    @Override
    public Object getRoot() {
        return super.getRoot();
    }
}