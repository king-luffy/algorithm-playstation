package com.kingluffy.playstation.no210notfinish;

import java.util.*;

/**
 *
 *
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no210notfinish
 * @ClassName: FindOrder
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/5/17 8:51 PM
 * @Version: 1.0
 */
public class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();

        //建立入度关系

        //入度数
        Map<Integer,Integer> inNum = new HashMap<>();
        Map<Integer,List<Integer>> depends = new HashMap<>();

        for(int i=0;i<numCourses;i++){
            inNum.put(i,0);
        }

        for (int[] is : prerequisites) {

            //记录入度
            if(inNum.containsKey(is[1])){
                inNum.put(is[1],inNum.get(is[1])+1);
            }

            //记录依赖
            if(depends.containsKey(is[0])){
                depends.get(is[0]).add(is[1]);
            }else{
                List<Integer> a = new ArrayList<>();
                a.add(is[1]);
                depends.put(is[0],a);
            }

        }


        //对所有入度为0的数据进行记录，并删除所有相关下级
        for(int i =0;i<numCourses;i++){
            if(inNum.get(i)==0){

                res.add(i);
                inNum.remove(i);
                // 减少关联项入度
                deleteIn(inNum,depends,i,res);

            }
        }
        if(inNum.size()>0){
            return new int[]{};
        }
        int[] r = new int[res.size()];
        for(int i=0;i<res.size();i++){
            r[res.size()-1-i]=res.get(i);
        }

        return r;
    }

    private void deleteIn(Map<Integer, Integer> inNum, Map<Integer, List<Integer>> depends, int i,List<Integer> res) {
        //是否存在关联项
        if(depends.containsKey(i)){

            //获取关联项
            List<Integer> nums = depends.get(i);

            //对每一个关联项
            for (Integer j: nums) {


                //减少入度
                int count = inNum.get(j)-1;
                inNum.put(j,count);

                if(count==0){
                    //如果入度减少到零，则可以加入到结果集中
                    res.add(j);
                    inNum.remove(j);
                    deleteIn(inNum,depends,j,res);
                }else{
                    inNum.put(j,count);
                }
            }
        }
    }

    public static void main(String[] args) {
        FindOrder findOrder = new FindOrder();
        int[][] src = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        src = new int[][]{{0,1}};
        int[] res = findOrder.findOrder(2,src);
        for (int i :res) {
            System.out.println(i);
        }
        System.out.println(new ArrayList<>(Arrays.asList(res)));
    }
}
