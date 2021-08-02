package com.leetcode.daily_2021.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/1/21 10:36
 * @version： v1.0
 * @modified By:
 */
public class FindCriticalAndPseudoCriticalEdges_0121 {
    public static void main(String[] args) {
        int[][] edges = {{0,1,1},{1,2,1},{2,3,2},{0,3,2},{0,4,3},{3,4,3},{1,4,6}};
        int n = 5;
        List<List<Integer>> list =    new FindCriticalAndPseudoCriticalEdges_0121().findCriticalAndPseudoCriticalEdges(n,edges);
        for (List<Integer> integerList : list) {
            for (Integer integer : integerList) {
                System.out.print(integer+ ", ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int m = edges.length;
        int [][] newEdges = new int[m][4];
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < 3; ++j) {
                newEdges[i][j] = edges[i][j];
            }
            newEdges[i][3] = i;
        }
        Arrays.sort(newEdges, (o1, o2) -> o1[2]-o2[2]);
        // 计算最小生存树的value
        UnionFind unionFind = new UnionFind(n);
        int value = 0;
        for (int i = 0; i < m; i++) {
            if(unionFind.union(newEdges[i][0],newEdges[i][1])){
                value += newEdges[i][2];
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            //判断是否为关键边
            UnionFind uf = new UnionFind(n);
            int v = 0;
            for (int j = 0; j < m; j++) {
                if( i != j && uf.union(newEdges[j][0],newEdges[j][1]) ){
                    v += newEdges[j][2];
                }

            }
            if (uf.setCount != 1 || (uf.setCount ==1 && v > value)){
                ans.get(0).add(newEdges[i][3]);
                continue;
            }
            //判断是否为伪关键边
            uf = new UnionFind(n);
            uf.union(newEdges[i][0],newEdges[i][1]);
            v = newEdges[i][2];
            for (int j = 0; j < m; j++) {
                if (i != j && uf.union(newEdges[j][0],newEdges[j][1])) {
                    v += newEdges[j][2];
                }
            }
            if (v == value){
                ans.get(1).add(newEdges[i][3]);
            }
        }
        return ans;
    }
    class UnionFind{
        int[] parent;
        int[] size;
        int n ;
        // 当前联通分量数目
        int setCount;
        
        public UnionFind( int n){
            this.n = n;
            this.setCount = n;
            this.parent = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
            
        }
        public int find(int x){
            return parent[x] == x ? x : (parent[x] = find(parent[x]));
        }
        public boolean union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if (x_root == y_root){
                return false;
            }
            if (size[x_root] < size[y_root] ) {
               int temp = x_root;
               x_root = y_root;
               y_root = temp;
            }
            parent[y_root] = x_root;
            size[x_root] += size[y_root];
            setCount--;
            return true;
        }
    }
}
