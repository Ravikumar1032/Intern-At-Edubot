import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class SecurityManager {
    public String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean authenticate(String username, String password, DatabaseManager dbManager) {
        User user = dbManager.getUser(username);
        if (user == null) {
            return false;
        }
        String hashedPassword = hashPassword(password);
        // Assuming passwords are stored hashed in the database
        return user.getPassword("main").equals(hashedPassword);
    }
}
