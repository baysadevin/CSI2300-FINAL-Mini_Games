import javax.swing.*;

import java.awt.*;
public class SimonSays {
    public void simonSays() {
        JFrame ssframe = new JFrame("Simon Says");
        ssframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
        JButton exitButton = new JButton("Exit");

        JLabel label = new JLabel("High Score: ");
        JLabel label2 = new JLabel("Score: ");


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
        startButton.addActionListener(e -> {
            System.out.println("Start");
        });
        submitButton.addActionListener(e -> {
            System.out.println("Submit");
        });
        exitButton.addActionListener(e -> {
            ssframe.dispose();
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
        label.setHorizontalAlignment(JLabel.CENTER);
        label2.setHorizontalAlignment(JLabel.CENTER);
        ssPanel.add(greenButton);
        ssPanel.add(redButton);
        ssPanel.add(label);
        ssPanel.add(blueButton);
        ssPanel.add(yellowButton);
        ssPanel.add(label2);
        ssPanel.add(startButton);
        ssPanel.add(submitButton);
        ssPanel.add(exitButton);
        ssPanel.setLayout(new GridLayout(3, 3));
        ssframe.add(ssPanel);
        ssframe.setVisible(true);
    }
    public static void main(String[] args) {
        new SimonSays().simonSays();
    }
}
