package com.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by Kunal on 12/8/2016.
 */
public class TopologicalSort {

    class Graph {
        private int V;
        private LinkedList<Integer> adj[];

        Graph(int v) {
            V = v;
            adj = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adj[i] = new LinkedList();
            }
        }

        void addEdge(int v, int w) {
            adj[v].add(w);
        }

        public int getV() {
            return V;
        }

        public void setV(int v) {
            V = v;
        }

        public LinkedList<Integer>[] getAdj() {
            return adj;
        }

        public void setAdj(LinkedList<Integer>[] adj) {
            this.adj = adj;
        }
    }

    void topSortUtil(int v, LinkedList<Integer> adj[], boolean[] visited, Stack s) {

        visited[v] = true;
        Iterator<Integer> it = adj[v].iterator();

        int i;
        while (it.hasNext()) {
            i = it.next();
            if (!visited[i]) {
                topSortUtil(i, adj, visited, s);
            }
        }
        s.push(new Integer(v));
    }

    void topSort(Graph g) {
        Stack s = new Stack();

        int V = g.getV();
        LinkedList<Integer> adj[] = g.getAdj();

        boolean visited[] = new boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (visited[i] == false)
                topSortUtil(i, adj, visited, s);

        // Print contents of stack
        while (s.empty() == false)
            System.out.print(s.pop() + " ");
    }
}
