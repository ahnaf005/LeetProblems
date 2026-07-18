package com.company.bst;

import java.util.ArrayList;
import java.util.List;

public class kthSmallest {
    List<Integer> array;
    public int kthSmallest(TreeNode root, int k) {
        array = new ArrayList<>();
        inOrder(root);
        return array.get(k-1);
    }

    public void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        array.add(root.val);
        inOrder(root.right);
    }
}
