import java.sql.*;
import java.util.Scanner;

public class Main {

    static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASSWORD = "PASSWORD"; // change this

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n==== EXPENSE TRACKER (JDBC) ====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Category Summary");
            System.out.println("5. Update Expense");
            System.out.println("6. Delete Expense");
            System.out.println("7. Exit");

            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> addExpense();
                case 2 -> viewExpenses();
                case 3 -> totalSpending();
                case 4 -> categorySummary();
                case 5 -> updateExpense();
                case 6 -> deleteExpense();
                case 7 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 1. Add Expense
    static void addExpense() {
        try (Connection con = getConnection()) {

            System.out.print("Enter date (YYYY-MM-DD): ");
            String date = sc.nextLine();

            System.out.print("Enter category: ");
            String category = sc.nextLine();

            System.out.print("Enter amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            String sql = "INSERT INTO expenses (date, category, amount) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDate(1, Date.valueOf(date));
            ps.setString(2, category);
            ps.setDouble(3, amount);

            ps.executeUpdate();

            System.out.println("Expense added");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 2. View Expenses
    static void viewExpenses() {
        try (Connection con = getConnection()) {

            String sql = "SELECT * FROM expenses";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- Expenses ---");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("id") + " | " +
                        rs.getDate("date") + " | " +
                        rs.getString("category") + " | " +
                        rs.getDouble("amount")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 3. Total Spending
    static void totalSpending() {
        try (Connection con = getConnection()) {

            String sql = "SELECT SUM(amount) AS total FROM expenses";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                System.out.println("Total Spending: " + rs.getDouble("total"));
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 4. Category Summary
    static void categorySummary() {
        try (Connection con = getConnection()) {

            String sql = "SELECT category, SUM(amount) AS total FROM expenses GROUP BY category";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n--- Category Summary ---");

            while (rs.next()) {
                System.out.println(
                        rs.getString("category") + " : " +
                        rs.getDouble("total")
                );
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 5. Update Expense
    static void updateExpense() {
        try (Connection con = getConnection()) {

            System.out.print("Enter Expense ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("New category: ");
            String category = sc.nextLine();

            System.out.print("New amount: ");
            double amount = sc.nextDouble();
            sc.nextLine();

            String sql = "UPDATE expenses SET category=?, amount=? WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, category);
            ps.setDouble(2, amount);
            ps.setInt(3, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Updated successfully");
            else
                System.out.println("Expense not found");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // 6. Delete Expense
    static void deleteExpense() {
        try (Connection con = getConnection()) {

            System.out.print("Enter Expense ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();

            String sql = "DELETE FROM expenses WHERE id=?";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0)
                System.out.println("Deleted successfully");
            else
                System.out.println("Expense not found");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}