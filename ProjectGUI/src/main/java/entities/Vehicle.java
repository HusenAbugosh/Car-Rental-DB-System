//import java.time.LocalDate;
package entities;

public class Vehicle {
    private int vehicleID;
    private int power;
    private String color;
    private String plateID;
    private String status;
    private int numberOfPassengers;
    private String model;
    private int year;
    private double trafficDepartmentFees;
    private double dailyRent;
    private double weeklyRent;
    private double monthlyRent;
    private double insurancePayment;

    public Vehicle(int vehicleID, int power, String color, String plateID, String status, int numberOfPassengers, String model, int year, double trafficDepartmentFees, double dailyRent, double weeklyRent, double monthlyRent, double insurancePayment) {
        this.vehicleID = vehicleID;
        this.power = power;
        this.color = color;
        this.plateID = plateID;
        this.status = status;
        this.numberOfPassengers = numberOfPassengers;
        this.model = model;
        this.year = year;
        this.trafficDepartmentFees = trafficDepartmentFees;
        this.dailyRent = dailyRent;
        this.weeklyRent = weeklyRent;
        this.monthlyRent = monthlyRent;
        this.insurancePayment = insurancePayment;
    }
    public Vehicle() {

    }
    public Vehicle( int power, String color, String plateID, String status, int numberOfPassengers, String model, int year, double trafficDepartmentFees, double dailyRent, double weeklyRent, double monthlyRent, double insurancePayment) {
        this.power = power;
        this.color = color;
        this.plateID = plateID;
        this.status = status;
        this.numberOfPassengers = numberOfPassengers;
        this.model = model;
        this.year = year;
        this.trafficDepartmentFees = trafficDepartmentFees;
        this.dailyRent = dailyRent;
        this.weeklyRent = weeklyRent;
        this.monthlyRent = monthlyRent;
        this.insurancePayment = insurancePayment;
    }
    public Vehicle(  int vehicleID,String color, String model, int year ,double dailyRent, double weeklyRent, double monthlyRent,int numberOfPassengers) {
        this.vehicleID=vehicleID;
        this.color = color;
        this.model = model;
        this.year = year;
        this.dailyRent = dailyRent;
        this.weeklyRent = weeklyRent;
        this.monthlyRent = monthlyRent;
        this.numberOfPassengers=numberOfPassengers;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPlateID() {
        return plateID;
    }

    public void setPlateID(String plateID) {
        this.plateID = plateID;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getTrafficDepartmentFees() {
        return trafficDepartmentFees;
    }

    public void setTrafficDepartmentFees(double trafficDepartmentFees) {
        this.trafficDepartmentFees = trafficDepartmentFees;
    }

    public double getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(double dailyRent) {
        this.dailyRent = dailyRent;
    }

    public double getWeeklyRent() {
        return weeklyRent;
    }

    public void setWeeklyRent(double weeklyRent) {
        this.weeklyRent = weeklyRent;
    }

    public double getMonthlyRent() {
        return monthlyRent;
    }

    public void setMonthlyRent(double monthlyRent) {
        this.monthlyRent = monthlyRent;
    }

    public double getInsurancePayment() {
        return insurancePayment;
    }

    public void setInsurancePayment(double insurancePayment) {
        this.insurancePayment = insurancePayment;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicleID=" + vehicleID +
                ", power=" + power +
                ", color='" + color + '\'' +
                ", plateID='" + plateID + '\'' +
                ", status='" + status + '\'' +
                ", numberOfPassengers=" + numberOfPassengers +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", trafficDepartmentFees=" + trafficDepartmentFees +
                ", dailyRent=" + dailyRent +
                ", weeklyRent=" + weeklyRent +
                ", monthlyRent=" + monthlyRent +
                ", insurancePayment=" + insurancePayment +
                '}';
    }

}
