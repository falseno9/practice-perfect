package com.graphs;

import java.util.LinkedList;

/**
 * Created by Kunal on 11/27/2016.
 */
public class BfsGraph {

    int V;
    LinkedList<Integer> adj[];

    BfsGraph(int v) {
        V = v;
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    void BFS(int s) {
        boolean visited[] = new boolean[V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");

            for (Integer i : adj[s]) {
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
