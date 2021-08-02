package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/14 16:19
 * @version： v1.0
 * @modified By:
 */
public class MinSwapsCouples {
    public static void main(String[] args) {
        int [] rows = {0, 2, 1, 3};
      int result =   new MinSwapsCouples().minSwapsCouples(rows);
        System.out.println(result);
    }
    public int minSwapsCouples(int[] row) {
        int len = row.length;
        int N = len / 2;
        UnionFind unionFind = new UnionFind(N);
        for (int i = 0; i < len; i += 2) {
            unionFind.union(row[i] / 2, row[i+1] / 2);
        }
        return N - unionFind.getCount();
    }
    class UnionFind {
        private int [] parent;
        private int count;
        public UnionFind(int n) {
            this.parent = new int [n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }
        public int find( int x ){
            while (x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return  parent[x];
        }
        public void union(int x, int y){
            int root_x = find(x);
            int root_y = find(y);

            if (root_x == root_y){
                return;
            }
            parent[root_x] = root_y;
            count--;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

}
