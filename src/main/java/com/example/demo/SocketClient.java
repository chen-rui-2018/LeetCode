package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
public class SocketClient extends Thread{

    public static void main(String[] args) {
        SocketClient client = new SocketClient("127.0.0.1",8080);
        client.start();
    }

    Socket socket = null;
    public  SocketClient(String host, int port){
        try {
            socket = new Socket(host,port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        new SendMessThread().start();
        super.run();
        try {
            InputStream s = socket.getInputStream();
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len = s.read(buf)) != -1) {
                System.out.println(getdate() + "  服务器说：  "+new String(buf, 0, len,"UTF-8"));
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
    class SendMessThread extends Thread{
        @Override
        public void run() {
            super.run();
            //写操作
            Scanner scanner=null;
            OutputStream os= null;
            try {
                scanner=new Scanner(System.in);
                os= socket.getOutputStream();
                String in="";
                do {
                    in=scanner.nextLine();
                    os.write((""+in).getBytes());
                    os.flush();
                } while (!in.equals("bye"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            scanner.close();
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
