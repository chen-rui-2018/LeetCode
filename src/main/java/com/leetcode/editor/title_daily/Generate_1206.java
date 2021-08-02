package com.leetcode.editor.title_daily;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/12/7 15:52
 * @version： v1.0
 * @modified By:
 */
public class Generate_1206 {
    public static void main(String[] args) {
        List<List<Integer>>  result = new Generate_1206().generate(5);
        System.out.println(result.size());
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; ++i) {
            List<Integer> row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(row);
        }


        return  result;
    }
}
