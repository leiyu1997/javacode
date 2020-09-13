package com.leiyu.algo.tree.BreadthFirstSearch;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.tree.ParentTravel;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先遍历
 */
public class BreadthFirstSearch implements ParentTravel {

    @Override
    public void travel(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            System.out.print(temp.val + ",");
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
        }
    }
}
