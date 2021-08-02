package com.leetcode.daily_2021.march;

import com.sun.deploy.panel.ITreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/3/15 23:01
 * @version： v1.0
 * @modified By:
 */
public class SpiralOrder_0315 {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        List<Integer> result =    new  SpiralOrder_0315().spiralOrder(matrix);
        for (Integer integer : result) {
            System.out.print(integer + ",");
        }

        }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int l = 0, r =  n-1, t = 0, d = m-1;
        int index =0, target = n*m;
        while (index < target) {
            for (int j = l; j <= r ; j++) { if(index >= target) {break;} result.add(matrix[t][j]); index++; } t++;
            for (int j = t; j <= d ; j++) { if(index >= target) {break;} result.add(matrix[j][r]); index++; } r--;
            for (int j = r; j >= l ; j--) { if(index >= target) {break;} result.add(matrix[d][j]); index++; } d--;
            for (int j = d; j >= t ; j--) { if(index >= target) {break;} result.add(matrix[j][l]); index++; } l++;

        }
        return result;
    }
}
