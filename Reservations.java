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

import java.sql.*;
import java.util.Calendar;
import java.util.Random;

public class Reservations{
    private JPanel Mainwindow;
    private JButton addRental = new JButton("Add Rental Reservation");
    private JButton viewRentalBtn = new JButton("View/Modify Rental Info");
    private JButton removeRentalBtn = new JButton("Remove Rental Reservation");
    private JButton viewAllBtn = new JButton("View all existing Reservations");
    private JButton logoutBtn = new JButton("Logout");
    
    public Rental() {
        createWindow();
        addListeners();
    }
    
    
    private void createWindow() {    
        Mainwindow = new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 3;
        c.gridy = 3;
        Mainwindow.add(addRental, c);//adding add rental button
        c.gridx = 3;
        c.gridy = 4;
        Mainwindow.add(removeRentalBtn, c);//adding delete rental button
        c.gridx = 3;
        c.gridy = 5;
        Mainwindow.add(viewRentalBtn, c);//adding view all rental button
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
        
        addRental.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               addRental();
           } 
        });
        
        removeRentalBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               removeRental();
           } 
        });
        
        viewRentalBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               viewRental();
           } 
        });
    }
    
    
    public JPanel getWindow() {
        return Mainwindow;
    }
    
//////////////////////////////////////////////////////////////////////////////////////////
    private void viewRental() {
        final JFrame frame = new JFrame("RAW Add Rental");//adding a frame
        JLabel lrentalID = new JLabel("Rental ID");
        final JTextField trentalID = new JTextField(20);
        
        JButton searchBtn = new JButton("Search");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lrentalID, c);//adding rental ID label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(trentalID, c);//adding textfield for rental ID
        c.gridx = 0;
        c.gridy = 2;
        window.add(searchBtn, c);//adding textfield 
        c.gridx = 1;
        c.gridy = 2;
        window.add(exitBtn, c);//adding textfield  
        
        searchBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String rentalID = trentalID.getText().trim();
               displayRental(rentalID);
           } 
        });
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        createFrame( window, frame);
    }
    
    
    
 ////////////////////////////////////////////////////////////////////////////////////////////////////   
    private void viewAllRental() {
        final JFrame frame = new JFrame("RAW Add Rental");//adding a frame
        JLabel ldate = new JLabel("Start Date");
        final JTextField tdate = new JTextField(10);
        
        JButton searchBtn = new JButton("Search");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(ldate, c);//adding rental ID label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(tdate, c);//adding textfield for rental ID
        c.gridx = 0;
        c.gridy = 2;
        window.add(searchBtn, c);//adding textfield 
        c.gridx = 1;
        c.gridy = 2;
        window.add(exitBtn, c);//adding textfield  
        
        searchBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String date = tdate.getText().trim();
               displayAllRental(date);
           } 
        });
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
        createFrame( window, frame);
    }
    
////////////////////////////////////////////////////////////////////////////////////////    
        
    private void displayRental(final String rentalID) {  
    	String initrentalID, initMemberID;
    	String initReturnedDate, initRentalCarID;
    	String initRentalDate;
		String initDueDate ;
    	
        final JFrame frame = new JFrame("RAW Displaying Rental: " + rentalID);//adding a frame
        
        JLabel lrentalID = new JLabel("Rental ID:");
        final JTextField trentalID = new JTextField(11);

        JLabel ldateRented = new JLabel("Date Rented:");
        final JTextField tdateRented = new JTextField(11);// 
        
        JLabel ldateDue = new JLabel("Date Rental Due:");
        final JTextField tdateDue = new JTextField(11);
        
        JLabel ldateReturned = new JLabel("Date Returned:");
        final JTextField tdateReturned = new JTextField(11);
        
        JLabel lmemberID = new JLabel("Member ID:");
        final JTextField tmemberID = new JTextField(11);
        
        JLabel lrentalCarID = new JLabel("Rental Car ID");
        final JTextField trentalCarID = new JTextField(11);
        
        JButton modifyBtn = new JButton("Save Changes");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lrentalID, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(trentalID, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 3;
        window.add(ldateRented, c);//adding dateRented label 
        c.gridx = 1;
        c.gridy = 3;
        window.add(tdateRented, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 4;
        window.add(ldateDue,c);//adding dateDue label
        c.gridx = 1;
        c.gridy = 4;
        window.add(tdateDue,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 5;
        window.add(ldateReturned,c);//adding dateReturned label
        c.gridx = 1;
        c.gridy = 5;
        window.add(tdateReturned,c);//adding textfield label
        c.gridx = 0;
        c.gridy = 6;
        window.add(lmemberID, c);//adding phone label
        c.gridx = 1;
        c.gridy = 6;
        window.add(tmemberID, c);//adding textfield
        c.gridx = 0;
        c.gridy = 7;
        window.add(lrentalCarID, c);//adding driverPermit label
        c.gridx = 1;
        c.gridy = 7;
        window.add(trentalCarID, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 9;
        window.add(exitBtn, c);//adding exit button
        c.gridx = 1;
        c.gridy = 9;
        window.add(modifyBtn, c);//adding modify button 
        
        
  
        
        
        Connection con = DatabaseConnection.getConnection();        
        try {
            String sql = "select * from rentaldetails where rentalID='" + rentalID + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            
            int count = 0;
			
			while(rs.next()){
				count = count + 1;
			}//end while
			
			//checks for one rentalID
			if(count == 1){
				JOptionPane.showMessageDialog(null, "Rental Reservation Found");
				try{
					 sql = "select * from rentaldetails where rentalID='" + rentalID + "'";
		             st = con.createStatement();
		             rs = st.executeQuery(sql);
					
					while (rs.next()) {
						initrentalID = rs.getString("rentalID");
						initRentalDate = rs.getString("dateRented");
						initDueDate = rs.getString("dateDue");
		                trentalID.setText(rs.getString("rentalID"));
		                tdateRented.setText(rs.getString("dateRented"));
		                tdateDue.setText(rs.getString("dateDue"));
		                tdateReturned.setText(rs.getString("dateReturned"));
		                tmemberID.setText(String.valueOf(rs.getInt("memberID")));
		                tcarID.setText(rs.getString("carID"));
		            }
				} catch(Exception ex){
					ex.printStackTrace();
				
			     	}
				
			}
				
			//checks for duplicate rentalIDs
			else if(count > 1){
				JOptionPane.showMessageDialog(null, "Duplicate reservation,");
				viewRental();
			}
			//when count == 0 (No match with rentalID input and db data)
			else{
				JOptionPane.showMessageDialog(null, "Rental Reservation not found!");
				viewRental();
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
        	   
        	   // test for atleast one form change 
        	   if (initrentalID.equals(trentalID.getText().trim()) ||
        	        	initRentalDate.equals(tdateRented.getText().trim())||
        	        	initDueDate.equals(tdateDue.getText().trim())||
        	        	initMemberID.equals(String.valueOf(tmemberID.getText().trim()))||
        	        	initRentalCarID.equals(trentalCarID.getText().trim())||
        	        	initReturnedDate.equals(tdateReturned.getText().trim())){
	        		 //creating an sql query
						String sql = "select * from rentaldetails where rentalCarID not in "
								+ "(select rentalCarID from rentaldetails where "
								+ "(dateRented <= '"+tdateRented+"' AND dateDue >= '"+tdateRented+"') OR"
								+ "(dateRented <= '"+tdateDue+"' AND dateDue >= '"+tdateDue+"') OR"
							    + "(dateRented >= '"+tdateRented+"' AND dateDue <= '"+tdateDue+"'))";
						Statement st = con.createStatement();
			            ResultSet rs = st.executeQuery(sql);
			            
						int count = 0;
						while(rs.next()){
							count = count + 1;
						}//end while
						
						//This vehicle has other rentals
						if(count != 0){
						     Calendar calendar = Calendar.getInstance();
						     java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());
							JOptionPane.showMessageDialog(null, "This vehicles have other upcoming rentals");
						}
						
						//creating an sql query
						sql = "select dateRented from rentaldetails where rentalID = '"+tdateRented.getText().trim()+"'";
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
        	   
        	   
        	   
        	   
             // rental ID is never changeable by anyone 
               String sql = "UPDATE rentaldetails SET dateRented = ?," +
                            "dateDue = ?, dateReturned = ?," +
                            "memberID = ?, rentalCarID = ? WHERE rentalID ='" + 
                            rentalID + "'";
               try {
                
                PreparedStatement update = con.prepareStatement(sql);
                update.setString(1, trentalID.getText().trim());
                update.setString(2, tdateRented.getText().trim());
                update.setString(3, tdateDue.getText().trim());
                update.setString(4, tdateReturned.getText().trim());
                update.setString(5, tmemberID.getText().trim());
                update.setString(6, trentalCarID.getText().trim());
                update.executeUpdate();
               } catch (Exception ex) {
                   ex.printStackTrace();
               }
           } 
        });
        
        createFrame(window, frame);
    }
    
    

    private void displayAllRental(String date){
    	final JFrame frame = new JFrame("RAW Display All Rental beginning at "+ date);//adding a frame
  
        
    
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        
        
        ////// TODO decide on way to dynamically show all rentals 
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 9;
        c.gridy = 9;
        window.add(exitBtn, c);//adding textfield 
        
        
        Connection con = DatabaseConnection.getConnection();        
        try {
            String sql = "select * from rentaldetails where dateRented >='" + date + "'";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            
            
            int count = 0;
			
			while(rs.next()){
				count = count + 1;
			}//end while
			
			//checks for one rentalID
			if(count == 1){
				JOptionPane.showMessageDialog(null, "Need to now display all reservations");
			}

    	 	
        } catch (Exception ex){
        	ex.printStackTrace();	
        	}   
        
    }
   
//////////////////////////////////////////////////////////////////////////////////////////    
    private void removeRental() {
        final JFrame frame = new JFrame("RAW Remove Rental");//adding a frame
	
        JLabel lrentalID = new JLabel("rental ID:");
        final JTextField trentalID = new JTextField(21);
        
        JButton saveBtn = new JButton("Save");
	JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lrentalID, c);//adding rentalID label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(trentalID, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 2;
        window.add(saveBtn, c);//adding save button
        c.gridx = 1;
        c.gridy = 2;
        window.add(exitBtn, c);//adding exit button
        
        saveBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               String rentalID = trentalID.getText().trim();
               Connection con = DatabaseConnection.getConnection();
               	String sql = "select rentalID from rentaldetails where rentalID = '"+trentalID.getText().trim()+"'";
				Statement st = con.createStatement();
	            ResultSet rs = st.executeQuery(sql);
	            
				rs = st.executeQuery(sql);
				int count = 0;
				while(rs.next()){
					count = count + 1;
				}//end while
				
				//checks if username already in use
				if(count == 0){
					JOptionPane.showMessageDialog(null, "This rental was not found in DB. Try Again");
				}
				
				if(count == 1){
					sql = "delete from rentaldetails where rentalID='" + rentalID + "'";
		               try {
		                   st = con.createStatement();
		                   st.executeQuery(sql);
		               } catch (Exception ex) {
		                   ex.printStackTrace();
		               }               
					
				}
               
                
           } 
        });
        
        //SEE THIS; How are we checking rentals??? 
        //do we check by car to see if it's out already? are we keeping a table for each vehicle?
        
        exitBtn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.dispose();
           } 
        });
        
       createFrame(window, frame);
    }
    
    
    
    
    
    
    
    
    
    
////////////////////////////////////////////////////////////////////////////////////////////    
    private void addRental() {
        Random generator = new Random(); 
   		int i = generator.nextInt(100) + 1;
           
        final JFrame frame = new JFrame("RAW Add Rental");//adding a frame
        
        JLabel lrentalID = new JLabel("Rental ID:");
        final JTextField trentalID = new JTextField(11);
        trentalID.setText(String.valueOf(i));
  
        JLabel ldateRented = new JLabel("Date Rented:");
        final JTextField tdateRented = new JTextField(11);// put filters on for formatting
        
        JLabel ldateDue = new JLabel("Date Rental Due:");
        final JTextField tdateDue = new JTextField(11);
        
        JLabel ldateReturned = new JLabel("Date Returned:");
        final JTextField tdateReturned = new JTextField(11);
        
        JLabel lmemberID = new JLabel("Member ID:");
        final JTextField tmemberID = new JTextField(11);
        
        JLabel lrentalCarID = new JLabel("Rental Car ID");
        final JTextField trentalCarID = new JTextField(11);
       
        JButton saveBtn = new JButton("Save");
        JButton exitBtn = new JButton("Exit");
        
        JPanel window = new JPanel(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.insets = new Insets(10,10,10,10);//spacing in the gridbag layout
        c.gridx = 0;
        c.gridy = 1;
        window.add(lrentalID, c);//adding username label 
        c.gridx = 1;
        c.gridy = 1;
        window.add(trentalID, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 2;
        window.add(lrentalCarID, c);//adding password label
        c.gridx = 1;
        c.gridy = 2;
        window.add(trentalCarID, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 3;
        window.add(ldateRented, c);//adding email label 
        c.gridx = 1;
        c.gridy = 3;
        window.add(tdateRented, c);//adding textfield 
        c.gridx = 0;
        c.gridy = 4;
        window.add(ldateDue,c);//adding dateDue label
        c.gridx = 1;
        c.gridy = 4;
        window.add(tdateDue,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 5;
        window.add(ldateReturned,c);//adding dateReturned label
        c.gridx = 1;
        c.gridy = 5;
        window.add(tdateReturned,c);//adding textfield 
        c.gridx = 0;
        c.gridy = 6;
        window.add(lmemberID, c);//adding phone label
        c.gridx = 1;
        c.gridy = 6;
        window.add(tmemberID, c);//adding textfield 
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
        
        viewAllBtn.addActionListener(new ActionListener(){
        	public void actioPerformed(ActionEvent e){
        		
        		
        	}
        
        });
        
        
        
        saveBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

                String rentalID = trentalID.getText().trim();
                String memberID = tmemberID.getText().trim();
                
                String dateDue = tdateDue.getText().trim();
                String dateReturned = tdateReturned.getText().trim();
                String dateRented = tdateRented.getText().trim();
                String rentalCarID = trentalCarID.getText().trim();
                
                Connection con = DatabaseConnection.getConnection()
				
				
				// TODO check that no member has two overlapping reservations
                // check that vehicle is available

                        try {
                        	String sql = "select * from rentaldetails where rentalCarID not in "
    								+ "(select rentalCarID from rentaldetails where "
    								+ "(dateRented <= '"+tdateRented+"' AND dateDue >= '"+tdateRented+"') OR"
    								+ "(dateRented <= '"+tdateDue+"' AND dateDue >= '"+tdateDue+"') OR"
    							    + "(dateRented >= '"+tdateRented+"' AND dateDue <= '"+tdateDue+"'))";
    						Statement st = con.createStatement();
    			            ResultSet rs = st.executeQuery(sql);
    			            
                            
                        
                            int count = 0;
                			
                			while(rs.next()){
                				count = count + 1;
                			}//end while
                			
                			//checks for one rentalID
                			if(count == 0){
                				JOptionPane.showMessageDialog(null, " Rental Reservation Not available for this car ");
                				
                			}
                				
                			//checks for duplicate rentalIDs
                			else if(count > 0){
                				JOptionPane.showMessageDialog(null, "There are Cars available for this date span");
                				try{
                					while (rs.next()) {
                						if(rs.getString("rentalCarID").equals(trentalCarID.getText().trim())){
                								JOptionPane.showMessageDialog(null, "Car available for selected dates. Reservation updated.");
                								//TODO SEND QUERY TO UPDATE RESERVATION
                								
                								try{
                									// add new employee to database
                									sql = "INSERT INTO rentaldetails (rentalID, memberID, dateDue, dateReturned, dateRented,rentalCarID)" +
                									        "VALUES (?, ?, ?, ?, ?, ?)";
                									
                							
                									
                									PreparedStatement preparedStatement = con.prepareStatement(sql);
                									preparedStatement.setString(1, rentalID);
                									preparedStatement.setString(2, memberID);
                									preparedStatement.setString(1, dateDue);
                									preparedStatement.setString(2, dateReturned);
                									preparedStatement.setString(1, dateRented);
                									preparedStatement.setString(2, rentalCarID);
                									preparedStatement.executeUpdate(); 
                									
                									
                									
                									}
                									catch(Exception ex){
                										
                										}//end catch
                									
                									
                						}//end if

                							}//end while
                						
                		            }
                				 catch(Exception ex){
                					ex.printStackTrace();
                				
                			     	}
                			}
                			//when count == 0 (No match with rentalID input and db data)
                			else{
                				JOptionPane.showMessageDialog(null, "Rental Reservation overlap; reservation not updated ");
                				viewRental();
                			}
                            
                            
                        }// end biggest try block 
                catch (Exception ex) {
                            ex.printStackTrace();
                        }
			}
                        
		});//end b action
        
       
        
        createFrame( window, frame);
    }
}
