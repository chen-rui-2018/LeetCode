package com.leetcode.daily_2021.june;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/6/24 9:43
 * @version： v1.0
 * @modified By:
 */
public class MaxPoints_0624 {
    public static void main(String[] args) {
//       int [][]  points = {{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
       int [][]  points = {{2,3},{3,3},{-5,3}};
        int i = new MaxPoints_0624().maxPoints(points);
        int y = new xll().maxPoints(points);
        System.out.println(i);
        System.out.println(y);
    }

    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2){
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n-i || ret > n / 2){
                break;
            }
            Map<Integer,Integer> map = new HashMap<>();
            for (int j = i+1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1; 
                }else {
                    if (y < 0){
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x),Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
               int key = y + x * 20001;
                map.put(key,map.getOrDefault(key,0)+1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn,num+1);
            }
            ret = Math.max(ret,maxn);
         }
        return ret;
    }

    private int gcd(int a, int b) {
        return b != 0 ? gcd(b,a % b) : a;
    }

}
class xll{
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n <= 2) {
            return n;
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (ret >= n - i || ret > n / 2) {
                break;
            }
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = i + 1; j < n; j++) {
                int x = points[i][0] - points[j][0];
                int y = points[i][1] - points[j][1];
                if (x == 0) {
                    y = 1;
                } else if (y == 0) {
                    x = 1;
                } else {
                    if (y < 0) {
                        x = -x;
                        y = -y;
                    }
                    int gcdXY = gcd(Math.abs(x), Math.abs(y));
                    x /= gcdXY;
                    y /= gcdXY;
                }
                int key = y + x * 20001;
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            int maxn = 0;
            for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
                int num = entry.getValue();
                maxn = Math.max(maxn, num + 1);
            }
            ret = Math.max(ret, maxn);
        }
        return ret;
    }

    public int gcd(int a, int b) {
        return b != 0 ? gcd(b, a % b) : a;
    }


}