package com.leetcode.editor.title_daily;

import javax.sound.midi.Soundbank;

/**
 * @author： chenr
 * @date： Created on 2020/12/7 10:23
 * @version： v1.0
 * @modified By:
 */
public class MatrixScore_1207 {
    public static void main(String[] args) {
        int [][] A = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new MatrixScore_1207().matrixScore(A));
    }
    public int matrixScore(int[][] A) {
        int  column= A[0].length;
        int  row = A.length;
        int result = row * (1 << (column - 1));

        for (int i = 1; i < column; i++) {
            int oneCount = 0;
            for (int j = 0; j < row; j++) {
                if(A[j][0] == 1){
                    oneCount += A[j][i] ;
                }else {
                    oneCount += 1 - A[j][i];
                }

            }
            int maxOneCount = Math.max(oneCount,row-oneCount);
            result += maxOneCount * (1 << (column - i - 1));
        }

        return result;
    }
}
