package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/1 9:37
 * @version： v1.0
 * @modified By:
 */
public class NumWays_0701 {
    public static void main(String[] args) {
        int n = 5;
        int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
        int k = 3;
        int i = new NumWays_0701().numWays(n, relation, k);
        System.out.println(i);

        long time = 1624976200000L;
        Date date = new Date(time);
        System.out.println(date);
    }

    int ways, n, k;
    List<List<Integer>> edges;

    public int numWays1(int n, int[][] relation, int k) {
        ways = 0;
        this.n = n;
        this.k = k;
        edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        dfs(0, 0);
        return ways;
    }

    private void dfs(int index, int steps) {
        if (steps == k) {
            if (index == n - 1) {
                ways++;
            }
            return;
        }
        List<Integer> list = edges.get(index);
        for (Integer next : list) {
            dfs(next, steps + 1);
        }
    }


    public int numWays2(int n, int[][] relation, int k) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int[] edge : relation) {
            int src = edge[0], dst = edge[1];
            edges.get(src).add(dst);
        }
        int steps = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty() && steps < k) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                List<Integer> list = edges.get(index);
                for (Integer next : list) {
                    queue.offer(next);
                }
            }
        }
        int ways = 0;
        if (steps == k) {
            while (!queue.isEmpty()) {
                if (queue.poll() == n - 1) {
                    ways++;
                }
            }
        }
        return ways;
    }
    // int[][] relation = {{0, 2}, {2, 1}, {3, 4}, {2, 3}, {1, 4}, {2, 0}, {0, 4}};
    public int numWays(int n, int[][] relation, int k) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 0; i < k; i++) {
            for (int[] edge : relation) {
                int src = edge[0], dst = edge[1];
                dp[i+1][dst] += dp[i][src];
            }
        }
        return dp[k][n-1];
    }
    public int numWays3(int n, int[][] relation, int k) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            int [] next = new int[n];
            for (int[] edge : relation) {
                int src = edge[0],dst = edge[1];
                next[dst] += dp[src];
            }
            dp = next;
        }
        return dp[n-1];
    }
}
