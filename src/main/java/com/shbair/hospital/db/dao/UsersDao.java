
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
        int count = 0;
        try{
            con= getConnection();
            String sql ="INSERT INTO users (USER_NAME,PASSWORD,USER_TYPE,ID) VALUES (?,?,?,?)";
            PreparedStatement ps ;
            ps = con.prepareStatement(sql);
            ps.setString(1, uv.getUserName());
            ps.setString(2, uv.getPassword());
            ps.setInt(3,uv.getUsersType().getId());
             ps.setInt(4, uv.getId());
            count= ps.executeUpdate();
            ps.close();
        }catch(Exception ex ){
        
        }finally{
            closeConnection(con);
        
        }
        return count;
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
    System.out.println("Trying login with: " + uv.getUserName() + " / " + uv.getPassword());
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
            usersVo.setId(rs.getInt("id"));
            usersVo.setUserName(rs.getString("USER_NAME"));
            usersVo.setPassword(rs.getString("PASSWORD"));
        }

        rs.close();
        ps.close();
        
    } catch(Exception ex) {
        ex.printStackTrace(); //  باش نعرف لو خطا
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

