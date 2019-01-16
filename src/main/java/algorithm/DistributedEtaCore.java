/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package algorithm;

import base.DeterminVertex;
import base.ProbabilityGraph;
import base.ResultSet;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;

public class DistributedEtaCore implements DistributedAlgorithm {
    private static Logger LOGGER = Logger.getLogger(DistributedEtaCore.class);

    public ArrayList<ResultSet> run(String datasetName, double eta) {
        LOGGER.info("===Start Run: DistributedEtaCore===");
        ArrayList<Integer> allVerticsEstCore = new ArrayList<Integer>(); //all vertics core

        /**===read graph===*/
        if (datasetName == null || datasetName.length() < 1) {
            LOGGER.error("====!datasetName error!=====");
            return null;
        }

        ProbabilityGraph probabilityGraph = ReadData.readProbabilityGraph(datasetName);

        /**===initial vertex===**/
        int vertexSize = probabilityGraph.getVertexSize();
        ArrayList<DeterminVertex> verticesList = new ArrayList<DeterminVertex>(vertexSize);

        for (int i = 0; i < vertexSize; i++) {
            DeterminVertex determinVertex = new DeterminVertex(i);
            determinVertex.setEstCore(probabilityGraph.getVertexEtaDegree(i, eta));  //initial estCore= eta-degree
            determinVertex.setNeighbors(probabilityGraph.getVertexNeigborsIdList(i));
            verticesList.add(determinVertex);  //important, ALL vertex's information
        }

        /** ===vertices send messages loop===**/
        ArrayList<ResultSet> resultSetsList = DistributedLoop.startLoop(allVerticsEstCore, verticesList);
        return resultSetsList;
    }


    public ArrayList<ResultSet> run(String datasetName) {
        return null;
    }
}
