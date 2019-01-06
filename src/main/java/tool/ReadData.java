package tool;

import model.ProbabilityGraph;
import model.UndirectGraph;
import org.apache.log4j.Logger;

import java.io.*;

public class ReadData {
    private static Logger LOGGER = Logger.getLogger(ReadData.class);

    private static String datasetRoot = System.getProperty("user.dir") + "\\dataset\\";

    /**
     * read a dataset
     *
     * @param datasetName
     * @return undirect graoh
     * @throws IOException
     */
    public static UndirectGraph readUndirectGraph(String datasetName){
        LOGGER.info("===starting=== readUndirectGraph");

        String filePath = datasetRoot + datasetName;
        LOGGER.info("datasetname: " + datasetName);

        String line;

        int vertexSize;
        int[][] edgeMatrix = null;
        String[] edge;
        int headV;
        int tailV;

        try {
//            LOGGER.info("==start== read file:");
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line = br.readLine();

            while (line.indexOf("#") > -1) {
                line = br.readLine();   //ignore the comment in dataset
            }

            LOGGER.info("vertextsize:" + line);
            vertexSize = Integer.parseInt(line);
            edgeMatrix = new int[vertexSize][vertexSize];
            for (int i = 0; i < vertexSize; i++) {
                for (int j = 0; j < vertexSize; j++) {
                    edgeMatrix[i][j] = 0;
                }
            }

//            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge = line.split("\t");
                headV = Integer.parseInt(edge[0]);
                tailV = Integer.parseInt(edge[1]);
                edgeMatrix[headV][tailV] = 1;
                edgeMatrix[tailV][headV] = 1;  //undirect graph
            }
            br.close();
        } catch (IOException e1) {
            LOGGER.error("IO error");
            System.out.println("readUndirectGraph: " + e1);
        } catch (OutOfMemoryError e2) {
            LOGGER.error("Out of memory error");
            System.out.println("readUndriectGraph: " + e2);
        }

        UndirectGraph undirectGraph = new UndirectGraph(edgeMatrix);
        return undirectGraph;
    }


    public static ProbabilityGraph readProbabilityGraph(String datasetName) throws IOException {
        LOGGER.info("===starting=== readProbabilityGraph");

        String filePath = datasetRoot + datasetName;
        LOGGER.info("datasetname: " + datasetName);

        String line;
        int vertexSize;
        double[][] edgeMatrix = null;
        String[] edge;
        int headV;
        int tailV;
        double p;

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line = br.readLine();

            LOGGER.info("==start== read vertextsize:" + line);
            vertexSize = new Integer(line);
            edgeMatrix = new double[vertexSize][vertexSize];
//            for (int i = 0; i < vertexSize; i++) {
//                for (int j = 0; j < vertexSize; j++) {
//                    edgeMatrix[i][j] = 0;
//                }
//            }

            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge = line.split("\t");
                headV = Integer.parseInt(edge[0]);
                tailV = Integer.parseInt(edge[1]);
                p = Double.parseDouble(edge[2]);
                edgeMatrix[headV][tailV] = p;
                edgeMatrix[tailV][headV] = p;  //undirect probability graph
            }
            br.close();
        } catch (IOException e) {
            LOGGER.error("IO error");
            System.out.println("readProbabilityGraph:" + e);
        }

        ProbabilityGraph probabilityGraph = new ProbabilityGraph(edgeMatrix);
        return probabilityGraph;
    }

}
