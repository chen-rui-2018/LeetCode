package com.leetcode.daily_2021.july;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/7/29 9:34
 * @version： v1.0
 * @modified By:
 */
public class PathInZigZagTree_0729 {

    public static void main(String[] args) {

        List<Integer> list = new PathInZigZagTree_0729().pathInZigZagTree(14);
        for (Integer integer : list) {
            System.out.print(integer+", ");
        }
    }

    public List<Integer> pathInZigZagTree(int label) {
        int row = 1, rowStart = 1;
        while (rowStart * 2 <= label) {
            row++;
            rowStart *= 2;
        }
        if (row % 2 == 0) {
            label = getReverse(label, row);
        }
        List<Integer> path = new ArrayList<>();
        while(row > 0){
            if (row % 2 == 0 ){
                path.add(getReverse(label,row));
            }else {
                path.add(label);
            }
            row--;
            label >>= 1;
        }
        Collections.reverse(path);
        return path;
    }

    private int getReverse(int label, int row) {

        return (1 << row - 1) + (1 << row) - 1 - label;
    }
}