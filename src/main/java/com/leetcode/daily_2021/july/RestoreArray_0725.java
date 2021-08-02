package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/26 10:31
 * @version： v1.0
 * @modified By:
 */
public class RestoreArray_0725 {
    public static void main(String[] args) {
        int[][] adjacentPairs = {{2,1},{3,4},{3,2}};
        int[] ints = new RestoreArray_0725().restoreArray(adjacentPairs);
        System.out.println(Arrays.toString(ints));
    }
    public int[] restoreArray(int[][] adjacentPairs) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] adjacentPair : adjacentPairs) {
            map.putIfAbsent(adjacentPair[0],new ArrayList<>());
            map.putIfAbsent(adjacentPair[1],new ArrayList<>());
            map.get(adjacentPair[0]).add(adjacentPair[1]);
            map.get(adjacentPair[1]).add(adjacentPair[0]);
        }
        int n = adjacentPairs.length + 1;
        int[] ret = new int[n];
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            int e = entry.getKey();
            List<Integer> adj = entry.getValue();
            if (adj.size() == 1) {
                ret[0] = e;
                break;
            }
        }
        ret[1] = map.get(ret[0]).get(0);
        for (int i = 2; i < n; i++) {
            List<Integer> adj = map.get(ret[i-1]);
            ret[i] = ret[i-2] == adj.get(0) ? adj.get(1) : adj.get(0);
        }
        return ret;
    }
}
