package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    private JLabel header;
    private JButton getResult, portalAccess;
    Main(){

        //Frame Building
        setTitle("NEUB Student Portal");
        setSize(650,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(new Color(173, 216, 230));
        header = new JLabel("Welcome to NEUB Student Portal", JLabel.CENTER);
        header.setSize(650,50);
        header.setOpaque(true);
        header.setBackground(new Color(173, 216, 230));
        header.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 30);
        header.setFont(font);
        add(header);

        //adding buttons
        getResult = new JButton("Get Result");
        getResult.setOpaque(true);
        getResult.setBackground(Color.DARK_GRAY);
        getResult.setForeground(Color.WHITE);
        getResult.setSize(300, 60);
        getResult.setLocation(150, 150);
        getResult.setFont(new Font("Poppins", Font.BOLD, 20));
        add(getResult);

        portalAccess = new JButton("Private Portal Access");
        portalAccess.setOpaque(true);
        portalAccess.setBackground(Color.DARK_GRAY);
        portalAccess.setForeground(Color.WHITE);
        portalAccess.setSize(300, 60);
        portalAccess.setLocation(150, 220);
        portalAccess.setFont(new Font("Poppins", Font.BOLD, 20));
        add(portalAccess);

        getResult.addActionListener(this);
        portalAccess.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String choice = e.getActionCommand();
        // System.out.println(choice);
        try{
            if(choice.equals("Get Result")){
                setVisible(false);
                new studentResult();
            }
            else if(choice.equals("Private Portal Access")){
                setVisible(false);
                new loginPage();
            }

        }finally{

        }

    }


    public static void main(String[] args) {
        new Main();

    }
}
