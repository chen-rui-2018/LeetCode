package com.leetcode.daily_2021.january;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/1/29 9:21
 * @version： v1.0
 * @modified By:
 */
public class MinimumEffortPath_0129 {
    public static void main(String[] args) {
        int [][] heights = {{1,2,2},{3,8,2},{5,3,5}};
//        int [][] heights = {{1,10,6,7,9,10,4,9}};
//   int [][] heights = {{4,3,4,10,5,5,9,2},{10,8,2,10,9,7,5,6},{5,8,10,10,10,7,4,2},{5,1,3,1,1,3,1,9},{6,4,10,6,10,9,4,6}};
      int ans =   new MinimumEffortPath_0129().minimumEffortPath(heights);
        System.out.println(ans);
    }
    // 不可以贪心
    public int minimumEffortPath1(int[][] heights) {
        int row = heights.length - 1;
        int col = heights[0].length - 1;
        int leftPath = 0;
        int upPath = 0;
        int minEffort = 0;
        int curr = heights[row][col];
        while (row > 0 || col > 0) {
            if (col > 0) {
                leftPath = Math.abs(curr - heights[row][col - 1]);
            }else {
                leftPath = Integer.MAX_VALUE;
            }
            if (row > 0) {
                upPath = Math.abs(curr - heights[row - 1][col]);
            }else{
                upPath = Integer.MAX_VALUE;
            }
            int minValue = Math.min(leftPath,upPath);
            if (leftPath > upPath  && row > 0) {
                row--;
                curr =  heights[row][col];
            }else if(col > 0) {
                col--;
                curr = heights[row][col];
            }
            minEffort = Math.max(minValue,minEffort);
        }
        return minEffort;
    }
    //二分查找
    int [][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    public int minimumEffortPath2(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int left = 0;
        int right = 999999;
        int ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});
            boolean[] seen =  new boolean[m*n];
            seen[0] = true;
            while (!queue.isEmpty()){
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int i = 0; i < 4; i++) {
                    int nx = x + dirs[i][0];
                    int ny = y + dirs[i][1];
                    boolean  temp = nx >= 0 && nx < m && ny >= 0 && ny < n && !seen[nx * n + ny] && Math.abs(heights[x][y] - heights[nx][ny]) <= mid;
                    if (temp){
                        queue.offer(new int[]{nx,ny});
                        seen[nx*n + ny] = true;
                    }
                }
            }
            if (seen[m*n-1]){
                ans = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return  ans;
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
        Collections.sort(edges,(o1,o2)->o1[2]-o2[2]);
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
    class UnionFind{
        private  int [] parent;
        private  int [] rank;
        public UnionFind (int n) {
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }
        //找根
        public int find (int x){
            return x == parent[x] ? parent[x] : find(parent[x]);
        }
        //合并
        public void union(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root){
                return;
            }
            if (rank[x_root] < rank[y_root]){
                parent[x_root] = y_root;
            } else if (rank[x_root] > rank[y_root]){
                parent[y_root] = x_root;
            }else {
                parent[x_root] = y_root;
                rank[y_root]++;
            }
        }
        //判断是否处于同一联通分量
        public boolean isUnion(int x, int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root){
                return true;
            }
            return false;
        }
    }
}
