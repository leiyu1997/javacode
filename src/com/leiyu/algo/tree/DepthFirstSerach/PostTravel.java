package com.leiyu.algo.tree.DepthFirstSerach;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.tree.ParentTravel;

public class PostTravel implements ParentTravel {
    @Override
    public void travel(TreeNode root) {
        if (root.left != null) travel(root.left);
        if (root.right != null) travel(root.right);
        System.out.print(root.val + ",");
    }
}
