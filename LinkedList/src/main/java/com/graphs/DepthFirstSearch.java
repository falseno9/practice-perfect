package com.graphs;

import java.util.Stack;

/**
 * Created by Kunal on 4/23/2016.
 */
class Vertex
{
    public char label;
    public boolean visited;
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
    public void displayVertex(int v) {
        System.out.println(vertexList[v].label);
    }

    public void dfs() {
        vertexList[0].visited = true;
        displayVertex(0);
        theStack.push(0);
        while (!theStack.isEmpty()) {
            int v = getAdjUnvisitedVertex((Integer) theStack.peek());
            if (v==-1) {
                theStack.pop();
            } else {
                vertexList[v].visited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }
        for (int j = 0; j < vertexCount; j++) {
            vertexList[j].visited = false;
        }
    }

    public int getAdjUnvisitedVertex(int v) {
        for (int j=0; j < vertexCount; j++) {
            if(adjMatrix[v][j] == 1 && vertexList[j].visited==false) {
                return j;
            }
        }
        return -1;
    }
}