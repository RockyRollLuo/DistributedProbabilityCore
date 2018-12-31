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

public class ResultProcess {
    private static Logger LOGGER = Logger.getLogger(ResultProcess.class);

    /**
     * TODO: process the resultset of each algorithm
     *
     */

    public static void processResult(ArrayList<ResultSet> resultSetList) {
        int totalRound = resultSetList.size();  // total round num
        ResultSet finalResult = resultSetList.get(totalRound - 1);
        int totalVertex=finalResult.getChangedNum()+finalResult.getNoChangedNum(); //total vertex num

        /**
         * TODO:in final round, each core number percent
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


    public static void main(String[] args) {

    }


}
