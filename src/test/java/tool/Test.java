/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package tool;

import model.DeterminVertex;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Test {
    private static Logger LOGGER = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        int a=10;
        System.out.println(new Double(1)/a);


        ArrayList<DeterminVertex> vertexList = new ArrayList<DeterminVertex>();
        DeterminVertex vertex0=new DeterminVertex(0,1);
        DeterminVertex vertex1=new DeterminVertex(1,2);
        DeterminVertex vertex2=new DeterminVertex(2,2);
        DeterminVertex vertex3=new DeterminVertex(3,2);
        DeterminVertex vertex4=new DeterminVertex(4,2);
        DeterminVertex vertex5=new DeterminVertex(5,2);
        DeterminVertex vertex6=new DeterminVertex(6,1);
        vertexList.add(vertex0);
        vertexList.add(vertex1);
        vertexList.add(vertex2);
        vertexList.add(vertex3);
        vertexList.add(vertex4);
        vertexList.add(vertex5);
        vertexList.add(vertex6);

        for (DeterminVertex e : vertexList) {
            e.setEstCore(3);
        }

        DeterminVertex  vertex=null;
        for (int i = 0; i < vertexList.size(); i++) {
            vertex = vertexList.get(i);
            vertex.setEstCore(4);
        }

        for (DeterminVertex e : vertexList) {
            System.out.println("first");
            System.out.println(e.getEstCore());
        }

        for (DeterminVertex e : vertexList) {
            e.setEstCore(5);
        }


        for (DeterminVertex e : vertexList) {
            System.out.println("second");
            System.out.println(e.getEstCore());
        }

    }
}
