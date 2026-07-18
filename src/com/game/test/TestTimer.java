package com.game.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestTimer {
    private static JLabel timeLabel;
    private static Timer timer;
    private static long startTime = 0;   // 记录开始时间（毫秒）
    private static boolean isRunning = false;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing 计时器");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // 时间显示标签
        timeLabel = new JLabel("00:00:00", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));

        // 按钮面板
        JButton startButton = new JButton("开始");
        JButton pauseButton = new JButton("暂停");
        JButton resetButton = new JButton("重置");

        // 初始化计时器（每隔 100ms 更新一次）
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long elapsed = System.currentTimeMillis() - startTime;
                updateTimeLabel(elapsed);
            }
        });

        // 绑定按钮事件
        startButton.addActionListener(e -> {
            if (!isRunning) {
                startTime = System.currentTimeMillis() - (startTime > 0 ? startTime : 0);
                timer.start();
                isRunning = true;
            }
        });

        pauseButton.addActionListener(e -> {
            timer.stop();
            isRunning = false;
        });

        resetButton.addActionListener(e -> {
            timer.stop();
            startTime = 0;
            isRunning = false;
            updateTimeLabel(0);
        });

        // 布局
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(pauseButton);
        buttonPanel.add(resetButton);

        frame.setLayout(new BorderLayout());
        frame.add(timeLabel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    // 更新时间标签（格式化为 HH:MM:SS）
    private static void updateTimeLabel(long elapsedMillis) {
        long hours = elapsedMillis / 3600000;
        long minutes = (elapsedMillis % 3600000) / 60000;
        long seconds = (elapsedMillis % 60000) / 1000;
        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timeLabel.setText(time);
    }
}
