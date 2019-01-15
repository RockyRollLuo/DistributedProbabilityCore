import algorithm.DistributedAlgorithm;
import algorithm.DistributedCore;
import algorithm.DistributedEtaCore;
import algorithm.DistributedSimpleCore;
import base.ResultSet;
import org.apache.log4j.Logger;
import tool.ResultProcess;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DistributedAlgorithm algorithm = null;
        String datasetName;

        System.out.println("===Choose an algorithm type===");
        System.out.println("==[0]:Distributed Simple Core Decomposition==");
        System.out.println("==[1]:Distributed Core Decomposition==");
        System.out.println("==[2]:Distributed Eta-Core Decomposition==");

        Scanner scanner = new Scanner(System.in);
        int algorithmType = scanner.nextInt();
        double eta=1.0;

        switch (algorithmType) {
            case 0:
                algorithm = new DistributedSimpleCore();
                break;
            case 1:
                algorithm = new DistributedCore();
                break;
            case 2:
                algorithm = new DistributedEtaCore();
                System.out.println("==input eta==");
                eta = scanner.nextDouble();
                break;
            default:
                LOGGER.error("We do not have this algorithm!");
                return;
        }


        System.out.println("===Choose an dataset===");
        if (algorithmType == 0 || algorithmType == 1) {
            System.out.println("[0]:p2p-Gnutella08.txt       # MinIndex:0    MaxIndex:6300       Nodes: 6301     Edges: 20777");
            System.out.println("[1]:p2p-Gnutella09.txt       # MinIndex:0    MaxIndex:8113       Nodes: 8114     Edges: 26013");
            System.out.println("[2]:CA-GrQc.txt              # MinIndex:13   MaxIndex:26196      Nodes: 5242     Edges: 28980");
            System.out.println("[3]:Email-Enron.txt          # MinIndex:0    MaxIndex:36691      Nodes: 36692    Edges: 367662");
            System.out.println("[4]:p2p-Gnutella31.txt       # MinIndex:0    MaxIndex:62585      Nodes: 62586    Edges: 147892");
            System.out.println("[5]:CA-CondMat.txt           # MinIndex:1    MaxIndex:108299     Nodes: 23133    Edges: 186936");
            System.out.println("[6]:CA-AstroPh.txt           # MinIndex:3    MaxIndex:133279     Nodes: 18772    Edges: 396160");
            System.out.println("[7]:com-dblp.ungraph.txt     # MinIndex:0    MaxIndex:425956     Nodes: 317080   Edges: 1049866");
            System.out.println("[8]:roadNet-TX.txt           # MinIndex:0    MaxIndex:1393382    Nodes: 1379917  Edges: 3843320");
        } else {
            System.out.println("[9]:test4node");
        }

        int datasetType = scanner.nextInt();
        switch (datasetType) {
            case 0:
                datasetName = "processdata/p2p-Gnutella08.txt";
                break;
            case 1:
                datasetName = "processdata/p2p-Gnutella09.txt";
                break;
            case 2:
                datasetName = "processdata/CA-AstroPh.txt";
                break;
            case 3:
                datasetName = "processdata/Email-Enron.txt";
                break;
            case 4:
                datasetName = "processdata/p2p-Gnutella31.txt";
                break;
            case 5:
                datasetName = "processdata/CA-CondMat.txt";
                break;
            case 6:
                datasetName = "processdata/CA-AstroPh.txt";
                break;
            case 7:
                datasetName = "processdata/com-dblp.ungraph.txt";
                break;
            case 8:
                datasetName = "processdata/roadNet-TX.txt";
                break;
            case 9:
                datasetName = "processdata/test4node";
                break;
            default:
                LOGGER.error("we dont have this dataset!");
                return;
        }


        /**
         * ============run algorithm=================
         */
        ArrayList<ResultSet> resultSetArrayList = null;

        if (algorithmType == 0 || algorithmType == 1) {
            resultSetArrayList = algorithm.run(datasetName);
        } else {
            resultSetArrayList = algorithm.run(datasetName, eta);
        }


        for (ResultSet rs : resultSetArrayList) {
            LOGGER.info("roundNo:" + rs.getRoundNo() + " changedNum:" + rs.getChangedNum() + " noChangedNum:" + rs.getNoChangedNum() + " roundTime:" + rs.getRoundTime());
//            LOGGER.info(rs.getEstCoreList().toString());
//            ResultProcess.processOneResultSet(rs);
        }

    }
}
