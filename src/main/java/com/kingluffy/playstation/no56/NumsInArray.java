package com.kingluffy.playstation.no56;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * No56
 *
 *
 *
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no56
 * @ClassName: NumsInArray
 * @Author: king_luffy_pc
 * @Description: ${description}
 * 数组中数字出现的次数
 * @Date: 2020/4/28 8:19 PM
 * @Version: 1.0
 */
public class NumsInArray {
    public static int[] singleNumbers(int[] src){


        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i< src.length;i++){
            if(map.containsKey(src[i])){
                map.remove(src[i]);
            }else{
                map.put(src[i],src[i]);
            }
        }
        List<Integer> list = new ArrayList<>(map.values());

        int[] res = new int[list.size()];
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
//
//        Integer[] res2 = new Integer[map.size()];
//        map.values().toArray(res2);
//        System.out.println(res2);
//        res = ArrayUtils.toPrimitive(res2);
        return res;
    }
}
