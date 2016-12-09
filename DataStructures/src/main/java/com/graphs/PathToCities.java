package com.graphs;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by Kunal on 12/4/2016.
 */
public class PathToCities {

    int V;
    LinkedList<Integer> adj[];

    PathToCities(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList();
        }
    }

    void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public int[] BFS(int s) {
        boolean[] visited = new boolean[V];
        LinkedList<Integer> queue = new LinkedList<>();

        int[] numCities = new int[0];
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            s = queue.poll();
            System.out.println(s + " ");

            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return numCities;
    }

    public int[] solution(int[] T) {
        PathToCities g = new PathToCities(T.length);
        int source = 0;
        for (int i : T) {
            if (i != T[i]) {
                g.addEdge(i, T[i]);
            } else {
                source = i;
            }
        }
        return g.BFS(source);
    }


    public static void main(String args[]) {
        PathToCities g = new PathToCities(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println("Following is Breadth First Traversal " +
                "(starting from vertex 2)");

        g.BFS(2);
    }
}
