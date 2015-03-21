package test;

import javax.swing.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;//imported for positioning
import java.awt.Insets;
import java.awt.event.*;
import java.sql.*;//needed b/c we need to connect to db and do sql queries

public class Login {
	
	Connection con;
	Statement st;
	ResultSet rs;
	
	JFrame f = new JFrame("RAW User Login");//adding a frame
	JLabel l = new JLabel("Username:");
	JLabel l1 = new JLabel("Password:");
	JTextField t = new JTextField(10);
	JPasswordField t1 = new JPasswordField(10);
	JButton b = new JButton("Login");
	JButton b1 = new JButton("Exit");
	
	
	//Login constructor
	public Login(){
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
		c.gridx = 0;
		c.gridy = 1;
		window.add(l,c);//adding username label 
		c.gridx = 1;
		c.gridy = 1;
		window.add(t,c);//adding textfield for username
		c.gridx = 0;
		c.gridy = 2;
		window.add(l1,c);//adding password label
		c.gridx = 1;
		c.gridy = 2;
		window.add(t1,c);//adding textfield label
		c.gridx = 8;
		c.gridy = 3;
		window.add(b,c);//adding login button
		c.gridx = 9;
		c.gridy = 3;
		window.add(b1,c);//adding exit button
		
		f.add(window);//adds all the labels, textfields and button to the JFrame
	
	
		b.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try{
					String user = t.getText().trim();
					@SuppressWarnings("deprecation")
					String pass = t1.getText().trim();
					
					//creating an sql query
					String sql = "select username,password from employee where username = '"+user+"' and password = '"+pass+"'";
					
					rs = st.executeQuery(sql);
					
					int count = 0;
					
					while(rs.next()){
						count = count + 1;
					}//end while
					
					//checks for one user
					if(count == 1){
						JOptionPane.showMessageDialog(null, "User Found, Access Granted!");
					}
					//checks for duplicate users
					else if(count > 1){
						JOptionPane.showMessageDialog(null, "Duplicate User, Access Denied!");
					}
					//when count == 0 (No match with user input and db data)
					else{
						JOptionPane.showMessageDialog(null, "User not found!");
					}
				}//end try
								
				catch(Exception ex){
					
				}//end catch					
				
			}
		});//end b action
		
		b1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});//end b1 action
		
	}//end frame
	
	public static void main(String[] args){
		
		new Login();
		
	}//end main
}
