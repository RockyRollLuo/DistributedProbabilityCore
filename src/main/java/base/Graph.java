package base;

import java.util.ArrayList;

public interface Graph {

    public int getVertexDegree(int vertex);

    public ArrayList<Integer> getVertexNeigbors(int vertex);


    public int getMaxdegree();

    public void removeOneVertex(int vertex);


}
