package com.company.tree;

import java.util.HashMap;
import java.util.Map;

public class buildTree {
    int preOrderIndex;
    Map<Integer,Integer>inOrderIndexMap = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preOrderIndex = 0;
        for(int i=0;i<inorder.length;i++){
            inOrderIndexMap.put(inorder[i],i);
        }
        return arrayToTree(preorder, 0 , preorder.length -1 );
    }

    TreeNode arrayToTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        // select the preorder_index element as the root and increment it
        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        // build left and right subtree
        // excluding inorderIndexMap[rootValue] element because it's the root
        root.left = arrayToTree(
                preorder,
                left,
                inOrderIndexMap.get(rootValue) - 1
        );
        root.right = arrayToTree(
                preorder,
                inOrderIndexMap.get(rootValue) + 1,
                right
        );
        return root;
    }
}
