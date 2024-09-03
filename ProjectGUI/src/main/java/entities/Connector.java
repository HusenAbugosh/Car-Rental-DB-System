package entities;

import java.sql.*;
import java.util.Properties;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Connector {

    private static String dbURL;
    private static String dbUsername = "root";
    private static String dbPassword = "root1234";
    private static String URL = "127.0.0.1";
    private static String port = "3306";
    private static String dbName = "carRental";
    private static Connection con;

    public static void connectDB() {
        try {
            dbURL = "jdbc:mysql://" + URL + ":" + port + "/" + dbName + "?verifyServerCertificate=false";
            Properties p = new Properties();
            p.setProperty("user", dbUsername);
            p.setProperty("password", dbPassword);
            p.setProperty("useSSL", "false");
            p.setProperty("autoReconnect", "true");
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(dbURL, p);
        } catch (ClassNotFoundException | SQLException e) {
            showAlert("Error", "Could not connect to database");
            System.out.println(e.getMessage());
        }
    }

    public static ResultSet ExecuteStatement(String SQL) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = Connector.getCon().createStatement();
            rs = stmt.executeQuery(SQL);
            return rs;
        } catch (SQLException s) {
            throw s;
        }
    }

    public static void executeUpdate(String SQL) throws SQLException {
        Statement stmt = null;
        try {
            stmt = Connector.getCon().createStatement();
            stmt.executeUpdate(SQL);
        } catch (SQLException s) {
            throw s;
        } finally {
            if (stmt != null) {
                stmt.close();
            }
        }
    }

    public static void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static Connection getCon() {
        try {
            if (con == null || con.isClosed()) {
                connectDB();
            }
        } catch (SQLException e) {
            showAlert("Database Error", "Failed to re-establish database connection.");
            e.printStackTrace();
        }
        return con;
    }
}
