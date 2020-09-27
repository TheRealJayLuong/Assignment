package com.company;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Clients {


    public static void main(String[] args) throws IOException
    {
        int num, temp;
        int i;
        Socket s = new Socket("127.0.0.1", 1342);
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(s.getInputStream());
        System.out.println("Enter number of clients: ");
        int number = input.nextInt();
        PrintStream p = new PrintStream(s.getOutputStream());
        p.println(number);
        temp = input1.nextInt();
        System.out.println(temp);

    }
}

