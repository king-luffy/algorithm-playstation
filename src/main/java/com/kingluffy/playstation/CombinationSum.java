package com.kingluffy.playstation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    private boolean[] visited;
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> cur = new ArrayList<>();

    private void DFS(int[] arr, int target, int pos, int sum) {
        if (sum > target) {
            return;
        }
        if (target == sum) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = pos; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i != 0 && arr[i] == arr[i - 1] && !visited[i - 1]) {
                continue;
            }
            if (!visited[i]) {
                visited[i] = true;
                cur.add(arr[i]);
                DFS(arr, target, i, sum + arr[i]);
                visited[i] = false;
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        visited = new boolean[candidates.length];
        DFS(candidates, target, 0, 0);
        return result;
    }

    public static void main(String[] args) {
        CombinationSum solution = new CombinationSum();
        int[] arr = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> list = solution.combinationSum2(arr, 8);
        System.out.println(list);
    }

}
