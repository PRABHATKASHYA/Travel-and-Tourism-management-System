package com.company;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {
    JButton login , signup ,forgot ;
    JTextField tfusername , tfpswrd;


    Login(){   //creating login frame using login constructor
        setSize(900,400);
        setLocation(350,200);
        setLayout(null); // Now no panel will be visible
        getContentPane().setBackground(Color.WHITE); // making whole frame color as white

        // after frame got created we want to divide it into two equal panels , one  for image and other one  for username n psswrd
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(131,193,233)); //makes whole frame white->we need to apply layouts concept to get panel in the left portion only
        // layouts types - 1. by default ->  border layout      ,
        // 2.swing layouts -> i.flow layout- labels are displayed one after another , ii.Grid Layout- labels are displayed in a table structure
        //3. User made - we ll be applying here . for this we need to set layout as null.

        p1.setBounds(0,0,400 ,400);  //setlocation for panel -> panel appear at left side
        p1.setLayout(null);
        add(p1);
        // now we want an image at lefthandside
           ImageIcon   i1  =  new ImageIcon(ClassLoader.getSystemResource("com/company/icons/login.png")) ;
        //To avoid zoomed in image , we need to scale image and pass it in JLabel but we can't pass it in Jlabel directly
        Image i2 = i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  // indirectly i2 is passed into Jlabel
        image.setBounds(100,120,200,200);
       // add(image) ; // -> added image on the frame and not on the panel -> image hidden behind panel
        p1.add(image);
      // Now image appears on the panel
      // The next job is to create labels on the right hand side
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(400,30,450,300);
        add(p2);
        // Now we need to insert labels - done through JLabel
        JLabel lblusername = new JLabel("Username");
        lblusername.setBounds(60,20,100,25);
        lblusername.setFont( new Font("SAN SERIF",Font.PLAIN, 20));
        p2.add(lblusername);
       tfusername = new JTextField();
       tfusername.setBounds(60,60,300,30);
       tfusername.setBorder(BorderFactory.createEmptyBorder());
       p2.add(tfusername);

        JLabel lblpswrd = new JLabel("Password");
        lblpswrd.setBounds(60,110,100,25);
        lblpswrd.setFont( new Font("SAN SERIF",Font.PLAIN, 20));
        p2.add(lblpswrd);
         tfpswrd = new JTextField();
        tfpswrd.setBounds(60,150,300,30);
        tfpswrd.setBorder(BorderFactory.createEmptyBorder());
        p2.add(tfpswrd);

        login = new JButton("Login");
        login.setBounds(60,200,130,30);
        login.setBackground(new Color(133,193,233));
        login.setForeground(Color.WHITE);
        login.setBorder(new LineBorder(new Color(133,193,233)));
        login.addActionListener(this);
        p2.add(login);

        signup = new JButton("Signup");
        signup.setBounds(230,200,130,30);
        signup.setBackground(new Color(133,193,233));
        signup.setForeground(Color.WHITE);
        signup.setBorder(new LineBorder(new Color(133,193,233)));
        signup.addActionListener(this);
        p2.add(signup);

        forgot = new JButton("Forget Password");
        forgot.setBounds(130,250,130,30);
        forgot.setBackground(new Color(133,193,233));
        forgot.setForeground(Color.WHITE);
        forgot.setBorder(new LineBorder(new Color(133,193,233)));
        forgot.addActionListener(this);
        p2.add(forgot);

        JLabel text = new JLabel("Trouble in login...");
        text.setBounds(300,250,150,20);
        text.setForeground(Color.red);
        p2.add(text);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae)
    {
        if (ae.getSource() == login){
            try {
                String username = tfusername.getText();
                String password = tfpswrd.getText();

                String query = "select * from account where username = '"+username+"' AND password = '"+password+"' "  ;
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                if (rs.next())
                {
                    setVisible(false); new Loading(username) ;
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Username Or Password");
                }

            }catch (Exception e){
                e.printStackTrace();
            }

        }
        else if (ae.getSource() == signup)
        {
            setVisible(false); new Signup();
        }
        else {
            setVisible(false); new ForgetPassword();
        }
    }

    public static void main(String[] args) {
    Login l = new Login();

    }
}
