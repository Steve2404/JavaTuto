package org.example;


import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {


    static String getMondialSql() {

        // https://github.com/ullenboom/mondial-database
        try (InputStream stream = Main.class.getResourceAsStream("/db/mondial.sql")) {
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:h2:file:./mondial")) {
            // String sql = getMondialSql();
            // connection.createStatement().execute(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        }
    }