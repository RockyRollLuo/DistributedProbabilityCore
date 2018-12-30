package tool;

import model.UndirectGraph;
import modelbig.BigGraph;
import org.apache.log4j.Logger;

import java.io.*;
import java.math.BigInteger;

public class ReadData {
    private static Logger LOGGER = Logger.getLogger(ReadData.class);

    private static String datasetRoot=System.getProperty("user.dir")+"\\dataset\\";

    /**
     * read a dataset
     * @param datasetName
     * @return undirect graoh
     * @throws IOException
     */
    public static UndirectGraph readUndirectGraph(String datasetName) throws IOException {
        LOGGER.info("===starting=== readUndirectGraph");

        String filePath=datasetRoot+datasetName;
        LOGGER.info("datasetname: "+datasetName);

        String line=null;

        int vertexSize=0;
        int[][] edgeMatrix=null;

        String[] edge=null;
        int headV=0;
        int tailV=0;

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line=br.readLine();

            LOGGER.info("==start== read vertextsize:"+line);
            vertexSize=Integer.parseInt(line);
            edgeMatrix= new int[vertexSize][vertexSize];
            for (int i = 0; i < vertexSize; i++) {
                for (int j = 0; j < vertexSize; j++) {
                    edgeMatrix[i][j]=0;
                }
            }

            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge=line.split("   ");
                headV=Integer.parseInt(edge[0]);
                tailV=Integer.parseInt(edge[1]);
                edgeMatrix[headV][tailV]=1;
                edgeMatrix[tailV][headV]=1;  //undirect graph
            }
            br.close();
        }catch (IOException e){
            LOGGER.error("IO error");
            System.out.println("readUndirectGraph:"+e);
        }

        UndirectGraph undirectGraph=new UndirectGraph(edgeMatrix);
        return undirectGraph;
    }


    public static BigGraph readBigGraph(String datasetName) throws IOException {
        LOGGER.info("===starting=== readBigGraph");

        String filePath=datasetRoot+datasetName;
        LOGGER.info("datasetname: "+datasetName);

        String line=null;

        BigInteger vertexSize=BigInteger.valueOf(0);
        BigInteger[][] edgeMatrix=null;

        String[] edge=null;
        BigInteger headV=BigInteger.valueOf(0);
        BigInteger tailV=BigInteger.valueOf(0);

        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line=br.readLine();

            LOGGER.info("==start== read vertextsize:"+line);
            vertexSize=new BigInteger(line);
            edgeMatrix= new BigInteger[][];
            for (BigInteger i = 0; i < vertexSize; i++) {
                for (int j = 0; j < vertexSize; j++) {
                    edgeMatrix[i][j]=0;
                }
            }

            LOGGER.info("==start== read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                edge=line.split("\t");
                headV=Integer.parseInt(edge[0]);
                tailV=Integer.parseInt(edge[1]);
                edgeMatrix[headV][tailV]=1;
                edgeMatrix[tailV][headV]=1;  //undirect graph
            }
            br.close();
        }catch (IOException e){
            LOGGER.error("IO error");
            System.out.println("readUndirectGraph:"+e);
        }

        UndirectGraph undirectGraph=new UndirectGraph(edgeMatrix);
        return undirectGraph;
    }
















//    ===Two types to read file====================================================================
    public static final void readF1(String filePath) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));

        for (String line = br.readLine(); line != null; line = br.readLine()) {
//            System.out.println(line);

        }
        br.close();
    }

    public static final void readF2(String filePath) throws IOException {
        FileReader fr = new FileReader(filePath);
        BufferedReader bufferedreader = new BufferedReader(fr);
        String instring;
        while ((instring = bufferedreader.readLine().trim()) != null) {
            if (0 != instring.length()) {
//                System.out.println(instring);
            }
        }
        fr.close();
    }


}
