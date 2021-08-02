package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/5 9:17
 * @version： v1.0
 * @modified By:
 */
public class FrequencySort_0703 {
    public static void main(String[] args) {
        String str = "eertrrr";
        String s = new FrequencySort_0703().frequencySort(str);
        System.out.println(s);
        System.out.println();
    }
    public String frequencySort1(String s) {
        Map<Character,Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (char item : chars) {
            int i = map.getOrDefault(item, 0) + 1;
            map.put(item,i);
        }
        List<Character>  list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> map.get(b) - map.get(a));
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            char c = list.get(i);
            int num = map.get(c);
            for (int j = 0; j < num; j++) {
                sb.append(c);
            }

        }
        return sb.toString();
    }

    public String frequencySort(String s) {

        Map<Character,Integer> map = new HashMap<>();
        int maxNum = 0;
        char[] chars = s.toCharArray();
        for (char item : chars) {
            int i = map.getOrDefault(item, 0) + 1;
            map.put(item,i);
            maxNum = Math.max(i,maxNum);
        }
        StringBuffer[] buffers = new StringBuffer[maxNum+1];
        for (int i = 0; i<= maxNum; i++) {
            buffers[i] = new StringBuffer();
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char c = entry.getKey();
            int  v = entry.getValue();
            buffers[v].append(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = maxNum; i > 0; i--) {
            StringBuffer bucket = buffers[i];
            int length = bucket.length();
            for (int j = 0; j < length; j++) {
                for (int k = 0; k < i; k++) {
                    sb.append(bucket.charAt(j));
                }
            }
        }
        return sb.toString();
    }
}
