import javax.swing.*;

import java.awt.*;
public class SimonSays {
    public void simonSays() {
        JFrame ssframe = new JFrame("Simon Says");
        ssframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ssframe.setSize(1000, 1200);
        ssframe.setVisible(true);
        JPanel ssPanel = new JPanel();
        ssPanel.setSize(900, 1100);
        JButton greenButton = new JButton("Green");
        JButton redButton = new JButton("Red");
        JButton blueButton = new JButton("Blue");
        JButton yellowButton = new JButton("Yellow");
        JButton startButton = new JButton("Start");
        JButton submitButton = new JButton("Submit");
        JButton resetButton = new JButton("Reset");

        greenButton.setPreferredSize(new Dimension(200, 200));
        redButton.setPreferredSize(new Dimension(200, 200));
        blueButton.setPreferredSize(new Dimension(200, 200));
        yellowButton.setPreferredSize(new Dimension(200, 200));

        greenButton.addActionListener(e -> {
            System.out.println("Green");
        });
        redButton.addActionListener(e -> {
            System.out.println("Red");
        });
        blueButton.addActionListener(e -> {
            System.out.println("Blue");
        });
        yellowButton.addActionListener(e -> {
            System.out.println("Yellow");
        });

        greenButton.setOpaque(true);
        greenButton.setContentAreaFilled(true);
        greenButton.setBorderPainted(false);
        greenButton.setFocusPainted(false);
        redButton.setOpaque(true);
        redButton.setContentAreaFilled(true);
        redButton.setBorderPainted(false);
        redButton.setFocusPainted(false);
        blueButton.setOpaque(true);
        blueButton.setContentAreaFilled(true);
        blueButton.setBorderPainted(false);
        blueButton.setFocusPainted(false);
        yellowButton.setOpaque(true);
        yellowButton.setContentAreaFilled(true);
        yellowButton.setBorderPainted(false);
        yellowButton.setFocusPainted(false);
        greenButton.setBackground(Color.GREEN);
        greenButton.setForeground(Color.BLACK);
        redButton.setBackground(Color.RED);
        redButton.setForeground(Color.WHITE);
        blueButton.setBackground(Color.BLUE);
        blueButton.setForeground(Color.WHITE);
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setForeground(Color.BLACK);
        ssPanel.add(greenButton);
        ssPanel.add(redButton);
        ssPanel.add(blueButton);
        ssPanel.add(yellowButton);
        ssPanel.add(startButton);
        ssPanel.add(resetButton);
        ssPanel.setLayout(new GridLayout(3, 2));
        ssframe.add(ssPanel);
    }
}
