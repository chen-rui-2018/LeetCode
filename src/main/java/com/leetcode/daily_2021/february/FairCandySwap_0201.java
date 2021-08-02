package com.leetcode.daily_2021.february;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 16:52
 * @version： v1.0
 * @modified By:
 */
public class FairCandySwap_0201 {

    public static void main(String[] args) {
            int [] A = {1,2};
            int [] B = {2,3};
            int[] ans = new FairCandySwap_0201().fairCandySwap(A,B);
        System.out.println(Arrays.toString(ans));

    }
    public int[] fairCandySwap(int[] A, int[] B) {
        int countA = Arrays.stream(A).sum();
        int countB = Arrays.stream(B).sum();
        int ave = (countA - countB) / 2;
        Set<Integer> set = new HashSet<>();
        for (int num : A) {
            set.add(num);
        }
        int [] ans = new int[2];
        for (int num : B) {
            int x = num + ave;
            if (set.contains(x)){
                ans[0] = x;
                ans[1] = num;
                break;
            }
        }
        return ans;
    }
}
