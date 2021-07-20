/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Models.UserEntity;
import Util.MessageType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Matthew
 */
public class LoginController extends Util.Util {

    private UserEntity CurrentUser;

    Statement st;
    ResultSet rs;

    public boolean Authenticate(String User, String Password) {
         UserController userController = new UserController();
        UserEntity userEntity = new UserEntity();
        try {
           // String sentencia = ;
            PreparedStatement ps;
            //Obtiene la conexion y asì mismo la ejecuta.
            ps = getConnection().prepareStatement("select * from usuarios where NombreUsuario = ? and Contraseña = ?");
            String pass = GetMD5(Password);
            ps.setString(1, User);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            if (rs.absolute(1)) {
                this.setCurrentUser(userController.getUserById(rs.getLong("idUsuarios")));
                return true;
            }

        } catch (SQLException e) {
             AddMessage("Ha ocurrido un error: "+e.getMessage(), MessageType.Error);
        }

        return false;
    }
    
     

    public UserEntity GetUser() {

        return (UserEntity) getSession().getAttribute("userSession");
    }

    /**
     * @return the CurrentUser
     */
    public UserEntity getCurrentUser() {
        return CurrentUser;
    }

    /**
     * @param CurrentUser the CurrentUser to set
     */
    public void setCurrentUser(UserEntity CurrentUser) {
        this.CurrentUser = CurrentUser;
    }
}
