package com.leetcode.structure.acs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/6/29 15:52
 * @version： v1.0
 * @modified By:
 */
public class MinimumEffortPath {
    public static void main(String[] args) {

    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int id = m * i + j;
                if (i > 0) {
                    // 同一列和上一个的 距离绝对值
                    edges.add(new int[]{id - m, id, Math.abs(heights[i][j] - heights[i - 1][j])});
                }
                if (j > 0) {
                    //同一行 和前一个的 距离绝对值
                    edges.add(new int[]{id - 1, id, Math.abs(heights[i][j] - heights[i][j-1])});
                }
            }
        }
        Collections.sort(edges,(o1, o2)->o1[2]-o2[2]);
        int ans = 0;
        UnionFind unionFind= new UnionFind(m*n);
        for (int[] edge : edges) {
            int x = edge[0],  y =  edge[1], val = edge[2];
            unionFind.union(x,y);
            if (unionFind.isUnion(0,m*n-1)) {
                ans = val;
                break;
            }
        }
        return ans;
    }
}

