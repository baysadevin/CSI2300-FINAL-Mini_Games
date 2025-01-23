import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class App {

    public void gui() {
        JFrame simonSays = new JFrame("My Swing GUI");
        JPanel ssPanel = new JPanel();
        ssPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));

        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel("Hello, Swing!", JLabel.CENTER);

        simonSays.getContentPane().add(label);

        simonSays.setSize(300, 200);

        simonSays.setVisible(true);

        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");

        easy.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simonSaysEasy();
            }
        });

        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simonSaysMedium();
            }
        });

        hard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                simonSaysHard();
            }
        });

        ssPanel.add(easy);
        ssPanel.add(medium);
        ssPanel.add(hard);
        simonSays.add(ssPanel);
        ssPanel.setVisible(true);
        simonSays.setVisible(true);
        simonSays.setSize(300, 200);
        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void simonSaysEasy() {
        System.out.println("Easy mode selected");
        
    }

    public void simonSaysMedium() {
        System.out.println("Medium mode selected");
        // Add your logic for Medium mode here
    }

    public void simonSaysHard() {
        System.out.println("Hard mode selected");
        // Add your logic for Hard mode here
    }

    public static void main(String[] args) {
        App app = new App();
        app.gui();
    }
}
    //public static void main(String[] args){
    //    App app = new App();
      //  app.gui();
        //List easyColors = new ArrayList();
      //  List mediumColors = new ArrayList();
      //  List hardColors = new ArrayList();
      //  easyColors.add("Red");
      //  easyColors.add("Blue");
      //  easyColors.add("Yellow");
       // easyColors.add("Green");
       // mediumColors.add("Red");
      //  mediumColors.add("Blue");
      //  mediumColors.add("Yellow");
      //  mediumColors.add("Green");
      //  mediumColors.add("Purple");
      //  mediumColors.add("Orange");
      //  hardColors.add("Red");
      //  hardColors.add("Blue");
      //  hardColors.add("Yellow");
      //  hardColors.add("Green");
      //  hardColors.add("Purple");
      //  hardColors.add("Orange");
      //  hardColors.add("Black");
      //  hardColors.add("Pink");
  //  }

