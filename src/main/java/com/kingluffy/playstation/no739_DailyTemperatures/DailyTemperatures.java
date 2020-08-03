package com.kingluffy.playstation.no739_DailyTemperatures;

import java.util.Stack;

/**
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no739_DailyTemperatures
 * @ClassName: DailyTemperatures
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/11 9:16 PM
 * @Version: 1.0
 */
public class DailyTemperatures {

    public static void main(String[] args) {
        int[] T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] res = dailyTemperatures.dailyTemperatures(T);

        for (int i :res) {
            System.out.println(i);
        }
    }

    public int[] dailyTemperatures(int[] T) {
        if(T.length==1){
            return new int[]{0};
        }
        int[] res = new int[T.length];

        Stack<Integer> stack = new Stack<>();

        int curT;
        for(int i = T.length-1;i>-1;i--){

            curT = T[i];

            while(!stack.empty() && T[stack.peek()]<=curT){
                stack.pop();
            }

            if(!stack.empty()){
                res[i]=stack.peek()-i;
            }

            stack.push(i);
        }


        return res;

    }
}
