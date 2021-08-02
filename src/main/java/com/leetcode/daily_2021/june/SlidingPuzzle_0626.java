package com.leetcode.daily_2021.june;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/6/29 10:34
 * @version： v1.0
 * @modified By:
 */
public class SlidingPuzzle_0626 {
    public static void main(String[] args) {
        int[][] board = {{1,2,3},{4,0,5}};
        int i = new SlidingPuzzle_0626().slidingPuzzle(board);
        System.out.println(i);
    }
    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        String initial = sb.toString();
        if ("123450".equals(initial)) {
            return 0;
        }
        int step = 0;
        Queue<String> queue = new LinkedList<>();
        queue.offer(initial);
        Set<String> seen = new HashSet<>();
        seen.add(initial);
        while(!queue.isEmpty()){
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for(String nextStatus : get(status)){
                    if (!seen.contains(nextStatus)){
                        if ("123450".equals(nextStatus)) {
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }

      return -1;
    }
    public List<String> get(String status){
        List<String> ret = new ArrayList<>();
        char[] array = status.toCharArray();
        int x  = status.indexOf('0');
        for (int y:neighbors[x]) {
            swap(array,x,y);
            ret.add(new String(array));
            swap(array,x,y);
        }
        return ret;
    }
    public void swap(char[] array,int x, int y){
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
}
