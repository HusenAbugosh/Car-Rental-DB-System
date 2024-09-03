package DAO;

import entities.Contract;
import entities.Connector;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContractDAO {

    public ContractDAO() {
        Connector.connectDB();
    }

    public List<Contract> getAllContracts() {
        List<Contract> contracts = new ArrayList<>();
        String query = "SELECT c.Contract_ID, c.Start_date, c.End_date, c.Vehicle_ID, " +
                "cu.Customer_ID, cu.First_name AS Customer_FirstName, cu.Last_name AS Customer_LastName, " +
                "e.Employee_ID, e.First_name AS Employee_FirstName, e.Last_name AS Employee_LastName, " +
                "c.Cost, c.Contract_Status, c.contract_type " +
                "FROM Contract c " +
                "JOIN Customers cu ON c.Customer_ID = cu.Customer_ID " +
                "JOIN Employees e ON c.Employee_ID = e.Employee_ID";
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Contract contract = new Contract(
                        resultSet.getInt("Contract_ID"),
                        resultSet.getString("Start_date"),
                        resultSet.getString("End_date"),
                        resultSet.getInt("Vehicle_ID"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getString("Customer_FirstName") + " " + resultSet.getString("Customer_LastName"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("Employee_FirstName") + " " + resultSet.getString("Employee_LastName"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Contract_Status"),
                        resultSet.getString("contract_type") // Get contract type
                );
                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to retrieve contracts.");
        }

        return contracts;
    }

    public void insertContract(Contract contract) {
        String query = "INSERT INTO Contract (Start_date, End_date, Vehicle_ID, Customer_ID, Employee_ID, Cost, Contract_Status, contract_type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setInt(3, contract.getVehicleID());
            preparedStatement.setInt(4, contract.getCustomerID());
            preparedStatement.setInt(5, contract.getEmployeeID());
            preparedStatement.setDouble(6, contract.getCost());
            preparedStatement.setString(7, contract.getContractStatus());
            preparedStatement.setString(8, contract.getContractType());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        contract.setContractID(generatedKeys.getInt(1));
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to insert contract. Error: " + e.getMessage());
        }
    }


    public void updateContract(Contract contract) {
        String query = "UPDATE Contract SET Start_date = ?, End_date = ?, Vehicle_ID = ?, Customer_ID = ?, Employee_ID = ?, Cost = ?, Contract_Status = ?, contract_type = ? WHERE Contract_ID = ?";
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, contract.getStartDate());
            preparedStatement.setString(2, contract.getEndDate());
            preparedStatement.setInt(3, contract.getVehicleID());
            preparedStatement.setInt(4, contract.getCustomerID()); // Use ID for update
            preparedStatement.setInt(5, contract.getEmployeeID()); // Use ID for update
            preparedStatement.setDouble(6, contract.getCost());
            preparedStatement.setString(7, contract.getContractStatus());
            preparedStatement.setString(8, contract.getContractType()); // Set contract type
            preparedStatement.setInt(9, contract.getContractID());

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to update contract.");
        }
    }

    public void deleteContract(int contractID) {
        String query = "DELETE FROM Contract WHERE Contract_ID = ?";
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setInt(1, contractID);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to delete contract.");
        }
    }

    public List<Contract> searchContracts(String field, String value) {
        List<Contract> contracts = new ArrayList<>();
        String column = "";
        boolean isDateField = false;

        switch (field) {
            case "Contract ID":
                column = "c.Contract_ID";
                break;
            case "Vehicle ID":
                column = "c.Vehicle_ID";
                break;
            case "Customer Name":
                column = "CONCAT(cu.First_name, ' ', cu.Last_name)";
                break;
            case "Employee Name":
                column = "CONCAT(e.First_name, ' ', e.Last_name)";
                break;
            case "Cost":
                column = "c.Cost";
                break;
            case "Status":
                column = "c.Contract_Status";
                break;
            case "Contract Type":
                column = "c.contract_type";
                break;
            case "Start Date":
                column = "c.Start_date";
                isDateField = true;
                break;
            case "End Date":
                column = "c.End_date";
                isDateField = true;
                break;
            default:
                Connector.showAlert("Search Error", "Invalid search field.");
                return contracts;
        }

        String query = "SELECT c.Contract_ID, c.Start_date, c.End_date, c.Vehicle_ID, " +
                "cu.Customer_ID, cu.First_name AS Customer_FirstName, cu.Last_name AS Customer_LastName, " +
                "e.Employee_ID, e.First_name AS Employee_FirstName, e.Last_name AS Employee_LastName, " +
                "c.Cost, c.Contract_Status, c.contract_type " +
                "FROM Contract c " +
                "JOIN Customers cu ON c.Customer_ID = cu.Customer_ID " +
                "JOIN Employees e ON c.Employee_ID = e.Employee_ID " +
                "WHERE " + column + (isDateField ? " = ?" : " LIKE ?");
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            if (isDateField) {
                preparedStatement.setDate(1, Date.valueOf(value));
            } else {
                preparedStatement.setString(1, "%" + value + "%");
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Contract contract = new Contract(
                            resultSet.getInt("Contract_ID"),
                            resultSet.getString("Start_date"),
                            resultSet.getString("End_date"),
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Customer_ID"),
                            resultSet.getString("Customer_FirstName") + " " + resultSet.getString("Customer_LastName"),
                            resultSet.getInt("Employee_ID"),
                            resultSet.getString("Employee_FirstName") + " " + resultSet.getString("Employee_LastName"),
                            resultSet.getDouble("Cost"),
                            resultSet.getString("Contract_Status"),
                            resultSet.getString("contract_type") // Get contract type
                    );
                    contracts.add(contract);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to search contracts.");
        }

        return contracts;
    }

    public List<Contract> getTop3ContractsByCost() {
        List<Contract> contracts = new ArrayList<>();
        String query = "SELECT c.Contract_ID, c.Start_date, c.End_date, c.Vehicle_ID, " +
                "c.Customer_ID, cu.First_name AS Customer_FirstName, cu.Last_name AS Customer_LastName, " +
                "c.Employee_ID, e.First_name AS Employee_FirstName, e.Last_name AS Employee_LastName, " +
                "c.Cost, c.Contract_Status, c.contract_type " +
                "FROM Contract c " +
                "JOIN Customers cu ON c.Customer_ID = cu.Customer_ID " +
                "JOIN Employees e ON c.Employee_ID = e.Employee_ID " +
                "ORDER BY c.Cost DESC LIMIT 3";
        System.out.println("Executing query: " + query);

        try (Connection connection = Connector.getCon();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Contract contract = new Contract(
                        resultSet.getInt("Contract_ID"),
                        resultSet.getString("Start_date"),
                        resultSet.getString("End_date"),
                        resultSet.getInt("Vehicle_ID"),
                        resultSet.getInt("Customer_ID"),
                        resultSet.getString("Customer_FirstName") + " " + resultSet.getString("Customer_LastName"),
                        resultSet.getInt("Employee_ID"),
                        resultSet.getString("Employee_FirstName") + " " + resultSet.getString("Employee_LastName"),
                        resultSet.getDouble("Cost"),
                        resultSet.getString("Contract_Status"),
                        resultSet.getString("contract_type") // Get contract type
                );
                contracts.add(contract);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Database Error", "Failed to retrieve top contracts.");
        }

        return contracts;
    }
}
