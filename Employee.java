package rentawheel;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Employee{
    private JPanel Mainwindow;
    private JButton addEmployeeBtn = new JButton("Add Employee");
    private JButton viewEmployeeBtn = new JButton("View/Modify Employee Info");
    private JButton removeEmployeeBtn = new JButton("Remove Employee");
    private JButton logoutBtn = new JButton("Logout");
    
    public Employee() {
        createWindow();
        addListeners();
    }
    
    private void createWindow() {    
        Mainwindow = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 3;
        c.gridy = 3;
        Mainwindow.add(addEmployeeBtn, c);//adding add employee button
        c.gridx = 3;
        c.gridy = 4;
        Mainwindow.add(removeEmployeeBtn, c);//adding delete employee button
        c.gridx = 3;
        c.gridy = 5;
        Mainwindow.add(viewEmployeeBtn, c);//adding view all employee button
        c.gridx = 9;
        c.gridy = 9;
        Mainwindow.add(logoutBtn, c);//adding logout button
    }
    
    private void createFrame( JPanel window, JFrame frame){
    	frame.setSize(600,400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(window);
        frame.setVisible(true);	
    }
    
    private void addListeners() {
        logoutBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
	});
        
        addEmployeeBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               addEmployee();
           } 
        });
        
        removeEmployeeBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeEmployee();
           } 
        });
        
        viewEmployeeBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               viewEmployee();
           } 
        });
    }
    
    public JPanel getWindow() {
        return Mainwindow;
    }
    
    private void viewEmployee() {
        final JFrame frame = new JFrame("RAW Add Employee");//adding a frame
        JLabel lUser = new JLabel("Username:");
        final JTextField tUser = new JTextField(20);
        
        JButton searchBtn = new JButton("Search");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lUser, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(tUser, c);//adding textfield for username
        c.gridx = 0;
        c.gridy = 2;
        window.add(searchBtn, c);//adding textfield for username
        c.gridx = 1;
        c.gridy = 2;
        window.add(exitBtn, c);//adding textfield for username  
        
        searchBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String username = tUser.getText().trim();
               displayEmployee(username);
           } 
        });
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        createFrame( window, frame);
    }
    
    
    
    
    
    
    
    
    private void displayEmployee(final String username) {  
    	String initUser;
    	String initEmail;
    	
        final JFrame frame = new JFrame("RAW Displaying Employee: " + username);//adding a frame
        JLabel lUser = new JLabel("Username:");
        final JTextField tUser = new JTextField(20);
        
        JLabel lEmail = new JLabel("Email:");
        final JTextField tEmail = new JTextField(30);
        
        JLabel lFirstName = new JLabel("First Name:");
        final JTextField tFirstName = new JTextField(25);
        
        JLabel lLastName = new JLabel("Last Name:");
        final JTextField tLastName = new JTextField(25);
        
        JLabel lPhoneNumber = new JLabel("Phone Number:");
        final JTextField tPhoneNumber = new JTextField(10);
        
        JLabel lDPNumber = new JLabel("Driver's Permit:");
        final JTextField tDPNumber = new JTextField(7);
        
        JButton modifyBtn = new JButton("Save Changes");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lUser, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(tUser, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 3;
        window.add(lEmail, c);//adding email label 
        c.gridx = 1;
        c.gridy = 3;
        window.add(tEmail, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 4;
        window.add(lFirstName,c);//adding firstname label
        c.gridx = 1;
        c.gridy = 4;
        window.add(tFirstName,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 5;
        window.add(lLastName,c);//adding lastname label
        c.gridx = 1;
        c.gridy = 5;
        window.add(tLastName,c);//adding textfield label
        c.gridx = 0;
        c.gridy = 6;
        window.add(lPhoneNumber, c);//adding phone label
        c.gridx = 1;
        c.gridy = 6;
        window.add(tPhoneNumber, c);//adding textfield
        c.gridx = 0;
        c.gridy = 7;
        window.add(lDPNumber, c);//adding driverPermit label
        c.gridx = 1;
        c.gridy = 7;
        window.add(tDPNumber, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 9;
        window.add(exitBtn, c);//adding exit button
        c.gridx = 1;
        c.gridy = 9;
        window.add(modifyBtn, c);//adding modify button 
        
        Connection con = DatabaseConnection.getConnection();        
        try {
            String sql = "select * from employee where username='" + username + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            
            int count = 0;
			
			while(rs.next()){
				count = count + 1;
			}//end while
			
			//checks for one user
			if(count == 1){
				JOptionPane.showMessageDialog(null, "User Found");
				try{
					String sql = "select * from employee where username='" + username + "'";
		            Statement st = con.createStatement();
		            ResultSet rs = st.executeQuery(sql);
					
					while (rs.next()) {
						initUser = rs.getString("username");
						initEmail = rs.getString("email");
		                tUser.setText(rs.getString("username"));
		                tEmail.setText(rs.getString("email"));
		                tFirstName.setText(rs.getString("firstname"));
		                tLastName.setText(rs.getString("lastname"));
		                tPhoneNumber.setText(String.valueOf(rs.getInt("PhoneNumber")));
		                tDPNumber.setText(rs.getString("DPNumber"));
		            }
				} catch(Exception ex){
					ex.printStackTrace();
				
			     	}
				
			}
				
			//checks for duplicate users
			else if(count > 1){
				JOptionPane.showMessageDialog(null, "Duplicate User,");
				viewEmployee();
			}
			//when count == 0 (No match with user input and db data)
			else{
				JOptionPane.showMessageDialog(null, "User not found!");
				viewEmployee();
			}
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        modifyBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
        	   Connection con = DatabaseConnection.getConnection();
        	   
        	   
        	   if(tUser.getText().trim().equals(initUser) ||tEmail.getText().trim().equals(initEmail) ){
	        		 //creating an sql query
						String sql = "select username from employee where username = '"+tUser.getText().trim()+"'";
						Statement st = con.createStatement();
			            ResultSet rs = st.executeQuery(sql);
			            
						rs = st.executeQuery(sql);
						int count = 0;
						while(rs.next()){
							count = count + 1;
						}//end while
						
						//checks if username already in use
						if(count == 1){
							JOptionPane.showMessageDialog(null, "Username already in use. Try Again");
						}
						
						//creating an sql query
						sql = "select email from employee where username = '"+tEmail.getText().trim()+"'";
						rs = st.executeQuery(sql);
					    count = 0;
						while(rs.next()){
							count = count + 1;
						}//end while
						
						//checks if email already in use
						if(count == 1){
							JOptionPane.showMessageDialog(null, "Email already in use. Try Again");
				
						
					}//end try
        	   }
        	   
        	   
        	   
        	   
             
               String sql = "UPDATE employee SET username = ?," +
                            "email = ?, firstname = ?, lastname = ?," +
                            "PhoneNumber = ?, DPNumber = ? WHERE username ='" + 
                            username + "'";
               try {
                
                PreparedStatement update = con.prepareStatement(sql);
                update.setString(1, tUser.getText().trim());
                update.setString(2, tEmail.getText().trim());
                update.setString(3, tFirstName.getText().trim());
                update.setString(4, tLastName.getText().trim());
                update.setString(5, tPhoneNumber.getText().trim());
                update.setString(6, tDPNumber.getText().trim());
                update.executeUpdate();
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           } 
        });
        
        createFrame( window, frame);
    }
    
    
    
    
    
    
    
    
    
    private void removeEmployee() {
        final JFrame frame = new JFrame("RAW Remove Employee");//adding a frame
	
        JLabel lUser = new JLabel("Username:");
        final JTextField tUser = new JTextField(20);
        
        JButton saveBtn = new JButton("Save");
	JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lUser, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(tUser, c);//adding textfield for username
        c.gridx = 0;
        c.gridy = 2;
        window.add(saveBtn, c);//adding textfield for username
        c.gridx = 1;
        c.gridy = 2;
        window.add(exitBtn, c);//adding textfield for username
        
        saveBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String username = tUser.getText().trim();
               Connection con = DatabaseConnection.getConnection();
               	String sql = "select username from employee where username = '"+tUser.getText().trim()+"'";
				Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
				rs = st.executeQuery(sql);
				int count = 0;
				while(rs.next()){
					count = count + 1;
				}//end while
				
				//checks if username already in use
				if(count == 0){
					JOptionPane.showMessageDialog(null, "This user was not found in DB. Try Again");
				}
				
				if(count == 1){
					sql = "delete from employee where username='" + username + "'";
		               try {
		                   st = con.createStatement();
		                   st.executeQuery(sql);
		               } catch (Exception ex) {
		                   ex.printStackTrace();
		               }               
					
				}
               
                
           } 
        });
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        createFrame(window, frame);
    }
    
    
    
    
    
    
    
    
    
    
    
    private void addEmployee() {
        final JFrame frame = new JFrame("RAW Add Employee");//adding a frame
        JLabel lUser = new JLabel("Username:");
        JLabel lPassword = new JLabel("Password:");
	
        JTextField tUser = new JTextField(20);
        JPasswordField tPassword = new JPasswordField(20);
        
        JLabel lEmail = new JLabel("Email:");
        JTextField tEmail = new JTextField(30);
        
        JLabel lFirstName = new JLabel("First Name:");
        JTextField tFirstName = new JTextField(25);
        
        JLabel lLastName = new JLabel("Last Name:");
        JTextField tLastName = new JTextField(25);
        
        JLabel lPhoneNumber = new JLabel("Phone Number:");
        JTextField tPhoneNumber = new JTextField(10);
        
        JLabel lDPNumber = new JLabel("Driver's Permit:");
        JTextField tDPNumber = new JTextField(7);
        
        JButton saveBtn = new JButton("Save");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lUser, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(tUser, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 2;
        window.add(lPassword, c);//adding password label
        c.gridx = 1;
        c.gridy = 2;
        window.add(tPassword, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 3;
        window.add(lEmail, c);//adding email label 
        c.gridx = 1;
        c.gridy = 3;
        window.add(tEmail, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 4;
        window.add(lFirstName,c);//adding firstname label
        c.gridx = 1;
        c.gridy = 4;
        window.add(tFirstName,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 5;
        window.add(lLastName,c);//adding lastname label
        c.gridx = 1;
        c.gridy = 5;
        window.add(tLastName,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 6;
        window.add(lPhoneNumber, c);//adding phone label
        c.gridx = 1;
        c.gridy = 6;
        window.add(tPhoneNumber, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 7;
        window.add(lDPNumber, c);//adding sriverPermit label
        c.gridx = 1;
        c.gridy = 7;
        window.add(tDPNumber, c);//adding textfield label
        c.gridx = 0;
        c.gridy = 9;
        window.add(saveBtn, c);//adding save button
        c.gridx = 1;
        c.gridy = 9;
        window.add(exitBtn, c);//adding exit button
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        saveBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

                String Username = tUser.getText().trim();
                String FirstName = tFirstName.getText().trim();
                @SuppressWarnings("deprecation")
                String Password = tPassword.getText().trim();
                String Email = tEmail.getText().trim();
                String LastName = tLastName.getText().trim();
                String PhoneNumber = tPhoneNumber.getText().trim();
                String DPNumber = tDPNumber.getText().trim();
                
                Connection con = DatabaseConnection.getConnection()
				
				
				
				try{
			
					//creating an sql query
					String sql = "select username from employee where username = '"+Username+"'";
					Statement st = con.createStatement();
	 	            ResultSet rs = st.executeQuery(sql);
	 	            
					int count = 0;
					
					while(rs.next()){
						count = count + 1;
					}//end while
					
					//checks if username already in use
					if(count == 1){
						JOptionPane.showMessageDialog(null, "Username already in use. Try Again");
			
					}
					
					
					
					//creating an sql query
					 sql = "select email from employee where username = '"+Email+"'";
					
					rs = st.executeQuery(sql);
					
					 count = 0;
					
					while(rs.next()){
						count = count + 1;
					}//end while
					
					//checks if email already in use
					if(count == 1){
						JOptionPane.showMessageDialog(null, "Email already in use. Try Again");
			
					
				}//end try
				}
								
				catch(Exception ex){
					
				}//end catch
				
				
				try{
				// add new employee to database
				String sql = "INSERT INTO employee (firstname, lastname)" +
				        "VALUES (?, ?)";
				
		
				
				PreparedStatement preparedStatement = con.prepareStatement(sql);
				preparedStatement.setString(1, FirstName);
				preparedStatement.setString(2, LastName);
				preparedStatement.executeUpdate(); 
				
				
				
				}
				catch(Exception ex){
					
					}//end catch
				
				
			}
		});//end b action
        
        createFrame( window, frame);
    }
}
