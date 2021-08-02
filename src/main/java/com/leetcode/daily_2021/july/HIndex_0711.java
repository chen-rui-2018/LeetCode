package com.leetcode.daily_2021.july;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/7/12 14:03
 * @version： v1.0
 * @modified By:
 */
public class HIndex_0711 {
    public static void main(String[] args) {
        int[] citations = {3,0,6,1,5};
        int h = new HIndex_0711().hIndex(citations);
        System.out.println(h);

    }
    public int hIndex1(int[] citations) {
        Arrays.sort(citations);
        int i= citations.length-1;
        int h = 0;
        while (i>= 0 && h < citations[i]){
            h++;
            i--;
        }
        return h;
    }
    public int hIndex(int[] citations) {
        int n = citations.length;
        int tot = 0;
        int [] counter = new int[n+1];
        for (int i = 0; i < n; i++) {
            if (citations[i] >= n){
                counter[n]++;
            }else {
                counter[citations[i]]++;
            }

        }
        for (int i = n; i >= 0; i--) {
            tot += counter[i];
            if (tot >= i) {
                return i;
            }
        }
        return 0;
    }
}
