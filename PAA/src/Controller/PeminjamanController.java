/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author ideapadGAMING
 */
import Database.DatabaseInterface;
import Model.PeminjamanModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PeminjamanController {
    private final DatabaseInterface dbInterface;
    // Variabel untuk melacak mode sorting saat ini
    private int currentSortMode = 0;

    // Constants untuk menentukan mode sorting
    private static final int SORT_BY_KELAS = 0;
    private static final int SORT_BY_TANGGAL = 1;
    private static final int SORT_BY_STATUS = 2;
    
    public PeminjamanController() throws SQLException {
        this.dbInterface = new DatabaseInterface();
    }

    // Insert Data dengan validasi
    public boolean insertPeminjaman(PeminjamanModel peminjaman) {
        String queryProdi = "SELECT prodi FROM mahasiswa WHERE nim = ?";
        String queryCekKelas = "SELECT COUNT(*) FROM peminjaman WHERE nama_kelas = ? AND hari_tanggal = ? AND waktu = ? AND status = 'Dipinjam'";
        String queryInsert = "INSERT INTO peminjaman (staf_id_staf, mahasiswa_nim, nama_kelas, prodi, hari_tanggal, waktu, status) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            // Pengecekan prodi mahasiswa sesuai dengan nim
            String prodiMahasiswa = null;
            ResultSet rsProdi = dbInterface.executeSelectQuery(queryProdi, peminjaman.getNim());
            if (rsProdi.next()) {
                prodiMahasiswa = rsProdi.getString("prodi");
            }

            // Validasi apakah prodi sesuai
            if (prodiMahasiswa == null || !prodiMahasiswa.trim().equalsIgnoreCase(peminjaman.getProdi().trim())) {
                JOptionPane.showMessageDialog(null, "Prodi mahasiswa tidak sesuai.");
                return false;
            }


            // Pengecekan apakah kelas sudah dipinjam pada hari_tanggal dan waktu yang sama
            ResultSet rsCekKelas = dbInterface.executeSelectQuery(queryCekKelas, peminjaman.getKelas(), peminjaman.getTanggal(), peminjaman.getWaktu());
            if (rsCekKelas.next() && rsCekKelas.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "Kelas sudah dipinjam pada waktu tersebut.");
                return false;
            }

            // Set staf_id_staf otomatis menjadi 'S001'
            String idStaf = "S001";

            // Menyimpan data peminjaman ke database
            int result = dbInterface.executeUpdateQuery(queryInsert, idStaf, peminjaman.getNim(), peminjaman.getKelas(),
                    peminjaman.getProdi(), peminjaman.getTanggal(), peminjaman.getWaktu(), peminjaman.getStatus());

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    // Update Data
    public boolean updatePeminjaman(PeminjamanModel peminjaman) {
        String query = "UPDATE peminjaman SET status = ? WHERE id_peminjaman = ?";
        try {
            int result = dbInterface.executeUpdateQuery(query, peminjaman.getStatus(), peminjaman.getId());
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    

    // Method untuk edit peminjaman
    public boolean editPeminjaman(PeminjamanModel peminjaman) {
        String queryCekPeminjaman = "SELECT COUNT(*) FROM peminjaman WHERE id_peminjaman = ?";
        String queryUpdate = "UPDATE peminjaman SET staf_id_staf = ?, mahasiswa_nim = ?, nama_kelas = ?, prodi = ?, hari_tanggal = ?, waktu = ?, status = ? WHERE id_peminjaman = ?";

        try {
            // Cek apakah peminjaman dengan ID tersebut ada
            ResultSet rsCekPeminjaman = dbInterface.executeSelectQuery(queryCekPeminjaman, peminjaman.getId());
            if (rsCekPeminjaman.next() && rsCekPeminjaman.getInt(1) == 0) {
                JOptionPane.showMessageDialog(null, "Peminjaman dengan ID tersebut tidak ditemukan.");
                return false;
            }

            // Set prodi, nim, dan tanggal menjadi null jika menggunakan '-'
            String nim = peminjaman.getNim().equals("-") ? null : peminjaman.getNim();
            String prodi = peminjaman.getProdi().equals("-") ? null : peminjaman.getProdi();
            String tanggal = peminjaman.getTanggal().equals("-") ? null : peminjaman.getTanggal();

            // Update peminjaman ke database
            int result = dbInterface.executeUpdateQuery(queryUpdate, "S001", nim, peminjaman.getKelas(), prodi, tanggal, peminjaman.getWaktu(), peminjaman.getStatus(), peminjaman.getId());

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<PeminjamanModel> getAllPeminjaman() {
        String query = "SELECT * FROM peminjaman";
        List<PeminjamanModel> peminjamanList = new ArrayList<>();

        try {
            // Menjalankan query dan mendapatkan hasil
            ResultSet rs = dbInterface.executeSelectQuery(query);

            // Memeriksa apakah hasil query ada
            if (rs != null) {
                // Menyusun daftar peminjaman berdasarkan data dari ResultSet
                while (rs.next()) {
                    // Membaca data dari ResultSet
                    String id = rs.getString("id_peminjaman");
                    String idStaf = rs.getString("staf_id_staf");
                    String nim = rs.getString("mahasiswa_nim");
                    String kelas = rs.getString("nama_kelas");
                    String prodi = rs.getString("prodi");
                    String tanggal = rs.getString("hari_tanggal");
                    String waktu = rs.getString("waktu");
                    String status = rs.getString("status");

                    // Membuat objek PeminjamanModel dan mengisi data
                    PeminjamanModel peminjaman = new PeminjamanModel(id, idStaf, nim, kelas, prodi, tanggal, waktu, status);

                    // Menambahkan peminjaman ke dalam list
                    peminjamanList.add(peminjaman);
                }
            }
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan saat membaca data
            e.printStackTrace();
        }

        // Mengembalikan list peminjaman yang telah diisi
        return peminjamanList.isEmpty() ? null : peminjamanList;
    }

    
    // Delete Data
    public boolean deletePeminjaman(String id) {
        String query = "DELETE FROM peminjaman WHERE id_peminjaman = ?";
        try {
            int result = dbInterface.executeUpdateQuery(query, id);
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean PeminjamanKelas(PeminjamanModel peminjaman) {
        String queryProdi = "SELECT prodi FROM mahasiswa WHERE nim = ?";
        String queryCekKetersediaan = "SELECT COUNT(*) FROM peminjaman WHERE id_peminjaman = ? AND nama_kelas = ?  AND waktu = ? AND status = 'Tersedia'";
        String queryUpdate = "UPDATE peminjaman SET staf_id_staf = ?, mahasiswa_nim = ?, prodi = ?, hari_tanggal = ?, waktu = ?, status = 'Menunggu' WHERE id_peminjaman = ?";

        try {
            // Pengecekan prodi mahasiswa sesuai dengan nim
            String prodiMahasiswa = null;
            ResultSet rsProdi = dbInterface.executeSelectQuery(queryProdi, peminjaman.getNim());
            if (rsProdi.next()) {
                prodiMahasiswa = rsProdi.getString("prodi");
            }

            // Validasi apakah prodi sesuai
            if (prodiMahasiswa == null || !prodiMahasiswa.trim().equalsIgnoreCase(peminjaman.getProdi().trim())) {
                JOptionPane.showMessageDialog(null, "Prodi mahasiswa tidak sesuai.");
                return false;
            }
            // Cek apakah kelas tersedia di database sesuai input user
            ResultSet rsCekKetersediaan = dbInterface.executeSelectQuery(queryCekKetersediaan, 
                peminjaman.getId(), peminjaman.getKelas(), peminjaman.getWaktu());

            if (rsCekKetersediaan.next()) {
                int jumlahKelasTersedia = rsCekKetersediaan.getInt(1);

                // Jika tidak ada kelas yang sesuai dengan ID, nama, waktu, dan status yang diinginkan
                if (jumlahKelasTersedia == 0) {
                    JOptionPane.showMessageDialog(null, "Kelas sedang dipinjam atau tidak tersedia di waktu tersebut.");
                    return false;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Tidak ada kelas yang cocok dengan data yang diinput.");
                return false;
            }

            // Jika validasi sukses, update data peminjaman menjadi 'Menunggu'
            int result = dbInterface.executeUpdateQuery(queryUpdate, 
                peminjaman.getIdStaf(), peminjaman.getNim(), peminjaman.getProdi(), 
                peminjaman.getTanggal(), peminjaman.getWaktu(), peminjaman.getId());

            return result > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


    // Method untuk mencari data peminjaman berdasarkan prodi dan menampilkannya di JTable
    public void searchAndDisplayByProdi(JTable jTable1, String prodi) {
        List<PeminjamanModel> peminjamanList = searchByProdi(prodi);

        if (peminjamanList == null || peminjamanList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada data peminjaman untuk prodi: " + prodi);
            return;
        }

        // Update tampilan tabel dengan hasil pencarian
        updateTable(jTable1, peminjamanList);
    }

    // Method untuk mencari data peminjaman berdasarkan prodi
    public List<PeminjamanModel> searchByProdi(String prodi) {
        String query = "SELECT * FROM peminjaman WHERE prodi = ?";
        List<PeminjamanModel> peminjamanList = new ArrayList<>();

        try {
            // Menjalankan query dengan parameter prodi menggunakan executeSelectQuery
            ResultSet rs = dbInterface.executeSelectQuery(query, prodi);

            // Memeriksa apakah hasil query ada
            if (rs != null) {
                // Menyusun daftar peminjaman berdasarkan data dari ResultSet
                while (rs.next()) {
                    // Membaca data dari ResultSet
                    String id = rs.getString("id_peminjaman");
                    String idStaf = rs.getString("staf_id_staf");
                    String nim = rs.getString("mahasiswa_nim");
                    String kelas = rs.getString("nama_kelas");
                    String retrievedProdi = rs.getString("prodi");
                    String tanggal = rs.getString("hari_tanggal");
                    String waktu = rs.getString("waktu");
                    String status = rs.getString("status");

                    // Membuat objek PeminjamanModel dan mengisi data
                    PeminjamanModel peminjaman = new PeminjamanModel(id, idStaf, nim, kelas, retrievedProdi, tanggal, waktu, status);

                    // Menambahkan peminjaman ke dalam list
                    peminjamanList.add(peminjaman);
                }
            }
        } catch (SQLException e) {
            // Tangani exception jika terjadi kesalahan saat membaca data
            e.printStackTrace();
        }

        // Mengembalikan list peminjaman yang telah diisi
        return peminjamanList.isEmpty() ? null : peminjamanList;
    }

    // Method untuk mengurutkan data peminjaman berdasarkan kriteria tertentu
    public void sortPeminjaman(JTable jTable1) {
        // Dapatkan semua data peminjaman
        List<PeminjamanModel> peminjamanList = getAllPeminjaman();
        
        if (peminjamanList == null || peminjamanList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tidak ada data peminjaman yang tersedia untuk diurutkan.");
            return;
        }

        // Tentukan mode sorting berdasarkan currentSortMode
        switch (currentSortMode) {
            case SORT_BY_KELAS:
                // Sorting berdasarkan kelas, dengan nilai null di akhir
                peminjamanList.sort(Comparator.comparing(
                    PeminjamanModel::getKelas, Comparator.nullsLast(Comparator.naturalOrder())
                ));
                break;
            case SORT_BY_TANGGAL:
                // Sorting berdasarkan tanggal, dengan nilai null di akhir
                peminjamanList.sort(Comparator.comparing(
                    PeminjamanModel::getTanggal, Comparator.nullsLast(Comparator.naturalOrder())
                ));
                break;
            case SORT_BY_STATUS:
                // Sorting dengan status 'tersedia' di atas, dengan nilai null di akhir
                peminjamanList.sort((a, b) -> {
                    if (a.getStatus() == null && b.getStatus() == null) return 0;
                    if (a.getStatus() == null) return 1;
                    if (b.getStatus() == null) return -1;
                    if (a.getStatus().equals("Tersedia") && !b.getStatus().equals("Tersedia")) return -1;
                    if (!a.getStatus().equals("Tersedia") && b.getStatus().equals("Tersedia")) return 1;
                    return 0;
                });
                break;
        }

        // Update mode sorting untuk siklus berikutnya
        currentSortMode = (currentSortMode + 1) % 3;

        // Update tampilan tabel dengan data yang sudah di-sort
        updateTable(jTable1, peminjamanList);
    }

    // Method untuk memperbarui tabel berdasarkan data yang telah di-sort atau hasil pencarian
    private void updateTable(JTable jTable1, List<PeminjamanModel> peminjamanList) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Hapus data sebelumnya

        // Loop untuk menambahkan data yang telah di-sort ke tabel
        for (PeminjamanModel peminjaman : peminjamanList) {
            Object[] rowData = {
                peminjaman.getId(),
                peminjaman.getIdStaf(),
                peminjaman.getNim(),
                peminjaman.getKelas(),
                peminjaman.getProdi(),
                peminjaman.getTanggal(),
                peminjaman.getWaktu(),
                peminjaman.getStatus()
            };
            model.addRow(rowData); // Tambahkan data ke tabel
        }
    }



    public PeminjamanModel getPeminjamanById(String id) {
        String query = "SELECT * FROM peminjaman WHERE id_peminjaman = ?";
        try {
            ResultSet rs = dbInterface.executeSelectQuery(query, id);
            if (rs.next()) {
                PeminjamanModel peminjaman = new PeminjamanModel(
                        rs.getString("id_peminjaman"),
                        rs.getString("staf_id_staf"),
                        rs.getString("mahasiswa_nim"),
                        rs.getString("nama_kelas"),
                        rs.getString("prodi"),
                        rs.getString("hari_tanggal"),
                        rs.getString("waktu"),
                        rs.getString("status")
                );
                peminjaman.setId(rs.getString("id_peminjaman"));
                return peminjaman;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    }
