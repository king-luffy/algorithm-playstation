package com.kingluffy.playstation.no18_Sum4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.18
 * 还需要去重
 * 达到边界情况
 */
public class Sum4for2 {
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        Arrays.sort(numbers);
        List<List<Integer>> ret = new ArrayList<>();
        dfs(ret, new ArrayList<Integer>(), numbers, 0, target);
        return ret;
    }

    private void dfs(List<List<Integer>> ret, List<Integer> condidate, int[] numbers, int curIndex,
                     int target) {
        // 以后求n数和，只要改这里就能解决，比如4改为3，改为5
        if (condidate.size() == 4) {
            int total = getSum(condidate);
            if (total == target) {
                ret.add(new ArrayList<>(condidate));
            }
            return;
        }
        if (curIndex > numbers.length - 1) {
            return;
        }
        for (int i = curIndex; i < numbers.length; i++) {
            // 如果是一样的数字，直接忽略，否则会有重复的答案
            if (i != curIndex && numbers[i] == numbers[i - 1]) {
                continue;
            }
            condidate.add(numbers[i]);
            // 如果已经大于target，并且当前数字大于0，再循环加下去已经没有意义了，因为只会更大，直接return
            if (getSum(condidate) > target && numbers[i] > 0) {
                if (!condidate.isEmpty()) {
                    condidate.remove(condidate.size() - 1);
                }
                return;
            }
            dfs(ret, condidate, numbers, i + 1, target);
            if (!condidate.isEmpty()) {
                condidate.remove(condidate.size() - 1);
            }
        }
    }

    private int getSum(List<Integer> condidate) {
        int total = 0;
        for (Integer num : condidate) {
            total += num;
        }
        return total;
    }

    public static void main(String[] args) {
        Sum4for2 sum4 = new Sum4for2();
//        int[] nums = new int[]{1,0,-1,0,-2,2};//0
//        int[] nums = new int[]{0,2,2,2,10,-3,-9,2,-10,-4,-9,-2,2,8,7};//6
//        int[] nums = new int[]{1,-2,-5,-4,-3,3,3,5};//-11
//        int[] nums = new int[]{-489,-475,-469,-468,-467,-462,-456,-443,-439,-425,-425,-410,-401,-342,-341,-331,-323,-307,-299,-262,-254,-245,-244,-238,-229,-227,-225,-224,-221,-197,-173,-171,-160,-142,-142,-136,-134,-125,-114,-100,-86,-81,-66,-47,-37,-34,4,7,11,34,60,76,99,104,113,117,124,139,141,143,144,146,157,157,178,183,185,189,192,194,221,223,226,232,247,249,274,281,284,293,298,319,327,338,340,368,375,377,379,388,390,392,446,469,480,490};//2738
        int[] nums = new int[]{-1,2,2,-5,0,-1,4};//3
//        int[] nums = new int[]{-492,-479,-468,-447,-432,-428,-418,-406,-388,-369,-300,-275,-238,-231,-228,-225,-224,-221,-220,-219,-189,-186,-180,-144,-130,-73,-67,-66,-55,-54,-53,-19,-6,13,28,36,47,57,80,82,87,97,97,120,132,142,148,174,176,176,205,225,232,238,245,247,264,268,268,275,319,334,387,392,412,413,426,434,442,451,475,478,485,490};//4631
        List<List<Integer>> result = sum4.fourSum(nums,3);
        for (List<Integer> tmp : result) {
            System.out.println("======");
            tmp.stream().forEach(System.out::println);
        }
    }
}
