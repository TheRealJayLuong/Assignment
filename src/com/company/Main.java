package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class Main {

    public static void main(String[] args) {
        // write your code here
        String a = JOptionPane.showInputDialog("Enter 1st player name: ");
        Color c = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.RED);
        String b = JOptionPane.showInputDialog("Enter 2nd player name: ");
        Color d = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.GREEN);
        String h = JOptionPane.showInputDialog("Enter 3rd player name: ");
        Color f = JColorChooser.showDialog(null, "Choose a color for your Light Cycle", Color.BLUE);
        //Create frame of game, game title
        JFrame frame = new JFrame("Light Cycle");
        Grid grid = new Grid();
        //Setting up two light cycles
        LightCycle bike1 = new LightCycle(5, c);
        LightCycle bike2 = new LightCycle(5, d);
        LightCycle bike3 = new LightCycle(5,f);

//display names, scores and leaderboard on screen
        JLabel name = new JLabel("Name: " + a + " | " );
        JLabel name2= new JLabel("Name: " + b + " | " );
        JLabel name3= new JLabel("Name: " + h + " | ");
        final JLabel scoreDisplay = new JLabel("Score: " );
        final JLabel scoreDisplay2 = new JLabel("Score: ");
        final JLabel scoreDisplay3 = new JLabel("Score: ");
        LeaderBoard leaderBoard = new LeaderBoard();
        name.setForeground(Color.BLACK);
        name2.setForeground(Color.BLACK);
        name.setBackground(Color.WHITE);
        name2.setBackground(Color.WHITE);
        name3.setBackground(Color.WHITE);
        name3.setForeground(Color.BLACK);
        frame.setSize(600,800);
        ScoreBoard scoreBoard = new ScoreBoard();
        scoreBoard.add(name, BorderLayout.NORTH);
        scoreBoard.add(scoreDisplay, BorderLayout.SOUTH);
        scoreBoard.add(name2,BorderLayout.NORTH);
        scoreBoard.add(scoreDisplay2,BorderLayout.SOUTH);
        scoreBoard.add(name3, BorderLayout.NORTH);
        scoreBoard.add(scoreDisplay3, BorderLayout.SOUTH);

        frame.add(scoreBoard, BorderLayout.SOUTH);
        frame.add(leaderBoard, BorderLayout.EAST);
        //get random position of light cyclels in grid
        bike1.getRandomStart();
        bike2.getRandomStart();
        bike3.getRandomStart();
        // frame-by-frame animation loop
        Timer timer = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bike1.move(grid.getSize(),bike2.getPoints()); //move  bike1
                bike2.move(grid.getSize(),bike3.getPoints()); //move bike2
                bike3.move(grid.getSize(),bike1.getPoints());
                //display scores
                scoreDisplay.setText("Score: " +
                        String.valueOf(bike1.getScore()) + "  ------  ");
                scoreDisplay2.setText("Score: " +
                        String.valueOf(bike2.getScore()) + " -------  ");
                scoreDisplay3.setText("Score: " +
                        String.valueOf(bike3.getScore()));
//                if bike1 die
                if (!bike1.getAlive()) {
                    bike1.leaderBoard(); //save scores to leaderboard
                    bike2.leaderBoard();
                    bike3.leaderBoard();

                    //display winner
                    int selectedOption =
                            JOptionPane.showConfirmDialog(frame, b + " and " + h + " won!" +
                                    "\n Do you want to play again?");
                    //restart
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        bike1.restart();
                        bike2.restart();
                        bike3.restart();
                        //close System
                    }
                    if (selectedOption == JOptionPane.NO_OPTION ||
                            selectedOption == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }
                }
                //if bike2 dies
                if (!bike2.getAlive()) {
                    bike1.leaderBoard();     //save scores to leaderboard
                    bike2.leaderBoard();
                    bike3.leaderBoard();
                    //display winner
                    int selectedOption =
                            JOptionPane.showConfirmDialog(frame, a + " and " + h + " won!" +
                                    "\n Do you want to play again?");

                    //restart
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        bike1.restart();
                        bike2.restart();
                        bike3.restart();
                    }
                    //close system
                    if (selectedOption == JOptionPane.NO_OPTION ||
                            selectedOption == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }
                }
//                if bike3 dies
                if (!bike3.getAlive()) {
                    bike1.leaderBoard();     //save scores to leaderboard
                    bike2.leaderBoard();
                    bike3.leaderBoard();
                    //display winner
                    int selectedOption =
                            JOptionPane.showConfirmDialog(frame, a + " and " + b + " won!" +
                                    "\n Do you want to play again?");

                    //restart
                    if (selectedOption == JOptionPane.YES_OPTION) {
                        bike1.restart();
                        bike2.restart();
                        bike3.restart();
                    }
                    //close system
                    if (selectedOption == JOptionPane.NO_OPTION ||
                            selectedOption == JOptionPane.CANCEL_OPTION){
                        System.exit(0);
                    }
                }
                //repaint for each frame per second
                grid.repaint();
            }
        });
        //start timer
        timer.start();
        //Setting up key interaction with light cycle for bike1
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_W){
                    bike1.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    bike1.down();
                }
                if (e.getKeyCode() == KeyEvent.VK_A){
                    bike1.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_D){
                    bike1.right();
                }
            }
        });
        //Setting up key interaction with light cycle for bike2
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_UP){
                    bike2.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN){
                    bike2.down();
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT){
                    bike2.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_RIGHT){
                    bike2.right();
                }
            }
        });
        grid.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e){
                e.getKeyCode();
                if (e.getKeyCode() == KeyEvent.VK_U){
                    bike3.up();
                }
                if (e.getKeyCode() == KeyEvent.VK_J){
                    bike3.down();
                }
                if (e.getKeyCode() == KeyEvent.VK_H){
                    bike3.left();
                }
                if (e.getKeyCode() == KeyEvent.VK_K){
                    bike3.right();
                }
            }
        });
//add grid to frame
        frame.add(grid, BorderLayout.CENTER);

//when car 1 dies
        //add light cycles to grid
        grid.addLightCycle(bike1);
        grid.addLightCycle(bike2);
        grid.addLightCycle(bike3);
        //set frame's properties
        frame.pack();

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}



