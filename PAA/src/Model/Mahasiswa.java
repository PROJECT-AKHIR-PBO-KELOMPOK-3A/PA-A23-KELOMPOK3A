/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author ideapadGAMING
 */
import Database.DatabaseInterface;
import java.sql.ResultSet;
import java.sql.SQLException;

// Kelas Mahasiswa sebagai turunan dari User
public class Mahasiswa extends User {
    private String prodi;

    // Konstruktor
    public Mahasiswa(String username, String password, String prodi) {
        super(username, password);
        this.prodi = prodi;
    }

    // Getter dan Setter untuk prodi
    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    // Implementasi login spesifik untuk Mahasiswa
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
}







