/*******
 * User: RockyRoll
 * Date: 2018-12-29
 *
 * An O(m) algorithm for cores decomposition of networks
 *
 */
package algorithm;

import base.ResultSet;
import base.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;
import java.util.HashMap;

public class PeelCoreDecomposition {
    private static Logger LOGGER = Logger.getLogger(PeelCoreDecomposition.class);

    public ArrayList<ResultSet> run(String datasetName) {
        ArrayList<ResultSet> resultSetList = new ArrayList<ResultSet>();

        UndirectGraph undirectGraph = ReadData.readUndirectGraph(datasetName);
        int vertexSize = undirectGraph.getVertexSize();

        ArrayList<Integer> coreList = new ArrayList<Integer>();
        //initial with degree
        for (int i = 0; i < vertexSize; i++) {
            coreList.add(undirectGraph.getVertexDegree(i));
        }

        ResultSet resultSet =null;
        long startTime=0;
        long endTime = 0;

        int k = 1;
        while (undirectGraph.getEdgeSize() != 0) {
            startTime = System.currentTimeMillis(); //round start time;

            for (int i = 0; i < vertexSize; i++) {
                if (coreList.indexOf(i) <= k) {
                    coreList.set(i,k);

                    //remove ajacent edges, re-compute core
                    undirectGraph.removeOneVertex(i);
                    for (int j = 0; j < vertexSize; j++) {
                        coreList.set(i, undirectGraph.getVertexDegree(i));
                    }
                }
            }

            endTime = System.currentTimeMillis(); //round end time;
            resultSet = new ResultSet(k, endTime-startTime, 0,0, coreList);
            resultSetList.add(resultSet);
            k++;
        }
        return resultSetList;
    }


}
