package com.leetcode.daily_2021.february;

/**
 * @author： chenr
 * @date： Created on 2021/2/25 16:08
 * @version： v1.0d
 * @modified By:
 */
public class FlipAndInvertImage_0224 {
    public static void main(String[] args) {
        int[][] image = {{1,1,0,0},{1,0,0,1},{0,1,1,1},{1,0,1,0}};
        int [][] result = new FlipAndInvertImage_0224().flipAndInvertImage(image);
        System.out.println("111");
    }
    public int[][] flipAndInvertImage(int[][] image) {
        for (int[] ints : image) {
            int left = 0;
            int right = ints.length-1;
            int temp ;
            while ( left <= right) {
               temp =   ints[left];
               ints[left] = ints[right] ^ 1;
               ints[right] = temp ^ 1;
               left++;
               right--;
            }

        }
        return image;
    }
}
