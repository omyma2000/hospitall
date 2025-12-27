
package com.shbair.hospital.db.dao;
import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.PatientinfoVo;
import com.shbair.hospital.db.vo.UsersVo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author LCS
 */
public class PatientinfoDao extends Dao implements DaoList<PatientinfoVo>{
    private static PatientinfoDao patientinfoDao;
// constructor
    private PatientinfoDao(){
    
   
    }
     public static PatientinfoDao getInstance(){
        if (patientinfoDao==null) {
            patientinfoDao=new PatientinfoDao();
        }
        return patientinfoDao;
    }

    @Override
    public List<PatientinfoVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(PatientinfoVo piv) throws Exception {
    Connection con = null;
    PreparedStatement psDetails =null;
    int count = 0;

    try {
        con = getConnection();
       
        // ---- Insert into Patient info ----
        String sql = "INSERT INTO PATIENT_INFO (ID, FIRST_NAME, FATHER_NAME, MOBILE, EMAIL,USER_ID) VALUES (?, ?, ?, ?, ?,?)";
        psDetails = con.prepareStatement(sql);
        psDetails.setInt(1, piv.getId());
        psDetails.setString(2, piv.getFirstName());
        psDetails.setString(3, piv.getFatherName());
        psDetails.setString(4, piv.getMobile());
        psDetails.setString(5, piv.getEmail());
        psDetails.setInt(6, piv.getUsersVo().getId());
        count= psDetails.executeUpdate();
        psDetails.close();
        

    } catch (Exception ex) {
        
       
    } finally {
        psDetails.close();
        closeConnection(con);
    }

    return count;
    }

    @Override
    public int update(PatientinfoVo piv) throws Exception {
     Connection con = null;
     PreparedStatement psCheck =null;
    int count = 0;
    PreparedStatement psUser =null;
try {
        con = getConnection();
          // ---- Update table ----
        String sql = "UPDATE patient_info SET FIRST_NAME=?, FATHER_NAME=?, MOBILE=?,EMAIL=?,USER_ID=? WHERE ID=?";
        psUser = con.prepareStatement(sql);
        psUser.setString(1, piv.getFirstName());
        psUser.setString(2, piv.getFatherName());
        psUser.setString(3, piv.getMobile());
        psUser.setString(4, piv.getEmail());
        psUser.setInt(5, piv.getUsersVo().getId());
        psUser.setInt(6, piv.getId());
        count = psUser.executeUpdate();
            
    } catch (Exception ex) {
     } finally {
        psUser.close();
        closeConnection(con);
    }

    return count;
}

    @Override
    public int delete(PatientinfoVo piv) throws Exception {
        Connection con = null;
         int count = 0;
         PreparedStatement psDetails=null;
     try {
        con = getConnection();
        con.setAutoCommit(false);
       
  // ---- Delete من users_details أولاً (FK) ----
        String sql = "DELETE FROM patient_info WHERE ID=?";
        psDetails = con.prepareStatement(sql);
        psDetails.setInt(1, piv.getId());
        count= psDetails.executeUpdate();
        psDetails.close();
        con.commit();
    } catch (Exception ex) {
        if(con!=null)
        {
        con.rollback();
        ex.printStackTrace();
        }
       } finally {
        closeConnection(con);
    }
      return count;
    }

    @Override
    public PatientinfoVo getData(PatientinfoVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public PatientinfoVo getDataById(int id) throws Exception {
        Connection con = null;
        ResultSet rs = null;
     
        PatientinfoVo patientinfoVo = null ; // local variable
        UsersVo usersVo;
        try {
             
            con = getConnection();
            String sql = "SELECT * FROM patient_info WHERE ID=?";
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                patientinfoVo = new PatientinfoVo();
                patientinfoVo.setId(rs.getInt("ID"));
                patientinfoVo.setFirstName(rs.getString("FIRST_NAME"));
                patientinfoVo.setFatherName(rs.getString("FATHER_NAME"));
                patientinfoVo.setMobile(rs.getString("MOBILE"));
                patientinfoVo.setEmail(rs.getString("EMAIL"));
                usersVo=new UsersVo();
                usersVo.setId( rs.getInt("USER_ID"));
                patientinfoVo.setUsersVo(usersVo);
                
            }
             rs.close();
             ps.close();
            
        } catch(Exception ex){
        } finally {
             closeConnection(con);
         }
            return patientinfoVo; 
    }
    
    
}
