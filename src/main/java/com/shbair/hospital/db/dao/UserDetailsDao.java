package com.shbair.hospital.db.dao;

import com.shbair.hospital.db.vo.UserDetailsVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

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
        int count = 0;

        try {
            con = getConnection();
            String sql = "INSERT INTO users_details (USER_ID, FIRST_NAME, FATHER_NAME, MOBILE) VALUES (?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, udv.getUsersVo().getId());
            ps.setString(2, udv.getFirstName());
            ps.setString(3, udv.getFatherName());
            ps.setString(4, udv.getMobile());

            count = ps.executeUpdate();
            ps.close();

        } catch (Exception ex) {
          ex.printStackTrace();
        } finally {
            closeConnection(con);   
        }

        return count;
    }

    @Override
    public int update(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int delete(UserDetailsVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
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
}