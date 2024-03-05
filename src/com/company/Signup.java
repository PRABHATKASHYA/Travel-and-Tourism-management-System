package com.company;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class Signup extends JFrame implements ActionListener {

    JButton create, back;
    JTextField tfname , tfusername ,tfpswrd , tfans;
    Choice question;

    Signup()
    {setBounds(350,200,900,360);

        getContentPane().setBackground(Color.WHITE); // making whole frame color as white
        setLayout(null);

        JPanel p1 =new JPanel();
        p1.setBackground(new Color(133,193,233));
        p1.setBounds(0,0,500,400);
        p1.setLayout(null);
        add(p1);

        JLabel lblusername = new JLabel("Username :");
        lblusername.setBounds(50,20,125,25);
        lblusername.setFont( new Font("SERIF",Font.BOLD, 14));
        p1.add(lblusername);
         tfusername = new JTextField();
        tfusername.setBounds(190,20,180,25);
        tfusername.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfusername);

        JLabel lblname = new JLabel(" Name :");
        lblname.setBounds(50,60,125,25);
        lblname.setFont( new Font("SERIF",Font.BOLD, 14));
        p1.add(lblname);
         tfname = new JTextField();
        tfname.setBounds(190,60,180,25);
        tfname.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfname);

        JLabel lblpswrd = new JLabel("Password :");
        lblpswrd.setBounds(50,100,125,25);
        lblpswrd.setFont( new Font("SERIF",Font.BOLD, 14));
        p1.add(lblpswrd);
         tfpswrd = new JTextField();
        tfpswrd.setBounds(190,100,180,25);
        tfpswrd.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfpswrd);

        JLabel lblque = new JLabel("Security Question :");
        lblque.setBounds(50,140,125,25);
        lblque.setFont( new Font("SERIF",Font.BOLD, 14));
        p1.add(lblque);

        //ADDING DROPDOWN MENU
        question = new Choice();
        question.add("Favourite Character from The Boys");
        question.add("Favourite Marvel SuperHero");
        question.add("Favourite Movie");
        question.setBounds(190,140,180,25);
        p1.add(question);

        JLabel lblans = new JLabel("Answer :");
        lblans.setBounds(50,180,125,25);
        lblans.setFont( new Font("SERIF",Font.BOLD, 14));
        p1.add(lblans);
        tfans = new JTextField();
        tfans.setBounds(190,180,180,25);
        tfans.setBorder(BorderFactory.createEmptyBorder());
        p1.add(tfans);

        create = new JButton("Create User");
        create.setBounds(80,250,100,30);
        create.setBackground(Color.WHITE);
        create.setForeground((new Color(133,193,233)));
        create.setBorder(new LineBorder(new Color(133,193,233)));
        create.addActionListener(this);
        p1.add(create);

        back = new JButton("Back");
        back.setBounds(250,250,100,30);
        back.setBackground(Color.WHITE);
        back.setForeground((new Color(133,193,233)));
        back.setBorder(new LineBorder(new Color(133,193,233)));
        back.addActionListener(this);
        p1.add(back);

        ImageIcon   i1  =  new ImageIcon(ClassLoader.getSystemResource("com/company/icons/signup.png")) ;
        //To avoid zoomed in image , we need to scale image and pass it in JLabel but we can't pass it in Jlabel directly
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  // indirectly i2 is passed into Jlabel
        image.setBounds(580,50,250,250);

       add(image);

        setVisible(true);

    }
    //what to perform using data into database
    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == create)
        {
            String username = tfusername.getText();
            String name = tfname.getText();
            String password = tfpswrd.getText();
            String security = question.getSelectedItem();
            String answer = tfans.getText();
            //now we need to insert these info in the table of mysql
            String query = "insert into account values('"+username+"', '"+name+"', '"+password+"', '"+security+"', '"+answer+"' )";
            try{ // first establish connection with this signup page
                Conn c = new Conn();
                c.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created Successfully");
                setVisible(false); //when we click on ok => close current frame
                new Login();
            }catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        else
        if (ae.getSource() == back)
        {setVisible(false);//close current frame
            new Login();
        }
    }
    public static void main(String[] args) {
      Signup s = new Signup();
    }
}
