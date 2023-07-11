package com.company.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllNodeKDistance {
    Map<TreeNode,TreeNode>parentMap;
    Map<TreeNode,Boolean>visitedMap;
    List<Integer>resultValues;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        if( root==null) return new ArrayList<>();
        parentMap=new HashMap<>();
        parentMap.put(root,null);
        fixParent(root);
        resultValues=new ArrayList<>();
        visitedMap=new HashMap<>();
        traverseDistance(target,k);
        return resultValues;
    }

    public void fixParent(TreeNode node){
        if(node.left==null && node.right==null) return;
        if(node.left!=null){
            parentMap.put(node.left,node);
            fixParent(node.left);
        }
        if(node.right!=null){
            parentMap.put(node.right,node);
            fixParent(node.right);
        }
    }

    public void traverseDistance(TreeNode node,int k){
        visitedMap.put(node,true);
        if(k==0){
            resultValues.add(node.val);
            return;
        }
        if(node.left==null && node.right==null && parentMap.get(node) == null) return;
        if(node.left!=null && visitedMap.get(node.left)==null){
            traverseDistance(node.left,k-1);
        }
        if(node.right!=null && visitedMap.get(node.right)==null){
            traverseDistance(node.right,k-1);
        }
        if(parentMap.get(node)!=null && visitedMap.get(parentMap.get(node))==null){
            traverseDistance(parentMap.get(node),k-1);
        }
    }
}
