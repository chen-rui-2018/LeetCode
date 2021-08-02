package com.leetcode.editor.title_daily;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/11/6 9:38
 * @version： v1.0
 * @modified By:
 */
public class SortByBits_20201106 {
    public static void main(String[] args) {
        int [] arr = {0,1,2,3,4,5,6,7,8};
        int [] arr1 = {1024,512,256,128,64,32,16,8,4,2,1};
//        int [] result =    new SortByBits_20201106().sortByBits(arr1);
        int [] result =    new SortByBits_20201106().sortByBits2(arr);
        System.out.println(Arrays.toString(result));
    }
    public int[] sortByBits(int[] arr) {
        int [] bit = new int[10001];
        List<Integer>  list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        for (int i = 1; i < bit.length; i++) {
            bit[i] = bit[i>>1] + (i&1);
        }
        Collections.sort(list, (o1, o2) -> {
            if (bit[o1] != bit[o2]){
                return bit[o1] - bit[o2];
            }else {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    public int[] sortByBits2(int[] arr) {
        int [] bit = new int[10001];
        List<Integer>  list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
            bit[arr[i]] = bitCount(arr[i]);
        }
        Collections.sort(list, (o1, o2) -> {
            if (bit[o1] != bit[o2]){
                return bit[o1] - bit[o2];
            }else {
                return o1 - o2;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
    int bitCount(int n) {
        int count = 0;
        while (n > 0) {
            // 清除最低位的1
            n &= (n - 1);
            count++;
        }
        return count;
    }





}

