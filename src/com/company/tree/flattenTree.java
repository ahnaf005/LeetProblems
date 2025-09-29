package com.company.tree;

public class flattenTree {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }

        // For a leaf node, we simply return the
        // node as is.
        if (node.left == null && node.right == null) {
            return node;
        }
        TreeNode leftTail = flattenTree(node.left);
        TreeNode rightTail = flattenTree(node.right);
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        return rightTail == null? leftTail: rightTail;
    }
}
