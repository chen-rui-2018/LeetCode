package com.leetcode.editor.title_daily;

import org.springframework.beans.BeanUtils;

import java.util.Comparator;
import java.util.FormatterClosedException;
import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2020/11/30 9:10
 * @version： v1.0
 * @modified By:
 */
public class ReorganizeString_1130 {
    public static void main(String[] args) {
        String S = "zhmyo";
        System.out.println(new ReorganizeString_1130().reorganizeString(S));
        System.out.println(new ReorganizeString_1130().reorganizeString2(S));

    }
    public String reorganizeString(String S) {
        int length = S.length();
        if (length < 2){
            return S;
        }
        int[] counts = new int[26];
        int maxCount = 0;
        for (int i = 0; i < S.length(); i++) {
            counts[S.charAt(i)-'a']++;
            maxCount = Math.max(maxCount, counts[S.charAt(i)-'a']);
        }
        if (maxCount > (length+1)/2){
            return "";
        }
        int odd = 1;
        int even = 0;
        int halfLength = length/2;
        char [] result = new char[length];
        for (int i = 0; i < counts.length; i++) {
            while(counts[i] > 0 && counts[i] <= halfLength && odd < length ){
                result[odd] = (char) (i+'a');
                odd+=2;
                counts[i]--;
            }
            while(counts[i] > 0){
                result[even] = (char) (i+'a');
                even += 2;
                counts[i]--;
            }
        }
        return String.valueOf(result);
    }

    public String reorganizeString2(String S) {
        if(S.length() < 2){
            return S;
        }
        int[] counts = new int[26];
        int maxCount  = 0;
        int length = S.length();
        for (int i = 0; i < length; i++) {
            char c = S.charAt(i);
            int count = ++counts[c-'a'];
            maxCount = Math.max(maxCount,count);
        }
        if(maxCount > (length+1)/2){
            return "";
        }
        PriorityQueue<Character> queue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return counts[o2-'a'] - counts[o1-'a'];
            }
        });
        for (char c = 'a';  c <= 'z'; c++) {
            if (counts[c - 'a'] > 0){
                queue.offer(c);
            }
        }
        StringBuffer sb = new StringBuffer();
        while(queue.size() > 1){
            char letter1 = queue.poll();
            char letter2 = queue.poll();
            sb.append(letter1);
            sb.append(letter2);
            int index1 = letter1 - 'a';
            int index2 = letter2 - 'a';
            counts[index1]--;
            counts[index2]--;
            if(counts[index1] > 0){
                queue.offer(letter1);
            }
            if(counts[index2] > 0){
                queue.offer(letter2);
            }

        }
        if(queue.size() > 0){
            sb.append(queue.poll());
        }
        return sb.toString();
    }
}
