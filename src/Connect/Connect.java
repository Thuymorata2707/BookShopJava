/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connect;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author LETHANHKIET
 */
public class Connect {
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String user = "sa";
    public static String password = "123456";
    public static String con_str = "jdbc:sqlserver://localhost:1433;databaseName=QLNSS;encrypt=false";
    
    public Connection connect() throws SQLException {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = (Connection) DriverManager.getConnection(con_str, user, password);
            return conn;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Kết nối cơ sở dữ liệu thất bại!", "Thông báo", JOptionPane.OK_OPTION);
        }
        return conn;
    } 

    public PreparedStatement prepareStatement(String query) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
