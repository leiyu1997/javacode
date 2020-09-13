package com.leiyu.algo.tree.BreadthFirstSearch;

import com.leiyu.algo.node.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

public class PrintTravel {
    public void travel(TreeNode root, int depth) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        for (; !queue.isEmpty(); depth--) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                System.out.print(printSpace(depth, i) + temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            System.out.println();
        }
    }

    private String printSpace(int depth, int pos) {
        int num = (int) Math.pow(2, depth);
        if (pos == 0) num /= 2;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < num; i++) {
            res.append("\t");
        }
        return res.toString();
    }
}
