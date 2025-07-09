import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SCREEN_TO_DO extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;

    public SCREEN_TO_DO() {
        setTitle("Login / Sign Up");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 1)); // زيادة السطر لأزرار أكثر

        usernameField = new JTextField();
        passwordField = new JPasswordField();

        JButton loginButton = new JButton("Login");
        JButton signUpButton = new JButton("Sign Up");

        add(new JLabel("Username:"));
        add(usernameField);
        add(new JLabel("Password:"));
        add(passwordField);
        add(loginButton);
        add(signUpButton);

        // تسجيل الدخول
        loginButton.addActionListener(e -> login());

        // تسجيل مستخدم جديد
        signUpButton.addActionListener(e -> signUp());
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (TaskStorage.validateUser(username, password)) {
            JOptionPane.showMessageDialog(this, "✅ Login successful!");
            dispose(); // إغلاق نافذة الواجهة
            Main.continueAppFromConsole(username); // تشغيل التطبيق من الكونسول
        } else {
            JOptionPane.showMessageDialog(this, "❌ Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void signUp() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        if (username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "❗ Enter both username and password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (TaskStorage.userExists(username)) {
            JOptionPane.showMessageDialog(this, "⚠️ Username already exists", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            TaskStorage.createUser(username, password);
            JOptionPane.showMessageDialog(this, "✅ Sign up successful! Logging in now...");
            dispose(); // إغلاق الشاشة
            Main.continueAppFromConsole(username); // دخول مباشر للكونسول
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SCREEN_TO_DO().setVisible(true));
    }
}
