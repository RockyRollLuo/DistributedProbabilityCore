import algorithm.DistributedCore;
import algorithm.DistributedEtaCore;
import base.ResultSet;
import org.apache.log4j.Logger;
import tool.ResultProcess;

import java.util.ArrayList;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

        String datasetName = "";

        /***
         * dataset stasitics
         *
         * CA-AstroPh.txt           # MinIndex:3    MaxIndex: 133279    Nodes: 18772    Edges: 396160
         * CA-CondMat.txt           # MinIndex:1	MaxIndex:108299     Nodes: 23133    Edges: 186936
         * CA-GrQc.txt              # MinIndex:13	MaxIndex:26196      Nodes: 5242     Edges: 28980
         * com-dblp.ungraph.txt     # MinIndex:0    MaxIndex:425956     Nodes: 317080   Edges: 1049866
         * Email-Enron.txt          # MinIndex:0	MaxIndex:36691      Nodes: 36692    Edges: 367662
         * p2p-Gnutella08.txt       # MinIndex:0	MaxIndex:6300       Nodes: 6301     Edges: 20777
         * p2p-Gnutella09.txt       # MinIndex:0	MaxIndex:8113       Nodes: 8114     Edges: 26013
         * p2p-Gnutella31.txt       # MinIndex:0	MaxIndex:62585      Nodes: 62586    Edges: 147892
         * roadNet-TX.txt           # MinIndex:0	MaxIndex:1393382    Nodes: 1379917  Edges: 3843320
         *
         */

        datasetName =

                /*====undirect graph test data====*/

//                "testdata/undirectgraph6";
//                "testdata/undirectgraph7";
                "testdata/undirectgraph18";

                /*====undirect graph data set====*/

//                "processdata/CA-AstroPh.txt";
//                "processdata/CA-CondMat.txt";
//                "processdata/CA-GrQc.txt";
//                "processdata/com-dblp.ungraph.txt";
//                "processdata/p2p-Gnutella08.txt";        //check
//                "processdata/p2p-Gnutella09.txt";        //check
//                "processdata/p2p-Gnutella31.txt";          //check after ad
//                "processdata/roadNet-TX.txt";


        /*====probabilistic graph test data====*/

//                "testdata/prograph4";


        /*====probabilistic graph data set====*/
//                "processdata/CA-AstroPh.txt";


        /**
         * ============Distributed Core Decomposition=================
         */
        DistributedCore distributedCore = new DistributedCore();
        ArrayList<ResultSet> resultSetArrayList = distributedCore.run(datasetName);

        for (ResultSet rs : resultSetArrayList) {
            LOGGER.info("roundNo:" + rs.getRoundNo() + " changedNum:" + rs.getChangedNum() + " noChangedNum:" + rs.getNoChangedNum() + " roundTime:" + rs.getRoundTime());
            LOGGER.info(rs.getEstCoreList().toString());
            ResultProcess.processOneResultSet(rs);
        }


        /**
         * ============Distributed Eta-Core Decomposition================
         */
        double eta = 0.5;
        DistributedEtaCore distributedEtaCore = new DistributedEtaCore();
        ArrayList<ResultSet> resultSetArrayList1 = distributedEtaCore.run(datasetName, eta);
        for (ResultSet rs : resultSetArrayList1) {
            LOGGER.info(rs.getRoundNo() + " " + rs.getChangedNum() + " " + rs.getNoChangedNum() + " " + rs.getRoundTime());
            LOGGER.info(rs.getEstCoreList().toString());
        }


    }
}
