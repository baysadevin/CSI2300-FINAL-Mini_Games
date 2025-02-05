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
    private Set<Character> guessedLetters;
    private int attempts;
    private JLabel wordLabel;
    private JLabel attemptsLabel;
    private JLabel categoryLabel;
    private JTextField guessField;
    private JButton guessButton;
    private JButton solveButton;

    public void hangMan(String categoryName) {
        loadRandomWord(categoryName);
        guessedWord = new StringBuilder("_ ".repeat(word.length()));
        guessedLetters = new HashSet<>();
        attempts = 6; // Number of allowed incorrect attempts

        JFrame frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1200);
        frame.setLayout(new BorderLayout());

        categoryLabel = new JLabel("Category: " + categoryName, JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        wordLabel = new JLabel("Word: " + guessedWord.toString(), JLabel.CENTER);
        wordLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        attemptsLabel = new JLabel("Attempts left: " + attempts, JLabel.CENTER);
        attemptsLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        guessField = new JTextField(10);
        guessField.setFont(new Font("Serif", Font.PLAIN, 30));
        guessButton = new JButton("Guess Letter");
        guessButton.setFont(new Font("Serif", Font.PLAIN, 30));
        solveButton = new JButton("Solve Word");
        solveButton.setFont(new Font("Serif", Font.PLAIN, 30));

        guessButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = guessField.getText().toLowerCase();
                if (input.length() != 1) {
                    JOptionPane.showMessageDialog(frame, "Please enter a single letter.");
                    return;
                }
                char guess = input.charAt(0);
                if (guessedLetters.contains(guess)) {
                    JOptionPane.showMessageDialog(frame, "You already guessed that letter.");
                    return;
                }

                guessedLetters.add(guess);

                if (word.contains(String.valueOf(guess))) {
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            guessedWord.setCharAt(i * 2, guess);
                        }
                    }
                } else {
                    attempts--;
                }

                wordLabel.setText("Word: " + guessedWord.toString());
                attemptsLabel.setText("Attempts left: " + attempts);
                guessField.setText("");
                
                if (guessedWord.toString().replace(" ", "").equals(word)) {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the word: " + word);
                    resetGame(categoryName);
                } else if (attempts == 0) {
                    JOptionPane.showMessageDialog(frame, "Game over. The word was: " + word);
                    resetGame(categoryName);
                }
            }
        });

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = guessField.getText().toLowerCase();
                if (input.equals(word)) {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the word: " + word);
                    resetGame(categoryName);
                } else {
                    attempts--;
                    attemptsLabel.setText("Attempts left: " + attempts);
                    guessField.setText("");
                    if (attempts == 0) {
                        JOptionPane.showMessageDialog(frame, "Game over. The word was: " + word);
                        resetGame(categoryName);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Incorrect guess. Try again.");
                    }
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Enter a letter or word: ", JLabel.CENTER));
        inputPanel.add(guessField);
        inputPanel.add(guessButton);
        inputPanel.add(solveButton);

        frame.add(categoryLabel, BorderLayout.NORTH);
        frame.add(wordLabel, BorderLayout.CENTER);
        frame.add(attemptsLabel, BorderLayout.SOUTH);
        frame.add(inputPanel, BorderLayout.SOUTH);
        frame.add(attemptsLabel, BorderLayout.NORTH);
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
    }

    private void resetGame(String categoryName) {
        loadRandomWord(categoryName);
        guessedWord = new StringBuilder("_ ".repeat(word.length()));
        guessedLetters = new HashSet<>();
        attempts = 6;
        wordLabel.setText("Word: " + guessedWord.toString());
        attemptsLabel.setText("Attempts left: " + attempts);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame categoryFrame = new JFrame("Select Category");
            categoryFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            categoryFrame.setSize(1000, 1200);
            categoryFrame.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);

            JLabel categoryLabel = new JLabel("Select a category:", JLabel.CENTER);
            categoryLabel.setFont(new Font("Serif", Font.PLAIN, 40));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.1;
            categoryFrame.add(categoryLabel, gbc);

            String[] categories = {"Animals", "Fruits", "Countries", "Cities", "Sports", "Movies", "Books", "Music", "Food", "Colors"};
            JComboBox<String> categoryComboBox = new JComboBox<>(categories);
            categoryComboBox.setFont(new Font("Serif", Font.PLAIN, 30));
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.8;
            categoryFrame.add(categoryComboBox, gbc);

            JButton startButton = new JButton("Start Game");
            startButton.setFont(new Font("Serif", Font.PLAIN, 40));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.1;
            categoryFrame.add(startButton, gbc);

            startButton.addActionListener(e -> {
                String selectedCategory = (String) categoryComboBox.getSelectedItem();
                categoryFrame.dispose();
                HangMan game = new HangMan();
                game.hangMan(selectedCategory);
            });

            categoryFrame.setVisible(true);
        });
    }
}