package com.company.tree;

public class maxSumTree {
    private int max;
    public int maxPathSum(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        dfs(root);
        return this.max;
    }

    private boolean isLeaf(TreeNode node) {
        return (node.left == null) && (node.right == null);
    }

    // Returns highest sum possible with this node in mind, starting at "node"
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHighestSum = Math.max(0, dfs(root.left)); // ignore negative
        int rightHighestSum = Math.max(0, dfs(root.right));

        int sumWithNode = leftHighestSum + root.val + rightHighestSum;
        this.max = Math.max(this.max, sumWithNode);

        return Math.max(leftHighestSum, rightHighestSum) + root.val;
    }
}
