/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazVisual;

import Model.Conex;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author AlumMati
 */
public class CrearCuenta extends javax.swing.JFrame {

    static Connection con = null;
    static Conex pepe = new Conex();
    static ArrayList<String> listaNicknames = new ArrayList<String>();

    public CrearCuenta() {
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

        nameField = new javax.swing.JTextField();
        acceptButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        clearButtton = new javax.swing.JButton();
        Name = new javax.swing.JLabel();
        Surname = new javax.swing.JLabel();
        Nickname = new javax.swing.JLabel();
        Password = new javax.swing.JLabel();
        surnameField = new javax.swing.JTextField();
        nicknameField = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        passwordField = new javax.swing.JPasswordField();
        emailField = new javax.swing.JTextField();
        imagenFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(590, 350));
        setMinimumSize(new java.awt.Dimension(590, 350));
        setPreferredSize(new java.awt.Dimension(590, 350));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(nameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 230, -1));

        acceptButton.setText("Accept");
        acceptButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptButtonActionPerformed(evt);
            }
        });
        getContentPane().add(acceptButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 100, 30));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        getContentPane().add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 100, 30));

        clearButtton.setText("Clear");
        clearButtton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearButttonActionPerformed(evt);
            }
        });
        getContentPane().add(clearButtton, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 270, 120, 30));

        Name.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Name.setForeground(new java.awt.Color(255, 255, 255));
        Name.setText("Name");
        getContentPane().add(Name, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 90, -1));

        Surname.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Surname.setForeground(new java.awt.Color(255, 255, 255));
        Surname.setText("Surname");
        getContentPane().add(Surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 70, -1));

        Nickname.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Nickname.setForeground(new java.awt.Color(255, 255, 255));
        Nickname.setText("Nickname");
        getContentPane().add(Nickname, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 60, -1));

        Password.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.setText("Password");
        getContentPane().add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 70, -1));

        surnameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                surnameFieldActionPerformed(evt);
            }
        });
        getContentPane().add(surnameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 230, -1));
        getContentPane().add(nicknameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 230, -1));

        Email.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
        Email.setText("Email");
        getContentPane().add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 80, -1));

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        getContentPane().add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 230, -1));
        getContentPane().add(emailField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 230, -1));

        imagenFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/crearCuenta.jpg"))); // NOI18N
        imagenFondo.setText("jLabel1");
        getContentPane().add(imagenFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        MenuLogin random = new MenuLogin();
        this.setVisible(false);
        random.setVisible(true);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void surnameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_surnameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_surnameFieldActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void clearButttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearButttonActionPerformed

        nameField.setText("");
        surnameField.setText("");
        nicknameField.setText("");
        passwordField.setText("");
        emailField.setText("");

    }//GEN-LAST:event_clearButttonActionPerformed

    private void acceptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptButtonActionPerformed

        String name, surname, nickname, password, email;
        Boolean sw = false;

        name = nameField.getText();
        surname = surnameField.getText();
        nickname = nicknameField.getText();
        password = passwordField.getText();
        email = emailField.getText();

        if (name.isEmpty() || surname.isEmpty() || nickname.isEmpty() || password.isEmpty() || email.isEmpty()) {
            sw = true;
            JOptionPane.showMessageDialog(null, "ALGUN CAMPO LO HAS DEJADO VACIO");

        }

        //ahora miro si el nickname ya esta repetido
        if (sw == false) {

            for (int i = 0; i < listaNicknames.size(); i++) {
                if (listaNicknames.get(i).equalsIgnoreCase(nickname)) {
                    sw = true;
                    JOptionPane.showMessageDialog(null, "Nickname Ya USADO, utilice otro.");
                }

            }

        }
        if(sw==false){
        try {
            con = pepe.AbrirConexion();
            String query = "insert into usuarios(nombre,apellidos,login,pass,email) values(?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, surname);
            st.setString(3, nickname);
            st.setString(4, password);
            st.setString(5, email);
            st.executeUpdate();
            
            pepe.CerrarConexion(con);
            st.close();
            
            
            
            

        } catch (SQLException e) {
            JOptionPane.showInputDialog(null, "ERROR EN LA CONEXION");

        }finally{
        
        pepe.CerrarConexion(con);
        MenuLogin random = new MenuLogin();
        this.setVisible(false);
        random.setVisible(true);
        
      
        }
        
        
        }

    }//GEN-LAST:event_acceptButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
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
                java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (InstantiationException ex) {
                java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (IllegalAccessException ex) {
                java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                java.util.logging.Logger.getLogger(CrearCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
            //</editor-fold>

            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new CrearCuenta().setVisible(true);
                }
            });

            // hago una consulta para hace run arraylist de los nicknames para que no se repita ninguno
            con = pepe.AbrirConexion();
            String query = "Select login from usuarios";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                listaNicknames.add(rs.getString("login"));
            }

            rs.close();
            st.close();
            pepe.CerrarConexion(con);

        } catch (SQLException ex) {
            Logger.getLogger(CrearCuenta.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Email;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Nickname;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Surname;
    private javax.swing.JButton acceptButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton clearButtton;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel imagenFondo;
    private javax.swing.JTextField nameField;
    private javax.swing.JTextField nicknameField;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JTextField surnameField;
    // End of variables declaration//GEN-END:variables
}
