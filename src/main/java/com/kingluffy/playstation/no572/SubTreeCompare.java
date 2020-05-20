package com.kingluffy.playstation.no572;

import com.kingluffy.playstation.base.TreeNode;

/**
 *
 * No572
 *
 * 比较一棵树t是不是另一棵树s的子树
 *
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no572
 * @ClassName: SubTreeCompare
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/8 9:51 PM
 * @Version: 1.0
 */
public class SubTreeCompare {
    public boolean isSubtree(TreeNode s, TreeNode t) {


        // 树的先序遍历，对每一个子节点做子树比较
        return preTraversal(s,t);



    }

    private boolean preTraversal(TreeNode s, TreeNode t) {
        boolean res = isMySubTree(s,t);
        if(res){
            return res;
        }
        if(s.left!=null) {
            res = preTraversal(s.left, t);
        }
        if(res){
            return res;
        }
        if(s.right!=null){
            res = preTraversal(s.right,t);
        }
        return res;
    }

    private boolean isMySubTree(TreeNode s, TreeNode t) {

        // 结束条件： 如果值相同，且左右子节点都为空，则返回true
        if(s==null && t==null){
            return true;
        }
        if(s==null || t==null){
            return false;
        }
        // 如果当前节点相同，就比较左右子节点
        if(s.val==t.val){
            return isMySubTree(s.left,t.left) && isMySubTree(s.right,t.right);
        }

        // 否则返回false

        return false;
    }

    /** t
     *      1
     *   /     \
     *   2      3
     * @param args
     */
    /** t2
     *      2
     *   /
     *   4
     * @param args
     */
    /** s
     *      1
     *     / \
     *    2   3
     *   /     \
     *  4       5
     * @param args
     */

    /**
     * [1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,null,1,2]
     [1,null,1,null,1,null,1,null,1,null,1,2]
     * @param args
     */
    public static void main(String[] args) {
        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(2);
        s.right  = new TreeNode(3);
        s.left.left = new TreeNode(4);
        s.right.right = new TreeNode(5);

        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(2);
        t.right = new TreeNode(3);

        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(4);


        SubTreeCompare compare = new SubTreeCompare();

//        System.out.println(compare.isSubtree(s,t2));


        s = new TreeNode(1);

        s.right = new TreeNode(1);
        s.right.left = new TreeNode(2);

        t = new TreeNode(1);
        t.left = new TreeNode(2);

        System.out.println(compare.isSubtree(s,t));
    }
}
