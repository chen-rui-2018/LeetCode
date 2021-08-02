package com.leetcode.daily_2021.march;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/3/2 9:12
 * @version： v1.0
 * @modified By:
 */
public class NumMatrix_0302 {
    public static void main(String[] args) {
        int[][] matrix = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };
//        int[][] matrix = {};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int result = numMatrix.sumRegion(2, 1, 4, 3);
        System.out.println(result);

    }

    /**
     * 一维前缀
     */
    static class NumMatrix1 {
        int[][] matrixCount;
        int count;

        public NumMatrix1(int[][] matrix) {
            int row = matrix.length;
            int column;
            if (row == 0) {
                matrixCount = null;
            } else {
                column = matrix[0].length;
                matrixCount = new int[row][column + 1];
                for (int i = 0; i < row; i++) {
                    Arrays.fill(matrixCount[i], 0);
                    for (int j = 1; j <= column; j++) {
                        matrixCount[i][j] = matrixCount[i][j - 1] + matrix[i][j - 1];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            count = 0;
            if (matrixCount == null) {
                return count;
            }
            for (int i = row1; i <= row2; i++) {
                count += matrixCount[i][col2 + 1] - matrixCount[i][col1];
            }
            return count;
        }
    }

    /**
     * 二维前缀
     */
    static class NumMatrix {
        int[][] matrixCount = null;
        int count;

        public NumMatrix(int[][] matrix) {
            int row = matrix.length;
            if (row > 0) {
                int column = matrix[0].length;
                matrixCount = new int[row + 1][column + 1];
                for (int i = 0; i < row; i++) {
                    for (int j = 0; j < column; j++) {
                        matrixCount[i + 1][j + 1] = matrixCount[i][j + 1] + matrixCount[i + 1][j] - matrixCount[i][j] + matrix[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            count = 0;
            if (matrixCount == null) {
                return count;
            }
            count = matrixCount[row2+1][col2+1] - matrixCount[row2 + 1][col1] - matrixCount[row1][col2 + 1] + matrixCount[row1][col1];
            return count;
        }
    }
}
