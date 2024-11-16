# Pertemuan Ketigabelas

##  Langkah - Langkah
Tabel pada Database
1. Tuliskan query berikut

![Screenshot 2024-11-16 194821](https://github.com/user-attachments/assets/1157475b-3b24-4d6e-8c96-c2d65aab70c5)

![Screenshot 2024-11-16 194827](https://github.com/user-attachments/assets/08b23647-9e7b-4989-a145-6ebc23a56284)


Persistence
1. Buat kelas entity dengan cara klik kanan proyek dan pilih 'Entity class from Database'.

![Screenshot 2024-11-09 191010](https://github.com/user-attachments/assets/64e03541-b50a-4ede-8cd0-03d213720117)

2.	Pilih koneksi database yang akan dihubungkan.

![Screenshot 2024-11-09 191037](https://github.com/user-attachments/assets/34f97dad-e27f-46f7-a862-05aa913f7fb8)

3.	Pilih database, lalu klik "Add All" untuk pindahkan semua tabel.

![Screenshot 2024-11-09 191056](https://github.com/user-attachments/assets/487fa37c-d1d4-4aa1-b2c7-dab6439996e0)

4.	Jika sudah benar semua, klik next

5.	Pilih mapping options dan finish

![Screenshot 2024-11-09 191143](https://github.com/user-attachments/assets/efcc508c-891f-4c37-9559-3bf966450e34)

6.	Akan muncul package `META-INF`

![Screenshot 2024-11-09 185549](https://github.com/user-attachments/assets/6aa93b37-c0ba-46cc-8f32-0d03bdea9209)

7. Buat design GUI untuk login dan create akun

![Screenshot 2024-11-16 194046](https://github.com/user-attachments/assets/2f66fe76-628f-4249-87ae-4ffb1ef2de67)

![Screenshot 2024-11-16 194055](https://github.com/user-attachments/assets/3688869a-14df-4292-9f8e-3012976bcc1d)

8. Tuliskan source code login

<pre>
private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        
        if (tfUser.getText().equals("") | tfPw.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi Terlebih Dahulu");
        } else {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            String user = tfUser.getText();
            String pw = tfPw.getText();
            Login y = em.find(Login.class, user);

            if (y == null) {
                JOptionPane.showMessageDialog(null, "Username tidak ditemukan");
            } else if (y.getPassword().equals(pw)) {
                JOptionPane.showMessageDialog(null, "Selamat Datang!");
                Mata_Kuliahh p = new Mata_Kuliahh();
                p.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Username atau Password salah!");
            }
            em.getTransaction().commit();
            em.close();
            emf.close();
        }

    }     
  
private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {                                     
        // TODO add your handling code here:
        Create y = new Create();
        y.setVisible(true);
        this.dispose();
    
    }          
</pre>

9. Tuliskan source code Create Account

<pre>
 private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
 if (tfUser.getText().equals("") || tfPw.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Isi semua data terlebih dahulu!");
        } else {
            String user, pw;
            user = tfUser.getText();
            pw = tfPw.getText();

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("PertemuanKeduabelasPU");
            EntityManager em = emf.createEntityManager();
            em.getTransaction().begin();

            Matakuliah y = em.find(Matakuliah.class, user);
            if (y != null) {
                JOptionPane.showMessageDialog(null, "Username tidak tersedia, silakan coba dengan nama yang lain");
                bersih();
            } else {
                Login x = new Login();
                x.setUsername(user);
                x.setPassword(pw);
                em.persist(x);

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(null, "Pembuatan akun berhasil");

                bersih();
                loginn z = new loginn();
                z.setVisible(true);
                this.dispose();
            }
            em.close();
            emf.close();
        }
        
    }                
</pre>


