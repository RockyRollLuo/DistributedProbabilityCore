package tool;

import model.UndirectGraph;
import org.apache.log4j.Logger;

import java.io.IOException;

public class TestReadData {
    private static Logger LOGGER = Logger.getLogger(TestReadData.class);

    public static void main(String[] args) {

        String filePath="testdata\\undirectgraph6";
        System.out.println(filePath);

        try {
            UndirectGraph ug=ReadData.readUndirectGraph(filePath);
            int vertexSize=ug.getVertexSize();
            int[][] edgeMartix=ug.getEdgeMatrix();

            for (int i = 0; i < vertexSize; i++) {
                for (int j = 0; j < vertexSize; j++) {
                    System.out.print(edgeMartix[i][j]+" ");
                }
                System.out.println();
            }

            int maxdeg=ug.getMaxdegree();

            LOGGER.info("maxdeg:"+maxdeg);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
