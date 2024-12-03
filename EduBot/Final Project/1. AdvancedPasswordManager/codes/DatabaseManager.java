import java.sql.*;
import java.util.HashMap;

public class DatabaseManager {
    private final String url = "jdbc:postgresql://localhost/password_manager";
    private final String user = "postgres";
    private final String password = "n190920";
    
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void addUser(String username) {
        String SQL = "INSERT INTO users(username) VALUES(?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, username);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addPassword(int userId, String service, String password) {
        String SQL = "INSERT INTO passwords(user_id, service, password) VALUES(?, ?, ?)";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, userId);
            pstmt.setString(2, service);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public User getUser(String username) {
        String SQL = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    public HashMap<String, String> getPasswords(int userId) {
        String SQL = "SELECT service, password FROM passwords WHERE user_id = ?";
        HashMap<String, String> passwords = new HashMap<>();
        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL)) {
            pstmt.setInt(1, userId);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                passwords.put(rs.getString("service"), rs.getString("password"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return passwords;
    }
}
