package com.leetcode.editor.title_daily;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2020/12/7 17:23
 * @version： v1.0
 * @modified By:
 */
public class LeastInterval_1205 {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','A','A','A','A','A','A','A','B','B','B','C'};
        int n = 2;
        int result = new LeastInterval_1205().leastInterval(tasks,n);
        System.out.println(result);
    }
    public int leastInterval(char[] tasks, int n) {
        int[] buckets = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buckets[tasks[i]-'A']++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for (int i = 25; i >= 1 ; i--) {
            if(buckets[i] == buckets[i-1]){
                maxCount++;
            }else {
                break;
            }
        }
        int res = (maxTimes - 1) * (n+1) + maxCount;
        return Math.max(res,tasks.length);
    }
}
