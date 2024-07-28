import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class SimpleUserSystem {
    public static void main(String[] args) {
        String username = JOptionPane.showInputDialog("Enter username:");
        String password = JOptionPane.showInputDialog("Enter password:");

        String url = "jdbc:mysql://localhost:3306/user_db";
        String user = "root"; // replace with your database username
        String pass = ""; // replace with your database password

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            String sql = "INSERT INTO registerinfo (username, password) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(null, "A new user has been inserted successfully!");
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
