package com.kingluffy.playstation.no18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18
 * 还需要去重
 * 达到边界情况
 */
public class Sum4 {

    List<List<Integer>> result = new ArrayList<>();
    Integer tar;

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        tar=target;
        if(checkMax(nums)){
            return result;
        }
        sum4(nums,new ArrayList<>(),0);
        return result;
    }
    boolean checkMax(int[] nums){
        if(nums==null || nums.length<4){
            return false;
        }
        int len = nums.length;
        if(nums[len-1]+nums[len-2]+nums[len-3]+nums[len-4]<tar){
            return true;
        }
        return false;
    }

    boolean size4(List<Integer> curs){
        return curs.size()==4;
    }

    void checkTarget(List<Integer> curs){
        if(curs.stream().reduce((a,b)->a+b).get().equals(tar)){
            if(!isExist(curs)) {
                result.add(curs);
            }
        }
    }
    
    boolean isExist(List<Integer> curs){
        if(result.size()==0){
            return false;
        }
        for (List<Integer> tmp : result) {
            if(compare2IntList(tmp,curs)){
                return true;
            }
        }
        return false;
    }

    boolean compare2IntList(List<Integer> l,List<Integer> r){
        for(int i=0;i<l.size();i++){
            if(!l.get(i).equals(r.get(i))){
                return false;
            }
        }
        return true;
    }

    boolean isBiggerThanTar(List<Integer> curs){
        if(curs.size()==0){
            return false;
        }
        if(curs.size()==1 && curs.get(0)>tar){
            return true;
        }
        if(curs.stream().reduce((a,b)->a+b).get()>tar){
            return true;
        }
        return false;
    }
    void sum4(int[] nums,List<Integer> curs,int idx){

        //如果累加到第四个，进行比对
        if(size4(curs)){
            checkTarget(curs);
            return;
        }
        //到达边界
        if(idx>=nums.length){
            return;
        }

        //因为是排序后的，所以大于后返回
        if(isBiggerThanTar(curs) && nums[idx]>0){
            return;
        }

        //不加自己
        List<Integer>noself = new ArrayList<>(curs);
        //加自己
        curs.add(nums[idx]);
        idx+=1;
        sum4(nums,curs,idx);
        sum4(nums,noself,idx);
    }

    boolean sum4(List<Integer> nums,List<Integer> curs,int idx){
        boolean tmp = true;

        //如果累加到第四个，进行比对
        if(size4(curs)){
            checkTarget(curs);

            //因为是降序排序，所以小于的可能性都可以排除
            if(isSmallerThanTar(curs)){
                return false;
            }

            return true;
        }
        //到达边界
        if(idx>=nums.size()){
            return true;
        }

        //copy
        List<Integer>noself = new ArrayList<>(curs);
        //加自己
        curs.add(nums.get(idx));
        idx+=1;
        tmp = sum4(nums,curs,idx);
        //已经小于
        if(!tmp){
            return false;
        }
        //不加自己
        tmp = sum4(nums,noself,idx);
        return tmp;
    }

    boolean isSmallerThanTar(List<Integer> curs){
        if(curs.size()==0){
            return false;
        }
        if(curs.size()==1 && curs.get(0)<tar){
            return true;
        }
        if(curs.stream().reduce((a,b)->a+b).get()<tar){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Sum4 sum4 = new Sum4();
//        int[] nums = new int[]{1,0,-1,0,-2,2};//0
//        int[] nums = new int[]{0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};//6
//        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};//-11
//        int[] nums = new int[]{-489,-475,-469,-468,-467,-462,-456,-443,-439,-425,-425,-410,-401,-342,-341,-331,-323,-307,-299,-262,-254,-245,-244,-238,-229,-227,-225,-224,-221,-197,-173,-171,-160,-142,-142,-136,-134,-125,-114,-100,-86,-81,-66,-47,-37,-34,4,7,11,34,60,76,99,104,113,117,124,139,141,143,144,146,157,157,178,183,185,189,192,194,221,223,226,232,247,249,274,281,284,293,298,319,327,338,340,368,375,377,379,388,390,392,446,469,480,490};//2738
//        int[] nums = new int[]{-1,2,2,-5,0,-1,4};//3
        int[] nums = new int[]{-492,-479,-468,-447,-432,-428,-418,-406,-388,-369,-300,-275,-238,-231,-228,-225,-224,-221,-220,-219,-189,-186,-180,-144,-130,-73,-67,-66,-55,-54,-53,-19,-6,13,28,36,47,57,80,82,87,97,97,120,132,142,148,174,176,176,205,225,232,238,245,247,264,268,268,275,319,334,387,392,412,413,426,434,442,451,475,478,485,490};//4631
        List<List<Integer>> result = sum4.fourSum(nums,4631);
        for (List<Integer> tmp : result) {
            System.out.println("======");
            tmp.stream().forEach(System.out::println);
        }
//
//        List<Integer> tmp = new ArrayList<>();
//        tmp.add(1);tmp.add(2);
//        List<Integer> tmp2 = new ArrayList<>(tmp);
//        tmp.add(3);
//        tmp2.stream().forEach(System.out::println);

    }

}
