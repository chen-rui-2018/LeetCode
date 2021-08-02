package com.leetcode.daily_2021.january;

/**
 * @author： chenr
 * @date： Created on 2021/1/14 16:00
 * @version： v1.0
 * @modified By:
 */
public class DisJointSet {
     int[] parent;
     int[] rank;

    public DisJointSet(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        //初始化
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public int findRoot(int x) {
        int x_root = x;
        while (parent[x] != x) {
            x = parent[x];
        }
        parent[x_root] = parent[x];
        return parent[x];
    }

    public void merge(int x, int y) {
        int x_root = findRoot(x);
        int y_root = findRoot(y);
        if ( x_root == y_root){
            return;
        }
        if (rank[x] > rank[y]) {
            parent[y] = x_root;
        }else if (rank[x] < rank[y]) {
            parent[x_root] = y_root;
        }else {
            parent[x_root] = y_root;
            rank[y]++;
        }
    }


}
