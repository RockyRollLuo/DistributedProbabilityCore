/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package database.algorithm;

import model.DeterminVertex;
import model.ResultSet;
import model.UndirectGraph;
import org.apache.log4j.Logger;
import tool.ReadData;

import java.util.ArrayList;

public class DistributedCore {
    private static Logger LOGGER = Logger.getLogger(DistributedCore.class);

    public ArrayList<ResultSet> run(int datasetId) {
        LOGGER.info("===Start Run: DistributedCore===");
        ArrayList<Integer> allVerticsEstCore = new ArrayList<Integer>(); //all vertics core

        /**
         *  ===initial vertex===
         *  neighbors, estcore
         */


        LOGGER.info("===DONE: initial vertices");


        /**
         * ===vertice send messages loop===
         */
        ArrayList<ResultSet> resultSetsList = new ArrayList<ResultSet>();
        int round = 0;
        int noChangedNum = 0;
        int changedNum = 0;
        long startTime=0;
        long endtime=0;
        long roundTime=0;
        while (true) {
            startTime = System.currentTimeMillis(); //round start time;
            LOGGER.info("==Start: ROUND: " + round);

            /**
             * ===check no changed (changed=false) number===
             */
            noChangedNum = 0;
            allVerticsEstCore.clear();
            LOGGER.info("==round" + round + ".  No changed number: " + noChangedNum);


            /**
             * ===get message to neighbors===
             * whatever who haved changed,
             * because in distributed environment, after changed then send message to update the neighbor's information
             * ===re-computing estmate core===
             */
            LOGGER.info("==round:" + round + ". re-computing estmate core");
            endtime = System.currentTimeMillis();


            /**
             * ===collect current resultset
             */

            /**
             * ===exit the loop===
             * when all vertices's core no more change, we have get the final result
             */

            //next loop
            round++;
        }
    }

    /***
     *
     * @param neighborsEstCore u's neigborsCore
     * @param vertexId u
     * @param k u's core
     * @return
     */
    private int computedIndex(ArrayList<Integer> neighborsEstCore, int vertexId, int k) {
        int[] count = new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            count[i] = 0;
        }

        for (int j : neighborsEstCore) {
            int index = ((k < j) ? k : j);
            count[index] = count[index] + 1;
        }

        for (int i = k; i > 1; i--) {
            count[i - 1] = count[i - 1] + count[i];
        }

        int ret = k;
        while (ret > 1 & count[ret] < ret) {
            ret = ret - 1;
        }
        return ret;
    }
}
