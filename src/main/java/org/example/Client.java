package org.example;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
while (true){
    try {
        Socket socket = new Socket("localhost", 6700);
        System.out.println("enter message:");
        String message = scanner.nextLine();
//client- server ekta message ekk sent kirima
        DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
        dataOutputStream.writeUTF(message);
        dataOutputStream.flush();
        System.out.println("client sending message");


        DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
        String s = dataInputStream.readUTF();
        System.out.println("message from server :"+s);
    } catch (IOException e) {
        throw new RuntimeException(e);


    }
}
    }
}
