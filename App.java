import javax.swing.*;
public class App{
    public static void main(String[] args){
        List easyColors = new ArrayList();
        List mediumColors = new ArrayList();
        List hardColors = new ArrayList();
        easyColors.add("Red");
        easyColors.add("Blue");
        easyColors.add("Yellow");
        easyColors.add("Green");
        mediumColors.add("Red");
        mediumColors.add("Blue");
        mediumColors.add("Yellow");
        mediumColors.add("Green");
        mediumColors.add("Purple");
        mediumColors.add("Orange");
        hardColors.add("Red");
        hardColors.add("Blue");
        hardColors.add("Yellow");
        hardColors.add("Green");
        hardColors.add("Purple");
        hardColors.add("Orange");
        hardColors.add("Black");
        hardColors.add("Pink");
        
        JFrame simonSays = new JFrame("My Swing GUI");
        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a JLabel (text label)
        JLabel label = new JLabel("Hello, Swing!", JLabel.CENTER);
        simonSays.getContentPane().add(label);

        // Set the size of the window and make it visible
        simonSays.setSize(300, 200);
        simonSays.setVisible(true);
    }
public void newColor(JFrame simonSays){

}
}