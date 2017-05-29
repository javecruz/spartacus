/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package InterfazVisual;

import Model.Batalla;
import Model.Conex;
import Model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.ThreadLocalRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class BatallaFrame extends javax.swing.JFrame {

    static Connection con = null;
    static Conex pepe = new Conex();

    static Batalla bat;
    static int ronda;
    //stas del Own
    static int strOwn;
    static int agiOwn;
    static int defOwn;
    static int vitOwn;
    //stats del Ene
    static int strEne;
    static int agiEne;
    static int defEne;
    static int vitEne;
    static int recompensa;
    static String texto = "";
    
    static Usuario userObjeto = new Usuario(); // es para cargar el menu usuario cuando finalice una batalla

    /*  public BatallaFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../Img/iconoSpartacus.jpg")).getImage());
       
    }*/
    public BatallaFrame(Batalla bat) {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("../Img/iconoSpartacus.jpg")).getImage());
        this.bat = bat;
        this.strOwn = bat.getGladOwn().getFuerza();
        this.agiOwn = bat.getGladOwn().getAgilidad();
        this.defOwn = bat.getGladOwn().getDefensa();
        this.vitOwn = bat.getGladOwn().getVitalidad();
        this.strEne = bat.getGladEne().getFuerza();
        this.agiEne = bat.getGladEne().getAgilidad();
        this.defEne = bat.getGladEne().getDefensa();
        this.vitEne = bat.getGladEne().getVitalidad();
        ronda = 0;
        loadProgressBars();
        volverMenu.setVisible(false);
    }

    public void loadProgressBars() {
        barOwn.setMaximum(bat.getGladOwn().getVitalidad());
        barEne.setMaximum(bat.getGladEne().getVitalidad());
        barOwn.setValue(bat.getGladOwn().getVitalidad());
        barEne.setValue(bat.getGladEne().getVitalidad());
        barOwn.setString(String.valueOf(bat.getGladOwn().getVitalidad()));
        barEne.setString(String.valueOf(bat.getGladEne().getVitalidad()));

    }

    public static void ronda() {

        ronda++;
        roundLabel.setText(String.valueOf(ronda));

        if (procesoStats(agiOwn, agiEne) == 1) {
            texto = texto.concat("ÉXITO, has ganado la tirada de agilidad atacas primero.\n");
            if (procesoStats(strOwn, defEne) == 1) {
                texto = texto.concat("ÉXITO, has ganado la tirada de fuerza le inflinges 1 punto de daño.\n");
                vitEne--;
                barEne.setValue(vitEne);
                barEne.setString(String.valueOf(vitEne));

                if (vitEne == 0) {

                    JOptionPane.showMessageDialog(null, "HAS SALIDO VICTORIOSO EN LA ARENA EL CLAMOR DE LA GENTE ENSORDECE EL AMBIENTE");
                    recompensa(1);
                    fightButton.setVisible(false);
                    volverMenu.setVisible(true);
                }

            } else {
                texto = texto.concat("FRACASO, el enemigo se ha defendido de tu ataque.\n");
            }

        } else {
            texto = texto.concat("FRACASO, el enemigo ha ganado la tirada de agilidad atacará primero.\n");
            if (procesoStats(defOwn, strEne) == 2) {
                texto = texto.concat("FRACASO, el enemigo ha ganado la tirada de fuerza te hace 1 punto de daño.\n");
                vitOwn--;
                barOwn.setValue(vitOwn);
                barOwn.setString(String.valueOf(vitOwn));
                if (vitOwn == 0) {

                    JOptionPane.showMessageDialog(null, "HAS SIDO DERROTADO EN LA ARENA");
                    recompensa(2);
                    fightButton.setVisible(false);
                    volverMenu.setVisible(true);

                }
            } else {
                texto = texto.concat("ÉXITO, te has  defendido del ataque de tu enemigo.\n");
            }

        }

        //texto = texto.concat("Vida Propia:" + vitOwn + " ---------- Vida Enemigo: " + vitEne + "\n\n");
        info.setText(texto);
        texto = "";

    }

    public static int procesoStats(int statsOwn, int statsEne) {
        int unoRes;
        int dosRes;
        int ganador = 0; //1==own  2==eni

        do {
            unoRes = ThreadLocalRandom.current().nextInt(0, statsOwn + 1);
            dosRes = ThreadLocalRandom.current().nextInt(0, statsEne + 1);
            if (unoRes > dosRes) {
                ganador = 1;
            } else if (dosRes > unoRes) {
                ganador = 2;
            }
        } while (unoRes == dosRes);

        texto = texto.concat("Has sacado un " + unoRes + " y el enemigo ha sacado un " + dosRes + ".\n");

        return ganador;
    }

    public static void recompensa(int ganador) {     // 1 == own    2 == Enemy

        int premio = 5;
        int idGanador = 0;
        int idPerdedor = 0;
        int userIdGanador = 0;
        int userIdPerdedor = 0;
        
       
        if (ganador == 1) {
            premio = premio + ((bat.getGladOwn().getVitalidad() - vitOwn) * 10);
           // System.out.println("premio "+ premio);
            idGanador = bat.getGladOwn().getId();
            //System.out.println("idGanador = "+idGanador);
            idPerdedor = bat.getGladEne().getId();
            //System.out.println("idPerdedor = " + idPerdedor);
            userIdGanador = bat.getGladOwn().getPropietario();
            //System.out.println("userIdGanador = "+userIdGanador);
            userIdPerdedor = bat.getGladEne().getPropietario();
            //System.out.println("userIdPerdedor = " + userIdPerdedor);

        } else if (ganador == 2) {
            
            premio = premio + ((bat.getGladEne().getVitalidad() - vitEne) * 10);
            //System.out.println("premio "+ premio);
            idGanador = bat.getGladEne().getId();
            idPerdedor = bat.getGladOwn().getId();
            userIdGanador = bat.getGladEne().getPropietario();
            userIdPerdedor = bat.getGladOwn().getPropietario();
            
        }
        
        
        
            try {

               con = pepe.AbrirConexion();
                
               // update victorias al ganador
                String query = "update gladiadores set victorias = victorias + 1 where id=?";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,idGanador);
                ps.executeUpdate();
                ps.close();
                
                //update derrotas al perdedor
                String query2 = "update gladiadores set derrotas = derrotas + 1 where id=?";
                PreparedStatement ps2 = con.prepareStatement(query2);
                ps2.setInt(1, idPerdedor);
                ps2.executeUpdate();
                ps2.close();
                
                
                //update del premio al usuario ganador
                String query3 = "update usuarios set saldo = saldo + ? where id=?";
                PreparedStatement ps3 = con.prepareStatement(query3);
                ps3.setInt(1, premio);
                ps3.setInt(2, userIdGanador);
                ps3.executeUpdate();
                ps3.close();
                
                
                pepe.CerrarConexion(con);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "ERROR EN BBDD al hacer los updates de la batalla cuando gana el enemigo");
            }
            
        

        
        // y aqui hago un insert de batalla
        
        try{
            
          
            
        con = pepe.AbrirConexion();
        String query4 = "insert into batalla(ganadorId,perdedorId,premio,fecha) values(?,?,?,CURRENT_TIMESTAMP)";
        PreparedStatement ps4 = con.prepareStatement(query4);
        ps4.setInt(1,userIdGanador);
        ps4.setInt(2,userIdPerdedor);
        ps4.setInt(3,premio);
        ps4.executeUpdate();
        ps4.close();

        }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "ERROR cuando hace insert en batalla table");
        
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

        JScrollPane = new javax.swing.JScrollPane();
        info = new javax.swing.JTextArea();
        fightButton = new javax.swing.JButton();
        barOwn = new javax.swing.JProgressBar();
        barEne = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        roundLabel = new javax.swing.JLabel();
        volverMenu = new javax.swing.JButton();
        fondoImg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        info.setColumns(20);
        info.setRows(5);
        info.setOpaque(false);
        JScrollPane.setViewportView(info);

        getContentPane().add(JScrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 440, 200));

        fightButton.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        fightButton.setText("FIGHT");
        fightButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fightButtonActionPerformed(evt);
            }
        });
        getContentPane().add(fightButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 490, 160, 70));

        barOwn.setBackground(new java.awt.Color(255, 0, 51));
        barOwn.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        barOwn.setForeground(new java.awt.Color(0, 0, 0));
        barOwn.setStringPainted(true);
        getContentPane().add(barOwn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 490, 250, 70));

        barEne.setBackground(new java.awt.Color(255, 0, 51));
        barEne.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        barEne.setForeground(new java.awt.Color(0, 0, 0));
        barEne.setStringPainted(true);
        getContentPane().add(barEne, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 490, 250, 70));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("ROUND");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 140, 50));

        roundLabel.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        roundLabel.setText("0");
        getContentPane().add(roundLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 100, 50, 50));

        volverMenu.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        volverMenu.setText("Menu Principal");
        volverMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverMenuActionPerformed(evt);
            }
        });
        getContentPane().add(volverMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 490, 230, 60));

        fondoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/batalla.jpg"))); // NOI18N
        getContentPane().add(fondoImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fightButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fightButtonActionPerformed

        if ((vitOwn > 0 && vitEne > 0)) {
            ronda();
        }
        
        
    }//GEN-LAST:event_fightButtonActionPerformed

    private void volverMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverMenuActionPerformed
        
        
        try {
            con = pepe.AbrirConexion();
            ResultSet rs5 = null;
            String query5 = "select * from usuarios where id=?";
            PreparedStatement ps5 = con.prepareStatement(query5);
            ps5.setInt(1,bat.getGladOwn().getPropietario());
            rs5 = ps5.executeQuery();
            
            while(rs5.next()){
            userObjeto.setId(rs5.getInt("id"));  
            userObjeto.setLogin(rs5.getString("login"));
            userObjeto.setPass(rs5.getString("pass"));
            userObjeto.setNombre(rs5.getString("nombre"));
            userObjeto.setApellidos(rs5.getString("apellidos"));
            userObjeto.setPermisos(rs5.getInt("permisos"));
            userObjeto.setSaldo(rs5.getInt("saldo"));
            userObjeto.setVictorias(rs5.getInt("victorias"));
            userObjeto.setDerrotas(rs5.getInt("derrotas"));
            userObjeto.setRatio(rs5.getFloat("ratio"));
            }
                    System.out.println(userObjeto.getSaldo());
            pepe.CerrarConexion(con);
            ps5.close();
            rs5.close();
            
            
                MenuUsuario random = new MenuUsuario(userObjeto);       
                this.setVisible(false);
                random.setVisible(true);
            
            
            
            
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERROR cuando intenta volver al menu principal tras la batalla");
        }
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_volverMenuActionPerformed

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
            java.util.logging.Logger.getLogger(BatallaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BatallaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BatallaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BatallaFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BatallaFrame(bat).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane JScrollPane;
    private static javax.swing.JProgressBar barEne;
    private static javax.swing.JProgressBar barOwn;
    private static javax.swing.JButton fightButton;
    private javax.swing.JLabel fondoImg;
    private static javax.swing.JTextArea info;
    private javax.swing.JLabel jLabel1;
    private static javax.swing.JLabel roundLabel;
    private static javax.swing.JButton volverMenu;
    // End of variables declaration//GEN-END:variables
}
