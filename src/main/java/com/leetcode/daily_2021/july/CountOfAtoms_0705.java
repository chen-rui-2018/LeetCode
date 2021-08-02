package com.leetcode.daily_2021.july;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2021/7/5 11:24
 * @version： v1.0
 * @modified By:
 */
public class CountOfAtoms_0705 {
    public static void main(String[] args) {
        String s  =  "K4(ON(SO3)2)2";
        String s1 = new CountOfAtoms_0705().countOfAtoms(s);
        System.out.println(s1);
    }
    int i,n;
    String formula;
    public String countOfAtoms(String formula) {
        this.i = 0;
        this.n = formula.length();
        this.formula = formula;
        Deque<Map<String,Integer>> stack = new LinkedList<>();
        stack.push( new HashMap<>());
        while (i < n) {
            char ch = formula.charAt(i);
            // 将一个空的哈希表压入栈中，准备统计括号内的原子数量
            if (ch =='(') {
                i++;
                stack.push(new HashMap<>());
            }else if (ch == ')') {
                i++;
                int num = parseNum();
                Map<String,Integer> popMap = stack.pop();
                Map<String,Integer> topMap = stack.peek();
                for (Map.Entry<String, Integer> entry : popMap.entrySet()) {
                    String atom = entry.getKey();
                    int v = entry.getValue();
                    topMap.put(atom,topMap.getOrDefault(atom,0)+v*num);
                }
            }else {
                String atom = parseAtom();
                int num = parseNum();
                Map<String,Integer> topMap= stack.peek();
                topMap.put(atom,topMap.getOrDefault(atom,0) + num);
            }
        }
        Map<String,Integer> map = stack.pop();
        TreeMap<String,Integer> treeMap = new TreeMap<>(map);
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            String atom = entry.getKey();
            int count = entry.getValue();
            sb.append(atom);
            if (count > 1){
                sb.append(count);
            }
        }
        return sb.toString();
    }

    private String parseAtom() {
        StringBuffer sb = new StringBuffer();
        sb.append(formula.charAt(i++));
        while (i < n && Character.isLowerCase(formula.charAt(i))) {
            sb.append(formula.charAt(i++));
        }
       return sb.toString();
    }

    public int parseNum() {
        // 不是数字 视作 1
        if (i == n || !Character.isDigit(formula.charAt(i))) {
            return 1;
        }
        int num = 0;
        while (i < n && Character.isDigit(formula.charAt(i))) {
            num = num * 10 + formula.charAt(i++)-'0';
        }
        return num;
    }
}
