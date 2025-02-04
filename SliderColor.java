import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

public class SliderColor {

    public static void sliderColor() {
        JFrame frame = new JFrame("Slider Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1000, 1200);
        frame.getContentPane().setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setSize(900, 1100);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        Border border = BorderFactory.createLineBorder(Color.BLACK, 5);
        panel.setBorder(border);
        // Create labels for the sliders
        JLabel redLabel = new JLabel("Red", JLabel.CENTER);
        JLabel greenLabel = new JLabel("Green", JLabel.CENTER);
        JLabel blueLabel = new JLabel("Blue", JLabel.CENTER);
        

        // Create sliders for red, green, and blue
        JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);
        JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 0);

        redSlider.setMajorTickSpacing(50);
        redSlider.setMinorTickSpacing(10);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        redSlider.setBorder(border);

        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        greenSlider.setBorder(border);

        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        blueSlider.setBorder(border);

        // Create a label that changes color
        JLabel changingLabel = new JLabel("Color Label", JLabel.CENTER);
        changingLabel.setOpaque(true);
        changingLabel.setBackground(Color.BLACK);
        changingLabel.setBorder(border);

        // Create a label with a random color
        JLabel randomColorLabel = new JLabel("Random Color Label", JLabel.CENTER);
        randomColorLabel.setOpaque(true);
        Random rand = new Random();
        int red = rand.nextInt(256);
        int green = rand.nextInt(256);
        int blue = rand.nextInt(256);
        
        
        Color randomColor = new Color(red, green, blue);
        System.out.println(red + " " + green + " " + blue);
        
        randomColorLabel.setBackground(randomColor);
        randomColorLabel.setBorder(border);

        // Add a ChangeListener to the sliders
        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                int green = greenSlider.getValue();
                int blue = blueSlider.getValue();
                Color color = new Color(red, green, blue);
                changingLabel.setBackground(color);
            }
        };

        redSlider.addChangeListener(changeListener);
        greenSlider.addChangeListener(changeListener);
        blueSlider.addChangeListener(changeListener);

        // Create a submit button
        JButton submitButton = new JButton("Submit");
        JLabel resultLabel = new JLabel("Similarity: ", JLabel.CENTER);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Color color1 = changingLabel.getBackground();
                Color color2 = randomColorLabel.getBackground();
                double similarity = calculateColorSimilarity(color1, color2);
                resultLabel.setText(String.format("Similarity: %.2f%%", similarity * 100));

                // Generate a new random color for the randomColorLabel
                Color newRandomColor = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
                randomColorLabel.setBackground(newRandomColor);

            }
        });

        // Add the sliders, labels, and button to the  panel
        panel.setLayout(new GridLayout(5, 2));
        panel.add(redLabel);
        redLabel.setBorder(border);
        panel.add(redSlider);
        panel.add(greenLabel);
        greenLabel.setBorder(border);
        panel.add(greenSlider);
        panel.add(blueLabel);
        blueLabel.setBorder(border);
        panel.add(blueSlider);
        panel.add(randomColorLabel);
        panel.add(changingLabel);
        panel.add(submitButton);
        submitButton.setBorder(border);
        panel.add(resultLabel);
        resultLabel.setBorder(border);
        

        frame.add(panel);        
        frame.setVisible(true);
    }

    private static double calculateColorSimilarity(Color color1, Color color2) {
        int red1 = color1.getRed();
        int green1 = color1.getGreen();
        int blue1 = color1.getBlue();
        int red2 = color2.getRed();
        int green2 = color2.getGreen();
        int blue2 = color2.getBlue();
        

        double distance = Math.sqrt(Math.pow(red1 - red2, 2) + Math.pow(green1 - green2, 2) + Math.pow(blue1 - blue2, 2));
        double maxDistance = Math.sqrt(Math.pow(255, 2) * 3);

        return 1 - (distance / maxDistance);
    }
    static void main(String[] args) {
        sliderColor();
    }
}