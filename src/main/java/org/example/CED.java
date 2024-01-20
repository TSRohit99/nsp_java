package org.example;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;


public class CED extends JFrame implements ActionListener{

    private JButton addData, delData, updateData,submit, back;
    JTextField sName, sID, sEmail, sCGPA, sBg, sStatus;
    private JLabel Name, ID, Email, CGPA, Bg, Status,header, header1, header2;

    //<<<<<<<<<<<< CED HOMEPAGE >>>>>>>>>>>

    CED(){
        setTitle("Add/Delete/Edit Student Information");
        setSize(650,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(Color.gray);
        header = new JLabel("Add/Delete/Edit Student Information", JLabel.CENTER);
        header.setSize(650,50);
        header.setOpaque(true);
        header.setBackground(Color.gray);
        header.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 27);
        header.setFont(font);
        add(header);

        //adding buttons
        addData = new JButton("Add Student Data");
        addData.setOpaque(true);
        addData.setBackground(Color.DARK_GRAY);
        addData.setForeground(Color.WHITE);
        addData.setSize(300, 60);
        addData.setLocation(150, 150);
        addData.setFont(new Font("Poppins", Font.BOLD, 20));
        add(addData);

        delData = new JButton("Delete Student info");
        delData.setOpaque(true);
        delData.setBackground(Color.DARK_GRAY);
        delData.setForeground(Color.WHITE);
        delData.setSize(300, 60);
        delData.setLocation(150, 220);
        delData.setFont(new Font("Poppins", Font.BOLD, 20));
        add(delData);

        updateData = new JButton("Update Student info");
        updateData.setOpaque(true);
        updateData.setBackground(Color.DARK_GRAY);
        updateData.setForeground(Color.WHITE);
        updateData.setSize(300, 60);
        updateData.setLocation(150, 290);
        updateData.setFont(new Font("Poppins", Font.BOLD, 20));
        add(updateData);

        back = new JButton("Return to Previous Page");
        back.setOpaque(true);
        back.setBackground(Color.LIGHT_GRAY);
        back.setForeground(Color.black);
        back.setSize(180, 25);
        back.setLocation(380, 360);
        back.setFont(new Font("Poppins", Font.BOLD, 10));
        add(back);

        setVisible(true);

        back.addActionListener(this);
        addData.addActionListener(this); 
        delData.addActionListener(this);
        updateData.addActionListener(this);

    }




     //<<<<<<<<<<<< CED ADD STUDENT INFO >>>>>>>>>>>

     CED(int i){

        setTitle("Add Student Information");
        setSize(650,550);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(Color.WHITE);
        if(i==1)
            header1 = new JLabel("Add Student Information Below", JLabel.CENTER);
        else {
            header1 = new JLabel("Update Student Information", JLabel.CENTER);
            JLabel info = new JLabel("***fill the information that needs to be updated only, use the ID");
            info.setBounds(40, 45, 650, 16);
            info.setOpaque(true);
            info.setFont(new Font("Poppins", Font.BOLD, 13));
            add(info);
        }
        header1.setSize(650,50);
        header1.setOpaque(true);
        // header.setBackground(Color.gray);
        // header.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 30);
        header1.setFont(font);
        add(header1);

        Name = new JLabel("Student Name : ");
           Name.setBounds(50, 60, 450, 30);
           Name.setOpaque(true);
           Name.setBackground(Color.WHITE);
           Name.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Name);

           sName = new JTextField();
           sName.setBounds(50, 95, 300, 30);
           add(sName);

           

           ID = new JLabel("ID :");
           ID.setBounds(50, 125, 450, 30);
           ID.setOpaque(true);
           ID.setBackground(Color.WHITE);
           ID.setFont(new Font("Poppins", Font.BOLD, 20));
           add(ID);
           sID = new JTextField();
           sID.setBounds(50, 160, 300, 30);
           add(sID);


           Email = new JLabel("Email :");
           Email.setBounds(50, 195, 450, 30);
           Email.setOpaque(true);
           Email.setBackground(Color.WHITE);
           Email.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Email);

           sEmail = new JTextField();
           sEmail.setBounds(50, 230, 300, 30);
           add(sEmail);

           CGPA = new JLabel("CGPA :");
           CGPA.setBounds(50, 260, 450, 30);
           CGPA.setOpaque(true);
           CGPA.setBackground(Color.WHITE);
           CGPA.setFont(new Font("Poppins", Font.BOLD, 20));
           add(CGPA);

           sCGPA = new JTextField();
           sCGPA.setBounds(50, 290, 300, 30);
           add(sCGPA);

           Bg = new JLabel("Blood Group :");
           Bg.setBounds(50, 320, 450, 30);
           Bg.setOpaque(true);
           Bg.setBackground(Color.WHITE);
           Bg.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Bg);

           sBg = new JTextField();
           sBg.setBounds(50, 350, 300, 30);
           add(sBg);


           Status = new JLabel("IsContinnuing :");
           Status.setBounds(50, 380, 300, 30);
           Status.setOpaque(true);
           Status.setBackground(Color.WHITE);
           Status.setFont(new Font("Poppins", Font.BOLD, 20));
           add(Status);

           sStatus = new JTextField();
           sStatus.setBounds(50, 410, 300, 30);
           add(sStatus);
           
           

            if(i==1)
                submit = new JButton("Submit");
            else
                submit = new JButton("Update");

                submit.setOpaque(true);
                submit.setBackground(Color.DARK_GRAY);
                submit.setForeground(Color.WHITE);
                submit.setSize(150, 40);
                submit.setLocation(450, 400);
                submit.setFont(new Font("Poppins", Font.BOLD, 15));
                add(submit);



            back = new JButton("Return to Home Page");
            back.setOpaque(true);
            back.setBackground(Color.red);
            back.setForeground(Color.WHITE);
            back.setSize(150, 25);
            back.setLocation(450, 480);
            back.setFont(new Font("Poppins", Font.BOLD, 10));
            add(back);

        setVisible(true);

        submit.addActionListener(this);
        back.addActionListener(this);
        
        }

 //<<<<<<<<<<<< CED Delete STUDENT INFO >>>>>>>>>>>


        CED(String x){
            setTitle("Delete Student Information ");
            setSize(650,500);
            setLocationRelativeTo(null);
            setResizable(false);
            setLayout(null);
           
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
            //Frame decor
            getContentPane().setBackground(Color.WHITE);
            header2 = new JLabel("Delete Student Information ", JLabel.CENTER);
            header2.setSize(650,50);
            header2.setOpaque(true);
            header2.setBackground(Color.white);
            header2.setForeground(Color.black);
            Font font = new Font("Courier New", Font.BOLD, 30);
            header2.setFont(font);
            add(header2);
    
            //adding input
    
            ID = new JLabel("Enter the ID :");
            ID.setBounds(50, 100, 150, 60);
            ID.setOpaque(true);
            ID.setBackground(Color.WHITE);
            ID.setFont(new Font("Poppins", Font.BOLD, 20));
    
    
            sID = new JTextField();
            sID.setBounds(200, 115, 200, 40); 
            add(ID);
            add(sID);

            //adding buttons
            submit = new JButton("Delete this ID from DB");
            submit.setOpaque(true);
            submit.setBackground(Color.DARK_GRAY);
            submit.setForeground(Color.WHITE);
            submit.setSize(220, 60);
            submit.setLocation(240, 190);
            submit.setFont(new Font("Poppins", Font.BOLD, 15));
            add(submit);

            back = new JButton("Return to Home Page");
            back.setOpaque(true);
            back.setBackground(Color.red);
            back.setForeground(Color.WHITE);
            back.setSize(150, 25);
            back.setLocation(380, 360);
            back.setFont(new Font("Poppins", Font.BOLD, 10));
            add(back);

            setVisible(true);

        submit.addActionListener(this);
        back.addActionListener(this);


        }
     
         //<<<<<<<<<<<< ACTION LISTENER >>>>>>>>>>>

       public void actionPerformed(ActionEvent e) { 
            String choice = e.getActionCommand();
            // System.out.println(choice);

            try{ 
                if(choice.equals("Add Student Data")){
                    setVisible(false);
                   new CED(1);

                }

                else if(choice.equals("Delete Student info")){
                    new CED("run");
                    setVisible(false);
                }
                else if(choice.equals("Update Student info")){
                    new CED(2);
                    setVisible(false);
                }

                else if(choice.equals("Return to Home Page")){
                    new home();
                    setVisible(false);
                }

                else if(choice.equals("Return to Previous Page")){
                    new home();
                    setVisible(false);
                }

                else if(choice.equals("Submit")){

                    handler.addUserData(this);

                    JOptionPane.showMessageDialog(null, "This User Information is successfully added to the Database", "Confirmatation Success", 1);
                    this.sID.setText(null);
                    this.sName.setText(null);
                    this.sEmail.setText(null);
                    this.sBg.setText(null);
                    this.sStatus.setText(null);
                    this.sCGPA.setText(null);



                }

                else if(choice.equals("Update")){

                    handler.updateUserData(this);

//                    JOptionPane.showMessageDialog(null, "This User Information will be added to the Database", "Confirmatation Success", 1);
                    this.sID.setText(null);
                    this.sName.setText(null);
                    this.sEmail.setText(null);
                    this.sBg.setText(null);
                    this.sStatus.setText(null);
                    this.sCGPA.setText(null);

                }
                else if(choice.equals("Delete this ID from DB")){
                 handler.delUserData(this.sID.getText());
                    JOptionPane.showMessageDialog(null, "This User ID has been deleted from Database", "Deleted!", 1);
                    this.sID.setText(null);

                }


            }finally{

            }

        }

       

    public static void main(String[] args) {
        new CED();
    }
}
