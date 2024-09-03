package DAO;
import entities.Connector;
import entities.Vehicle;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public ArrayList<Vehicle>  getData() throws SQLException, ClassNotFoundException {
        ArrayList<Vehicle> data = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String SQL = "SELECT \n" +
                    "    Vehicle_ID,\n" +
                    "    Power,\n" +
                    "    Color,\n" +
                    "    Plate_ID,\n" +
                    "    Vehicles_Status,\n" +
                    "    Model,\n" +
                    "    Year_of_manufacture,\n" +
                    "    Number_of_passengers,\n" +
                    "    Traffic_department_fees,\n" +
                    "    Daily_rent,\n" +
                    "    Weekly_rent,\n" +
                    "    Monthly_rent,\n" +
                    "    Insurance_payment\n" +
                    "FROM \n" +
                    "    Vehicles;";
            stmt = Connector.getCon().createStatement();
            rs = stmt.executeQuery(SQL);


            while (rs.next()) {
                int Vehicle_ID = rs.getInt("Vehicle_ID");
                int Power = rs.getInt("Power");
                String Color = rs.getString("Color");
                String Plate_ID = rs.getString("Plate_ID");
                String Vehicles_Status = rs.getString("Vehicles_Status");
                String model = rs.getString("Model");
                int year = rs.getInt("Year_of_manufacture");
                int Number_of_passengers = rs.getInt("Number_of_passengers");
                double Traffic_department_fees=rs.getDouble("Traffic_department_fees");
                double  Weekly_rent=rs.getDouble("Weekly_rent");
                double Daily_rent = rs.getDouble("Daily_rent");
                double Monthly_rent = rs.getDouble("Monthly_rent");
                double Insurance_payment = rs.getDouble("Insurance_payment");


                Vehicle v = new Vehicle(Vehicle_ID,Power,Color,Plate_ID,Vehicles_Status,Number_of_passengers,model,year,Traffic_department_fees,Daily_rent,Weekly_rent,Monthly_rent,Insurance_payment);
                if(!v.getStatus().equals("Unavailable"))
                    data.add(v);

                System.out.println("From database: Vehicle ID=" + Vehicle_ID + ", Power=" + Power + ", Color=" + Color +
                        ", Plate ID=" + Plate_ID + ", Status=" + Vehicles_Status + ", Model=" + model +
                        ", Year of Manufacture=" + year + ", Passengers=" + Number_of_passengers +
                        ", Traffic Fees=" + Traffic_department_fees + ", Daily Rent=" + Daily_rent +
                        ", Weekly Rent=" + Weekly_rent + ", Monthly Rent=" + Monthly_rent +
                        ", Insurance Payment=" + Insurance_payment);
            }

        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Connector.getCon().close();


                System.out.println("Connection closed. Total Vehicle reocrds loaded: " + data.size());

            } catch (SQLException e) {
                System.out.println("Failed to close database resources.");
            }
            return data;
        }
    }
    public boolean insertVehicle(Vehicle vehicle) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String sql = "INSERT INTO Vehicles (Power, Color, Plate_ID, Vehicles_Status, Model, Year_of_manufacture, Number_of_passengers, Traffic_department_fees, Daily_rent, Weekly_rent, Monthly_rent, Insurance_payment) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = Connector.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, vehicle.getPower());
            pstmt.setString(2, vehicle.getColor());
            pstmt.setString(3, vehicle.getPlateID());
            pstmt.setString(4, vehicle.getStatus());
            pstmt.setString(5, vehicle.getModel());
            pstmt.setInt(6, vehicle.getYear());
            pstmt.setInt(7, vehicle.getNumberOfPassengers());
            pstmt.setDouble(8, vehicle.getTrafficDepartmentFees());
            pstmt.setDouble(9, vehicle.getDailyRent());
            pstmt.setDouble(10, vehicle.getWeeklyRent());
            pstmt.setDouble(11, vehicle.getMonthlyRent());
            pstmt.setDouble(12, vehicle.getInsurancePayment());

            pstmt.executeUpdate();
            rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                int vehicleId = rs.getInt(1);
                vehicle.setVehicleID(vehicleId); // Assuming you have a setter for VehicleID in your Vehicle class
                System.out.println("Generated VehicleID: " + vehicleId);
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
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Failed to close result set");
                }
            }
        }
    }
    public void updatePower(int Vehicle_ID , int power) {

        try {
            System.out.println("update  Vehicles set power = '" + power + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set power = '" + power + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateColor(int Vehicle_ID , String Color) {

        try {
            System.out.println("update  Vehicles set Color = '" + Color + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Color = '" + Color + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updatePlate_ID(int Vehicle_ID ,  String Plate_ID) {

        try {
            System.out.println("update  Vehicles set Plate_ID = '" + Plate_ID + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Plate_ID = '" + Plate_ID + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateVehicles_Status(int Vehicle_ID ,  String Vehicles_Status) {

        try {
            System.out.println("update  Vehicles set Vehicles_Status = '" + Vehicles_Status + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Vehicles_Status = '" + Vehicles_Status + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateModel(int Vehicle_ID ,  String Model) {

        try {
            System.out.println("update  Vehicles set Model = '" + Model + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Model = '" + Model + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateYear_of_manufacture(int Vehicle_ID ,  int Year_of_manufacture) {

        try {
            System.out.println("update  Vehicles set Year_of_manufacture = '" + Year_of_manufacture + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Year_of_manufacture = '" + Year_of_manufacture + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateNumber_of_passengers(int Vehicle_ID ,  int Number_of_passengers) {

        try {
            System.out.println("update  Vehicles set Number_of_passengers = '" + Number_of_passengers + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Number_of_passengers = '" + Number_of_passengers + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateTraffic_department_fees(int Vehicle_ID ,  double Traffic_department_fees) {

        try {
            System.out.println("update  Vehicles set Traffic_department_fees = '" + Traffic_department_fees + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Traffic_department_fees = '" + Traffic_department_fees + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateDaily_rent(int Vehicle_ID ,  double Daily_rent) {

        try {
            System.out.println("update  Vehicles set Daily_rent = '" + Daily_rent + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Daily_rent = '" + Daily_rent + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateWeekly_rent(int Vehicle_ID ,  double Weekly_rent) {

        try {
            System.out.println("update  Vehicles set Weekly_rent = '" + Weekly_rent + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Weekly_rent = '" + Weekly_rent + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateMonthly_rent(int Vehicle_ID ,  double Monthly_rent) {

        try {
            System.out.println("update  Vehicles set Monthly_rent = '" + Monthly_rent + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Monthly_rent = '" + Monthly_rent + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateInsurance_payment(int Vehicle_ID ,  double Insurance_payment) {

        try {
            System.out.println("update  Vehicles set Insurance_payment = '" + Insurance_payment + "' where Vehicle_ID = " + Vehicle_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Vehicles set Insurance_payment = '" + Insurance_payment + "' where Vehicle_ID = " + Vehicle_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");
        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public List<Vehicle> searchVehicles(String field, String searchKey) {
        List<Vehicle> VS = new ArrayList<>();
        String query = "SELECT * FROM Vehicles WHERE " + field + " LIKE ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchKey + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Vehicle v = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("power"),
                            resultSet.getString("color"),
                            resultSet.getString("plate_ID"),
                            resultSet.getString("Vehicles_Status"),
                            resultSet.getInt("Number_of_passengers"),
                            resultSet.getString("model"),
                            resultSet.getInt("Year_of_manufacture"),
                            resultSet.getDouble("Traffic_department_fees"),
                            resultSet.getDouble("Daily_rent"),
                            resultSet.getDouble("Weekly_rent"),
                            resultSet.getDouble("monthly_Rent"),
                            resultSet.getDouble("Insurance_payment")
                    );
                    VS.add(v);
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return VS;
    }

    public Vehicle getMostExpensiveCar() {
        Vehicle vehicle = null;
        String query = "SELECT * FROM Vehicles ORDER BY Daily_rent DESC LIMIT 1";
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    vehicle = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Power"),
                            resultSet.getString("Color"),
                            resultSet.getString("Plate_ID"),
                            resultSet.getString("Vehicles_Status"),
                            resultSet.getInt("Number_of_passengers")   ,
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
        return vehicle;
    }
    public Vehicle returnCar(int vid) {
        Vehicle vehicle = null;
        String query = "SELECT * FROM Vehicles where Vehicle_ID = ?";
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setInt(1,vid);
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    vehicle = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Power"),
                            resultSet.getString("Color"),
                            resultSet.getString("Plate_ID"),
                            resultSet.getString("Vehicles_Status"),
                            resultSet.getInt("Number_of_passengers")   ,
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
        return vehicle;
    }

    public Vehicle getLeastExpensiveCar() {
        Vehicle vehicle = null;
        String query = "SELECT * FROM Vehicles ORDER BY Daily_rent asc LIMIT 1";
        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    vehicle = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getInt("Power"),
                            resultSet.getString("Color"),
                            resultSet.getString("Plate_ID"),
                            resultSet.getString("Vehicles_Status"),
                            resultSet.getInt("Number_of_passengers")   ,
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
        return vehicle;
    }
    public boolean checkContractConflict(int vehicleId, LocalDate StartDate, LocalDate EndDate) {
        String query = "SELECT * FROM Contract WHERE Vehicle_ID = ? AND (" +
                "(Start_date <= ? AND End_date >= ?) OR " +
                "(Start_date <= ? AND End_date >= ?) OR " +
                "(Start_date >= ? AND End_date <= ?))";


        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setInt(1, vehicleId);
                preparedStatement.setDate(2, Date.valueOf(EndDate));
                preparedStatement.setDate(3,  Date.valueOf(StartDate));
                preparedStatement.setDate(4,Date.valueOf(EndDate));
                preparedStatement.setDate(5, Date.valueOf(StartDate));
                preparedStatement.setDate(6, Date.valueOf(StartDate));
                preparedStatement.setDate(7,Date.valueOf(EndDate));
                System.out.println(preparedStatement);

                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    return true;
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public Vehicle getMostRentedCar() {
        Vehicle vehicle = null;
        String query = "SELECT v.Vehicle_ID ,v.Color, " +
                "v.Year_of_manufacture, v.Model, v.number_of_passengers, " +
                "v.Daily_rent, v.Weekly_rent, v.Monthly_rent, COUNT(c.Contract_ID) AS RentCount " +
                "FROM Vehicles v " +
                "JOIN Contract c ON v.Vehicle_ID = c.Vehicle_ID " +
                "GROUP BY v.Vehicle_ID, v.Color, " +
                "v.Year_of_manufacture, v.Model, " +
                "v.number_of_passengers, v.Daily_rent, v.Weekly_rent, v.Monthly_rent " +
                "ORDER BY RentCount DESC " +
                "LIMIT 1";

        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    vehicle = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getString("Color"),
                            resultSet.getString("Model"),
                            resultSet.getInt("Year_of_manufacture"),
                            resultSet.getDouble("Daily_rent"),
                            resultSet.getDouble("Weekly_rent"),
                            resultSet.getDouble("Monthly_rent"),
                            resultSet.getInt("Number_of_passengers")
                    );
                    vehicle.setNumberOfPassengers(resultSet.getInt("RentCount"));
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
    public Vehicle getLeastRentedCar() {
        Vehicle vehicle = null;
        String query =  "SELECT v.Vehicle_ID ,v.Color, " +
                "v.Year_of_manufacture, v.Model, v.number_of_passengers, " +
                "v.Daily_rent, v.Weekly_rent, v.Monthly_rent, COUNT(c.Contract_ID) AS RentCount " +
                "FROM Vehicles v " +
                "JOIN Contract c ON v.Vehicle_ID = c.Vehicle_ID " +
                "GROUP BY v.Vehicle_ID, v.Color, " +
                "v.Year_of_manufacture, v.Model, " +
                "v.number_of_passengers, v.Daily_rent, v.Weekly_rent, v.Monthly_rent " +
                "ORDER BY RentCount asc " +
                "LIMIT 1";

        System.out.println(query);

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    vehicle = new Vehicle(
                            resultSet.getInt("Vehicle_ID"),
                            resultSet.getString("Color"),
                            resultSet.getString("Model"),
                            resultSet.getInt("Year_of_manufacture"),
                            resultSet.getDouble("Daily_rent"),
                            resultSet.getDouble("Weekly_rent"),
                            resultSet.getDouble("Monthly_rent"),
                            resultSet.getInt("Number_of_passengers")

                    );
                    vehicle.setNumberOfPassengers(resultSet.getInt("RentCount"));
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicle;
    }
    public double returnMonthlyRent(int vid) {
        String query = "SELECT Monthly_rent FROM Vehicles WHERE Vehicle_ID = ?";
        System.out.println(query);
        double rent = 0;

        Connector.connectDB();
        Connection connection = Connector.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, vid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rent = resultSet.getDouble("Monthly_rent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rent;
    }
    public double returnDailyRent(int vid) {
        String query = "SELECT Daily_rent FROM Vehicles WHERE Vehicle_ID = ?";
        System.out.println(query);
        double rent = 0;

        Connector.connectDB();
        Connection connection = Connector.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, vid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rent = resultSet.getDouble("Daily_rent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rent;
    }
    public double returnweeklyRent(int vid) {
        String query = "SELECT Weekly_rent FROM Vehicles WHERE Vehicle_ID = ?";
        System.out.println(query);
        double rent = 0;

        Connector.connectDB();
        Connection connection = Connector.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, vid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rent = resultSet.getDouble("Weekly_rent");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rent;
    }
    public double returnweeklyInsurancePayment(int vid) {
        String query = "SELECT Insurance_payment FROM Vehicles WHERE Vehicle_ID = ?";
        System.out.println(query);
        double rent = 0;

        Connector.connectDB();
        Connection connection = Connector.getCon();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, vid);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                rent = resultSet.getDouble("Insurance_payment");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return rent;
    }


}
