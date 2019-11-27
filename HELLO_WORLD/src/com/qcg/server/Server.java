package com.qcg.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket socket =new ServerSocket(8888);
            ExecutorService executorService = Executors.newFixedThreadPool(20);
            while (true){
//                Thread thread = new Thread(new exec(socket.accept()));
//                thread.start();
                executorService.submit(new exec(socket.accept()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class exec implements  Runnable{
    private Socket accept = null;

    public exec(Socket sc) {
        this.accept = sc;
    }

    @Override
    public void run() {
        BufferedReader bf=null;
        try {
            InputStream inputStream1 = accept.getInputStream();
             bf=new BufferedReader(new InputStreamReader(inputStream1));

            StringBuffer sb =new StringBuffer();
            String str ="";
            while((str=bf.readLine())!=null){
                sb.append(str);

            }
            System.out.println(sb);
            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("你好".getBytes());
            accept.shutdownOutput();

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (bf!=null){
                    bf.close();
                }
                if (accept!=null){
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}