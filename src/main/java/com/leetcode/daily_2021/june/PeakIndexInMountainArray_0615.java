package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/15 9:34
 * @version： v1.0
 * @modified By:
 */
public class PeakIndexInMountainArray_0615 {
    public static void main(String[] args) {
        int arr[] = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        PeakIndexInMountainArray_0615 peak = new PeakIndexInMountainArray_0615();

        int result = peak.peakIndexInMountainArray(arr);
        System.out.println(result);
    }

    public int peakIndexInMountainArray1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
          int mid = (left + right) / 2;
          if (arr[mid] < arr[mid+1]){
              left = mid + 1;
          }else {
              right = mid;
          }
        }
        return left;
    }
}
