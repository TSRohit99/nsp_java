package org.example;

import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;

public class loginPage extends JFrame implements ActionListener{

    private JTextField usernameField;
    private JPasswordField passwordField;

    public loginPage() {
        setTitle("Login Page");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel titleLabel = new JLabel("Submit your Credentials to login");
        titleLabel.setBounds(150, 50, 350, 60);
        titleLabel.setFont(new Font("Poppins", Font.BOLD, 20));
        add(titleLabel);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 145, 80, 45);
        usernameLabel.setFont(new Font("Poppins", Font.BOLD, 15));
        add(usernameLabel);

        usernameField = new JTextField();
        usernameField.setBounds(200, 150, 200, 35);
        add(usernameField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 195, 80, 45);
        passwordLabel.setFont(new Font("Poppins", Font.BOLD, 15));
        add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(200, 200, 200, 35);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(250, 250, 80, 40);
        add(loginButton);
       JButton back = new JButton("Return to Home Page");
        back.setOpaque(true);
        back.setBackground(Color.red);
        back.setForeground(Color.WHITE);
        back.setSize(150, 25);
        back.setLocation(380, 360);
        back.setFont(new Font("Poppins", Font.BOLD, 10));
        add(back);
        back.addActionListener(this);
        loginButton.addActionListener(this);


        setVisible(true);
    }
            
            public void actionPerformed(ActionEvent e) {
                String choice = e.getActionCommand();
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);


                if (username.equals("1") && password.equals("1")) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    setVisible(false);
                    new home();
                }else if(choice.equals("Return to Home Page")){
                    setVisible(false);
                    new Main();
                }
                else {
                    JOptionPane.showMessageDialog(null, "Invalid Credentials.Try again!");
                }


            }
        


    

    public static void main(String[] args) {
        new loginPage();
    }
}
