package com.leetcode.editor.title_daily;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author： chenr
 * @date： Created on 2020/10/28 10:39
 * @version： v1.0
 * @modified By:
 */
public class UniqueOccurrences_1028 {
    public static void main(String[] args) {
        int [] arr = {1,2,2,1,1,3};
        System.out.println( new UniqueOccurrences_1028().uniqueOccurrences(arr));
        String hello = "hello";
        int index =   hello.indexOf("ll");
        System.out.println(index);
        System.out.println((int)'e');
    }
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer,Integer> map  = new HashMap<>(16);
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> set = new HashSet<>();
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(!set.add(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}
