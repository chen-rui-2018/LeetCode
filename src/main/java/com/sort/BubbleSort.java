package com.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author： chenr
 * @date： Created on 2021/7/15 11:00
 * @version： v1.0
 * @modified By:
 */
public class BubbleSort {

    public static void main(String[] args) {
        int [] arr = {9,8,7,6,5,4,3,2,1};
        int[] bubbleSort = new BubbleSort().getBubbleSort(arr);
        System.out.println(Arrays.toString(bubbleSort));
    }
    public int[] getBubbleSort(int[] arr){
        if (arr == null || arr.length <= 1){
            return arr;
        }
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }
}
