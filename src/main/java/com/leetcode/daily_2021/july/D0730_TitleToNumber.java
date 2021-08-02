package com.leetcode.daily_2021.july;

import org.springframework.aop.scope.ScopedProxyUtils;

/**
 * @author： chenr
 * @date： Created on 2021/7/30 15:07
 * @version： v1.0
 * @modified By:
 */
public class D0730_TitleToNumber {
    public static void main(String[] args) {
        int aa = new D0730_TitleToNumber().titleToNumber("AA");
        System.out.println(aa);
    }
    public int titleToNumber1(String columnTitle) {
        char [] chars = columnTitle.toCharArray();
        int result = 0;
        int length = chars.length;
        for (int i = length-1; i >= 0; i--) {
            result += ((chars[i]-'A') + 1) * Math.pow(26,length-1-i);
        }
        return result;
    }
    public int titleToNumber(String columnTitle) {

        int result = 0;
        int multiple = 1;
        for (int i = columnTitle.length()-1; i >= 0; i--) {
            result += ((columnTitle.charAt(i)-'A') + 1) * multiple;
            multiple *= 26;
        }
        return result;
    }
}
