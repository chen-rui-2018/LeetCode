package com.leetcode.daily_2021.january;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/1/19 11:50
 * @version： v1.0
 * @modified By:
 */
public class MinCostConnectPoints_0119 {
    public static void main(String[] args) {
//        int[][] points = {{0,0},{1,1},{1,0},{-1,1}};
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,10}};
        int ans = new MinCostConnectPoints_0119().minCostConnectPoints(points);
        System.out.println(ans);
    }
    public int minCostConnectPoints1(int[][] points) {
        int n = points.length;
        DisjoinSet disjoinSet = new DisjoinSet(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                edges.add(new Edge(dist(points,i,j),i,j));
            }
        }
        Collections.sort(edges, (o1, o2) -> o1.len - o2.len);
        int result = 0;
        int num = 1;
        for (Edge edge : edges) {
            int len = edge.len;
            int x = edge.x;
            int y = edge.y;
            if(disjoinSet.unionSet(x,y)){
                result += len;
                num++;
                if (num == n){
                    break;
                }
            }
        }
        return result;
    }

    private int dist(int[][] points, int i, int j) {
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }

    class DisjoinSet{
        int [] parent;
        int [] rank;
        int n;
        public DisjoinSet(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.n = n;
            for (int i = 0; i < n; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
        }
        public int  find (int x){
            if (x != parent[x]){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
        public  boolean unionSet(int x,int y){
            int x_root = find(x);
            int y_root = find(y);
            if(x_root == y_root){
                return false;
            }
            if (rank[x_root] < rank [y_root]) {
                int temp = x_root;
                x_root = y_root;
                y_root = temp;
            }
            rank[x_root] += rank[y_root];
            parent[y_root] = x_root;

            return true;
        }
    }
    class Edge{
        int len,x,y;
        public Edge(int len, int x,int y){
            this.len = len;
            this.x = x;
            this.y = y;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        int vertsxes = points.length;
        if (vertsxes < 2){
            return 0;
        }
        int checkPoint = 0;
        int cost = 0;
        int [] lowcost = new int[vertsxes];
        Arrays.fill(lowcost, Integer.MAX_VALUE);
        lowcost[0] = 0;
        for (int i = 0; i < vertsxes -1; i++) {
            int minDist = Integer.MAX_VALUE;
            int temp = checkPoint;
            for (int j = 0; j < vertsxes; j++) {
                if (lowcost[j] > 0){
                    lowcost[j] = Math.min(lowcost[j],manhaton(points,j,checkPoint));
                    if (lowcost[j] < minDist){
                        minDist = lowcost[j];
                        temp = j;
                    }
                }
            }
            checkPoint = temp;
            lowcost[checkPoint] = 0;
            cost += minDist;
        }
        return cost;
    }

    private int manhaton(int[][] points, int i, int j) {
        return Math.abs(points[i][0]-points[j][0]) + Math.abs(points[i][1]-points[j][1]);
    }
}
