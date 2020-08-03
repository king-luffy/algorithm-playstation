package com.kingluffy.playstation.no990_EquationsPossible;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * 使用a b两个字母，分别放到相同或不同组中，最后check不等的是否在组中
 * @ProjectName: algorithm-playstation
 * @Package: com.kingluffy.playstation.no990_EquationsPossible
 * @ClassName: EquationsPossible
 * @Author: king_luffy_pc
 * @Description: ${description}
 * @Date: 2020/6/8 8:47 PM
 * @Version: 1.0
 */
public class EquationsPossible {

    public boolean equationsPossible(String[] equations) {
        if(equations.length<1){
            return true;
        }
        List<String> checkList = new ArrayList<>();
        List<Map<Character,Integer>> groups = new ArrayList<>();

        for(String equation : equations){

            char first = equation.charAt(0);
            char second = equation.charAt(3);
            boolean isEqual = equation.charAt(1)=='=';

            // 第一个字母所在组
            Map<Character,Integer> curGroup = inGroup(groups,first);


            // 第二个字母所在组
            Map<Character,Integer> secGroup = inGroup(groups,second);


            if(isEqual){
                //相等


                if(curGroup==null && secGroup==null){
                    // 都不在新组
                    putCharInNewGroup(groups,first,second);
                }else if(curGroup!=null && secGroup==null){
                    // 找到第一个字母所在组
                    curGroup.put(second,0);
                }else if(secGroup!=null && curGroup==null){
                    // 找到第二个字母所在组
                    secGroup.put(first,0);
                }else if(curGroup!=secGroup){
                    // 找到两个组
                    curGroup.putAll(secGroup);
                    groups.remove(secGroup);

                }


            }else {
                //不等
                checkList.add(equation);
            }

        }

        for(String equation : checkList){
            char first = equation.charAt(0);
            char second = equation.charAt(3);
            if(first==second){
                return false;
            }
            for (Map<Character,Integer> map:groups) {
                if(map.containsKey(first) && map.containsKey(second)){
                    return false;
                }
            }
        }
        return true;
    }

    private Map<Character, Integer> putCharInNewGroup(List<Map<Character, Integer>> groups, char first,char second) {
        Map<Character, Integer> curGroup;
        curGroup = new HashMap<>();
        curGroup.put(first,0);
        curGroup.put(second,0);
        groups.add(curGroup);
        return curGroup;
    }

    Map<Character,Integer> inGroup(List<Map<Character,Integer>> groups,char c){
        for (Map<Character,Integer> group:groups) {
            if(group.containsKey(c)){
                return group;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] src = new String[]{"f==a","a==b","f!=e","a==c","b==e","c==f"};
        EquationsPossible possible = new EquationsPossible();
        boolean res = possible.equationsPossible(src);
        System.out.println(res);
    }
}
