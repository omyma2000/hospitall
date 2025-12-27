
package com.shbair.hospital.db.dao;

import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.MessageVo;
import com.shbair.hospital.db.vo.PatientinfoVo;
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
public class MessageDao extends Dao implements DaoList<MessageVo>{

     private static MessageDao messageDao;
    // CONSTRUCTOR
    private MessageDao() {}

    public static MessageDao getInstance() {
        if (messageDao == null){
          messageDao = new MessageDao();
        }
          return messageDao;
    }
    
    
    
    @Override
    public List<MessageVo> LoadAll() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int insert(MessageVo mv) throws Exception {
    Connection con = null;
    PreparedStatement ps = null;
    int count = 0;
    try {
        con = getConnection();
        String sql = "INSERT INTO MESSAGES (MESSAGE_BODY,MESSAGE_DATE,FROM_USER,TO_USER,PATIENT_ID) VALUES (?,?,?,?,?)";
       ps = con.prepareStatement(sql);
       ps.setString(1, mv.getMessageBody());
       ps.setDate(2, mv.getMessageDate());
       ps.setInt(3, mv.getFromUser().getId());
       ps.setInt(4, mv.getToUser().getId());
       ps.setInt(5, mv.getPatientinfoVo().getId());
       System.out.println("insert "+mv.getMessageBody());
       count = ps.executeUpdate();
        System.out.println("number of column"+ count);
    } catch (Exception ex) {
        ex.printStackTrace();
        throw ex;
    } finally {
         if(ps != null)
             ps.close();
        closeConnection(con);
    }

    return count ; 
    }

    @Override
    public int update(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int delete(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MessageVo getData(MessageVo t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public MessageVo getDataById(int id) throws Exception {
         throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
 
    }
     public MessageVo getDataByPatientIdAndUserId(int patientID) throws Exception{
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    MessageVo messageVo = null;
    UsersVo fromUser = null;
    UsersVo toUser = null;
    PatientinfoVo patientinfoVo = null;
    try {
        con = getConnection();
        String sql = "SELECT ID,MESSAGE_BODY,MESSAGE_DATE,FROM_USER ,TO_USER ,PATIENT_ID FROM messages WHERE PATIENT_ID=?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, patientID);
        rs = ps.executeQuery();
        if (rs.next()) {
            messageVo =new MessageVo();
            messageVo.setId(rs.getInt("ID"));
            messageVo.setMessageBody(rs.getString("MESSAGE_BODY"));
            messageVo.setMessageDate(rs.getDate("MESSAGE_DATE"));
            fromUser = new UsersVo();
            fromUser.setId(rs.getInt("FROM_USER"));
            messageVo.setFromUser(fromUser);
            toUser = new UsersVo();
            toUser.setId(rs.getInt("TO_USER"));
            messageVo.setToUser(toUser);
            patientinfoVo = new PatientinfoVo();
            patientinfoVo.setId(rs.getInt("PATIENT_ID"));
            messageVo.setPatientinfoVo(patientinfoVo);
            System.out.println("✅ DATA FOUND FOR ID = " + patientID );
        }else{
            System.out.println("❌ NO DATA FOUND FOR ID = " + patientID );
            return null;
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionpane.showMessageDialog(null, ex.getMessage());
        throw ex;
    } finally {
         if (rs != null) rs.close();
         if (ps != null) ps.close();
        closeConnection(con);
    }

    return messageVo;
}
     
     
     }
    
    

