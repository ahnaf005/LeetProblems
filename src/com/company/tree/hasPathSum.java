package com.company.tree;

public class hasPathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return root.val == targetSum;
        }
        boolean leftTreeSum = false, rightTreeSum = false;
        if(root.left != null) {
            leftTreeSum = hasPathSum(root.left , targetSum - root.val);
        }
        if(root.right != null) {
            rightTreeSum = hasPathSum(root.right , targetSum - root.val);
        }
        return leftTreeSum || rightTreeSum;
    }
}
