package com.company.bst;

public class isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBSTRecur(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBSTRecur(TreeNode root, long min, long max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        return isValidBSTRecur(root.left, min, root.val)
                && isValidBSTRecur(root.right, root.val, max);
    }

}
