package com.leetcode.daily_2021.february;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/2/18 15:37
 * @version： v1.0
 * @modified By:
 */
public class GetRow_0212 {
    public static void main(String[] args) {
        List<Integer>  list =    new GetRow_0212().getRow(6);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + ",");
        }
    }
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j <= i ; j++) {
                if (j == 0  || i == j) {
                    curr.add(1);
                }else {
                    curr.add(pre.get(j-1) +  pre.get(j));
                }
            }
            pre = curr;
        }
        return pre;
    }
    public List<Integer> getRow(int rowIndex) {
        List<Integer>list=new ArrayList<Integer>();
        list.add(1);
        for(int i=0;i<rowIndex;i++){
            for(int j=i;j>=1;j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;


    }
}
