/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuankeduabelas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import pertemuankeduabelas.Matakuliah;

/**
 *
 * @author Habtia Humaira
 */
public class Mata_Kuliahh extends javax.swing.JFrame {

    private static int masukkanData(Connection conn, String kode, String sks, String nama, String semester) throws SQLException {
        String sql = "INSERT INTO Mata_Kuliah (kodemk, sks, namamk, semesterajar) VALUES (?, ?, ?, ?)";
        try ( PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, kode);
            ps.setString(2, sks);
            ps.setString(3, nama);
            ps.setString(4, semester);
            return ps.executeUpdate();
        }
    }
    private Connection conn;

    public void showTable() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Buat model tabel dengan kolom yang sesuai
            DefaultTableModel tbnmhs = new DefaultTableModel(new String[]{"KODE MK", "SKS", "NAMA MK", "SEMESTER AJAR"}, 0);

            // Menggunakan NamedQuery "Matakuliah.findAll" untuk mengambil semua data
            List<Matakuliah> mataKuliahList = em.createNamedQuery("Matakuliah.findAll", Matakuliah.class).getResultList();

            // Iterasi hasil query dan tambahkan baris ke model tabel
            for (Matakuliah matakuliah : mataKuliahList) {
                tbnmhs.addRow(new Object[]{
                    matakuliah.getKodemk(),
                    matakuliah.getSks(),
                    matakuliah.getNamamk(),
                    matakuliah.getSemesterajar()
                });
            }

            // Atur model tabel ke tabel GUI
            Tabel.setModel(tbnmhs);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            em.close();  // Tutup EntityManager setelah selesai
        }
    }

    /**
     * Creates new form MataKuliahh
     */
    public Mata_Kuliahh() {
        initComponents();
        showTable();
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
        tfKode = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfSKS = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        tfNama = new javax.swing.JTextField();
        tfSemester = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btnUpdate = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnCetak = new javax.swing.JButton();
        btnUpload = new javax.swing.JButton();
        btnLogout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jLabel1.setText("MATA KULIAH");

        jLabel2.setText("Kode");

        tfKode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfKodeActionPerformed(evt);
            }
        });

        jLabel3.setText("SKS");

        tfSKS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSKSActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama");

        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Kode MK", "SKS", "Nama MK", "Semester Ajar"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(Tabel);

        tfNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNamaActionPerformed(evt);
            }
        });

        tfSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfSemesterActionPerformed(evt);
            }
        });

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jLabel5.setText("Semester Ajar");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnCetak.setText("Cetak");
        btnCetak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCetakActionPerformed(evt);
            }
        });

        btnUpload.setText("Upload");
        btnUpload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadActionPerformed(evt);
            }
        });

        btnLogout.setText("Log Out");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnAdd)
                        .addGap(27, 27, 27)
                        .addComponent(btnUpdate)
                        .addGap(26, 26, 26)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnCetak)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpload)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLogout)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfSKS)
                                    .addComponent(tfKode)
                                    .addComponent(tfSemester)
                                    .addComponent(tfNama)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jLabel1)
                                        .addGap(0, 234, Short.MAX_VALUE))))
                            .addComponent(jScrollPane2))
                        .addGap(45, 45, 45))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfKode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSKS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfSemester, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd)
                    .addComponent(btnUpdate)
                    .addComponent(btnDelete)
                    .addComponent(btnCetak)
                    .addComponent(btnUpload)
                    .addComponent(btnLogout))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tfKodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfKodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfKodeActionPerformed

    private void tfSKSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSKSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSKSActionPerformed

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        int row = Tabel.getSelectedRow();
        tfKode.setText(Tabel.getValueAt(row, 0).toString());
        tfSKS.setText(Tabel.getValueAt(row, 1).toString());
        tfNama.setText(Tabel.getValueAt(row, 2).toString());
        tfSemester.setText(Tabel.getValueAt(row, 3).toString());
    }//GEN-LAST:event_TabelMouseClicked

    private void tfNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNamaActionPerformed

    private void tfSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfSemesterActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if (tfKode.getText().equals("") || tfNama.getText().equals("") || tfSKS.getText().equals("") || tfSemester.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String kode, nama, sks, semester;
            kode = tfKode.getText();
            nama = tfNama.getText();
            sks = tfSKS.getText();
            semester = tfSemester.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Matakuliah mk = new Matakuliah();
            mk.setKodemk(kode);
            mk.setNamamk(nama);
            mk.setSemesterajar(semester);
            mk.setSks(sks);

            em.persist(mk);

            em.getTransaction().commit();
            JOptionPane.showMessageDialog(null, "Sukses diinput");

            bersih();
            showTable();

            em.close();
            emf.close();
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if (tfKode.getText().equals("") | tfNama.getText().equals("") | tfSKS.getText().equals("") | tfSemester.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data");
        } else {
            String kode, nama, sks, semester;
            kode = tfKode.getText();
            nama = tfNama.getText();
            sks = tfSKS.getText();
            semester = tfSemester.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Matakuliah mk = em.find(Matakuliah.class, kode);
            if (mk == null) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
            } else {
                mk.setKodemk(kode);
                mk.setNamamk(nama);
                mk.setSks(sks);
                mk.setSemesterajar(semester);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");

                em.close();
                emf.close();
                bersih();
                tfKode.setEditable(true);
            }
        }
        showTable();
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
        EntityManager em = emf.createEntityManager();

        try {
            // Validasi input
            if (tfKode.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Masukkan Kode Mata Kuliah yang akan dihapus");
            } else {
                // Mulai transaksi
                em.getTransaction().begin();

                // Cari entitas Matakuliah berdasarkan kode mata kuliah
                String kodeMK = tfKode.getText();
                Matakuliah matakuliah = em.find(Matakuliah.class, kodeMK);

                if (matakuliah != null) {
                    // Hapus entitas jika ditemukan
                    em.remove(matakuliah);

                    // Commit transaksi
                    em.getTransaction().commit();
                    JOptionPane.showMessageDialog(null, "Data berhasil dihapus");

                    // Refresh data pada tampilan
                    showTable();
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan untuk KodeMK: " + kodeMK);
                    em.getTransaction().rollback();
                }
            }
        } catch (Exception e) {
            // Rollback transaksi jika terjadi kesalahan
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            JOptionPane.showMessageDialog(null, "Gagal menghapus data");
            System.out.println(e.getMessage());
        } finally {
            em.close();  // Tutup EntityManager setelah operasi
        }

// Kosongkan text field setelah penghapusan
        tfKode.setText("");
        tfNama.setText("");
        tfSKS.setText("");
        tfSemester.setText("");
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnCetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCetakActionPerformed
        String driver = "org.postgresql.Driver";
        String koneksi = "jdbc:postgresql://localhost:5432/Mata_Kuliah";
        String user = "postgres";
        String password = "yupiburger";
        File reportFile = new File(".");
        String dirr = "";

        try {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(koneksi, user, password);
            Statement stat = conn.createStatement();
            String sql = "SELECT * FROM MataKuliah";
            dirr = reportFile.getCanonicalPath() + "/src/pertemuankeduabelas/";
            JasperDesign design = JRXmlLoader.load(dirr + "report1.jrxml");
            JasperReport jr = JasperCompileManager.compileReport(design);
            ResultSet rs = stat.executeQuery(sql);
            JRResultSetDataSource rsDataSource = new JRResultSetDataSource(rs);
            JasperPrint jp = JasperFillManager.fillReport(jr, new HashMap(),
                    rsDataSource);
            JasperViewer.viewReport(jp);
        } catch (ClassNotFoundException | SQLException | IOException | JRException ex) {
            JOptionPane.showMessageDialog(null, "\nGagal Mencetak\n" + ex,
                    "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }

//        try {
//            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Mata_Kuliah", "postgres", "yupiburger");
//
//            JasperReport reports;
//            String path = "\\PertemuanKeduabelas\\src\\pertemuankeduabelas\\report1.jrxml";
//            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
//            JasperPrint print = JasperFillManager.fillReport(path, null, conn);
//            JasperViewer view = new JasperViewer(print, false);
//            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
//            view.setVisible(true);
//        } catch (JRException e) {
//            System.out.println(e.getMessage());
//        } catch (SQLException ex) {
//            Logger.getLogger(Mata_Kuliahh.class.getName()).log(Level.SEVERE, null, ex);
//
//        }
    }//GEN-LAST:event_btnCetakActionPerformed

    private void btnUploadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadActionPerformed

        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            System.out.println("yang dipilih : " + filePilihan.getAbsolutePath());
            try {
                BufferedReader br = new BufferedReader(new FileReader(filePilihan));
                String baris;
                String pemisah = ";";

                // EntityManager untuk database
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
                EntityManager em = emf.createEntityManager();

                em.getTransaction().begin(); // Mulai transaksi

                while ((baris = br.readLine()) != null) {
                    String[] dataMhs = baris.split(pemisah);

                    if (dataMhs.length >= 4) {
                        String kode_mk = dataMhs[0];
                        String SKS = dataMhs[1];
                        String nama_mk = dataMhs[2];
                        String semester_ajar = dataMhs[3];

                        // Buat objek MataKuliah baru
                        Matakuliah matakuliah = new Matakuliah();
                        matakuliah.setKodemk(kode_mk);
                        matakuliah.setSks(SKS);
                        matakuliah.setNamamk(nama_mk);
                        matakuliah.setSemesterajar(semester_ajar);

                        // Simpan objek ke database
                        em.persist(matakuliah);
                    }
                }

                em.getTransaction().commit(); // Commit transaksi
                em.close(); // Tutup EntityManager

                JOptionPane.showMessageDialog(this, "Data berhasil ditambahkan");
                showTable(); // Refresh tabel GUI

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_btnUploadActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        // TODO add your handling code here:
        loginn y = new loginn();
        y.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnLogoutActionPerformed

    private void bersih() {
        tfKode.setText("");
        tfSKS.setText("");
        tfNama.setText("");
        tfSemester.setText("");
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mata_Kuliahh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mata_Kuliahh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mata_Kuliahh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mata_Kuliahh.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mata_Kuliahh().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabel;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCetak;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpload;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tfKode;
    private javax.swing.JTextField tfNama;
    private javax.swing.JTextField tfSKS;
    private javax.swing.JTextField tfSemester;
    // End of variables declaration//GEN-END:variables
}
