package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class neubInfoPortal extends JFrame implements ActionListener {
    private JButton submit;
    JButton back;
    private JLabel header, ID, name;
    private JTextField sID, sName;

    neubInfoPortal(){
          //Frame Building
        setTitle("NEUB Student Information");
        setSize(650,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(new Color(144, 238, 144));
        header = new JLabel("NEUB Students Information ", JLabel.CENTER);
        header.setSize(650,50);
        header.setOpaque(true);
        header.setBackground(new Color(144, 238, 144));
        header.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 30);
        header.setFont(font);
        add(header);

        //ading input

        ID = new JLabel("Enter Student ID  : ");
        ID.setBounds(68, 103, 200, 60);
        ID.setOpaque(true);
        ID.setBackground(new Color(144, 238, 144));
        ID.setFont(new Font("Poppins", Font.BOLD, 20));


        sID = new JTextField();
        sID.setBounds(260, 116, 200, 40); 
        add(ID);
        add(sID);

        name = new JLabel("Enter Student Name:");
        name.setBounds(50, 180, 200, 60);
        name.setFont(new Font("Poppins", Font.BOLD, 20));


        sName = new JTextField();
        sName.setBounds(260, 190, 200, 40);  
        add(name);
        add(sName);

        //adding buttons
        submit = new JButton("Submit");
        submit.setOpaque(true);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.setSize(150, 60);
        submit.setLocation(350, 280);
        submit.setFont(new Font("Poppins", Font.BOLD, 15));
        add(submit);

        back = new JButton("Return to Home Page");
        back.setOpaque(true);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setSize(150, 25);
        back.setLocation(450, 395);
        back.setFont(new Font("Poppins", Font.BOLD, 10));
        add(back);

        setVisible(true);

        submit.addActionListener(this);
        back.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e){
        String choice = e.getActionCommand();
            // System.out.println(choice);

            try{ 

                if(choice.equals("Submit")){

                    String id = sID.getText();
                    JOptionPane.showMessageDialog(null, "Searching on DB,it might take few seconds!");
                    handler.getUserDataByID(id);
                    setVisible(false);

                }


                else if(choice.equals("Return to Home Page")){
                    setVisible(false);
                    new home();
                }

            }finally{

            }

    }

    public static void main(String[] args) {
        new neubInfoPortal();
    }

}
