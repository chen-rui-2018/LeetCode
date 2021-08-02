package com.leetcode.daily_2021.february;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 15:05
 * @version： v1.0
 * @modified By:
 */
public class FindDisappearedNumbers_0213 {
    public static void main(String[] args) {
            String x = "13246";
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                list.add(i+1);
            }
        }
        return list;
    }
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int x = (nums[i]-1) % len;
            nums[x] += len;
        }
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < len; i++) {
            if(nums[i] < len){
                list.add(i+1);
            }
        }
        return list;
    }
}
