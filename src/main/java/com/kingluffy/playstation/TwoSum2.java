package com.kingluffy.playstation;

import java.util.HashMap;
import java.util.Map;

/**
 * NO. 1
 *
 * 使用 hashmap 找另一个数
 *
 */
public class TwoSum2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = getMap(nums);
        int other;
        for(int i=0;i<nums.length-1;i++){
            other = target-nums[i];
            if(findTarget(map,i,other)){
                return putIntoRes(map,i,other);
            }
        }
        return new int[]{};
    }

    private Map<Integer,Integer> getMap(int[] nums){
        Map<Integer,Integer> res = new HashMap<>();
        if(nums==null || nums.length==0){
            return res;
        }
        for(int i=0;i<nums.length;i++){
            res.put(nums[i],i);
        }
        return res;
    }

    private boolean findTarget(Map<Integer,Integer> map,int i,int other){
        if(map.containsKey(other) && map.get(other)>i){
            return true;
        }
        return false;
    }

    private int[] putIntoRes(Map<Integer,Integer> map,int i,int other){
        int[] res = new int[2];
        res[0]=i;
        res[1]=map.get(other);
        return res;
    }

    public static void main(String[] args) {
        TwoSum2 sum2 = new TwoSum2();
        int[] nums = new int[]{1,2,3};
        int[] res = sum2.twoSum(nums,3);
        for (int r:res) {
            System.out.println(r);
        }
    }
}
