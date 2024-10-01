package Payment_BillingSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Billing billing = new Billing();
        Scanner scanner = new Scanner(System.in);

        // Input for adding users
        System.out.println("Enter number of users to add:");
        int numUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numUsers; i++) {
            System.out.println("Enter details for User " + (i + 1));
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            billing.addUser(name, email);
        }

        // Input for adding products
        System.out.println("Enter number of products to add:");
        int numProducts = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numProducts; i++) {
            System.out.println("Enter details for Product " + (i + 1));
            System.out.print("Product Name: ");
            String productName = scanner.nextLine();
            System.out.print("Price: ");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            billing.addProduct(productName, price);
        }

        // Input for adding transactions
        System.out.println("Enter number of transactions to add:");
        int numTransactions = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numTransactions; i++) {
            System.out.println("Enter details for Transaction " + (i + 1));
            System.out.print("User ID: ");
            int userId = scanner.nextInt();
            System.out.print("Product ID: ");
            int productId = scanner.nextInt();
            System.out.print("Quantity: ");
            int quantity = scanner.nextInt();
            System.out.print("Total Amount: ");
            double totalAmount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            billing.addTransaction(userId, productId, quantity, totalAmount);
        }

        // Generate bills for all users
        System.out.println("Enter User ID to generate bill:");
        int billUserId = scanner.nextInt();
        billing.generateBill(billUserId);

        // Displaying users and products
        billing.displayUsers();
        billing.displayProducts();

        scanner.close();
    }
}
