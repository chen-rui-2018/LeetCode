package com.leetcode.daily_2021.july;

import javax.sound.midi.Soundbank;

/**
 * @author： chenr
 * @date： Created on 2021/7/26 10:00
 * @version： v1.0
 * @modified By:
 */
public class MaximumTime_0724 {
    public static void main(String[] args) {
        String s = new MaximumTime_0724().maximumTime("19:?0");
        System.out.println(s);
    }

    public String maximumTime1(String time) {
        char[] chars = time.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                if (i == 0 && (chars[1] == '?' || chars[1] <= '3')) {
                    chars[i] = '2';
                } else if (i == 0) {
                    chars[i] = '1';
                }

                if (i == 1 && chars[0] != '2') {
                    chars[i] = '9';
                } else if (i == 1) {
                    chars[i] = '3';
                }

                if (i == 3) {
                    chars[i] = '5';
                }
                if (i == 4) {
                    chars[i] = '9';
                }
            }
        }
        return new String(chars);

    }

    public String maximumTime(String time) {
        char[] chars = time.toCharArray();
        if (chars[0] == '?' && (chars[1] == '?' || chars[1] <= '3')) {
            chars[0] = '2';
        } else if (chars[0] == '?'){
            chars[0] = '1';
        }

        if (chars[1] == '?' && chars[0] != '2') {
            chars[1] = '9';
        } else if (chars[1] == '?'){
            chars[1] = '3';
        }

        if (chars[3] == '?') {
            chars[3] = '5';
        }
        if (chars[4] == '?') {
            chars[4] = '9';
        }


        return new String(chars);
    }

}
