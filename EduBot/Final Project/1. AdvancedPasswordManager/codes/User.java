import java.util.HashMap;

public class User {
    private String username;
    private HashMap<String, String> passwords; // Map of service -> password

    public User(String username) {
        this.username = username;
        this.passwords = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void addPassword(String service, String password) {
        passwords.put(service, password);
    }

    public String getPassword(String service) {
        return passwords.get(service);
    }

    public void removePassword(String service) {
        passwords.remove(service);
    }

    public HashMap<String, String> getAllPasswords() {
        return passwords;
    }
}
