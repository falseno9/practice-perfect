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


}
