package com.kingluffy.playstation.no207_CanFinish;

import java.util.*;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no207_CanFinish
 * @ClassName: CanFinish
 * @Author: king_luffy_pc
 * @Description:
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]

给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？

 

示例 1:

输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 

提示：

输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
1 <= numCourses <= 10^5

 *
 * @Date: 2020/8/4 10:12 AM
 * @Version: 1.0
 */
public class CanFinish {

    class Node{
        int in = 0;
        List<Integer> nexts = new ArrayList<>();
    }

    // 广度遍历
    public boolean canFinish(int numCourses, int[][] prerequisites) {


        // 构建图结构
        Map<Integer,Node> nodes = new HashMap<>();
        Set<Integer> begins = new HashSet<>();
        // 所有节点初始化
        for(int i=0;i<numCourses;i++){
            nodes.put(i,new Node());
            begins.add(i);
        }
        // 记录节点的入度和边
        for(int i=0;i< prerequisites.length;i++){
            // 入度计算
            nodes.get(prerequisites[i][0]).in += 1;
            // 边增加
            nodes.get(prerequisites[i][1]).nexts.add(prerequisites[i][0]);
            // 移除初始值
            begins.remove(prerequisites[i][0]);
        }

        // 每次删除入度为0的节点，直到不存在节点，true 或者不存在入度为0的节点，但仍然有节点存在 false
        for (Integer begin : begins) {

            removeNode(begin,nodes);

        }

        return nodes.size()<1;
    }

    private void removeNode(Integer begin,Map<Integer,Node> nodes) {
        List<Integer> nexts = nodes.get(begin).nexts;
        nodes.remove(begin);
        for (Integer next:nexts) {
            nodes.get(next).in-=1;
            if(nodes.get(next).in==0){
                removeNode(next,nodes);
            }
        }
    }


    public static void main(String[] args) {
        // 2, [[1,0]]
        int numCourses = 2 ;
        int[][] prerequisites = new int[][]{{1,0},{0,1}};


        CanFinish canFinish = new CanFinish();
        boolean res = canFinish.canFinish(numCourses,prerequisites);
        System.out.println(res);
    }
}
