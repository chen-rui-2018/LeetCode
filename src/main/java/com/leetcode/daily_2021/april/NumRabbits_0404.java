package com.leetcode.daily_2021.april;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/4/4 11:12
 * @version： v1.0
 * @modified By:
 */
public class NumRabbits_0404  {
    public static void main(String[] args) {
        int [] answer = {5,5,5,5,5,5,5};
       int result =   new NumRabbits_0404().numRabbits(answer);
        System.out.println(result);
    }
    public int numRabbits(int[] answers) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.put(answer,map.getOrDefault(answer,0)+1);
        }
        int ans = 0;
        for (Integer key : map.keySet()) {
            int x = map.get(key);
            int y = key;
            ans +=  (x + y) / (y + 1) * (y + 1);
        }
        return ans;
    }
}
