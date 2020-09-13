package com.leiyu.algo.tree.BreadthFirstSearch;

import com.leiyu.algo.node.TreeNode;
import com.leiyu.algo.tree.ParentTravel;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 树的层次遍历
 */
public class LevelTravel implements ParentTravel {
    @Override
    public void travel(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(temp.val + "\t\t");
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }
}
