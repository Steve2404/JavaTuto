package execices;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Pirat {

    public static String getPirateSql() {
        try (InputStream stream = Pirat.class.getResourceAsStream("/db/create-table.sql")) {
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw  new RuntimeException();
        }
    }
    public static void main(String[] args) {
        String jdbcurl = " jdbc:h2:./pirates-dating";
        try (Connection conn = DriverManager.getConnection(jdbcurl)) {
            String sql = getPirateSql();
            conn.createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
