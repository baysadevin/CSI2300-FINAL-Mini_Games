import javax.swing.*;

import org.w3c.dom.events.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Random;


public class App {

    public void gui() {
        JFrame simonSays = new JFrame("My Swing GUI");
        JPanel ssPanel = new JPanel();
        ssPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 100,200));
        simonSays.setSize(1000, 800);
        simonSays.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        

        simonSays.setVisible(true);

        JButton easy = new JButton("Easy");
        JButton medium = new JButton("Medium");
        JButton hard = new JButton("Hard");
        easy.setPreferredSize(new java.awt.Dimension(100, 50));
        medium.setPreferredSize(new java.awt.Dimension(100, 50));
        hard.setPreferredSize(new java.awt.Dimension(100, 50));

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
}

    public void simonSaysEasy() {
        System.out.println("Easy mode selected");
        String[] easyColors = {"RED", "BLUE", "YELLOW", "GREEN"};

        JFrame easyFrame = new JFrame("Easy Mode");
        easyFrame.setSize(1000 , 800);
        easyFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        

        JLabel easyLabel = new JLabel("Easy Mode", JLabel.CENTER);
        easyFrame.getContentPane().add(easyLabel);
        Timer timer = new Timer(2000, new ActionListener() {
            @Override
    public void actionPerformed(ActionEvent e) {

        easyFrame.getContentPane().setBackground(Color.BLACK);

    
        Timer flashTimer = new Timer(100, new ActionListener() { 
            @Override
            public void actionPerformed(ActionEvent e) {
                int rndmnum = new Random().nextInt(easyColors.length);
                String thisColor = easyColors[rndmnum];
                easyLabel.setText(thisColor);
                if (rndmnum == 0 || rndmnum == 1) {
                    easyLabel.setForeground(Color.WHITE);
                } else {
                    easyLabel.setForeground(Color.BLACK);
                }
                easyFrame.getContentPane().setBackground(
                    thisColor.equals("RED") ? Color.RED :
                    thisColor.equals("BLUE") ? Color.BLUE :
                    thisColor.equals("YELLOW") ? Color.YELLOW : Color.GREEN
                );
            }
        });
        flashTimer.setRepeats(false); 
        flashTimer.start();
    }
});
        timer.start();

        easyFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                timer.stop();
            }
        });

        easyFrame.setVisible(true);

    }


public void simonSaysMedium() {
    System.out.println("Medium mode selected");
    String[] mediumColors = {"RED", "BLUE", "YELLOW", "GREEN", "ORANGE", "PURPLE"};

    JFrame mediumFrame = new JFrame("Medium Mode");
    mediumFrame.setSize(1000, 800);
    mediumFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel mediumLabel = new JLabel("Medium Mode", JLabel.CENTER);
    mediumFrame.getContentPane().add(mediumLabel);
    Timer timer = new Timer(2000, new ActionListener() { // Faster interval for medium mode
        @Override
        public void actionPerformed(ActionEvent e) {
            mediumFrame.getContentPane().setBackground(Color.BLACK);


            Timer flashTimer = new Timer(100, new ActionListener() { // Longer flash duration
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rndmnum = new Random().nextInt(mediumColors.length);
                    String thisColor = mediumColors[rndmnum];
                    mediumLabel.setText(thisColor);
                    if (rndmnum == 0 || rndmnum == 1 || rndmnum == 2) {
                        mediumLabel.setForeground(Color.WHITE);
                    } else {
                        mediumLabel.setForeground(Color.BLACK);
                    }
                    mediumFrame.getContentPane().setBackground(
                        thisColor.equals("RED") ? Color.RED :
                        thisColor.equals("BLUE") ? Color.BLUE :
                        thisColor.equals("YELLOW") ? Color.YELLOW :
                        thisColor.equals("ORANGE") ? Color.ORANGE :
                        thisColor.equals("PURPLE") ? Color.MAGENTA : Color.GREEN
                    );
                }
            });
            flashTimer.setRepeats(false);
            flashTimer.start();
        }
    });
    timer.start();

    mediumFrame.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            timer.stop();
        }
    });

    mediumFrame.setVisible(true);
}

public void simonSaysHard() {
    System.out.println("Hard mode selected");
    String[] hardColors = {"RED", "BLUE", "YELLOW", "GREEN", "ORANGE", "PURPLE", "PINK", "CYAN"};

    JFrame hardFrame = new JFrame("Hard Mode");
    hardFrame.setSize(1000, 800);
    hardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    JLabel hardLabel = new JLabel("Hard Mode", JLabel.CENTER);
    hardFrame.getContentPane().add(hardLabel);
    Timer timer = new Timer(2000, new ActionListener() { 
        @Override
        public void actionPerformed(ActionEvent e) {
            hardFrame.getContentPane().setBackground(Color.BLACK);


            Timer flashTimer = new Timer(100, new ActionListener() { // Longer flash duration
                @Override
                public void actionPerformed(ActionEvent e) {
                    int rndmnum = new Random().nextInt(hardColors.length);
                    String thisColor = hardColors[rndmnum];
                    hardLabel.setText(thisColor);
                    if (rndmnum == 0 || rndmnum == 1) {
                        hardLabel.setForeground(Color.WHITE);
                    } else {
                        hardLabel.setForeground(Color.BLACK);
                    }
                    hardFrame.getContentPane().setBackground(
                        thisColor.equals("RED") ? Color.RED :
                        thisColor.equals("BLUE") ? Color.BLUE :
                        thisColor.equals("YELLOW") ? Color.YELLOW :
                        thisColor.equals("ORANGE") ? Color.ORANGE :
                        thisColor.equals("PURPLE") ? Color.MAGENTA :
                        thisColor.equals("PINK") ? Color.PINK : Color.CYAN
                    );
                }
            });
            flashTimer.setRepeats(false);
            flashTimer.start();
        }
    });
    timer.start();

    hardFrame.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            timer.stop();
        }
    });

    hardFrame.setVisible(true);
}

    public static void main(String[] args) {
        App app = new App();
        app.gui();
    }
}

