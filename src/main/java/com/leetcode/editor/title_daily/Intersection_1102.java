package com.leetcode.editor.title_daily;

import java.awt.font.NumericShaper;
import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/11/2 9:06
 * @version： v1.0
 * @modified By:
 */
public class Intersection_1102 {
    public static void main(String[] args) {

        int[] nums1 = {1,2};
        int[] nums2 = {2,1};
//        int[] ans =  new Intersection_1102().intersection(nums1,nums2);
        int[] ans =  new Intersection_1102().intersection2(nums1,nums2);
        System.out.println(Arrays.toString(ans));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer>  set1 = new HashSet<>();
        Set<Integer>  set2 = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        if (nums1.length ==0 || nums2.length == 0){
            return  ans.stream().mapToInt(Integer::valueOf).toArray();
        }
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
          set2.add(nums2[i]);
        }
        Iterator<Integer> iterator =   set1.iterator();
        while (iterator.hasNext()){
           int temp =iterator.next();
            if(set2.contains(temp)){
                ans.add(temp);
            }
        }
        return  ans.stream().mapToInt(Integer::valueOf).toArray();
    }
    public int[] intersection2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int k = 0;
        int lenght1= nums1.length;
        int lenght2= nums2.length;
        int [] ans = new int [lenght1+lenght2];
        while (i < lenght1 && j <lenght2){
            int num1 = nums1[i];
            int num2 = nums2[j];
            if (num1 == num2){
                if (k == 0 || ans[k-1] !=  num1){
                    ans[k] = num1;
                    k++;
                }
                i++;
                j++;
            }else if(num1 < num2){
                i++;
            }else {
                j++;
            }

        }
        return Arrays.copyOfRange(ans,0,k);
    }

}
