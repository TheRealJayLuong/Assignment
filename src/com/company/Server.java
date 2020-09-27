package com.company;
import javax.swing.*;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
public class Server {


    public static void main(String[] args) throws Exception{
        int number;
        ServerSocket s1 = new ServerSocket(1342);
        Socket socket = s1.accept();
        Scanner sc = new Scanner(socket.getInputStream());
        number = sc.nextInt();
        PrintStream p = new PrintStream(socket.getOutputStream());
        String temp = number + " clients are added";
        p.println(temp);
    }


}