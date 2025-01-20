import javax.swing.*;
public class App{
    public static void main(String[] args){
        JFrame simonSays = new JFrame("My Swing GUI");
        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a JLabel (text label)
        JLabel label = new JLabel("Hello, Swing!", JLabel.CENTER);
        simonSays.getContentPane().add(label);

        // Set the size of the window and make it visible
        simonSays.setSize(300, 200);
        simonSays.setVisible(true);
    }

}