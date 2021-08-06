package com.leetcode.daily_2021.august;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/8/5 9:32
 * @version： v1.0
 * @modified By:
 */
public class D0805_eventualSafeNodes {
    public static void main(String[] args) {
        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
//        int[][] graph={{1,2},{2,3},{5},{0},{5},{},{}};
        List<Integer> list = new D0805_eventualSafeNodes().eventualSafeNodes(graph);
        for (Integer integer : list) {
            System.out.print(integer +", ");
        }

    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (safe(graph,color,i)){
                ret.add(i);
            }

        }
        return ret;
    }

    public boolean safe(int[][] graph,int[] color,int x){
        if (color[x] >0) {
          return   color[x] == 2;
        }
        color[x] = 1;
        for (int y : graph[x]) {
            if(!safe(graph,color,y)){
                return false;
            }
        }
        color[x] = 2;
        return true;
    }
}
