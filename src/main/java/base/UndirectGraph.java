package base;

import java.util.ArrayList;

public class UndirectGraph implements Graph{
    private int vertexSize;
    private int edgeSize;

    private int[][] edgeMatrix; //1:edge else 0

    /**
     * constructor with edgeMatrix
     * @param edgeMatrix
     */
    public UndirectGraph(int[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;

        int m=edgeMatrix[0].length;
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


    /**
     * the function just remove the edge, the vertexSize don't change
     * the edgeSize don't change ,because I don't want to code
     * @param vertex
     */
    public void removeOneVertex(int vertex) {
        //delete edges who adjacent to vertex
        for (int i = 0; i < vertexSize; i++) {
            edgeMatrix[i][vertex] = 0;
        }
        for (int j = 0; j < vertexSize; j++) {
            edgeMatrix[vertex][j] = 0;
        }
        //re-compute edgeSize
        int newEdgeSize = 0;
        for (int i = 0; i < vertex; i++) {
            for (int j = 0; j < vertex; j++) {
                if (edgeMatrix[i][j] != 0) {
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

    public int[][] getEdgeMatrix() {
        return edgeMatrix;
    }

    public void setEdgeMatrix(int[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
    }
}
