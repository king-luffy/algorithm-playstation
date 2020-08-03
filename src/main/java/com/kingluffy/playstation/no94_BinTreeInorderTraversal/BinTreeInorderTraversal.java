package com.kingluffy.playstation.no94_BinTreeInorderTraversal;

import com.kingluffy.playstation.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.94
 *
 * 二叉树的中序遍历
 *
 */
public class BinTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        visit(root,result);
        return result;
    }
    public void visit(TreeNode node,List<Integer> result){
        if(node==null) return;
        visit(node.left,result);
        result.add(node.val);
        visit(node.right,result);
    }
}
