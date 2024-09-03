package entities;

import java.time.LocalDate;

public class Maintenance {
    private int receiptID;
    private int vehicleID;
    private String description;
    private double cost;
    private LocalDate date;
    private int employeeID;
    private String companyEmail;

    public Maintenance(int receiptID, int vehicleID,int employeeID, double cost, String description,String companyEmail, LocalDate date) {
        this.receiptID = receiptID;
        this.vehicleID = vehicleID;
        this.description = description;
        this.cost = cost;
        this.date = date;
        this.employeeID = employeeID;
        this.companyEmail=companyEmail;
    }
    public Maintenance( int vehicleID,int employeeID, double cost, String description,String companyEmail, LocalDate date) {
        this.vehicleID = vehicleID;
        this.description = description;
        this.cost = cost;
        this.date = date;
        this.employeeID = employeeID;
        this.companyEmail=companyEmail;
    }


    public int getReceiptID() {
        return receiptID;
    }

    public void setReceiptID(int receiptID) {
        this.receiptID = receiptID;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeName) {
        this.employeeID = employeeID;
    }

    public String getCompanyEmail() {
        return companyEmail;
    }

    public Maintenance setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
        return this;
    }

}