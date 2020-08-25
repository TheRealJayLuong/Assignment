package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String player1, player2;
        String color1, color2;
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter 1st player name: ");
        player1 = input.nextLine();
        System.out.println("Please enter your color for light cycle: ");
        color1 = input.nextLine();
        System.out.println("Please enter 2nd player name: ");
        player2 = input.nextLine();
        System.out.println("Please enter your color for light cycle: ");
        color2 = input.nextLine();

    }
}
