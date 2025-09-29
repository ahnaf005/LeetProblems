package com.company.tree;

import java.util.HashMap;
import java.util.Map;

public class buildTreePostOrder {
    int postOrderIndex;
    Map<Integer,Integer> inOrderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length - 1;
        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return arrayToTree(postorder, 0 , inorder.length -1 );
    }

    TreeNode arrayToTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(
                postorder,
                left,
                inOrderIndexMap.get(rootValue) - 1
        );
        root.right = arrayToTree(
                postorder,
                inOrderIndexMap.get(rootValue) + 1,
                right
        );
        return root;
    }
}
