package com.leiyu.algo.tree.DepthFirstSerach;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.tree.ParentTravel;


/**
 * 前序遍历
 */
public class PreTravel implements ParentTravel {

    @Override
    public void travel(TreeNode root) {
        System.out.print(root.val + ",");
        if (root.left != null) travel(root.left);
        if (root.right != null) travel(root.right);
    }
}
