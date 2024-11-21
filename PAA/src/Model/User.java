package Model;

import Database.DatabaseInterface;
import java.sql.ResultSet;
import java.sql.SQLException;

// User sebagai kelas abstrak untuk generalisasi
public abstract class User {
    protected String username;
    protected String password;

    // Konstruktor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getter dan Setter untuk username dan password
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

    // Metode abstrak untuk login, diimplementasikan oleh subclass
    public abstract boolean login(DatabaseInterface dbInterface);

    // Metode umum untuk mendapatkan objek user berdasarkan username
    public static User findUser(DatabaseInterface dbInterface, String username, String password) {
        User user = null;

        // Coba cari di tabel Mahasiswa
        String queryMahasiswa = "SELECT * FROM mahasiswa WHERE nim = ? AND password = ?";
        try (ResultSet rs = dbInterface.executeSelectQuery(queryMahasiswa, username, password)) {
            if (rs.next()) {
                user = new Mahasiswa(username, password, rs.getString("prodi"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Jika tidak ditemukan sebagai Mahasiswa, coba cari di tabel Staf
        if (user == null) {
            String queryStaf = "SELECT * FROM staf WHERE id_staf = ? AND password = ?";
            try (ResultSet rs = dbInterface.executeSelectQuery(queryStaf, username, password)) {
                if (rs.next()) {
                    user = new Staf(username, password, rs.getString("jabatan"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return user;
    }
}

