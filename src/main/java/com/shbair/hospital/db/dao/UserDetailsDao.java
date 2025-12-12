/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.shbair.hospital.db.dao;
import com.shbair.hospital.db.vo.UserDetailsVo;
import com.shbair.hospital.db.vo.UsersVo;
import com.shbair.hospital.view.UsersView;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author LCS
 */
public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo>

{
    private static UserDetailsDao userDetailsDao;
    private UserDetailsDao(){
    
    }
    public static  UserDetailsDao getInstance(){
        if (userDetailsDao == null) {
            userDetailsDao = new UserDetailsDao();
        }
        return  userDetailsDao;
    }
 @Override
public int insert(UserDetailsVo udv) {
    Connection con = null;
    PreparedStatement psUser = null;
    PreparedStatement psDetails = null;
    int count = 0;

    try {
        con = getConnection();
        con.setAutoCommit(false);

        // ======== إدخال المستخدم في جدول users ========
        String userSql = "INSERT INTO users (ID, USER_NAME, PASSWORD, USER_TYPE) VALUES (?, ?, ?, ?)";
        psUser = con.prepareStatement(userSql);
        psUser.setInt(1, udv.getUsersVo().getId()); // ID محدد من المستخدم
        psUser.setString(2, udv.getUsersVo().getUserName());
        psUser.setString(3, udv.getUsersVo().getPassword());
        psUser.setInt(4, udv.getUsersVo().getUsersType().getId());

        int rowsUser = psUser.executeUpdate();
        System.out.println("Rows inserted into users: " + rowsUser);

        // ======== إدخال تفاصيل المستخدم في جدول users_details ========
        String detailsSql;
        boolean hasImage = UsersView.imageByte != null && UsersView.imageByte.length > 0;

        if (hasImage) {
            detailsSql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE, IMAGE) VALUES (?, ?, ?, ?, ?)";
            psDetails = con.prepareStatement(detailsSql);
            psDetails.setInt(1, udv.getUsersVo().getId());
            psDetails.setString(2, udv.getFirstName());
            psDetails.setString(3, udv.getFatherName());
            psDetails.setString(4, udv.getMobile());
            psDetails.setBytes(5, UsersView.imageByte);
        } else {
            detailsSql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE) VALUES (?, ?, ?, ?)";
            psDetails = con.prepareStatement(detailsSql);
            psDetails.setInt(1, udv.getUsersVo().getId());
            psDetails.setString(2, udv.getFirstName());
            psDetails.setString(3, udv.getFatherName());
            psDetails.setString(4, udv.getMobile());
        }

        int rowsDetails = psDetails.executeUpdate();
        System.out.println("Rows inserted into users_details: " + rowsDetails);

        con.commit();

        if (rowsUser > 0 && rowsDetails > 0) {
            count = 1;
            System.out.println("✔ Insert successfully");
        } else {
            System.out.println("❌ Insert failed: rowsUser=" + rowsUser + ", rowsDetails=" + rowsDetails);
        }

    } catch (Exception e) {
        try { if (con != null) con.rollback(); } catch (Exception ex) { ex.printStackTrace(); }
        System.out.println("❌ Insert failed: " + e.getMessage());
        e.printStackTrace();
    } finally {
        try {
            if (psUser != null) psUser.close();
            if (psDetails != null) psDetails.close();
            if (con != null) closeConnection(con);
        } catch (Exception e) { e.printStackTrace(); }
    }

    return count;
}

   @Override
public int update(UserDetailsVo udv) throws Exception {
    Connection con = null;
    PreparedStatement psUser = null;
    PreparedStatement psDetails = null;
    int count = 0;

    try {
        con = getConnection();
        con.setAutoCommit(false);

        // تحديث جدول users
        String userSql = "UPDATE users SET USER_NAME=?, PASSWORD=?, USER_TYPE=? WHERE ID=?";
        psUser = con.prepareStatement(userSql);
        psUser.setString(1, udv.getUsersVo().getUserName());
        psUser.setString(2, udv.getUsersVo().getPassword());
        psUser.setInt(3, udv.getUsersVo().getUsersType().getId());
        psUser.setInt(4, udv.getUsersVo().getId());

        int rowsUser = psUser.executeUpdate();

        // تحديث جدول users_details
        String detailsSql = "UPDATE users_details SET FIRST_NAME=?, FATHER_NAME=?, MOBILE=? WHERE USER_ID=?";
        psDetails = con.prepareStatement(detailsSql);
        psDetails.setString(1, udv.getFirstName());
        psDetails.setString(2, udv.getFatherName());
        psDetails.setString(3, udv.getMobile());
        psDetails.setInt(4, udv.getUsersVo().getId());

        int rowsDetails = psDetails.executeUpdate();

        con.commit();

        if (rowsUser > 0 && rowsDetails > 0) {
            count = 1; // التعديل نجح
        }

    } catch (Exception e) {
        if (con != null) con.rollback();
        e.printStackTrace();
    } finally {
        if (psUser != null) psUser.close();
        if (psDetails != null) psDetails.close();
        if (con != null) closeConnection(con);
    }

    return count;
}


    
    
    @Override
    public int delete(UserDetailsVo ud) throws Exception {
    Connection con = null;
    PreparedStatement psDetails = null;
    PreparedStatement psUser = null;
    int count = 0;

    try {
        con = getConnection();
        con.setAutoCommit(false);
        // 1) حذف من جدول التفاصيل أولاً
        String sqlDetails = "DELETE FROM users_details WHERE USER_ID = ?";
        psDetails = con.prepareStatement(sqlDetails);
        psDetails.setInt(1, ud.getUsersVo().getId());
        int rowsDetails = psDetails.executeUpdate();

        // 2) حذف من جدول users
        String sqlUser = "DELETE FROM users WHERE ID = ?";
        psUser = con.prepareStatement(sqlUser);
        psUser.setInt(1, ud.getUsersVo().getId());
        int rowsUser = psUser.executeUpdate();

        // لو تم الحذف من الجدولين
        if (rowsUser > 0 && rowsDetails > 0) {
            count = 1;
        }

        con.commit(); // تأكيد الحذف

    } catch (Exception e) {
        if (con != null) con.rollback(); // رجوع في حال الخطأ
        e.printStackTrace();
        throw e;
    } finally {
        if (psDetails != null) psDetails.close();
        if (psUser != null) psUser.close();
        closeConnection(con);
    }

    return count;
}
  

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public UserDetailsVo getDataById(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

  
    private void closeConnection(Connection con) {
    try {
        if (con != null) {
            con.close();
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
