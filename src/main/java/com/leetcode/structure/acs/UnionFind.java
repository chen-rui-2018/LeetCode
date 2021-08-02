package com.leetcode.structure.acs;

/**
 * @author： chenr
 * @date： Created on 2021/6/29 15:53
 * @version： v1.0
 * @modified By:
 */
public class UnionFind {
    private int[] parent;
    private int[] rank;

    public UnionFind(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * 找到当前值的根
     * @param x
     * @return
     */
    public int find(int x) {
        return x == parent[x] ? parent[x] : find(parent[x]);
    }

    /**
     * 合并
     * @param x
     * @param y
     */
    public void union (int x, int y) {
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root) {
            return;
        }
        if (rank[x_root] < rank[y_root]) {
            parent[x_root] = y_root;
        }else if(rank[x_root] > rank[y_root]){
            parent[y_root] = x_root;
        }else {
            parent[x_root] = y_root;
            rank[y_root]++;
        }
    }

    /**
     * 判断是否为同一联通分量
     * @param x
     * @param y
     * @return
     */
    public boolean isUnion(int x, int y){
        int x_root = find(x);
        int y_root = find(y);
        if (x_root == y_root){
            return true;
        }
        return false;
    }
}
