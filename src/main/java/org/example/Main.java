package org.example;


import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    /*
    static String getMondialSql() {
        try (InputStream stream = Main.class.getResourceAsStream("/db/mondial.sql")) {
            //new String(stream.readAllBytes(), )
        } catch (IOException e) {
        }
    }
    */


    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:./mondial")) {
            System.out.println(connection);
            // https://github.com/ullenboom/mondial-database
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }