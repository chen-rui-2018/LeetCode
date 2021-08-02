package com.leetcode.editor.title_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/11/23 15:02
 * @version： v1.0
 * @modified By:
 */
public class Insert {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int [] newIntervals = {1,10};
        Insert insert =  new Insert();
        int [][] result = insert.insert(intervals,newIntervals);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints) + ",");
        }
        System.out.println();
        System.out.println(insert.add(2,2));
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean flag = false;
        List<int[]> ans = new ArrayList<>();
        for (int[] interval : intervals) {
            if(interval[1] < left){
                ans.add(interval);
            }else if(interval[0] > right){
                if(!flag){
                    ans.add(new int[]{left,right});
                    flag = true;
                }
                ans.add(interval);
            }else{
                left = Math.min(interval[0],left);
                right = Math.max(interval[1],right);
            }
        }
        if(!flag){
            ans.add(new int[]{left,right});
        }
        int [][] ansArray = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            ansArray[i] = ans.get(i);
        }
        return ansArray;
    }

    public int  add(int a ,int b){
        if(b == 0){
            return a;
        }
        return add(b^a,(a&b)<<1);
    }
}
