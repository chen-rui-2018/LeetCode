package com.leetcode.editor.title_daily;

import java.util.ArrayList;

/**
 * @author： chenr
 * @date： Created on 2020/11/11 9:28
 * @version： v1.0
 * @modified By:
 */
public class FindRotateSteps_1111 {
    public static void main(String[] args) {
        String ring = "nyngl";
        String key = "yyynnnnnnlllggg";
        int times =  new FindRotateSteps_1111().findRotateSteps(ring,key);
        int times2 =  new FindRotateSteps_1111().findRotateSteps2(ring,key);
        System.out.println(times);
        System.out.println(times2);

    }
    //贪心 举出了反例，是不正确的
    public int findRotateSteps(String ring, String key) {
        char [] charRing = ring.toCharArray();
        char [] charkey = key.toCharArray();
        int ringMid = 0;
        int ringLeft = 0;
        int ringRight = 0;
        int times = 0;
        for (char c : charkey) {
          while (c != charRing[ringMid]) {
              int leftTimes = 0;
              int rigthTimes = 0;
              int minTimes = 0;
              while (c != charRing[ringLeft]){
                  leftTimes++;
                  if (ringLeft > 0) {
                      ringLeft--;
                  }else {
                      ringLeft = charRing.length-1;
                  }

              }
              while (c != charRing[ringRight]){
                  rigthTimes++;
                  if (ringRight < charRing.length-1) {
                      ringRight++;
                  }else {
                      ringRight = 0;
                  }

              }
              minTimes = leftTimes < rigthTimes ? leftTimes : rigthTimes;
              times += minTimes;
              ringMid = leftTimes < rigthTimes ? ringLeft : ringRight;
              ringLeft = ringMid;
              ringRight = ringMid;

          }

          times ++;
        }
        return times;
    }
    // 动态规划
    public int findRotateSteps2(String ring, String key) {
        char [] charRing = ring.toCharArray();
        char [] charKey = key.toCharArray();
        ArrayList<Integer> [] lists = new ArrayList[26];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        // 遍历ring，存储每个字符出现的位置，即下标
        int n = charRing.length;
        int m = charKey.length;
        for (int i = 0; i < n; i++){
            char c =charRing[i];
            // 找到对应的ArrayList,存储下标
            lists[c-'a'].add(i);
        }
        // ring 和 key 的长度最多100
        int [][] dp = new int [m][150];
        // dp[0][j] 只需要计算从12点方向到key[0]所需要走的最短距离
        for (int j = 0; j < lists[charKey[0]-'a'].size(); j++) {
            // 每一个key[0]字符所在的下标
            int x = lists[charKey[0]-'a'].get(j);
            // 第一个12点方向的字符的下标，其实就是0
            int y = lists[charRing[0]-'a'].get(0);
            dp[0][j] = Math.min(Math.abs(x-y),n-Math.abs(x-y)) + 1;

        }
        for (int i = 1; i < charKey.length; i++) {
            // 列出当前的字符，和上一个的字符分别是什么
            char cur = charKey[i];
            char pre = charKey[i - 1];
            for (int j = 0; j < lists[cur-'a'].size(); j++) {
                // 当前字符cur出现在ring圆盘上每一个位置的下标
                int x = lists[cur-'a'].get(j);
                int minSteps = Integer.MAX_VALUE;
                for (int k = 0; k < lists[pre-'a'].size(); k++) {
                    // 上一个字符pre出现在ring圆盘上每一个位置的下标
                    int y = lists[pre-'a'].get(k);
                    int steps = dp[i-1][k] + Math.min(Math.abs(x-y),n-Math.abs(x-y)) + 1;
                    minSteps = Math.min(minSteps,steps);
                }
                dp[i][j] = minSteps;
            }


        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 150; i++) {
            if (dp[charKey.length-1][i] == 0){
                break;
            }
            ans = Math.min(ans,dp[charKey.length-1][i]);
        }
        return ans;
    }
}
