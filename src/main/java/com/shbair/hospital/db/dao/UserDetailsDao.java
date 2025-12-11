package com.shbair.hospital.db.dao;

import static com.shbair.hospital.db.dao.MyDriverManager.getConnection;
import com.shbair.hospital.db.vo.UserDetailsVo;
import java.sql.Connection;
import static java.sql.DriverManager.getConnection;
import java.sql.PreparedStatement;
import java.util.List;
import javax.swing.JOptionPane;

public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo> {

    private static UserDetailsDao userDetailsDao;

    private UserDetailsDao() {
    }

    public static UserDetailsDao getInstance() {
        if (userDetailsDao == null) {
            userDetailsDao = new UserDetailsDao();
        }
        return userDetailsDao;
    }

    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int insert(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            con = getConnection();
            con.setAutoCommit(false);
            String usersql = "INSERT INTO users (USER_NAME,PASSWORD,USER_TYPE,ID) VALUES (?,?,?,?)";
            ps = con.prepareStatement(usersql);
            ps.setString(1, udv.getUsersVo().getUserName());
            ps.setString(2, udv.getUsersVo().getPassword());
            ps.setInt(3, udv.getUsersVo().getUsersType().getId());
            ps.setInt(4, udv.getUsersVo().getId());
            ps.executeUpdate();
            String UserDetailsSql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE) VALUES (?, ?, ?, ?)";
            ps = con.prepareStatement(UserDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());
            ps.executeUpdate();
            con.commit();
            count = 1;

        } catch (Exception ex) {
            con.rollback(); //            للتراجع عن الاضافة  لو فيه اي خطأ صار 
        } finally {
            ps.close();
            closeConnection(con);
        }

        return count;
    }

    @Override
    public int update(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(UserDetailsVo udv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            con = getConnection();
            con.setAutoCommit(false);
            // الحدف اولا من اليوزر ديتايلز لانه يحتوي على فورن كــي من اليوزر فلا نستطيع حذق شيء في اليوزر وهوا معتمد عليه من اليوزر ديتايلز
            String UserDetailsSql = "DELETE FROM users_details WHERE USER_ID=?"; 
            ps = con.prepareStatement(UserDetailsSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();
            String userSql = "DELETE FROM USERS WHERE ID=?";
            ps = con.prepareStatement(userSql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.executeUpdate();
            con.commit();
            count = 1;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            con.rollback(); //            للتراجع عن الحذف لو فيه اي خطأ صار 
        } finally {
            ps.close();
            closeConnection(con);
        }

        return count;

    }

    @Override
    public UserDetailsVo getData(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    private void closeConnection(Connection con) {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public UserDetailsVo getDataById(int id) throws Exception {
       
        return null;
       
    }
}
