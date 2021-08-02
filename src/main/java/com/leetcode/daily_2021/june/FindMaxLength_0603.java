package com.leetcode.daily_2021.june;

import javax.xml.bind.SchemaOutputResolver;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/6/3 11:17
 * @version： v1.0
 * @modified By:
 */
public class FindMaxLength_0603 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,1,0,0,1,1};
        int maxLength = new FindMaxLength_0603().findMaxLength(nums);
        System.out.println(maxLength);
    }
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        Map<Integer,Integer> map = new HashMap<>();
        int counter = 0;
        map.put(counter,-1);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                counter--;
            }else {
                counter++;
            }
            if (map.containsKey(counter)) {
                int preIndex = map.get(counter);
                maxLength = Math.max(maxLength,i-preIndex);
            }else {
                map.put(counter,i);
            }
        }
        return maxLength;
    }
}
