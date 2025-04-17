import java.awt.*;
import javax.swing.*;

public class GUI {

    @SuppressWarnings("unused")
    public static void mainMenu() {
        JFrame frame = new JFrame("Mini Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new BorderLayout());

       
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 1, 20, 20)); 

        
        JButton simonSaysButton = new JButton("Simon Says");
        JButton sliderColorsButton = new JButton("Slider Colors");
        JButton hangManButton = new JButton("HangMan");
        JButton exitButton = new JButton("Exit");

        
        Font buttonFont = new Font("Serif", Font.BOLD, 40);
        simonSaysButton.setFont(buttonFont);
        sliderColorsButton.setFont(buttonFont);
        hangManButton.setFont(buttonFont);
        exitButton.setFont(buttonFont);

       
        buttonPanel.add(simonSaysButton);
        buttonPanel.add(sliderColorsButton);
        buttonPanel.add(hangManButton);
        buttonPanel.add(exitButton);

        
        simonSaysButton.addActionListener(e -> {
            SimonSays game = new SimonSays();
        });
        sliderColorsButton.addActionListener(e -> {
            SliderColor.sliderColor(); 
            System.out.println("Slider Colors Selected");
        });
        hangManButton.addActionListener(e -> {
            HangMan hangMan = new HangMan();
            hangMan.hangMan(); 
        });
        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        JLabel titleLabel = new JLabel("Mini Games", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 60));
        frame.add(titleLabel, BorderLayout.NORTH);

        
        frame.add(buttonPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}