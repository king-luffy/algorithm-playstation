package com.kingluffy.playstation.no145_BinTreePostorderTraversal;

import com.kingluffy.playstation.base.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * No.145
 *
 * 二叉树的后序遍历
 *
 * 左右中
 */
public class BinTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        visit(root,result);
        return result;
    }
    public void visit(TreeNode node,List<Integer> result){
        if(node==null) return;
        visit(node.left,result);
        visit(node.right,result);
        result.add(node.val);
    }
}
