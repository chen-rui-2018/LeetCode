package com.leetcode.daily_2021.march;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/3/8 14:28
 * @version： v1.0
 * @modified By:
 */
public class Partition_0307 {
    public static void main(String[] args) {
        List<List<String>> res =   new Partition_0307().partition("aab");
        for (List<String> re : res) {
            for (String s : re) {
                System.out.print(s+",");
            }
            System.out.println();
        }
    }
    public List<List<String>> partition(String s) {
       int len = s.length();
       List<List<String>> res= new ArrayList<>();
       if (len == 0) {
           return res;
       }
        Deque<String> stack = new LinkedList<>();
       char[] chars = s.toCharArray();
       dfs (chars,0,len,stack,res);

        return res;
    }

    private void dfs(char[] chars, int index, int len, Deque<String> path, List<List<String>> res) {
        if (index == len ){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < len; i++) {
            if (!checkPalindrome(chars,index,i)){
                continue;
            }
            path.addLast(new String(chars,index,i + 1 - index));
            dfs(chars,i+1,len,path,res);
            path.removeLast();
        }
    }

    private boolean checkPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left] != chars[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

}
