package com.kingluffy.playstation;

import java.util.*;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation
 * @ClassName: no0
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/12 1:33 PM
 * @Version: 1.0
 */
public class no0 {

    public static void main(String[] args) {
        int[] src = new int[]{1,1,2,2,1,3};
        List<Integer> res = findTopKByFreq(src,3);
        System.out.println(res);


        int[] src2 = new int[]{4,5,6,7,0,1,2};
        src2 = new int[]{0,1,2};
        int res2 = findMin(src2);
        System.out.println(res2);
    }

    // [1,1,2,2,1,3] k = 2 => return [1,2]
    // [1,1,2,2,1,3] k = 3 => return [1,2,3]
    public static List<Integer> findTopKByFreq(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();

        // 构建数次数
        for(int i=0;i<nums.length;i++){
            int curNum = nums[i];
            if(map.containsKey(curNum)){
                map.put(curNum,map.get(curNum)+1);
            }else{
                map.put(curNum,1);
            }
        }

        // 创建小顶堆
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparing(map::get));

        // 留下k个最多的次数
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            int val = entry.getKey();
            if(queue.size()<k || map.get(val)<map.get(queue.peek())){
                queue.offer(val);
            }
            if(queue.size()>k){
                queue.poll();
            }
        }

        // 构建结果集
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()){
            res.add(queue.poll());
        }
        return res;
    }

    public static int findMin(int[] nums){
        int b = 0;
        int e = nums.length-1;
        int m= (b + e)/2;

        while(b<e){
            if(b==e-1){
                if(nums[b]<nums[e]){
                    return nums[b];
                }else {
                    return nums[e];
                }
            }
            m= (b + e)/2;
            if(nums[m]<nums[e]){
                e=m;
            }else {
                b=m;
            }
        }
        return nums[m];

    }
}
