/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Course_Registration_System;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author abdul
 */
public class User_Interface extends JFrame implements ActionListener {

    int count = 1;
    JComboBox cb = new JComboBox(func1());
    boolean k;
    String ob2[] = new String[5];
    String username;
    String ID;
    JTextArea display = new JTextArea(4, 30);
    JLabel lbl3 = new JLabel("Password:");
    JLabel lbl1 = new JLabel("Name:        ");
    JLabel lbl2 = new JLabel("Student ID:");
    JLabel lblu = new JLabel("Registration Form");
    ImageIcon i = new ImageIcon("E:\\ProjectDataBase\\GUB.png");
    JLabel lblud = new JLabel(i);
    JPanel pd = new JPanel();

    JTextField txt1 = new JTextField(15);
    JTextField txt2 = new JTextField(15);
    JPasswordField txt4 = new JPasswordField(15);
    JTextArea txta = new JTextArea();
    JPasswordField txtaa = new JPasswordField(15);
    JPasswordField txtaaa = new JPasswordField(15);
    JRadioButton rb1 = new JRadioButton("DAY");
    JRadioButton rb2 = new JRadioButton("EVENING");
    JLabel labelbutton;
    JButton button = new JButton("Login");
    JButton button3 = new JButton("Registered list");
    JButton button2 = new JButton("Add Course");
    JButton button4 = new JButton("Change Password");
    JButton button5 = new JButton("OK");

    JFrame framef = new JFrame("Registration");
    JPanel panelg = new JPanel();
    ButtonGroup G = new ButtonGroup();
    JPanel panelx = new JPanel();
    JScrollPane scrollPane = new JScrollPane();
    JPanel first = new JPanel();

    JPanel a2 = new JPanel();
    JPanel a3 = new JPanel();
    JPanel a4 = new JPanel();
    JPanel al = new JPanel();

    JList<String> liswt = new JList<String>();

    User_Interface(String title) {
        super(title);
        a4.setLayout(new BoxLayout(a4, BoxLayout.Y_AXIS));
        txt1.addActionListener(this);
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        txtaa.addActionListener(this);
        txtaaa.addActionListener(this);
        txt4.addActionListener(this);
        rb1.addActionListener(this);
        rb2.addActionListener(this);

        button5.addActionListener(this);

        setLayout(new FlowLayout());
        setSize(322, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

        first.add(lbl1);
        first.add(txt1);
        al.add(lbl2);
        al.add(txt2);
        a2.add(lbl3);
        a2.add(txt4);
        a3.add(button);
        pd.add(lblud);
        a4.add(pd);
        a4.add(first);
        a4.add(al);
        a4.add(a2);
        a4.add(a3);

        add(a4);

        String directoryname = "E:\\ProjectDataBase";
        String Filename = "Database.txt";
        File file = new File(directoryname, Filename);
        FileReader fr = null;

        try {
            fr = new FileReader(file);
        } catch (Exception eGx) {

        }

        Scanner in = new Scanner(fr);

        while (in.hasNext()) {
            for (int i = 0; i < 4; i++) {

                ob2[i] = in.nextLine();

            }
        }

        cb.setEditable(true);
        cb.setSelectedItem("List of courses");
        cb.setEditable(false);

        cb.setPreferredSize(new Dimension(300, 20));

        panelg.add(cb);
        framef.setLayout(new FlowLayout());
        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        framef.setSize(425, 415);

        framef.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JPanel lePanel = new JPanel();
        lePanel.setBorder(new TitledBorder(new EtchedBorder(), "Information Display"));
        //JTextArea display = new JTextArea ( 4, 30 );
        display.setEditable(true);
        JScrollPane scroll = new JScrollPane(display);

        lePanel.add(scroll);

        p3.add(button2);
        p3.add(button3);
        p3.add(button4);
        p1.add(rb1);
        p1.add(rb2);
        p2.add(p1);
        p2.add(panelx);
        JPanel p5 = new JPanel();
        p5.add(lblu);
        p4.add(p5);
        p4.add(panelg);

        p4.add(p2);
        p4.add(p3);
        p4.add(lePanel);
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        framef.add(p4);

        G.add(rb1);
        G.add(rb2);

        func3();

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == button) {
            username = txt1.getText();
            ID = txt2.getText();

            String lem = txt4.getText();

            String merger = "";
            merger = username.concat(ID);

            merger = merger.concat(lem);

            int flag = 0;
            for (int i = 0; i < 4; i++) {

                if (merger.equals(ob2[i])) {

                    func2();
                    flag = 1;
                }
            }

            if (flag == 0) {
                JOptionPane.showMessageDialog(null, "Entered infomation is wrong", "Invalid Information",
                        JOptionPane.ERROR_MESSAGE);

            }

        }
        if (ae.getSource() == button2) {

            String data = ""
                    + cb.getItemAt(cb.getSelectedIndex()) + " ";

            String s2 = "null";
            String s2_words[];

            s2_words = s2.split("\\s");

            String s1_words[] = data.split("\\s");
            int num_words = s2_words.length;

            if (num_words == s2_words.length) {
                for (int i = 0; i < num_words; i++) {

                    k = s1_words[i].equals(s2_words[i]);

                }
            }

            if ((rb1.isSelected() ^ rb2.isSelected()) && k == false && liswt.getSelectedIndex() != -1) {
                String choice = "";
                if (rb1.isSelected()) {
                    choice = rb1.getText();
                }
                if (rb2.isSelected()) {
                    choice = rb2.getText();
                }
                String s3;
                s3 = data.concat(choice);

                String dat = " " + liswt.getSelectedValue();
                String dat2 = "";
                dat2 = s3.concat(dat);

                String directoryName = "E:\\ProjectDataBase";
                String fileNameq = ID + ".txt";
                File filet = new File(directoryName, fileNameq);
                try {
                    FileWriter fwx = new FileWriter(filet, true);
                    fwx.write("\n" + dat2);

                    fwx.close();
                } catch (IOException ewx) {

                }
                //display.append("("+count+")"+dat2+" "+"added to your list"+"\n");
                display.setText(dat2 + " " + "added to the list");

                count = count + 1;

            } else {

//         JOptionPane.showMessageDialog( null, "Select all the information fields" , "ERROR",
//JOptionPane.ERROR_MESSAGE );
                display.setText("Please Select all the input fields");
            }

        }
        if (ae.getSource() == button3) {

            JPanel infopanel = new JPanel();
            infopanel.setBorder(new TitledBorder(new EtchedBorder(), "Registered Courses"));
            JTextArea display = new JTextArea(10, 30);
            display.setEditable(false);
            JScrollPane scroll = new JScrollPane(display);
            scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            infopanel.add(scroll);

            JFrame framex = new JFrame("Resgistered Course List");
            framex.add(infopanel);
            framex.pack();
            framex.setLocationRelativeTo(null);
            framex.setVisible(true);

            framex.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            String directoryname = "E:\\ProjectDataBase";
            String Filename = ID + ".txt";
            File file = new File(directoryname, Filename);
            FileReader fr = null;

            try {
                fr = new FileReader(file);
            } catch (Exception eGx) {

            }

            Scanner in = new Scanner(fr);
            String s4 = "";
            while (in.hasNext()) {
                String input = in.nextLine();

                s4 = s4.concat(input + "\n");

            }
            display.setText(s4);

        }
        if (ae.getSource() == button4) {

            JFrame frame3 = new JFrame("Change Password");

            JLabel oldp = new JLabel("Old Password: ");
            JLabel newp = new JLabel("New Password: ");
            JPanel panelp = new JPanel();
            JPanel panelq = new JPanel();
            JPanel paneld = new JPanel();
            JPanel panelv = new JPanel();

            panelp.add(oldp);
            panelp.add(txtaa);
            panelq.add(newp);
            panelq.add(txtaaa);

            paneld.add(panelp);
            paneld.add(panelq);
            paneld.add(button5);

            frame3.setSize(300, 140);

            frame3.setVisible(true);
            frame3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame3.setLayout(new FlowLayout());
            frame3.add(paneld);
            paneld.setLayout(new BoxLayout(paneld, BoxLayout.Y_AXIS));

        }
        if (ae.getSource() == button5) {

            int flag = 0;
            String oldpass = "";
            String newpass = "";
            String after_change = "";
            String wri = "";
            oldpass = txtaa.getText();
            newpass = txtaaa.getText();
            String checker = "";
            checker = username.concat(ID);
            checker = checker.concat(oldpass);
            for (int i = 0; i < 4; i++) {
                if (checker.equals(ob2[i])) {
                    after_change = checker.replace(oldpass, newpass);
                    flag = 1;
                }
            }
            if (flag == 1) {
                JOptionPane.showMessageDialog(null, "Password changed successfully", "Success",
                        JOptionPane.INFORMATION_MESSAGE);

                String directoryname = "E:\\ProjectDataBase";
                String Filename = "Database.txt";
                File file = new File(directoryname, Filename);
                FileReader fr = null;

                try {
                    fr = new FileReader(file);
                } catch (Exception eGx) {

                }

                Scanner in = new Scanner(fr);
                String sq = "";
                while (in.hasNext()) {
                    String input = in.nextLine();

                    sq = sq.concat(input + "\n");

                }
                wri = sq.replace(checker, after_change);
                String directoryName = "E:\\ProjectDataBase";
                String fileNameq = "Database.txt";
                File filet = new File(directoryName, fileNameq);
                try {
                    FileWriter fwx = new FileWriter(filet);
                    fwx.write(wri);

                    fwx.flush();
                    fwx.close();
                } catch (IOException ewx) {

                }

            } else {
                JOptionPane.showMessageDialog(null, "The given password doesn't match with the old password", "Password Mismatch",
                        JOptionPane.ERROR_MESSAGE);
            }

        }

    }

    public String[] func1() {

        String directorsyname = "E:\\ProjectDataBase";
        String Filensame = "CourseList.txt";
        File files = new File(directorsyname, Filensame);
        FileReader frs = null;

        try {
            frs = new FileReader(files);
        } catch (Exception eGx) {

        }

        Scanner ins = new Scanner(frs);
        String ob3[] = new String[12];

        while (ins.hasNext()) {
            for (int i = 0; i < 12; i++) {
                ob3[i] = ins.nextLine();

            }
        }
        return ob3;
    }

    public void func2() {

        String directoryName = "E:\\ProjectDataBase";
        String fileNameq = ID + ".txt";
        File filet = new File(directoryName, fileNameq);
        try {
            FileWriter fwx = new FileWriter(filet);
            fwx.write("Name: " + username + " ID: " + ID);

            fwx.flush();
            fwx.close();
        } catch (IOException ewx) {

        }

        framef.setVisible(true);

    }

    public void func3() {

        List<String> myList = new ArrayList<>(10);
        for (char index = 65; index < 75; index++) {
            myList.add("Section " + index);
        }
        JList<String> list = new JList<String>(myList.toArray(new String[myList.size()]));
        list.setPreferredSize(new Dimension(80, 180));
        liswt = list;
        scrollPane.setViewportView(list);
        list.setLayoutOrientation(JList.VERTICAL);
        panelx.add(scrollPane);

    }
}
