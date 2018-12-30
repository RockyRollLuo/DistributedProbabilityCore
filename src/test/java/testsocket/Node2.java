package testsocket;

import model.NodeServer;
import org.apache.log4j.Logger;

public class Node2 {
    private static Logger LOGGER = Logger.getLogger(Node2.class);

    public static void main(String[] args) {
        LOGGER.info(Node1.class.getName());

        int node1port=55551;
        int node2port=55552;
        NodeServer node2=new NodeServer(2,5);
        node2.sendMessage(node1port);
        node2.reciveMessage(node2port);



    }

}
