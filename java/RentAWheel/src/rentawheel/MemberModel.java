package rentawheel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberModel {
    private final Connection con;
    
    public MemberModel() {
        this.con = DatabaseConnection.getConnection();
    }
    
    public boolean addMember(Member m) {
        try {
            String sql = "INSERT INTO member (username, password, email, firstname, lastname, PhoneNumber, DPNumber)" +
                         "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement preparedStatement = con.prepareStatement(sql);
            preparedStatement.setString(1, m.getUsername());
            preparedStatement.setString(2, m.getPassword());
            preparedStatement.setString(3, m.getEmail());
            preparedStatement.setString(4, m.getFirstname());
            preparedStatement.setString(5, m.getLastname());
            preparedStatement.setInt(6, Integer.parseInt(m.getPhonenumber()));
            preparedStatement.setString(7, m.getDpnumber());
            preparedStatement.executeUpdate(); 
            
            return true;
        } catch (Exception ex2) {
            ex2.printStackTrace();
            return false;
        }
    }
    
    public void removeMember(int id) {
        try {  
            String sql = "DELETE FROM member WHERE memberid=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql); 
            preparedStatement.setInt(1, id);  
            preparedStatement.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    public void removeMemberByUser(String username) {
        try {  
            String sql = "DELETE FROM member WHERE username=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql); 
            preparedStatement.setString(1, username);  
            preparedStatement.executeUpdate();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }
    }
    
    public Member getMember(String username) {
        Member m = new Member();
        
        try {
            String sql = "SELECT * FROM member WHERE username=?";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            
            int count = 0;
            while (rs.next()) {
                m.setFirstname(rs.getString("firstname"));
                m.setLastname(rs.getString("lastname"));
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
                m.setEmail(rs.getString("email"));
                m.setPhonenumber(String.valueOf(rs.getInt("PhoneNumber")));
                m.setDpnumber(rs.getString("DPNumber"));
                m.setId(rs.getInt("memberid"));
                
                count += 1;
            }
            
            if (count == 0) {
                return null;
            } else {
                return m;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public void editMember(Member m) {
        try {
            String sql = "UPDATE member SET username=?, password=?," +
                         "email=?, firstname=?, lastname=?," +
                         "PhoneNumber=?, DPNumber=? WHERE username=?";
            
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            preparedStatement.setString(1, m.getUsername());
            preparedStatement.setString(2, m.getPassword());
            preparedStatement.setString(3, m.getEmail());
            preparedStatement.setString(4, m.getFirstname());
            preparedStatement.setString(5, m.getLastname());
            preparedStatement.setInt(6, Integer.parseInt(m.getPhonenumber()));
            preparedStatement.setString(7, m.getDpnumber());
            preparedStatement.setString(8, m.getUsername());
            preparedStatement.executeUpdate();  

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public ArrayList<Member> getAllMembers() {
        ArrayList<Member> list = new ArrayList<Member>();
        
        try {
            String sql = "SELECT * FROM member";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                Member m = new Member();
                m.setFirstname(rs.getString("firstname"));
                m.setLastname(rs.getString("lastname"));
                m.setUsername(rs.getString("username"));
                m.setPassword(rs.getString("password"));
                m.setEmail(rs.getString("email"));
                m.setPhonenumber(String.valueOf(rs.getInt("PhoneNumber")));
                m.setDpnumber(rs.getString("DPNumber"));
                m.setId(rs.getInt("memberid"));
                
                list.add(m);
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Integer> getAllMemberIds() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        try {
            String sql = "SELECT memberid FROM member";
            PreparedStatement preparedStatement = this.con.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            
            while (rs.next()) {
                list.add(rs.getInt("memberid"));
            }
            
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }        
    }
}