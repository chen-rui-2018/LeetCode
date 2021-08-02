package com.leetcode.daily_2021.june;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/6/21 9:29
 * @version： v1.0
 * @modified By:
 */
public class ReadBinaryWatch_0621 {
    public static void main(String[] args) {
        List<String> list = new ReadBinaryWatch_0621().readBinaryWatch(1);
        list.stream().forEach(l -> System.out.println(l));
        System.out.println(Integer.bitCount(3));
    }

    public List<String> readBinaryWatch1(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int i = 0; i < 60; i++) {
                if (Integer.bitCount(h) + Integer.bitCount(i) == turnedOn) {
                    list.add(h + ":" + (i < 10 ? "0" : "") + i);
                }
            }
        }
        return list;
    }

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 1024; i++) {
            int h = i >> 6;
            int m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                list.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return list;
    }
}
