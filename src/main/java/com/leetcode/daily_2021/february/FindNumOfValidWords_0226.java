package com.leetcode.daily_2021.february;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/2/26 11:28
 * @version： v1.0
 * @modified By:
 */
public class FindNumOfValidWords_0226 {
    public static void main(String[] args) {
        String [] words = {"aaaa","asas","able","ability","actt","actor","access"};
        String [] puzzles = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        List<Integer> result =   new FindNumOfValidWords_0226().findNumOfValidWords(words,puzzles);
        for (Integer integer : result) {
            System.out.print(integer+", ");
        }
    }
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> state = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp = temp | (1<<s.charAt(j)-'a');
            }
            state.put(temp,state.getOrDefault(temp,0)+1);
        }
        for (int i = 0; i < puzzles.length; i++) {
            String s = puzzles[i];
            int temp = 0;
            for (int j = 0; j < s.length(); j++) {
                temp = temp | (1 << s.charAt(j) - 'a');
            }
            int cnt = 0;
            for (int k = temp; k != 0 ; k=(k-1)&temp) {
                if ((1<<(s.charAt(0)-'a')&k)!=0){
                    cnt += state.getOrDefault(k,0);
                }

            }
            res.add(cnt);
        }
        return res;
    }
}
