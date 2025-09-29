package com.company.tree;

import java.util.ArrayList;
import java.util.List;

class BSTIterator {

    List<TreeNode> list;
    int index;
    public BSTIterator(TreeNode root) {
        list = new ArrayList<>();
        index = 0;
        if(root!=null){
            inOrderTraverse(root);
        }
    }

    private void inOrderTraverse(TreeNode node){
        if(node.left!= null) {
            inOrderTraverse(node.left);
        }
        list.add(node);
        if(node.right!=null){
            inOrderTraverse(node.right);
        }
    }
    public int next() {
        return list.get(index++).val;
    }

    public boolean hasNext() {
        return index < list.size();
    }
}
