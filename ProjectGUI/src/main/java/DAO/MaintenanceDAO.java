package DAO;

import entities.Connector;
import entities.Maintenance;
import entities.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceDAO {
    public ArrayList<Maintenance> getData() throws SQLException, ClassNotFoundException {
        ArrayList<Maintenance> data = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String SQL = "SELECT Receipt_ID, Vehicle_ID, Employee_ID, Cost, Description,  Company_Email, Date FROM Maintenance";
            stmt = Connector.getCon().createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int Receipt_ID = rs.getInt("Receipt_ID");
                int Vehicle_ID = rs.getInt("Vehicle_ID");
                int Employee_ID = rs.getInt("Employee_ID");
                double Cost = rs.getDouble("Cost");
                String Description = rs.getString("Description");
                String Company_Email = rs.getString("Company_Email");
                String dateString = rs.getString("Date");

                // SimpleDateFormat simple = new SimpleDateFormat("yyyy-MM-dd");

                LocalDate date = LocalDate.parse(dateString);


                Maintenance maintenance = new Maintenance(Receipt_ID, Vehicle_ID, Employee_ID, Cost, Description, Company_Email, date);
                data.add(maintenance);

                System.out.println("from database Receipt ID=" + Receipt_ID + ", Vehicle ID=" + Vehicle_ID + ", Employee ID=" + Employee_ID +
                        ", Cost=" + Cost + ", Description=" + Description + ", Company Email=" + Company_Email + ", Date=" + date);
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Connector.getCon().close();


                System.out.println("Connection closed. Total Maintenance reocrds loaded: " + data.size());
                System.out.println("Data " + data);

            } catch (SQLException e) {
                System.out.println("Failed to close database resources.");
            }
            return data;
        }
    }

    public void deleteRow(Maintenance row) throws Exception {
        System.out.println("delete from  Maintenance where Receipt_ID=" + row.getReceiptID() + ";");
        Connector.connectDB();

        Connector.ExecuteStatement("delete from  Maintenance where Receipt_ID=" + row.getReceiptID() + ";");
        Connector.getCon().close();
        System.out.println("Connection closed");
    }

    public void updateCompanyEmail(int receiptId, String companyEmail) {

        try {
            System.out.println("update  Maintenance set Company_Email = '" + companyEmail + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set Company_Email = '" + companyEmail + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateMaintenanceDate(int receiptId, LocalDate date) {

        try {
            System.out.println("update  Maintenance set Date = '" + date + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set Date = '" + date + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateDescription(int receiptId, String Description) {

        try {
            System.out.println("update  Maintenance set Description = '" + Description + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set Description = '" + Description + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateCost(int receiptId, double cost) {

        try {
            System.out.println("update  Maintenance set cost = '" + cost + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set cost = '" + cost + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateEmployeeID(int receiptId, int EmployeeID) {

        try {
            System.out.println("update  Maintenance set Employee_ID = '" + EmployeeID + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set Employee_ID = '" + EmployeeID + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateVehicleID(int receiptId, int Vehicle_ID) {

        try {
            System.out.println("update  Maintenance set Vehicle_ID = '" + Vehicle_ID + "' where Receipt_ID = " + receiptId);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Maintenance set Vehicle_ID = '" + Vehicle_ID + "' where Receipt_ID = " + receiptId + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public boolean insertMaintenance( Maintenance M) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String sql = "INSERT INTO Maintenance (Vehicle_ID,Employee_ID,Cost,Description,Company_Email,Date) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = Connector.getCon().prepareStatement(sql);
            pstmt = Connector.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, M.getVehicleID());
            pstmt.setInt(2, M.getEmployeeID());
            pstmt.setDouble(3, M.getCost());
            pstmt.setString(4, M.getDescription());
            pstmt.setString(5, M.getCompanyEmail());
            java.sql.Date sqldate= java.sql.Date.valueOf(M.getDate());
            pstmt.setDate(6, sqldate);
            pstmt.executeUpdate();
            System.out.println(pstmt.toString());
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int receiptId = rs.getInt(1);
                System.out.println("Generated ReceiptID: " + receiptId);
                M.setReceiptID(receiptId);
            }
            Connector.getCon().close();


            return true;
        } catch (Exception e) {
            Connector.showAlert("Error", e.getMessage());
            return false;
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close statement");
                }
            }
        }
    }
    public boolean doesEmpExist(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select first_name from employees where employee_id =" + id + ";");
        Connector.connectDB();
        String SQL = "select first_name from employees where employee_id = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }
        return true;


    }

    public boolean doesCarExist(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select model from Vehicles where Vehicle_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select model from Vehicles where Vehicle_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }
        return true;


    }
    public List<Maintenance> searchMaintenace(String field, String searchKey) {
        List<Maintenance> maintenances = new ArrayList<>();
        String query = "SELECT * FROM maintenance WHERE " + field + " LIKE ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchKey + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Maintenance m = new Maintenance(
                            resultSet.getInt("Receipt_ID"),
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Employee_ID"),
                            resultSet.getDouble("Cost"),
                            resultSet.getString("Description"),
                            resultSet.getString("Company_Email"),
                            resultSet.getDate("Date").toLocalDate()
                    );
                    maintenances.add(m);
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maintenances;
    }
    public   Double TotalRepairsCostLastMonth() {
        LocalDate Current=LocalDate.now();
        LocalDate lastMonth=Current.minusMonths(1);
        String query = "SELECT SUM(Cost) AS TotalLastMonth\n" +
                "FROM Maintenance\n" +
                "WHERE Date >= ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setDate(1, Date.valueOf(lastMonth));
                System.out.println(preparedStatement);


                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getDouble("TotalLastMonth");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public  Double TotalRepairsCostLastYear()  {
        LocalDate Current=LocalDate.now();
        LocalDate lastYear=Current.minusYears(1);
        String query = "SELECT SUM(Cost) AS TotalLastYear\n" +
                "FROM Maintenance\n" +
                "WHERE Date >= ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setDate(1, Date.valueOf(lastYear));
                System.out.println(preparedStatement);


                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getDouble("TotalLastYear");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public  int TotalRepairsLastMonth() {
        LocalDate Current=LocalDate.now();
        LocalDate lastMonth=Current.minusMonths(1);
        String query = "SELECT COUNT(Receipt_ID) AS TotalLastMonth\n" +
                "FROM Maintenance\n" +
                "WHERE Date >= ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {

                preparedStatement.setDate(1, Date.valueOf(lastMonth));
                System.out.println(preparedStatement);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt("TotalLastMonth");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  int TotalRepairsLastYear()  {
        LocalDate Current=LocalDate.now();
        LocalDate lastYear=Current.minusYears(1);
        String query = "SELECT COUNT(*) AS TotalLastYear " +
                "FROM Maintenance " +
                "WHERE Date >= ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setDate(1, Date.valueOf(lastYear));
                System.out.println(preparedStatement);


                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt("TotalLastYear");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  Double TotalRepairsCostAllTime()  {

        String query = "SELECT SUM(Cost) AS Total\n" +
                "FROM Maintenance\n";
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getDouble("Total");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public  int TotalRepairsAllTime()  {

        String query = "SELECT COUNT(Receipt_ID) AS Total\n" +
                "FROM Maintenance\n";
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getInt("Total");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  String CompanyWithMostRepairs()  {

        String query = "SELECT Company_Email, COUNT(*) AS CompanyCount " +
                "FROM Maintenance " +
                "GROUP BY Company_Email " +
                "ORDER BY CompanyCount DESC " +
                "LIMIT 1";;
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return resultSet.getString("Company_Email");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  Double CompanyRepairsCost(String company)  {

        String query = "SELECT SUM(Cost) AS TotalCost " +
                "FROM Maintenance " +
                "WHERE Company_Email = ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setString(1,company);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);

                if (resultSet.next()) {
                    return resultSet.getDouble("TotalCost");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }
    public  int CompanyNumberOFRepairs(String company)  {

        String query = "SELECT COUNT(Receipt_ID) AS repairCount " +
                "FROM Maintenance " +
                "WHERE Company_Email = ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setString(1,company);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);

                if (resultSet.next()) {
                    return resultSet.getInt("repairCount");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  int mostRepairedCar ()  {

        String query = "SELECT Vehicle_ID " +
                "FROM Maintenance " +
                "GROUP BY Vehicle_ID " +
                "ORDER BY COUNT(*) DESC " +
                "LIMIT 1";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);

                if (resultSet.next()) {
                    return resultSet.getInt("Vehicle_ID");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public  Vehicle selectAcar (int vehicleId)  {

        String query = "SELECT * FROM Vehicles WHERE Vehicle_ID = ?";


        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setInt(1, vehicleId);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);

                if (resultSet.next()) {
                    return new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Power"),
                            resultSet.getString("Color"),
                            resultSet.getString("Plate_ID"),
                            resultSet.getString("Vehicles_Status"),
                            resultSet.getInt("Number_of_passengers"),
                            resultSet.getString("Model"),
                            resultSet.getInt("Year_of_manufacture"),
                            resultSet.getDouble("Traffic_department_fees"),
                            resultSet.getDouble("Daily_rent"),
                            resultSet.getDouble("Weekly_rent"),
                            resultSet.getDouble("Monthly_rent"),
                            resultSet.getDouble("Insurance_payment")
                    );
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public  double mostRepairedCarBill (int Vehicle_ID)  {

        String query = "SELECT SUM(Cost) AS TotalCost FROM Maintenance WHERE Vehicle_ID = ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setInt(1,Vehicle_ID);
                ResultSet resultSet = preparedStatement.executeQuery();
                System.out.println(preparedStatement);

                if (resultSet.next()) {
                    return resultSet.getInt("TotalCost");
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0.0;
    }

}

