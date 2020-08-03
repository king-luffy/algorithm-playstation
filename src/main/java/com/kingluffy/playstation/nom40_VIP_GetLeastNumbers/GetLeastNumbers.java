package com.kingluffy.playstation.nom40_VIP_GetLeastNumbers;

import java.util.PriorityQueue;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.nom40_VIP_GetLeastNumbers
 * @ClassName: GetLeastNumbers
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/2 9:19 PM
 * @Version: 1.0
 */
public class GetLeastNumbers {

    // 堆方法
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>(k,(v1,v2)->Integer.compare(v2,v1));

        for(int i=0;i<arr.length;i++){
            int cur = arr[i];
            if(heap.size()<k || cur<heap.peek()){
                heap.offer(cur);
            }
            if(heap.size()>k){
                heap.poll();
            }
        }

        return heap.stream().mapToInt(Integer::valueOf).toArray();
    }





    public int[] getLeastNumbers2(int[] arr, int k) {
        if(k==0){
            return new int[]{};
        }
        int res[] =new int[k];

        for(int i=0;i<arr.length;i++){
            heap(arr,i,res,k);
        }
        return res;
    }

    // 可以优化，不创建堆
    // 堆排序， 限制排序堆大小为k
    void heap(int[] src,int i,int res[],int k){

        // 如果当前指针大于最大数，和堆最后一个比较，小的替换
        if(i>k-1) {
            if(src[i]<res[k-1]) {
                res[k-1] = src[i];
                i=k-1;
            }else {
                return;
            }
        }else {

            //当前指针不大于最大数，直接插入
            res[i] = src[i];
        }
        int parent;
        while(i>0){
            parent = (i-1)/2;
            if(res[parent]>res[i]){
                swap(i, res, parent);
            }else {
                break;
            }
        }

    }

    // 交换两个数
    private void swap(int i, int[] res, int parent) {
        int tmp = res[parent];
        res[parent] = res[i];
        res[i]=tmp;
    }

    public static void main(String[] args) {
        GetLeastNumbers numbers = new GetLeastNumbers();
        int[] src = new int[]{4,2,2,3,1,4};
        int k =3;
        int[] res = numbers.getLeastNumbers(src,k);

        for(int i =0;i<res.length;i++) {
            System.out.println(res[i]);
        }
    }
}
