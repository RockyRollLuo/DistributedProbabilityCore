/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package algorithm;

import base.DeterminVertex;
import base.ResultSet;
import base.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;

public class DistributedCore {
    private static Logger LOGGER = Logger.getLogger(DistributedCore.class);

    public ArrayList<ResultSet> run(String datasetName) {
        LOGGER.info("===Start Run: DistributedCore===");
        ArrayList<Integer> allVerticsEstCore = new ArrayList<Integer>(); //all vertics core

        /**
         * ===read graph===
         */
        if (datasetName == null || datasetName.length() < 1) {
            LOGGER.error("====!datasetName error!=====");
            return null;
        }

        UndirectGraph undirectGraph = ReadData.readUndirectGraph(datasetName);
        //        LOGGER.info("===DONE: read graph");

        /**
         *  ===initial vertex===
         *  neighbors, estcore
         */
        int vertexSize = undirectGraph.getVertexSize();
        ArrayList<DeterminVertex> verticesList = new ArrayList<DeterminVertex>(vertexSize);

        for (int i = 0; i < vertexSize; i++) {
            DeterminVertex determinVertex = new DeterminVertex(i);
            determinVertex.setEstCore(undirectGraph.getVertexDegree(i));  //initial estCore=degree
            determinVertex.setNeighbors(undirectGraph.getVertexNeigbors(i));
            verticesList.add(determinVertex);  //important, ALL vertex's information
        }
//        LOGGER.info("===DONE: initial vertices");


        /**
         * ===vertice send messages loop===
         */
        ArrayList<ResultSet> resultSetsList = DistributedLoop.startLoop(allVerticsEstCore, verticesList);

        return resultSetsList;
    }

}
