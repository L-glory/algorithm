package com.glory.algorithm.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 邻接表
 *
 * @author Glory
 * @create 2020-07-07 13:59
 **/
public class AdjacencyList {
    // 顶点个数
    private int v;
    // 顶点的临接顶点集合
    private LinkedList<Integer> adj[];

    // 深度优先遍历终止标志
    private boolean found;

    public AdjacencyList(int v) {
        this.v = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    /**
     * 添加无向图的两个顶点
     *
     * @param s 顶点1
     * @param t 顶点2
     * @return
     */
    public void addEdge(int s, int t) {
        // 无向图，一条边存两次
        adj[s].add(t);
        adj[t].add(s);
    }

    public int getV() {
        return this.v;
    }

    /**
     * 广度优先搜索, 搜索结果是最短路径
     * 实现原理：按顶点一层一层地去遍历，利用queue的原理，先入列的先被遍历到；
     *
     * @param s
     * @param t
     */
    public void bfs(int s, int t) {
        if (s == t) {
            return;
        }

        // 记录顶点是否被访问过
        boolean[] visited = new boolean[v];
        visited[s] = true;

        // 广度优先遍历关键数据结构，队列
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);

        // 记录搜索路径，初始化为-1
        int[] pred = new int[v];
        Arrays.fill(pred, -1);

        while (!queue.isEmpty()) {
            // 遍历当前层所有顶点的所有临接顶点
            int w = queue.poll();
            for (int i = 0; i < adj[w].size(); i++) {
                int q = adj[w].get(i);
                if (!visited[q]) {
                    pred[q] = w;
                    if (q == t) {
                        // 打印pred
                        print(pred, s, t);
                        return;
                    }
                    visited[q] = true;
                    queue.add(q);
                }
            }
        }

    }

    /**
     * 递归打印s->t的路径
     * @param prev
     * @param s
     * @param t
     */
    private void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && t != s) {
            print(prev, s, prev[t]);
        }
        System.out.print(t + " ");
    }

    public void dfs(int s, int t) {
        found = false;
        // 顶点访问记录
        boolean[] visited = new boolean[v];
        // 记录搜索路径
        int[] pred = new int[v];
        Arrays.fill(pred, -1);
        recurDfs(s, t, visited, pred);

        print(pred, s, t);
    }

    // 深度遍历回溯
    private void recurDfs(int w, int t, boolean[] visited, int[] pred) {
        if (found) return;

        visited[w] = true;

        if (w == t) {
            found = true;
            return;
        }

        for (int i = 0; i < adj[w].size(); i++) {
            int q = adj[w].get(i);
            if (!visited[q]) {
                pred[q] = w;
                recurDfs(q, t, visited, pred);
            }
        }
    }
}
