
import javax.swing.*;
import java.awt.*;


public class GUI {
    static int buttonHeight = 100;
    static int buttonSides = 10;
    static int gapHeight = 50;
    public static void mainMenu(){
        JFrame frame = new JFrame("Mini Games");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1200);
        frame.setLayout(new FlowLayout());

        JButton simonSaysButton = new JButton("Simon Says");
        JButton sliderColorsButton = new JButton("Slider Colors");
        JButton hangManButton = new JButton("HangMan");
        JButton exitButton = new JButton("Exit");

        simonSaysButton.addActionListener(e -> {
            new SimonSays().simonSays();
            System.out.println("Simon Says Selected");
        });
        sliderColorsButton.addActionListener(e -> {
            new SliderColor().sliderColor();
            System.out.println("Slider Colors Selected");
        });
        hangManButton.addActionListener(e -> {
            new HangMan();
            System.out.println("HangMan Selected");
        });

        exitButton.addActionListener(e -> {
            System.exit(0);
        });

        // simonSaysButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // simonSaysButton.setBorder(BorderFactory.createEmptyBorder(buttonHeight, buttonSides, buttonHeight, buttonSides));
        // sliderColorsButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 5));
        // sliderColorsButton.setBorder(BorderFactory.createEmptyBorder(buttonHeight, buttonSides, buttonHeight, buttonSides));
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, 1));
        panel.setPreferredSize(new Dimension(800, 1000));
        JLabel label = new JLabel("Mini Games");
        JLabel label2 = new JLabel("By Devin Baysa");

        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label2.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setFont(new Font("Serif", Font.PLAIN, 40));

        panel.add(label);
        panel.add(label2);
        panel.add(Box.createRigidArea(new Dimension(0, gapHeight)));

        frame.add(panel);

        panel.add(simonSaysButton);
        panel.add(Box.createRigidArea(new Dimension(0, gapHeight)));

        panel.add(sliderColorsButton);
        panel.add(Box.createRigidArea(new Dimension(0, gapHeight)));

        panel.add(hangManButton);
        panel.add(Box.createRigidArea(new Dimension(0, gapHeight)));

        panel.add(exitButton);
        simonSaysButton.setPreferredSize(new Dimension(150, 50));
        sliderColorsButton.setPreferredSize(new Dimension(150, 50));
        hangManButton.setPreferredSize(new Dimension(150, 50));
        exitButton.setPreferredSize(new Dimension(150, 50));
        simonSaysButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        sliderColorsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        hangManButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        exitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        simonSaysButton.add(Box.createVerticalStrut(buttonHeight));
        sliderColorsButton.add(Box.createVerticalStrut(buttonHeight));
        hangManButton.add(Box.createVerticalStrut(buttonHeight));
        exitButton.add(Box.createVerticalStrut(buttonHeight));
        


        frame.setVisible(true);
    }

    public static void main(String[] args) {
        mainMenu();
    }
}