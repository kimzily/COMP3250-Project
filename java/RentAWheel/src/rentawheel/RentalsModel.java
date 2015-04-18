package rentawheel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class RentalsModel {
    private final Connection con;
    
    public RentalsModel() {
        this.con = DatabaseConnection.getConnection();
    }
    
    public boolean addRental(Rentals r) {
        try {
            String sql = "INSERT INTO rentalcar (manufacturer, model, rentalcost, rented, availability)" +
                         "VALUES (?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, r.getManufacturer());
            preparedStatement.setString(2, r.getModel());
            preparedStatement.setString(3, r.getRentalcost());
            preparedStatement.setBoolean(4, r.isRented());
            preparedStatement.setString(5, r.getAvailability());
            preparedStatement.executeUpdate(); 
            
            return true;
        } catch (Exception ex2) {
            ex2.printStackTrace();
            return false;
        }
    }
    
    public void removeRental(int id) {
        try {  
            String sql = "DELETE FROM rentalcar WHERE carid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql); 
            preparedStatement.setInt(1, id);  
            preparedStatement.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    public Rentals getRental(int id) {
        Rentals m = new Rentals();
        
        try {
            String sql = "SELECT * FROM rentalcar WHERE carid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                m.setAvailability(rs.getString("availability"));
                m.setManufacturer(rs.getString("manufacturer"));
                m.setModel(rs.getString("model"));
                m.setRentalcost(rs.getString("rentalcost"));
                m.setRented(rs.getBoolean("rented"));
                m.setId(rs.getInt("carid"));
            }
            
            return m;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void editRental(Rentals m) {
        try {
            String sql = "UPDATE rentalcar SET carid=?," +
                         "manufacturer=?, model=?, rentalcost=?," +
                         "rented=?, availability=? WHERE carid=?";
            
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setInt(1, m.getId());
            preparedStatement.setString(2, m.getManufacturer());
            preparedStatement.setString(3, m.getModel());
            preparedStatement.setString(4, m.getRentalcost());
            preparedStatement.setBoolean(5, m.isRented());
            preparedStatement.setString(6, m.getAvailability());
            preparedStatement.setInt(7, m.getId());

            preparedStatement.executeUpdate();  

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Integer> getAllAvailableCarIds() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try {
            String sql = "SELECT carid FROM rentalcar";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getInt("carid"));
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }        
    }
    
    public ArrayList<Rentals> getAllRentals() {
        ArrayList<Rentals> list = new ArrayList<Rentals>();
        
        try {
            String sql = "SELECT * FROM rentalcar";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Rentals m = new Rentals();
                
                m.setAvailability(rs.getString("availability"));
                m.setManufacturer(rs.getString("manufacturer"));
                m.setModel(rs.getString("model"));
                m.setRentalcost(rs.getString("rentalcost"));
                m.setRented(rs.getBoolean("rented"));
                m.setId(rs.getInt("carid"));
                
                list.add(m);
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Rentals> getAllAvailableRentals() {
        ArrayList<Rentals> list = new ArrayList<Rentals>();
        
        try {
            String sql = "SELECT * FROM rentalcar WHERE rented=? AND availability=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setBoolean(1, true);
            preparedStatement.setString(2, "Available");
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Rentals m = new Rentals();
                
                m.setAvailability(rs.getString("availability"));
                m.setManufacturer(rs.getString("manufacturer"));
                m.setModel(rs.getString("model"));
                m.setRentalcost(rs.getString("rentalcost"));
                m.setRented(rs.getBoolean("rented"));
                m.setId(rs.getInt("carid"));
                
                list.add(m);
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Rentals> getAllUnavailableRentals() {
        ArrayList<Rentals> list = new ArrayList<Rentals>();
        
        try {
            String sql = "SELECT * FROM rentalcar WHERE rented=? OR availability=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, "Not Available");
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Rentals m = new Rentals();
                
                m.setAvailability(rs.getString("availability"));
                m.setManufacturer(rs.getString("manufacturer"));
                m.setModel(rs.getString("model"));
                m.setRentalcost(rs.getString("rentalcost"));
                m.setRented(rs.getBoolean("rented"));
                m.setId(rs.getInt("carid"));
                
                list.add(m);
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}