package com.leetcode.editor.title_daily;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/11/9 9:28
 * @version： v1.0
 * @modified By:
 */
public class KClosest_1109 {
    public static void main(String[] args) {
        int [][] ponints = {{1,3},{2,-2},{1,1},{3,1}};
        int k = 2;
//        int [][] result =  new KClosest_1109().kClosest(ponints,k);
//        int [][] result =  new KClosest_1109().kClosest2(ponints,k);
        int [][] result =  new KClosest_1109().kClosest3(ponints,k);
        for (int i = 0; i <result.length ; i++) {
            System.out.println(Arrays.toString(result[i]));
        }

    }
    public int[][] kClosest(int[][] points, int K) {

//        Arrays.sort(points, (o1, o2) -> (o1[0]*o1[0] + o1[1]*o1[1]) - (o2[0]*o2[0]+o2[1]*o2[1]));
        Arrays.sort(points, Comparator.comparingInt(o -> (o[0] * o[0] + o[1] * o[1])));
        return Arrays.copyOfRange(points,0,K);
    }

    /**
     * 大根堆
     * @param points
     * @param K
     * @return
     */
    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (o1, o2) -> o2[0] - o1[0]
        );
        for (int i = 0; i < K; i++) {
            pq.offer(new int[]{points[i][0]*points[i][0]+points[i][1]*points[i][1],i});
        }
        int n =  points.length;
        for (int i = K ; i< n ;i++){
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            if (dist < pq.peek()[0]){
                pq.poll();
                pq.offer(new int[]{dist,i});
            }
        }
        int [][] ans = new int[K][2];
        for (int i = 0; i < K; i++) {
            ans[i] = points[pq.poll()[1]];
        }
        return ans;
    }

    public int[][] kClosest3(int[][] points, int K) {
        int n = points.length;
        random_select(points,0,n-1,K);
        return Arrays.copyOfRange(points,0,K);
    }

    private void random_select(int[][] points, int left, int right, int K) {

        int pivotId = left + new Random().nextInt( right-left +1);
        int pivot = points[pivotId][0] * points[pivotId][0] + points[pivotId][1] * points[pivotId][1];
        swap(points,right,pivotId);
        int i = left - 1;
        for (int j = left; j < right; ++j) {
            int dist = points[j][0]*points[j][0] + points[j][1]*points[j][1];
            if (dist <= pivot){
                i++;
                swap(points,i,j);
            }
        }
        i++;
        swap(points,i,right);
        if (K < i - left +1){
            random_select(points,left,i-1,K);
        }else if (K > i - left + 1) {
            random_select(points,i+1,right,K-(i-left+1));
        }
    }
    private void swap(int[][] points, int right, int pivotId) {
        int [] temp = points[right];
        points[right] = points[pivotId];
        points[pivotId] = temp;
    }

}
