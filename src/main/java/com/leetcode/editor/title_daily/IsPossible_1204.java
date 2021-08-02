package com.leetcode.editor.title_daily;


import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/12/9 10:38
 * @version： v1.0
 * @modified By:
 */
public class IsPossible_1204 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,5};

        System.out.println( new IsPossible_1204().isPossible(nums));
    }
    public boolean isPossible(int[] nums) {
        Map<Integer,Integer> countMap = new HashMap<>();
        Map<Integer,Integer> endMap = new HashMap<>();
        for(int x : nums){
            int count = countMap.getOrDefault(x,0)+1;
            countMap.put(x,count);
        }
        for(int x : nums){
            int count = countMap.getOrDefault(x,0);
            if(count > 0){
                int prevEndCount = endMap.getOrDefault(x-1,0);
                if(prevEndCount > 0){
                    countMap.put(x,count-1);
                    endMap.put(x-1,prevEndCount - 1);
                    endMap.put(x,endMap.getOrDefault(x,0) + 1);
                }else {
                    int count1 =countMap.getOrDefault(x+1,0);
                    int count2 =countMap.getOrDefault(x+2,0);
                    if(count1 > 0 && count2 > 0){
                        countMap.put(x,count - 1);
                        countMap.put(x+1,count1-1);
                        countMap.put(x+2,count2-1);
                        endMap.put(x+2,endMap.getOrDefault(x+2,0)+1);
                    }else {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
