package tool;

import model.UndirectGraph;
import org.apache.log4j.Logger;

import java.io.*;

public class ReadData {
    private static Logger LOGGER = Logger.getLogger(ReadData.class);

    public static UndirectGraph readUndirectGraph(String filePath) throws IOException {
        LOGGER.info("starting-"+ReadData.class.getName());

        String line=null;

        int vertexSize=0;
        int[][] edgeMatrix=null;

        String[] edge=null;
        int headV=0;
        int tailV=0;
        
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            line=br.readLine();

            LOGGER.info("start-read vertextsize:"+line);
            vertexSize=Integer.parseInt(line);
            edgeMatrix= new int[vertexSize][vertexSize];
            for (int i = 0; i < vertexSize; i++) {
                for (int j = 0; j < vertexSize; j++) {
                    edgeMatrix[i][j]=0;
                }
            }

            LOGGER.info("start-read edges");
            for (line = br.readLine(); line != null; line = br.readLine()) {
                //readline
                System.out.println(line);
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
