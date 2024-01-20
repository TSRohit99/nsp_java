package org.example;

import org.bson.Document;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class studentResult extends JFrame implements ActionListener {
    private JLabel header2, ID;
    private JTextField sID;
    JButton submit,back;
    private JTable courseTable;
    private JTable cgpaTable;
    private JButton backButton;
    studentResult(){
        setTitle("Get your Result ");
        setSize(650,500);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Frame decor
        getContentPane().setBackground(new Color(144, 238, 144));
        header2 = new JLabel("NEUB Result Portal ", JLabel.CENTER);
        header2.setSize(650,50);
        header2.setOpaque(true);
        header2.setBackground(new Color(144, 238, 144));
        header2.setForeground(Color.black);
        Font font = new Font("Courier New", Font.BOLD, 30);
        header2.setFont(font);
        add(header2);

        //ading input

        ID = new JLabel("Enter Your ID :");
        ID.setBounds(50, 100, 150, 60);
        ID.setOpaque(true);
        ID.setBackground(new Color(144, 238, 144));
        ID.setFont(new Font("Poppins", Font.BOLD, 20));


        sID = new JTextField();
        sID.setBounds(200, 115, 200, 40); 
        add(ID);
        add(sID);

        //adding buttons
        submit = new JButton("Submit");
        submit.setOpaque(true);
        submit.setBackground(Color.DARK_GRAY);
        submit.setForeground(Color.WHITE);
        submit.setSize(180, 40);
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

    studentResult(Document doc){
        setTitle("Student Result");
        setSize(650, 500);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a map to store user information
        Map<String, List<Double>> userData = new LinkedHashMap<>();
        userData.put("Data Structure", createList(doc.getDouble("ds"), doc.getDouble("ds_c")));
        userData.put("Data Structure Lab", createList(doc.getDouble("dsLab"), doc.getDouble("dsLab_c")));
        userData.put("Physics", createList(doc.getDouble("physices"), doc.getDouble("physices_c")));
        userData.put("Math", createList(doc.getDouble("math"), doc.getDouble("math_c")));
        userData.put("DLD", createList(doc.getDouble("dld"), doc.getDouble("dld_c")));
        userData.put("DLD lab", createList(doc.getDouble("dldLab"), doc.getDouble("dldLab_c")));
        userData.put("EDC", createList(doc.getDouble("bee"), doc.getDouble("bee_c")));
        userData.put("EDC lab", createList(doc.getDouble("beeLab"), doc.getDouble("beeLab_c")));
        userData.put("Total Credit", createList(null, doc.getDouble("totalCredit")));


        int i;
        // Create a two-dimensional array for course table data
        List<Object[]> courseDataList = new ArrayList<>();
        for (Map.Entry<String, List<Double>> entry : userData.entrySet()) {
            String key = entry.getKey();
            List<Double> values = entry.getValue();
            Object[] rowData = new Object[3];
            rowData[0] = key;
            for ( i = 0; i < values.size(); i++) {
                rowData[i + 1] = values.get(i);
            }
            courseDataList.add(rowData);
        }

        Object[][] courseData = new Object[courseDataList.size()][3];
        courseDataList.toArray(courseData);

        String[] courseColumnNames = {"Course Title", "Grade", "Credit"};
        DefaultTableModel courseModel = new DefaultTableModel(courseData, courseColumnNames);

        courseTable = new JTable(courseModel);
        courseTable.setEnabled(false);
        courseTable.setFont(new Font("Arial", Font.PLAIN, 15));
        courseTable.getTableHeader().setBackground(Color.DARK_GRAY);
        courseTable.getTableHeader().setForeground(Color.WHITE);
        courseTable.setSelectionBackground(Color.LIGHT_GRAY);
        courseTable.setSelectionForeground(Color.BLACK);
        courseTable.setRowHeight(30); // Increase row height

        Map<String, Double> result = new LinkedHashMap<>();
        result.put("Current CGPA", doc.getDouble("currentSemResult"));
        result.put("Previous Semester CGPA",doc.getDouble("prevSemResult"));
        double totalCGPA = (doc.getDouble("currentSemResult") + doc.getDouble("prevSemResult")) / 2;
        double roundedCGPA = Math.round(totalCGPA * 100.0) / 100.0;
        result.put("Total CGPA", roundedCGPA);

        // Create a two-dimensional array for cgpa table data
        Object[][] cgpaData = new Object[result.size()][2];
         i = 0;
        for (Map.Entry<String, Double> entry : result.entrySet()) {
            cgpaData[i][0] = entry.getKey();
            cgpaData[i][1] = entry.getValue();
            i++;
        }

        String[] cgpaColumnNames = {"CGPA Table", "Grade"};
        DefaultTableModel cgpaModel = new DefaultTableModel(cgpaData, cgpaColumnNames);

        cgpaTable = new JTable(cgpaModel);
        cgpaTable.setEnabled(false);
        cgpaTable.setFont(new Font("Arial", Font.PLAIN, 15));
        cgpaTable.getTableHeader().setBackground(Color.DARK_GRAY);
        cgpaTable.getTableHeader().setForeground(Color.WHITE);
        cgpaTable.setSelectionBackground(Color.LIGHT_GRAY);
        cgpaTable.setSelectionForeground(Color.BLACK);
        cgpaTable.setRowHeight(30);

        JPanel contentPanel = new JPanel(new GridLayout(2, 1, 10, 10)); // 2 rows, 1 column

        contentPanel.add(new JScrollPane(courseTable));
        contentPanel.add(new JScrollPane(cgpaTable));

        add(contentPanel, BorderLayout.CENTER);

        String sName = doc.getString("name"); // Example result fetched from the database

        JLabel resultLabel2 = new JLabel("Name: " + sName, JLabel.CENTER);
        resultLabel2.setFont(new Font("Arial", Font.BOLD, 14));
        add(resultLabel2, BorderLayout.NORTH);

        backButton = new JButton("Return to Previous Page");
        backButton.setBackground(Color.RED);
        backButton.setForeground(Color.WHITE);
        backButton.setFont(new Font("Arial", Font.BOLD, 20));
        backButton.addActionListener(e -> new studentResult());

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.WHITE);
        buttonPanel.add(backButton);

        add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private List<Double> createList(Double... values) {
        List<Double> list = new ArrayList<>();
        for (Double value : values) {
            list.add(value);
        }
        return list;
    }

    public void actionPerformed(ActionEvent e) { 
        String choice = e.getActionCommand();
        // System.out.println(choice);

            if(choice.equals("Submit")){
                JOptionPane.showMessageDialog(null, "Searching on DB,it might take few seconds!");
                handler.getResult(sID.getText());
                setVisible(false);

            }


            else if(choice.equals("Return to Previous Page")){
                Main main = new Main();
                setVisible(false);
            }

            else if(choice.equals("Return to Home Page")){
                Main main = new Main();
                setVisible(false);
            }
    }





    public static void main(String[] args) {
        new studentResult();
        
    }
}
