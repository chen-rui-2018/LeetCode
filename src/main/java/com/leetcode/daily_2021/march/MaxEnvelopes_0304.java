package com.leetcode.daily_2021.march;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/3/4 9:17
 * @version： v1.0
 * @modified By:
 */
public class MaxEnvelopes_0304 {
    public static void main(String[] args) {
//        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        int[][] envelopes = {{2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}};

      int result  =  new MaxEnvelopes_0304().maxEnvelopes(envelopes);
        System.out.println(result);
    }
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length == 0){
            return 0;
        }
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return  o2[1] - o1[1];
            }
            return o1[0] - o2[0];
        });
        int res = 1;
        int length = envelopes.length;
        int [] f = new int[length];
        Arrays.fill(f,1);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if ( envelopes[j][1] < envelopes[i][1]){
                    f[i] = Math.max(f[i], f[j]+1);
                }
            }
            res = Math.max(res,f[i]);
        }
        return  res;
    }
}
