package com.shbair.hospital.db.dao;
import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.UserDetailsVo;
import com.shbair.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UsersDao extends Dao implements DaoList<UsersVo> {

    private static UsersDao usersDao;
    // CONSTRUCTOR
    private UsersDao() {}

    public static UsersDao getInstance() {
        if (usersDao == null){
          usersDao = new UsersDao();
        }
          return usersDao;
    }

    @Override
    public int insert(UsersVo uv) throws Exception {
        Connection con = null;
       
        int count = 0;

        try {
            con = getConnection();
            String sql = "INSERT INTO users (ID,USER_NAME, PASSWORD, USER_TYPE) VALUES (?, ?, ?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, uv.getId());
            ps.setString(2, uv.getUserName());
            ps.setString(3, uv.getPassword());
            ps.setInt(4, uv.getUsersType().getId());
            
            count = ps.executeUpdate();
            ps.close();
            

        }catch(Exception ex){
        } finally {
            
            closeConnection(con);
        }

        return count;
    }

    @Override
    public int update(UsersVo uv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            con = getConnection();
            String sql = "UPDATE users SET USER_NAME=?, PASSWORD=?, USER_TYPE=? WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, uv.getUserName());
            ps.setString(2, uv.getPassword());
            ps.setInt(3, uv.getUsersType().getId());
            ps.setInt(4, uv.getId());

            count = ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
            closeConnection(con);
        }

        return count;
    }

    @Override
    public int delete(UsersVo uv) throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        int count = 0;

        try {
            con = getConnection();
            String sql = "DELETE FROM users WHERE ID=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, uv.getId());
            count = ps.executeUpdate();

        } finally {
            if (ps != null) ps.close();
            closeConnection(con);
        }

        return count;
    }

    @Override
public UsersVo getData(UsersVo uv) throws Exception {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    UsersVo usersVo = null;

    try {
        con = getConnection();

        // استخدمي PreparedStatement لتجنب SQL Injection
        String sql = "SELECT * FROM users WHERE USER_NAME = ? AND PASSWORD = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, uv.getUserName().trim()); // remove spaces
        ps.setString(2, uv.getPassword().trim()); // remove spaces

        rs = ps.executeQuery();

        if(rs.next()) {
            usersVo = new UsersVo();
            usersVo.setId(rs.getInt("ID"));
            usersVo.setUserName(rs.getString("USER_NAME"));
            usersVo.setPassword(rs.getString("PASSWORD"));
            UsersType usersType = UsersType.getUsersTypeByTypeById(rs.getInt("USER_TYPE"));
            usersVo.setUsersType(usersType);
        }

    } catch(Exception ex){
        ex.printStackTrace(); // مهم جدًا لطباعة أي خطأ
    } finally {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        closeConnection(con);
    }

    return usersVo;
}


    @Override
    public UsersVo getDataById(int id) throws Exception {
        Connection con = null;
        
        ResultSet rs = null;
        UsersVo usersVo = null ;

        try {
             
            con = getConnection();
            String sql = "SELECT * FROM users WHERE ID=?";
            PreparedStatement ps = con.prepareCall(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                usersVo = new UsersVo();
                usersVo.setId(rs.getInt("ID"));
                usersVo.setUserName(rs.getString("USER_NAME"));
                usersVo.setPassword(rs.getString("PASSWORD"));
                UsersType usersType = UsersType.getUsersTypeById(rs.getInt("USER_TYPE"));
                usersVo.setUsersType(usersType);
            }
            rs.close();
            ps.close();
        } catch(Exception ex){
        } finally {
            closeConnection(con);
        
        }

        return usersVo;
    }

        @Override
        public List<UsersVo> LoadAll() throws Exception {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
    

   
    private void closeconnection(Connection con) {
        try { if (con != null) con.close(); } catch (Exception e) { e.printStackTrace(); }
    }
}
   