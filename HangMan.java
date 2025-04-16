import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.List;

public class HangMan {
    private String word;
    private StringBuilder guessedWord;
    private int attempts;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel categoryLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JButton solveButton;
    public void hangMan() {
        SwingUtilities.invokeLater(() -> {
            JFrame categoryFrame = new JFrame("Select Category");
            categoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            categoryFrame.setSize(1000, 1200);
            categoryFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
            categoryFrame.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);

            // Add the category label
            JLabel categoryLabel = new JLabel("Select a category:", JLabel.CENTER);
            categoryLabel.setFont(new Font("Serif", Font.PLAIN, 40));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 1; // Equal vertical weight
            categoryFrame.add(categoryLabel, gbc);

            // Add the category dropdown
            String[] categories = {"Animals", "Fruits", "Countries", "Cities", "Sports", "Movies", "Books", "Music", "Food", "Colors"};
            JComboBox<String> categoryComboBox = new JComboBox<>(categories);
            categoryComboBox.setFont(new Font("Serif", Font.PLAIN, 20));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.5; // Adjust vertical weight
            categoryFrame.add(categoryComboBox, gbc);

            // Add the start button
            JButton startButton = new JButton("Start Game");
            startButton.setFont(new Font("Serif", Font.PLAIN, 40));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 1; // Equal vertical weight
            categoryFrame.add(startButton, gbc);

            startButton.addActionListener(_ -> {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                categoryFrame.dispose();
                startGame(selectedCategory);
            });

            categoryFrame.setVisible(true);
        });
    }

    private void startGame(String categoryName) {
        loadRandomWord(categoryName);
        new HashSet<>();
        attempts = 6; // Number of allowed incorrect attempts

        JFrame frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window
        frame.setLayout(new BorderLayout());

        categoryLabel = new JLabel("Category: " + categoryName, JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        wordLabel = new JLabel("Word: " + guessedWord.toString(), JLabel.CENTER);
        wordLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        attemptsLabel = new JLabel("Attempts left: " + attempts, JLabel.CENTER);
        attemptsLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        guessField = new JTextField(10);
        guessField.setFont(new Font("Serif", Font.PLAIN, 30));

        // Add ActionListener to allow pressing "Enter" to submit the guess
        guessField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = guessField.getText().trim().toLowerCase();
                if (input.length() == 1) {
                    guessButton.doClick(); // Simulate a button click on the "Guess Letter" button
                } else if (input.length() > 1) {
                    solveButton.doClick(); // Simulate a button click on the "Solve Word" button
                }
            }
        });

        guessButton = new JButton("Guess Letter");
        guessButton.setFont(new Font("Serif", Font.PLAIN, 30));
        solveButton = new JButton("Solve Word");
        solveButton.setFont(new Font("Serif", Font.PLAIN, 30));

        // Add components to the frame
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Enter a letter or word: ", JLabel.CENTER));
        inputPanel.add(guessField);
        inputPanel.add(guessButton);
        inputPanel.add(solveButton);

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(categoryLabel);
        topPanel.add(attemptsLabel);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(wordLabel, BorderLayout.CENTER);
        frame.add(inputPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private void loadRandomWord(String categoryName) {
        List<String> words = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("Hangman_Categories/Hangman_" + categoryName + ".txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim());
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(1);
        }

        if (words.isEmpty()) {
            System.err.println("No words found in the file.");
            System.exit(1);
        }

        Random random = new Random();
        word = words.get(random.nextInt(words.size())).toLowerCase();

        // Initialize guessedWord with underscores and automatically fill spaces
        guessedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == ' ') {
                guessedWord.append("  "); // Add a space for spaces in the word
            } else {
                guessedWord.append("_ ");
            }
        }
    }

    public static void main(String[] args) {
        HangMan game = new HangMan();
        game.hangMan();
    }
}