package com.kingluffy.playstation;

import com.kingluffy.playstation.base.TreeNode;

/**
 * No.124
 */
public class BinTreeMaxPath {

    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        //post order traversal
        int height = maxPathSumCalculate(root);
        return ans;
    }

    public int maxPathSumCalculate(TreeNode root) {
        if (root == null) return 0;
        int left = Math.max(0,maxPathSumCalculate(root.left));
        int right = Math.max(0,maxPathSumCalculate(root.right));
        ans = Math.max(ans, root.val + left + right);
        return root.val + Math.max(left, right);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-100);
        TreeNode t1 = new TreeNode(-9);
        TreeNode t2 = new TreeNode(10);
        TreeNode t3 = new TreeNode(30);
        TreeNode t4 = new TreeNode(-30);
        t2.left = t3;
        t2.right = t4;
        root.left = t1;
        root.right = t2;
        BinTreeMaxPath binTreeMaxPath = new BinTreeMaxPath();
        System.out.println(binTreeMaxPath.maxPathSum(root));
    }
}
