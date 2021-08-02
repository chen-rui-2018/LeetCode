package com.leetcode.editor.title_daily;

/**
 * @author： chenr
 * @date： Created on 2020/11/25 9:04
 * @version： v1.0
 * @modified By:
 */
public class LRUTest {
    public static void main(String[] args) {
//        LRUCacheMap cache = new LRUCacheMap(2);
//        [[2],[2,1],[1,1],[2,3],[4,1],[1],[2]]
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        // 返回  1
//        System.out.println(cache.get(1));
//        // 该操作会使得密钥 2 作废
//        cache.put(3, 3);
//        // 返回 -1 (未找到)
//        System.out.println( cache.get(2));
//        // 该操作会使得密钥 1 作废
//        cache.put(4, 4);
//        // 返回 -1 (未找到)
//        System.out.println( cache.get(1));
        // 返回  3
        System.out.println(cache.get(1));
        // 返回  4
        System.out.println(cache.get(2));


    }
}
