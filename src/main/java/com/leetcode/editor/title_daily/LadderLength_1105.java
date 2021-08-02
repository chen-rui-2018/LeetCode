package com.leetcode.editor.title_daily;

import javafx.util.Pair;

import java.util.*;

/**
 * @author： chenr
 * @date： Created on 2020/11/5 15:06
 * @version： v1.0
 * @modified By:
 */
public class LadderLength_1105 {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
       int times = new LadderLength_1105().ladderLength(beginWord,endWord,wordList);
        System.out.println(times);
    }
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)){
            return 0;
        }
        System.out.println(wordId.toString());
        int [] dis = new int[nodeNum];
        Arrays.fill(dis,Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord);
        int endId = wordId.get(endWord);
        dis[beginId] = 0;
        Queue<Integer> que = new LinkedList<>();
        que.offer(beginId);
        while(!que.isEmpty()){
            int x = que.poll();
            if (x == endId){
                return dis[endId]/2 + 1;
            }
            for(int it: edge.get(x)){
                if (dis[it] == Integer.MAX_VALUE){
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }
     public void addEdge(String word){
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
         for (int i = 0; i < length; i++) {
             char temp = array[i];
             array[i] = '*';
             String newWord = new String(array);
             addWord(newWord);
             int id2 = wordId.get(newWord);
             edge.get(id1).add(id2);
             edge.get(id2).add(id1);
             array[i] = temp;
         }
    }

    private void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word,nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        // 所有单词长度相同
        int length = beginWord.length();
        //字典包含可组成的单词组合
        //从任何给定的词。 通过一次更改一个字母。
        Map<String,List<String>> allComboDict = new HashMap<>();
        for (String word : wordList) {
            for (int i = 0; i < length; i++) {
                // Key是通用词
                //值是具有相同中间通用词的词的列表。
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                List<String> transformations = allComboDict.getOrDefault(newWord,new ArrayList<>());
                transformations.add(word);
                allComboDict.put(newWord,transformations);
            }
        }
        // queue for bfs
        Queue<Pair<String,Integer>> queue = new LinkedList<>();
        queue.add(new Pair(beginWord,1));
        // 访问以确保我们不会重复处理相同的单词。
        Map<String,Boolean> visited = new HashMap<>();
        visited.put(beginWord,true);
        while (!queue.isEmpty()) {
            Pair<String,Integer> node = queue.remove();
            String word = node.getKey();
            int level = node.getValue();
            for (int i = 0;i < length; i++) {
                //当前单词的中间单词
                String newWord = word.substring(0,i)+"*"+word.substring(i+1,length);
                //下一个状态是共享相同中间状态的所有单词
                for (String adjacentWord : allComboDict.getOrDefault(newWord,new ArrayList<>())) {
                    //如果在任何时候找到我们想要的东西
                    //即结尾词-我们可以返回答案。
                    if (adjacentWord.equals(endWord)) {
                        return level+1;
                    }
                    //否则，将其添加到BFS队列中。 同时标记为已访问
                    if (!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord,true);
                        queue.add(new Pair<>(adjacentWord,level+1));
                    }
                }
            }
        }

        return 0;
    }

}
