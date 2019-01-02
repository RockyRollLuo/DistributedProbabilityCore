/**
 * User: RockyRoll
 * Date: 2018-12-31
 * <p>
 * process each algorithm result set
 */

package tool;

import model.ResultSet;
import org.apache.log4j.Logger;

import java.util.ArrayList;
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


        /**
         * TODO:in each round, each core number and percent
         */






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


    public static void processOneResultSet(ResultSet resultSet) {
        ArrayList<Integer> coreList = resultSet.getEstCoreList();
        ArrayList<Integer> core_number = new ArrayList<Integer>();

        for (int core : coreList) {
            int orig = (core_number.get(core) == null) ? 0 : core_number.get(core);
            core_number.set(core, orig + 1);
        }
        LOGGER.info("core distribution: " + core_number.toString());
    }


    public static void main(String[] args) {

    }


}
