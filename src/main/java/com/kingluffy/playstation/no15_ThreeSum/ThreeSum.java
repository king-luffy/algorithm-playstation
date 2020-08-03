package com.kingluffy.playstation.no15_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.15
 *
 * 3数之和
 *
 * 固定一位，之后部分头尾双指针向内扫描，相加为零，直到结束
 *
 * 注意相加相等的数不可能交叉
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        int j,k;
        int len = nums.length;
        if(len==0){
            return res;
        }

        Arrays.sort(nums);

        for(int i=0;i<len-2;i++){

            //都大于0，相加不可能等于零
            if(nums[i]>0){
                break;
            }

            //掉过重复项
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }

            j=i+1;
            k=len-1;

            while(j<k){
                if(isBigger(nums,i,j,k)){
                    k--;
                }
                else if(isSmaller(nums,i,j,k)){
                    j++;
                }
                else{
                    add2Res(nums,i,j,k,res);
                    //跳过循环数
                    while(j<k && nums[k-1]==nums[k]) k--;
                    while(j<k && nums[j]==nums[j+1]) j++;
                    k--;j++;
                }
            }
        }

        return res;
    }

    boolean isBigger(int[] nums,int i,int j,int k){
        return nums[i]+nums[j]+nums[k]>0;
    }
    boolean isSmaller(int[] nums,int i,int j,int k){
        return nums[i]+nums[j]+nums[k]<0;
    }
    void add2Res(int[] nums,int i,int j,int k,List<List<Integer>> res){
        List<Integer> cell = new ArrayList<>();
        cell.add(nums[i]);
        cell.add(nums[j]);
        cell.add(nums[k]);
        res.add(cell);
    }

    public static void main(String[] args) {
        ThreeSum sum = new ThreeSum();
        int[] input = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = sum.threeSum(input);
        res.stream().forEach(a->{
            System.out.println("====");
            a.stream().forEach(System.out::println);});
    }
}
