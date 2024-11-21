
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
import Model.User;
import java.sql.SQLException;

public class LoginController {
    private DatabaseInterface dbInterface;

    public LoginController() throws SQLException {
        this.dbInterface = new DatabaseInterface();
    }

    // Metode login tetap, sekarang menggunakan User.findUser()
    public User login(String username, String password) {
        return User.findUser(dbInterface, username, password);
    }
}


