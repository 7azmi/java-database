package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOJdbc {
    private static final String URL = "jdbc:mysql://localhost:3306/your_database_name";
    private static final String USER = "app_user";  // New user
    private static final String PASSWORD = "app_password";  // New password

    // 1. Create a connection
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // 2. Create: Add a new customer
    public void addCustomer(String name, String address, String contactNum, String email) {
        String sql = "INSERT INTO customer (name, address, contactNum, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, contactNum);
            stmt.setString(4, email);
            stmt.executeUpdate();

            System.out.println("Customer added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 3. Read: Get all customers
    public List<String> getAllCustomers() {
        List<String> customers = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String customer = "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Address: " + rs.getString("address") +
                        ", Contact: " + rs.getString("contactNum") +
                        ", Email: " + rs.getString("email");
                customers.add(customer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    // 4. Update: Update a customer's details
    public void updateCustomer(int id, String name, String address, String contactNum, String email) {
        String sql = "UPDATE customer SET name = ?, address = ?, contactNum = ?, email = ? WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setString(2, address);
            stmt.setString(3, contactNum);
            stmt.setString(4, email);
            stmt.setInt(5, id);
            stmt.executeUpdate();

            System.out.println("Customer updated successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 5. Delete: Remove a customer
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();

            System.out.println("Customer deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
