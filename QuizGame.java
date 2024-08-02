import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.sql.*;

public class QuizGame extends JFrame {
    private CardLayout cardLayout;
    private JPanel mainPanel;
    private boolean isLoggedIn = false; // Flag to track login status

    // Database credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user_db";
    private static final String DB_USER = "root"; // Replace with your username
    private static final String DB_PASS = ""; // Replace with your password

    public QuizGame() {
        setTitle("Quiz Game");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create navigation bar
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.DARK_GRAY);
        menuBar.setForeground(Color.WHITE);

        JMenu homeMenu = createMenu("Home");
        JMenu scoreMenu = createMenu("Great Score");
        JMenu rulesMenu = createMenu("Rules");
        JMenu serviceMenu = createMenu("Service");

        JMenu userMenu = createMenu("User");
        JMenuItem registerItem = createMenuItem("Register");
        JMenuItem loginItem = createMenuItem("Login");

        userMenu.add(registerItem);
        userMenu.add(loginItem);

        menuBar.add(homeMenu);
        menuBar.add(scoreMenu);
        menuBar.add(rulesMenu);
        menuBar.add(serviceMenu);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(userMenu);

        setJMenuBar(menuBar);

        // Create main panel with CardLayout
        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);
        mainPanel.setBackground(Color.LIGHT_GRAY);

        // Add pages to the main panel
        mainPanel.add(new HomePage(), "Home");
        mainPanel.add(new RegistrationPage(this), "Register");
        mainPanel.add(new LoginPage(this), "Login");

        // Set default view to LoginPage
        cardLayout.show(mainPanel, "Login");

        add(mainPanel);

        // Action listeners for navigation bar items
        homeMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (isLoggedIn) {
                    cardLayout.show(mainPanel, "Home");
                } else {
                    JOptionPane.showMessageDialog(null, "Please log in first!");
                }
            }
        });

        registerItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Register");
            }
        });

        loginItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "Login");
            }
        });
    }

    private JMenu createMenu(String title) {
        JMenu menu = new JMenu(title);
        menu.setForeground(Color.WHITE);
        menu.setFont(new Font("Arial", Font.BOLD, 14));
        return menu;
    }

    private JMenuItem createMenuItem(String title) {
        JMenuItem menuItem = new JMenuItem(title);
        menuItem.setFont(new Font("Arial", Font.PLAIN, 14));
        return menuItem;
    }

    public void loginSuccessful() {
        isLoggedIn = true;
        cardLayout.show(mainPanel, "Home");
    }

    public void logout() {
        isLoggedIn = false;
        cardLayout.show(mainPanel, "Login");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new QuizGame().setVisible(true);
        });
    }

    // Placeholder for HomePage class
    class HomePage extends BackgroundPanel {
        public HomePage() {
            super("D:\\java folder\\test\\BackGround.jpg"); // Path to your background image
            setBackground(Color.WHITE);
            JLabel label = new JLabel("Home Page");
            label.setFont(new Font("Arial", Font.BOLD, 24));
            add(label);
        }
    }
// Placeholder for RegistrationPage class
class RegistrationPage extends BackgroundPanel {
    public RegistrationPage(QuizGame quizGame) {
        super("D:\\java folder\\test\\BackGround.jpg"); // Path to your background image
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setOpaque(false);
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        JLabel welcomeLabel = new JLabel("Create an account");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(welcomeLabel);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel userLabel = new JLabel("Username:");
        userLabel.setForeground(Color.WHITE);
        userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setMaximumSize(userText.getPreferredSize());
        userText.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(userText);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(emailLabel);

        JTextField emailText = new JTextField(20);
        emailText.setMaximumSize(emailText.getPreferredSize());
        emailText.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(emailText);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setMaximumSize(passwordText.getPreferredSize());
        passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(passwordText);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JButton registerButton = new JButton("Continue");
        registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());
                if (registerUser(username, email, password)) {
                    JOptionPane.showMessageDialog(null, "Registration successful!");
                    quizGame.cardLayout.show(quizGame.mainPanel, "Login"); // Use cardLayout to show LoginPage
                } else {
                    JOptionPane.showMessageDialog(null, "Registration failed!");
                }
            }
        });

        formPanel.add(registerButton);

        formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

        JLabel loginLabel = new JLabel("Already have an account?");
        loginLabel.setForeground(Color.WHITE);
        loginLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.add(loginLabel);

        JButton loginButton = new JButton("Login");
        loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                quizGame.cardLayout.show(quizGame.mainPanel, "Login");
            }
        });

        formPanel.add(loginButton);

        add(formPanel, BorderLayout.CENTER);
    }

    private boolean registerUser(String username, String email, String password) {
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String sql = "INSERT INTO registerinfo (username, email, password) VALUES (?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, email);
            statement.setString(3, password);
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}


    // Placeholder for LoginPage class
    class LoginPage extends BackgroundPanel {
        public LoginPage(QuizGame quizGame) {
            super("D:\\java folder\\test\\BackGround.jpg"); // Path to your background image
            setLayout(new BorderLayout());

            JPanel formPanel = new JPanel();
            formPanel.setOpaque(false);
            formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

            JLabel welcomeLabel = new JLabel("Welcome back");
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
            welcomeLabel.setForeground(Color.WHITE);
            welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(welcomeLabel);

            formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel userLabel = new JLabel("Email:");
            userLabel.setForeground(Color.WHITE);
            userLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(userLabel);

            JTextField userText = new JTextField(20);
            userText.setMaximumSize(userText.getPreferredSize());
            userText.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(userText);

            formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel passwordLabel = new JLabel("Password:");
            passwordLabel.setForeground(Color.WHITE);
            passwordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(passwordLabel);

            JPasswordField passwordText = new JPasswordField(20);
            passwordText.setMaximumSize(passwordText.getPreferredSize());
            passwordText.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(passwordText);

            formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JButton loginButton = new JButton("Login");
            loginButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            loginButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String email = userText.getText();
                    String password = new String(passwordText.getPassword());
                    if (authenticateUser(email, password)) {
                        quizGame.loginSuccessful();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid email or password!");
                    }
                }
            });

            formPanel.add(loginButton);

            formPanel.add(Box.createRigidArea(new Dimension(0, 10)));

            JLabel noAccountLabel = new JLabel("Don't have an account? ");
            noAccountLabel.setForeground(Color.WHITE);
            noAccountLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            formPanel.add(noAccountLabel);

            JButton registerButton = new JButton("Sign Up");
            registerButton.setAlignmentX(Component.CENTER_ALIGNMENT);
            registerButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    quizGame.cardLayout.show(quizGame.mainPanel, "Register");
                }
            });

            formPanel.add(registerButton);

            add(formPanel, BorderLayout.CENTER);
        }

        private boolean authenticateUser(String email, String password) {
            try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
                String sql = "SELECT * FROM registerinfo WHERE email = ? AND password = ?";
                PreparedStatement statement = connection.prepareStatement(sql);
                statement.setString(1, email);
                statement.setString(2, password);
                ResultSet resultSet = statement.executeQuery();
                return resultSet.next();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }

    // Placeholder for BackgroundPanel class
    class BackgroundPanel extends JPanel {
        private BufferedImage backgroundImage;

        public BackgroundPanel(String imagePath) {
            try {
                backgroundImage = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) {
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        }
    }
}
