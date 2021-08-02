package com.leetcode.daily_2021.january;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/1/14 10:14
 * @version： v1.0
 * @modified By:
 */
public class SummaryRanges_0110 {
    public static void main(String[] args) {
        int []  nums = {0,1,2,4,5,7};
        List<String> list =   new SummaryRanges_0110().summaryRanges(nums);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    public List<String> summaryRanges(int[] nums) {
        int i = 0;
        int n = nums.length;
        List<String> list = new ArrayList<>();
       while (i < n){
           int low = i;
           i++;
           while (i < n && nums[i] == nums[i-1]+1) {
               i++;
           }
           int high = i-1;
           StringBuilder stringBuilder = new StringBuilder(Integer.toString(nums[low]));
           if(low < high){
               stringBuilder.append("->").append(nums[high]);
           }
           list.add(stringBuilder.toString());
        }
        return list;
    }
}
