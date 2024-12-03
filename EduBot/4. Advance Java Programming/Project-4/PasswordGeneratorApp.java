import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Random;

public class PasswordGeneratorApp extends JFrame {
    private JSlider lengthSlider;
    private JCheckBox uppercaseCheckBox;
    private JCheckBox lowercaseCheckBox;
    private JCheckBox digitsCheckBox;
    private JCheckBox specialCheckBox;
    private JButton generateButton;
    private JProgressBar progressBar;
    private JPasswordField passwordField;
    private JCheckBox showPasswordCheckBox;

    public PasswordGeneratorApp() {
        setTitle("Password Generator App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500)); // Set preferred window size

        // Header
        JLabel headerLabel = new JLabel("Password Generator App");
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 25));
        add(headerLabel, BorderLayout.NORTH);

        // Form Panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(BorderFactory.createEmptyBorder(20, 40, 0, 40)); // Padding

        JLabel lengthLabel = new JLabel("Password Length:");
        lengthSlider = new JSlider(JSlider.HORIZONTAL, 6, 20, 10);
        lengthSlider.setMajorTickSpacing(2);
        lengthSlider.setMinorTickSpacing(1);
        lengthSlider.setPaintTicks(true);
        lengthSlider.setPaintLabels(true);
        lengthSlider.setSnapToTicks(true);

        JPanel checkboxPanel = new JPanel();
        checkboxPanel.setLayout(new BoxLayout(checkboxPanel, BoxLayout.Y_AXIS));
        checkboxPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0)); // Padding

        Font checkboxFont = new Font("Arial", Font.PLAIN, 18); // Checkbox font

        uppercaseCheckBox = new JCheckBox("Uppercase");
        uppercaseCheckBox.setFont(checkboxFont);
        lowercaseCheckBox = new JCheckBox("Lowercase");
        lowercaseCheckBox.setFont(checkboxFont);
        digitsCheckBox = new JCheckBox("Digits");
        digitsCheckBox.setFont(checkboxFont);
        specialCheckBox = new JCheckBox("Special Characters");
        specialCheckBox.setFont(checkboxFont);

        checkboxPanel.add(uppercaseCheckBox);
        checkboxPanel.add(lowercaseCheckBox);
        checkboxPanel.add(digitsCheckBox);
        checkboxPanel.add(specialCheckBox);

        generateButton = new JButton("Generate");
        generateButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                generatePassword();
            }
        });

        passwordField = new JPasswordField();
        passwordField.setEditable(false);
        passwordField.setHorizontalAlignment(JTextField.CENTER);
        passwordField.setMaximumSize(new Dimension(Integer.MAX_VALUE, 30));
        passwordField.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0)); // Add 10% space at the top
        passwordField.setEchoChar('*');

        showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(checkboxFont);
        showPasswordCheckBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    passwordField.setEchoChar((char) 0);
                } else {
                    passwordField.setEchoChar('*');
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        buttonPanel.add(generateButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(20, 0))); // Add spacing between components
        buttonPanel.add(showPasswordCheckBox);

        formPanel.add(lengthLabel);
        formPanel.add(lengthSlider);
        formPanel.add(checkboxPanel);
        formPanel.add(buttonPanel); // Add the button panel
        formPanel.add(passwordField);

        add(formPanel, BorderLayout.CENTER);

        // Progress Panel
        JPanel progressPanel = new JPanel(new BorderLayout());
        progressBar = new JProgressBar();
        progressBar.setForeground(Color.GREEN); // Change the color to green
        progressBar.setStringPainted(true);
        progressBar.setPreferredSize(new Dimension(500, 20)); // Set progress bar width and height
        progressPanel.add(progressBar, BorderLayout.NORTH);

        add(progressPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);

        PasswordDatabase.createTable(); // Ensure the table exists
    }

    private void generatePassword() {
        int length = lengthSlider.getValue();
        boolean hasUppercase = uppercaseCheckBox.isSelected();
        boolean hasLowercase = lowercaseCheckBox.isSelected();
        boolean hasDigits = digitsCheckBox.isSelected();
        boolean hasSpecial = specialCheckBox.isSelected();

        String uppercaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowercaseChars = "abcdefghijklmnopqrstuvwxyz";
        String digitsChars = "0123456789";
        String specialChars = "!@#$%^&*()-_=+[]{}|;:'\",.<>?/";

        StringBuilder password = new StringBuilder();
        Random random = new Random();

        String allChars = "";
        if (hasUppercase) allChars += uppercaseChars;
        if (hasLowercase) allChars += lowercaseChars;
        if (hasDigits) allChars += digitsChars;
        if (hasSpecial) allChars += specialChars;

        if (allChars.isEmpty()) {
            passwordField.setText("Select at least one character type");
            progressBar.setValue(0);
            progressBar.setString("0%");
            return;
        }

        for (int i = 0; i < length; i++) {
            password.append(allChars.charAt(random.nextInt(allChars.length())));
        }

        // Shuffle the password to avoid patterns
        char[] passwordArray = password.toString().toCharArray();
        for (int i = 0; i < passwordArray.length; i++) {
            int randomIndex = random.nextInt(passwordArray.length);
            char temp = passwordArray[i];
            passwordArray[i] = passwordArray[randomIndex];
            passwordArray[randomIndex] = temp;
        }

        passwordField.setText(new String(passwordArray));

        // Update progress bar to display password strength
        int strength = calculatePasswordStrength(passwordArray);
        progressBar.setValue(strength);
        progressBar.setString(strength + "%");

        // Save generated password to database
        PasswordDatabase.savePassword(new String(passwordArray), LocalDate.now(), strength, false);
    }

    private int calculatePasswordStrength(char[] password) {
        int length = password.length;
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigits = false;
        boolean hasSpecial = false;

        for (char c : password) {
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigits = true;
            } else {
                hasSpecial = true;
            }
        }

        int strength = (length - 6) * 10;
        if (hasUppercase) strength += 10;
        if (hasLowercase) strength += 10;
        if (hasDigits) strength += 10;
        if (hasSpecial) strength += 10;

        return Math.min(strength, 100);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PasswordGeneratorApp app = new PasswordGeneratorApp();
            app.setVisible(true);
        });
    }
}
