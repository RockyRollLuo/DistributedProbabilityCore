package modelbig;

import java.math.BigInteger;
import java.util.ArrayList;

public class BigGraph {
    private BigInteger vertexSize;
    private BigInteger edgeSize;

    private BigInteger[][] edgeMatrix; //1:edge else 0

    public BigGraph(BigInteger[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;

        int m=edgeMatrix.length;
        this.vertexSize= BigInteger.valueOf(m);
        BigInteger k=0;
        for (BigInteger i = BigInteger.valueOf(0); i < m; i++) {
            for (BigInteger j = 0; j < m; j++) {
                if (edgeMatrix[i][j] == 1) {
                    k++;
                }
            }
        }
        this.edgeSize=k;
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











    //
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
