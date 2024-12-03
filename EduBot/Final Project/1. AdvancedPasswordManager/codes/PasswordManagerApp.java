import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PasswordManagerApp extends JFrame {
    private JTextField usernameField;
    private JTextField serviceField;
    private JTextField passwordField;
    private JTextArea passwordArea;
    private UserManager userManager;

    public PasswordManagerApp() {
        userManager = new UserManager();

        setTitle("Password Manager");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        add(panel);
        placeComponents(panel);

        setVisible(true);
    }

    private void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        usernameField = new JTextField(20);
        usernameField.setBounds(100, 20, 165, 25);
        panel.add(usernameField);

        JLabel serviceLabel = new JLabel("Service:");
        serviceLabel.setBounds(10, 50, 80, 25);
        panel.add(serviceLabel);

        serviceField = new JTextField(20);
        serviceField.setBounds(100, 50, 165, 25);
        panel.add(serviceField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JTextField(20);
        passwordField.setBounds(100, 80, 165, 25);
        panel.add(passwordField);

        JButton addButton = new JButton("Add Password");
        addButton.setBounds(10, 110, 150, 25);
        panel.add(addButton);

        passwordArea = new JTextArea();
        passwordArea.setBounds(10, 140, 350, 100);
        panel.add(passwordArea);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String service = serviceField.getText();
                String password = passwordField.getText();
                
                User user = userManager.getUser(username);
                if (user == null) {
                    userManager.addUser(username);
                    user = userManager.getUser(username);
                }
                user.addPassword(service, password);
                
                passwordArea.setText("Password added for " + service);
            }
        });
    }

    public static void main(String[] args) {
        new PasswordManagerApp();
    }
}
