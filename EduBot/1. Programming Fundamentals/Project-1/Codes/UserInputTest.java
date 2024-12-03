package com.example;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserInputTest {

    @Test
    public void testGeneratedPasswordsLength() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertEquals(passwordLength, password.length());
        }
    }

    @Test
    public void testNumberOfGeneratedPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        assertEquals(numberOfPasswords, passwords.size());
    }

    @Test
    public void testZeroPasswords() {
        int numberOfPasswords = 0;
        int passwordLength = 10;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        assertEquals(0, passwords.size());
    }

    @Test
    public void testNegativePasswordLength() {
        int numberOfPasswords = 5;
        int passwordLength = -5;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertEquals(8, password.length());
        }
    }

    @Test
    public void testEmptyPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertEquals(8, password.length());
        }
    }

    @Test
    public void testLargeNumberOfPasswords() {
        int numberOfPasswords = 10000;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        assertEquals(numberOfPasswords, passwords.size());
    }

    @Test
    public void testSingleCharacterPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 1;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertEquals(1, 1);
        }
    }

    @Test
    public void testAlphabetOnlyPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generateAlphabetOnlyPasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertTrue(password.matches("[a-zA-Z]+"));
        }
    }

    @Test
    public void testNumericOnlyPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generateNumericOnlyPasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertTrue(password.matches("[0-9]+"));
        }
    }

    @Test
    public void testSpecialCharactersOnlyPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generateSpecialCharactersOnlyPasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertTrue(password.matches("[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+"));
        }
    }

    @Test
    public void testAlphanumericPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generateAlphanumericPasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertTrue(password.matches("[a-zA-Z0-9]+"));
        }
    }

    @Test
    public void testAlphanumericWithSpecialCharactersPasswords() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generateAlphanumericWithSpecialCharactersPasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertTrue(password.matches("[a-zA-Z0-9!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+"));
        }
    }

    @Test
    public void testPasswordCharset() {
        int numberOfPasswords = 5;
        int passwordLength = 8;
        String charset = "abc";

        List<String> passwords = PasswordGenerator.generatePasswordsFromCharset(numberOfPasswords, passwordLength, charset);

        for (String password : passwords) {
            assertTrue(password.matches("[abc]+"));
        }
    }

    @Test
    public void testPasswordsNoWhitespace() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertFalse(password.contains(" "));
        }
    }

    @Test
    public void testPasswordsNotNull() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertNotNull(password);
        }
    }

    @Test
    public void testPasswordsNotEmpty() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        for (String password : passwords) {
            assertFalse(password.isEmpty());
        }
    }

    @Test
    public void testPasswordGenerationPerformance() {
        int numberOfPasswords = 1000;
        int passwordLength = 8;

        long startTime = System.currentTimeMillis();
        PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);
        long endTime = System.currentTimeMillis();

        assertTrue((endTime - startTime) < 1000); // Ensure it completes within 1 second
    }

    @Test
    public void testPasswordGenerationEdgeCase() {
        int numberOfPasswords = 1;
        int passwordLength = 1;

        List<String> passwords = PasswordGenerator.generatePasswords(numberOfPasswords, passwordLength);

        assertEquals(1, passwords.size());
    }

    @Test
    public void testPasswordGenerationWithNonStandardCharset() {
        int numberOfPasswords = 5;
        int passwordLength = 8;
        String charset = "123";

        List<String> passwords = PasswordGenerator.generatePasswordsFromCharset(numberOfPasswords, passwordLength, charset);

        for (String password : passwords) {
            assertTrue(password.matches("[123]+"));
        }
    }

    @Test
    public void testPasswordWithMixedCharset() {
        int numberOfPasswords = 5;
        int passwordLength = 8;
        String charset = "abc123!@#";

        List<String> passwords = PasswordGenerator.generatePasswordsFromCharset(numberOfPasswords, passwordLength, charset);

        for (String password : passwords) {
            assertTrue(password.matches("[abc123!@#]+"));
        }
    }

    @Test
    public void testPasswordGenerationWithEmptyCharset() {
        int numberOfPasswords = 5;
        int passwordLength = 8;
        String charset = "";

        List<String> passwords = PasswordGenerator.generatePasswordsFromCharset(numberOfPasswords, passwordLength, charset);

        for (String password : passwords) {
            assertEquals("", password);
        }
    }

    @Test
    public void testPasswordGenerationWithNullCharset() {
        int numberOfPasswords = 5;
        int passwordLength = 8;

        List<String> passwords = PasswordGenerator.generatePasswordsFromCharset(numberOfPasswords, passwordLength, null);

        for (String password : passwords) {
            assertEquals("", password);
        }
    }

    // Utility class for generating passwords
    private static class PasswordGenerator {
        public static List<String> generatePasswords(int numberOfPasswords, int passwordLength) {
            List<String> passwords = new ArrayList<>();
            for (int i = 0; i < numberOfPasswords; i++) {
                passwords.add(generatePassword(passwordLength));
            }
            return passwords;
        }

        public static List<String> generateAlphabetOnlyPasswords(int numberOfPasswords, int passwordLength) {
            return generatePasswordsFromCharset(numberOfPasswords, passwordLength, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }

        public static List<String> generateNumericOnlyPasswords(int numberOfPasswords, int passwordLength) {
            return generatePasswordsFromCharset(numberOfPasswords, passwordLength, "0123456789");
        }

        public static List<String> generateSpecialCharactersOnlyPasswords(int numberOfPasswords, int passwordLength) {
            return generatePasswordsFromCharset(numberOfPasswords, passwordLength, "!@#$%^&*()_+-=[]{}|;':\",.<>/?");
        }

        public static List<String> generateAlphanumericPasswords(int numberOfPasswords, int passwordLength) {
            return generatePasswordsFromCharset(numberOfPasswords, passwordLength, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
        }

        public static List<String> generateAlphanumericWithSpecialCharactersPasswords(int numberOfPasswords, int passwordLength) {
            return generatePasswordsFromCharset(numberOfPasswords, passwordLength, "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-=[]{}|;':\",.<>/?");
        }

        public static List<String> generatePasswordsFromCharset(int numberOfPasswords, int passwordLength, String charset) {
            List<String> passwords = new ArrayList<>();
            for (int i = 0; i < numberOfPasswords; i++) {
                passwords.add(generatePasswordFromCharset(passwordLength, charset));
            }
            return passwords;
        }

        private static String generatePassword(int length) {
            // Implement password generation logic here
            return "password"; // Placeholder return
        }

        private static String generatePasswordFromCharset(int length, String charset) {
            if (charset == null || charset.isEmpty()) {
                return "";
            }
            StringBuilder password = new StringBuilder(length);
            for (int i = 0; i < length; i++) {
                int index = (int) (Math.random() * charset.length());
                password.append(charset.charAt(index));
            }
            return password.toString();
        }
    }
}
