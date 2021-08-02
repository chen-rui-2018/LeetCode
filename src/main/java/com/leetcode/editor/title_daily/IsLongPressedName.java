package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/10/21 16:29
 * @version： v1.0
 * @modified By:
 */
public class IsLongPressedName {
    public static void main(String[] args) {
        String name = "hello";
        String typed = "hhee";
        System.out.println(new IsLongPressedName().isLongPressedName(name,typed));

    }
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;
        int j = 0;
        while( j < typed.length() ){
            if(i < name.length() && name.charAt(i) == typed.charAt(j)){
                i++;
                j++;
            }else if ( j > 0 && typed.charAt(j) == typed.charAt(j-1)) {
                    j++;
            }else {
                    return false;
                }
            }

        return i==name.length();
    }

}
