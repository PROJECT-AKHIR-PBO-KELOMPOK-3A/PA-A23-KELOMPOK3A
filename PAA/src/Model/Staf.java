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

// Kelas Staf sebagai turunan dari User
public class Staf extends User {
    private String jabatan;

    // Konstruktor
    public Staf(String username, String password, String jabatan) {
        super(username, password);
        this.jabatan = jabatan;
    }

    // Getter dan Setter untuk jabatan
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    // Implementasi login spesifik untuk Staf
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
}



