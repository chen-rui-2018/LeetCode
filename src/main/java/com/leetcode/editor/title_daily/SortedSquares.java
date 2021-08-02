package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/10/16 13:50
 * @version： v1.0
 * @modified By:
 */
public class SortedSquares {
    public static void main(String[] args) {
       int [] param = {-4,-1,0,3,10};
       int[] answer =   new SortedSquares().sortedSquares(param);
        System.out.println(Arrays.toString(answer));
    }
    public int[] sortedSquares(int[] A) {
        if (A == null || A.length <= 0){
            return A;
        }
        int length = A.length;
        int [] answer = new int[length];
        for(int i = 0, j = length-1, pos = length-1; i <= j ;){
            if(A[i]*A[i] >= A[j]*A[j]){
                answer[pos--] = A[i]*A[i];
                i++;
            }else{
                answer[pos--] = A[j]*A[j];
                j--;
            }

        }
        return answer;
    }
}
