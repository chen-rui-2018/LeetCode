package com.leetcode.daily_2021.january;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/1/27 9:19
 * @version： v1.0
 * @modified By:
 */
public class MaxNumEdgesToRemove_0127 {
    public static void main(String[] args) {
        int n = 4;
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,3},{1,2,4},{1,1,2},{2,3,4}};
//        int[][] edges = {{3,1,2},{3,2,3},{1,1,4},{2,1,4}};
        int[][] edges = {{3,2,3},{1,1,2},{2,3,4}};


       int ans = new MaxNumEdgesToRemove_0127().maxNumEdgesToRemove(n,edges);
        System.out.println(ans);
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        UnionFind unionFindA = new UnionFind(n);
        UnionFind unionFindB = new UnionFind(n);
        Arrays.sort(edges, (o1, o2) -> o2[0]-o1[0]);
        int sizeComm = 0;
        for (int[] edge : edges) {
            if(edge[0] == 3 ){
                unionFindA.union(edge[1],edge[2]);
                unionFindB.union(edge[1],edge[2]);
            }
        }
        sizeComm = unionFindA.count;
        for (int[] edge : edges) {
            if (edge[0] == 1){
                unionFindA.union(edge[1],edge[2]);
            }
            if (edge[0] == 2){
                unionFindB.union(edge[1],edge[2]);
            }
        }
        if (unionFindB .getSize() > 1 || unionFindA.getSize() > 1) {
            return -1;
        }
        return unionFindA.getCount() + unionFindB.getCount() - sizeComm;

    }
    
    class UnionFind{
        private int [] parent;
        private int [] rank;
        // 可删除边数量
        private int count;
        // 联通分量个数
        private int size;
        
        public UnionFind(int n) {
            this.parent = new int[n+1];
            this.rank = new int[n+1];
            this.size = n;
            this.count = 0;
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        
        public int find ( int x) {
            while (x != parent[x]) {
                x = parent[x];
                parent[x] = parent[parent[x]];
            }
            return x;
        }
        
        public void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root){
                count++;
                return;
            }
            if(rank[x_root] < rank[y_root]){
                parent[x_root] = y_root;
            }else if (rank[x_root] > rank[y_root]){
                parent[y_root] = x_root;
            }else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
            size--;
        }
        public int getCount(){
            return count;
        }
        public int getSize(){
            return size;
        }
    }
}
