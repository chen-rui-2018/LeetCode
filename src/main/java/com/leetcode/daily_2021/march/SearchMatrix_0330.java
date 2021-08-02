package com.leetcode.daily_2021.march;

/**
 * @author： chenr
 * @date： Created on 2021/3/30 22:12
 * @version： v1.0
 * @modified By:
 */
public class SearchMatrix_0330 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        int target = 3;
       boolean result =  new SearchMatrix_0330().searchMatrix(matrix,target);
        System.out.println(result);
    }
    /**
     *  一次遍历
     */
    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if(anInt == target){
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 二分查找
     *
     * */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int low = 0; int high = row*column-1;
        while (low <= high) {
            int mid = (high - low ) / 2 + low;
            int x = matrix[mid / column][mid % column];
            if (x < target) {
                low = mid + 1;
            }else if (x > target) {
                high = mid -1;
            }else {
                return true;
            }
        }
        return false;
    }

}
