package com.kingluffy.playstation.no18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18
 *
 * 四数之和
 *
 * 和三数之和同样思路
 * 使用for循环固定2数
 *
 * 再使用双指针寻找目标值
 */
public class Sum4for3 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();

        int j,k;
        int len = nums.length;
        if(len==0){
            return res;
        }

        Arrays.sort(nums);

        for(int i=0;i<len-3;i++){
            //跳过重复项
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            for(int l=i+1;l<len-2;l++){

                //跳过重复项
                if(l>i+1 && nums[l]==nums[l-1]){
                    continue;
                }

                j=l+1;
                k=len-1;

                while(j<k){
                    if(isBigger(nums,i,l,j,k,target)){
                        k--;
                    }
                    else if(isSmaller(nums,i,l,j,k,target)){
                        j++;
                    }
                    else{
                        add2Res(nums,i,l,j,k,res);
                        //跳过循环数
                        while(j<k && nums[k-1]==nums[k]) k--;
                        while(j<k && nums[j]==nums[j+1]) j++;
                        k--;j++;
                    }
                }
            }

        }

        return res;
    }

    boolean isBigger(int[] nums,int i,int l,int j,int k,int target){
        return nums[i]+nums[l]+nums[j]+nums[k]>target;
    }
    boolean isSmaller(int[] nums,int i,int l,int j,int k,int target){
        return nums[i]+nums[l]+nums[j]+nums[k]<target;
    }
    void add2Res(int[] nums,int i,int l,int j,int k,List<List<Integer>> res){
        List<Integer> cell = new ArrayList<>();
        cell.add(nums[i]);
        cell.add(nums[l]);
        cell.add(nums[j]);
        cell.add(nums[k]);
        res.add(cell);
    }

    public static void main(String[] args) {
        Sum4for3 sum = new Sum4for3();
        int[] input = new int[]{1,0,-1,0,-2,2};
        List<List<Integer>> res = sum.fourSum(input,1);
        res.stream().forEach(a->{
            System.out.println("====");
            a.stream().forEach(System.out::println);});
    }
}
