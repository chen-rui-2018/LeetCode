package com.leetcode.daily_2021.february;

import javax.sound.midi.Soundbank;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 14:00
 * @version： v1.0
 * @modified By:
 */
public class MatrixReshape_0217 {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4},{5,6}};
        int[][] res = new MatrixReshape_0217().matrixReshape(nums,2,3);
        System.out.println(res.length);
    }
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length;
        int m = nums[0].length;
        if (n*m  != r*c ){
            return nums;
        }
        int[][] res = new int[r][c];
        int k = 0;
        int l = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (l == m){
                    l = 0;
                    k++;
                }
                res[i][j] = nums[k][l];
                l++;
            }
        }
        return res;
    }
}
