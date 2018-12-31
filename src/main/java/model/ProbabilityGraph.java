/**
 * edge with probability p in [0,1]
 */

package model;

import java.util.ArrayList;

public class ProbabilityGraph {
    private int vertexSize;
    private int edgeSize;
    private double[][] edgeMatrix;

    /**
     * constructor with vertexSize
     * all edge = 0
     * @param vertexSize
     */
    public ProbabilityGraph(int vertexSize) {
        this.vertexSize = vertexSize;
        this.edgeSize = 0;
        for (int i = 0; i < vertexSize; i++) {
            for (int j = 0; j < vertexSize; j++) {
                edgeMatrix[i][j] = 0;
            }
        }
    }

    /**
     * constructor with edgeMatrix
     * @param edgeMatrix
     */
    public ProbabilityGraph(double[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
        this.vertexSize = edgeMatrix.length;
        int k=0;
        for (int i = 0; i < vertexSize; i++) {
            for (int j = 0; j < vertexSize; j++) {
                if (edgeMatrix[i][j] != 0) {
                    k++;
                }
            }
        }
        this.edgeSize = k;
    }

    /***
     * get one vertex degree
     * @param vertex
     * @return
     */
    public int getVertexDegree(int vertex){
        int deg=0;
        for (int j = 0; j < vertexSize; j++) {
            if (edgeMatrix[vertex][j] != 0) {
                deg++;
            }
        }
        return deg;
    }

    /**
     * get one vertex eta degree
     * @param vertex
     * @param eta: a  given threshold
     * @return
     */
    public int getVertexEtaDegree(int vertex, double eta) {
        //TODO:eta degree
        int etaDeg = 0;
        for (int j = 0; j < vertexSize; j++) {



        }



        return etaDeg;
    }



    /***
     * get one vertex neigbors index
     * @param vertex
     * @return
     */
    public ArrayList<Integer> getVertexNeigbors(int vertex) {
        ArrayList<Integer> neigborsList = new ArrayList<Integer>();
        for (int j = 0; j < this.edgeMatrix[vertex].length; j++) {
            if (edgeMatrix[vertex][j] != 0) {
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





}
