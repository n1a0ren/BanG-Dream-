package com.game.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestMyJFrame extends JFrame implements ActionListener {
    JButton jbt1 = new JButton("jbt1");
    JButton jbt2 = new JButton("jbt2");
    public TestMyJFrame(){
        //Setting window size
        this.setSize(800, 800);

        //Setting window title
        this.setTitle("Ricky Li's game");

        //Setting window on top
        //this.setAlwaysOnTop(true);

        //Setting window at middle
        this.setLocationRelativeTo(null);

        //Setting close mode (Stop the program after closing the window)
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Cancelling the default layout
        this.setLayout(null);

        jbt1.setBounds(0,0,200,200);
        jbt1.addActionListener(this);
        
        jbt2.setBounds(200,0,200,200);
        jbt2.addActionListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object button = e.getSource();
        if(button == jbt1){
            System.out.println("jbt1");
        }else if(button == jbt2){
            System.out.println("jbt2");
        }
    }

}
