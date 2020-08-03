package com.kingluffy.playstation.no990_EquationsPossible;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 使用并查集方式来查数据
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no990_EquationsPossible
 * @ClassName: EquationsPossible
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/8 8:47 PM
 * @Version: 1.0
 */
public class EquationsPossible2 {

    public boolean equationsPossible(String[] equations) {
        if(equations.length<1){
            return true;
        }
        int[] parent = new int[26];
        for(int i =0;i<26;i++){
            parent[i]=i;
        }
        List<String> checkList = new ArrayList<>();


        for(String equation : equations){

            boolean isEqual = equation.charAt(1)=='=';
            if(!isEqual){
                //不等
                checkList.add(equation);
                continue;
            }

            int first = equation.charAt(0)-'a';
            int second = equation.charAt(3)-'a';


            // 相等方程式
            // 更新父节点
            updateParent(parent,first,second);


        }

        for(String equation : checkList){
            int first = equation.charAt(0)-'a';
            int second = equation.charAt(3)-'a';
            if(find(parent,first)==find(parent,second)){
                return false;
            }

        }
        return true;
    }

    private void updateParent(int[] parent, int first, int second) {
        parent[find(parent,first)] = find(parent,second);
    }

    private int find(int[] parent, int idx) {
        while (parent[idx]!=idx){
            idx = parent[idx];
        }
        return idx;
    }


    public static void main(String[] args) {
        String[] src = new String[]{"c==c","b==d","x!=z"};
        EquationsPossible2 possible = new EquationsPossible2();
        boolean res = possible.equationsPossible(src);
        System.out.println(res);
    }
}
