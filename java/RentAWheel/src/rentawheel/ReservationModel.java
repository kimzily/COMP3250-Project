package rentawheel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ReservationModel {
    private final Connection con;
    
    public ReservationModel() {
        this.con = DatabaseConnection.getConnection();
    }
    
    public boolean addReservation(Reservation m) {
        try {
            String sql = "INSERT INTO rentaldetails (datereturned, daterented, memberid, carid, dateDue)" +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, m.getDateRented());
            preparedStatement.setString(2, m.getDateReturned());
            preparedStatement.setInt(3, m.getMemberid());
            preparedStatement.setInt(4, m.getCarid());
            preparedStatement.setString(5, m.getDateDue());
            preparedStatement.executeUpdate(); 
            
            return true;
        } catch (Exception ex2) {
            ex2.printStackTrace();
            return false;
        }
    }
    
    public void removeReservation(int id) {
        try {  
            String sql = "DELETE FROM rentaldetails WHERE rentalid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql); 
            preparedStatement.setInt(1, id);  
            preparedStatement.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    public Reservation getReservation(int id) {
        Reservation m = new Reservation();
        
        try {
            String sql = "SELECT * FROM rentaldetails WHERE rentalid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                m.setDateReturned(rs.getString("datereturned"));
                m.setDateRented(rs.getString("daterented"));
                m.setMemberid(rs.getInt("memberid"));
                m.setCarid(rs.getInt("carid"));
                m.setDateDue(rs.getString("dateDue"));
                m.setId(rs.getInt("rentalid"));
            }
            
            return m;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void editReservation(Reservation m) {
        try {
            String sql = "UPDATE rentaldetails SET daterented=?," +
                         "datedue=?, datereturned=?," +
                         "memberid=?, carid=? WHERE rentalid=?";
            
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, m.getDateRented());
            preparedStatement.setString(2, m.getDateDue());
            preparedStatement.setString(3, m.getDateReturned());
            preparedStatement.setInt(4, m.getMemberid());
            preparedStatement.setInt(5, m.getCarid());
            preparedStatement.setInt(6, m.getId());
            preparedStatement.executeUpdate(); 
            preparedStatement.executeUpdate();  

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Reservation> getAllReservations() {
        ArrayList<Reservation> list = new ArrayList<Reservation>();
        
        try {
            String sql = "SELECT * FROM rentaldetails";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Reservation m = new Reservation();
                
                m.setDateReturned(rs.getString("datereturned"));
                m.setDateRented(rs.getString("daterented"));
                m.setMemberid(rs.getInt("memberid"));
                m.setCarid(rs.getInt("carid"));
                m.setDateDue(rs.getString("dateDue"));
                m.setId(rs.getInt("rentalid"));
                
                list.add(m);
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}