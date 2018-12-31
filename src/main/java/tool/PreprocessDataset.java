/**
 * User: RockyRoll
 * Date: 2018-12-30
 */
package tool;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.HashSet;

public class PreprocessDataset {
    private static Logger LOGGER = Logger.getLogger(PreprocessDataset.class);


    /***
     * get dataset the max-index,min-index, and vertex num
     * @param args
     */
    public static void main(String[] args) {


        String filePath=System.getProperty("user.dir")+"\\dataset\\origdata\\p2p-Gnutella09.txt";
        HashSet<Integer> vertexSet = new HashSet<Integer>();
        int maxIndex = Integer.MIN_VALUE;
        int minIndex = Integer.MAX_VALUE;

        String[] edge=new String[2];
        int u=0;
        int v=0;
        try {
            BufferedReader br = null;
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
            for (String line = br.readLine(); line != null; line = br.readLine()) {
                if (line.indexOf("#") > -1) {
                    continue;
                }
                LOGGER.info("edge:"+line);

                edge = line.split("\t");
                u = Integer.parseInt(edge[0]);
                v = Integer.parseInt(edge[1]);

                vertexSet.add(u);
                vertexSet.add(v);

                if (u > v) {
                    maxIndex = (u > maxIndex ? u : maxIndex);
                    minIndex = (v < minIndex ? v : minIndex);
                } else{
                    maxIndex = (v > maxIndex ? v : maxIndex);
                    minIndex = (u < minIndex ? u : minIndex);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (vertexSet != null && vertexSet.size() > 0) {
            int len = vertexSet.size();
            System.out.println("vertexSize:" + len);
            System.out.println("maxIndex:"+maxIndex); //the vertex should be 1 bigger than it (+1)
            System.out.println("minIndex:"+minIndex);
        }

    }

}
