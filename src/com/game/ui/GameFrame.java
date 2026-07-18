package com.game.ui;

import com.game.Characters;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class GameFrame extends JFrame implements ItemListener, ActionListener {
    public GameFrame() {
        //initialing the frame
        initFrame();

        //initialing the menu
        initHelpMenu();

        //initialing the image
        initContentPane();

        //Showing the window
        this.setVisible(true);
    }

    private void initFrame() {
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
    }

    private void initContentPane() {
        //Disrupting the image sorting
        disruptImage();

        //Creating JButton and adding image into it
        initButton();

        initTimer();
    }

    private void initHelpMenu() {
        //Creating menu bar
        JMenuBar jMenuBar = new JMenuBar();

        //Creating menu
        JMenu jMenu = new JMenu("Tips");
        JMenu jMenu1 = new JMenu("Help");


        //Creating menu elements
        JMenuItem jMenuItem = new JMenuItem("Restart");
        jMenuItem.addActionListener(this);
        JMenuItem jMenuItem1 = new JMenuItem("Logout");
        JMenuItem jMenuItem2 = new JMenuItem("Exit");

        JMenuItem jMenuItem3 = new JMenuItem("Contact Us");

        //Adding elements into menus
        jMenu.add(jMenuItem);
        jMenu.add(jMenuItem1);
        jMenu.add(jMenuItem2);

        jMenu1.add(jMenuItem3);

        //Adding menu into menu bar
        jMenuBar.add(jMenu);
        jMenuBar.add(jMenu1);

        //Adding menu bar into window
        this.setJMenuBar(jMenuBar);
    }

    private void initButton() {
        //Creating the button
        for (int i = 0; i < Characters._BangDream.size(); i++) {
            for (int j = 0; j < Characters._BangDream.get(i).size(); j++) {
                JToggleButton jbt = new JToggleButton(Characters._BangDream.get(i).get(j));
                jbt.setBackground(Color.white);
                jbt.setBounds(100 * j, 100 * i, 80, 80);
                jbt.addItemListener(this);
                this.getContentPane().add(jbt);
            }
        }

        for(int i = 0; i < Characters.bands.size(); i++){
            JLabel jLabel = new JLabel(Characters.bands.get(i));
            jLabel.setBounds(500, 100*i, 300, 100);
            this.getContentPane().add(jLabel);
        }
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        JToggleButton button = (JToggleButton) e.getSource();
        if (e.getStateChange() == ItemEvent.SELECTED) {
            handleButtonSelected(button);
        } else {
            handleButtonDeselected(button);
        }
    }

    ArrayList<JToggleButton> alljtb = new ArrayList<>();

    private static void collectAllJTB(Container container, ArrayList<JToggleButton> jtb) {
        for (Component comp : container.getComponents()) {
            if (comp instanceof JToggleButton) {
                jtb.add((JToggleButton) comp);
            } else if (comp instanceof Container) {
                collectAllJTB((Container) comp, jtb);
            }
        }
    }

    private void checkVictory() {
        ArrayList<JToggleButton> jtb = new ArrayList<>(); //所有JTB容器
        collectAllJTB(this.getContentPane(), jtb); //获取所有JTB
        ArrayList<Icon> row1 = new ArrayList<>(); //每一行的Icon容器
        ArrayList<Icon> row2 = new ArrayList<>();
        ArrayList<Icon> row3 = new ArrayList<>();
        ArrayList<Icon> row4 = new ArrayList<>();
        ArrayList<Icon> row5 = new ArrayList<>();
        ArrayList<Icon> row6 = new ArrayList<>();
        ArrayList<Icon> row7 = new ArrayList<>();
        for (JToggleButton button : jtb) {
            switch (button.getY()) { //获取每一行的Icon并添加进对应容器
                case 0:
                    row1.add(button.getIcon());
                    break;
                case 100:
                    row2.add(button.getIcon());
                    break;
                case 200:
                    row3.add(button.getIcon());
                    break;
                case 300:
                    row4.add(button.getIcon());
                    break;
                case 400:
                    row5.add(button.getIcon());
                    break;
                case 500:
                    row6.add(button.getIcon());
                    break;
                case 600:
                    row7.add(button.getIcon());
                    break;
                default:
                    break;
            }
        }
        ArrayList<ArrayList<Icon>> temp = new ArrayList<>(List.of(row1, row2, row3, row4, row5, row6, row7));
        for (int j = 0; j < temp.size(); j++) {
            boolean c = true;
            for (int i = 0; i < temp.get(i).size(); i++) {
                if (!Characters.BangDream.get(j).contains(temp.get(j).get(i))) {
                    c = false;
                }
            }
            if (c == true) {
                System.out.println("You Win!");
                for (JToggleButton button : jtb) {
                    if (button.getY() == j * 100) {
                        button.setBackground(Color.green);
                        button.setEnabled(false);
                        button.setDisabledIcon(button.getIcon());
                    }
                }
            }
        }
    }

    private final ArrayList<JToggleButton> selectedButtons = new ArrayList<>();

    private void handleButtonSelected(JToggleButton button) {
        if (!selectedButtons.contains(button)) {
            selectedButtons.add(button);
        }

        if (selectedButtons.size() == 2) {
            swapIconsAndReset();
            checkVictory();
        }
    }

    private void handleButtonDeselected(JToggleButton button) {
        if (selectedButtons.contains(button)) {
            selectedButtons.remove(button);
        }
    }

    private void swapIconsAndReset() {
        JToggleButton firstButton = selectedButtons.get(0);
        JToggleButton secondButton = selectedButtons.get(1);

        // 检查是否是同一个按钮
        if (firstButton == secondButton) {
            firstButton.setSelected(false);
            selectedButtons.clear();
            return;
        }

        // 交换图标
        Icon firstIcon = firstButton.getIcon();
        Icon secondIcon = secondButton.getIcon();
        firstButton.setIcon(secondIcon);
        secondButton.setIcon(firstIcon);

        // 重置按钮状态
        firstButton.setSelected(false);
        secondButton.setSelected(false);
        selectedButtons.clear();
    }

    private void disruptImage() {
        Random random = new Random();
        for (int i = 0; i < Characters._BangDream.size(); i++) {
            for (int j = 0; j < Characters._BangDream.get(i).size(); j++) {
                int row = random.nextInt(Characters._BangDream.size());
                int column = random.nextInt(Characters._BangDream.get(i).size());
                ImageIcon temp = Characters._BangDream.get(i).get(j);
                Characters._BangDream.get(i).set(j, Characters._BangDream.get(row).get(column));
                Characters._BangDream.get(row).set(column, temp);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        disruptImage();

        ArrayList<Icon> temp = new ArrayList<>();
        for (int i = 0; i < Characters._BangDream.size(); i++) {
            for (int j = 0; j < Characters._BangDream.get(i).size(); j++) {
                temp.add(Characters._BangDream.get(i).get(j));
            }
        }


        ArrayList<JToggleButton> jtb = new ArrayList<>();
        collectAllJTB(this.getContentPane(), jtb);
        for (int i = 0; i < jtb.size(); i++) {
            jtb.get(i).setEnabled(true);
            jtb.get(i).setBackground(Color.white);
            jtb.get(i).setIcon(temp.get(i));
        }
    }
    private void initTimer() {
        long hours = System.currentTimeMillis() / 3600000;
        long minutes = (System.currentTimeMillis() % 3600000) / 60000;
        long seconds = (System.currentTimeMillis() % 60000) / 1000;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        JLabel timeLabel = new JLabel("00:00:00");
        timeLabel.setText(time);
        timeLabel.setBounds(0, 700, 300,200);
        this.getContentPane().add(timeLabel);
    }
}
