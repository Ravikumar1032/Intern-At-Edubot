import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Student {
    private String name;
    private int id;
    private int age;
    private String contact;

    public Student(String name, int id, int age, String contact) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.contact = contact;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
}

public class StudentManagementApp extends JFrame implements ActionListener {
    private ArrayList<Student> studentRecords;
    private JTextField nameField, idField, ageField, contactField;
    private JButton addButton, viewButton, updateButton, deleteButton;
    private JTable table;

    public StudentManagementApp() {
        studentRecords = new ArrayList<>();

        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Create header
        JLabel headerLabel = new JLabel("Student Management App", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(headerLabel, BorderLayout.NORTH);

        // Create form panel
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));
        formPanel.setBorder(new EmptyBorder(30, 30, 30, 30)); // 10% padding relative to the input field width

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBorder(new EmptyBorder(0, 0, 3, 0)); // 10% padding relative to the input field height
        formPanel.add(nameLabel);

        nameField = new JTextField();
        nameField.setPreferredSize(new Dimension(550, 30));
        nameField.setMaximumSize(nameField.getPreferredSize());
        formPanel.add(nameField);

        JLabel idLabel = new JLabel("ID:");
        idLabel.setBorder(new EmptyBorder(0, 0, 3, 0)); // 10% padding relative to the input field height
        formPanel.add(idLabel);

        idField = new JTextField();
        idField.setPreferredSize(new Dimension(550, 30));
        idField.setMaximumSize(idField.getPreferredSize());
        formPanel.add(idField);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBorder(new EmptyBorder(0, 0, 3, 0)); // 10% padding relative to the input field height
        formPanel.add(ageLabel);

        ageField = new JTextField();
        ageField.setPreferredSize(new Dimension(550, 30));
        ageField.setMaximumSize(ageField.getPreferredSize());
        formPanel.add(ageField);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBorder(new EmptyBorder(0, 0, 3, 0)); // 10% padding relative to the input field height
        formPanel.add(contactLabel);

        contactField = new JTextField();
        contactField.setPreferredSize(new Dimension(550, 30));
        contactField.setMaximumSize(contactField.getPreferredSize());
        formPanel.add(contactField);

        // Create buttons
        addButton = new JButton("Add");
        addButton.addActionListener(this);
        viewButton = new JButton("View");
        viewButton.addActionListener(this);
        updateButton = new JButton("Update");
        updateButton.addActionListener(this);
        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(this);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);

        // Create table
        String[] columnNames = {"Name", "ID", "Age", "Contact"};
        table = new JTable(new DefaultTableModel(columnNames, 0));
        JScrollPane scrollPane = new JScrollPane(table);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addStudent();
        } else if (e.getSource() == viewButton) {
            viewStudents();
        } else if (e.getSource() == updateButton) {
            updateStudent();
        } else if (e.getSource() == deleteButton) {
            deleteStudent();
        }
    }

    private void addStudent() {
        try {
            String name = nameField.getText();
            int id = Integer.parseInt(idField.getText());
            int age = Integer.parseInt(ageField.getText());
            String contact = contactField.getText();
            Student student = new Student(name, id, age, contact);
            studentRecords.add(student);
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter valid data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void viewStudents() {
        if (studentRecords.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student records available.", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            String[] columnNames = {"Name", "ID", "Age", "Contact"};
            Object[][] data = new Object[studentRecords.size()][4];
            for (int i = 0; i < studentRecords.size(); i++) {
                Student student = studentRecords.get(i);
                data[i][0] = student.getName();
                data[i][1] = student.getId();
                data[i][2] = student.getAge();
                data[i][3] = student.getContact();
            }
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel(model);

            JOptionPane.showMessageDialog(this, new JScrollPane(table), "Student Records", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void updateStudent() {
        try {
            int idToUpdate = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter ID to update:"));
            Student studentToUpdate = null;
            for (Student student : studentRecords) {
                if (student.getId() == idToUpdate) {
                    studentToUpdate = student;
                    break;
                }
            }
            if (studentToUpdate != null) {
                // Create a dialog for updating name, age, and contact
                JTextField nameField = new JTextField(studentToUpdate.getName());
                JTextField ageField = new JTextField(String.valueOf(studentToUpdate.getAge()));
                JTextField contactField = new JTextField(studentToUpdate.getContact());
                Object[] message = {
                    "Name:", nameField,
                    "Age:", ageField,
                    "Contact:", contactField
                };

                int option = JOptionPane.showConfirmDialog(this, message, "Update Student", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    String newName = nameField.getText();
                    int newAge = Integer.parseInt(ageField.getText());
                    String newContact = contactField.getText();

                    studentToUpdate.setName(newName);
                    studentToUpdate.setAge(newAge);
                    studentToUpdate.setContact(newContact);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Student with ID " + idToUpdate + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid ID or Age. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteStudent() {
        if (studentRecords.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No student records available.", "Message", JOptionPane.INFORMATION_MESSAGE);
        } else {
            try {
                int idToDelete = Integer.parseInt(JOptionPane.showInputDialog(this, "Enter ID to delete:"));
                boolean found = false;
                for (int i = 0; i < studentRecords.size(); i++) {
                    if (studentRecords.get(i).getId() == idToDelete) {
                        studentRecords.remove(i);
                        found = true;
                        break;
                    }
                }
                if (found) {
                    JOptionPane.showMessageDialog(this, "Student with ID " + idToDelete + " deleted.", "Information", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Student with ID " + idToDelete + " not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid ID. Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void clearFields() {
        nameField.setText("");
        idField.setText("");
        ageField.setText("");
        contactField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentManagementApp::new);
    }
}