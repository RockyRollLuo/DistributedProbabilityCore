/**
 * User: RockyRoll
 * Date: 2018-12-31
 * <p>
 * process each algorithm result set
 */

package tool;

import base.ResultSet;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class ResultProcess {
    private static Logger LOGGER = Logger.getLogger(ResultProcess.class);

    /**
     * TODO: process the resultset of each algorithm
     */

    public static void processResultList(ArrayList<ResultSet> resultSetList) {
        int totalRound = resultSetList.size();  // total round num
        ResultSet finalResult = resultSetList.get(totalRound - 1);
        int totalVertex = finalResult.getChangedNum() + finalResult.getNoChangedNum(); //total vertex num

        /**
         * TODO:in final round, each core number  and percent
         */
        ArrayList<Integer> finalCore = finalResult.getEstCoreList();
        ArrayList<Integer> core_number = new ArrayList<Integer>();
        for (int core : finalCore) {
            core_number.set(core, core_number.get(core) + 1);
        }
        LOGGER.info("final round core distribution: " + core_number.toString());







        /*
         * TODO:in final round, min core and max core
         */


        /**
         * TODO:in each round, round time
         */


        /**
         * TODO:in each round, correct core number and precent
         */


        /**
         * TODO:in each round, wrong core number and precent
         */
    }


    /**
     * TODO:in each round, each core numbers percent
     */
    public static void processOneResultSet1(ResultSet resultSet) {
        ArrayList<Integer> coreList = resultSet.getEstCoreList();
        ArrayList<Float> precentList = new ArrayList<Float>();
        int maxCore = Collections.max(coreList);
        int minCore = Collections.min(coreList);
        HashMap<Integer, Float> percentMap = new HashMap<Integer, Float>();
        for (int core : coreList) {


        }


        LOGGER.info("core distribution :");
    }

    /**
     *
     * @param resultSet
     */
    public static void processOneResultSet(ResultSet resultSet) {
        ArrayList<Integer> coreList = resultSet.getEstCoreList();
        int maxCore = Collections.max(coreList);
        int minCore = Collections.min(coreList);
        int[] core_number = new int[maxCore + 1]; //0 ,1 , 2, …… ,maxCore   total:maxCore+1

        for (int core : coreList) {
            core_number[core] = core_number[core] + 1;
        }
        LOGGER.info("core distribution: " );
    }


    public static void main(String[] args) {

    }


}
