package com.leetcode.daily_2021.january;

/**
 * @author： chenr
 * @date： Created on 2021/1/25 16:37
 * @version： v1.0
 * @modified By:
 */
public class RegionsBySlashes_0125 {
    public static void main(String[] args) {
        String [] grid = {" /","/ "};
        System.out.println(new RegionsBySlashes_0125().regionsBySlashes(grid));
    }
    public int regionsBySlashes(String[] grid) {
        int N = grid.length;
    int size = 4 * N *N;
    UnionFind unionFind= new UnionFind(size);
        for (int i = 0; i < N; i++) {
        char[] row = grid[i].toCharArray();
        for (int j = 0; j < N; j++) {
            // 二维网格 转换为 一维网格
            int index = 4 * (i * N + j);
            char c = row[j];
            // 单元格内合并
            if ( c == '/'){
                // 合并 0,3  1,2
                unionFind.union(index ,index + 3);
                unionFind.union(index + 1 ,index + 2);
            } else if ( c == '\\') {
                // 合并 0,1  2,3
                unionFind.union(index ,index + 1);
                unionFind.union(index + 2 ,index + 3);
            }else {
                //c == ' ' 合并整个单元格
                unionFind.union(index,index +1);
                unionFind.union(index +1,index +2);
                unionFind.union(index +2,index +3);
            }
            // 合并单元格间
            // 向右合并:1(当前) ,3(右一列)
            if ( j+1 < N){
                unionFind.union(index + 1,4 * (i * N + j +1) + 3);
            }
            // 向下合并: 2 (当前) ,0(下一行)
            if (i+1 < N){
                unionFind.union(index+2, 4*((i+1) *N + j));
            }
        }
    }
        return unionFind.getCount();
}
class UnionFind{
    private int [] parent;
    private int count;
    public int getCount(){
        return count;
    }
    public UnionFind(int n) {
        this.count = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public  int find (int x){
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public  void union(int x, int y){
        int x_root = find(x);
        int y_root = find(y);
        if(x_root == y_root){
            return;
        }
        parent[x_root] = y_root;
        count--;
    }
}
}
