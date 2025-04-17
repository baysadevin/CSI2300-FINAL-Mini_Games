import java.awt.*;
import java.util.Random;
import javax.swing.*;
import javax.swing.event.ChangeListener;

public class SliderColor {

    public static void sliderColor() {
        JFrame frame = new JFrame("Slider Example");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        frame.setLayout(new GridBagLayout()); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20); 
        gbc.fill = GridBagConstraints.BOTH; 

        
        Font standardFont = new Font("Serif", Font.BOLD, 30);

        
        JLabel redLabel = new JLabel("Red", JLabel.CENTER);
        JLabel greenLabel = new JLabel("Green", JLabel.CENTER);
        JLabel blueLabel = new JLabel("Blue", JLabel.CENTER);
        redLabel.setFont(standardFont);
        greenLabel.setFont(standardFont);
        blueLabel.setFont(standardFont);

        
        JSlider redSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255); // Default to white
        JSlider greenSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255); // Default to white
        JSlider blueSlider = new JSlider(JSlider.HORIZONTAL, 0, 255, 255); // Default to white

        redSlider.setMajorTickSpacing(50);
        redSlider.setMinorTickSpacing(10);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        redSlider.setFont(standardFont);

        greenSlider.setMajorTickSpacing(50);
        greenSlider.setMinorTickSpacing(10);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        greenSlider.setFont(standardFont);

        blueSlider.setMajorTickSpacing(50);
        blueSlider.setMinorTickSpacing(10);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        blueSlider.setFont(standardFont);

        
        JLabel changingLabel = new JLabel("Color Label", JLabel.CENTER);
        changingLabel.setOpaque(true);
        changingLabel.setBackground(Color.WHITE);
        changingLabel.setFont(standardFont);

        
        JLabel randomColorLabel = new JLabel("Random Color Label", JLabel.CENTER);
        randomColorLabel.setOpaque(true);
        Random rand = new Random();
        randomColorLabel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));
        randomColorLabel.setFont(standardFont);

        
        ChangeListener changeListener = _ -> {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            changingLabel.setBackground(new Color(red, green, blue));
        };

        redSlider.addChangeListener(changeListener);
        greenSlider.addChangeListener(changeListener);
        blueSlider.addChangeListener(changeListener);

        
        JButton submitButton = new JButton("Submit");
        submitButton.setFont(standardFont);

        JLabel resultLabel = new JLabel("Similarity: ", JLabel.CENTER);
        resultLabel.setFont(standardFont);

        
        JLabel highScoreLabel = new JLabel("High Score: 0.00%", JLabel.CENTER);
        highScoreLabel.setFont(standardFont);

        
        JPanel similarityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10)); // Horizontal alignment with spacing
        similarityPanel.add(resultLabel);
        similarityPanel.add(highScoreLabel);

        
        gbc.gridy = 6; 
        gbc.gridwidth = 2;
        frame.add(similarityPanel, gbc);

       
        double[] highScore = {0.0}; 

        
        submitButton.addActionListener(_ -> {
            Color color1 = changingLabel.getBackground();
            Color color2 = randomColorLabel.getBackground();
            double similarity = calculateColorSimilarity(color1, color2);
            resultLabel.setText(String.format("Similarity: %.2f%%", similarity * 100));

            
            if (similarity > highScore[0]) {
                highScore[0] = similarity;
                highScoreLabel.setText(String.format("High Score: %.2f%%", similarity * 100));
            }

            
            randomColorLabel.setBackground(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

            
            redSlider.setValue(255);
            greenSlider.setValue(255);
            blueSlider.setValue(255);
        });

        
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        gbc.weightx = 1;
        gbc.weighty = 0.1;
        frame.add(redLabel, gbc);

        gbc.gridx = 1;
        frame.add(redSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(greenLabel, gbc);

        gbc.gridx = 1;
        frame.add(greenSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(blueLabel, gbc);

        gbc.gridx = 1;
        frame.add(blueSlider, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.weighty = 0.2;
        frame.add(randomColorLabel, gbc);

        gbc.gridy = 4;
        frame.add(changingLabel, gbc);

        gbc.gridy = 5;
        gbc.weighty = 0.1;
        frame.add(submitButton, gbc);

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

    public static void main(String[] args) {
        sliderColor();
    }
}