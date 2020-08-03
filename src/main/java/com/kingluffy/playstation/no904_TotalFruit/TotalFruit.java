package com.kingluffy.playstation.no904_TotalFruit;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no904_TotalFruit
 * @ClassName: TotalFruit
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/15 7:52 PM
 * @Version: 1.0
 */
public class TotalFruit {

    public int totalFruit(int[] tree) {

        int i=0,j=0,res=0,count;
        Map<Integer,Integer> window = new HashMap<>();


        while(j<tree.length){

            //记录当前树
            if(window.containsKey(tree[j])){
                window.put(tree[j],window.get(tree[j])+1);
            }else {
                window.put(tree[j],1);
            }

            //缩小左边界
            while(window.size()>2){
                count = window.get(tree[i])-1;
                if(count<1){
                    window.remove(tree[i]);
                }else{
                    window.put(tree[i],count);
                }
                i++;
            }

            //记录最大值
            res = Math.max(res,j-i+1);

            //扩大右边界

            j++;

        }
        return res;
    }

    public static void main(String[] args) {
        TotalFruit totalFruit = new TotalFruit();

        int[] src = new int[]{3,3,3,1,2,1,1,2,3,3,4};

        int res = totalFruit.totalFruit(src);

        System.out.println(res);
    }
}
