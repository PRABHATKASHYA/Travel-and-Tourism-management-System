package com.company;

import javax.swing.*;
import java.awt.* ;
//JFrame is a component of swing package
public  class Splash extends JFrame implements Runnable
//to use setsize(), we need to create string objects,to avoid this we extended splash by JFrame
//TO USE MULTITHREADING CONCPT -> EXTEND SPLASH WITH THREAD CLASS BUT MULTIPLE INHERITANCE IS NOT ALLOWED -> IMPLEMENT RUNNABLE CLASS
{
   Thread thread ;

    Splash()  //constructors
    {
      /* setSize(1200,600);   //creating a frame of given size
        setLocation(200,100);     // now frame opens at the centre of the screen
     */ //commands are commented out bcuz we don t want to hard code the SIZE AND LOCATION OF THE FRAME , it must change dynamically


        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/company/icons/splash.jpg")) ;

        // To avoid zoomed in image , we need to scale image and pass it in JLabel but we can't pass it in Jlabel directly
        Image i2 = i1.getImage().getScaledInstance(1200,600,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);  // indirectly i2 is passed into Jlabel
        add(image)    ;   // To place JLabel on frame

       setVisible(true);      //setting visibility as true . cuz default visibility is hidden
              // now frame opens at left top (origin) -> to avoid that we use setLocation
        thread = new Thread(this) ;
        thread.start(); //internally calls run method -> it behaves like a multihthreaded function
    }

    public void run() {
        try {
            Thread.sleep(7000); //to hold i1 image on screen  for 7 sec
           // new login();
            setVisible(false);
            new Login();

        } catch (Exception e){} ;
    }

    public static void main(String[] args) {
        Splash frame = new Splash();  //as we run the class, we want that the frame to be opened
        int x = 1 ;
        for (int i=1 ; i <= 500 ; x+=7 , i+=6)
        {
            frame.setLocation(750 - (x+i)/2,400 - (i/2)); // such location is given to open the img at the centre
            frame.setSize(x+i,i);
            try {
                Thread.sleep(50); // just to give a pause of 10 milli sec  while the transition process of opening of i1 img
            }
            catch (Exception e){}



        }


    }
}
