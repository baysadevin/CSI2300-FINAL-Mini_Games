import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class SimonSays {
    private final JFrame frame;
    private final JButton startButton;
    private final JButton submitButton;
    private JButton blueButton;
    private JButton greenButton;
    private JButton redButton;
    private JButton yellowButton;
    private final JLabel scoreLabel;
    private final JLabel highScoreLabel;
    private final int[] sequence;
    private final int[] playerSequence;
    private int sequenceLength;
    private int playerSequenceLength;
    private int score;
    private int highScore;
    private final Random random;

    public SimonSays() {
        frame = new JFrame("Simon Says");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window to take up the entire screen
        frame.setLayout(new BorderLayout());

        // Create a panel for the 2x2 grid of color buttons
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(2, 2, 20, 20)); // 2x2 grid with gaps between buttons
        colorPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Add padding around the grid

        // Initialize color buttons with reduced size
        greenButton = createColorButton(Color.GREEN);
        redButton = createColorButton(Color.RED);
        blueButton = createColorButton(Color.BLUE);
        yellowButton = createColorButton(Color.YELLOW);

        // Add buttons to the grid
        colorPanel.add(greenButton);
        colorPanel.add(redButton);
        colorPanel.add(blueButton);
        colorPanel.add(yellowButton);

        // Create a panel for the controls (start button, score, high score, submit button)
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(1, 4, 20, 20)); // Horizontal layout for controls

        startButton = new JButton("Start");
        startButton.setFont(new Font("Serif", Font.BOLD, 30));

        submitButton = new JButton("Submit");
        submitButton.setFont(new Font("Serif", Font.BOLD, 30));

        scoreLabel = new JLabel("Score: 0", JLabel.CENTER);
        scoreLabel.setFont(new Font("Serif", Font.BOLD, 30));

        highScoreLabel = new JLabel("High Score: 0", JLabel.CENTER);
        highScoreLabel.setFont(new Font("Serif", Font.BOLD, 30));

        controlPanel.add(startButton);
        controlPanel.add(submitButton);
        controlPanel.add(scoreLabel);
        controlPanel.add(highScoreLabel);

        // Add panels to the frame
        frame.add(colorPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);

        // Initialize game variables
        sequence = new int[100]; // Arbitrary large size for the sequence
        playerSequence = new int[100];
        sequenceLength = 0;
        playerSequenceLength = 0;
        score = 0;
        highScore = 0;
        random = new Random();

        // Add action listeners
        startButton.addActionListener(_ -> startGame());
        submitButton.addActionListener(_ -> checkSequence());
        greenButton.addActionListener(_ -> handleButtonClick(0, greenButton));
        redButton.addActionListener(_ -> handleButtonClick(1, redButton));
        blueButton.addActionListener(_ -> handleButtonClick(2, blueButton));
        yellowButton.addActionListener(_ -> handleButtonClick(3, yellowButton));

        frame.setVisible(true);
    }

    private JButton createColorButton(Color color) {
        JButton button = new JButton();
        button.setBackground(color);
        button.setOpaque(true);
        button.setContentAreaFilled(true);
        button.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        button.setFocusPainted(false);
        button.setPreferredSize(new Dimension(200, 200)); // Reduced size by 100 pixels
        return button;
    }

    private void handleButtonClick(int colorIndex, JButton button) {
        // Add the color to the player's sequence
        playerSequence[playerSequenceLength] = colorIndex;
        playerSequenceLength++;

        // Provide a visual indication of the button click
        Color originalColor = button.getBackground();
        button.setBackground(Color.WHITE);
        new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(originalColor);
                ((Timer) e.getSource()).stop();
            }
        }).start();
    }

    void startGame() {
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
                        colorFlash(greenButton, 500); // Flash duration in milliseconds
                        break;
                    case 1:
                        colorFlash(redButton, 500);
                        break;
                    case 2:
                        colorFlash(blueButton, 500);
                        break;
                    case 3:
                        colorFlash(yellowButton, 500);
                        break;
                }
                try {
                    Thread.sleep(1000); // Delay between flashes
                } catch (InterruptedException e) {
                }
            }
            // Reset player sequence length after the sequence is played
            playerSequenceLength = 0;
        }).start();
    }

    private void colorFlash(JButton button, int duration) {
        Color originalColor = button.getBackground();
        button.setBackground(Color.WHITE); // Flash to white
        new Timer(duration, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setBackground(originalColor); // Reset to original color
                ((Timer) e.getSource()).stop();
            }
        }).start();
    }

    private void checkSequence() {
        boolean correct = true;
        for (int i = 0; i < playerSequenceLength; i++) {
            if (playerSequence[i] != sequence[i]) {
                correct = false;
                break;
            }
        }

        if (correct && playerSequenceLength == sequenceLength) {
            score++;
            highScore = Math.max(highScore, score);
            scoreLabel.setText("Score: " + score);
            highScoreLabel.setText("High Score: " + highScore);
            generateSequence();
            playSequence();
        } else if (!correct) {
            JOptionPane.showMessageDialog(frame, "Incorrect sequence! Game over.");
            startGame();
        }
    }

    public static void main(String[] args) {
        new SimonSays();
    }
}