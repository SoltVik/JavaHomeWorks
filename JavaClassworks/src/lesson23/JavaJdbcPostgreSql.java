import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaJdbcPostgreSql {
    private static Connection connection;


    public static void main(String[] args) throws SQLException {
        connect("jdbc:postgresql://localhost:5432/table", "postgres", "root");

       try (Statement stmt = connection.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT * FROM students;")) {
            while (rs.next()) {
                System.out.println(rs.getInt(1) + "\t " + rs.getString("name") + "\t " + rs.getString(3) + "\t " + rs.getInt(4));
            }
        }

        System.out.println();

        try (PreparedStatement preStmt = connection.prepareStatement("SELECT * FROM students WHERE id = ?")) {
            preStmt.setInt(1, 1);

            try (ResultSet rs = preStmt.executeQuery()) {
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + "\t " + rs.getString("name") + "\t " + rs.getString(3) + "\t " + rs.getInt(4));
                }
            }
        }

        System.out.println("\nRecords read.");

        disconnect();
    }

    static void connect(String url, String user, String pswd) {
        try {
            connection = DriverManager.getConnection(url, user, pswd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void disconnect() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}