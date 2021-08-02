package com.leetcode.daily_2021.july;

import java.lang.annotation.Target;
import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/12 9:17
 * @version： v1.0
 * @modified By:
 */
public class TimeMap {
    /**
     * Initialize your data structure here.
     */
    Map<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(pair);
        map.put(key, list);
    }

    public String get(String key, int timestamp) {
        List<Pair> pairs = map.getOrDefault(key, new ArrayList<>());
        Pair pair = new Pair(String.valueOf((char) 127), timestamp);
        int i = binarySearch(pairs, pair);
        if (i > 0) {
            return pairs.get(i - 1).value;
        }
        return "";


    }

    private int binarySearch(List<Pair> pairs, Pair target) {
        int low = 0, high = pairs.size() - 1;
        if (high < 0 || pairs.get(high).compareTo(target) <= 0) {
            return high + 1;
        }
        while (low < high) {
            int mid = (high - low) / 2 + low;
            Pair pair = pairs.get(mid);
            if (pair.compareTo(target) <= 0) {
                low = mid + 1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    class Pair implements Comparable<Pair>{
        private String value;
        private int timestamp;

        public Pair(String value, Integer timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }

        @Override
        public int hashCode() {
            return timestamp + value.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (o instanceof Pair) {
                Pair pair2 = (Pair) o;
                return this.timestamp == pair2.timestamp && this.value.equals(pair2.value);
            }
            return false;
        }
        @Override
        public int compareTo(Pair pair2) {
            if (this.timestamp != pair2.timestamp) {
                return this.timestamp - pair2.timestamp;
            } else {
                return this.value.compareTo(pair2.value);
            }
        }

    }
}
