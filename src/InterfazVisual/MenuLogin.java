/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazVisual;

import Model.Conex;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AlumMati
 */
public class MenuLogin extends javax.swing.JFrame {

    static Connection con = null;
    static Conex pepe = new Conex();
    static Usuario userObjeto = new Usuario();

    public MenuLogin() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../Img/iconoSpartacus.jpg")).getImage());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botonLogin = new javax.swing.JButton();
        botonCrearCuenta = new javax.swing.JButton();
        userField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        imgFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 505));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonLogin.setText("Login");
        botonLogin.setPreferredSize(new java.awt.Dimension(60, 25));
        botonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(botonLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 250, 120, 50));

        botonCrearCuenta.setText("Create Account");
        botonCrearCuenta.setPreferredSize(new java.awt.Dimension(60, 25));
        botonCrearCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCrearCuentaActionPerformed(evt);
            }
        });
        getContentPane().add(botonCrearCuenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 250, 120, 50));

        userField.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        getContentPane().add(userField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 210, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("USER:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 70, 20));

        jLabel3.setBackground(new java.awt.Color(0, 0, 0));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("PASS:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 70, 20));

        passField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passField, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 210, 210, -1));

        imgFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menuLogin.jpg"))); // NOI18N
        getContentPane().add(imgFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonCrearCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCrearCuentaActionPerformed
        CrearCuenta random = new CrearCuenta();
        this.setVisible(false);
        random.setVisible(true);
    }//GEN-LAST:event_botonCrearCuentaActionPerformed

    private void passFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passFieldActionPerformed

    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLoginActionPerformed

        String user;
        String pass;
        int id;
        Boolean sw = false;
        user = userField.getText();
        pass = passField.getText();
        ResultSet rs = null;
        try {
            con = pepe.AbrirConexion();
            String query = "select * from usuarios where login=? and pass=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, user);
            st.setString(2, pass);
            rs = st.executeQuery();
            //si está vacio entra en el if
            
            
            while(rs.next()){
            
            userObjeto.setId(rs.getInt("id"));  
            userObjeto.setLogin(rs.getString("login"));
            userObjeto.setPass(rs.getString("pass"));
            userObjeto.setNombre(rs.getString("nombre"));
            userObjeto.setApellidos(rs.getString("apellidos"));
            userObjeto.setPermisos(rs.getInt("permisos"));
            userObjeto.setSaldo(rs.getInt("saldo"));
            userObjeto.setVictorias(rs.getInt("victorias"));
            userObjeto.setDerrotas(rs.getInt("derrotas"));
            userObjeto.setRatio(rs.getFloat("ratio"));
            }
            
            rs.beforeFirst();
            
            if (!rs.isBeforeFirst()) {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecta, vuelva a intentarlo");
                sw = true;
            }

            pepe.CerrarConexion(con);
            st.close();
            

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(rootPane, "ERROR EN BBDD");
        } finally {

            if (sw == false) {
                MenuUsuario random = new MenuUsuario(userObjeto);       
                this.setVisible(false);
                random.setVisible(true);
            }

        }


    }//GEN-LAST:event_botonLoginActionPerformed

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
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonCrearCuenta;
    private javax.swing.JButton botonLogin;
    private javax.swing.JLabel imgFondo;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
