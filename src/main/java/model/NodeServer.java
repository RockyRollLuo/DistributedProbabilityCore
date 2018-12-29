package model;

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


    public NodeServer(int nodeId, int estCore) {
        this.nodeId = nodeId;
        this.estCore = estCore;
        changed = false;
        this.message=nodeId+"_"+estCore;
    }



    public void sendMessage() {
        String host = "127.0.0.1"; //ipdress
        int port = 55533;
        Socket socket = null;
        try {
            socket = new Socket(host, port);

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


    public void reciveMessage() {
        int port = 55533;
        ServerSocket server = null;
        try {
            server = new ServerSocket(port);

            System.out.println("wait for reciveMessage......");
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sb = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sb.append(new String(bytes, 0, len, "UTF-8"));
            }
            System.out.println("get message from client: " + sb);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("Hello Client,I get the message.".getBytes("UTF-8"));

            inputStream.close();
            outputStream.close();
            socket.close();
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
