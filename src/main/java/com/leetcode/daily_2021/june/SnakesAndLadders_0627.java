package com.leetcode.daily_2021.june;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2021/6/29 11:31
 * @version： v1.0
 * @modified By:
 */
public class SnakesAndLadders_0627 {
    public static void main(String[] args) {

    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n*n+1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new  int[]{1,0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 1; i <=6 ; i++) {
                int nxt = p[0] + i;
                if (nxt > n*n){
                    break;
                }
                int[] rc = id2rc(nxt,n);
                if (board[rc[0]][rc[1]]>0) {
                    nxt = board[rc[0]][rc[1]];
                }
                if (nxt == n*n) {
                    return p[1] + 1;
                }
                if (!vis[nxt]) {
                    vis[nxt]  = true;
                    queue.offer(new int[]{nxt,p[1]+1});
                }
            }
        }
      return -1;
    }
    public int[] id2rc(int id ,int n){
        int r = (id -1) / n, c = (id - 1) % n;
        if (r%2 == 1){
            c = n-1-c;
        }
        return new int[]{n-1-r,c};
    }
}
