package com.leetcode.editor.title_daily;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author： chenr
 * @date： Created on 2020/11/23 9:38
 * @version： v1.0
 * @modified By:
 */
public class FindMinArrowShots_1123 {
    public static void main(String[] args) {
//        int [][] points = {{10,16},{2,8},{1,6},{7,12}};
//        int [][] points = {{1,2},{3,4},{5,6},{7,8}};
//        int [][] points = {{-2147483646,-2147483645},{2147483646,2147483647}};
        int [][] points = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int times = new FindMinArrowShots_1123().findMinArrowShots(points);
        System.out.println(times);
    }
    public int findMinArrowShots(int[][] points) {
        int sum = 0;
        if (points == null || points.length == 0){
            return sum;
        }
        Arrays.sort(points, (o1, o2) -> {
            if(o1[1] > o2[1]){
                return 1;

            }else if (o1[1] < o2[1]) {
                return -1;
            }
            return 0;
        });
        int i = 1;
        int j = 0;
        while(i < points.length  && j < points.length){
            if(points[j][1] < points[i][0]){
                j = i;
                sum++;
            }
            i++;
        }
        return ++sum;
    }
}
