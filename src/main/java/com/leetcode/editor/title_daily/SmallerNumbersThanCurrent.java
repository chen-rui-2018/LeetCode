package com.leetcode.editor.title_daily;

import com.sun.javafx.robot.FXRobotImage;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/10/26 9:19
 * @version： v1.0
 * @modified By:
 */
public class SmallerNumbersThanCurrent {
    public static void main(String[] args) {
        int [] param = {8,1,2,2,3};
//        int [] res = new SmallerNumbersThanCurrent().smallerNumbersThanCurrent(param);
        int [] res = new SmallerNumbersThanCurrent().smallerNumbersThanCurrent2(param);
        System.out.println(Arrays.toString(res));
    }
    public int[] smallerNumbersThanCurrent(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>(16);
        for (int i = 0; i < nums.length; i++) {
             map.put(i,0);
            for (int j = 0; j < nums.length; j++) {
                if (i == j){
                    continue;
                }
                if (nums[i] > nums[j]){
                    map.put(i,map.getOrDefault(i,0)+1);
                }


            }
        }
        int [] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = map.get(i);
        }
        return ans;
    }
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int [] clt = new  int[101];
        for (int i = 0; i < nums.length; i++) {
            clt[nums[i]]++;
        }
        for (int i = 1; i < clt.length; i++) {
            clt[i] = clt[i] + clt[i-1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] ==0 ? 0 : clt[nums[i]-1];
        }
        return nums;

    }
}
