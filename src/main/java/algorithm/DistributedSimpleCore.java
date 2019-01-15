/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package algorithm;

import base.DeterminVertex;
import base.ResultSet;
import base.SimpleGraph;
import base.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;

public class DistributedSimpleCore implements DistributedAlgorithm {
    private static Logger LOGGER = Logger.getLogger(DistributedSimpleCore.class);

    public ArrayList<ResultSet> run(String datasetName) {
        LOGGER.info("===Start Run: DistributedSimpleCore===");
        ArrayList<Integer> allVerticsEstCore = new ArrayList<Integer>(); //all vertics core

        /**
         * ===read graph===
         */
        if (datasetName == null || datasetName.length() < 1) {
            LOGGER.error("====!datasetName error!=====");
            return null;
        }

        SimpleGraph simpleGraph = ReadData.readSimpleGraph(datasetName);
        //        LOGGER.info("===DONE: read graph");

        /**
         *  ===initial vertex===
         *  neighbors, estcore
         */
        int vertexSize = simpleGraph.getVertexSize();
        ArrayList<DeterminVertex> verticesList = new ArrayList<DeterminVertex>(vertexSize);

        for (int i = 0; i < vertexSize; i++) {
            DeterminVertex determinVertex = new DeterminVertex(i);
            determinVertex.setEstCore(simpleGraph.getVertexDegree(i));  //initial estCore=degree
            determinVertex.setNeighbors(simpleGraph.getVertexNeigbors(i));
            verticesList.add(determinVertex);  //important, ALL vertex's information
        }
//        LOGGER.info("===DONE: initial vertices");


        /**
         * ===vertice send messages loop===
         */
        ArrayList<ResultSet> resultSetsList = DistributedLoop.startLoop(allVerticsEstCore, verticesList);

        return resultSetsList;
    }


    public ArrayList<ResultSet> run(String datasetName, double eta) {
        return null;
    }
}
