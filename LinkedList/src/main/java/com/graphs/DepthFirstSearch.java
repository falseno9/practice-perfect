package com.graphs;

import java.util.Stack;

/**
 * Created by Kunal on 4/23/2016.
 */
class Vertex
{
    private char label;
    private boolean visited;
    Vertex(char label) {
        this.label = label;
        this.visited = false;
    }
}

class DfsGraph {
    private final int maxVertices = 20;
    private Vertex vertexList[];
    private int adjMatrix[][];
    private int vertexCount;
    private Stack theStack;
    public DfsGraph() {
        vertexList = new Vertex[maxVertices];
        adjMatrix = new int[maxVertices][maxVertices];
        vertexCount = 0;
        for(int x=0; x < maxVertices; x++) {
            for(int y=0; y < maxVertices; y++) {
                adjMatrix[x][y] = 0;
            }
        }
        theStack = new Stack();
    }
}

class DepthFirstSearch {

    public dfs() {

    }
}
