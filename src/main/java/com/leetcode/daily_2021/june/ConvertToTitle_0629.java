package com.leetcode.daily_2021.june;

/**
 * @author： chenr
 * @date： Created on 2021/6/29 9:46
 * @version： v1.0
 * @modified By:
 */
public class ConvertToTitle_0629 {
    public static void main(String[] args) {

        String str="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s = new ConvertToTitle_0629().convertToTitle(701);
        System.out.println(s);
    }
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber--;
            int ret  = columnNumber % 26;
            columnNumber = columnNumber / 26;
            sb.append((char)('A'+ret));
        }
        return sb.reverse().toString();
    }

}
