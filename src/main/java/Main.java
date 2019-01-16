import algorithm.DistributedAlgorithm;
import algorithm.DistributedCore;
import algorithm.DistributedEtaCore;
import algorithm.DistributedSimpleCore;
import base.ResultSet;
import org.apache.log4j.Logger;
import tool.ConstantVal;
import tool.ResultProcess;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        DistributedAlgorithm algorithm;
        String datasetName;
        double eta = 1.0;
        Scanner scanner = new Scanner(System.in);

        /**
         * choose algorithm
         */
        System.out.println("===Choose an algorithm type===");
        for (Map.Entry<Integer, String> entry : ConstantVal.MapAlgorithmType.entrySet()) {
            System.out.println("[" + entry.getKey() + "]: " + entry.getValue());
        }

        System.out.print("Input your algorithm type:");
        int algorithmType = scanner.nextInt();
        LOGGER.info("algorithm type: " + ConstantVal.MapAlgorithmType.get(algorithmType));

        /**
         * choose dataset
         */
        System.out.println("===Choose an dataset===");
        if (algorithmType == 0 || algorithmType == 1) {
            for (Map.Entry<Integer, String> entry : ConstantVal.MapDatasetName_UndirectGraph.entrySet()) {
                System.out.println("[" + entry.getKey() + "]: " + entry.getValue());
            }
        } else {
            for (Map.Entry<Integer, String> entry : ConstantVal.MapDatasetName_ProbGraph.entrySet()) {
                System.out.println("[" + entry.getKey() + "]: " + entry.getValue());
            }
        }
        System.out.print("Input your dataset:");
        int datasetType = scanner.nextInt();

        if (algorithmType == 0 || algorithmType == 1) {
            datasetName = ConstantVal.MapDatasetPath_undirectGraph.get(datasetType);
            LOGGER.info("==dataset type: " + ConstantVal.MapDatasetName_UndirectGraph.get(datasetType) + "==");
        } else {
            datasetName = ConstantVal.MapDatasetPath_ProbGraph.get(datasetType);
            LOGGER.info("==dataset type: " + ConstantVal.MapDatasetName_ProbGraph.get(datasetType) + "==");
        }

        /**
         * ============run algorithm=================
         */
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
                System.out.print("Input your eta:");
                eta = scanner.nextDouble();
                break;
            default:
                LOGGER.error("We do not have this algorithm!");
                return;
        }
        LOGGER.info("==eta: " + eta + "==");

        ArrayList<ResultSet> resultSetArrayList;
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
