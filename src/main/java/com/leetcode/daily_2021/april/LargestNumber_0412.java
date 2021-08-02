package com.leetcode.daily_2021.april;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author： chenr
 * @date： Created on 2021/4/12 11:55
 * @version： v1.0
 * @modified By:
 */
public class LargestNumber_0412 {
    public static void main(String[] args) {
        int [] nums = {0,0,0};
     String result =    new LargestNumber_0412().largestNumber(nums);
        System.out.println(result);
    }
    public String largestNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = nums[i]+"";
        }
        Arrays.sort(str,(str1,str2)->{
           String  a = str1 + str2;
           String b =   str2 + str1;
          return b.compareTo(a);
        });
        StringBuilder result = new StringBuilder();
        for (String s : str) {
            result.append(s);
        }
        if (result.indexOf("0") == 0) {
            return "0";
        }
        Vector v = null;
        LinkedList l = null;
        ArrayList a = null;
        ConcurrentHashMap c =null;
        TreeMap t= null;
        return result.toString();
    }
}
