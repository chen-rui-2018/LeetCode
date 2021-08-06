package com.leetcode.daily_2021.august;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/8/2 9:22
 * @version： v1.0
 * @modified By:
 */
public class D0802_networkDelayTime {
    public static void main(String[] args) {

    }
    public int networkDelayTime(int[][] times, int n, int k) {
        int max = Integer.MAX_VALUE / 2;
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i],max);
        }
        for (int[] time : times) {
            int x = time[0]-1,y=time[1]-1;
            g[x][y] = time[2];
        }

        int [] dist = new int[n];
        Arrays.fill(dist,max);
        dist[k-1] = 0;
        boolean[] used = new boolean[n];
        Arrays.fill(used,false);
        for (int i = 0; i < n; i++) {
            int x = -1;
            for (int y = 0; y < n; y++) {
                if (!used[y] && (x==-1|| dist[y] <dist[x])){
                    x = y;
                }
            }
            used[x] = true;
            for (int y = 0; y < n; y++) {
                dist[y] = Math.min(dist[y],dist[x]+ g[x][y]);
            }

        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == max ? -1 : ans;
    }

}
