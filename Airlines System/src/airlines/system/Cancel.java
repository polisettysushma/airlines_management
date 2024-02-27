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

public class Cancel extends JFrame {
    private JTextField textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
        new Cancel();
    }
    
    public Cancel() {
        initialize();
    }
    
    private void initialize() {
        setTitle("CANCELLATION");
	getContentPane().setBackground(Color.WHITE);
	setBounds(100, 100, 801, 472);
	setLayout(null);
		
	JLabel Cancellation = new JLabel("CANCELLATION");
	Cancellation.setFont(new Font("Tahoma", Font.PLAIN, 31));
	Cancellation.setBounds(185, 24, 259, 38);
	add(Cancellation);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airlines/system/icons/cancel.jpg"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
	NewLabel.setBounds(470, 100, 250, 250);
	add(NewLabel);
		
	JLabel CancellationNo = new JLabel("CANCELLATION NO");
	CancellationNo.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationNo.setBounds(60, 150, 150, 27);
	add(CancellationNo);
		
	JLabel CancellationDate = new JLabel("CANCELLATION DATE");
	CancellationDate.setFont(new Font("Tahoma", Font.PLAIN, 17));
	CancellationDate.setBounds(60, 200, 180, 27);
	add(CancellationDate);
		
	JLabel Ticketid = new JLabel("TICKET_ID");
	Ticketid.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Ticketid.setBounds(60, 250, 150, 27);
	add(Ticketid);
        
        JLabel Pnr_no = new JLabel("PNR_NO");
	Pnr_no.setFont(new Font("Tahoma", Font.PLAIN, 17));
	Pnr_no.setBounds(60, 300, 150, 27);
	add(Pnr_no);

   		
	JButton Cancel = new JButton("CANCEL");
	Cancel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
	Cancel.setBounds(250, 350, 150, 30);
	add(Cancel);
			
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
        
        
        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
		
		String cancel_no = textField_1.getText();
		String cancel_date = textField_2.getText();
		String ticket_id = textField_3.getText();
                String pnr_no = textField_4.getText();
         

                
		try{	
                    Conn c = new Conn();
                    String str = "INSERT INTO cancellation values( '"+cancel_no+"', '"+cancel_date+"', '"+ticket_id+"','"+pnr_no+"')";
                    String str1 = "DELETE FROM reservation where ticket_id='"+ticket_id+"'";
                    String str2 = "DELETE FROM passenger where pnr_no='"+pnr_no+"'";
                            
                    c.s.executeUpdate(str);
                    c.s.executeUpdate(str1);
                    c.s.executeUpdate(str2);
                    JOptionPane.showMessageDialog(null,"Ticket Canceled");
                    setVisible(false);
						
		}catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
			
	setSize(860,500);
	setVisible(true);
        setLocation(400,200);
    }
}
