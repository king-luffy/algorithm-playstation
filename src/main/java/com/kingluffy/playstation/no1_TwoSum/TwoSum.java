package com.kingluffy.playstation.no1_TwoSum;

/**
 * No.1
 *
 *
 * 双重循环暴力破解
 *
 */
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {

        if(nums==null || nums.length<2){
            return null;
        }

        int len = nums.length;


        for(int i=0;i<len-1;i++){
            for(int j=len-1;j>i;j--){
                if(findTarget(nums[i],nums[j],target)){
                    return getResult(i,j);
                }
            }
        }
        return null;

    }

    private static boolean findTarget(int a,int b,int target){
        return a + b == target;
    }

    private static int[] getResult(int a,int b){
        int[] result = new int[2];
        result[0]=a;
        result[1]=b;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,4,2};
        int target = 6;

        nums = twoSum(nums,target);
        for (Integer n:nums) {
            System.out.println(n);
        }

    }
}
