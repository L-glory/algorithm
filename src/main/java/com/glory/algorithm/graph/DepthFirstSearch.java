package com.glory.algorithm.graph;

/**
 * 深度优先搜索
 *
 * @author Glory
 * @create 2020-07-07 15:18
 **/
public class DepthFirstSearch {

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(9);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 3);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(3, 6);
        adjacencyList.addEdge(4, 5);
        adjacencyList.addEdge(5, 6);
        adjacencyList.addEdge(5, 7);
        adjacencyList.addEdge(6, 8);
        adjacencyList.addEdge(7, 8);

        adjacencyList.dfs(3, 8);

        System.out.println("位运算=" + (-1 >> 4));

    }
}
