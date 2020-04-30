package com.kingluffy.playstation.no215;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no215
 * @ClassName: MaxK
 * @Author: king_luffy_pc
 * @Description: 第k个最大的数，使用堆排序
 * @Date: 2020/4/23 8:08 PM
 * @Version: 1.0
 *
 *
 */
public class MaxK {

    public int findKthLargest(int[] nums, int k) {
        int res = 0;

        for(int i=0;i<nums.length;i++){

            heap(nums,i);

        }

        System.out.println(Arrays.toString(nums));
        return res;
    }

    private void heap(int[] nums, int i) {

        // 已排序的当前index
        int idx = i;

        // 向上替换直到堆顶
        while (idx>0){

            // 父节点idx总数除2后向下取整
            int parent = idx / 2;

            // 如果比父节点大则替换（大顶推）
            if(nums[idx]>nums[parent]){
                sweap(nums,idx,parent);
            }

            //更新idx
            idx = idx / 2;
        }
    }

    private int[] heapk(int[] nums, int i,int k) {

        // 已排序的当前index
        int idx = i;

        // 向上替换直到堆顶
        while (idx>0){

            // 父节点idx总数除2后向下取整
            int parent = idx / 2;

            // 如果比父节点大则替换（大顶推）
            if(nums[idx]>nums[parent]){
                sweap(nums,idx,parent);
            }

            //更新idx
            idx = idx / 2;
        }

        return Arrays.copyOfRange(nums,0,k);
    }

    private void sweap(int[] nums, int i, int parent) {
        int tmp = nums[i];
        nums[i]=nums[parent];
        nums[parent]=tmp;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,1,3,5,4};
        System.out.println(Arrays.toString(nums));
        MaxK mk = new MaxK();
        mk.findKthLargest(nums,2);

    }

}
