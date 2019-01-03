package database.entity;

import java.util.ArrayList;

public class IntGraph {

    private int id;
    private String datasetName;
    private int vertexSize;
    private int edgeSize;
    private ArrayList<IntEdge> edgeList;

    public IntGraph() {
    }

    public IntGraph(String datasetName, int vertexSize, int edgeSize) {
        this.datasetName = datasetName;
        this.vertexSize = vertexSize;
        this.edgeSize = edgeSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

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

    public ArrayList<IntEdge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<IntEdge> edgeList) {
        this.edgeList = edgeList;
    }
}
