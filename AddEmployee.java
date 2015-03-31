package test;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;//imported for positioning
import java.awt.Insets;
import java.awt.event.*;
import java.sql.*;//needed b/c we need to connect to db and do sql queries

public class Employee {
	Connection con;
	Statement st;
	ResultSet rs;
	JFrame f = new JFrame("RAW Employee Modification");//adding a frame
	JButton b = new JButton("Add Employee");
	JButton b1 = new JButton("Delete Employee");
	JButton b2 = new JButton("View All Employees");
	JButton b3 = new JButton("Modify Employee");
	JButton b4 = new JButton("Search Employee Info");
	JButton b5 = new JButton("Logout");

	//Login constructor
	public Member(){
		connect();
		frame();
		
	}
	
	//creates a connection to the rent a wheel db
	public void connect(){
				
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rentawheeldb","root",null);
			st = con.createStatement();//creates a statement so we could access a table in our db
		} 
		catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//database -> jdbc:mysql://localhost:3306/rentawheeldb
		//user -> root
		//password -> null
		
	}//end connect



		//creates a login window for users to enter thr application
	public void frame(){
		
		f.setSize(600,400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		JPanel window = new JPanel(new GridBagLayout());//creating Jpanel for addition of items named window	
		
		GridBagConstraints c = new GridBagConstraints();
		
		c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
		c.gridx = 3;
		c.gridy = 3;
		window.add(b,c);//adding add member button
		c.gridx = 3;
		c.gridy = 4;
		window.add(b1,c);//adding delete member button
		c.gridx = 3;
		c.gridy = 5;
		window.add(b2,c);//adding view all employees button
		c.gridx = 3;
		c.gridy = 6;
		window.add(b3,c);//adding modify employee button
		c.gridx = 3;
		c.gridy = 7;
		window.add(b4,c);//adding search employee button
		c.gridx = 9;
		c.gridy = 9;
		window.add(b5,c);//adding logout button
		
		f.add(window);//adds alls, textfields and button to the JFrame
		
		
		
		
		
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
			
			}
		});//end b action
		
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
			}
		});//end b1 action
		
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
			}
		});//end b2 action
		
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
			}
		});//end b3 action
		
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				new Login();
			}
		});//end b4 action
        
        

		
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});//end b5 action
		
	}//end frame
	
	public static void main(String[] args){
		
		new Employee();
		
	}//end main
}
