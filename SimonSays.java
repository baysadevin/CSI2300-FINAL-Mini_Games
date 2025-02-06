import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimonSays {
    private JFrame frame;
    private JButton startButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton redButton;
    private JButton yellowButton;
    private JButton submitButton;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private int[] sequence;
    private int[] playerSequence;
    private int sequenceLength;
    private int playerSequenceLength;
    private int score;
    private int highScore;
    private Random random;

    public SimonSays() {
        frame = new JFrame("Simon Says");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1200);
        frame.setLayout(new GridLayout(4, 2));

        startButton = new JButton("Start");
        blueButton = new JButton();
        blueButton.setBackground(Color.BLUE);
        blueButton.setOpaque(true);
        blueButton.setContentAreaFilled(true);
        blueButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        blueButton.setFocusPainted(false);

        greenButton = new JButton();
        greenButton.setOpaque(true);
        greenButton.setContentAreaFilled(true);
        greenButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        greenButton.setFocusPainted(false);
        greenButton.setBackground(Color.GREEN);

        redButton = new JButton();
        redButton.setBackground(Color.RED);
        redButton.setOpaque(true);
        redButton.setContentAreaFilled(true);
        redButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        redButton.setFocusPainted(false);

        yellowButton = new JButton();
        yellowButton.setBackground(Color.YELLOW);
        yellowButton.setOpaque(true);
        yellowButton.setContentAreaFilled(true);
        yellowButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        yellowButton.setFocusPainted(false);

        submitButton = new JButton("Submit");

        scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        highScoreLabel = new JLabel("High Score: 0", JLabel.CENTER);
        highScoreLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        frame.add(startButton);
        frame.add(new JLabel()); // Empty label for spacing
        frame.add(blueButton);
        frame.add(greenButton);
        frame.add(redButton);
        frame.add(yellowButton);
        frame.add(submitButton);
        frame.add(scoreLabel);
        frame.add(highScoreLabel);

        sequence = new int[100]; // Arbitrary large size for the sequence
        playerSequence = new int[100];
        sequenceLength = 0;
        playerSequenceLength = 0;
        score = 0;
        highScore = 0;
        random = new Random();

        startButton.addActionListener(e -> startGame());
        submitButton.addActionListener(e -> checkSequence());

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

        frame.setVisible(true);
    }

    private void startGame() {
        sequenceLength = 0;
        playerSequenceLength = 0;
        score = 0;
        scoreLabel.setText("Score: " + score);
        generateSequence();
        playSequence();
    }

    private void generateSequence() {
        sequence[sequenceLength] = random.nextInt(4);
        sequenceLength++;
    }

    private void playSequence() {
        new Thread(() -> {
            for (int i = 0; i < sequenceLength; i++) {
                switch (sequence[i]) {
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
                    Thread.sleep(1500); // Pause for 1.5 seconds between flashes to include the gap
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void colorFlash(JButton button, int duration) {
        Color originalColor = button.getBackground();
        button.setBackground(Color.WHITE);
        new Timer(duration * 500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(originalColor);
                ((Timer) e.getSource()).stop();
            }
        }).start();
    }

    private void checkSequence() {
        if (playerSequenceLength != sequenceLength) {
            JOptionPane.showMessageDialog(frame, "Game Over! You reached a sequence length of " + sequenceLength);
            if (score > highScore) {
                highScore = score;
                highScoreLabel.setText("High Score: " + highScore);
            }
            return;
        }
        for (int i = 0; i < sequenceLength; i++) {
            if (sequence[i] != playerSequence[i]) {
                if (score > highScore) {
                    highScore = score;
                    highScoreLabel.setText("High Score: " + highScore);
                }
                return;
            }
        }
        playerSequenceLength = 0;
        score++;
        scoreLabel.setText("Score: " + score);
        generateSequence();
        playSequence();
    }

    public static void main(String[] args) {
        new SimonSays();
    }
}