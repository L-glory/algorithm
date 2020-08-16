package com.glory.algorithm.graph;

/**
 * 广度优先搜索图
 *
 * @author Glory
 * @create 2020-07-07 13:58
 **/
public class BreadthFirstSearch {

    public static void main(String[] args) {
        AdjacencyList adjacencyList = new AdjacencyList(8);
        adjacencyList.addEdge(0, 1);
        adjacencyList.addEdge(0, 3);
        adjacencyList.addEdge(1, 2);
        adjacencyList.addEdge(1, 4);
        adjacencyList.addEdge(2, 5);
        adjacencyList.addEdge(3, 4);
        adjacencyList.addEdge(4, 5);
        adjacencyList.addEdge(4, 6);
        adjacencyList.addEdge(5, 7);
        adjacencyList.addEdge(6, 7);

        adjacencyList.bfs(5, 0);
    }
}
