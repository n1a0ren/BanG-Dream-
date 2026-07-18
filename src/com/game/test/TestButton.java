package com.game.test;

import com.game.Characters;
import com.game.ui.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestButton extends JFrame implements ActionListener {

    public TestButton(){
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

        //JLabel jLabel = new JLabel(Characters.Ako);
        //jLabel.setBounds(0, 0, 80, 80);

        JButton jbt = new JButton(Characters.Ako);
        jbt.setBounds(0,0,80,80);
        jbt.setBackground(Color.white);
        jbt.addActionListener(this);
        this.getContentPane().add(jbt);

        this.setVisible(true);
    }




    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
