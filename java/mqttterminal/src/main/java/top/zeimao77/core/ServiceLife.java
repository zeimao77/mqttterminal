package top.zeimao77.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.zeimao77.main.Start;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiceLife extends Thread {

    private static Logger logger = LoggerFactory.getLogger(ServiceLife.class);

    Integer PORT = 22222;

    Start start;

    public ServiceLife(Start start) {
        this.start = start;
    }

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                logger.info(socket.getInetAddress() + "取得SOCKET联接");
                OutputStream socketOutputStream = socket.getOutputStream();
                InputStream socketInputStream = socket.getInputStream();
                DataOutputStream dataOutputStream = new DataOutputStream(socketOutputStream);
                DataInputStream dataInputStream = new DataInputStream(socketInputStream);
                String scriptStr = dataInputStream.readUTF().trim();
                logger.info("监听到消息:"+ scriptStr);
                String returnStr = "##";
                if("<#SHUTDOWN#>".equals(scriptStr)) {
                    //停止服务器
                    start.stop();
                    returnStr = "<#SERVER STOP...#>";

                }
                if("<QUERY_STATUS>".equals(scriptStr)) {
                    returnStr = "<#SERVER RUNNING#>";
                }
                dataInputStream.close();
                dataOutputStream.close();
                socketInputStream.close();
                socketOutputStream.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
