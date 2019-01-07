/*******
 * User: RockyRoll
 * Date: 2018-12-29
 *
 * the O(m) (i.e., peel like ) core decomposition algorithm
 */
package algorithm;

import model.ResultSet;
import model.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;
import java.util.HashMap;

public class PeelCoreDecomposition {
    private static Logger LOGGER = Logger.getLogger(PeelCoreDecomposition.class);

    public ArrayList<ResultSet> run(String datasetName) {

        UndirectGraph undirectGraph = ReadData.readUndirectGraph(datasetName);

        int vertexSize=undirectGraph.getVertexSize();









        ArrayList<ResultSet> resultSetList = new ArrayList<ResultSet>();


        return resultSetList;
    }
}
