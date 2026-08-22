package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

public class countNodes {
    public int countNodes2(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int count = 0 ;
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            count += size;
            for(int i=0;i<size;i++){
                TreeNode node = queue.poll();
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }

        }
        return count;
    }

    public int countNodes(TreeNode root) {
        // Base case: empty tree has 0 nodes
        if (root == null) {
            return 0;
        }

        // Find height of left subtree (leftmost path)
        // This takes O(log n) time in a complete binary tree
        int leftHeight = 0;
        TreeNode leftNode = root;
        while (leftNode != null) {
            leftHeight++;
            leftNode = leftNode.left;
        }

        // Find height of right subtree (rightmost path)
        // This also takes O(log n) time
        int rightHeight = 0;
        TreeNode rightNode = root;
        while (rightNode != null) {
            rightHeight++;
            rightNode = rightNode.right;
        }

        // If perfect binary tree (all levels filled)
        // We can compute the exact number of nodes using the formula 2^h - 1
        if (leftHeight == rightHeight) {
            return (1 << leftHeight) - 1;  // 2^height - 1
        }

        // Otherwise, recursively count nodes in left and right subtrees
        // This creates at most O(log n) recursive calls in the worst case
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}
