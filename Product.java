// Similar method for adding products to the database

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public void addProduct(Payment_BillingSystem.Product product) {
    String sql = "INSERT INTO products (id, name, price) VALUES (?, ?, ?)";

    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, product.getId());
        statement.setString(2, product.getName());
        statement.setDouble(3, product.getPrice());

        statement.executeUpdate();
        System.out.println("Product added successfully.");
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

// Method to retrieve all products from the database
public void displayProducts() {
    String sql = "SELECT * FROM products";

    try (Connection connection = Database.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {
            String id = resultSet.getString("id");
            String name = resultSet.getString("name");
            double price = resultSet.getDouble("price");
            System.out.println("Product ID: " + id + ", Name: " + name + ", Price: " + price);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
