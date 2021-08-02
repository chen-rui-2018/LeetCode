package com.leetcode.daily_2021.january;

/**
 * @author： chenr
 * @date： Created on 2021/1/17 10:53
 * @version： v1.0
 * @modified By:
 */
public class CheckStraightLine_0117 {
    public static void main(String[] args) {
        int[][] coordinates = {{1,2},{2,3},{3,4},{4,5},{5,6}};
       boolean ans = new CheckStraightLine_0117().checkStraightLine(coordinates);
        System.out.println(ans);
    }
    public boolean checkStraightLine(int[][] coordinates) {
        int deltaX = coordinates[0][0];
        int deltaY = coordinates[0][1];
        int n = coordinates.length;
        for (int i = 0; i < n; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1];
        int B = -coordinates[1][0];
        for (int i = 2; i < n; i++) {
            int x = coordinates[i][0];
            int y = coordinates[i][1];
            if(A * x + B * y != 0){
                return false;
            }
        }
        return true;

    }
}
