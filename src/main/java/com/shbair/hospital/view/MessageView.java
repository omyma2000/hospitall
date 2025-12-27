/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shbair.hospital.view;

import com.shbair.hospital.db.dao.MessageDao;
import com.shbair.hospital.db.dao.UserDetailsDao;
import com.shbair.hospital.db.type.UsersType;
import com.shbair.hospital.db.vo.MessageVo;
import com.shbair.hospital.db.vo.PatientinfoVo;
import com.shbair.hospital.db.vo.UserDetailsVo;
import com.shbair.hospital.db.vo.UsersVo;
import com.shbair.hospital.validation.Validation;
import static com.shbair.hospital.view.UsersView.imageByte;
import java.awt.Image;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
//import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author LCS
 */
public class MessageView extends javax.swing.JFrame {
    DateFormat d ;
    java.util.Date messagedDate;
    
    /**
     * Creates new form MessageView
     */
    public MessageView() {
        initComponents();
        this.setLocationRelativeTo(null);
        DateFormat d =  new SimpleDateFormat("dd-mm-yyyy");
        messagedDate = Calendar.getInstance().getTime();
       txtMessageDate.setText(d.format(messagedDate));
       txtMessageDate.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtPatientId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtToUser = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtMessageDate = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessageBody = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();
        btnGetMessage = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        setResizable(false);

        jLabel1.setText("         Patient ID");

        jLabel2.setText("            To User");

        jLabel4.setText("       Message Date");

        jLabel5.setText("     Message Body ");

        txtMessageBody.setColumns(20);
        txtMessageBody.setRows(5);
        jScrollPane1.setViewportView(txtMessageBody);

        btnSend.setText("Send");
        btnSend.addActionListener(this::btnSendActionPerformed);

        btnGetMessage.setText("Get  Message");
        btnGetMessage.addActionListener(this::btnGetMessageActionPerformed);

        btnNew.setText("New");
        btnNew.addActionListener(this::btnNewActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtToUser, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtPatientId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtMessageDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(107, 107, 107))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnGetMessage)
                                .addGap(18, 18, 18)
                                .addComponent(btnNew)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSend, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPatientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtToUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMessageDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGetMessage)
                    .addComponent(btnSend)
                    .addComponent(btnNew))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        boolean isTextEmpty = Validation .isEmpty(txtToUser.getText(),txtPatientId.getText(),txtMessageDate.getText(),txtMessageBody.getText());
        boolean isDigit=Validation.isDigit(txtToUser.getText(),txtPatientId.getText());
        boolean isText= Validation.isText(txtMessageBody.getText());
        boolean isValidDate= Validation.isDate(txtMessageDate.getText());
         if (isTextEmpty || !isDigit ||!isText || !isValidDate) {
            JOptionPane.showMessageDialog(null,"please enter valid data!!! (check Date format DD-MM-YYYY) ");
            return;
        }
       try{
       int patientId = Integer.parseInt(txtPatientId.getText());
       int to = Integer.parseInt(txtToUser.getText());
       int from;
       if(Home.usersVo != null){
       from= Home.usersVo.getId();
       }else{
       from=1;
       
       }
       Date messageDate = Date.valueOf(txtMessageDate.getText());
       String messageBody = txtMessageBody.getText();
       MessageVo messageVo =new MessageVo();
       messageVo.setMessageBody(messageBody);
       messageVo.setMessageDate(messageDate);
       UsersVo fromUser = new UsersVo();
       fromUser.setId(from);
       messageVo.setFromUser(fromUser);
       UsersVo toUser = new UsersVo();
       toUser.setId(to);
       messageVo.setToUser(toUser);
       PatientinfoVo patientinfoVo =new PatientinfoVo();
       patientinfoVo.setId(patientId);
       messageVo.setPatientinfoVo(patientinfoVo);
      
          int count= MessageDao.getInstance().insert(messageVo);
           
            if (count>0){
            JOptionPane.showMessageDialog(null, "Insert successfully ");
                reset();
            }
           else{
              JOptionPane.showMessageDialog(null,"Insert failed !!! ");
              
            
            }
                    } catch (Exception ex) {
               JOptionPane.showMessageDialog(null,"Error "+ ex.getMessage());
               ex.printStackTrace();
               }
        
    }//GEN-LAST:event_btnSendActionPerformed

    private void btnGetMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGetMessageActionPerformed
    boolean isTextEmpty = Validation.isEmpty(txtPatientId.getText());
    boolean isDigit = Validation.isDigit(txtPatientId.getText());

if (isTextEmpty || !isDigit) {
    JOptionPane.showMessageDialog(null, "Please enter a valid ID!!!");
    return;
}

int patientID = Integer.parseInt(txtPatientId.getText());


try {
    MessageVo messageVo = MessageDao.getInstance().getDataByPatientIdAndUserId(patientID);

    if (messageVo == null) {
        JOptionPane.showMessageDialog(null, "ID does not exist!");
        reset(); // إعادة تعيين الحقول
    } else { 
    txtMessageBody.setText(messageVo.getMessageBody());
    txtMessageDate.setText(messageVo.getMessageDate().toString());
  
    }

} catch (Exception ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
}
        
    }//GEN-LAST:event_btnGetMessageActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
     reset();
     txtMessageDate.setText(d.format(messagedDate));
    }//GEN-LAST:event_btnNewActionPerformed
     protected  void  reset(){
     txtPatientId.setText("");
     txtToUser.setText("");
     txtMessageBody.setText("");
     txtMessageDate.setText(d.format(messagedDate));
     
      }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
           System.getLogger(UsersView.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MessageView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGetMessage;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txtMessageBody;
    private javax.swing.JTextField txtMessageDate;
    private javax.swing.JTextField txtPatientId;
    private javax.swing.JTextField txtToUser;
    // End of variables declaration//GEN-END:variables
}
