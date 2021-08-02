package com.leetcode;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/4 11:08
 * @version： v1.0
 * @modified By:
 */
public class EliminateMaximum {
    public static void main(String[] args) {

         int[] dist = {3,2,4};
         int [] speed  = {5,3,2};
        int i = new EliminateMaximum().eliminateMaximum(dist, speed);
        System.out.println(i);
    }
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        double [] steps = new double[n];
        for (int i = 0; i < n; i++) {
            steps[i] = Math.ceil(dist[i]*1.0/speed[i]);
        }
        Arrays.sort(steps);
        if (0==steps[0]) {
          return 0;
        }
        for (int i = 1; i < n; i++) {
            if (steps[i] <= i){
               return i;
            }
        }
        return n;
    }
}
