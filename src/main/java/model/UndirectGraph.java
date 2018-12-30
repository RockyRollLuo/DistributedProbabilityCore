package model;

import java.util.ArrayList;

public class UndirectGraph {
    private int vertexSize;
    private int edgeSize;

    private int[][] edgeMatrix; //1:edge else 0

    /**
     * constructor with edgeMatrix
     * @param edgeMatrix
     */
    public UndirectGraph(int[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;

        int m=edgeMatrix.length;
        this.vertexSize=m;
        int k=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (edgeMatrix[i][j] == 1) {
                    k++;
                }
            }
        }
        this.edgeSize=k;
    }

    /**
     * constructor with vertexSize
     * @param vertexSize
     */
    public UndirectGraph(int vertexSize) {
        if (vertexSize < 1) {
            System.out.println("vertexSize should more than 2");
            return;
        }

        int[][] edgeMatrix = new int[vertexSize][vertexSize];
        for (int i = 0; i < vertexSize; i++) {
            for (int j = 0; j < vertexSize; j++) {
                edgeMatrix[i][j] = 0;
            }
        }
        this.edgeMatrix = edgeMatrix;
        this.vertexSize = vertexSize;
        this.edgeSize = 0;

    }

    /***
     * get one vertex degree
     * @param vertex
     * @return
     */
    public int getVertexDegree(int vertex){
        int deg=0;
        for (int j = 0; j <edgeMatrix[vertex].length ; j++) {
            if (edgeMatrix[vertex][j] == 1) {
                deg++;
            }
        }
        return deg;
    }

    /***
     * get one vertex neigbors index
     * @param vertex
     * @return
     */
    public ArrayList<Integer> getVertexNeigbors(int vertex) {
        ArrayList<Integer> neigborsList = new ArrayList<Integer>();
        for (int j = 0; j < this.edgeMatrix[vertex].length; j++) {
            if (edgeMatrix[vertex][j] == 1) {
                neigborsList.add(j);
            }
        }
        return neigborsList;
    }


    /***
     * get the maxdegree
     * @return
     */
    public int getMaxdegree() {
        int maxdeg=0;
        int deg=0;
        for (int i = 0; i < vertexSize; i++) {
            deg=getVertexDegree(i);
            if (deg > maxdeg) {
                maxdeg=deg;
            }
        }
        return maxdeg;
    }

    //getter and setter
    public int getVertexSize() {
        return vertexSize;
    }

    public void setVertexSize(int vertexSize) {
        this.vertexSize = vertexSize;
    }

    public int getEdgeSize() {
        return edgeSize;
    }

    public void setEdgeSize(int edgeSize) {
        this.edgeSize = edgeSize;
    }

    public int[][] getEdgeMatrix() {
        return edgeMatrix;
    }

    public void setEdgeMatrix(int[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
    }
}
