package rentawheel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseConnection {
    private static Connection DBconnection;
    
    public synchronized static Connection getConnection() {
        if (DBconnection == null) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                
                DBconnection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/rentawheeldb",
                    "root",
                    null
                );
                
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        
        return DBconnection;
    }
    
    public synchronized static Statement getStatement() {
        Connection con = DatabaseConnection.getConnection();
        Statement st;
        
        try {
            st = con.createStatement();
        } catch (Exception e) {
            st = null;
            e.printStackTrace();
            return null;
        }
        
        return st;
    } 
}