package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame implements ActionListener {
    String username;
    JButton addpersonaldetails , destinations , viewpersonaldetails , updatepersonaldetails , checkpackages , bookhotels , bookpackage , viewpackage , viewhotels;

    Dashboard( String username){
        this.username = username;
     // setBounds(0,0,1600,1000);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(Color.PINK);
        p1.setBounds(0,0,1600,65);
        add(p1);

        ImageIcon   i1  =  new ImageIcon(ClassLoader.getSystemResource("com/company/icons/dashboard.png")) ;
        //To avoid zoomed in image , we need to scale image and pass it in JLabel but we can't pass it in Jlabel directly
        Image i2 = i1.getImage().getScaledInstance(70,70,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel icon = new JLabel(i3);  // indirectly i2 is passed into Jlabel
        icon.setBounds(5,0,70,70);

        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80,10,300,40);
        heading.setForeground(Color.RED);
        heading.setFont(new Font("Tahoma" , Font.BOLD , 30));
        p1.add(heading);

        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(Color.PINK);
        p2.setBounds(0,65,300,900);
        add(p2);

        addpersonaldetails = new JButton("Add Personal Details");
        addpersonaldetails.setBounds(0,0,300,50);
        addpersonaldetails.setBackground(Color.pink);
        addpersonaldetails.setForeground(Color.BLACK);
        addpersonaldetails.setMargin(new Insets(0,0,0,60));
        addpersonaldetails.setFont(new Font("Tahoma" , Font.BOLD , 15));
        addpersonaldetails.addActionListener(this);
        p2.add(addpersonaldetails);

        updatepersonaldetails = new JButton("Update Personal Details");
        updatepersonaldetails.setBounds(0,50,300,50);
        updatepersonaldetails.setBackground(Color.pink);
        updatepersonaldetails.setForeground(Color.BLACK);
        updatepersonaldetails.setMargin(new Insets(0,0,0,50));
        updatepersonaldetails.setFont(new Font("Tahoma" , Font.BOLD , 15));
        updatepersonaldetails.addActionListener(this);
        p2.add(updatepersonaldetails);

        viewpersonaldetails = new JButton("View Personal Details");
        viewpersonaldetails.setBounds(0,100,300,50);
        viewpersonaldetails.setBackground(Color.pink);
        viewpersonaldetails.setForeground(Color.BLACK);
        viewpersonaldetails.setMargin(new Insets(0,0,0,60));
        viewpersonaldetails.setFont(new Font("Tahoma" , Font.BOLD , 15));
        viewpersonaldetails.addActionListener(this);
        p2.add(viewpersonaldetails);

        JButton deletepersonaldetails = new JButton("Delete Personal Details");
        deletepersonaldetails.setBounds(0,150,300,50);
        deletepersonaldetails.setBackground(Color.pink);
        deletepersonaldetails.setForeground(Color.BLACK);
        deletepersonaldetails.setMargin(new Insets(0,0,0,50));
        deletepersonaldetails.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(deletepersonaldetails);

        checkpackages = new JButton("Check Packages");
        checkpackages.setBounds(0,200,300,50);
        checkpackages.setBackground(Color.pink);
        checkpackages.setForeground(Color.BLACK);
        checkpackages.setMargin(new Insets(0,0,0,110));
        checkpackages.setFont(new Font("Tahoma" , Font.BOLD , 15));
        checkpackages.addActionListener(this);
        p2.add(checkpackages);

        bookpackage = new JButton("Book Package");
        bookpackage.setBounds(0,250,300,50);
        bookpackage.setBackground(Color.pink);
        bookpackage.setForeground(Color.BLACK);
        bookpackage.setMargin(new Insets(0,0,0,120));
        bookpackage.setFont(new Font("Tahoma" , Font.BOLD , 15));
        bookpackage.addActionListener(this);
        p2.add(bookpackage);

        viewpackage = new JButton("View Package");
        viewpackage.setBounds(0,300,300,50);
        viewpackage.setBackground(Color.pink);
        viewpackage.setForeground(Color.BLACK);
        viewpackage.setMargin(new Insets(0,0,0,120));
        viewpackage.setFont(new Font("Tahoma" , Font.BOLD , 15));
        viewpackage.addActionListener(this);
        p2.add(viewpackage);

        viewhotels = new JButton("View Hotels");
        viewhotels.setBounds(0,350,300,50);
        viewhotels.setBackground(Color.pink);
        viewhotels.setForeground(Color.BLACK);
        viewhotels.setMargin(new Insets(0,0,0,130));
        viewhotels.setFont(new Font("Tahoma" , Font.BOLD , 15));
        viewhotels.addActionListener(this);
        p2.add(viewhotels);

         bookhotels = new JButton("Book Hotels");
        bookhotels.setBounds(0,400,300,50);
        bookhotels.setBackground(Color.pink);
        bookhotels.setForeground(Color.BLACK);
        bookhotels.setMargin(new Insets(0,0,0,130));
        bookhotels.setFont(new Font("Tahoma" , Font.BOLD , 15));
        bookhotels.addActionListener(this);
        p2.add(bookhotels);

        JButton viewbookedhotels = new JButton("View Booked Hotels");
        viewbookedhotels.setBounds(0,450,300,50);
        viewbookedhotels.setBackground(Color.pink);
        viewbookedhotels.setForeground(Color.BLACK);
        viewbookedhotels.setMargin(new Insets(0,0,0,70));
        viewbookedhotels.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(viewbookedhotels);

        destinations = new JButton("Destinations");
        destinations.setBounds(0,500,300,50);
        destinations.setBackground(Color.pink);
        destinations.setForeground(Color.BLACK);
        destinations.setMargin(new Insets(0,0,0,125));
        destinations.setFont(new Font("Tahoma", Font.BOLD , 15));
        destinations.addActionListener(this);
        p2.add(destinations);

        JButton payments = new JButton("Payments");
        payments.setBounds(0,550,300,50);
        payments.setBackground(Color.pink);
        payments.setForeground(Color.BLACK);
        payments.setMargin(new Insets(0,0,0,150));
        payments.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(payments);

        JButton calculator = new JButton("Calculator");
        calculator.setBounds(0,600,300,50);
        calculator.setBackground(Color.pink);
        calculator.setForeground(Color.BLACK);
        calculator.setMargin(new Insets(0,0,0,145));
        calculator.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(calculator);

        JButton notepad = new JButton("Notepad");
        notepad.setBounds(0,650,300,50);
        notepad.setBackground(Color.pink);
        notepad.setForeground(Color.BLACK);
        notepad.setMargin(new Insets(0,0,0,150));
        notepad.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(notepad);

        JButton about = new JButton("About");
        about.setBounds(0,700,300,50);
        about.setBackground(Color.pink);
        about.setForeground(Color.BLACK);
        about.setMargin(new Insets(0,0,0,165));
        about.setFont(new Font("Tahoma" , Font.BOLD , 15));
        p2.add(about);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/home.jpg"));
        Image i5 = i4.getImage().getScaledInstance(1650,1000,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image = new JLabel(i6);image.setBounds(0,0,1650,1000);
        add(image);

        JLabel text = new JLabel("Travel And Tourism Management System") ;
        text.setBounds(400,70,1200,70);
        text.setForeground(Color.BLACK);
        text.setFont(new Font("Raleway",Font.PLAIN , 40));
        image.add(text);

        setVisible(true);


    }
    public void actionPerformed (ActionEvent ae)
    {
        if (ae.getSource() == addpersonaldetails)
        {
            new  AddPersonalDetails(username);
        }
        else  if (ae.getSource() == viewpersonaldetails)
        {
            new ViewCustomer(username);
        }
        else  if (ae.getSource() == updatepersonaldetails)
        {
            new UpdatePersonalDetails(username);
        }
        else  if (ae.getSource() == checkpackages)
        {
            new CheckPackage();
        }
        else  if (ae.getSource() == bookpackage)
        {
            new BookPackage(username);
        }
        else  if (ae.getSource() == viewpackage)
        {
            new ViewPackage(username);
        }
        else  if (ae.getSource() == viewhotels)
        {
            new CheckHotels();
        }
        else  if (ae.getSource() == destinations)
        {
            new Destinations();
        }
        else  if (ae.getSource() == bookhotels)
        {
            new BookHotel("");
        }
    }
    public static void main(String[] args)
    {
        new Dashboard("");
    }
}
