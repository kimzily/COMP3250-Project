package rentawheel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class EmployeeModel {
    private final Connection con;
    
    public EmployeeModel() {
        this.con = DatabaseConnection.getConnection();
    }
    
    public boolean addEmployee(Employee e) {
        try{
            String sql = "INSERT INTO employee (firstname, lastname, title, username, password)" +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, e.getFirstName());
            preparedStatement.setString(2, e.getLastName());
            preparedStatement.setInt(3, e.getTitle());
            preparedStatement.setString(4, e.getUsername());
            preparedStatement.setString(5, e.getPassword());
            preparedStatement.executeUpdate();
            
            return true;

        } catch(Exception ex){
            ex.printStackTrace();
            return false;
        }	
    }
    
    public void removeEmployee(int id) {  
        try {  
            String sql = "DELETE FROM employee WHERE employeeid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql); 
            preparedStatement.setInt(1, id);  
            preparedStatement.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    public Employee getEmployee(String username) {
        Employee e = new Employee();
        
        try {
            String sql = "SELECT * FROM employee WHERE username=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            
            int count = 0;
            
            while (rs.next()) {
                e.setFirstName(rs.getString("firstname"));
                e.setLastName(rs.getString("lastname"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setTitle(rs.getInt("title"));
                e.setId(rs.getInt("employeeid"));
                
                count += 1;
            }
            if (count == 0) {
                return null;
            } else {
                return e;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void editEmployee(Employee e) {
        try {
            String sql = "UPDATE employee SET username=?," +
                         "password=?, firstname=?, lastname=?," +
                         "title=? WHERE username=?";
            
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, e.getUsername());
            preparedStatement.setString(2, e.getPassword());
            preparedStatement.setString(3, e.getFirstName());
            preparedStatement.setString(4, e.getLastName());
            preparedStatement.setInt(5, e.getTitle());
            preparedStatement.setString(6, e.getUsername());
            preparedStatement.executeUpdate();  

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}