package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/10/30 9:57
 * @version： v1.0
 * @modified By:
 */
public class IslandPerimeter_1030 {
    public static void main(String[] args) {
        int [][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        System.out.println( new IslandPerimeter_1030().islandPerimeter(grid));
    }
    public int islandPerimeter(int[][] grid) {
        if(grid == null){
            return 0;
        }
        int x = grid.length;
        int y = grid[0].length;
        int perimeter = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (grid[i][j] == 1){
                    perimeter += 4;

                    if( i < x-1 && grid[i+1][j] == 1 ){
                        perimeter -= 2;
                    }
                    if( j < y-1 && grid[i][j+1] == 1 ){
                        perimeter -= 2;
                    }
                }

            }
        }
        return perimeter;

    }
}
