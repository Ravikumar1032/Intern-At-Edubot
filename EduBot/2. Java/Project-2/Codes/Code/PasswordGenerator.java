import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

public class PasswordGenerator {

    private static final String UPPERCASE_LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE_LETTERS = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";
    private static final String ALL_CHARACTERS = UPPERCASE_LETTERS + LOWERCASE_LETTERS + DIGITS + SPECIAL_CHARACTERS;

    private List<String> generatedPasswords = new ArrayList<>();

    public String[] generatePasswords(int numPasswords, int passwordLength) {
        generatedPasswords.clear();
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < numPasswords; i++) {
            StringBuilder password;
            do {
                password = new StringBuilder(passwordLength);
                for (int j = 0; j < passwordLength; j++) {
                    password.append(ALL_CHARACTERS.charAt(random.nextInt(ALL_CHARACTERS.length())));
                }
            } while (!isValidPassword(password.toString()));
            generatedPasswords.add(password.toString());
        }
        return generatedPasswords.toArray(new String[0]);
    }

    private boolean isValidPassword(String password) {
        boolean hasUppercase = password.chars().anyMatch(Character::isUpperCase);
        boolean hasLowercase = password.chars().anyMatch(Character::isLowerCase);
        boolean hasDigit = password.chars().anyMatch(Character::isDigit);
        boolean hasSpecial = password.chars().anyMatch(ch -> SPECIAL_CHARACTERS.indexOf(ch) >= 0);
        return hasUppercase && hasLowercase && hasDigit && hasSpecial;
    }

    public List<String> getGeneratedPasswords() {
        return generatedPasswords;
    }
}
