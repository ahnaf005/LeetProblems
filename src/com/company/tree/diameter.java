package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

public class diameter {

    private int max;
    public int diameterOfBinaryTree(TreeNode root) {
        this.max = Integer.MIN_VALUE;
        dfs(root);
        return this.max;
    }

    // Returns highest sum possible with this node in mind, starting at "node"
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHighestSum = Math.max(0, dfs(root.left)); // ignore negative
        int rightHighestSum = Math.max(0, dfs(root.right));

        int sumWithNode = leftHighestSum + 1 + rightHighestSum;
        this.max = Math.max(this.max, sumWithNode);

        return Math.max(leftHighestSum, rightHighestSum) + 1;
    }
}
