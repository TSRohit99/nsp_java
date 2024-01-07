package org.example;

import org.bson.Document;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class displayUserInfo extends JFrame implements ActionListener {
    
    private JLabel Name, ID, Email, CGPA, Bg, Status, header;
    private JTextArea sName, sID, sEmail, sCGPA, sBg, sStatus;
    private JButton back;
    displayUserInfo( Document obj){

           //Frame Building
           setTitle("Student Information");
           setSize(650,500);
           setLocationRelativeTo(null);
           setResizable(false);
           setLayout(null);
           setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
           //Frame decor
           getContentPane().setBackground(Color.WHITE);
           header = new JLabel("Student Information ", JLabel.CENTER);
           header.setSize(650,50);
           header.setOpaque(true);
           Font font = new Font("Courier New", Font.BOLD, 30);
           header.setFont(font);
           add(header);

           // UI

           Name = new JLabel("Name              : ");
           Name.setBounds(50, 100, 150, 60);
           Name.setOpaque(true);
           Name.setBackground(Color.WHITE);
           Name.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Name);

           sName = new JTextArea();
           sName.setText(obj.getString("name"));
           sName.setBounds(210, 123, 150, 30 );
           add(sName);

           ID = new JLabel("ID                    :");
           ID.setBounds(50, 140, 150, 60);
           ID.setOpaque(true);
           ID.setBackground(Color.WHITE);
           ID.setFont(new Font("Poppins", Font.BOLD, 20));
           add(ID);

           sID = new JTextArea();
           sID.setText(obj.getString("id"));
           sID.setBounds(210, 163, 150, 30 );
           add(sID);

           Email = new JLabel("Email              :");
           Email.setBounds(50, 180, 150, 60);
           Email.setOpaque(true);
           Email.setBackground(Color.WHITE);
           Email.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Email);

           sEmail = new JTextArea();
           sEmail.setText(obj.getString("email"));
           sEmail.setBounds(210, 203, 150, 30 );
           add(sEmail);

           CGPA = new JLabel("CGPA             :");
           CGPA.setBounds(50, 220, 150, 60);
           CGPA.setOpaque(true);
           CGPA.setBackground(Color.WHITE);
           CGPA.setFont(new Font("Poppins", Font.BOLD, 20));
           add(CGPA);

           sCGPA = new JTextArea();
           sCGPA.setText(obj.getString("result"));
           sCGPA.setBounds(210, 243, 150, 30 );
           add(sCGPA);

           Bg = new JLabel("Blood Group :");
           Bg.setBounds(50, 260, 150, 60);
           Bg.setOpaque(true);
           Bg.setBackground(Color.WHITE);
           Bg.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Bg);

           sBg = new JTextArea();
           sBg.setText(obj.getString("bloodGroup"));
           sBg.setBounds(210, 283, 150, 30 );
           add(sBg);

           Status = new JLabel("IsContinnuing:");
           Status.setBounds(50, 300, 150, 60);
           Status.setOpaque(true);
           Status.setBackground(Color.WHITE);
           Status.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Status);

           sStatus = new JTextArea();
           sStatus.setText(String.valueOf(obj.getBoolean("status")));
           sStatus.setBounds(210, 323, 150, 30 );
           add(sStatus);

           back = new JButton("Return to Home Page");
           back.setOpaque(true);
           back.setBackground(Color.red);
           back.setForeground(Color.WHITE);
           back.setSize(150, 25);
           back.setLocation(380, 360);
           back.setFont(new Font("Poppins", Font.BOLD, 10));
           add(back);
           setVisible(true);
           back.addActionListener(this);


    }

       public void actionPerformed(ActionEvent e) {
              String choice = e.getActionCommand();
              // System.out.println(choice);
              if(choice.equals("Return to Home Page")){
                     new home();
                     setVisible(false);
              }

       }

       public static void main(String[] args) {

       }
}
