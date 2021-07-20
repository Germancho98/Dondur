/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Matthew
 */
public class Connection {
        private static java.sql.Connection con = null;

    public static java.sql.Connection getConnection() {
        if (con != null) {
            return con;
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/proyectodondur";
                String user = "root";
                String password = "";

                con = DriverManager.getConnection(url, user, password);
                System.out.println("coneccion efectiva");

            } catch (ClassNotFoundException conn) {
                System.out.println("Driver");
                conn.printStackTrace();
            } catch (SQLException e) {
                System.out.println("Excepcion");
                System.out.println(e);
            }
            return con;
        }
    }
}
