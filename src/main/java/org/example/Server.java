package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            ServerSocket serverSocket = new ServerSocket(6700);
           while (true){


               Socket socket = serverSocket.accept();
               DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
               String s = dataInputStream.readUTF();
               System.out.println("client message is :" + s);

               System.out.println("enter server message:");
               String s1 = scanner.nextLine();
               DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
               dataOutputStream.writeUTF(s1);
               dataOutputStream.flush();
               System.out.println("server message sending");

           }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}