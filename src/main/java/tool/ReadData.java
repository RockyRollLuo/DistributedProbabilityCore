package tool;

import base.ProbabilityGraph;
import base.SimpleGraph;
import base.UndirectGraph;
import org.apache.log4j.Logger;

import java.io.*;

public class ReadData {
    private static Logger LOGGER = Logger.getLogger(ReadData.class);

    //Determine the operating system type
    private static String osType = System.getProperty("os.name");
    private static String dirStr="/dataset/";
    static{
        if (osType.indexOf("Windows") > -1) {
            dirStr="\\dataset\\";
        } else if (osType.indexOf("Linux") > -1) {
            dirStr="/dataset/";
        }
    }

    private static String datasetRoot = System.getProperty("user.dir") + dirStr;

    /**
     * read a simple graph,  no direction no weight
     * @param datasetName
     * @return
     */
    public static SimpleGraph readSimpleGraph(String datasetName) {
        LOGGER.info("===starting=== readSimpleGraph");

        String filePath = datasetRoot + datasetName;
        LOGGER.info("datasetname: " + datasetName);

        String line;

        int vertexSize;
        boolean[][] edgeMatrix = null;
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
            edgeMatrix = new boolean[vertexSize][vertexSize];

//            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge = line.split("\t");
                headV = Integer.parseInt(edge[0]);
                tailV = Integer.parseInt(edge[1]);
                edgeMatrix[headV][tailV] = true;
                edgeMatrix[tailV][headV] = true;  //undirect graph
            }
            br.close();
        } catch (IOException e1) {
            LOGGER.error("IO error");
            System.out.println("readSimpleGraph: " + e1);
        } catch (OutOfMemoryError e2) {
            LOGGER.error("Out of memory error");
            System.out.println("readSimpleGraph: " + e2);
        }

        SimpleGraph simpleGraph = new SimpleGraph(edgeMatrix);
        return simpleGraph;
    }



    /**
     * read a dataset
     *
     * @param datasetName
     * @return undirect graph , can be weighted graph
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


    /**
     *  read a no weighted graph
     *  may have direction
     * @param datasetName
     * @return
     */
    public static ProbabilityGraph readProbabilityGraph(String datasetName){
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
