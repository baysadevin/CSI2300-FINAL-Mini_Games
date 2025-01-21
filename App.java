import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App{
    
    public void gui() {
        JFrame simonSays = new JFrame("My Swing GUI");
        JPanel ssPanel = new JPanel();
        ssPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
    
        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        JLabel label = new JLabel("Hello, Swing!", JLabel.CENTER);
    
        simonSays.getContentPane().add(label);
    
        simonSays.setSize(300, 200);
    
        simonSays.setVisible(true);
    }
    
    public static void main(String[] args){

        new gui();
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
    }
}
