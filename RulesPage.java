
import javax.swing.*;
import java.awt.*;

public class RulesPage extends JPanel {
    public RulesPage() {
        // Set the layout for the main panel
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);

        // Create a content panel with a BorderLayout
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        // Add a title label
        JLabel titleLabel = new JLabel("Quiz Game Rules", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLUE);
        contentPanel.add(titleLabel, BorderLayout.NORTH);

        // Add rules in a text area
        JTextArea rulesTextArea = new JTextArea();
        rulesTextArea.setEditable(false);
        rulesTextArea.setFont(new Font("Arial", Font.PLAIN, 14));
        rulesTextArea.setText(getRulesText());
        rulesTextArea.setMargin(new Insets(10, 10, 10, 10));
        rulesTextArea.setLineWrap(true);
        rulesTextArea.setWrapStyleWord(true);

        // Add a scroll pane for the text area
        JScrollPane scrollPane = new JScrollPane(rulesTextArea);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        contentPanel.add(scrollPane, BorderLayout.CENTER);

        // Add content panel to the main panel
        add(contentPanel, BorderLayout.CENTER);
    }

    private String getRulesText() {
        return "### Quiz Game Rules\n\n" +
                "1. **Eligibility**:\n" +
                "- The quiz is open to participants of all ages.\n" +
                "- Participants must register and log in to play.\n\n" +
                "2. **Format**:\n" +
                "- The quiz consists of multiple-choice questions.\n" +
                "- Each question will have four options, and only one correct answer.\n" +
                "- The quiz is time-bound, and the timer starts as soon as the quiz begins.\n\n" +
                "3. **Scoring**:\n" +
                "- Each correct answer awards 10 points.\n" +
                "- No negative marking for wrong answers.\n" +
                "- Skipped questions will not affect the score.\n\n" +
                "4. **Time Limit**:\n" +
                "- Each question must be answered within 30 seconds.\n" +
                "- The total time for the quiz is 10 minutes.\n\n" +
                "5. **Conduct**:\n" +
                "- Participants must not seek help from others.\n" +
                "- The use of external resources such as books, internet, or any electronic devices is prohibited.\n" +
                "- Any form of cheating will result in immediate disqualification.\n\n" +
                "6. **Technical Issues**:\n" +
                "- In case of technical issues (e.g., loss of internet connection), participants should report to the organizers immediately.\n" +
                "- The organizers are not responsible for technical failures caused by the participant's device.\n\n" +
                "7. **Results**:\n" +
                "- Scores will be displayed immediately after the quiz ends.\n" +
                "- The top scorers will be displayed on the leaderboard.\n" +
                "- In case of a tie, the participant who completed the quiz in the least time will be ranked higher.\n\n" +
                "8. **Prizes**:\n" +
                "- Prizes (if any) will be awarded to the top scorers.\n" +
                "- The details of the prizes and distribution will be communicated by the organizers.\n\n" +
                "9. **Disqualification**:\n" +
                "- Participants found violating any rules will be disqualified from the quiz.\n" +
                "- Decisions made by the organizers are final and binding.\n\n" +
                "10. **Feedback**:\n" +
                "- Participants are encouraged to provide feedback after the quiz.\n" +
                "- Feedback can be submitted through the provided form on the website.\n\n" +
                "### Additional Guidelines\n\n" +
                "- Ensure you have a stable internet connection before starting the quiz.\n" +
                "- Read each question carefully before selecting an answer.\n" +
                "- Manage your time effectively to maximize your score.\n" +
                "- Stay calm and focused throughout the quiz.\n\n" +
                "By participating in the quiz, you agree to abide by these rules and regulations. Enjoy the quiz and good luck!";
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Quiz Game - Rules");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(new RulesPage());
        frame.setVisible(true);
    }
}
