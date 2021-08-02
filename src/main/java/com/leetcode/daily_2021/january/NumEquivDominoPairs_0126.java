package com.leetcode.daily_2021.january;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/1/26 9:22
 * @version： v1.0
 * @modified By:
 */
public class NumEquivDominoPairs_0126 {
    public static void main(String[] args) {
        int[][] dominoes ={{1,2},{2,1},{3,4},{5,6},{3,4},{1,2},{1,2}};
        int count =    new NumEquivDominoPairs_0126().numEquivDominoPairs(dominoes);
        System.out.println(count);

    }

    public int numEquivDominoPairs1(int[][] dominoes) {
        int count = 0;
        Map<int[], Integer> map = new HashMap<>(dominoes.length);

        for (int i = 0; i < dominoes.length; i++) {
            int[] key1 = dominoes[i];
            int[] key2 = new int [2];
            key2[0] = dominoes[i][1];
            key2[1] = dominoes[i][0];
            if (map.containsKey(key1) || map.containsKey(key2)) {
                map.put(dominoes[i], map.get(dominoes[i]) + 1);
                count++;
            }
            if (!map.containsKey(dominoes[i])) {
                map.put(dominoes[i], 0);
            }
        }
        return count;
    }
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] index = new int [100];
        int ans = 0;
        for (int i = 0; i < dominoes.length; i++) {
            int val = dominoes[i][0] < dominoes[i][1] ? dominoes[i][1] * 10 + dominoes[i][0] : dominoes[i][0] * 10 + dominoes[i][1];
            ans += index[val];
            index[val]++;
        }
        return ans;
    }
}
