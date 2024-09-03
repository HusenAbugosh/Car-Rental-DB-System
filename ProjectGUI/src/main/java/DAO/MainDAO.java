package DAO;

import entities.Connector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.LinkedHashMap;

import java.util.Map;


public class MainDAO {

    // Method to get the number of employees
    static public int getNumberOfEmployees() {
        String query = "SELECT COUNT(*) FROM Employees";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Method to get the number of rented cars
    static public int getNumberOfRentedCars() {
        String query = "SELECT COUNT(*) FROM Vehicles WHERE Vehicles_Status = 'Under Lease'";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }



    public static Map<String, Double> getContractCostForLastFourMonths() {
        String query = "SELECT DATE_FORMAT(Start_date, '%b %Y') AS month, SUM(Cost) AS total_cost " +
                "FROM Contract " +
                "WHERE Start_date >= DATE_SUB(CURDATE(), INTERVAL 4 MONTH) " +
                "AND Contract_Status != 'Cancelled' " +
                "GROUP BY month " +
                "ORDER BY MIN(Start_date)";
        Map<String, Double> contractCostByMonth = new LinkedHashMap<>();
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String month = rs.getString("month");
                double totalCost = rs.getDouble("total_cost");
                contractCostByMonth.put(month, totalCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contractCostByMonth;
    }




    // Method to get the maintenance cost for each month in the year
    public static Map<String, Double> getMaintenanceCostByMonth() {
        String query = "SELECT MONTHNAME(Date) AS month, SUM(Cost) AS total_cost, MONTH(Date) AS month_number " +
                "FROM Maintenance " +
                "WHERE YEAR(Date) = YEAR(CURDATE()) " +
                "GROUP BY MONTH(Date), MONTHNAME(Date) " +
                "ORDER BY month_number";

        Map<String, Double> maintenanceCostByMonth = new LinkedHashMap<>();
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                String month = rs.getString("month");
                double totalCost = rs.getDouble("total_cost");
                maintenanceCostByMonth.put(month, totalCost);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return maintenanceCostByMonth;
    }




    // Method to get the number of available cars
    static public int getNumberOfAvailableCars() {
        String query = "SELECT COUNT(*) FROM Vehicles WHERE Vehicles_Status = 'Available'";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Method to get the total monthly salaries
    static public double getTotalMonthlySalaries() {
        String query = "SELECT SUM(Salary) FROM Employees";
        try (Connection con = Connector.getCon();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getDouble(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
}
