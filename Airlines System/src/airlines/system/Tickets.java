/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package airlines.system;

/**
 *
 * @author Sushma
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Tickets extends JFrame{
    private JTextField textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
        new Tickets();
    }
    
    public Tickets() {
        initialize();
    }
    
    private void initialize() {
        setTitle("TICKET BOOKING");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Ticket = new JLabel("TICKET BOOKING");
	Ticket.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Ticket.setBounds(185, 24, 259, 38);
	add(Ticket);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines/system/icons/ticket.PNG"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
        
        JLabel Name = new JLabel("NAME");
	Name.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Name.setBounds(60, 150, 150, 27);
	add(Name);
		
	JLabel FlightCode = new JLabel("FLIGHT CODE");
	FlightCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	FlightCode.setBounds(60, 200, 180, 27);
	add(FlightCode);
		
	JLabel ClassCode = new JLabel("CLASS CODE");
	ClassCode.setFont(new Font("Tahoma", Font.PLAIN, 17));
	ClassCode.setBounds(60, 250, 150, 27);
	add(ClassCode);
        
        JLabel JnyDate = new JLabel("JOURNEY DATE");
	JnyDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	JnyDate.setBounds(60, 300, 150, 27);
	add(JnyDate);

   		
	JButton Tickets = new JButton("SAVE");
	Tickets.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Tickets.setBackground(Color.BLACK);
        Tickets.setForeground(Color.WHITE);
	Tickets.setBounds(250, 350, 150, 30);
	add(Tickets);
        
        
        textField_1 = new JTextField();
	textField_1.setBounds(250, 150, 150, 27);
	add(textField_1);
		
	textField_2 = new JTextField();
	textField_2.setBounds(250, 200, 150, 27);
	add(textField_2);
	
        textField_3 = new JTextField();
	textField_3.setBounds(250, 250, 150, 27);
	add(textField_3);
		
	textField_4 = new JTextField();
	textField_4.setBounds(250, 300, 150, 27);
	add(textField_4);
        
        
        Tickets.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
		String name = textField_1.getText();
		String flight_code = textField_2.getText();
		String class_code = textField_3.getText();
                String journey_date = textField_4.getText();
                
                try{
                    Conn c = new Conn();
                    String str = "INSERT INTO tickets values('"+name+"','"+flight_code+"','"+class_code+"','"+journey_date+"')";
                    
                    c.s.executeUpdate(str);
                    JOptionPane.showMessageDialog(null,"Ticket Booked");
                    setVisible(false);

                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        );
        setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}
