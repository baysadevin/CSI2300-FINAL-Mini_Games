import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;
import javax.swing.*;

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
            categoryFrame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
            categoryFrame.setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.insets = new Insets(10, 10, 10, 10);

            
            JLabel categoryLabel = new JLabel("Select a category:", JLabel.CENTER);
            categoryLabel.setFont(new Font("Serif", Font.PLAIN, 50));
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.1; 
            categoryFrame.add(categoryLabel, gbc);

          
            JPanel radioPanel = new JPanel();
            radioPanel.setLayout(new GridLayout(0, 1, 10, 10)); 

            
            String[] categories = {"Animals", "Fruits", "Countries", "Cities", "Sports", "Movies", "Books", "Music", "Food", "Colors"};
            ButtonGroup group = new ButtonGroup();
            for (String category : categories) {
                JRadioButton radioButton = new JRadioButton(category);
                radioButton.setFont(new Font("Serif", Font.PLAIN, 40));
                group.add(radioButton);
                radioPanel.add(radioButton);
            }

            
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.7; 
            categoryFrame.add(radioPanel, gbc);

            
            JButton startButton = new JButton("Start Game");
            startButton.setFont(new Font("Serif", Font.PLAIN, 40));
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 2;
            gbc.weightx = 1;
            gbc.weighty = 0.2; 
            categoryFrame.add(startButton, gbc);

            
            startButton.addActionListener(_ -> {
                for (Component comp : radioPanel.getComponents()) {
                    if (comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
                        String selectedCategory = ((JRadioButton) comp).getText();
                        categoryFrame.dispose();
                        startGame(selectedCategory);
                        return;
                    }
                }
                JOptionPane.showMessageDialog(categoryFrame, "Please select a category.");
            });

            categoryFrame.setVisible(true);
        });
    }

    private void startGame(String categoryName) {
        loadRandomWord(categoryName);
        attempts = 6; 

        JFrame frame = new JFrame("Hangman Game");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new BorderLayout());

        categoryLabel = new JLabel("Category: " + categoryName, JLabel.CENTER);
        categoryLabel.setFont(new Font("Serif", Font.PLAIN, 30));
        wordLabel = new JLabel("Word: " + guessedWord.toString(), JLabel.CENTER);
        wordLabel.setFont(new Font("Serif", Font.PLAIN, 40));
        attemptsLabel = new JLabel("Attempts left: " + attempts, JLabel.CENTER);
        attemptsLabel.setFont(new Font("Serif", Font.PLAIN, 30));

        guessField = new JTextField(10);
        guessField.setFont(new Font("Serif", Font.PLAIN, 30));

       
        guessField.addActionListener(e -> {
            String input = guessField.getText().trim().toLowerCase();
            if (input.length() == 1) {
                guessButton.doClick();
            } else if (input.length() > 1) {
                solveButton.doClick(); 
            }
        });

        guessButton = new JButton("Guess Letter");
        guessButton.setFont(new Font("Serif", Font.PLAIN, 30));
        guessButton.addActionListener(e -> {
            String input = guessField.getText().trim().toLowerCase();
            guessField.setText(""); 

            if (input.length() != 1) {
                JOptionPane.showMessageDialog(frame, "Please enter a single letter.");
                return;
            }

            char guessedLetter = input.charAt(0);
            boolean correctGuess = false;

            
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guessedLetter) {
                    guessedWord.setCharAt(i * 2, guessedLetter);
                    correctGuess = true;
                }
            }

            if (correctGuess) {
                wordLabel.setText("Word: " + guessedWord.toString());
                if (!guessedWord.toString().contains("_")) {
                    JOptionPane.showMessageDialog(frame, "Congratulations! You guessed the word!");
                    restartGame(frame, categoryName); 
                }
            } else {
                attempts--; 
                attemptsLabel.setText("Attempts left: " + attempts);

                if (attempts == 0) {
                    JOptionPane.showMessageDialog(frame, "Game Over! The word was: " + word);
                    restartGame(frame, categoryName); 
                }
            }
        });

        solveButton = new JButton("Solve Word");
        solveButton.setFont(new Font("Serif", Font.PLAIN, 30));
        solveButton.addActionListener(e -> {
            String input = guessField.getText().trim().toLowerCase();
            guessField.setText(""); 

            if (input.equals(word)) {
                wordLabel.setText("Word: " + word.replace("", " ").trim()); // Reveal the full word
                JOptionPane.showMessageDialog(frame, "Congratulations! You solved the word!");
                restartGame(frame, categoryName); 
            } else {
                attempts--; 
                attemptsLabel.setText("Attempts left: " + attempts);

                if (attempts == 0) {
                    JOptionPane.showMessageDialog(frame, "Game Over! The word was: " + word);
                    restartGame(frame, categoryName); 
                }
            }
        });

        JPanel topPanel = new JPanel(new GridLayout(2, 1));
        topPanel.add(categoryLabel);
        topPanel.add(attemptsLabel);

       
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 1, 10, 10));

    
        JPanel inputFieldPanel = new JPanel();
        inputFieldPanel.setLayout(new BorderLayout());
        inputFieldPanel.add(new JLabel("Enter a letter or word: ", JLabel.CENTER), BorderLayout.WEST);
        inputFieldPanel.add(guessField, BorderLayout.CENTER);

        
        JPanel actionButtonsPanel = new JPanel();
        actionButtonsPanel.setLayout(new GridLayout(1, 2, 10, 10)); 
        actionButtonsPanel.add(guessButton);
        actionButtonsPanel.add(solveButton);

        
        JButton returnButton = new JButton("Return to Categories");
        returnButton.setFont(new Font("Serif", Font.BOLD, 40));
        returnButton.addActionListener(e -> {
            frame.dispose(); 
            hangMan(); 
        });

        bottomPanel.add(inputFieldPanel); 
        bottomPanel.add(actionButtonsPanel); 
        bottomPanel.add(returnButton); 

        
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(wordLabel, BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.PAGE_END); 

        frame.setVisible(true);
    }

    private void restartGame(JFrame frame, String categoryName) {
        frame.dispose(); 
        startGame(categoryName); 
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

        
        guessedWord = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (c == ' ') {
                guessedWord.append("  "); 
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