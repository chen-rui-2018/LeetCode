package com.leetcode.daily_2021.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/6/22 10:54
 * @version： v1.0
 * @modified By:
 */
public class Permutation_0622 {
    public static void main(String[] args) {
        String s = "abbc";
        String[] permutation = new Permutation_0622().permutation(s);
        System.out.println(Arrays.toString(permutation));
    }

    List<String> rec;
    boolean[] vis;
    public String[] permutation(String s) {
        int n = s.length();
        rec = new ArrayList<>();
        vis = new boolean[n];
        char[] arr= s.toCharArray();
        Arrays.sort(arr);
        StringBuilder perm = new StringBuilder();
        backtrack(arr,0,n,perm);
        int size = rec.size();
        String [] rceArr = new String[size];
        for (int i = 0; i < size; i++) {
            rceArr[i] = rec.get(i);
        }
        return rceArr;
    }

    public void backtrack(char[] arr, int i, int n, StringBuilder perm) {
        if (i == n) {
            rec.add(perm.toString());
            return;
        }
        for (int j = 0; j < n; j++) {
            if (vis[j] || (j>0 && !vis[j-1] && arr[j-1] == arr[j])){
                continue;
            }
            vis[j] = true;
            perm.append(arr[j]);
            backtrack(arr,i+1,n,perm);
            perm.deleteCharAt(perm.length()-1);
            vis[j] = false;
        }
    }
}
