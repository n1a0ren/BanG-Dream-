package com.game.test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestMyJFrame2 extends JFrame implements MouseListener {
    JButton jbt1 = new JButton("jbt1");
    JButton jbt2 = new JButton("jbt2");
    public TestMyJFrame2(){
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
        jbt1.addMouseListener(this);

        jbt2.setBounds(200,0,200,200);
        jbt2.addMouseListener(this);

        this.getContentPane().add(jbt1);
        this.getContentPane().add(jbt2);

        this.setVisible(true);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("Click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Press");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Release");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Enter");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Exit");
    }
}
