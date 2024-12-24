import dao.CustomerDAOJdbc;

public class JdbcTest {
    public static void main(String[] args) {
        CustomerDAOJdbc dao = new CustomerDAOJdbc();

        // Test Create
        dao.addCustomer("Bob Marley", "123 Reggae St", "999888777", "bob@example.com");

        // Test Read
        System.out.println("All Customers:");
        dao.getAllCustomers().forEach(System.out::println);

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
    }
}
