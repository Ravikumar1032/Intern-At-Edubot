import java.security.SecureRandom;

public class PasswordGenerator implements Runnable {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int PASSWORD_LENGTH = 12;
    private User user;
    private String service;

    public PasswordGenerator(User user, String service) {
        this.user = user;
        this.service = service;
    }

    @Override
    public void run() {
        String password = generatePassword();
        synchronized (user) {
            user.addPassword(service, password);
        }
    }

    private String generatePassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(PASSWORD_LENGTH);
        for (int i = 0; i < PASSWORD_LENGTH; i++) {
            sb.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        return sb.toString();
    }
}
