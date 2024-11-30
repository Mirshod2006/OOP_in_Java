import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class MySQLExample {
    // JDBC URL, username, and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String USER = "your_username";
    private static final String PASSWORD = "your_password";

    // JDBC variables for opening, closing, and managing connections
    private static Connection connection;

    public static void main(String[] args) {
        try {
            // Step 1: Establish the connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to the database!");

            // Step 2: Perform a simple query
            createTable();
            insertData("John Doe", "john@example.com");
            fetchData();
            updateData(1, "Jane Doe", "jane@example.com");
            deleteData(1);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Step 5: Close the connection
            try {
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static void createTable() throws SQLException {
        String createTableSQL = """
            CREATE TABLE IF NOT EXISTS users (
                id INT AUTO_INCREMENT PRIMARY KEY,
                name VARCHAR(50) NOT NULL,
                email VARCHAR(50) NOT NULL UNIQUE
            )
            """;
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
            System.out.println("Table 'users' created or already exists.");
        }
    }

    private static void insertData(String name, String email) throws SQLException {
        String insertSQL = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertSQL)) {
            statement.setString(1, name);
            statement.setString(2, email);
            statement.executeUpdate();
            System.out.println("Data inserted successfully.");
        }
    }

    private static void fetchData() throws SQLException {
        String querySQL = "SELECT * FROM users";
        try (PreparedStatement statement = connection.prepareStatement(querySQL)) {
            ResultSet resultSet = statement.executeQuery();
            System.out.println("Users in the database:");
            while (resultSet.next()) {
                System.out.printf("ID: %d, Name: %s, Email: %s%n",
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("email"));
            }
        }
    }

    private static void updateData(int id, String newName, String newEmail) throws SQLException {
        String updateSQL = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateSQL)) {
            statement.setString(1, newName);
            statement.setString(2, newEmail);
            statement.setInt(3, id);
            int rowsUpdated = statement.executeUpdate();
            System.out.printf("%d row(s) updated.%n", rowsUpdated);
        }
    }

    private static void deleteData(int id) throws SQLException {
        String deleteSQL = "DELETE FROM users WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(deleteSQL)) {
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            System.out.printf("%d row(s) deleted.%n", rowsDeleted);
        }
    }
}
public class U2310088MySQL{
    public static void main(String[] args) {
        
    }
}