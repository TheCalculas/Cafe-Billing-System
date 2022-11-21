/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cafe.management.system.Admin;

import dao.AdminDAO;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Admin;

/**
 *
 * @author dharm
 */
public class AdminLogin extends javax.swing.JFrame {

    public String emailPattern = "^[a-zA-Z0-9]+[@]+[a-zA-Z0-9]+[.]+[a-zA-Z0-9]+$";
    public String mobileNumberPattern = "^[0-9]*$";

    /**
     * Creates new form AdminLogin
     */
    public AdminLogin() {
        initComponents();
//        setAlwaysOnTop(true);
//        setResizable(true);
//        setVisible(true);
//        Toolkit tk = Toolkit.getDefaultToolkit();
//        int x = (int) tk.getScreenSize().getWidth();
//        int y = (int) tk.getScreenSize().getHeight();
//        setSize(x, y);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
    }

    public void clear() {
        sName.setText("");
        sPassword.setText("");
        sLogin.setEnabled(false);
    }

    public void validateFeilds() {
        String email = sName.getText();
        String password = sPassword.getText();
        if (email.matches(emailPattern) && !password.equals("")) {
            sLogin.setEnabled(true);
        } else {
            sLogin.setEnabled(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        sName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        sPassword = new javax.swing.JPasswordField();
        sLogin = new javax.swing.JButton();
        sClear = new javax.swing.JButton();
        sExit = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Admin Login");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 80, -1, -1));

        sName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sNameActionPerformed(evt);
            }
        });
        sName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sNameKeyReleased(evt);
            }
        });
        getContentPane().add(sName, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 290, 301, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Email");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 293, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(401, 349, -1, -1));

        sPassword.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        sPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sPasswordActionPerformed(evt);
            }
        });
        sPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sPasswordKeyReleased(evt);
            }
        });
        getContentPane().add(sPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(595, 346, 301, -1));

        sLogin.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/login.png"))); // NOI18N
        sLogin.setText("Login");
        sLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sLoginMouseClicked(evt);
            }
        });
        sLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sLoginActionPerformed(evt);
            }
        });
        getContentPane().add(sLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 450, -1, -1));

        sClear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/eraser icon.png"))); // NOI18N
        sClear.setText("Clear");
        sClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sClearActionPerformed(evt);
            }
        });
        getContentPane().add(sClear, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 450, -1, -1));

        sExit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        sExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.png"))); // NOI18N
        sExit.setText("Exit");
        sExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sExitActionPerformed(evt);
            }
        });
        getContentPane().add(sExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 450, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cafe_login.jpg"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sNameActionPerformed

    private void sNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sNameKeyReleased
        // TODO add your handling code here:
        validateFeilds();
    }//GEN-LAST:event_sNameKeyReleased

    private void sPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sPasswordActionPerformed

    private void sPasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sPasswordKeyReleased
        // TODO add your handling code here:
        validateFeilds();
    }//GEN-LAST:event_sPasswordKeyReleased

    private void sLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sLoginActionPerformed
        // mera user login ho jaaye
        //       User user = new User();
        Admin admin = null;
        admin = AdminDAO.login(sName.getText(), sPassword.getText());
        //        System.out.print(user);
        if (admin == null) {
            JOptionPane.showMessageDialog(null, "Incorrect Details Check Again");
        } else {
            // agar user ko kaam pe rakaha hai toh

            // isse ye window shut down ho jaayegi
            setVisible(false);
            new AdminHomepage(sName.getText()).setVisible(true);

        }

    }//GEN-LAST:event_sLoginActionPerformed

    private void sClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sClearActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_sClearActionPerformed

    private void sExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sExitActionPerformed
        // TODO add your handling code here:
        int a = JOptionPane.showConfirmDialog(null, "Do you really want to close the app?", "Select", JOptionPane.YES_NO_OPTION);
        // agar message ka status true hai toh exit kardo
        if (a == 0) {
            System.exit(0);
        }
    }//GEN-LAST:event_sExitActionPerformed

    private void sLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_sLoginMouseClicked

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JButton sClear;
    private javax.swing.JButton sExit;
    private javax.swing.JButton sLogin;
    private javax.swing.JTextField sName;
    private javax.swing.JPasswordField sPassword;
    // End of variables declaration//GEN-END:variables
}
