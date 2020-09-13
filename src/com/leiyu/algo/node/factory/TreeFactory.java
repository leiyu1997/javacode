package com.leiyu.algo.node.factory;


import com.leiyu.algo.node.TreeNode;

import java.util.Random;

public class TreeFactory {
    static Random random = new Random();
    static int range;

    public static TreeNode getTree(int depth) {
        if (depth <= 0) return null;
        range = (int) Math.pow(2, depth) * 5;
        TreeNode root = new TreeNode(random.nextInt(range));
        travelSetTree(root, depth);
        return root;
    }

    private static void travelSetTree(TreeNode node, int maxDepth) {
        if (maxDepth <= 1) return;
        node.left = new TreeNode(random.nextInt(range));
        travelSetTree(node.left, maxDepth - 1);
        node.right = new TreeNode(random.nextInt(range));
        travelSetTree(node.right, maxDepth - 1);
    }
}
