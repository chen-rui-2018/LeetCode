package com.leetcode.daily_2021.july;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2021/7/26 17:05
 * @version： v1.0
 * @modified By:
 */
public class MinOperations_0726 {
    public static void main(String[] args) {
            int [] target = {6,4,8,1,3,2};
            int [] arr = {4,7,6,2,3,8,6,1};
        int i = new MinOperations_0726().minOperations(target, arr);
        System.out.println(i);
    }

    public int minOperations(int[] target, int[] arr) {
        int n = target.length;
        Map<Integer, Integer> pos = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos.put(target[i], i);
        }
        List<Integer> d = new ArrayList<>();
        for (int val : arr) {
            if (pos.containsKey(val)) {
                int index = pos.get(val);
                int it = binarySearch(d, index);
                if (it != d.size()) {
                    d.set(it, index);
                } else {
                    d.add(index);
                }
            }
        }

        return n-d.size();
    }

    private int binarySearch(List<Integer> d, int index) {
        int size = d.size();
        if (size == 0 || d.get(size - 1) < index) {
            return size;
        }
        int low = 0, high = size - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (d.get(mid) < index) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
