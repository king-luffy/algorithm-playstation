package com.kingluffy.playstation.No104;


import com.kingluffy.playstation.base.TreeNode;

/**
 * No.104
 *
 * 二叉树最大深度
 *
 * 深度优先遍历，返回路径最大值
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth,rightDepth)+1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t2.left = t3;
        t2.right = t4;
        root.left = t1;
        root.right = t2;
        MaxDepth maxDepth = new MaxDepth();
        System.out.println(maxDepth.maxDepth(root));
    }

}

