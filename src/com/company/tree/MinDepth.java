package com.company.tree;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepthRec(root, 1);
    }

    public int minDepthRec(TreeNode node, int depth) {
        if (node == null) {
            return Integer.MAX_VALUE;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.min(minDepthRec(node.left, depth + 1), minDepthRec(node.right, depth + 1));
    }
}
