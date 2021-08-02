package com.leetcode.editor.title_daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author： chenr
 * @date： Created on 2020/12/11 9:42
 * @version： v1.0
 * @modified By:
 */
public class PredictPartyVictory_1211 {
    public static void main(String[] args) {
        String senate = "RRDDD";
        String result = new PredictPartyVictory_1211().predictPartyVictory(senate);
        System.out.println(result);
    }
    public String predictPartyVictory(String senate) {
        int length = senate.length();
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            if(senate.charAt(i) == 'R'){
                radiant.offer(i);
            }else {
                dire.offer(i);
            }
        }
        while(!radiant.isEmpty() && !dire.isEmpty()){
            int indexRadiant = radiant.poll();
            int indexDire = dire.poll();
            if(indexRadiant < indexDire){
                radiant.offer(indexRadiant + length);
            }else {
                dire.offer(indexDire + length);
            }
        }
        return radiant.isEmpty() ? "Dire" : "Radiant";
    }
}
