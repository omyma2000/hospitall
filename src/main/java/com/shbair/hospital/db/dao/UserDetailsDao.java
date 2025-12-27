package com.shbair.hospital.db.dao;
import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.UserDetailsVo;
import com.shbair.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
/**
 *
 * @author LCS
 */
public class UserDetailsDao extends Dao implements DaoList<UserDetailsVo>

{
    private static UserDetailsDao userDetailsDao;
    private int id;
    private UserDetailsDao(){

}
    public static UserDetailsDao getInstance(){
        if (userDetailsDao==null) {
            userDetailsDao=new UserDetailsDao();
        }
        return userDetailsDao;
    }

    @Override
    public List<UserDetailsVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

@Override
public int insert(UserDetailsVo udv) throws Exception {
    Connection con = null;
    int count = 0;

    try {
        con = getConnection();
        con.setAutoCommit(false);

        int userId = udv.getUsersVo().getId(); // ID من واجهة المستخدم

        // ---- تحقق أن هذا ID غير موجود مسبقًا ----
        String checkSql = "SELECT COUNT(*) AS cnt FROM users WHERE ID=?";
        PreparedStatement psCheck = con.prepareStatement(checkSql);
        psCheck.setInt(1, userId);
        ResultSet rs = psCheck.executeQuery();
        if (rs.next() && rs.getInt("cnt") > 0) {
            throw new Exception("This ID already exists!");
        }
        rs.close();
        psCheck.close();

        // ---- Insert into users ----
        String userSql = "INSERT INTO users (ID, USER_NAME, PASSWORD, USER_TYPE) VALUES (?, ?, ?, ?)";
        PreparedStatement psUser = con.prepareStatement(userSql);
        psUser.setInt(1, userId);
        psUser.setString(2, udv.getUsersVo().getUserName());
        psUser.setString(3, udv.getUsersVo().getPassword());
        psUser.setInt(4, udv.getUsersVo().getUsersType().getId());
        psUser.executeUpdate();
        psUser.close();

        // ---- Insert into users_details ----
        String userDetailsSql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE, IMAGE,Specialization) VALUES (?, ?, ?, ?, ?,?)";
        PreparedStatement psDetails = con.prepareStatement(userDetailsSql);
        psDetails.setInt(1, userId);
        psDetails.setString(2, udv.getFirstName());
        psDetails.setString(3, udv.getFatherName());
        psDetails.setString(4, udv.getMobile());
        psDetails.setBytes(5, udv.getImage());
        psDetails.setString(6, udv.getSpecialization());
        psDetails.executeUpdate();
        psDetails.close();

        con.commit();
        count = 1;

    } catch (Exception ex) {
        if (con != null) con.rollback();
        ex.printStackTrace();
        throw ex;
    } finally {
        closeConnection(con);
    }

    return count;
}


 @Override
public int update(UserDetailsVo udv) throws Exception {
    Connection con = null;
    int count = 0;
    int userId = udv.getUsersVo().getId();

    try {
        con = getConnection();
        con.setAutoCommit(false);

        // ---- تحقق أن ID موجود ----
        String checkSql = "SELECT COUNT(*) AS cnt FROM users WHERE ID=?";
        PreparedStatement psCheck = con.prepareStatement(checkSql);
        psCheck.setInt(1, userId);
        ResultSet rs = psCheck.executeQuery();
        if (!rs.next() || rs.getInt("cnt") == 0) {
            throw new Exception("ID does not exist!");
        }
        rs.close();
        psCheck.close();

        // ---- Update جدول users ----
        String userSql = "UPDATE users SET USER_NAME=?, PASSWORD=?, USER_TYPE=? WHERE ID=?";
        PreparedStatement psUser = con.prepareStatement(userSql);
        psUser.setString(1, udv.getUsersVo().getUserName());
        psUser.setString(2, udv.getUsersVo().getPassword());
        psUser.setInt(3, udv.getUsersVo().getUsersType().getId());
        psUser.setInt(4, userId);
        psUser.executeUpdate();
        psUser.close();

        // ---- Update جدول users_details ----
        String detailsSql = "UPDATE users_details SET FIRST_NAME=?, FATHER_NAME=?, MOBILE=?, IMAGE=? , Specialization=? WHERE USER_ID=?";
        PreparedStatement psDetails = con.prepareStatement(detailsSql);
        psDetails.setString(1, udv.getFirstName());
        psDetails.setString(2, udv.getFatherName());
        psDetails.setString(3, udv.getMobile());
        psDetails.setBytes(4, udv.getImage());
        psDetails.setInt(5, userId);
        psDetails.setString(6, udv.getSpecialization());
        psDetails.executeUpdate();
        psDetails.close();

        con.commit();
        count = 1;

    } catch (Exception ex) {
        if (con != null) con.rollback();
        ex.printStackTrace();
        throw ex;
    } finally {
        closeConnection(con);
    }

    return count;
}

@Override
public int delete(UserDetailsVo udv) throws Exception {
    Connection con = null;
    int count = 0;

    try {
        con = getConnection();
        con.setAutoCommit(false);

        // ---- تحقق أن ID موجود ----
        String checkSql = "SELECT COUNT(*) AS cnt FROM users WHERE ID=?";
        PreparedStatement psCheck = con.prepareStatement(checkSql);
        psCheck.setInt(1, udv.getUsersVo().getId());
        ResultSet rs = psCheck.executeQuery();
        if (!rs.next() || rs.getInt("cnt") == 0) {
            throw new Exception("ID does not exist!");
        }
        rs.close();
        psCheck.close();

        // ---- Delete من users_details أولاً (FK) ----
        String detailsSql = "DELETE FROM users_details WHERE USER_ID=?";
        PreparedStatement psDetails = con.prepareStatement(detailsSql);
        psDetails.setInt(1, udv.getUsersVo().getId());
        psDetails.executeUpdate();
        psDetails.close();

        // ---- Delete من users ----
        String userSql = "DELETE FROM users WHERE ID=?";
        PreparedStatement psUser = con.prepareStatement(userSql);
        psUser.setInt(1, udv.getUsersVo().getId());
        psUser.executeUpdate();
        psUser.close();

        con.commit();
        count = 1;

    } catch (Exception ex) {
        if (con != null) con.rollback();
        ex.printStackTrace();
        throw ex;
    } finally {
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
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    UserDetailsVo userDetailsVo = null;

    try {
        con = getConnection();
        String sql = "SELECT u.ID, u.USER_NAME, u.PASSWORD, u.USER_TYPE, " +
                     "ud.FIRST_NAME, ud.FATHER_NAME, ud.MOBILE, ud.IMAGE " +
                     "FROM USERS u " +
                     "INNER JOIN USERS_DETAILS ud ON ud.USER_ID = u.ID " +
                     "WHERE u.ID=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            UsersVo usersVo = new UsersVo();
            usersVo.setId(rs.getInt("ID"));
            usersVo.setUserName(rs.getString("USER_NAME"));
            usersVo.setPassword(rs.getString("PASSWORD"));

            // استخدم دالة صحيحة للـ UsersType
            UsersType usersType = UsersType.getUsersTypeByTypeById(rs.getInt("USER_TYPE"));
            usersVo.setUsersType(usersType);

            userDetailsVo = new UserDetailsVo();
            userDetailsVo.setFirstName(rs.getString("FIRST_NAME"));
            userDetailsVo.setFatherName(rs.getString("FATHER_NAME"));
            userDetailsVo.setMobile(rs.getString("MOBILE"));
            userDetailsVo.setImage(rs.getBytes("IMAGE"));
            userDetailsVo.setUsersVo(usersVo);

            System.out.println("✅ DATA FOUND FOR ID = " + id);
        } else {
            System.out.println("❌ NO DATA FOUND FOR ID = " + id);
            return null;
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        throw ex;
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        closeConnection(con);
    }

    return userDetailsVo;
}

}
    