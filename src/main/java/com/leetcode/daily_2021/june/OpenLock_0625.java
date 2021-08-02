package com.leetcode.daily_2021.june;

import com.sun.javafx.robot.FXRobotImage;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/6/25 16:16
 * @version： v1.0
 * @modified By:
 */
public class OpenLock_0625 {
    public static void main(String[] args) {

    }
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)){
            return 0;
        }
        Set<String> dead = new HashSet<>();
        for (String s : deadends) {
            dead.add(s);
        }
        if (dead.contains("0000")){
            return -1;
        }
        int step = 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        while (!queue.isEmpty()){
            ++step;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String status = queue.poll();
                for (String nextStatus:get(status)){
                    if (!seen.contains(nextStatus) && !dead.contains(nextStatus)) {
                        if (nextStatus.equals(target)){
                            return step;
                        }
                        queue.offer(nextStatus);
                        seen.add(nextStatus);
                    }
                }
            }
        }
        return -1;
    }

    public char numPrev(char x){
        return x == '0' ? '9' : (char)(x - 1);
    }
    public char numSucc(char x){
        return x == '9' ? '0' : (char)(x + 1);
    }
    public List<String> get(String staus){
        List<String> ret = new ArrayList<>();
        char[] array = staus.toCharArray();
        for (int i = 0; i < 4; i++) {
            char num =array[i];
            array[i] = numPrev(num);
            ret.add(new String(array));
            array[i] = numSucc(num);
            ret.add(new String(array));
            array[i] = num;
        }
        return ret;
    }
}
