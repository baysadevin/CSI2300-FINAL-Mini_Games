import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SimonSays {
    private int borderThickness = 5;

    private static JButton greenButton = new JButton("Green");
    private static JButton redButton = new JButton("Red");
    private static JButton blueButton = new JButton("Blue");
    private static JButton yellowButton = new JButton("Yellow");
    private static JButton startButton = new JButton("Start");
    private static JButton submitButton = new JButton("Submit");
    private static JButton exitButton = new JButton("Exit");
    public static int playerSequenceLength = 1;
    @SuppressWarnings("unused")
    public void simonSays() {
        JFrame ssframe = new JFrame("Simon Says");
        ssframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ssframe.setSize(1000, 1200);
        ssframe.setVisible(true);
        JPanel ssPanel = new JPanel();
        ssPanel.setSize(900, 1100);


        JLabel label = new JLabel("High Score: ");
        JLabel label2 = new JLabel("Score: ");


        greenButton.setPreferredSize(new Dimension(200, 200));
        redButton.setPreferredSize(new Dimension(200, 200));
        blueButton.setPreferredSize(new Dimension(200, 200));
        yellowButton.setPreferredSize(new Dimension(200, 200));



        greenButton.setOpaque(true);
        greenButton.setContentAreaFilled(true);
        greenButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
        greenButton.setFocusPainted(false);
        redButton.setOpaque(true);
        redButton.setContentAreaFilled(true);
        redButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
        redButton.setFocusPainted(false);
        blueButton.setOpaque(true);
        blueButton.setContentAreaFilled(true);
        blueButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
        blueButton.setFocusPainted(false);
        yellowButton.setOpaque(true);
        yellowButton.setContentAreaFilled(true);
        yellowButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, borderThickness));
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

        startButton.addActionListener(e -> {
            SimonSays.gameLoop();
        });
        submitButton.addActionListener(e -> {
            System.out.println("Submit");
        });
        exitButton.addActionListener(e -> {
            ssframe.dispose();
        });
        
    }
    public static void colorFlash(JButton button , int seconds) {
            button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
            int fullSecond = seconds * 1000;
            Timer timer = new Timer(fullSecond, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
                }
            });
            timer.setRepeats(false);
            timer.start();

    }
    public static void gameLoop() {
        int[] sequence= new int[100];
        int[] playerSequence = new int[100];
        int score = 0;
        int sequenceLength = 1;
        boolean gameRunning = true;
        
        while (gameRunning) {
            for (int i = 0; i < sequenceLength; i++) {
                int random = (int) (Math.random() * 4);
                sequence[i] = random;
                System.out.println(random);
                System.out.println(sequence[i]);
                for (int item : sequence) {
                    switch (item) {
                        case 0:
                            colorFlash(greenButton, 2);
                            break;
                        case 1:
                            colorFlash(redButton, 2);
                            break;
                        case 2:
                            colorFlash(blueButton, 2);
                            break;
                        case 3:
                            colorFlash(yellowButton, 2);
                            break;
                    }
                    try {
                        Thread.sleep(2000); // Pause for 2 seconds
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                System.out.println("for loop 1");
                }
            }
        
        // Add action listeners to buttons outside of the loop
        blueButton.addActionListener(e -> {
            playerSequence[playerSequenceLength] = 2;
            playerSequenceLength++;
        });
        greenButton.addActionListener(e -> {
            playerSequence[playerSequenceLength] = 0;
            playerSequenceLength++;
        });
        redButton.addActionListener(e -> {
            playerSequence[playerSequenceLength] = 1;
            playerSequenceLength++;
        });
        yellowButton.addActionListener(e -> {
            playerSequence[playerSequenceLength] = 3;
            playerSequenceLength++;
        });

        // Wait for player input
        while (playerSequenceLength < sequenceLength) {
            // Busy wait (not ideal, but for simplicity)
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Check player sequence
        for (int j = 0; j < sequenceLength; j++) {
            if (sequence[j] != playerSequence[j]) {
                gameRunning = false;
                break;
            }
        }

        // Increase sequence length for next round
        sequenceLength++;
    }
}

public static void main(String[] args) {
    new SimonSays().simonSays();
}
}