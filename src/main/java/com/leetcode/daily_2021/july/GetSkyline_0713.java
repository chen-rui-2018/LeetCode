package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/13 9:25
 * @version： v1.0
 * @modified By:
 */
public class GetSkyline_0713 {
    public static void main(String[] args) {
        int[][] buikdings = {{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        List<List<Integer>> skyline = new GetSkyline_0713().getSkyline(buikdings);
        System.out.println(skyline);
    }
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->b[1]-a[1]);
        List<Integer> boundaries = new ArrayList<>();
        for (int[] building : buildings) {
            boundaries.add(building[0]);
            boundaries.add(building[1]);
        }
        Collections.sort(boundaries);
        List<List<Integer>> ret = new ArrayList<>();
        int n = buildings.length;
        int idx = 0;
        for (Integer boundary : boundaries) {
            while (idx < n && buildings[idx][0] <= boundary ){
                pq.offer(new int[]{buildings[idx][1],buildings[idx][2]});
                idx++;
            }
            while (!pq.isEmpty() && pq.peek()[0] <= boundary) {
                pq.poll();
            }
            int maxn = pq.isEmpty()?0:pq.peek()[1];
            if (ret.size() == 0 || maxn != ret.get(ret.size()-1).get(1)) {
                ret.add(Arrays.asList(boundary,maxn));
            }
        }
       return ret;
    }
}
