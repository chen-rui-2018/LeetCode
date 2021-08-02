package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/11/12 9:20
 * @version： v1.0
 * @modified By:
 */
public class SortArrayByParityII_1112 {
    public static void main(String[] args) {
        int [] A = {4,2,5,7};
//        int [] B = new SortArrayByParityII_1112().sortArrayByParityII(A);
        int [] B = new SortArrayByParityII_1112().sortArrayByParityII2(A);
        System.out.println(Arrays.toString(B));
    }
    public int[] sortArrayByParityII(int[] A) {
        int odd = 1;
        int even = 0;
        int [] B = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            if ((A[i]&1) == 0){
                B[even] = A[i];
                even += 2;
            }else{
                B[odd] = A[i];
                odd += 2;
            }
        }
        return B;
    }
    public int[] sortArrayByParityII2(int[] A) {

        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if ((A[i]&1) == 1){
                while ((A[j]&1) == 1) {
                    j+=2;
                }
                swap(A,i,j);

            }
        }
        return A;
    }
    private void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
