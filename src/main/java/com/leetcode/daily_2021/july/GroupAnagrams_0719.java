package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/19 10:13
 * @version： v1.0
 * @modified By:
 */
public class GroupAnagrams_0719 {
    public static void main(String[] args) {
        String [] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = new GroupAnagrams_0719().groupAnagrams(strs);
        System.out.println(lists.size());
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key,orDefault);
        }
        return new ArrayList<List<String>>(map.values());
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            int [] counts = new int[26];
            int length = str.length();
            for (int i = 0; i < length; i++) {
                counts[str.charAt(i)-'a']++;
            }
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < 26; i++) {
                if (counts[i] != 0){
                    sb.append((char)(i+'a'));
                    sb.append(counts[i]);
                }
            }
            String key = sb.toString();
            List<String> orDefault = map.getOrDefault(key, new ArrayList<>());
            orDefault.add(str);
            map.put(key,orDefault);

        }

        return new ArrayList<List<String>>(map.values());
    }
}
