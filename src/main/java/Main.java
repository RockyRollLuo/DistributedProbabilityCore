import algorithm.DistributedCore;
import org.apache.log4j.Logger;

public class Main {
    private static Logger LOGGER = Logger.getLogger(Main.class);

    public static void main(String[] args) {

//        String datasetName="testdata/undirectgraph6";
//        String datasetName="testdata/undirectgraph7";
        String datasetName="testdata/undirectgraph18";
//        String datasetName="dblp/com-dblp.ungraph";

        /**
         * Distributed Core Decomposition
         */
        DistributedCore distributedCore = new DistributedCore();
        distributedCore.run(datasetName);




    }

}
