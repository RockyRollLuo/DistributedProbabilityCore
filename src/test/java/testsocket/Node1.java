package testsocket;

import model.NodeServer;
import org.apache.log4j.Logger;

public class Node1 {
    private static Logger LOGGER = Logger.getLogger(Node1.class);


    public static void main(String[] args) {
        LOGGER.info(Node1.class.getName());

        int node1port=55551;
        int node2port=55552;

        NodeServer node1=new NodeServer(1,2);
        node1.reciveMessage(node1port);
        node1.sendMessage(node2port);


    }

}
