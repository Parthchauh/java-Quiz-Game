
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ServicePage extends JPanel {
    public ServicePage() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Create a content panel with a BoxLayout
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Add a title label
        JLabel titleLabel = new JLabel("Service and Support", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        contentPanel.add(titleLabel);

        // Add sections with details
        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        contentPanel.add(createSectionLabel("Customer Support Information"));
        contentPanel.add(createTextArea("For support, contact us at:\nEmail: support@quizgame.com\nPhone: +123456789\nSupport Hours: 9 AM - 5 PM (Mon-Fri)"));

        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        contentPanel.add(createSectionLabel("Technical Support"));
        contentPanel.add(createTextArea("For technical issues, follow these steps:\n1. Check your internet connection.\n2. Restart the application.\n3. Report the issue to support@quizgame.com."));

        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        contentPanel.add(createSectionLabel("Feedback and Suggestions"));
        contentPanel.add(createTextArea("We value your feedback! Please send your suggestions to feedback@quizgame.com."));

        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        contentPanel.add(createSectionLabel("Terms of Service"));
        contentPanel.add(createTextArea("Read our terms and conditions at www.quizgame.com/terms."));

        contentPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Spacer

        contentPanel.add(createSectionLabel("Privacy Policy"));
        contentPanel.add(createTextArea("Your privacy is important to us. Read our privacy policy at www.quizgame.com/privacy."));

        // Add feedback form
        contentPanel.add(Box.createRigidArea(new Dimension(0, 20))); // Spacer
        contentPanel.add(createFeedbackForm());

        // Add a scroll pane for the content panel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Add scroll pane to the main panel
        add(scrollPane, BorderLayout.CENTER);
    }

    private JLabel createSectionLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 18));
        label.setForeground(Color.DARK_GRAY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    private JTextArea createTextArea(String text) {
        JTextArea textArea = new JTextArea(text);
        textArea.setEditable(false);
        textArea.setFont(new Font("Arial", Font.PLAIN, 14));
        textArea.setBackground(Color.WHITE);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        textArea.setMaximumSize(new Dimension(600, Integer.MAX_VALUE));
        return textArea;
    }

    private JPanel createFeedbackForm() {
        JPanel feedbackPanel = new JPanel();
        feedbackPanel.setLayout(new GridBagLayout());
        feedbackPanel.setBackground(Color.WHITE);
        feedbackPanel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Feedback Form"));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add form elements
        JLabel nameLabel = createLabel("Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        feedbackPanel.add(nameLabel, gbc);

        JTextField nameField = createTextField();
        gbc.gridx = 1;
        feedbackPanel.add(nameField, gbc);

        JLabel dateLabel = createLabel("Date:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        feedbackPanel.add(dateLabel, gbc);

        JTextField dateField = createTextField();
        gbc.gridx = 1;
        feedbackPanel.add(dateField, gbc);

        JLabel ratingLabel = createLabel("Rating:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        feedbackPanel.add(ratingLabel, gbc);

        JPanel ratingPanel = new JPanel();
        ratingPanel.setBackground(Color.WHITE);
        JRadioButton goodButton = new JRadioButton("Good");
        JRadioButton badButton = new JRadioButton("Bad");
        ButtonGroup ratingGroup = new ButtonGroup();
        ratingGroup.add(goodButton);
        ratingGroup.add(badButton);
        ratingPanel.add(goodButton);
        ratingPanel.add(badButton);
        gbc.gridx = 1;
        feedbackPanel.add(ratingPanel, gbc);

        JLabel emailLabel = createLabel("Email ID:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        feedbackPanel.add(emailLabel, gbc);

        JTextField emailField = createTextField();
        gbc.gridx = 1;
        feedbackPanel.add(emailField, gbc);

        JLabel commentsLabel = createLabel("Comments:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        feedbackPanel.add(commentsLabel, gbc);

        JTextArea commentsArea = new JTextArea(5, 20);
        commentsArea.setLineWrap(true);
        commentsArea.setWrapStyleWord(true);
        commentsArea.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane commentsScrollPane = new JScrollPane(commentsArea);
        gbc.gridx = 1;
        feedbackPanel.add(commentsScrollPane, gbc);

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(70, 130, 180)); // Steel blue color
        submitButton.setForeground(Color.WHITE);
        submitButton.setFont(new Font("Arial", Font.BOLD, 16));
        submitButton.setFocusPainted(false);
        gbc.gridx = 1;
        gbc.gridy = 5;
        feedbackPanel.add(submitButton, gbc);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String date = dateField.getText();
                String email = emailField.getText();
                String comments = commentsArea.getText();
                String rating = goodButton.isSelected() ? "Good" : "Bad";

                // Handle form submission (for now just show a message dialog)
                JOptionPane.showMessageDialog(null, 
                    "Feedback submitted!\n\n" +
                    "Name: " + name + "\n" +
                    "Date: " + date + "\n" +
                    "Rating: " + rating + "\n" +
                    "Email: " + email + "\n" +
                    "Comments: " + comments, 
                    "Feedback Submitted", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        return feedbackPanel;
    }

    // Helper method to create a JLabel with consistent styling
    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 16));
        return label;
    }

    // Helper method to create a JTextField with consistent styling
    private JTextField createTextField() {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Arial", Font.PLAIN, 16));
        return textField;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Service and Support");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.add(new ServicePage());
        frame.setVisible(true);
    }
}
