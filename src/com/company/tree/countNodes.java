package com.company.tree;

import java.util.LinkedList;
import java.util.Queue;

public class countNodes {
    public int countNodes(TreeNode root) {
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
}
