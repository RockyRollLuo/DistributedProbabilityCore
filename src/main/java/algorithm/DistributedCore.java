/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package algorithm;

import model.DeterminVertex;
import model.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class DistributedCore {
    private static Logger LOGGER = Logger.getLogger(DistributedCore.class);

    public static void main(String[] args) {

        /**
         * ===read graph===
         *
         */
        String datasetName="testdata/undirectgraph6";
//        String datasetName="testdata/undirectgraph10";
//        String datasetName="dblp/com-dblp.ungraph";


        UndirectGraph undirectGraph=null;
        try {
            undirectGraph= ReadData.readUndirectGraph(datasetName);
        } catch (IOException e) {
            LOGGER.error("read dataset error:",e);
            e.printStackTrace();
        }
        LOGGER.info("===DONE: read graph");

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
        LOGGER.info("===DONE: initial vertices");


        /**
         * ===vertice send messages loop===
         */
        int round=0;
        while(true){

            /**
             * ===check no changed (changed=false) number===
             */
            int noChangedNum=0;
            ArrayList<Integer> allVerticsEstCore=new ArrayList<Integer>(); //test use!!!
            for (DeterminVertex e : verticesList) {
                allVerticsEstCore.add(e.getEstCore());
                if(e.isChanged() == false){
                    noChangedNum++;
                }
            }
            LOGGER.info("==DONE: check no changed number: " + noChangedNum + ". Percent:" + new Double(noChangedNum) / vertexSize);
            LOGGER.info("All vertics estmate core is:"+ allVerticsEstCore.toString());

            if (noChangedNum == vertexSize) {
                LOGGER.info("======!!!ALL VERTICES HAVE CONVERGE!!!======");
                break;
            }

            /**
             * ===get message to neighbors===
             * whatever who haved changed,
             * becouse in distributed eviroment, after changed then send message to update
             *
             * ===re-computing estmate core===
             *
             */
            ArrayList<Integer> neighbors = new ArrayList<Integer>();
            DeterminVertex determinVertex=null;
            for (int i = 0; i < verticesList.size(); i++) {
                determinVertex=verticesList.get(i);
                ArrayList<Integer> neighborsEstCore = new ArrayList<Integer>();
                neighbors = determinVertex.getNeighbors(); //get neighbors index
                //all neighbors
                for (int vertexId : neighbors) {
                    neighborsEstCore.add(verticesList.get(vertexId).getEstCore());

                    verticesList.get(vertexId).setChanged(false); //after use neighbor's core, set false
                }

                int t = computedIndex(neighborsEstCore, i, determinVertex.getEstCore()); // new estCore
                if (t < determinVertex.getEstCore()) {
                    determinVertex.setEstCore(t);
                    determinVertex.setChanged(true);
                }
            }

            round++;
            LOGGER.info("==DNOE: re-computing estmate core, ROUND:"+round);
        }
    }

    /***
     *
     * @param neighborsEstCore u's neigborsCore
     * @param vertexId u
     * @param k u's core
     * @return
     */
    public static int computedIndex(ArrayList<Integer> neighborsEstCore, int vertexId, int k) {
        int[] count = new int[k + 1];
        for (int i = 0; i < k+1; i++) {
            count[i] = 0;
        }

        for (int j : neighborsEstCore) {
            int index = ((k < j) ? k : j);
            count[index] = count[index] + 1;
        }

        for (int i = k; i > 1; i--) {
            count[i - 1] = count[i - 1] + count[i];
        }

        int ret=k;
        while (ret > 1 & count[ret] < ret) {
            ret = ret - 1;
        }
        return ret;
    }



}
