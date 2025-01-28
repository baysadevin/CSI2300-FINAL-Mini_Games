
import javax.swing.*;
import java.awt.*;


public class GUI {

    private JFrame frame;
    private JLabel label;
   
   public void initializeFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);      
    }
    public void initializeButton(String text, int width, int height) {
        JButton button = new JButton(text);
        button.setSize(width, height);
        button.setVisible(true);
    }
    public void initializeLabel(String text, int width, int height) {
        label.setSize(width, height);
        label.setVisible(true);
    }
    public void initializeBorderLayout() {
        frame.setLayout(new BorderLayout());
    }
}