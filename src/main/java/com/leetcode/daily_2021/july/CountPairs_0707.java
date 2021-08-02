package com.leetcode.daily_2021.july;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/7/7 9:16
 * @version： v1.0
 * @modified By:
 */
public class CountPairs_0707 {

    public static void main(String[] args) {

        int[] nums = {1,1,1,3,3,3,7};
        int i = new CountPairs_0707().countPairs(nums);
        System.out.println(i);

        List<String> list = new ArrayList<>();
        list.add("123");
        list.add("456");
        list.add("789");
        String jsonStr = JSON.toJSONString(list);
        String str2 = "123,456,789";
        System.out.println(JSON.toJSONString(jsonStr));
        String[] split = str2.split(",");
        List<String> parse = (List<String>) JSON.parse(jsonStr);

        for (int j = 0; j < parse.size();j++) {
            System.out.println(parse.get(j));
            System.out.println(split[j]);

        }

    }

    public int countPairs(int[] deliciousness) {
        final int MDD = 1000000007;
        int maxVal = 0;
        for (int val : deliciousness) {
            maxVal = Math.max(maxVal, val);
        }
        int maxSum = maxVal * 2;
        int pairs = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int n = deliciousness.length;
        for (int i = 0; i < n; i++) {
            int val = deliciousness[i];
            for (int sum = 1; sum <= maxSum; sum <<= 1) {
                int count = map.getOrDefault(sum - val, 0);
                pairs = (pairs + count) % MDD;
            }
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        return pairs;
    }
}
