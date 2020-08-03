package com.kingluffy.playstation.no144_BinTreePreorderTraversal;

import com.kingluffy.playstation.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.144
 *
 * 二叉树的先序遍历
 *
 * 中左右
 */
public class BinTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        visit(root,result);
        return result;
    }
    public void visit(TreeNode node,List<Integer> result){
        if(node==null) return;
        result.add(node.val);
        visit(node.left,result);
        visit(node.right,result);
    }
}
