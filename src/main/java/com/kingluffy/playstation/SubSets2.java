package com.kingluffy.playstation;

import java.util.ArrayList;
import java.util.List;

public class SubSets2 {
    public List<List<Integer>> subsets(int[] nums, int pos) {
        if (nums.length == pos) {
            // empty set
            List<List<Integer>> t = new ArrayList<>();
            List<Integer> empty = new ArrayList<>();
            t.add(empty);
            return t;
        }

        List<List<Integer>> nextSets = subsets(nums, pos+1);
        List<List<Integer>> ret = new ArrayList<>();
        for (List<Integer> set : nextSets) {
            ret.add(new ArrayList<Integer>(set)); // without
            set.add(nums[pos]);
            ret.add(new ArrayList<Integer>(set)); // with
        }

        return ret;
    }

    public List<List<Integer>> subsets(int[] nums) {
        return subsets(nums, 0);
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        SubSets2 subSets = new SubSets2();
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
