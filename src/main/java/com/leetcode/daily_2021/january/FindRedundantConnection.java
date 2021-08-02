package com.leetcode.daily_2021.january;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/1/15 13:50
 * @version： v1.0
 * @modified By:
 */
public class FindRedundantConnection {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3},{1,4},{1,5}};
        int [] result = new FindRedundantConnection().findRedundantConnection(edges);
        System.out.println(Arrays.toString(result));
    }
    public int[] findRedundantConnection(int[][] edges) {
        int len = edges.length;
        UnionFind unionFind = new UnionFind(len+1);
        for (int[] edge : edges) {
            unionFind.unnion(edge[0],edge[1]);
        }
        return unionFind.getResult();
    }
    class UnionFind {
       private int[] parent;
       private int[] rank;
       private int[] ans;
       public  UnionFind(int n){
           ans = new int[2];
           parent = new int[n];
           rank = new int[n];
           for (int i = 0; i < n; i++) {
               parent[i] = i;
               rank[i] = 0;
           }
       }
       public int [] getResult(){
           return ans;
       }
       public int findRoot(int x){
           if (x != parent[x]) {
               x = findRoot(parent[x]);
           }
           return parent[x];
       }
       public void unnion( int x, int y){
           int x_root = findRoot(x);
           int y_root = findRoot(y);
           if (x_root == y_root) {
               ans[0] = x;
               ans[1] = y;
               return;
           }
           if(rank[x] < rank[y]) {
               parent[x_root] = y_root;
           }else if(rank[x] > rank[y]) {
               parent[y_root] = x_root;
           }else {
               parent[x_root] = y_root;
               rank[y]++;
           }
       }
    }
}
