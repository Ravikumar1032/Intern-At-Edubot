import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

public class PasswordDatabase {
    private static final String URL = "jdbc:postgresql://localhost:5432/passwords";
    private static final String USER = "postgres";
    private static final String PASSWORD = "n190920";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS passwords (" +
                "id SERIAL PRIMARY KEY," +
                "password VARCHAR(255) NOT NULL," +
                "creation_date DATE NOT NULL," +
                "strength INT NOT NULL," +
                "used BOOLEAN NOT NULL" +
                ");";
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void savePassword(String password, LocalDate creationDate, int strength, boolean used) {
        String sql = "INSERT INTO passwords (password, creation_date, strength, used) VALUES (?, ?, ?, ?);";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, password);
            preparedStatement.setDate(2, java.sql.Date.valueOf(creationDate));
            preparedStatement.setInt(3, strength);
            preparedStatement.setBoolean(4, used);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
