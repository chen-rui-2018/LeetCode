package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author： chenr
 * @date： Created on 2021/1/15 16:58
 * @version： v1.0
 * @modified By:
 */
public class SocketServer  extends Thread{
    ServerSocket server = null;
    Socket socket = null;
    public SocketServer (int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void run(){
        super.run();
        try {
            System.out.println(getdate() + "等待客户端连接...");
            socket = server.accept();
            new SendMessThread().start();
            System.out.println((getdate()+" 客户端 (" + socket.getInetAddress().getHostAddress()+") 连接成功..."));
            InputStream in = socket.getInputStream();
            int len = 0;
            byte[] buf = new byte[1024];
            while ((len = in.read(buf)) != -1) {
                System.out.println(getdate() + " 客户端: ("
                + socket.getInetAddress().getHostAddress() +") 说 :"+
                        new String(buf,0,len, "UTF-8"));
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static String getdate() {
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String result = format.format(date);
        return result;
    }
    class SendMessThread extends  Thread{
        @Override
        public void run() {
            super.run();
            Scanner scanner = null;
            OutputStream out = null;
            try{
                if(socket != null) {
                    scanner = new Scanner(System.in);
                    out = socket.getOutputStream();
                    String in = "";
                    do {
                        in = scanner.nextLine();
                        out.write((""+in).getBytes("UTF-8"));
                        out.flush();
                    }while (!in.equals("q"));
                    scanner.close();
                    out.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        SocketServer socketServer = new SocketServer(8080);
        socketServer.start();
    }
}
