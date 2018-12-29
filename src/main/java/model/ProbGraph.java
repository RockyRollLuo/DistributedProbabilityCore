package model;

public class ProbGraph {
    private int vertexSize;
    private int edgeSize;

    private int[] vertexSet;
    private double[][] neigborMatrix;


    public ProbGraph(int vertexSize, double[][] neigborMatrix) {
        this.vertexSize = vertexSize;
        this.neigborMatrix = neigborMatrix;

        vertexSet=new int[vertexSize];
        for (int i = 1; i <= vertexSize; i++) {
            vertexSet[i-1]=i;
        }




    }






}
