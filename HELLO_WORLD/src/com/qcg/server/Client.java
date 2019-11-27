package com.qcg.server;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket =new Socket("localhost",8888);
            OutputStream out = socket.getOutputStream();
            out.write("卧槽".getBytes());
            socket.shutdownOutput();
            InputStream inputStream = socket.getInputStream();
            BufferedReader bf =new BufferedReader(new InputStreamReader(inputStream));
            String s = bf.readLine();
            System.out.println(s);
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
