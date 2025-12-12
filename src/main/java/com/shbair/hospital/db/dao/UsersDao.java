
package com.shbair.hospital.db.dao;
import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author LCS
 */
public class UsersDao extends Dao implements DaoList<UsersVo> {
    private static UsersDao usersDao;
    private UsersDao(){
    
    }
    public static UsersDao getInstance(){
    if (usersDao == null){
        usersDao = new UsersDao();
    }
    return usersDao;
    }

    @Override
    public List<UsersVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public int insert(UsersVo uv) throws Exception {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        con = getConnection();

        // بدون ID لأن الجدول Auto Increment
        String sql = "INSERT INTO users (USER_NAME, PASSWORD, USER_TYPE) VALUES (?, ?, ?)";
        
        ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setString(1, uv.getUserName());
        ps.setString(2, uv.getPassword());
        ps.setInt(3, uv.getUsersType().getId());

        int count = ps.executeUpdate();

        // سحب آخر ID تمت إضافته
        rs = ps.getGeneratedKeys();
        if (rs.next()) {
            uv.setId(rs.getInt(1)); // تخزين ID داخل الكائن
        }

        return count;

    } catch (Exception ex) {
        throw ex; // حتى لو فشل نعرف وين الخطأ
    } finally {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        closeConnection(con);
    }
}


    @Override
    public int update(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(UsersVo uv) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); }

    @Override
    
public UsersVo getData(UsersVo uv) throws Exception {
    Connection con = null;
    UsersVo usersVo = null;
    ResultSet rs = null;

    try {
        con = getConnection();

        String sql = "SELECT * FROM users WHERE USER_NAME = ? AND PASSWORD = ?";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, uv.getUserName());
        ps.setString(2, uv.getPassword());

        rs = ps.executeQuery();

        if (rs.next()) {
            usersVo = new UsersVo();
            usersVo.setId(rs.getInt("ID"));
            usersVo.setUserName(rs.getString("USER_NAME"));
            usersVo.setPassword(rs.getString("PASSWORD"));
            UsersType usersType = UsersType.getUsersTypeByTypeById(rs.getInt("USER_TYPE"));
            usersVo.setUsersType(usersType);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        closeConnection(con);
    }

    return usersVo;
}



    
    @Override
public UsersVo getDataById(int id) throws Exception {
    Connection con = null;
    UsersVo usersVo = null;
    ResultSet rs = null;

    try {
        con = getConnection();
        String sql = "SELECT * FROM users WHERE ID=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            usersVo = new UsersVo();
            usersVo.setId(rs.getInt("ID"));
            usersVo.setUserName(rs.getString("USER_NAME"));
            usersVo.setPassword(rs.getString("PASSWORD"));
            UsersType usersType = UsersType.getUsersTypeByTypeById(rs.getInt("USER_TYPE")); // ثابت
            usersVo.setUsersType(usersType);
        }

        rs.close();
        ps.close();

    } catch(Exception ex) {
        ex.printStackTrace();
        throw ex; //  لمعرفة سبب الخطأ
    } finally {
        closeConnection(con);
    }

    return usersVo;
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

}

