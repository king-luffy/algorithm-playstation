package com.kingluffy.playstation.no102;

import com.kingluffy.playstation.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.102
 *
 * 二叉树层次遍历
 *
 * 每次循环获取当前层的所有子孩子，即下一层
 *
 */
public class BinTreeOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if(root==null){
            return result;
        }

        List<TreeNode> nodes = new ArrayList<>();
        nodes.add(root);

        while(nodes!=null && nodes.size()!=0) {

            List<Integer> level = getLevel(nodes);
            result.add(level);

            nodes = getChildren(nodes);
        }

        return result;
    }

    private static List<Integer> getLevel(List<TreeNode> nodes){
        List<Integer> result = new ArrayList<>();

        for (TreeNode node : nodes) {
            result.add(node.val);
        }

        return result;
    }
    private static List<TreeNode> getChildren(List<TreeNode> nodes){
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node:nodes) {
            if(node.left!=null){
                children.add(node.left);
            }
            if(node.right!=null){
                children.add(node.right);
            }
        }
        return children;
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
        BinTreeOrderTraversal binTreeOrderTraversal = new BinTreeOrderTraversal();
        System.out.println(binTreeOrderTraversal.levelOrder(root));
    }
}
