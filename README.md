# PA-A23-KELOMPOK3A
# Program Class Think

## Anggota Kelompok
1. Muhammad Alfian Adien (2309116034)
2. Muhammad Nabil Ma'ruf (2309116035)
3. Andromeda Hibnu Darmawi (2309116038)
4. Rifqi Hadi Wijaya (2309116042)

## Deskripsi Program
Program Class Think merupakan aplikasi yang dibuat menggunakan bahasa pemrograman Java dengan menggunakan konsep Pemrograman Berorientasi Objek (PBO). Aplikasi ini dibuat berdasarkan studi kasus yang terjadi di Fakultas Teknik Universitas Mulawarman, dimana masih ada kasus terjadinya tabrakan jadwal kelas. Jadi, aplikasi ini dibuat untuk memudahkan dan menghindari terjadinya jadwal kelas yang bentrok.

## Struktur Project

![Screenshot 2024-11-21 155556](https://github.com/user-attachments/assets/2105ce07-41d4-4834-90fb-9633c93bff64)

- Package Controller: Berisi class atau logika yang mengatur alur kerja program, yang mana setiap user yang terlibat dengan aplikasi bisa mengakses class peminjaman.
- Package Database: Berguna untuk menghubungkan antara program dengan database.
- Package Image: Berisi file atau resource gambar yang digunakan oleh program. Package ini tidak berisi class, tetapi menjadi tempat penyimpanan gambar-gambar
- Package Main: Untuk menjalankan program
- Package Model: Berisi class yang merepresentasikan data atau entitas dalam program
- Package View: Untuk menampilkan GUI
  

## FlowChart

![FlowChart PA PBO fix](https://github.com/user-attachments/assets/dd3443c6-26c4-4e7e-946d-5d7f5c066c3f)

## Fitur Program
#### Fitur Utama
- Manajemen Peminjaman: Akses untuk staf mengelola data peminjaman yang ada (CRUD)
- Autentikasi pengguna: Memverifikasi atau membuktikan bahwa user yang ingin mengakses aplikasi benar-benar user yang terdapat di dalam database.

#### Fitur User
- Staf
  - Create: Staf dapat menambahkan data peminjaman kelas 
  - Read: Staf dapat melihat riwayat peminjaman kelas
  - Update: Staf dapat melakukan perubahan pada jadwal peminjaman dan juga mengubah status ketersediaan kelas
  - Delete: Staf dapat menghapus record data peminjaman kelas
- Mahasiswa
  - Create: Mahasiswa pada menu create berarti mengajukan peminjaman kelas
  - Read: Mahasiswa dapat melihat riwayat peminjaman kelas
  - Searching: Menu searching mencari kelas yang ada di tabel peminjaman dan mencari berdasarkan program studi
  - Sorting: Menu sorting pada mahasiswa dapat dilakukan berdasarkan nama kelas, tanggal, dan status peminjaman
## Penerapan 4 Pilar OOP
#### 1. Inheritance

- Parent Class
  
![Screenshot 2024-11-21 184029](https://github.com/user-attachments/assets/800b7450-c9c0-4705-96f0-4b5bef915019)

- Child Class
  
![Screenshot 2024-11-21 184043](https://github.com/user-attachments/assets/c6b7a657-82a0-417e-9230-a87c8030ee2d)

![Screenshot 2024-11-21 184057](https://github.com/user-attachments/assets/c05701a4-33c7-4b3b-af66-9363060150db)

Pada program yang dibawakan, penerapan inheritance terdapat di bagian class `User` dimana class User merupakan `parent class`, `class Mahasiswa` dan `staf` merupakan `child class`

#### 2. Encapsulation
Bertujuan untuk menyembunyikan data yang sensitif dari suatu kelas.
Penerapan encapsulation pada:
- Model.PeminjamanModel.java
  
      public String getId() {
            return id;
        }
    
      public void setId(String id) {
          this.id = id;
      }
  
      public String getIdStaf() {
          return idStaf;
      }
  
      public void setIdStaf(String idStaf) {
          this.idStaf = idStaf;
      }
  
      public String getNim() {
          return nim;
      }
  
      public void setNim(String nim) {
          this.nim = nim;
      }
  
      public String getKelas() {
          return kelas;
      }
  
      public void setKelas(String kelas) {
          this.kelas = kelas;
      }
  
      public String getProdi() {
          return prodi;
      }
  
      public void setProdi(String prodi) {
          this.prodi = prodi;
      }
  
      public String getTanggal() {
          return tanggal;
      }
  
      public void setTanggal(String tanggal) {
          this.tanggal = tanggal;
      }
  
      public String getWaktu() {
          return waktu;
      }
  
      public void setWaktu(String waktu) {
          this.waktu = waktu;
      }
  
      public String getStatus() {
          return status;
      }
  
      public void setStatus(String status) {
          this.status = status;
      }
  
- Model.User.java
  
      public String getUsername() {
            return username;
        }
  
      public void setUsername(String username) {
          this.username = username;
      }
  
      public String getPassword() {
          return password;
      }
  
      public void setPassword(String password) {
          this.password = password;
      }
  
- Model.Mahasiswa.java

      public String getProdi() {
          return prodi;
      }
  
      public void setProdi(String prodi) {
          this.prodi = prodi;
      }

- Model.Staf.java

      public String getJabatan() {
          return jabatan;
      }
  
      public void setJabatan(String jabatan) {
          this.jabatan = jabatan;
      }

#### 3. Polymorphism
Metode yang memungkinkan sebuah kelas untuk memiliki nama `method yang sama`, namun dengan `parameter yang berbeda`.
Diterapkan pada: 
- Model.Mahasiswa.java

      @Override
      public boolean login(DatabaseInterface dbInterface) {
          String query = "SELECT * FROM mahasiswa WHERE nim = ? AND password = ?";
          try (ResultSet rs = dbInterface.executeSelectQuery(query, this.username, this.password)) {
              if (rs.next()) {
                  System.out.println("Login Mahasiswa Berhasil: " + rs.getString("nama_mahasiswa"));
                  return true;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return false;
      }

- Model.Staf.java

      @Override
      public boolean login(DatabaseInterface dbInterface) {
          String query = "SELECT * FROM staf WHERE id_staf = ? AND password = ?";
          try (ResultSet rs = dbInterface.executeSelectQuery(query, this.username, this.password)) {
              if (rs.next()) {
                  System.out.println("Login Staf Berhasil: " + rs.getString("nama_staf"));
                  return true;
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
          return false;
      }

#### 4. Abstraction
Abstrak berarti menaruh karakteristik-karakteristik yang diperlukan oleh sebuah kelas, tanpa harus menampilkan detail dari karakteristik tersebut.
`Abstrak` diterapkan pada `class User`

    public abstract class User {
      protected String username;
      protected String password;
  
      // Konstruktor
      public User(String username, String password) {
          this.username = username;
          this.password = password;
      }
## Output Program
- #### 1. Login

  ![Screenshot 2024-11-21 213647](https://github.com/user-attachments/assets/999fa024-4951-463d-8ad8-3750c89bc564)

  ![Screenshot 2024-11-21 213711](https://github.com/user-attachments/assets/ab262e57-904b-48b7-83c7-9aa23d0c3ac5)

  Login dilakukan dengan memasukkan NIM atau id staf, nantinya sistem akan menilai sendiri, jika yang diinputkan adalah NIM maka akan masuk ke menu mahasiswa, dan jika yang diinputkan adalah id staf maka akan masuk ke menu staf


- #### 2. Staf

  ![Screenshot 2024-11-21 203840](https://github.com/user-attachments/assets/48b7cdd6-52f7-419a-b3b6-efd8bc4402f3)
  - Gambar di atas merupakan `tampilan awal` dari staf
 





  ![Create_staf](https://github.com/user-attachments/assets/c6c9a809-fec3-421e-982c-09fe9c158668)
  - `Create`: Tampilan di atas menunjukkan data yang ditambahkan oleh staf berhasil.





  ![Update_staf](https://github.com/user-attachments/assets/48c962e7-c8fa-4ea4-a3a6-dfd4f04e31e2)
  - `Update`: Update yang dilakukan oleh staf bisa melakukan perubahan status atau juga bisa mengubah data peminjaman, tampilan di atas menunjukkan update yang dilakukan berhasil.
 




  ![Delete_staf](https://github.com/user-attachments/assets/cfdb4b8d-5325-4036-bd6d-e51c16b1597b)
  - `Delete`: Tampilan di atas menunjukkan data yang dihapus berhasil


- #### 3. Mahasiswa

  ![Screenshot 2024-11-21 205853](https://github.com/user-attachments/assets/11fe391d-d151-463d-a66b-ebb929fa44bc)
  - Gambar di atas merupakan `tampilan awal` dari mahasiswa
 




  ![Peminjaman_berhasil](https://github.com/user-attachments/assets/47e1f66b-9605-470e-bda3-d3bbe980570f)
  - `Create`: Mahasiswa dapat melaukan pengajuan peminjaman kelas, tampilan di atas menunjukkan bahwa kelas yang diajukan telah berhasil masuk ke data, jika kelas yang diajukan gagal maka akan muncul tampilan seperti berikut:

  ![peminjaman_penuh_cut](https://github.com/user-attachments/assets/4a99f491-2909-4e28-a047-7101a1a30281)




  
  ![searching_mahasiswa](https://github.com/user-attachments/assets/1998879f-bffa-41a4-a8d9-4afe464b94fd)
  - `Searching`: Mahasiswa dapat melakukan `searhing` dengan `berdasarkan program studi`





  ![sorting tanggal](https://github.com/user-attachments/assets/0e14d974-151c-4642-9179-bdecac21264b)
  - `Sorting`: Mahasiswa dapat melakukan sorting berdasarkan `nama kelas`, `tanggal peminjaman`, dan `status peminjaman`.

