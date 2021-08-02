package com.leetcode.daily_2021.february;

import java.util.Arrays;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 10:31
 * @version： v1.0
 * @modified By:
 */
public class MaxScore_0206 {
    public static void main(String[] args) {
        int[] cardPoints = {1,79,80,1,1,1,200,1};
       int result =   new MaxScore_0206().maxScore(cardPoints,3);
        System.out.println(result);
    }
    public int maxScore(int[] cardPoints, int k) {

        int n = cardPoints.length;
        int minScore = 0;

        for (int i = 0; i < n-k; i++) {
            minScore += cardPoints[i];
        }
        int sum = minScore;
        for (int i = n-k; i < n; i++) {
             sum =  sum - cardPoints[i-n+k] + cardPoints[i];
            minScore = Math.min(sum,minScore);
        }
        return Arrays.stream(cardPoints).sum()- minScore;
    }


}
