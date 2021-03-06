import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CounterFrame extends JFrame {

    // Declaring the variables
    private JPanel panelNorth;
    private JPanel panelEast;
    private JPanel panelWest;
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JLabel titleLabel;
    private JLabel counterLabel;
    private JButton plusButton;
    private JButton minusButton;
    private JButton resetButton;
    private int count;
    

    public CounterFrame(){

        this.setTitle("The Counter GUI"); //sets title of frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit out of appliaction
        this.setResizable(true); //makes the frame resizeable
        this.setSize(500, 500); //sets the x-dimension and y-dimension of frame

        // Initializing the JPanels
        panelNorth = new JPanel();
        panelEast = new JPanel();
        panelWest = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        // Using the BorderLayout for the Frame and Center, East, and West Panel
        this.setLayout(new BorderLayout());
        panelCenter.setLayout(new BorderLayout());
        panelEast.setLayout(new BorderLayout());
        panelWest.setLayout(new BorderLayout());

        // Feel free to customize these colors
        panelNorth.setBackground(Color.ORANGE);
        panelCenter.setBackground(Color.WHITE);
        panelSouth.setBackground(Color.ORANGE);

        // Initializing and setting the titleLabel
        titleLabel = new JLabel();
        titleLabel.setText("The Counter");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 50)); // Feel free to customize the font


        // Initializing and setting the counterLabel
        counterLabel = new JLabel();
        counterLabel.setText("" + 0); // Clue : use the 'count' variable
        counterLabel.setHorizontalAlignment(JLabel.CENTER);
        counterLabel.setVerticalAlignment(JLabel.CENTER);
        counterLabel.setFont(new Font("Serif", Font.PLAIN, 75)); // Feel free to customize the font

        // Initializing the JButtons
        plusButton = new JButton("+");
        minusButton = new JButton("-");
        resetButton = new JButton("RESET");

        plusButton.setFont(new Font("Arial", Font.BOLD, 75)); // Feel free to customize the font
        plusButton.setBackground(Color.GREEN);
        plusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count++;
                counterLabel.setText("" + count);
            }
        });

        minusButton.setFont(new Font("Arial", Font.BOLD, 75)); // Feel free to customize the font
        minusButton.setBackground(Color.RED);
        minusButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count--;
                if(count < 0){
                    count = 0;
                    counterLabel.setText("" + count);
                } else
                    counterLabel.setText("" + count);
                
            }
        });

        resetButton.setFont(new Font("Arial", Font.PLAIN, 30)); // Feel free to customize the font
        resetButton.setBackground(Color.CYAN);
        resetButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                count = 0;
                counterLabel.setText("" + count);
            }     
        });

        panelNorth.add(titleLabel);
        panelEast.add(plusButton);
        panelWest.add(minusButton);
        panelSouth.add(resetButton);
        panelCenter.add(counterLabel);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelEast, BorderLayout.EAST);
        this.add(panelWest, BorderLayout.WEST);
        this.add(panelSouth, BorderLayout.SOUTH);
        this.add(panelCenter, BorderLayout.CENTER);

        this.setVisible(true); // Making the frame visible
    }
}
