package com.leetcode.daily_2021.january;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/1/11 9:26
 * @version： v1.0
 * @modified By:
 */
public class SmallestStringWithSwaps_0111 {
    public static void main(String[] args) {
        String s = "dcab";
        List<List<Integer>> pairs = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        list1.add(0);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(2);
        pairs.add(list1);
        pairs.add(list2);
        String ans =    new SmallestStringWithSwaps_0111().smallestStringWithSwaps(s,pairs);
        System.out.println(ans);
    }
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        if (pairs.size() == 0) {
            return s;
        }
        // 第一步:将任意交换的节点对输入并查集
        int len = s.length();
        UnionFind unionFind = new UnionFind(len);
        for (List<Integer> pair : pairs) {
            int index1 = pair.get(0);
            int index2 = pair.get(1);
            unionFind.union(index1,index2);
        }
        System.out.println(Arrays.toString(unionFind.parent));
        // 第二步:构建映射关系
        char[] charArray = s.toCharArray();
        //key: 连通分量的代表元,value:同一个连通分量的字符集合(保存在一个优先队列中)
        Map<Integer, PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
//            if (hashMap.containsKey(root)) {
//                hashMap.get(root).offer(charArray[i]);
//            }else {
//                PriorityQueue<Character> minHeap = new PriorityQueue<>();
//                minHeap.offer(charArray[i]);
//                hashMap.put(root,minHeap);
//            }
            //上面六行代码等价于下面一行代码，JDK 1.8 以及以后支持下面的写法
            hashMap.computeIfAbsent(root,key ->new PriorityQueue<>()).offer(charArray[i]);
        }
        //第三步:重组字符串
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
         return stringBuilder.toString();
    }
    class UnionFind{
         int[] parent;
        /**
         * 以i为根节点的子树的高度,(引入可压缩路径后该定义并不准确
         */
        private int[] rank;
        public UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            for (int i = 0; i < n; i++){
                this.parent[i] = i;
                this.rank[i] = 1;
            }
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] == rank[rootY]) {
                parent[rootX] = rootY;
                rank[rootY]++;
            }else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            }else {
                parent[rootY] = rootX;
            }

        }

        private int find(int x) {
            if (x != parent[x]) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
