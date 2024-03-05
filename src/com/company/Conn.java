package com.company;
import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    Conn()
    {
 //for jdbc connectivity - 1st step is register the driver of mysql
        //since mysql is an external entity there can be exception at runtime -> Requires Exception Handling
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
   //Step2. Creating the connection string :
            c = DriverManager.getConnection("jdbc:mysql:///travelmanagementsystem", "root","Sumesh@123");
   //Step3. creating statement
            s = c.createStatement();

        } catch (Exception e){
            e.printStackTrace(); //printing the exception
        }

    }
}
