package tencent;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/1/19 17:19
 * @version： v1.0
 * @modified By:
 */
public class ReverseString {
    public static void main(String[] args) {
        char[] s ={'h','e','l','l','o'};
        new ReverseString().reverseString(s);
        System.out.println(Arrays.toString(s));
    }
    public void reverseString(char[] s) {
        int j = s.length - 1;
        for (int i = 0; i < j; i++) {
            char temp = s[i];
            s[i] = s[j];
            s[j--] = temp;
        }

    }
}
