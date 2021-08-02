package com.leetcode.daily_2021.january;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author： chenr
 * @date： Created on 2021/1/14 16:33
 * @version： v1.0
 * @modified By:
 */
public class client {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {2, 4}, {3, 4}, {2, 5}};
        int [] src = {0,1,2,3,4,5};
        DisJointSet disJointSet = new DisJointSet(6);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String str = scanner.nextLine();
            String[] strs = str.split(" ");
            if (strs.length >= 2) {
                int x = Integer.valueOf(strs[0]);
                int y = Integer.valueOf(strs[1]);

                disJointSet.merge(x, y);
                System.out.println(disJointSet.findRoot(x));
                System.out.println(disJointSet.findRoot(y));
            } else {
                int x = Integer.valueOf(strs[0]);
                System.out.println(disJointSet.findRoot(x));
            }


            System.out.println(Arrays.toString(src));
            System.out.println(Arrays.toString(disJointSet.parent));
            System.out.println(Arrays.toString(disJointSet.rank));


        }


    }
}
