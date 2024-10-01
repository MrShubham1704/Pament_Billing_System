package Payment_BillingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Billing {

    // Method to add a user
    public void addUser(String name, String email) {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Users (name, email, balance) VALUES (?, ?, 0)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.executeUpdate();
            System.out.println("User added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a product
    public void addProduct(String name, double price) {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Products (name, price) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setDouble(2, price);
            stmt.executeUpdate();
            System.out.println("Product added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to add a transaction
    public void addTransaction(int userId, int productId, int quantity, double totalAmount) {
        Connection connection = DatabaseConnection.getConnection();
        String query = "INSERT INTO Transactions (userId, productId, quantity, totalAmount) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, productId);
            stmt.setInt(3, quantity);
            stmt.setDouble(4, totalAmount);
            stmt.executeUpdate();
            System.out.println("Transaction added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to generate a bill for a user
    public void generateBill(int userId) {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT SUM(totalAmount) AS total FROM Transactions WHERE userId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                double total = rs.getDouble("total");
                System.out.println("Total bill for user " + userId + ": " + total);
            } else {
                System.out.println("No transactions found for user " + userId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display all users
    public void displayUsers() {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Users";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                double balance = rs.getDouble("balance");
                System.out.println("User ID: " + id + ", Name: " + name + ", Email: " + email + ", Balance: " + balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to display all products
    public void displayProducts() {
        Connection connection = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Products";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                System.out.println("Product ID: " + id + ", Name: " + name + ", Price: " + price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
