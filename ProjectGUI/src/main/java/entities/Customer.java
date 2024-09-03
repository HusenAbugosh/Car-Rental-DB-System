package entities;



public class Customer {
    // Attributes of the Customer class
    private String customerID;  // Unique identifier
    private String firstName;  // Customer's first name
    private String lastName;  // Customer's last name
    private String address;  // Address of the customer

    private String phone;  // Customer's phone number
    private String licenseNumber;  // License number

    // Constructor to initialize all attributes
    public Customer(String customerID, String firstName, String lastName, String address, String licenseNumber, String phone) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.licenseNumber = licenseNumber;
    }

    public Customer() {

    }

    // Getter and setter for Customer_ID
    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    // Getter and setter for First_name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and setter for Last_name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and setter for Address
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }



    // Getter and setter for Phone
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // Getter and setter for License_number
    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    // Optional: Override toString to print customer information
    @Override
    public String toString() {
        return "Customer{" +
                "Customer_ID=" + customerID +
                ", First_name='" + firstName + '\'' +
                ", Last_name='" + lastName + '\'' +
                ", Address='" + address + '\'' +

                ", Phone='" + phone + '\'' +
                ", License_number='" + licenseNumber + '\'' +
                '}';
    }
}