package com.kingluffy.playstation.no199;

import com.kingluffy.playstation.base.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.199
 *
 * 二叉树的右视图
 *
 * 层次遍历No.102，并输出层次遍历的最后一个节点
 */
public class BinTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        List<TreeNode> nodes = Arrays.asList(root);
        visitLayer(nodes,result);
        return result;
    }
    public void visitLayer(List<TreeNode> nodes,List<Integer> result){
        if(nodes==null || nodes.size()==0){
            return;
        }
        addLast(nodes,result);
        List<TreeNode> children = getChildren(nodes);
        visitLayer(children, result);
    }
    public void addLast(List<TreeNode>nodes, List<Integer> result){
        int len = nodes.size();
        result.add(nodes.get(len-1).val);
    }
    public List<TreeNode> getChildren(List<TreeNode> parents){
        List<TreeNode> children = new ArrayList<>();
        for (TreeNode node : parents) {
            if(node.left!=null)
                children.add(node.left);
            if(node.right!=null)
                children.add(node.right);
        }
        return children;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        TreeNode t1 = new TreeNode(9);
//        TreeNode t2 = new TreeNode(20);
//        TreeNode t3 = new TreeNode(15);
//        TreeNode t4 = new TreeNode(7);
//        t2.left = t3;
//        t2.right = t4;
//        root.left = t1;
//        root.right = t2;
        TreeNode root = new TreeNode(3);
        BinTreeRightSideView view = new BinTreeRightSideView();
        List<Integer> result = view.rightSideView(root);
        result.stream().forEach(System.out::println);
    }
}
