/**
 * User: RockyRoll
 * Date: 2018-12-29
 */
package tool;

import model.DeterminVertex;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashSet;

public class Test {
    private static Logger LOGGER = Logger.getLogger(Test.class);

    public static void main(String[] args) {

        int a=10;
        System.out.println(new Double(1)/a);

        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);


//        HashSet<Integer> set = new HashSet<Integer>();
//        set.add(1);
//        set.add(2);
//        set.add(3);
//        set.add(2);
//        set.add(2);
//        set.add(3);
//        set.add(1);
//        System.out.println("set size:"+set.size());
//        for (int i : set) {
//            System.out.println(i);
//        }


//        ArrayList<DeterminVertex> vertexList = new ArrayList<DeterminVertex>();
//        DeterminVertex vertex0=new DeterminVertex(0,1);
//        DeterminVertex vertex1=new DeterminVertex(1,2);
//        DeterminVertex vertex2=new DeterminVertex(2,2);
//        DeterminVertex vertex3=new DeterminVertex(3,2);
//        DeterminVertex vertex4=new DeterminVertex(4,2);
//        DeterminVertex vertex5=new DeterminVertex(5,2);
//        DeterminVertex vertex6=new DeterminVertex(6,1);
//        vertexList.add(vertex0);
//        vertexList.add(vertex1);
//        vertexList.add(vertex2);
//        vertexList.add(vertex3);
//        vertexList.add(vertex4);
//        vertexList.add(vertex5);
//        vertexList.add(vertex6);
//
//        for (DeterminVertex e : vertexList) {
//            e.setEstCore(3);
//        }
//
//        DeterminVertex  vertex=null;
//        for (int i = 0; i < vertexList.size(); i++) {
//            vertex = vertexList.get(i);
//            vertex.setEstCore(4);
//        }
//
//        for (DeterminVertex e : vertexList) {
//            System.out.println("first");
//            System.out.println(e.getEstCore());
//        }
//
//        for (DeterminVertex e : vertexList) {
//            e.setEstCore(5);
//        }
//
//
//        for (DeterminVertex e : vertexList) {
//            System.out.println("second");
//            System.out.println(e.getEstCore());
//        }

        int[][] matrix = new int[2][2];
        System.out.println("matrix.length:"+matrix.length);



    }
}
