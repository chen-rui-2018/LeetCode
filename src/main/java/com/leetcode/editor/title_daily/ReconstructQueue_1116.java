package com.leetcode.editor.title_daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2020/11/16 9:39
 * @version： v1.0
 * @modified By:
 */
public class ReconstructQueue_1116 {
    public static void main(String[] args) {
        int [][] people = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
//        int [][] result = new ReconstructQueue_1116().reconstructQueue(people);
        int [][] result = new ReconstructQueue_1116().reconstructQueue2(people);
        for (int[] ints : result) {
            System.out.print(Arrays.toString(ints)+",");
        }

    }
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o1[0] != o2[0]) {
                return o1[0] - o2[0];
            }else {
                return o2[1] - o1[1];
            }
        });
        int n = people.length;
        int[][] ans = new int[n][];

        for (int[] person : people) {
            int spaces  =  person[1] + 1;
            for (int i = 0; i < n; i++) {
                if(ans[i] == null){
                    --spaces;
                    if(spaces == 0){
                        ans[i] = person;
                        break;
                    }
                }
            }
        }
        return ans;
    }
    public int[][] reconstructQueue2(int[][] people) {
        Arrays.sort(people,(person1,person2)->{
            if(person1[0] !=  person2[0]){
                return person2[0] - person1[0];
            }else {
                return person1[1] - person2[1];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for (int[] person : people) {
            ans.add(person[1],person);
        }
        return ans.toArray(new  int[ans.size()][]);
    }
}
