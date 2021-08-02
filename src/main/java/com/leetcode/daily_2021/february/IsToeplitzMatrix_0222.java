package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/22 11:39
 * @version： v1.0
 * @modified By:
 */
public class IsToeplitzMatrix_0222 {
    public static void main(String[] args) {
        int[][] matrix = {{53,64,90,98,34},
                          {91,53,64,90,98},
                          {17,91,53,64,0},};
        boolean result = new IsToeplitzMatrix_0222().isToeplitzMatrix(matrix);
        System.out.println(result);


    }
    public boolean isToeplitzMatrix(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int i = 1;
        while (i < row ) {
            int j = 1;
            while (j < column) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) {
                    return false;
                }
               j++;
            }
            i++;
        }

        return true;
    }
}
