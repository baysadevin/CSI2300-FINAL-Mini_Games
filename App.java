import javax.swing.*;

import org.w3c.dom.events.MouseEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;
import java.util.Random;
import javax.swing.Timer;


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
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                int rndmnum = new Random().nextInt(easyColors.length);
                String thisColor = easyColors[rndmnum];
                easyLabel.setText(thisColor);
                if (rndmnum == 0) {
                    easyLabel.setForeground(Color.WHITE);
                } else if (rndmnum == 1) {
                    easyLabel.setForeground(Color.WHITE);
                } else if (rndmnum == 2) {
                    easyLabel.setForeground(Color.BLACK);
                } else {
                    easyLabel.setForeground(Color.BLACK);
                }
                easyFrame.getContentPane().setBackground( thisColor == "RED" ? Color.RED : thisColor == "BLUE" ? Color.BLUE : thisColor == "YELLOW" ? Color.YELLOW : Color.GREEN); 
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
        String[] mediumColors = {"RED", "BLUE", "YELLOW", "GREEN", "PURPLE", "ORANGE"};
        
        JFrame mediumFrame = new JFrame("Medium Mode");
        mediumFrame.setSize(300, 200);
        mediumFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel mediumLabel = new JLabel("medium Mode", JLabel.CENTER);
        mediumFrame.getContentPane().add(mediumLabel);
        Timer timer = new Timer(2000, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String thisColor = mediumColors[new Random().nextInt(mediumColors.length)];
                mediumLabel.setText(thisColor);
                mediumFrame.getContentPane().setBackground( thisColor == "RED" ? Color.RED : thisColor == "BLUE" ? Color.BLUE : thisColor == "YELLOW" ? Color.YELLOW : thisColor == "GREEN" ? Color.GREEN : thisColor == "PURPLE" ? Color.MAGENTA : Color.ORANGE);
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
        String[] hardColors = {"Red", "Blue", "Yellow", "Green", "Purple", "Orange", "Black", "Pink"};
        JFrame hardFrame = new JFrame("Hard Mode");
        hardFrame.setSize(300, 200);
        hardFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JLabel hardLabel = new JLabel("Hard Mode", JLabel.CENTER);
        hardFrame.getContentPane().add(hardLabel);
        Timer timer = new Timer(2000, new ActionListener() {
            int index = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                String thisColor = hardColors[new Random().nextInt(hardColors.length)];
                hardLabel.setText(thisColor);
                hardFrame.getContentPane().setBackground( thisColor == "Red" ? Color.RED : thisColor == "Blue" ? Color.BLUE : thisColor == "Yellow" ? Color.YELLOW : thisColor == "Green" ? Color.GREEN : thisColor == "Purple" ? Color.MAGENTA : thisColor == "Orange" ? Color.ORANGE : thisColor == "Black" ? Color.BLACK : Color.PINK);
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

