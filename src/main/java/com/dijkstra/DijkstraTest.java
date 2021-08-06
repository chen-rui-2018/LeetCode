package com.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/8/6 9:52
 * @version： v1.0
 * @modified By:
 */
public class DijkstraTest {
    public static void main(String[] args) {
        List<Character> list= new ArrayList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        list.add('F');
        list.add('G');
        int[][] edgeMatrix = {
                {'A','B',4},
                {'A','C',6},
                {'A','D',6},
                {'B','C',1},
                {'B','E',7},
                {'C','E',6},
                {'C','F',4},
                {'D','C',2},
                {'D','F',5},
                {'E','G',6},
                {'F','E',1},
                {'F','G',8},


        };
        //0 0 1 0 5 2 4

        Dijkstra<Character> dijkstra = new Dijkstra<>(edgeMatrix, list, list.size());
        int length = dijkstra.doDijkstra('A', 'G');
        System.out.println(length);

    }
}
