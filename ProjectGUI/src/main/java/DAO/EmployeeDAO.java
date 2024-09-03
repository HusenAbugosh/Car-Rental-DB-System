package DAO;

import entities.Employee;
import entities.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    // Method to retrieve all employees
    public List<Employee> getAllEmployees() {
        List<Employee> employees = new ArrayList<>();
        String query = "SELECT * FROM Employees WHERE Status = TRUE";

        try (Connection con = Connector.getCon();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                Employee employee = new Employee(
                        rs.getString("Employee_ID"),
                        rs.getString("First_name"),
                        rs.getString("Last_name"),
                        rs.getDouble("Salary"),
                        rs.getString("Phone"),
                        rs.getString("Gender"),
                        rs.getString("emp_Role"),
                        rs.getString("Address"),
                        rs.getDate("Hire_date"),
                        rs.getBoolean("Status"),
                        rs.getString("Password")
                );
                employees.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public List<Employee> searchEmployees(String field, String value) {
        List<Employee> employees = new ArrayList<>();
        String query;

        if (field.equals("Hire Date")) {
            query = "SELECT * FROM Employees WHERE " + field.replace(" ", "_") + " = ?";
        } else if (field.equals("Status")) {
            query = "SELECT * FROM Employees WHERE " + field.replace(" ", "_") + " = ?";
        } else {
            query = "SELECT * FROM Employees WHERE " + field.replace(" ", "_") + " LIKE ?";
            value = "%" + value + "%";
        }

        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            if (field.equals("Status")) {
                stmt.setBoolean(1, Boolean.parseBoolean(value));
            } else {
                stmt.setString(1, value);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Employee employee = new Employee(
                            rs.getString("Employee_ID"),
                            rs.getString("First_name"),
                            rs.getString("Last_name"),
                            rs.getDouble("Salary"),
                            rs.getString("Phone"),
                            rs.getString("Gender"),
                            rs.getString("emp_Role"),
                            rs.getString("Address"),
                            rs.getDate("Hire_date"),
                            rs.getBoolean("Status"),
                            rs.getString("Password")
                    );
                    employees.add(employee);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    // Method to get an employee by ID
    public Employee getEmployeeByID(String employeeID) {
        String query = "SELECT * FROM Employees WHERE Employee_ID = ?";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {
            stmt.setString(1, employeeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Employee(
                        rs.getString("Employee_ID"),
                        rs.getString("First_name"),
                        rs.getString("Last_name"),
                        rs.getDouble("Salary"),
                        rs.getString("Phone"),
                        rs.getString("Gender"),
                        rs.getString("emp_Role"),
                        rs.getString("Address"),
                        rs.getDate("Hire_date"),
                        rs.getBoolean("Status"),
                        rs.getString("Password")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Method to check if an employee ID already exists
    public boolean employeeIDExists(String employeeID) {
        String query = "SELECT COUNT(*) FROM Employees WHERE Employee_ID = ?";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, employeeID);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Method to insert a new employee
    public void insertEmployee(Employee employee) {
        String query = "INSERT INTO Employees (Employee_ID, First_name, Last_name, Salary, Phone, Gender, emp_Role, Address, Hire_date, Status, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, employee.getEmployeeID());
            stmt.setString(2, employee.getFirstName());
            stmt.setString(3, employee.getLastName());
            stmt.setDouble(4, employee.getSalary());
            stmt.setString(5, employee.getPhone());
            stmt.setString(6, employee.getGender());
            stmt.setString(7, employee.getRole());
            stmt.setString(8, employee.getAddress());
            stmt.setDate(9, employee.getHireDate());
            stmt.setBoolean(10, employee.getStatus());
            stmt.setString(11, employee.getPassword());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to update an employee
    public void updateEmployee(Employee employee) {
        String query = "UPDATE Employees SET First_name = ?, Last_name = ?, Salary = ?, Phone = ?, Address = ?, Hire_date = ?, Status = ?, Password = ? WHERE Employee_ID = ?";

        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, employee.getFirstName());
            stmt.setString(2, employee.getLastName());
            stmt.setDouble(3, employee.getSalary());
            stmt.setString(4, employee.getPhone());
            stmt.setString(5, employee.getAddress());
            stmt.setDate(6, employee.getHireDate());
            stmt.setBoolean(7, employee.getStatus());
            stmt.setString(8, employee.getPassword());
            stmt.setString(9, employee.getEmployeeID());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Method to delete an employee
    public void deleteEmployee(String employeeID) {
        String query = "DELETE FROM Employees WHERE Employee_ID = ?";

        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query)) {

            stmt.setString(1, employeeID);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
