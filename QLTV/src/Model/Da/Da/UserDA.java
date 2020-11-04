/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Da.Da;

import Model.Da.User;
import Database.ConnectDb;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author tudv
 */
public class UserDA {
    
    public UserDA(){}

    private Connection con = ConnectDb.connectDB();
    public static ArrayList<User> listUser;
   
    public ArrayList<User> getAll() throws SQLException {
        listUser = new ArrayList<User>();

        String sql = "SELECT * FROM user";
        Statement stmt = (Statement) con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            User user = new User(rs.getString(2),
                    rs.getString(3), rs.getInt(4), rs.getInt(5),
                    rs.getString(6), rs.getInt(7), rs.getString(8),
                    rs.getString(9), rs.getInt(10), rs.getInt(11), rs.getInt(12), rs.getInt(13));
            listUser.add(user);
        }
        return listUser;
    }

    public boolean deleteUser(int id) throws SQLException {
        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setInt(1, id);
        int result = stmt.executeUpdate();
        return result > 0;
    }

    public boolean updateUser(User user) throws SQLException {
        String sql = "update user set us_name = ?,us_address=?"
                + ",us_gender=?,us_code_student=?,us_mail=?,us_phone_number=?,us_role=?"
                + ",fac_id=?,us_nien_khoa=?,us_pass_word=?,maj_id=?,sch_id=?"
                + "where id = ?";
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getAddress());
        stmt.setInt(3, user.getGender());
        stmt.setInt(4, user.getMasv());
        stmt.setString(5, user.getEmail());
        stmt.setInt(6, user.getPhone_number());
        stmt.setInt(7, user.getRole());
        stmt.setInt(8, user.getId_faculty());
        stmt.setString(9, user.getNien_khoa());
        stmt.setString(10, user.getPassword());
        stmt.setInt(11, user.getId_major());
        stmt.setInt(12, user.getId_school());
        int result = stmt.executeUpdate();
        return result > 0;
    }

    public boolean addUser(User user) throws SQLException {
        String sql = "INSERT INTO user (us_name,us_address, "
                + "us_gender,us_code_student,us_mail,us_phone_number ,"
                + "us_role,fac_id,us_nien_khoa,us_pass_word,maj_id,sch_id ) "
                + "VALUES (?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getAddress());
        stmt.setInt(3, user.getGender());
        stmt.setInt(4, user.getMasv());
        stmt.setString(5, user.getEmail());
        stmt.setInt(6, user.getPhone_number());
        stmt.setInt(7, user.getRole());
        stmt.setInt(8, user.getId_faculty());
        stmt.setString(9, user.getNien_khoa());
        stmt.setString(10, user.getPassword());
        stmt.setInt(11, user.getId_major());
        stmt.setInt(12, user.getId_school());
        int result = stmt.executeUpdate();
        return result > 0;
    }
    
    public boolean checkLogin(String name, String password) throws SQLException{
        if(con == null){
            System.out.println("Ket noi that bai");
            return false;
        }
        String sql = "SELECT * FROM user WHERE us_name = ? AND us_pass_word = ?";
        java.sql.PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, password);
        ResultSet rs = stmt.executeQuery();
        if (rs.next())
                return true;
        return false;
    }
    
    public static void main(String[] args) throws SQLException {
        UserDA qe = new UserDA();
        ArrayList<User> listUser = qe.getAll();
        for (User u : listUser) {
            System.out.println("user==============" + u.getName());
        }
    }

}
