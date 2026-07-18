package com.game.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestListener{
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        //Setting window size
        jFrame.setSize(800, 800);

        //Setting window title
        jFrame.setTitle("Ricky Li's game");

        //Setting window on top
        //jFrame.setAlwaysOnTop(true);

        //Setting window at middle
        jFrame.setLocationRelativeTo(null);

        //Setting close mode (Stop the program after closing the window)
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Cancelling the default layout
        jFrame.setLayout(null);


        JButton jtb = new JButton("Damn");
        jtb.setBounds(0,0,300, 300);
        //jtb.addActionListener(new TestActionListener());
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Button is clicked");
            }
        });

        jFrame.getContentPane().add(jtb);




        jFrame.setVisible(true);
    }
}
