import config.DatabaseConfig;
import dao.CustomerDAOSpring;
import entity.Customer;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class SpringJdbcTest {
    public static void main(String[] args) {
        // Initialize Spring Context
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        // Get the DAO Bean
        CustomerDAOSpring dao = context.getBean(CustomerDAOSpring.class);

        // Test Create
        dao.addCustomer("Bob Marley", "123 Reggae St", "999888777", "bob@example.com");

        // Test Read
        System.out.println("All Customers:");
        List<Customer> customers = dao.getAllCustomers();
        customers.forEach(System.out::println);

        // Test Update
        dao.updateCustomer(1, "John Updated", "Updated Address", "000111222", "updatedjohn@example.com");

        // Test Read After Update
        System.out.println("After Update:");
        dao.getAllCustomers().forEach(System.out::println);

        // Test Delete
        dao.deleteCustomer(1);

        // Test Read After Delete
        System.out.println("After Deletion:");
        dao.getAllCustomers().forEach(System.out::println);

        // Close context
        context.close();
    }
}
