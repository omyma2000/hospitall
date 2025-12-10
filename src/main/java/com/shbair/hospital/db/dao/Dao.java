package com.shbair.hospital.db.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;
// ربط البروجكت مع الداتابيس
public class Dao {

    public  Connection getConnection() throws Exception {
        // تحميل الدرايفر
        Class.forName("com.mysql.cj.jdbc.Driver");

        // الاتصال بقاعدة البيانات
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");
         if (con != null) {
            
            return con;
        }

        return null;
    }
    public void closeconnection(Connection con) throws Exception{
    if (con != null){
    con.close();
    }
    
    }

    
}
