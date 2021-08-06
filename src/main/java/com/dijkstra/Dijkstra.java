package com.dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author： chenr
 * @date： Created on 2021/8/2 10:50
 * @version： v1.0
 * @modified By:
 */
public class Dijkstra<V> {

    private int veritices;
    private List<V> vertexList;
    private int[][] edgeMatrix;
    private int[][] edgeParam;

    Dijkstra(int[][] edgeParam, List<V> vertexList,int veritices){

        this.edgeParam =  edgeParam;
        this.vertexList = vertexList;
        this.veritices = veritices;
        this.edgeMatrix = new int[ this.veritices][ this.veritices];
        for (int i = 0; i < veritices; i++) {
            for (int j = 0; j < veritices; j++) {
                if (i==j){
                    edgeMatrix[i][j] = 0;

                }else {
                    edgeMatrix[i][j] = Integer.MAX_VALUE;
                }
            }

        }
        for (int[] ints : edgeParam) {
            int x = vertexList.indexOf((char)ints[0]);
            int y = vertexList.indexOf((char)ints[1]);
            int v = ints[2];
            edgeMatrix[x][y] = v;
        }

    }




    /**
     * 从定点 v0 出发 打目标 vi 的 最短路径
     *
     * @param v0
     * @param vi
     */
    public int doDijkstra(V v0, V vi) {
        // 未处理过的定点
        List<Integer> listU = new ArrayList<>();
        // 用来存储所有顶点 到 v0 的最短距离
        int[] dist = new int[this.veritices];
        // 用来存储 所有顶点到v0 的最短路径 的上一个顶点;
        int[] path = new int[this.veritices];
        // 起始顶点序号
        int start = this.vertexList.indexOf(v0);
        // 目标顶点序号
        int end = this.vertexList.indexOf(vi);
        // 初始化U 集合 起始点在 S 集合
        for (int i = 0; i < this.veritices; i++) {
            if (i == start) {
                continue;
            }
            listU.add(i);
        }
        // 初始化 所有顶点到起始点的最短距离
        for (int i = 0; i < this.veritices; i++) {
            dist[i] = this.edgeMatrix[start][i];
            // 顶点i 目前状态不可达,
            if (this.edgeMatrix[start][i] == Integer.MAX_VALUE) {
                path[i] = -1;
            } else {
                // 如果start 能直达某顶点, 则表示i 可以直接访问 start
                path[i] = start;
            }
        }
        // 记录路径最小值的 顶点序号 dist 数组下标
        int minIndex;
        while (!listU.isEmpty()) {
            minIndex = listU.get(0);
            for (int i = 1; i < listU.size(); i++) {
                if (dist[listU.get(i)] < dist[minIndex]) {
                    minIndex = listU.get(i);
                }
            }
            listU.remove(listU.indexOf(new Integer(minIndex)));

            // 更新 dist[] 和 path [] 主要考察 minIndex 纳入S 集合后的变化
            for (int i = 0; i < this.veritices; i++) {
                if (this.edgeMatrix[minIndex][i] != 0 && this.edgeMatrix[minIndex][i] < Integer.MAX_VALUE) {
                    //找到顶点的所有邻接点
                    if (this.edgeMatrix[minIndex][i] + dist[minIndex] < dist[i]) {
                        dist[i] = this.edgeMatrix[minIndex][i] + dist[minIndex];
                        path[i] = minIndex;
                    }
                }
            }
        }
        return dist[end];
    }
}
