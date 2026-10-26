
package com.tka;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyDbconfig {

    public static Connection getsSQLconnection() {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/iplproject2";
            String username = "root";
            String pass = "root";

            con = DriverManager.getConnection(url, username, pass);

            System.out.println("Database connected successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return con;
    }
}
 