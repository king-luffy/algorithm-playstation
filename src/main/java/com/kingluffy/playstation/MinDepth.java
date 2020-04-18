package com.kingluffy.playstation;

import com.kingluffy.playstation.base.TreeNode;

/**
 * No.111
 */
public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        if(root.left==null){
            return minDepth(root.right);
        }
        if(root.right==null){
            return minDepth(root.left);
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        return Math.min(leftDepth,rightDepth)+1;
    }
}
