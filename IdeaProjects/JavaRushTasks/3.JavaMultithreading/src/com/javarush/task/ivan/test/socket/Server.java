package com.javarush.task.ivan.test.socket;
import sun.nio.ch.IOUtil;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(999);
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            ObjectInputStream in = new ObjectInputStream(inputStream);

            while (true){
                String s = (String) in.readObject();
                System.out.println(s);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
