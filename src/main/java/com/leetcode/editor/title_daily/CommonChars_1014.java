package com.leetcode.editor.title_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/10/14 11:23
 * @version： v1.0
 * @modified By:
 */
public class CommonChars_1014 {
    public static void main(String[] args) {
        String [] param = {"bella","label","roller"};
      List<String> result = new CommonChars_1014().commonChars(param);
        System.out.println(result.size());

    }
    public List<String> commonChars(String[] A) {
        int [] minValue = new int[26];
        Arrays.fill(minValue,Integer.MAX_VALUE);
        for (int i = 0; i < A.length; i++) {
            int [] preValue = new int[26];
            int length = A[i].length();
            for (int j = 0; j < length;j++) {
                char ch = A[i].charAt(j);
                preValue[ch-'a']++;
            }
            for (int k = 0; k < preValue.length; k++) {
                minValue[k] = Math.min(minValue[k],preValue[k]);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < minValue.length; i++) {
            for (int j = 0; j < minValue[i]; j++) {
                ans.add(String.valueOf((char)(i+'a')));
            }
        }
        return ans;
    }

}
