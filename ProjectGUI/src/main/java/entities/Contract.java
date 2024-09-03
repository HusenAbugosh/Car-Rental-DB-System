package entities;

public class Contract {
    private int contractID;
    private String startDate;
    private String endDate;
    private int vehicleID;
    private int customerID;
    private int employeeID;
    private String customerName;
    private String employeeName;
    private double cost;
    private String contractStatus;
    private String contractType;

    // Constructors, getters, and setters
    public Contract(int contractID, String startDate, String endDate, int vehicleID, int customerID, String customerName, int employeeID, String employeeName, double cost, String contractStatus, String contractType) {
        this.contractID = contractID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.vehicleID = vehicleID;
        this.customerID = customerID;
        this.customerName = customerName;
        this.employeeID = employeeID;
        this.employeeName = employeeName;
        this.cost = cost;
        this.contractStatus = contractStatus;
        this.contractType = contractType;
    }

    // Getters and setters for each attribute
    public int getContractID() { return contractID; }
    public void setContractID(int contractID) { this.contractID = contractID; }

    public String getStartDate() { return startDate; }
    public void setStartDate(String startDate) { this.startDate = startDate; }

    public String getEndDate() { return endDate; }
    public void setEndDate(String endDate) { this.endDate = endDate; }

    public int getVehicleID() { return vehicleID; }
    public void setVehicleID(int vehicleID) { this.vehicleID = vehicleID; }

    public int getCustomerID() { return customerID; }
    public void setCustomerID(int customerID) { this.customerID = customerID; }

    public int getEmployeeID() { return employeeID; }
    public void setEmployeeID(int employeeID) { this.employeeID = employeeID; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }

    public String getContractStatus() { return contractStatus; }
    public void setContractStatus(String contractStatus) { this.contractStatus = contractStatus; }

    public String getContractType() { return contractType; }
    public void setContractType(String contractType) { this.contractType = contractType; }
}
