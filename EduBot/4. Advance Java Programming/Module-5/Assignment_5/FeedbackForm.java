import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FeedbackForm extends JFrame implements ActionListener {
    // Components
    private JLabel headerLabel, nameLabel, emailLabel, feedbackLabel, messageLabel;
    private JTextField nameField, emailField;
    private JTextArea feedbackArea;
    private JButton submitButton;

    public FeedbackForm() {
        // Set window title
        super("Feedback Form");

        // Initialize components
        headerLabel = new JLabel("Feedback Form");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        headerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        feedbackLabel = new JLabel("Description:");
        messageLabel = new JLabel("");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        nameField = new JTextField(20);
        emailField = new JTextField(20);
        feedbackArea = new JTextArea(5, 20);
        feedbackArea.setLineWrap(true);
        feedbackArea.setWrapStyleWord(true);
        JScrollPane feedbackScrollPane = new JScrollPane(feedbackArea);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);

        // Set layout
        setLayout(new BorderLayout(10, 10));

        // Create panels for structured layout
        JPanel headerPanel = new JPanel();
        headerPanel.add(headerLabel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.NORTH;

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(nameLabel, gbc);

        gbc.gridy = 1;
        formPanel.add(nameField, gbc);

        gbc.gridy = 2;
        formPanel.add(emailLabel, gbc);

        gbc.gridy = 3;
        formPanel.add(emailField, gbc);

        gbc.gridy = 4;
        formPanel.add(feedbackLabel, gbc);

        gbc.gridy = 5;
        formPanel.add(feedbackScrollPane, gbc);

        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.CENTER;
        formPanel.add(submitButton, gbc);

        JPanel messagePanel = new JPanel();
        messagePanel.add(messageLabel);

        // Add panels to frame
        add(headerPanel, BorderLayout.NORTH);
        add(formPanel, BorderLayout.CENTER);
        add(messagePanel, BorderLayout.SOUTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null); // Center the frame
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String name = nameField.getText();
            String email = emailField.getText();
            String feedback = feedbackArea.getText();

            // Perform validation
            if (feedback.isEmpty()) {
                messageLabel.setText("Please provide feedback.");
            } else {
                // Display confirmation message
                messageLabel.setText("Thank you for your feedback, " + name + "!");
            }
        }
    }

    public static void main(String[] args) {
        // Create and show the GUI on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FeedbackForm();
            }
        });
    }
}
