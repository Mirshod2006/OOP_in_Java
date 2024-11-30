import java.sql.*;
import java.util.Scanner;

public class U2310088Lab8 {
    // Database connection details
    static final String DB_URL = "jdbc:mysql://localhost:3306/BMI_DB";
    static final String USER = "mironshoh";
    static final String PASS = "02072021Imronbek@";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Scanner scanner = new Scanner(System.in);
            int choice;
            do {
                // Display menu
                System.out.println("\n--- BMI Database Manager ---");
                System.out.println("1. View Records");
                System.out.println("2. Insert Record");
                System.out.println("3. Update Record");
                System.out.println("4. Delete Record");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        viewRecords(conn);
                        break;
                    case 2:
                        insertRecord(conn, scanner);
                        break;
                    case 3:
                        updateRecord(conn, scanner);
                        break;
                    case 4:
                        deleteRecord(conn, scanner);
                        break;
                    case 5:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } while (choice != 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to view records
    private static void viewRecords(Connection conn) throws SQLException {
        String query = "SELECT * FROM BMI";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- BMI Records ---");
            while (rs.next()) {
                System.out.println("PersonID: " + rs.getInt("PersonID") +
                                   ", Name: " + rs.getString("PersonName") +
                                   ", Weight: " + rs.getInt("Weight") +
                                   ", Height: " + rs.getInt("Height"));
            }
        }
    }

    // Method to insert a record
    private static void insertRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter PersonID: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Weight: ");
        int weight = scanner.nextInt();
        System.out.print("Enter Height: ");
        int height = scanner.nextInt();

        String query = "INSERT INTO BMI (PersonID, PersonName, Weight, Height) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, weight);
            pstmt.setInt(4, height);
            pstmt.executeUpdate();
            System.out.println("Record inserted successfully.");
        }
    }

    // Method to update a record
    private static void updateRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter PersonID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new Weight: ");
        int weight = scanner.nextInt();
        System.out.print("Enter new Height: ");
        int height = scanner.nextInt();


        String query = "UPDATE BMI SET Weight = ?, Height = ? WHERE PersonID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, weight);
            pstmt.setInt(2, height);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            System.out.println("Record updated successfully.");
        }
    }

    // Method to delete a record
    private static void deleteRecord(Connection conn, Scanner scanner) throws SQLException {
        System.out.print("Enter PersonID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM BMI WHERE PersonID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            System.out.println("Record deleted successfully.");
        }
    }
}

