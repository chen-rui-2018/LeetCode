package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/1/5 14:12
 * @version： v1.0
 * @modified By:
 */
public class LargeGroupPositions {
    public static void main(String[] args) {
        String s = "abcdddeeeeaabbbcd";
        List<List<Integer>>  ans =    new LargeGroupPositions().largeGroupPositions(s);
        System.out.println(ans.size());
    }
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> ans = new ArrayList();
        int j = 0;
        int i = 0;
        int pennut = 0;
        while (i < s.length()) {
            int count = 0;
            char temp = s.charAt(i);
            while ( j<s.length()&& temp == s.charAt(j) ) {
                count++;
                j++;
            }
            if (count >= 3) {
                List<Integer> list = new ArrayList();
                list.add(i);
                list.add(j-1);
                ans.add(list);
            }
            i = j;
        }
        return ans;
    }
}
