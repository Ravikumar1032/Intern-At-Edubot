import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportGenerator {
    private DatabaseManager dbManager;

    public ReportGenerator() {
        dbManager = new DatabaseManager();
    }

    public HashMap<String, Integer> generatePasswordUsageReport() {
        String SQL = "SELECT service, COUNT(*) AS usage_count FROM passwords GROUP BY service";
        HashMap<String, Integer> report = new HashMap<>();
        try (Connection conn = dbManager.connect();
             PreparedStatement pstmt = conn.prepareStatement(SQL);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                report.put(rs.getString("service"), rs.getInt("usage_count"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return report;
    }
}
