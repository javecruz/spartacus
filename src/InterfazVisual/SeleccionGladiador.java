/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazVisual;

import Model.Batalla;
import Model.Conex;
import Model.Gladiadores;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AlumMati
 */
public class SeleccionGladiador extends javax.swing.JFrame {
    
      static Connection con = null;
    static Conex pepe = new Conex();
    static Usuario user = new Usuario();
    static ArrayList<Gladiadores> listaGladiadoresOwn = new ArrayList<Gladiadores>();
    static DefaultTableModel modelOwn = new DefaultTableModel();
    static Object datosFilaOwn[] = new Object[1];     // 1 porque es una columnas solo, es la tabla..
    static ArrayList<Gladiadores> listaGladiadoresEnemy = new ArrayList<Gladiadores>();
    static DefaultTableModel modelEnemy = new DefaultTableModel();
    static Object datosFilaEnemy[] = new Object[1];     // 1 porque es una columnas solo, es la tabla..
    
    static Gladiadores gladOwn;
    static Gladiadores gladEnemy;
    
    
    
    
    
    /**
     * Creates new form SeleccionGladiador
     */
    /*public SeleccionGladiador() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage (new ImageIcon(getClass().getResource("../Img/iconoSpartacus.jpg")).getImage());
    }*/
    
    public SeleccionGladiador(Usuario user) {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage (new ImageIcon(getClass().getResource("../Img/iconoSpartacus.jpg")).getImage());
        this.user=user;
        generaTablaOwn();
        generaTablaEnemy();
    }

    
    public static void generaTablaOwn() {

        try {

            // cargo el nombre de todos los gladiadores
            con = pepe.AbrirConexion();
            String query = "Select * from gladiadores where propietario=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, user.getId());
            ResultSet rs = st.executeQuery();

            int Id;
            String Nombre;
            String Descripcion;
            int Precio;
            int Victorias;
            int Derrotas;
            int Fuerza;
            int Agilidad;
            int Vitalidad;
            int Defensa;
            int Propietario;

            // llena arraylist de todo el select
            listaGladiadoresOwn.clear(); // sino hago esto al volver atras y volver hacia delante vuelve a cargar gladiadores en la lista y habrán duplicados
            while (rs.next()) {

                Id = rs.getInt("id");
                Nombre = rs.getString("nombre");
                Descripcion = rs.getString("descripcion");
                Precio = rs.getInt("precio");
                Victorias = rs.getInt("victorias");
                Derrotas = rs.getInt("derrotas");
                Fuerza = rs.getInt("fuerza");
                Agilidad = rs.getInt("agilidad");
                Vitalidad = rs.getInt("vitalidad");
                Defensa = rs.getInt("defensa");
                Propietario = rs.getInt("propietario");

                Gladiadores glad = new Gladiadores(Id, Nombre, Descripcion, Precio, Victorias, Derrotas, Fuerza, Agilidad, Vitalidad, Defensa, Propietario);

                listaGladiadoresOwn.add(glad);

            }
            pepe.CerrarConexion(con);
            st.close();
            rs.close();

            // ahora hago lo de la tabla...
            /*if (model.getRowCount() > 0) {                                                // PENSABA QUE ESTO ERA PARA QUE NO VOLVIERA A CARGAR doblemente la lista pero no, con el clear.arraylist suficiente
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }*/

            modelOwn = (DefaultTableModel) tableOwn.getModel();

            for (int i = 0; i < listaGladiadoresOwn.size(); i++) {
                datosFilaOwn[0] = listaGladiadoresOwn.get(i).getNombre();
                modelOwn.addRow(datosFilaOwn);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ComercioGladiadores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

        }

    }
    
    public static void generaTablaEnemy() {

        try {

            // cargo el nombre de todos los gladiadores que sean de algun dueño que no sea el usuario, tampoco carga los que NO tienen dueño
            con = pepe.AbrirConexion();
            String query = "Select gladiadores.*,usuarios.login from gladiadores,usuarios where gladiadores.propietario=usuarios.id and propietario!=? and propietario!=0";
            PreparedStatement st = con.prepareStatement(query);
            st.setInt(1, user.getId());
            ResultSet rs = st.executeQuery();

            int Id;
            String Nombre;
            String Descripcion;
            int Precio;
            int Victorias;
            int Derrotas;
            int Fuerza;
            int Agilidad;
            int Vitalidad;
            int Defensa;
            int Propietario;
            ArrayList<String> logins = new ArrayList<String>();
            // llena arraylist de todo el select
            listaGladiadoresEnemy.clear(); // sino hago esto al volver atras y volver hacia delante vuelve a cargar gladiadores en la lista y habrán duplicados
            logins.clear();
            while (rs.next()) {

                Id = rs.getInt("id");
                Nombre = rs.getString("nombre");
                Descripcion = rs.getString("descripcion");
                Precio = rs.getInt("precio");
                Victorias = rs.getInt("victorias");
                Derrotas = rs.getInt("derrotas");
                Fuerza = rs.getInt("fuerza");
                Agilidad = rs.getInt("agilidad");
                Vitalidad = rs.getInt("vitalidad");
                Defensa = rs.getInt("defensa");
                Propietario = rs.getInt("propietario");

                Gladiadores glad = new Gladiadores(Id, Nombre, Descripcion, Precio, Victorias, Derrotas, Fuerza, Agilidad, Vitalidad, Defensa, Propietario);
                logins.add(rs.getString("login"));
                listaGladiadoresEnemy.add(glad);

            }
            pepe.CerrarConexion(con);
            st.close();
            rs.close();

            // ahora hago lo de la tabla...
            /*if (model.getRowCount() > 0) {                    // PENSABA QUE ESTO ERA PARA QUE NO VOLVIERA A CARGAR doblemente la lista pero no, con el clear.arraylist suficiente
                for (int i = model.getRowCount() - 1; i > -1; i--) {
                    model.removeRow(i);
                }
            }*/

            modelEnemy = (DefaultTableModel) tableEne.getModel();

            for (int i = 0; i < listaGladiadoresEnemy.size(); i++) {
                datosFilaEnemy[0] = listaGladiadoresEnemy.get(i).getNombre() + " ("+ logins.get(i)+")";
                modelEnemy.addRow(datosFilaEnemy);

            }

        } catch (SQLException ex) {
            Logger.getLogger(ComercioGladiadores.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ownDef = new javax.swing.JTextField();
        eneVit = new javax.swing.JTextField();
        ownVit = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ownStr = new javax.swing.JTextField();
        eneDef = new javax.swing.JTextField();
        eneStr = new javax.swing.JTextField();
        botonLuchar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        ownAgi = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        eneAgi = new javax.swing.JTextField();
        botonFlee = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableOwn = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableEne = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("ENEMIES");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 80, 30));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("YOUR GLADIATORS");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 150, 30));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("DEF");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 380, 30, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("STR");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 260, 30, 20));

        jLabel5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("VIT");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 30, 20));

        ownDef.setEditable(false);
        getContentPane().add(ownDef, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 50, 30));

        eneVit.setEditable(false);
        getContentPane().add(eneVit, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 290, 50, 30));

        ownVit.setEditable(false);
        getContentPane().add(ownVit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 50, 30));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("STR");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 30, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("VIT");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 30, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("DEF");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 30, 30));

        ownStr.setEditable(false);
        getContentPane().add(ownStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 50, 30));

        eneDef.setEditable(false);
        eneDef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eneDefActionPerformed(evt);
            }
        });
        getContentPane().add(eneDef, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 370, 50, 30));

        eneStr.setEditable(false);
        getContentPane().add(eneStr, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 50, 30));

        botonLuchar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonLuchar.setText("GO FIGHT");
        botonLuchar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLucharActionPerformed(evt);
            }
        });
        getContentPane().add(botonLuchar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 320, 170, 60));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("AGI");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 30, 30));

        ownAgi.setEditable(false);
        getContentPane().add(ownAgi, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 50, 30));

        jLabel10.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("AGI");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, 30, 20));

        eneAgi.setEditable(false);
        eneAgi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eneAgiActionPerformed(evt);
            }
        });
        getContentPane().add(eneAgi, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 330, 50, 30));

        botonFlee.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonFlee.setText("FLEE");
        botonFlee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFleeActionPerformed(evt);
            }
        });
        getContentPane().add(botonFlee, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 340, 70, 60));

        tableOwn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Yours Gladiators"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableOwn.getTableHeader().setReorderingAllowed(false);
        tableOwn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableOwnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableOwn);
        if (tableOwn.getColumnModel().getColumnCount() > 0) {
            tableOwn.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 150, 190));

        tableEne.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Enemies"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableEne.getTableHeader().setReorderingAllowed(false);
        tableEne.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableEneMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableEne);
        if (tableEne.getColumnModel().getColumnCount() > 0) {
            tableEne.getColumnModel().getColumn(0).setResizable(false);
        }

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 150, 190));

        fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/menuSeleccion.jpg"))); // NOI18N
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 625, 411));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void eneDefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eneDefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eneDefActionPerformed

    private void eneAgiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eneAgiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_eneAgiActionPerformed

    private void botonFleeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFleeActionPerformed
                MenuUsuario random = new MenuUsuario(user);       
                this.setVisible(false);
                random.setVisible(true);
    }//GEN-LAST:event_botonFleeActionPerformed

    private void tableOwnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableOwnMouseClicked
        
        
        int row = tableOwn.getSelectedRow();
        String tableClick = tableOwn.getModel().getValueAt(row, 0).toString();

        for (int i = 0; i < listaGladiadoresOwn.size(); i++) {

            if (listaGladiadoresOwn.get(i).getNombre().equalsIgnoreCase(tableClick)) {

                
                ownStr.setText(String.valueOf(listaGladiadoresOwn.get(i).getFuerza()));
                ownVit.setText(String.valueOf(listaGladiadoresOwn.get(i).getVitalidad()));
                ownAgi.setText(String.valueOf(listaGladiadoresOwn.get(i).getAgilidad()));
                ownDef.setText(String.valueOf(listaGladiadoresOwn.get(i).getDefensa()));
                gladOwn = listaGladiadoresOwn.get(i); // sera uno de los parametros que envie a la clase de batalla
                

            }

        }
        
        
    }//GEN-LAST:event_tableOwnMouseClicked

    private void tableEneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableEneMouseClicked
        
      
        
        
        
        
        
        
        int row = tableEne.getSelectedRow();
        String tableClick = tableEne.getModel().getValueAt(row, 0).toString();
        int loc = tableClick.indexOf('(');
        
        
        for (int i = 0; i < listaGladiadoresEnemy.size(); i++) {

            if (listaGladiadoresEnemy.get(i).getNombre().equalsIgnoreCase(tableClick.substring(0,loc-1))) {         // como cada row es GLadiador (dueño), tengo que quitar el dueño y coger solo el name del gladiador

                
                eneStr.setText(String.valueOf(listaGladiadoresEnemy.get(i).getFuerza()));
                eneVit.setText(String.valueOf(listaGladiadoresEnemy.get(i).getVitalidad()));
                eneAgi.setText(String.valueOf(listaGladiadoresEnemy.get(i).getAgilidad()));
                eneDef.setText(String.valueOf(listaGladiadoresEnemy.get(i).getDefensa()));
                gladEnemy = listaGladiadoresEnemy.get(i); // sera uno de los parametros que envie a la clase de batalla
                

            }

        }
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_tableEneMouseClicked

    private void botonLucharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonLucharActionPerformed
        
        
        
                Batalla objetoBatalla = new Batalla(gladOwn,gladEnemy); 
                BatallaFrame random = new BatallaFrame(objetoBatalla);
                this.setVisible(false);
                random.setVisible(true);
        
        
        
        
        
    }//GEN-LAST:event_botonLucharActionPerformed

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
            java.util.logging.Logger.getLogger(SeleccionGladiador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SeleccionGladiador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SeleccionGladiador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SeleccionGladiador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SeleccionGladiador(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFlee;
    private javax.swing.JButton botonLuchar;
    private javax.swing.JTextField eneAgi;
    private javax.swing.JTextField eneDef;
    private javax.swing.JTextField eneStr;
    private javax.swing.JTextField eneVit;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField ownAgi;
    private javax.swing.JTextField ownDef;
    private javax.swing.JTextField ownStr;
    private javax.swing.JTextField ownVit;
    private static javax.swing.JTable tableEne;
    private static javax.swing.JTable tableOwn;
    // End of variables declaration//GEN-END:variables
}
