package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/11/3 9:39
 * @version： v1.0
 * @modified By:
 */
public class ValidMountainArray_1103 {
    public static void main(String[] args) {
        int [] A = {0,1,1,3,2,1};

        System.out.println( new ValidMountainArray_1103().validMountainArray(A ));
        System.out.println( new ValidMountainArray_1103().validMountainArray2(A ));
    }
    public boolean validMountainArray(int[] A) {
        if (A == null || A.length < 3){
            return false;
        }
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > max){
                max = A[i];
                maxIndex = i;
            }
        }
        if (0 == maxIndex || maxIndex == A.length-1) {
            return false;
        }
        for (int i = 0; i < maxIndex; i++) {
            if(A[i] >= A[i+1]){
                return false;
            }
        }
        for (int i = maxIndex; i < A.length-1; i++) {
            if (A[i] <= A[i+1]){
                return false;
            }
        }
        return true;
    }
    public boolean validMountainArray2(int[] A) {
        int length = A.length;
        int index = 0;
        while (index < length-1 && A[index] < A[index+1]) {
            index++ ;
        }
        if (index == 0 || index == length-1) {
            return false;
        }
        while (index < length-1 && A[index] > A[index+1]){
            index ++;
        }
        return index == length-1;
    }
}
