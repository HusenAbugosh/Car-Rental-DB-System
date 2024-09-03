package DAO;
import entities.*;
import entities.Connector;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    public ArrayList<Payment> getData() throws SQLException, ClassNotFoundException {
        ArrayList<Payment> data = new ArrayList<>();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String SQL = "SELECT Payment_ID, Contract_ID, Date, Amount, Method FROM Payments";
            stmt = Connector.getCon().createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                int Payment_ID = rs.getInt("Payment_ID");
                int Contract_ID = rs.getInt("Contract_ID");
                String dateString = rs.getString("Date");
                double Amount = rs.getDouble("Amount");
                String Method = rs.getString("Method");

                LocalDate date = LocalDate.parse(dateString);

                Payment payment = new Payment(Payment_ID, Contract_ID, date, Amount, Method);
                System.out.println("from database Payment ID=" + Payment_ID + ", Contract ID=" + Contract_ID + ", date" + dateString +
                        ", Amount=" + Amount + ", Method=" + Method );
                data.add(payment);
            }
        } finally {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            Connector.getCon().close();
        }
        return data;
    }
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void updateMethod(int Payment_ID, String method) {

        try {
            System.out.println("update  payments set method = '" + method + "' where Payment_ID = " + Payment_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  payments set method = '" + method + "' where Payment_ID = " + Payment_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateAmount(int Payment_ID, Double Amount) {

        try {
            System.out.println("update  payments set Amount = '" + Amount + "' where Payment_ID = " + Payment_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  payments set Amount = '" + Amount + "' where Payment_ID = " + Payment_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public void updateDate(int Payment_ID, LocalDate Date) {

        try {
            System.out.println("update  payments set Date = '" + Date + "' where Payment_ID = " + Payment_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  payments set Date = '" + Date + "' where Payment_ID = " + Payment_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }
    public static boolean isAfterOpening (LocalDate date){
        LocalDate opening = LocalDate.of(2022,1,1);
        return !date.isBefore(opening);
    }
    public List<Payment> searchPayemnts(String field, String searchKey) {
        List<Payment> payments = new ArrayList<>();
        String query = "SELECT * FROM Payments WHERE " + field + " LIKE ?";

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                preparedStatement.setString(1, "%" + searchKey + "%");
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    Payment payment = new Payment(
                            resultSet.getInt("Payment_ID"),
                            resultSet.getInt("Contract_ID"),
                            resultSet.getDate("Date").toLocalDate(),
                            resultSet.getDouble("Amount"),
                            resultSet.getString("Method")
                    );
                    payments.add(payment);
                }
            } finally {
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;
    }


    public static List<Payment> sumOfPayments ()  throws SQLException {

        String query = "select YEAR(Date) as Payment_year , SUM(Amount) as Total " +
                "from Payments " +
                "group by Payment_year";

        System.out.println(query);
        List<Payment> payments = new ArrayList<>();

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Payment payment = new Payment(
                            resultSet.getInt("Payment_year"),
                            resultSet.getDouble("Total")
                    );

                    payments.add(payment);
                }

                } finally{
                    Connector.getCon().close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return payments;


        }


    public static List<Payment> maxPayment ()  throws SQLException {

        String query = "select Payment_ID, Amount " +
                "from Payments " +
                "where Amount = (select max(p1.Amount) from Payments P1);";

        System.out.println(query);
        List<Payment> payments = new ArrayList<>();

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Payment payment = new Payment(
                            resultSet.getDouble("Amount"),
                            resultSet.getInt("Payment_ID")

                    );

                    payments.add(payment);
                }

            } finally{
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;


    }


    public int insertPayment(Payment payment) {
        String query = "INSERT INTO Payments (Contract_ID, Date, Amount, Method) VALUES (?, ?, ?, ?)";
        int generatedId = -1;

        try (Connection con = Connector.getCon();
             PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, payment.getContractID());
            preparedStatement.setDate(2, java.sql.Date.valueOf(payment.getDate()));
            preparedStatement.setDouble(3, payment.getAmount());
            preparedStatement.setString(4, payment.getMethod());

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        generatedId = generatedKeys.getInt(1);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Connector.showAlert("Error", "Failed to insert payment. " + e.getMessage());
        }

        return generatedId;
    }


    public static List<Payment> minPayment ()  throws SQLException {

        String query = "select Payment_ID, Amount " +
                "from Payments " +
                "where Amount = (select min(p1.Amount) from Payments P1);";

        System.out.println(query);
        List<Payment> payments = new ArrayList<>();

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Payment payment = new Payment(
                            resultSet.getDouble("Amount"),
                            resultSet.getInt("Payment_ID")

                    );

                    payments.add(payment);
                }

            } finally{
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;


    }


    public static List<Payment> avgPayment ()  throws SQLException {

        String query = "select YEAR(Date) as P_year , ROUND(AVG(Amount),2) as Average " +
                "from Payments " +
                "group by P_year;";

        System.out.println(query);
        List<Payment> payments = new ArrayList<>();

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Payment payment = new Payment(
                            resultSet.getInt("P_year"),
                            resultSet.getDouble("Average")

                    );

                    payments.add(payment);
                }

            } finally{
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;


    }



    public static List<Payment> methodfreq ()  throws SQLException {

        String query = "select count(method) as method_frequency , method " +
                "from Payments " +
                "group by method;";

        System.out.println(query);
        List<Payment> payments = new ArrayList<>();

        try {
            Connector.connectDB();
            try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {

                    Payment payment = new Payment(
                            resultSet.getInt("method_frequency"),
                            resultSet.getString("method")

                    );

                    payments.add(payment);
                }

            } finally{
                Connector.getCon().close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return payments;


    }
    }