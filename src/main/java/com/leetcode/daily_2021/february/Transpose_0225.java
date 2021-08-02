package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/25 16:36
 * @version： v1.0
 * @modified By:
 */
public class Transpose_0225 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int [][] result = new Transpose_0225().transpose(matrix);
        System.out.println("111");
    }
    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int [][] result = new int[column][row];

        int m = 0;
        int i = 0;
        while ( i < row ) {
            int j = 0;
            int n = 0;
            while (j < column) {
                result[n][m] = matrix[i][j];
                j++;
                n++;
            }
            i++;
            m++;

        }
        return result;
    }
}
