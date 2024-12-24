package dao;

import entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDAOSpring {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerDAOSpring(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addCustomer(String name, String address, String contactNum, String email) {
        String sql = "INSERT INTO customer (name, address, contactNum, email) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(sql, name, address, contactNum, email);
        System.out.println("Customer added successfully.");
    }

    public List<Customer> getAllCustomers() {
        String sql = "SELECT * FROM customer";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Customer.class));
    }

    public void updateCustomer(int id, String name, String address, String contactNum, String email) {
        String sql = "UPDATE customer SET name = ?, address = ?, contactNum = ?, email = ? WHERE id = ?";
        jdbcTemplate.update(sql, name, address, contactNum, email, id);
        System.out.println("Customer updated successfully.");
    }

    public void deleteCustomer(int id) {
        String sql = "DELETE FROM customer WHERE id = ?";
        jdbcTemplate.update(sql, id);
        System.out.println("Customer deleted successfully.");
    }
}
