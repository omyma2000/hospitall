/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.shbair.hospital.view;
import com.shbair.hospital.db.vo.UsersVo;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author LCS
 */
public class Home extends javax.swing.JFrame {
    
   public static UsersVo usersVo =null;
    /**
     * Creates new form Home
     * @param uv
     */
    public Home(UsersVo uv) {
    initComponents();        // 1️⃣ أنشئي القوائم أولاً
    usersVo = uv;            // 2️⃣ تخزين المستخدم
    getUserLevel();          // 4️⃣ فعّلي حسب الصلاحية
    this.setLocationRelativeTo(null);
        scaleImage("C:\\Users\\LCS\\OneDrive\\المستندات\\NetBeansProjects\\HospitalSystem\\image\\images.jpg" , ImageLabel);
       
    }
    private  void scaleImage(String imagePath,javax.swing.JLabel ImageLabel){
    ImageIcon icon = new ImageIcon(imagePath);
    int width=ImageLabel.getWidth();
    int height = ImageLabel.getHeight();
    if(width>0&&height>0){}
     Image img = icon.getImage();
     Image newImg= img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
     ImageLabel.setIcon(new ImageIcon(newImg));
    
    }
   private void getUserLevel(){
    // 1. فحص هل الكائن موجود؟
    if(Home.usersVo == null || Home.usersVo.getUsersType() == null || 
       Home.usersVo.getUsersType().getType() == null){
        System.out.println("Error: User or Type is Null !!");  
        return;
    }

    // 2. جلب النوع وتحويله لحروف صغيرة لتجنب أخطاء المطابقة
   String type = usersVo.getUsersType().getType().toLowerCase().trim();
   System.out.println("Current Logged User Type: " + type); // للـ Debug
   // 4. تفعيل المسموح به فقط
   
   switch(type){
       case "admin":
            madmin.setEnabled(true);
            mDoctor.setEnabled(false);
            mReception.setEnabled(false);
            mNurse.setEnabled(false);
     
           break;
        case "doctor":
            mdoctor.setEnabled(true);
            mAdmin.setEnabled(false);
            mReception.setEnabled(false);
            mNurse.setEnabled(false);
            break;
        case "reception": 
            mreception.setEnabled(true);
             mAdmin.setEnabled(false);
             mDoctor.setEnabled(false);
             mNurse.setEnabled(false);
            break;
        case "nurse":
            mnurse.setEnabled(true);
            mAdmin.setEnabled(false);
            mDoctor.setEnabled(false);
            mReception.setEnabled(false);
            break;
        default:
            System.out.println("Unknown type: " + type);
            // يمكن تعطيل الكل في حال وجود نوع غير معروف
          
            mAdmin.setEnabled(false);
            mDoctor.setEnabled(false);
            mReception.setEnabled(false);
            mNurse.setEnabled(false);
            break;
    }
}

// دالة مساعدة لتعطيل جميع القوائم


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        ImageLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        madmin = new javax.swing.JMenu();
        mAdmin = new javax.swing.JMenuItem();
        mdoctor = new javax.swing.JMenu();
        mDoctor = new javax.swing.JMenuItem();
        mreception = new javax.swing.JMenu();
        mReception = new javax.swing.JMenuItem();
        mnurse = new javax.swing.JMenu();
        mNurse = new javax.swing.JMenuItem();

        jMenuItem2.setText("jMenuItem2");

        jMenuItem3.setText("jMenuItem3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        ImageLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\LCS\\OneDrive\\المستندات\\NetBeansProjects\\HospitalSystem\\image\\photo.jpg")); // NOI18N
        ImageLabel.setMaximumSize(new java.awt.Dimension(630, 431));

        madmin.setText("Admin");

        mAdmin.setText("Add new user ");
        mAdmin.addActionListener(this::mAdminActionPerformed);
        madmin.add(mAdmin);

        jMenuBar1.add(madmin);

        mdoctor.setText("Doctor");

        mDoctor.setText("Patient info");
        mDoctor.addActionListener(this::mDoctorActionPerformed);
        mdoctor.add(mDoctor);

        jMenuBar1.add(mdoctor);

        mreception.setText("Reception");

        mReception.setText("PatientInfo");
        mReception.addActionListener(this::mReceptionActionPerformed);
        mreception.add(mReception);

        jMenuBar1.add(mreception);

        mnurse.setText("Nurse");

        mNurse.setText("patientinfo");
        mNurse.addActionListener(this::mNurseActionPerformed);
        mnurse.add(mNurse);

        jMenuBar1.add(mnurse);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 846, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ImageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 456, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mAdminActionPerformed
        UsersView usersView = new UsersView();
        usersView.setVisible(true);
    }//GEN-LAST:event_mAdminActionPerformed

    private void mReceptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mReceptionActionPerformed
        PatientinfoView patientinfoView = new PatientinfoView();
        patientinfoView.setVisible(true);
    }//GEN-LAST:event_mReceptionActionPerformed

    private void mDoctorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mDoctorActionPerformed
        MessageView messageView = new MessageView();
        messageView.setVisible(true);
    }//GEN-LAST:event_mDoctorActionPerformed

    private void mNurseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNurseActionPerformed
       MessageView messageView = new MessageView();
        messageView.setVisible(true);
    }//GEN-LAST:event_mNurseActionPerformed
   
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
             Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null ,ex);
      
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
            //new Home().setVisible(true));
            }
        });{ 
               
    }}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImageLabel;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem mAdmin;
    private javax.swing.JMenuItem mDoctor;
    private javax.swing.JMenuItem mNurse;
    private javax.swing.JMenuItem mReception;
    private javax.swing.JMenu madmin;
    private javax.swing.JMenu mdoctor;
    private javax.swing.JMenu mnurse;
    private javax.swing.JMenu mreception;
    // End of variables declaration//GEN-END:variables
}
