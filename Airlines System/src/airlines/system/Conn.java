/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.system;

import java.sql.*;

/**
 *
 * @author Sushma
 */
public class Conn {
   Connection c;
    Statement s;
    public Conn(){  
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/airlines","root","root");   
            s =c.createStatement(); 
           
            }catch(Exception e){
                System.out.println(e);
        }  
    } 
}
