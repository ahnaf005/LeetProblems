package com.company.tree;

public class maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return maxDepthRec(root, 1);
    }

    public int maxDepthRec(TreeNode node, int depth) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return depth;
        }
        return Math.max(maxDepthRec(node.left, depth + 1), maxDepthRec(node.right, depth + 1));
    }
}
