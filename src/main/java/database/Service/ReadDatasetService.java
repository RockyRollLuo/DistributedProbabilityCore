package database.Service;

import algorithm.DistributedCore;
import database.entity.IntEdge;
import model.UndirectGraph;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadDatasetService {
    private static Logger LOGGER = Logger.getLogger(ReadDatasetService.class);

    private static String datasetRoot = System.getProperty("user.dir") + "\\dataset\\";



    public void readDataset(String datasetName) {

        LOGGER.info("===starting=== readUndirectGraph");

        String filePath = datasetRoot + datasetName;
        LOGGER.info("datasetname: " + datasetName);


        IntEdgeService intEdgeService = new IntEdgeService();
        IntEdge intEdge = new IntEdge();

        String line;

        int vertexSize;
        int edgeSize;
        String[] edge;
        int headV;
        int tailV;


        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line = br.readLine();

            StringBuffer datasetDescrip = new StringBuffer();
            while (line.indexOf("#") > -1) {
                datasetDescrip.append(line);
                line = br.readLine();   //ignore the comment in dataset
            }
            LOGGER.info("datasetDscription:"+datasetDescrip);

            int nodeIndex=datasetDescrip.indexOf("Nodes: ");
            int edgesIndex=datasetDescrip.indexOf("Edges: ");
            int endEdgeIndex=datasetDescrip.indexOf("# FromNodeId");
            vertexSize=Integer.parseInt(datasetDescrip.substring(nodeIndex+7,edgesIndex-1));
            edgeSize=Integer.parseInt(datasetDescrip.substring(edgesIndex+7,endEdgeIndex));
            LOGGER.info("nodes number:"+vertexSize);
            LOGGER.info("edges number:"+edgeSize);

            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge = line.split("\t");
                headV = Integer.parseInt(edge[0]);
                tailV = Integer.parseInt(edge[1]);
                intEdge=new IntEdge(1,headV,tailV,1);
                intEdgeService.insertEdge(intEdge);
            }
            br.close();
        } catch (IOException e1) {
            LOGGER.error("IO error");
            System.out.println("readUndirectGraph: " + e1);
        } catch (OutOfMemoryError e2) {
            LOGGER.error("Out of memory error");
            System.out.println("readUndriectGraph: " + e2);
        }

    }


}
