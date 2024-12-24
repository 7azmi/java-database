package entity;

public class Customer {
    private int id;
    private String name;
    private String address;
    private String contactNum;
    private String email;

    // Default Constructor
    public Customer() {}

    // Parameterized Constructor
    public Customer(int id, String name, String address, String contactNum, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.contactNum = contactNum;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNum() {
        return contactNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // ToString Method
    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", contactNum='" + contactNum + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
