package com.company;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.nio.file.StandardOpenOption.*;
public class LeaderBoard extends JPanel{
    String originalPath = "C:\\\\Users\\\\phong\\\\IdeaProjects\\\\Assignment\\\\src\\\\com\\\\company\\\\leaderboard.txt\\\\";
    JLabel heading = new JLabel("Leaderboard: \n"); //The  leaderboard header
    JLabel savedscore = new JLabel(""); //The score saved in the  leaderboard
    LightCycle lightCycle;                   //Calling class LightCycle
    // LeaderBoard constructor (designing the panel and labels)
    public LeaderBoard(){
        setPreferredSize(new Dimension(100,600));
        setBackground(Color.BLACK);
        heading.setForeground(Color.WHITE);
        savedscore.setForeground(Color.RED);
        add(heading, BorderLayout.NORTH);


        //Opening the leaderboard file

        Path path = Paths.get(originalPath);
        InputStream input = null;
        try{
            input = Files.newInputStream(path);
            BufferedReader reader = new BufferedReader(new
                    InputStreamReader(input));
            String s = null;
            s = reader.readLine();
            savedscore.setText(s);
            add(savedscore, BorderLayout.CENTER);

            input.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}


