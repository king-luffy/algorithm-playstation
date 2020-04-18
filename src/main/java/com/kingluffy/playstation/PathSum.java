package com.kingluffy.playstation;

import com.kingluffy.playstation.base.TreeNode;

/**
 * No.112
 */
public class PathSum {
    private int tar;
    public boolean hasPathSum(TreeNode root, int sum) {
        tar = sum;
        if(root==null){
            return false;
        }
        return pathSum(root,0);
    }
    public boolean pathSum(TreeNode node,int value){
        int curValue = value+node.val;
        if(node.left==null && node.right==null && curValue==tar){
            return true;
        }
        boolean left = false;
        boolean right = false;
        if(node.left!=null){
            left = pathSum(node.left,curValue);
        }
        if(node.right!=null){
            right = pathSum(node.right,curValue);
        }
        return left | right;
    }
}
