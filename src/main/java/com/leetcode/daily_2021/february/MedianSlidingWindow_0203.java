package com.leetcode.daily_2021.february;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author： chenr
 * @date： Created on 2021/2/7 13:50
 * @version： v1.0
 * @modified By:
 */
public class MedianSlidingWindow_0203 {
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483648,2147483647,-2147483648,-2147483648,-2147483648,2147483647,2147483647,2147483647,2147483647,-2147483648,2147483647,-2147483648};
        int k = 3;

        double[] result = new MedianSlidingWindow_0203().medianSlidingWindow(nums,k);
        System.out.println(Arrays.toString(result));

    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        DualHeap dualHeap = new DualHeap(k);
        for (int i = 0; i < k; i++) {
            dualHeap.insert(nums[i]);
        }
        double[] ans = new double[nums.length-k+1];
        ans[0] = dualHeap.getMedian();
        for (int i = k; i < nums.length; i++) {
            dualHeap.insert(nums[i]);
            dualHeap.erase(nums[i-k]);
            ans[i-k+1] = dualHeap.getMedian();
        }
        return  ans;
    }
    class DualHeap{

        private PriorityQueue<Integer> small;
        private PriorityQueue<Integer> large;
        private Map<Integer,Integer> delayed;
        private  int k;
        private int smallSize,largeSize;
        public  DualHeap (int k) {
            this.small = new PriorityQueue<>((o1,o2)-> o2.compareTo(o1));
            this.large = new PriorityQueue<>((o1,o2)-> o1.compareTo(o2));
            this.delayed = new HashMap<>();
            this.k = k;
            this.smallSize = 0;
            this.largeSize = 0;
        }
        public double getMedian(){
            return (k & 1) == 1 ? small.peek():  ((double)small.peek() + large.peek()) / 2;
        }
        public  void insert (int num) {
            if (small.isEmpty() || num <= small.peek()){
                    small.offer(num);
                smallSize++;
            }else {
                large.offer(num);
                largeSize++;
            }
            makeBalance();
        }
        public  void erase(int num) {
            delayed.put(num,delayed.getOrDefault(num,0)+1);
            if (num <= small.peek()){
                --smallSize;
                if (num == small.peek()){
                    prune(small);
                }
            }else {
                --largeSize;
                if (num == large.peek()){
                    prune(large);
                }
            }
            makeBalance();
        }
        public void prune(PriorityQueue<Integer> queue){
            while (!queue.isEmpty()){
                int num = queue.peek();
                if (delayed.containsKey(num)){
                    delayed.put(num,delayed.get(num)-1);
                    if (delayed.get(num) == 0){
                        delayed.remove(num);
                    }
                    queue.poll();
                }else {
                    break;
                }
            }

        }
        public void makeBalance(){
            if (smallSize > largeSize +1){
                large.offer(small.poll());
                --smallSize;
                ++largeSize;
                prune(small);
            }else if(smallSize < largeSize){
                small.offer(large.poll());
                ++smallSize;
                --largeSize;
                prune(large);
            }

        }
    }
}
