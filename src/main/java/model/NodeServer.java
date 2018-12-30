package model;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class NodeServer {
    private int nodeId;
    private int estCore;

    private Boolean changed;
    private ArrayList<Integer> neighborList;
    private HashMap<Integer, Integer> neigborCore = new HashMap<Integer, Integer>();

    private String message; //id + core


    private static Logger LOGGER = Logger.getLogger(NodeServer.class);

    public NodeServer(int nodeId, int estCore) {
        this.nodeId = nodeId;
        this.estCore = estCore;
        changed = false;
        this.message=nodeId+"_"+estCore;
    }

    private static final String host = "127.0.0.1"; //will send message to ip


    public void sendMessage(int sendPort) {
        Socket socket = null;
        try {
            socket = new Socket(host, sendPort);

            LOGGER.info(this.getClass().getName()+": send message");

            OutputStream outputStream = socket.getOutputStream();
//            String message = "output meassge";
            socket.getOutputStream().write(this.message.getBytes("UTF-8"));
            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len,"UTF-8"));
            }
            System.out.println("get message from server: " + sb);

            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void reciveMessage(int receivePort) {
        ServerSocket server = null;
        try {
            server = new ServerSocket(receivePort);

            LOGGER.info(this.getClass().getName()+": wait for message......");

            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }

            LOGGER.info("get message: " + sb);

//            OutputStream outputStream = socket.getOutputStream();
//            outputStream.write("Hello Client,I get the message:".getBytes("UTF-8"));

            inputStream.close();
//            outputStream.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
