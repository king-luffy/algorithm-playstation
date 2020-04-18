package com.kingluffy.playstation;

import java.util.ArrayList;
import java.util.List;

/**
 * No.78
 */
public class SubSets {

    public List<List<Integer>> subsets(int[] nums) {
        return sub(0,nums);
    }

    public static List<List<Integer>>  sub(int idx,int[] nums){

        //最后一个节点
        if(idx==nums.length-1){
            List<List<Integer>> tail = new ArrayList<>();
            List<Integer> only = new ArrayList<>();
            only.add(nums[idx]);
            tail.add(only);
            tail.add(new ArrayList<Integer>());
            return tail;
        }

        List<List<Integer>> subResults = sub(idx+1,nums);

        List<List<Integer>> r = new ArrayList<>();

        //无自己
        r.addAll(subResults);

        //有自己
        for (List<Integer> subResult : subResults) {
            List<Integer> with = new ArrayList<>();
            with.add(nums[idx]);
            with.addAll(subResult);
            r.add(with);
        }

        return r;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        SubSets subSets = new SubSets();
        List<List<Integer>> result = subSets.subsets(nums);
        for (List<Integer> r: result) {
            for (Integer i:r) {
                System.out.print(i);
                System.out.print(",");
            }
            System.out.println("\n");
        }
    }
}
