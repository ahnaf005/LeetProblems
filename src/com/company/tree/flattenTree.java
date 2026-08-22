package com.company.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class flattenTree {
    public void flatten(TreeNode root) {
        flattenTree(root);
    }

    TreeNode flattenTree1(TreeNode node) {
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

    List<TreeNode> list = new ArrayList<>();
    TreeNode flattenTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        preOrder(root);
        for(int i =0; i < list.size()-1; i++){
            TreeNode node = list.get(i);
            node.left = null;
            node.right = list.get(i+1);
        }
        TreeNode node = list.get(list.size()-1);
        node.left = null;
        node.right = null;
        return list.get(0);
    }
    void preOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        list.add(node);
        preOrder(node.left);
        preOrder(node.right);
    }
}
