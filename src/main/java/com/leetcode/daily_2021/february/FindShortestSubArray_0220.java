package com.leetcode.daily_2021.february;

import sun.font.FontRunIterator;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/2/20 9:30
 * @version： v1.0
 * @modified By:
 */
public class FindShortestSubArray_0220 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 1, 4, 2};
        int result = new FindShortestSubArray_0220().findShortestSubArray(nums);
        System.out.println(result);
    }

    public int findShortestSubArray1(int[] nums) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int maxMap1 = 0;
        int maxMap2 = 0;
        // 计算原数组的度
        for (int i = 0; i < nums.length; i++) {
            int val = map1.getOrDefault(nums[i], 0) + 1;
            map1.put(nums[i], val);
            maxMap1 = Math.max(maxMap1, val);
        }
        int i = 0;
        int j = 0;
        int key = 0;
        int res = Integer.MAX_VALUE;
        while (i < nums.length) {
            int val = map2.getOrDefault(nums[i], 0) + 1;
            map2.put(nums[i], val);
            if (val > maxMap2) {
                maxMap2 = val;
                key = nums[i];
            }
            while (j <= i && maxMap1 == maxMap2) {
                map2.put(nums[j], map2.get(nums[j]) - 1);
                if (key == nums[j]) {
                    maxMap2--;
                }
                res = Math.min(res, i - j + 1);
                j++;
            }
            i++;
        }
        return res;
    }

    int maxDegree = 0;

    public int findShortestSubArray(int[] nums) {
        int result = Integer.MAX_VALUE;
        Map<Integer, int[]> map = getDegree(nums);
        for (int i = 0; i < nums.length; i++) {
            int[] val = map.get(nums[i]);
            if (val[0] < maxDegree) {
                continue;
            } else {
                result = Math.min(result, val[2] - val[1] + 1);
            }
        }
        return result;
    }

    private Map<Integer, int[]> getDegree(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int[] val;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                val = map.get(nums[i]);
                val[2] = i;
                val[0]++;
            } else {
                val = new int[3];
                val[0] = 1;
                val[1] = i;
                val[2] = i;
                map.put(nums[i], val);
            }
            if (maxDegree < val[0]) {
                maxDegree = val[0];
            }
        }
        return map;
    }

}
