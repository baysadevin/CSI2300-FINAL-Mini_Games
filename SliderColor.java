import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import java.util.Random;

public class SliderColor {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Slider Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1200);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        frame.add(panel);

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

        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);

        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);

        // Create a label that changes color
        JLabel changingLabel = new JLabel("Color Label", JLabel.CENTER);
        changingLabel.setOpaque(true);
        changingLabel.setBackground(Color.BLACK);

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

        // Add the sliders, labels, and button to the frame
        panel.setLayout(new GridLayout(9, 1));
        panel.add(redLabel);
        panel.add(redSlider);
        panel.add(greenLabel);
        panel.add(greenSlider);
        panel.add(blueLabel);
        panel.add(blueSlider);
        panel.add(changingLabel);
        panel.add(randomColorLabel);
        panel.add(submitButton);
        panel.add(resultLabel);

        panel.setVisible(true);
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
}