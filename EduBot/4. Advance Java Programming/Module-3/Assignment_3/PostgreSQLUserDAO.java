import java.sql.*;

public class PostgreSQLUserDAO implements UserDAO {
    private Connection connection;

    public PostgreSQLUserDAO() throws SQLException {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Assignment-3", "postgres", "n190920");
    }

    @Override
    public void addUser(String name, String email) {
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO Users (name, email) VALUES (?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void getAllUsers() {
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM Users")) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name") + ", Email: " + rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateUser(int id, String name, String email) {
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE Users SET name = ?, email = ? WHERE id = ?")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setInt(3, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteUser(int id) {
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM Users WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
