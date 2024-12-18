/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

/**
 *
 * @author Muhammad Nabil Ma'ru
 */

import Controller.PeminjamanController;
import Model.PeminjamanModel;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class MenuPinjamRuangan extends javax.swing.JFrame {
    private final PeminjamanController con;
    
    public MenuPinjamRuangan() throws SQLException {
        initComponents();
        con = new PeminjamanController();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TanggalField = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        NIMfield = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        WaktuComboBox = new javax.swing.JComboBox<>();
        KelasComboBox = new javax.swing.JComboBox<>();
        ProdiComboBox = new javax.swing.JComboBox<>();
        IDField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel2.setText("Kelas");

        jLabel6.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel6.setText("Prodi");

        jLabel7.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel7.setText("Hari & Tanggal");

        TanggalField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        TanggalField.setForeground(new java.awt.Color(0, 0, 0));
        TanggalField.setText("Tahun/Bulan/Hari");
        TanggalField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TanggalFieldActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel8.setText("Jam");

        jButton3.setBackground(new java.awt.Color(39, 45, 90));
        jButton3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(255, 0, 51));
        jButton4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        NIMfield.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        NIMfield.setForeground(new java.awt.Color(0, 0, 0));
        NIMfield.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NIMfieldActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel5.setText("ID Kelas");

        WaktuComboBox.setForeground(new java.awt.Color(0, 0, 0));
        WaktuComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "7:30 - 9:00", "9:10 - 10:40", "10:50 - 12:20", "13:00 - 14:30", "14:40 - 16:10" }));
        WaktuComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WaktuComboBoxActionPerformed(evt);
            }
        });

        KelasComboBox.setForeground(new java.awt.Color(0, 0, 0));
        KelasComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "A101", "A102", "A103", "A104", "B201", "B202", "B203", "C302", "C303", "D401", "D402", "D404" }));
        KelasComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KelasComboBoxActionPerformed(evt);
            }
        });

        ProdiComboBox.setForeground(new java.awt.Color(0, 0, 0));
        ProdiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Teknik Sipil", "Teknik Industri", "Teknik Lingkungan", "Teknik Informatika", "Sistem Informasi", "Teknik Pertambangan", "Teknik Elektro", "Teknik Arsitektur", "Teknik Geologi", "Teknik Kimia" }));
        ProdiComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProdiComboBoxActionPerformed(evt);
            }
        });

        IDField.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        IDField.setForeground(new java.awt.Color(0, 0, 0));
        IDField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDFieldActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Poppins", 0, 18)); // NOI18N
        jLabel9.setText("NIM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TanggalField, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                            .addComponent(NIMfield, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(WaktuComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(KelasComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ProdiComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(IDField))))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NIMfield, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(KelasComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(ProdiComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TanggalField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(WaktuComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 610, 420));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Pinjam");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 70, -1, 70));

        jLabel3.setFont(new java.awt.Font("Poppins", 1, 64)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ruangan");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, -1, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/Untitled design (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1030, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    // TODO add your handling code here:
    // Ambil data inputan dari form
    String id = IDField.getText();  // Ambil ID untuk meng-update data
    String idStaf = "S001";  // ID staf otomatis di-set menjadi S001
    String nim = NIMfield.getText();  
    String namaKelas = (String) KelasComboBox.getSelectedItem();        
    String prodi = (String) ProdiComboBox.getSelectedItem();              
    String tanggal = TanggalField.getText();   
    String waktu = (String) WaktuComboBox.getSelectedItem();
    String status = "Menunggu";  // Status akan diubah menjadi 'Menunggu' jika validasi sukses

    // Cek apakah data sudah lengkap
    if (id.isEmpty() || namaKelas.isEmpty() || tanggal.isEmpty() || waktu.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Mohon isi semua field yang wajib!", "Error", JOptionPane.ERROR_MESSAGE);
        return;  // Jika ada field yang kosong, stop proses
    }

    // Validasi format tanggal
    if (!isValidDateFormat(tanggal)) {
        JOptionPane.showMessageDialog(null, "Format tanggal tidak valid! Gunakan format yyyy/mm/dd.", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Membuat objek PeminjamanModel dengan data yang sudah diambil dari inputan form
    PeminjamanModel peminjaman = new PeminjamanModel(id, idStaf, nim, namaKelas, prodi, tanggal, waktu, status);

    // Memanggil method PeminjamanKelas
    boolean isSuccess = con.PeminjamanKelas(peminjaman);

    // Memberikan feedback kepada pengguna
    if (isSuccess) {
        JOptionPane.showMessageDialog(null, "Peminjaman Berhasil!", "Success", JOptionPane.INFORMATION_MESSAGE);
    } else {
        JOptionPane.showMessageDialog(null, "Peminjaman gagal.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
// Tambahkan metode validasi tanggal
private boolean isValidDateFormat(String date) {
    try {
        new SimpleDateFormat("yyyy/mm/dd").parse(date);
        return true;
    } catch (ParseException e) {
        return false;
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        MenuUser mu = new MenuUser();
        mu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void NIMfieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NIMfieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NIMfieldActionPerformed

    private void TanggalFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TanggalFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TanggalFieldActionPerformed

    private void WaktuComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WaktuComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WaktuComboBoxActionPerformed

    private void KelasComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KelasComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KelasComboBoxActionPerformed

    private void ProdiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProdiComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProdiComboBoxActionPerformed

    private void IDFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDFieldActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPinjamRuangan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new MenuPinjamRuangan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(MenuPinjamRuangan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField IDField;
    private javax.swing.JComboBox<String> KelasComboBox;
    private javax.swing.JTextField NIMfield;
    private javax.swing.JComboBox<String> ProdiComboBox;
    private javax.swing.JTextField TanggalField;
    private javax.swing.JComboBox<String> WaktuComboBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
