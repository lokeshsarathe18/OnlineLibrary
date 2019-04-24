package com.kulchuri.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryDb implements DbData {

    private static Connection conn = null;

    private LibraryDb() {
    }

    static {
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Connection Failed:" + e);
        }
    }

    public static Connection getLibrariDb() {
        return conn;
    }

    public static void main(String[] args) {
        System.out.println(getLibrariDb());
    }
}
