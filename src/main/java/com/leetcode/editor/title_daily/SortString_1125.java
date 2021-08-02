package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/11/25 15:13
 * @version： v1.0
 * @modified By:
 */
public class SortString_1125 {
    public static void main(String[] args) {
//        String str = "aaaabbbbcccc";
//        String str = "rat";
        String str = "leetcode";
        System.out.println( new SortString_1125().sortString(str));

    }
    public String sortString(String s) {
        int []  num = new int[26];
        for (int i = 0; i < s.length(); i++) {
            num[s.charAt(i)-'a']++;
        }
        StringBuffer ans = new StringBuffer();

        while(ans.length() < s.length()){
            for (int i = 0; i < num.length; i++) {
                if(num[i] > 0){
                    ans.append((char)(i+'a'));
                    num[i]--;
                }
            }
            for (int i = num.length-1; i >=0; i--) {
                if(num[i] > 0){
                    ans.append((char)(i+'a'));
                    num[i]--;
                }
            }
        }
        return ans.toString();
    }

}
