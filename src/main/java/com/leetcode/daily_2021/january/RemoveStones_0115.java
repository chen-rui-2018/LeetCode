package com.leetcode.daily_2021.january;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/1/15 9:41
 * @version： v1.0
 * @modified By:
 */
public class RemoveStones_0115 {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        int result =    new RemoveStones_0115().removeStones(stones);
        System.out.println(result);
    }
    public int removeStones(int[][] stones) {
       int len = stones.length;
//       UnionFind unionFind = new UnionFind(len);
//        for (int i = 0; i < len; i++) {
//            for (int j = i+1; j < len; j++) {
//                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
//                    unionFind.merge(i,j);
//                }
//            }
//        }
//        return unionFind.count;
        UnionFindMap unionFindMap = new UnionFindMap();
        for (int[] stone : stones) {
            unionFindMap.union(stone[0] + 10001,stone[1]);
        }
        return len - unionFindMap.getCount();
    }


    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;
        UnionFind (int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        public   int getCount(){
            return count;
        }
        public int findRoot(int x){
            while (parent[x] != x){
                x = parent[x];
            }
            return parent[x];
        }
        public void merge (int x,int y){
            int x_root = findRoot(x);
            int y_root = findRoot(y);
            if (x_root == y_root){
                return;
            }
            if(rank[x] > rank[y]){
                parent[y_root] = x_root;
            }else if (rank[x] < rank[y]){
                parent[x_root] = y_root;
            }else {
                parent[x_root] = y_root;
                rank[y]++;
            }
            count--;
        }

    }
   class UnionFindMap{
        private Map<Integer,Integer> parent;
        private int count;
        public  UnionFindMap(){
            this.parent = new HashMap<>();
            this.count = 0;

        }
        public int getCount(){
            return count;
        }
        public int findRoot(int x){
            if(!parent.containsKey(x)){
                parent.put(x,x);
                count++;
            }
            int x_root= x;
            while(x != parent.get(x)){
                 x = parent.get(x);
            }
            parent.put(x_root,parent.get(x));
            return parent.get(x);
        }
        public void union (int x, int y){
            int x_root = findRoot(x);
            int y_root = findRoot(y);
            if (x_root == y_root){
                return;
            }
            parent.put(x_root,y_root);
            count--;
        }
    }
}
