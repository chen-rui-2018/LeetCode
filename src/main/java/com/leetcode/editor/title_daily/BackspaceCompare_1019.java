package com.leetcode.editor.title_daily;

import java.util.concurrent.ForkJoinPool;

/**
 * @author： chenr
 * @date： Created on 2020/10/19 9:26
 * @version： v1.0
 * @modified By:
 */
public class BackspaceCompare_1019 {
    public static void main(String[] args) {
        String s = "a##c";
        String  t = "#a#c";
        System.out.println( new BackspaceCompare_1019().backspaceCompare(s,t));
    }

    public boolean backspaceCompare(String S, String T) {
        int i = S.length()-1;
        int j = T.length()-1;
        int skips = 0;
        int skipt = 0;
        while (i >= 0 || j >= 0){
            while(i >= 0 ) {
                if (S.charAt(i) == '#') {
                    skips++;
                    i--;
                } else if (skips > 0) {
                    skips--;
                    i--;
                } else {
                    break;
                }
            }
                while (j >= 0){
                    if (T.charAt(j) == '#'){
                        skipt++;
                        j--;
                    }else if (skipt > 0){
                        skipt--;
                        j--;
                    }else {
                        break;
                    }
                }
                if (i >= 0 && j >=0){
                    if(S.charAt(i)!=T.charAt(j)){
                        return false;
                    }
                }else {
                    if (i >=0 || j>=0){
                        return false;
                    }
                }
                i--;
                j--;
            }
            return true;
        }



    public boolean backspaceCompare2(String S, String T) {

        return stingBuilder(S).equals(stingBuilder(T));
    }
    public String stingBuilder(String str){
        StringBuffer buffer = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) != '#'){
                buffer.append(str.charAt(i));
            }else {
                if(buffer.length() > 0){
                    buffer = buffer.deleteCharAt(buffer.length()-1);
                }
            }
        }
        return buffer.toString();
    }

    public boolean backspaceCompare1(String S, String T) {
        char[] chars = S.toCharArray();
        char[] chart = T.toCharArray();
        String newS = getNewString(chars);
        String newT = getNewString(chart);

        return newS.equals(newT);
    }
    public  String  getNewString(char[] chars){

        for(int i = chars.length-1; i >= 0; i--){
            if(chars[i]=='#'){
                chars[i] = '\0';
                for (int j = i-1; j >= 0 ; j--) {
                    if (chars[j] == '#' || chars[j] == '\0') {
                       continue;
                    }else {
                        chars[j] = '\0';
                        break;
                    }

                }
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] != '\0') {
                builder.append(chars[i]);
            }
        }
        return builder.toString();
    }
}
