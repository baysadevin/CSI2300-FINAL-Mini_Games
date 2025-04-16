import java.awt.*;
import javax.swing.*;

public class GUI {

    @SuppressWarnings("unused")
    public static void mainMenu() {
        JFrame frame = new JFrame("Mini Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Maximize the window to take up the entire screen
        frame.setLayout(new BorderLayout());

        // Create a panel for the buttons with GridLayout
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 20, 20)); // 4 rows, 1 column, with 20px gaps

        // Create buttons
        JButton simonSaysButton = new JButton("Simon Says");
        JButton sliderColorsButton = new JButton("Slider Colors");
        JButton hangManButton = new JButton("HangMan");
        JButton exitButton = new JButton("Exit");

        // Set font size for buttons to make them larger
        Font buttonFont = new Font("Serif", Font.BOLD, 40);
        simonSaysButton.setFont(buttonFont);
        sliderColorsButton.setFont(buttonFont);
        hangManButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

        // Add buttons to the panel
        buttonPanel.add(simonSaysButton);
        buttonPanel.add(sliderColorsButton);
        buttonPanel.add(hangManButton);
        buttonPanel.add(exitButton);

        // Add action listeners for buttons
        simonSaysButton.addActionListener(e -> {
            SimonSays game = new SimonSays();
        });
        sliderColorsButton.addActionListener(e -> {
            SliderColor.sliderColor(); // Launch the SliderColor GUI
            System.out.println("Slider Colors Selected");
        });
        hangManButton.addActionListener(e -> {
            HangMan hangMan = new HangMan();
            hangMan.hangMan(); // This starts the Hangman game
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // Add a title label at the top
        JLabel titleLabel = new JLabel("Mini Games", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 60)); // Larger font for the title
        frame.add(titleLabel, BorderLayout.NORTH);

        // Add the button panel to the center of the frame
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}