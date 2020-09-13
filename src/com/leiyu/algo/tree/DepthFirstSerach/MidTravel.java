package com.leiyu.algo.tree.DepthFirstSerach;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.tree.ParentTravel;

/**
 * 中序遍历
 */
public class MidTravel implements ParentTravel {
    @Override
    public void travel(TreeNode root) {
        if (root.left != null) travel(root.left);
        System.out.print(root.val + ",");
        if (root.right != null) travel(root.right);
    }
}
