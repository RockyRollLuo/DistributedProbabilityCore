/**
 * edge with probability p in [0,1]
 */

package base;

import java.math.BigDecimal;
import java.util.ArrayList;

public class ProbabilityGraph {
    private int vertexSize;
    private int edgeSize;
    private double[][] edgeMatrix;

    /**
     * constructor with vertexSize
     * all edge = 0
     *
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
     *
     * @param edgeMatrix
     */
    public ProbabilityGraph(double[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
        this.vertexSize = edgeMatrix[0].length;
        int k = 0;
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
    public int getVertexDegree(int vertex) {
        int deg = 0;
        for (int j = 0; j < vertexSize; j++) {
            if (edgeMatrix[vertex][j] > 0) {
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
    public ArrayList<Integer> getVertexNeigborsIdList(int vertex) {
        ArrayList<Integer> neigborsList = new ArrayList<Integer>();
        for (int j = 0; j < this.edgeMatrix[vertex].length; j++) {
            if (edgeMatrix[vertex][j] > 0) {
                neigborsList.add(j);
            }
        }
        return neigborsList;
    }


    /**
     * get one vertex's adjacent edge's probability list
     *
     * @param vertex
     * @return
     */
    public ArrayList<Double> getVertexAdjacentEdgesList(int vertex) {
        ArrayList<Double> adjacentEdgesList = new ArrayList<Double>();
        for (int j = 0; j < vertexSize; j++) {
            if (edgeMatrix[vertex][j] > 0) {
                adjacentEdgesList.add(edgeMatrix[vertex][j]);
            }
        }
        return adjacentEdgesList;
    }


    /**
     * get one vertex eta degree
     * Pr[deg(v)>=k]>=eta
     *
     * @param vertex
     * @param eta:   a  given threshold
     * @return
     */
    public int getVertexEtaDegree(int vertex, double eta) {
        int etaDeg = 0;
        int k = 0;

        // IMPORTANT!! double leixing de bijiao
        BigDecimal bigDecimal1=new BigDecimal(proVertexDegMoreThanK(vertex,k));
        BigDecimal bigDecimal2=new BigDecimal(eta);

        while ((bigDecimal1.compareTo(bigDecimal2))==1) {
            k++;  //the case k<dv have consider in the proVertexDegMoreThanK
            bigDecimal1=new BigDecimal(proVertexDegMoreThanK(vertex,k));
        }
        etaDeg = k-1;
        return etaDeg;
    }

    /**
     * the probability of a vertex have degree i.
     * Pr[deg(v)=i] i=0,1,2,,,dv  (dv is max-degree of v)
     *
     * @param vertex
     * @param i
     * @return
     */
    public double proVertexDegEquali(int vertex, int i) {
        double p = 0;
        int degree = getVertexDegree(vertex);
        if (i > degree || i < 0) {
            return p;
        }
        ArrayList<Double> adjacentEdgesList = getVertexAdjacentEdgesList(vertex);
        p = func(degree, i, adjacentEdgesList);
        return p;
    }

    /**
     * X(h,j)=ph*X(h-1,j-1)+(1-ph)X(h-1,j)
     * <p>
     * X(0,0)=1,
     * X(h,-1)=0, h in [0,dv]
     * X(h,j)=0, h in [0,dv], j in [h+1, i]
     *
     * @param h
     * @param j
     * @param adjacentEdgesList
     * @return
     */
    private double func(int h, int j, ArrayList<Double> adjacentEdgesList) {
        int dv = adjacentEdgesList.size();
        if (h < 0 || h > dv) {
            return 0.0;
        } else if (h == 0 && j == 0) {
            return 1.0;
        } else if (j == -1 || j > h) {
            return 0.0;
        } else {
            //if h is the index  of edge ,then the ph=adjacentEdgesList.get(h-1);
            return adjacentEdgesList.get(h - 1) * func(h - 1, j - 1, adjacentEdgesList) + (1 - adjacentEdgesList.get(h - 1)) * func(h - 1, j, adjacentEdgesList);
        }
    }


    /**
     * the probability of a vertex have degree more than k
     * Pr[deg[v]>=k]
     * = (the sum fo all Pr[deg(v)=i]) i=k,k+1,,,dv
     * = 1-(the sum of all Pr[deg(v)=i]) i=0,1,2,,,k-1
     *
     * @param vertex
     * @param k
     * @return
     */
    public double proVertexDegMoreThanK(int vertex, int k) {
        double p = 0;
        int degree = getVertexDegree(vertex);
        if (k > degree || k < 0) {
            return p;
        }
//        for (int i = 0; i < k; i++) {
//            p += proVertexDegEquali(vertex, i);
//        }
//        return 1 - p;

        for (int i = k; i <= degree; i++) {
            p += proVertexDegEquali(vertex, i);
        }
        return p;
    }


    /***
     * get the maxdegree
     * @return
     */
    public int getMaxdegree() {
        int maxdeg = 0;
        int deg = 0;
        for (int i = 0; i < vertexSize; i++) {
            deg = getVertexDegree(i);
            if (deg > maxdeg) {
                maxdeg = deg;
            }
        }
        return maxdeg;
    }


    /**
     * getter and setter
     */
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

    public double[][] getEdgeMatrix() {
        return edgeMatrix;
    }

    public void setEdgeMatrix(double[][] edgeMatrix) {
        this.edgeMatrix = edgeMatrix;
    }
}
