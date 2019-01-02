/**
 * User: RockyRoll
 * Date: 2019-01-02
 */

package adjacentlist;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;

public class IntGraph {
    private static Logger LOGGER = Logger.getLogger(IntGraph.class);

    private int vertexSize;
    private int edgeSize;

    private HashMap<Integer, ArrayList<Integer>> adjacentMap; // adjacency list

}
