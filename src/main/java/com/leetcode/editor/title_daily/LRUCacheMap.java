package com.leetcode.editor.title_daily;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author： chenr
 * @date： Created on 2020/11/25 8:51
 * @version： v1.0
 * @modified By:
 */
public class LRUCacheMap extends LinkedHashMap<Integer,Integer> {
    private int capacity;
    public LRUCacheMap(int capacity){
        super(capacity,0.75F,true);
        this.capacity = capacity;
    }
    public int get(int key){
        return super.getOrDefault(key,-1);
    }
    public void  put(int key , int value){
        super.put(key,value);
    }
    @Override
    protected boolean removeEldestEntry(Map.Entry<Integer,Integer> eldest){
        return size()>capacity;
    }

}
