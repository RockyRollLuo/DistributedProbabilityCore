package base;

import java.util.ArrayList;

public class SimpleGraph implements Graph {

    private int vertexSize;
    private int edgeSize;
    private boolean[][] edgeMatrix; //1:edge else 0

    /**
     * constructor with edgeMatrix
     * @param edgeMatrix
     */
    public SimpleGraph(boolean[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;

        int m=edgeMatrix.length;
        this.vertexSize=m;
        int k=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (edgeMatrix[i][j] == true) {
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
    public SimpleGraph(int vertexSize) {
        if (vertexSize < 1) {
            System.out.println("vertexSize should more than 2");
            return;
        }
        boolean[][] edgeMatrix = new boolean[vertexSize][vertexSize];
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
            if (edgeMatrix[vertex][j] == true) {
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
            if (edgeMatrix[vertex][j] == true) {
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


    /**
     * the function just remove the edge, the vertexSize don't change
     * the edgeSize don't change ,because I don't want to code
     * @param vertex
     */
    public void removeOneVertex(int vertex) {
        //delete edges who adjacent to vertex
        for (int i = 0; i < vertexSize; i++) {
            edgeMatrix[i][vertex] = false;
        }
        for (int j = 0; j < vertexSize; j++) {
            edgeMatrix[vertex][j] = false;
        }
        //re-compute edgeSize
        int newEdgeSize = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (edgeMatrix[i][j] == true) {
                    newEdgeSize++;
                }
            }
        }
        edgeSize = newEdgeSize;
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

    public boolean[][] getEdgeMatrix() {
        return edgeMatrix;
    }

    public void setEdgeMatrix(boolean[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
    }
}
