/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package algorithm;

import model.DeterminVertex;
import model.ProbabilityGraph;
import model.ResultSet;
import model.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.io.IOException;
import java.util.ArrayList;

public class DistributedEtaCore {
    private static Logger LOGGER = Logger.getLogger(DistributedEtaCore.class);

    public ArrayList<ResultSet> run(String datasetName, double eta) {
        LOGGER.info("===Start Run: DistributedEtaCore===");
        ArrayList<Integer> allVerticsEstCore = new ArrayList<Integer>(); //all vertics core

        /**
         * ===read graph===
         */
        if (datasetName == null || datasetName.length() < 1) {
            LOGGER.error("====!datasetName error!=====");
            return null;
        }

        ProbabilityGraph probabilityGraph = ReadData.readProbabilityGraph(datasetName);
        //        LOGGER.info("===DONE: read graph");

        /**
         *  ===initial vertex===
         *  neighbors, estcore
         */
        int vertexSize = probabilityGraph.getVertexSize();
        ArrayList<DeterminVertex> verticesList = new ArrayList<DeterminVertex>(vertexSize);

        for (int i = 0; i < vertexSize; i++) {
            DeterminVertex determinVertex = new DeterminVertex(i);
            determinVertex.setEstCore(probabilityGraph.getVertexEtaDegree(i, eta));  //initial estCore= eta-degree
            determinVertex.setNeighbors(probabilityGraph.getVertexNeigborsIdList(i));
            verticesList.add(determinVertex);  //important, ALL vertex's information
        }
//        LOGGER.info("===DONE: initial vertices");


        /**
         * ===vertices send messages loop===
         */
        ArrayList<ResultSet> resultSetsList = DistributedLoop.startLoop(allVerticsEstCore, verticesList);


        return resultSetsList;
    }
}
