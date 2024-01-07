package org.example;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class home extends JFrame implements ActionListener {
    private JLabel header;
    private JButton neubInfoPortal, CED, back;
    home(){

        //Frame Building
        setTitle("NEUB Student Portal");
        setSize(650,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(Color.gray);
        header = new JLabel("NEUB Student Portal Dashboard ", JLabel.CENTER);
        header.setSize(650,50);
        header.setOpaque(true);
         header.setBackground(Color.gray);
        header.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 30);
        header.setFont(font);
        add(header);

        //adding buttons
        neubInfoPortal = new JButton("NEUB Student Portal");
        neubInfoPortal.setOpaque(true);
        neubInfoPortal.setBackground(Color.DARK_GRAY);
        neubInfoPortal.setForeground(Color.WHITE);
        neubInfoPortal.setSize(300, 60);
        neubInfoPortal.setLocation(150, 150);
        neubInfoPortal.setFont(new Font("Poppins", Font.BOLD, 20));
        add(neubInfoPortal);

        CED = new JButton("CED Operations");
        CED.setOpaque(true);
        CED.setBackground(Color.DARK_GRAY);
        CED.setForeground(Color.WHITE);
        CED.setSize(300, 60);
        CED.setLocation(150, 220);
        CED.setFont(new Font("Poppins", Font.BOLD, 20));
        add(CED);

        back = new JButton("Return to Home Page");
        back.setOpaque(true);
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.black);
        back.setSize(150, 25);
        back.setLocation(380, 360);
        back.setFont(new Font("Poppins", Font.BOLD, 10));
        add(back);

        neubInfoPortal.addActionListener(this); 
        CED.addActionListener(this);
        back.addActionListener(this);
        
        

        setVisible(true);
    }

       public void actionPerformed(ActionEvent e) { 
            String choice = e.getActionCommand();
            // System.out.println(choice);

            try{ 
                if(choice.equals("NEUB Student Portal")){
                    setVisible(false);
                   new neubInfoPortal();
                }
                else if(choice.equals("CED Operations")){
                    setVisible(false);
                   new CED();
                }
                else if(choice.equals("Return to Home Page")){
                    setVisible(false);
                    new Main();
                }

            }finally{

            }

        }
    

    public static void main(String[] args) {
        new home();
        
    }
}
