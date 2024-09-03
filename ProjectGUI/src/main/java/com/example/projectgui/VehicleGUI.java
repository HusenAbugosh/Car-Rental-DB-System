package com.example.projectgui;

import entities.Connector;
import DAO.VehicleDAO;
import entities.Vehicle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class VehicleGUI extends Application {
    private Stage stage2;

    private ArrayList<Vehicle> data;
    private ObservableList<Vehicle> dataList;
    private VehicleDAO vehicleDAO;
    private static Vehicle forRent;

    public static void main(String[] args) {
        launch(args);
    }

    public Scene getVehicleScene(Stage primaryStage) {
        data = new ArrayList<>();
        forRent=new Vehicle();

        vehicleDAO = new VehicleDAO();

        try {
            data = vehicleDAO.getData();
            dataList = FXCollections.observableArrayList(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        Image CustomerICON = new Image(getClass().getResourceAsStream("/custICON.png"));
        Image EMPICON = new Image(getClass().getResourceAsStream("/emplICON.png"));
        Image contractICON = new Image(getClass().getResourceAsStream("/contractICON.png"));
        Image paymentICON = new Image(getClass().getResourceAsStream("/PaymentICON.png"));
        Image maintenanceICON = new Image(getClass().getResourceAsStream("/maintenanceICON.png"));
        Image carICON = new Image(getClass().getResourceAsStream("/carICON.png"));
        Image LOICON = new Image(getClass().getResourceAsStream("/exitICON.png"));
        Image DBICON = new Image(getClass().getResourceAsStream("/dashboardICON.png"));
        Image dealICON = new Image(getClass().getResourceAsStream("/hand-shake (3).png"));


        Label label = new Label();
        label.setStyle("-fx-background-color: #FDDE55");
        label.setPrefSize(10, 90);

        Button CustomersBtn = new Button(" Customers ", new ImageView(CustomerICON));
        Button ContractBtn = new Button(" Contract  ", new ImageView(contractICON));
        Button PaymentsBtn = new Button(" Payments", new ImageView(paymentICON));
        Button EmployeesBtn = new Button(" Employees", new ImageView(EMPICON));
        Button MaintenanceBtn = new Button(" Maintenance", new ImageView(maintenanceICON));
        Button VehiclesBtn = new Button(" Vehicles   ", new ImageView(carICON));
        Button DASHBOARD = new Button("DashBoard", new ImageView(DBICON));
        Button BackBtn = new Button("Back To Main Page");
        Button logOut = new Button(" Log Out  ", new ImageView(LOICON));
        Button dealBtn = new Button(" Make a Deal", new ImageView(dealICON));


        HBox current = new HBox();

        current.getChildren().addAll(label, VehiclesBtn);

        CustomersBtn.setPrefSize(320, 50);
        ContractBtn.setPrefSize(320, 50);
        PaymentsBtn.setPrefSize(320, 50);
        EmployeesBtn.setPrefSize(320, 50);
        MaintenanceBtn.setPrefSize(320, 50);
        VehiclesBtn.setPrefSize(320, 50);
        DASHBOARD.setPrefSize(320, 50);
        BackBtn.setPrefSize(550, 50);
        logOut.setPrefSize(320, 50);
        dealBtn.setPrefSize(320, 50);


        dealBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 26px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACk;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"

        ); // Font family


        CustomersBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACk;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"

        ); // Font family


        ContractBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        PaymentsBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        VehiclesBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        EmployeesBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        MaintenanceBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 28px; " + // Font size
                "-fx-font-family:Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        DASHBOARD.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        logOut.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        BackBtn.setStyle("-fx-background-color: #ED5506; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family


        Label space = new Label();
        space.setStyle("-fx-background-color: #3F2B63");
        space.setPrefSize(350, 10);


        Image logo = new Image("/LOGO3.PNG");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(320);
        logoView.setFitHeight(100);


        VBox Menu = new VBox();
        Menu.getChildren().addAll(logoView, space, DASHBOARD, CustomersBtn, EmployeesBtn, ContractBtn, PaymentsBtn, MaintenanceBtn, current, logOut);
        Menu.setSpacing(3);
        Menu.setPadding(new Insets(2));

        VBox sceneArea = new VBox();
        sceneArea.setStyle("-fx-background-color: #FFFFFF;");
        sceneArea.setSpacing(50);
        sceneArea.setPadding(new Insets(20, 20, 20, 20));
        // sceneArea.getChildren().addAll(BackBtn);


        sceneArea.setAlignment(Pos.TOP_CENTER);
        Pane pane = new Pane();
        Label t1 = new Label("First Name");
        MainPage MP = new MainPage();

        Screen Cscene = Screen.getPrimary();
        Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
       // primaryStage.setX(bounds.getMinX());
       // primaryStage.setY(bounds.getMinY());
       // primaryStage.setWidth(bounds.getWidth());
       // primaryStage.setHeight(bounds.getHeight());
        GridPane GP1 = new GridPane();
        GP1.add(sceneArea, 1, 0);
        Button close = new Button("Close");

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        Stage stage = new Stage();
        //Scene scene = new Scene(GP1, bounds.getWidth(), bounds.getHeight());
        Scene scene = new Scene(GP1,1520, 820);

        column1.setPercentWidth(22);
        column2.setPercentWidth(78);
        GP1.getColumnConstraints().addAll(column1, column2);
        GP1.setBackground(new Background(new BackgroundFill(Color.web("#3F2B63"), null, null)));
        GP1.add(Menu, 0, 0);

        TextField serachBAR = new TextField();
        serachBAR.setPromptText("Search...");
        serachBAR.setPrefSize(300, 41.2);
        serachBAR.setStyle("-fx-background-radius: 20 0 0 20;" + "-fx-background-color: #E2DDF8;" +
                "-fx-border-color: #3F2B63;" + "-fx-border-width: 2px;" + "-fx-border-radius: 20 0 0 20;");


        Image searchimg = new Image(getClass().getResourceAsStream("/searchICON.png"));

        Button searchbtn = new Button("", new ImageView(searchimg));
        searchbtn.setStyle("-fx-background-radius: 0 19 19 0;" + "-fx-background-color: #E2DDF8;" +
                "-fx-border-color: #3F2B63;" + "-fx-border-radius: 0 19 19 0;");
        searchbtn.setPrefSize(60, 40);

        ComboBox<String> comboBox = new ComboBox<>();

        // Add items to the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
                "Vehicle ID", "Plate ID", "Power", "Color", "Status", "Passengers", "Model", "Year", "Traffic Fees", "Daily Rent", "Weekly Rent", "Monthly Rent", "Insurance Payment"

        );
        comboBox.setItems(items);
        comboBox.setPrefSize(200, 40);
        comboBox.setPromptText("Specify the field..");
        comboBox.setStyle("-fx-background-color: #E2DDF8;" + "-fx-font-family:Comic Sans MS;" + "-fx-font-size: 15px");
        comboBox.setPadding(new Insets(0, 0, 0, 30));

        HBox search = new HBox();
        // search.setPrefSize(495,40);
        // search.setStyle("-fx-background-radius: 20 20 20 20 ;"+"-fx-background-color: #E2DDF8;");
        //  search.setPadding(new Insets(0,0,0,0));
        search.getChildren().addAll(serachBAR, searchbtn);
        search.setAlignment(Pos.CENTER);


        TableView<Vehicle> vehicleTable = new TableView<>();
        vehicleTable.setPrefSize(706, 600);
        vehicleTable.setPadding(new Insets(5));


        TableColumn<Vehicle, Integer> vehicleIDColumn = new TableColumn<>("Vehicle ID");
        vehicleIDColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));

        TableColumn<Vehicle, String> plateIDColumn = new TableColumn<>("Plate ID");
        plateIDColumn.setCellValueFactory(new PropertyValueFactory<>("plateID"));

        TableColumn<Vehicle, String> powerColumn = new TableColumn<>("Power");
        powerColumn.setCellValueFactory(new PropertyValueFactory<>("power"));

        TableColumn<Vehicle, String> colorColumn = new TableColumn<>("Color");
        colorColumn.setCellValueFactory(new PropertyValueFactory<>("color"));

        TableColumn<Vehicle, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));

        TableColumn<Vehicle, Integer> passengersColumn = new TableColumn<>("Passengers");
        passengersColumn.setCellValueFactory(new PropertyValueFactory<>("numberOfPassengers"));

        TableColumn<Vehicle, String> modelColumn = new TableColumn<>("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));

        TableColumn<Vehicle, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<Vehicle, Double> trafficFeesColumn = new TableColumn<>("Traffic Fees");
        trafficFeesColumn.setCellValueFactory(new PropertyValueFactory<>("trafficDepartmentFees"));

        TableColumn<Vehicle, Double> dailyRentColumn = new TableColumn<>("Daily Rent");
        dailyRentColumn.setCellValueFactory(new PropertyValueFactory<>("dailyRent"));

        TableColumn<Vehicle, Double> weeklyRentColumn = new TableColumn<>("Weekly Rent");
        weeklyRentColumn.setCellValueFactory(new PropertyValueFactory<>("weeklyRent"));

        TableColumn<Vehicle, Double> monthlyRentColumn = new TableColumn<>("Monthly Rent");
        monthlyRentColumn.setCellValueFactory(new PropertyValueFactory<>("monthlyRent"));

        TableColumn<Vehicle, Double> insurancePaymentColumn = new TableColumn<>("Insurance Payment");
        insurancePaymentColumn.setCellValueFactory(new PropertyValueFactory<>("insurancePayment"));

        // Add columns to TableView
        vehicleTable.getColumns().addAll(vehicleIDColumn, plateIDColumn, powerColumn, colorColumn, statusColumn,
                passengersColumn, modelColumn, yearColumn, trafficFeesColumn, dailyRentColumn, weeklyRentColumn,
                monthlyRentColumn, insurancePaymentColumn);


        vehicleTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView


        Label Clabel = new Label("Vehicles");
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setPrefSize(500, 70);
        Clabel.setStyle("-fx-font-family: Helvetica;" +
                "-fx-font-size: 50;"
                +
                "-fx-text-fill: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-background-color: TRANSPARENT;");

        Button Insert = new Button("Insert");
        Button Refresh = new Button("Refresh");
        Button Update = new Button("Update");
        Button stats = new Button("stats");
        Button Rent = new Button("Rent");


        Insert.setPrefSize(150, 40);
        Update.setPrefSize(150, 40);
        Refresh.setPrefSize(150, 40);
        stats.setPrefSize(150, 40);
        Rent.setPrefSize(150, 40);



        Insert.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 50;" +
                "-fx-background-radius:50;"); // Font family

        Refresh.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"); // Font family
        Rent.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"); // Font family


        stats.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"); // Font family

        Update.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Comic Sans MS;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;"); // Font family


        HBox buttons = new HBox();
        buttons.getChildren().addAll(Insert, Update, Refresh, stats,Rent);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));


        stats.setOnAction(e -> {
            Stage formStat = new Stage();
            formStat.setTitle("Vehicles Stats");
            formStat.setResizable(false);

            GridPane rootStat = new GridPane();
            rootStat.setPrefWidth(250);
            Scene scene1stat = new Scene(rootStat, 300, 750);
            formStat.setScene(scene1stat);
            rootStat.setPadding(new Insets(10));
            rootStat.setHgap(10);
            rootStat.setVgap(10);
            rootStat.setStyle("-fx-background-color:#E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2");

            Vehicle mostExpensiveCar = vehicleDAO.getMostExpensiveCar();
            Vehicle leastExpensiveCar = vehicleDAO.getLeastExpensiveCar();
            Vehicle mostRentedCar = vehicleDAO.getMostRentedCar();
            Vehicle leastRentedCar = vehicleDAO.getLeastRentedCar();

            VBox statsBox = new VBox();
            statsBox.setSpacing(10);
            statsBox.setPadding(new Insets(10));
            statsBox.setAlignment(Pos.TOP_CENTER); // Align the content at the top but centered horizontally

            Label mostExpensiveLabel = new Label("Most Expensive Car");
            mostExpensiveLabel.setStyle(
                    "-fx-text-fill: #3F2B63; " +
                            "-fx-font-size: 25px; " +
                            "-fx-font-family: 'Comic Sans MS';" +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);"
            );

            Label mostExpensiveValue;
            if (mostExpensiveCar != null) {
                mostExpensiveValue = new Label("Vehicle ID:" + mostExpensiveCar.getVehicleID() +
                        "\nModel:" + mostExpensiveCar.getModel() +
                        "\nyear:" + mostExpensiveCar.getYear() +
                        "\ncolor:" + mostExpensiveCar.getColor() +
                        "\nDaily rent: " + mostExpensiveCar.getDailyRent() + "$");
            } else {
                mostExpensiveValue = new Label("N/A");
            }
            mostExpensiveValue.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" +"-fx-font-weight: bold; ");

            Label leastExpensiveLabel = new Label("Least Expensive Car");
            leastExpensiveLabel.setStyle(
                    "-fx-text-fill: #3F2B63; " +
                            "-fx-font-size: 25px; " +
                            "-fx-font-family: 'Comic Sans MS';" +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);"
            );

            Label leastExpensiveValue;
            if (leastExpensiveCar != null) {
                leastExpensiveValue = new Label("Vehicle ID:" + leastExpensiveCar.getVehicleID() +
                        "\nModel:" + leastExpensiveCar.getModel() +
                        "\nyear:" + leastExpensiveCar.getYear() +
                        "\ncolor:" + leastExpensiveCar.getColor() +
                        "\nDaily rent: " + leastExpensiveCar.getDailyRent() + "$");
            } else {
                leastExpensiveValue = new Label("N/A");
            }
            leastExpensiveValue.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';"+
                    "-fx-font-weight: bold; ");

            Label mostRentedLabel = new Label("Most Rented Car");
            mostRentedLabel.setStyle("-fx-text-fill: #3F2B63; " +
                    "-fx-font-size: 25px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);");

            Label mostRentedValue;
            if (mostRentedCar != null) {
                mostRentedValue = new Label("Vehicle ID:" + mostRentedCar.getVehicleID() +
                        "\nModel:" + mostRentedCar.getModel() +
                        "\nyear:" + mostRentedCar.getYear() +
                        "\ncolor:" + mostRentedCar.getColor() +
                        "\nDaily rent: " + mostRentedCar.getDailyRent() + "$" +
                        "\nNumber of times Rented:" + mostRentedCar.getNumberOfPassengers());
            } else {
                mostRentedValue = new Label("N/A");
            }
            mostRentedValue.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" +"-fx-font-weight: bold; ");

            Label leastRentedLabel = new Label("Least Rented Car");
            leastRentedLabel.setStyle("-fx-text-fill: #3F2B63; " +
                    "-fx-font-size: 25px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);");

            Label leastRentedValue;
            if (leastRentedCar != null) {
                leastRentedValue = new Label("Vehicle ID:" + leastRentedCar.getVehicleID() +
                        "\nModel:" + leastRentedCar.getModel() +
                        "\nyear:" + leastRentedCar.getYear() +
                        "\ncolor:" + leastRentedCar.getColor() +
                        "\nDaily rent: " + leastRentedCar.getDailyRent() + "$" +
                        "\nNumber of times Rented:" + leastRentedCar.getNumberOfPassengers());
            } else {
                leastRentedValue = new Label("N/A");
            }
            leastRentedValue.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" +"-fx-font-weight: bold; ");



            rootStat.add(mostExpensiveLabel,0,0);
            rootStat.add(mostExpensiveValue,0,1);
            rootStat.add(leastExpensiveLabel,0,2);
            rootStat.add(leastExpensiveValue,0,3);
            rootStat.add(mostRentedLabel,0,4);
            rootStat.add(mostRentedValue,0,5);
            rootStat.add(leastRentedLabel,0,6);
            rootStat.add(leastRentedValue,0,7);





            rootStat.setAlignment(Pos.TOP_CENTER); // Align the root content at the top but centered horizontally
            rootStat.add(statsBox, 0, 0);
            formStat.show();});




        vehicleTable.setStyle("-fx-background-color: #E2DDF8;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-border-width: 2;" +
                "-fx-font-size: 14px ");

        vehicleIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        plateIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        powerColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        colorColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        statusColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        passengersColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        modelColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        yearColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        trafficFeesColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        dailyRentColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        weeklyRentColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        monthlyRentColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        insurancePaymentColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");

        //GP1.setStyle("-fx-border-color: BLACK;" + "-fx-border-width: 20;");

        sceneArea.getChildren().addAll(Clabel, search, comboBox, vehicleTable, buttons);
        vehicleTable.setItems(dataList);
        vehicleTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        vehicleTable.setRowFactory(MT -> {
            TableRow<Vehicle> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    int index = row.getIndex();
                    if (vehicleTable.getSelectionModel().isSelected(index)) {
                        vehicleTable.getSelectionModel().clearSelection(index);
                    } else {
                        vehicleTable.getSelectionModel().select(index);

                    }
                }
            });
            return row;
        });


        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(10);

        vehicleTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);


        Stage form = new Stage();
        form.setTitle("Vehicle Data");
        form.setResizable(false);

        GridPane root = new GridPane();
        root.setPrefWidth(250);
        Scene scene1 = new Scene(root, 400, 530);
        form.setScene(scene1);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setStyle("-fx-background-color:#E2DDF8; " + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2");


        Label label2 = new Label("Plate ID");
        TextField plateIDField = new TextField();
        Label label3 = new Label("Power");
        TextField powerField = new TextField();
        Label label4 = new Label("Color");
        TextField colorField = new TextField();
        Label label5 = new Label("Status");
        TextField statusField = new TextField();
        Label label6 = new Label("Passengers");
        TextField passengersField = new TextField();
        Label label7 = new Label("Model");
        TextField modelField = new TextField();
        Label label8 = new Label("Year");
        TextField yearField = new TextField();
        Label label9 = new Label("Traffic Fees");
        TextField trafficFeesField = new TextField();
        Label label10 = new Label("Daily Rent");
        TextField dailyRentField = new TextField();
        Label label11 = new Label("Weekly Rent");
        TextField weeklyRentField = new TextField();
        Label label12 = new Label("Monthly Rent");
        TextField monthlyRentField = new TextField();
        Label label13 = new Label("Insurance Payment");
        TextField insurancePaymentField = new TextField();


        label2.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label3.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label4.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label5.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label6.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label7.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label8.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label9.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label10.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");
        label11.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label12.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label13.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        Button ok = new Button("Insert");
        ok.setPrefSize(200, 25);
        ok.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS; " +
                "-fx-border-width: 2; " +
                "-fx-border-color: #3F2B63; " +
                "-fx-font-weight: BOLD; " +
                "-fx-font-style: ITALIC; " +
                "-fx-border-radius: 10; " +
                "-fx-background-radius: 10;");


        ComboBox status = new ComboBox();
        status.setPrefSize(200, 20);
        status.setValue("Available");

        status.setStyle("-fx-background-color: WHITE;");

        ObservableList<String> items2 = FXCollections.observableArrayList(
                "Available", "Rented", "At maintenance", "Unavailable"
        );
        status.setItems(items2);


        root.add(label2, 0, 1);
        root.add(plateIDField, 1, 1);
        root.add(label3, 0, 2);
        root.add(powerField, 1, 2);
        root.add(label4, 0, 3);
        root.add(colorField, 1, 3);
        root.add(label5, 0, 4);
        root.add(status, 1, 4);
        root.add(label6, 0, 5);
        root.add(passengersField, 1, 5);
        root.add(label7, 0, 6);
        root.add(modelField, 1, 6);
        root.add(label8, 0, 7);
        root.add(yearField, 1, 7);
        root.add(label9, 0, 8);
        root.add(trafficFeesField, 1, 8);
        root.add(label10, 0, 9);
        root.add(dailyRentField, 1, 9);
        root.add(label11, 0, 10);
        root.add(weeklyRentField, 1, 10);
        root.add(label12, 0, 11);
        root.add(monthlyRentField, 1, 11);
        root.add(label13, 0, 12);
        root.add(insurancePaymentField, 1, 12);

        // Add OK button to the layout
        root.add(ok, 1, 13);
        Stage form2 = new Stage();
        form2.setTitle("Vehicle Data");
        form2.setResizable(false);

        GridPane root2 = new GridPane();
        root.setPrefWidth(250);
        Scene scene12 = new Scene(root2, 400, 530);
        form2.setScene(scene12);
        root2.setPadding(new Insets(10));
        root2.setHgap(10);
        root2.setVgap(10);
        root2.setStyle("-fx-background-color:#E2DDF8; " + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2");


        Label label22 = new Label("Plate ID");
        TextField plateIDField2 = new TextField();
        Label label32 = new Label("Power");
        TextField powerField2 = new TextField();
        Label label42 = new Label("Color");
        TextField colorField2 = new TextField();
        Label label52 = new Label("Status");
        TextField statusField2 = new TextField();
        Label label62 = new Label("Passengers");
        TextField passengersField2 = new TextField();
        Label label72 = new Label("Model");
        TextField modelField2 = new TextField();
        Label label82 = new Label("Year");
        TextField yearField2 = new TextField();
        Label label92 = new Label("Traffic Fees");
        TextField trafficFeesField2 = new TextField();
        Label label102 = new Label("Daily Rent");
        TextField dailyRentField2 = new TextField();
        Label label112 = new Label("Weekly Rent");
        TextField weeklyRentField2 = new TextField();
        Label label122 = new Label("Monthly Rent");
        TextField monthlyRentField2 = new TextField();
        Label label132 = new Label("Insurance Payment");
        TextField insurancePaymentField2 = new TextField();


        label22.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label32.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label42.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label52.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label62.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label72.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label82.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label92.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label102.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");
        label112.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label122.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        label132.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;");

        Button ok2 = new Button("Update");
        ok2.setPrefSize(200, 25);
        ok2.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS; " +
                "-fx-border-width: 2; " +
                "-fx-border-color: #3F2B63; " +
                "-fx-font-weight: BOLD; " +
                "-fx-font-style: ITALIC; " +
                "-fx-border-radius: 10; " +
                "-fx-background-radius: 10;");


        ComboBox status2 = new ComboBox();
        status2.setPrefSize(200, 20);

        status2.setStyle("-fx-background-color: WHITE;");

        ObservableList<String> items22 = FXCollections.observableArrayList(
                "Available", "Rented", "At maintenance", "Unavailable"
        );
        status2.setItems(items22);


        root2.add(label22, 0, 1);
        root2.add(plateIDField2, 1, 1);
        root2.add(label32, 0, 2);
        root2.add(powerField2, 1, 2);
        root2.add(label42, 0, 3);
        root2.add(colorField2, 1, 3);
        root2.add(label52, 0, 4);
        root2.add(status2, 1, 4);
        root2.add(label62, 0, 5);
        root2.add(passengersField2, 1, 5);
        root2.add(label72, 0, 6);
        root2.add(modelField2, 1, 6);
        root2.add(label82, 0, 7);
        root2.add(yearField2, 1, 7);
        root2.add(label92, 0, 8);
        root2.add(trafficFeesField2, 1, 8);
        root2.add(label102, 0, 9);
        root2.add(dailyRentField2, 1, 9);
        root2.add(label112, 0, 10);
        root2.add(weeklyRentField2, 1, 10);
        root2.add(label122, 0, 11);
        root2.add(monthlyRentField2, 1, 11);
        root2.add(label132, 0, 12);
        root2.add(insurancePaymentField2, 1, 12);

        // Add OK button to the layout
        root2.add(ok2, 1, 13);

        ///////////////////////////////// Back End


        Insert.setOnAction(e -> {

            form.show();
            ok.setOnAction(e1 -> {
                boolean err = false;
                if (emptyString(plateIDField.getText())) {
                    Alert emptyPID = new Alert(Alert.AlertType.ERROR);
                    emptyPID.setTitle("empty field");
                    emptyPID.setHeaderText(null);
                    emptyPID.setContentText("plate Id field is empty!!!");
                    emptyPID.showAndWait();
                    err = true;
                } else if (!isValidPid(plateIDField.getText())) {
                    Alert invalidVId = new Alert(Alert.AlertType.ERROR);
                    invalidVId.setTitle("invalid plate Id");
                    invalidVId.setHeaderText(null);
                    invalidVId.setContentText("plate id is in this format xxx-xx-xx x is a digit!!!");
                    invalidVId.showAndWait();
                    err = true;
                }
                if (emptyString(powerField.getText())) {
                    Alert emptyP = new Alert(Alert.AlertType.ERROR);
                    emptyP.setTitle("empty field");
                    emptyP.setHeaderText(null);
                    emptyP.setContentText("Power field is empty!!!");
                    emptyP.showAndWait();
                    err = true;
                } else if (!isInteger(powerField.getText())) {
                    Alert invalidP = new Alert(Alert.AlertType.ERROR);
                    invalidP.setTitle("invalid power");
                    invalidP.setHeaderText(null);
                    invalidP.setContentText("power must be an int!!!");
                    invalidP.showAndWait();
                    err = true;
                }
                if (emptyString(colorField.getText())) {
                    Alert emptyc = new Alert(Alert.AlertType.ERROR);
                    emptyc.setTitle("empty field");
                    emptyc.setHeaderText(null);
                    emptyc.setContentText("Color field is empty!!!");
                    emptyc.showAndWait();
                    err = true;
                }
                if (emptyString(passengersField.getText())) {
                    Alert emptyp = new Alert(Alert.AlertType.ERROR);
                    emptyp.setTitle("empty field");
                    emptyp.setHeaderText(null);
                    emptyp.setContentText("Passengers field is empty!!!");
                    emptyp.showAndWait();
                    err = true;
                } else if (!isInteger(passengersField.getText())) {
                    Alert notint = new Alert(Alert.AlertType.ERROR);
                    notint.setTitle("invalid passenger");
                    notint.setHeaderText(null);
                    notint.setContentText("Passengers must be an int");
                    notint.showAndWait();
                    err = true;

                } else if (!validPassenger(Integer.parseInt(passengersField.getText()))) {
                    Alert emptyp2 = new Alert(Alert.AlertType.ERROR);
                    emptyp2.setTitle("invalid number of passenger");
                    emptyp2.setHeaderText(null);
                    emptyp2.setContentText("Passengers number is between 2 and 8!!!");
                    emptyp2.showAndWait();
                    err = true;
                }
                if (emptyString(modelField.getText())) {
                    Alert emptyM = new Alert(Alert.AlertType.ERROR);
                    emptyM.setTitle("empty field");
                    emptyM.setHeaderText(null);
                    emptyM.setContentText("Model field is empty!!!");
                    emptyM.showAndWait();
                    err = true;
                }
                if (emptyString(yearField.getText())) {
                    Alert emptyY = new Alert(Alert.AlertType.ERROR);
                    emptyY.setTitle("empty field");
                    emptyY.setHeaderText(null);
                    emptyY.setContentText("Year field is empty!!!");
                    emptyY.showAndWait();
                    err = true;
                } else if (!isInteger(yearField.getText())) {
                    Alert invalidYear2 = new Alert(Alert.AlertType.ERROR);
                    invalidYear2.setTitle("invalid Year");
                    invalidYear2.setHeaderText(null);
                    invalidYear2.setContentText("Invalid year");
                    invalidYear2.showAndWait();
                    err = true;

                } else if (!validYear(Integer.parseInt(yearField.getText()))) {
                    Alert invalidYear = new Alert(Alert.AlertType.ERROR);
                    invalidYear.setTitle("invalid Year");
                    invalidYear.setHeaderText(null);
                    invalidYear.setContentText("Invalid year");
                    invalidYear.showAndWait();
                    err = true;

                }
                if (emptyString(trafficFeesField.getText())) {
                    Alert emptyt = new Alert(Alert.AlertType.ERROR);
                    emptyt.setTitle("empty field");
                    emptyt.setHeaderText(null);
                    emptyt.setContentText("Traffic fees field is empty!!!");
                    emptyt.showAndWait();
                    err = true;
                } else if (!isDouble(trafficFeesField.getText())) {
                    Alert invalidCost = new Alert(Alert.AlertType.ERROR);
                    invalidCost.setTitle("invalid Cost");
                    invalidCost.setHeaderText(null);
                    invalidCost.setContentText("Cost must be a double !!");
                    invalidCost.showAndWait();
                    err = true;

                }
                if (emptyString(dailyRentField.getText())) {
                    Alert emptytD = new Alert(Alert.AlertType.ERROR);
                    emptytD.setTitle("empty field");
                    emptytD.setHeaderText(null);
                    emptytD.setContentText("dailyRent field is empty!!!");
                    emptytD.showAndWait();
                    err = true;
                } else if (!isDouble(dailyRentField.getText())) {
                    Alert invalidDaily = new Alert(Alert.AlertType.ERROR);
                    invalidDaily.setTitle("invalid daily rent");
                    invalidDaily.setHeaderText(null);
                    invalidDaily.setContentText("Daily rent must be a double !!");
                    invalidDaily.showAndWait();
                    err = true;

                }
                if (emptyString(weeklyRentField.getText())) {
                    Alert emptytW = new Alert(Alert.AlertType.ERROR);
                    emptytW.setTitle("empty field");
                    emptytW.setHeaderText(null);
                    emptytW.setContentText("weekly rent field is empty!!!");
                    emptytW.showAndWait();
                    err = true;
                } else if (!isDouble(weeklyRentField.getText())) {
                    Alert invalidweekly = new Alert(Alert.AlertType.ERROR);
                    invalidweekly.setTitle("invalid weekly rent");
                    invalidweekly.setHeaderText(null);
                    invalidweekly.setContentText("weekly rent must be a double !!");
                    invalidweekly.showAndWait();
                    err = true;

                }
                if (emptyString(monthlyRentField.getText())) {
                    Alert emptytWmonthly = new Alert(Alert.AlertType.ERROR);
                    emptytWmonthly.setTitle("empty field");
                    emptytWmonthly.setHeaderText(null);
                    emptytWmonthly.setContentText("monthly rent field is empty!!!");
                    emptytWmonthly.showAndWait();
                    err = true;
                } else if (!isDouble(monthlyRentField.getText())) {
                    Alert invalidmonthly = new Alert(Alert.AlertType.ERROR);
                    invalidmonthly.setTitle("invalid monthly rent");
                    invalidmonthly.setHeaderText(null);
                    invalidmonthly.setContentText("monthly rent must be a double !!");
                    invalidmonthly.showAndWait();
                    err = true;

                }
                if (emptyString(insurancePaymentField.getText())) {
                    Alert insurancePayment = new Alert(Alert.AlertType.ERROR);
                    insurancePayment.setTitle("empty field");
                    insurancePayment.setHeaderText(null);
                    insurancePayment.setContentText("insurance Payment field is empty!!!");
                    insurancePayment.showAndWait();
                    err = true;
                } else if (!isDouble(insurancePaymentField.getText())) {
                    Alert insurancePayment2 = new Alert(Alert.AlertType.ERROR);
                    insurancePayment2.setTitle("invalid insurancePayment2");
                    insurancePayment2.setHeaderText(null);
                    insurancePayment2.setContentText("insurance Payment must be a double !!");
                    insurancePayment2.showAndWait();
                    err = true;

                }

                if (!err) {
                    try {
                        Vehicle v = new Vehicle(Integer.parseInt(powerField.getText()), colorField.getText(),
                                plateIDField.getText(), status.getValue().toString(),
                                Integer.parseInt(passengersField.getText()), modelField.getText(), Integer.parseInt(yearField.getText()),
                                Double.parseDouble(trafficFeesField.getText()), Double.parseDouble(dailyRentField.getText()),
                                Double.parseDouble(weeklyRentField.getText()), Double.parseDouble(monthlyRentField.getText()),
                                Double.parseDouble(insurancePaymentField.getText()));
                        if (vehicleDAO.insertVehicle(v)) {
                            dataList.add(v);
                            Alert Added = new Alert(Alert.AlertType.INFORMATION);
                            Added.setTitle("insert completed");
                            Added.setHeaderText(null);
                            Added.setContentText("new record has been inserted :)");
                            Added.showAndWait();
                            powerField.setText("");
                            colorField.setText("");
                            weeklyRentField.setText("");
                            monthlyRentField.setText("");
                            weeklyRentField.setText("");
                            insurancePaymentField.setText("");
                            status.setValue("Available");
                            trafficFeesField.setText("");
                            yearField.setText("");
                            passengersField.setText("");
                            modelField.setText("");
                            plateIDField.setText("");
                            form.close();
                        }

                    } catch (Exception e2) {
                        Connector.showAlert("Error", e2.getMessage());
                    }

                }
            });


        });
        Rent.setOnAction(e->{
            Vehicle selected = vehicleTable.getSelectionModel().getSelectedItem();

            if (selected==null){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected Vehicle");
                alert.setHeaderText(null);
                alert.setContentText("You must select a Vehicle first !!");
                alert.showAndWait();
            }
            else if(selected.getStatus().equals("Unavailable")||selected.getStatus().equals("At maintenance")){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Not available Vehicle");
                alert.setHeaderText(null);
                alert.setContentText("This vehicle is not available right now !!");
                alert.showAndWait();
            }
            else {
                forRent=selected;
               /* SignAcontractGUI signAcontractGUI = new SignAcontractGUI();
               // signAcontractGUI.start(stage);
                Scene scene3 = dealBtn.getScene();

                // Get the stage from the scene
                Stage stage2 = (Stage) scene.getWindow();

                // Close the stage
                stage2.close();*/
                Scene s = new SignAcontractGUI().getDealScene(primaryStage);
                primaryStage.setScene(s);
                primaryStage.setMaximized(true);
                // primaryStage.setResizable(true);
                primaryStage.setTitle("Middle East Car Rental");


            }

        });
        Update.setOnAction(e -> {
            Vehicle selected = vehicleTable.getSelectionModel().getSelectedItem();

            if (selected != null) {
                form2.show();
                powerField2.setText(Integer.toString(selected.getPower()));
                colorField2.setText(selected.getColor());
                dailyRentField2.setText(Double.toString(selected.getDailyRent()));
                //String formattedDate = selected.getDate().toString();
                status2.setValue(selected.getStatus());
                passengersField2.setText(Integer.toString(selected.getNumberOfPassengers()));
                plateIDField2.setText(selected.getPlateID());
                weeklyRentField2.setText(Double.toString(selected.getWeeklyRent()));
                monthlyRentField2.setText(Double.toString(selected.getMonthlyRent()));
                insurancePaymentField2.setText(Double.toString(selected.getInsurancePayment()));
                trafficFeesField2.setText(Double.toString(selected.getTrafficDepartmentFees()));
                modelField2.setText(selected.getModel());
                yearField2.setText(Integer.toString(selected.getYear()));


            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected row");
                alert.setHeaderText(null);
                alert.setContentText("You must select a row first !!");
                alert.showAndWait();
            }


            ok2.setOnAction(e1 -> {
                boolean err = false;
                if (emptyString(plateIDField2.getText())) {
                    Alert emptyPID2 = new Alert(Alert.AlertType.ERROR);
                    emptyPID2.setTitle("empty field");
                    emptyPID2.setHeaderText(null);
                    emptyPID2.setContentText("plate Id field is empty!!!");
                    emptyPID2.showAndWait();
                    err = true;
                } else if (!isValidPid(plateIDField2.getText())) {
                    Alert invalidVId = new Alert(Alert.AlertType.ERROR);
                    invalidVId.setTitle("invalid plate Id");
                    invalidVId.setHeaderText(null);
                    invalidVId.setContentText("plate id is in this format xxx-xx-xx x is a digit!!!");
                    invalidVId.showAndWait();
                    err = true;
                }
                if (emptyString(powerField2.getText())) {
                    Alert emptyP = new Alert(Alert.AlertType.ERROR);
                    emptyP.setTitle("empty field");
                    emptyP.setHeaderText(null);
                    emptyP.setContentText("Power field is empty!!!");
                    emptyP.showAndWait();
                    err = true;
                } else if (!isInteger(powerField2.getText())) {
                    Alert invalidP = new Alert(Alert.AlertType.ERROR);
                    invalidP.setTitle("invalid power");
                    invalidP.setHeaderText(null);
                    invalidP.setContentText("power must be an int!!!");
                    invalidP.showAndWait();
                    err = true;
                }
                if (emptyString(colorField2.getText())) {
                    Alert emptyc = new Alert(Alert.AlertType.ERROR);
                    emptyc.setTitle("empty field");
                    emptyc.setHeaderText(null);
                    emptyc.setContentText("Color field is empty!!!");
                    emptyc.showAndWait();
                    err = true;
                }
                if (emptyString(passengersField2.getText())) {
                    Alert emptyp = new Alert(Alert.AlertType.ERROR);
                    emptyp.setTitle("empty field");
                    emptyp.setHeaderText(null);
                    emptyp.setContentText("Passengers field is empty!!!");
                    emptyp.showAndWait();
                    err = true;
                } else if (!isInteger(passengersField2.getText())) {
                    Alert notint = new Alert(Alert.AlertType.ERROR);
                    notint.setTitle("invalid passenger");
                    notint.setHeaderText(null);
                    notint.setContentText("Passengers must be an int");
                    notint.showAndWait();
                    err = true;

                } else if (!validPassenger(Integer.parseInt(passengersField2.getText()))) {
                    Alert emptyp2 = new Alert(Alert.AlertType.ERROR);
                    emptyp2.setTitle("invalid number of passenger");
                    emptyp2.setHeaderText(null);
                    emptyp2.setContentText("Passengers number is between 2 and 8!!!");
                    emptyp2.showAndWait();
                    err = true;
                }
                if (emptyString(modelField2.getText())) {
                    Alert emptyM = new Alert(Alert.AlertType.ERROR);
                    emptyM.setTitle("empty field");
                    emptyM.setHeaderText(null);
                    emptyM.setContentText("Model field is empty!!!");
                    emptyM.showAndWait();
                    err = true;
                }
                if (emptyString(yearField2.getText())) {
                    Alert emptyY = new Alert(Alert.AlertType.ERROR);
                    emptyY.setTitle("empty field");
                    emptyY.setHeaderText(null);
                    emptyY.setContentText("Year field is empty!!!");
                    emptyY.showAndWait();
                    err = true;
                } else if (!isInteger(yearField2.getText())) {
                    Alert invalidYear2 = new Alert(Alert.AlertType.ERROR);
                    invalidYear2.setTitle("invalid Year");
                    invalidYear2.setHeaderText(null);
                    invalidYear2.setContentText("Invalid year");
                    invalidYear2.showAndWait();
                    err = true;

                } else if (!validYear(Integer.parseInt(yearField2.getText()))) {
                    Alert invalidYear = new Alert(Alert.AlertType.ERROR);
                    invalidYear.setTitle("invalid Year");
                    invalidYear.setHeaderText(null);
                    invalidYear.setContentText("Invalid year");
                    invalidYear.showAndWait();
                    err = true;

                }
                if (emptyString(trafficFeesField2.getText())) {
                    Alert emptyt = new Alert(Alert.AlertType.ERROR);
                    emptyt.setTitle("empty field");
                    emptyt.setHeaderText(null);
                    emptyt.setContentText("Traffic fees field is empty!!!");
                    emptyt.showAndWait();
                    err = true;
                } else if (!isDouble(trafficFeesField2.getText())) {
                    Alert invalidCost = new Alert(Alert.AlertType.ERROR);
                    invalidCost.setTitle("invalid Cost");
                    invalidCost.setHeaderText(null);
                    invalidCost.setContentText("Cost must be a double !!");
                    invalidCost.showAndWait();
                    err = true;

                }
                if (emptyString(dailyRentField2.getText())) {
                    Alert emptytD = new Alert(Alert.AlertType.ERROR);
                    emptytD.setTitle("empty field");
                    emptytD.setHeaderText(null);
                    emptytD.setContentText("dailyRent field is empty!!!");
                    emptytD.showAndWait();
                    err = true;
                } else if (!isDouble(dailyRentField2.getText())) {
                    Alert invalidDaily = new Alert(Alert.AlertType.ERROR);
                    invalidDaily.setTitle("invalid daily rent");
                    invalidDaily.setHeaderText(null);
                    invalidDaily.setContentText("Daily rent must be a double !!");
                    invalidDaily.showAndWait();
                    err = true;

                }
                if (emptyString(weeklyRentField2.getText())) {
                    Alert emptytW = new Alert(Alert.AlertType.ERROR);
                    emptytW.setTitle("empty field");
                    emptytW.setHeaderText(null);
                    emptytW.setContentText("weekly rent field is empty!!!");
                    emptytW.showAndWait();
                    err = true;
                } else if (!isDouble(weeklyRentField2.getText())) {
                    Alert invalidweekly = new Alert(Alert.AlertType.ERROR);
                    invalidweekly.setTitle("invalid weekly rent");
                    invalidweekly.setHeaderText(null);
                    invalidweekly.setContentText("weekly rent must be a double !!");
                    invalidweekly.showAndWait();
                    err = true;

                }
                if (emptyString(monthlyRentField2.getText())) {
                    Alert emptytWmonthly = new Alert(Alert.AlertType.ERROR);
                    emptytWmonthly.setTitle("empty field");
                    emptytWmonthly.setHeaderText(null);
                    emptytWmonthly.setContentText("monthly rent field is empty!!!");
                    emptytWmonthly.showAndWait();
                    err = true;
                } else if (!isDouble(monthlyRentField2.getText())) {
                    Alert invalidmonthly = new Alert(Alert.AlertType.ERROR);
                    invalidmonthly.setTitle("invalid monthly rent");
                    invalidmonthly.setHeaderText(null);
                    invalidmonthly.setContentText("monthly rent must be a double !!");
                    invalidmonthly.showAndWait();
                    err = true;

                }
                if (emptyString(insurancePaymentField2.getText())) {
                    Alert insurancePayment = new Alert(Alert.AlertType.ERROR);
                    insurancePayment.setTitle("empty field");
                    insurancePayment.setHeaderText(null);
                    insurancePayment.setContentText("insurance Payment field is empty!!!");
                    insurancePayment.showAndWait();
                    err = true;
                } else if (!isDouble(insurancePaymentField2.getText())) {
                    Alert insurancePayment2 = new Alert(Alert.AlertType.ERROR);
                    insurancePayment2.setTitle("invalid insurancePayment2");
                    insurancePayment2.setHeaderText(null);
                    insurancePayment2.setContentText("insurance Payment must be a double !!");
                    insurancePayment2.showAndWait();
                    err = true;

                }
                if (!err) {
                    if (!Integer.toString(selected.getPower()).equals(powerField2.getText()))
                        vehicleDAO.updatePower(selected.getVehicleID(), Integer.parseInt(powerField2.getText()));
                    if (!selected.getColor().equals(colorField2.getText()))
                        vehicleDAO.updateColor(selected.getVehicleID(), colorField2.getText());
                    if (!selected.getPlateID().equals(plateIDField2.getText()))
                        vehicleDAO.updatePlate_ID(selected.getVehicleID(), plateIDField2.getText());
                    if (!selected.getStatus().equals(status2.getValue().toString()))
                        vehicleDAO.updateVehicles_Status(selected.getVehicleID(), status2.getValue().toString());
                    if (!selected.getModel().equals(modelField2.getText()))
                        vehicleDAO.updateModel(selected.getVehicleID(), modelField2.getText());
                    if (!Integer.toString(selected.getYear()).equals(yearField2.getText()))
                        vehicleDAO.updateYear_of_manufacture(selected.getVehicleID(), Integer.parseInt(yearField2.getText()));
                    if (!Integer.toString(selected.getNumberOfPassengers()).equals(passengersField2.getText()))
                        vehicleDAO.updateNumber_of_passengers(selected.getVehicleID(), selected.getNumberOfPassengers());
                    if (!Double.toString(selected.getTrafficDepartmentFees()).equals(trafficFeesField2.getText()))
                        vehicleDAO.updateTraffic_department_fees(selected.getVehicleID(), Double.parseDouble(trafficFeesField2.getText()));
                    if (!Double.toString(selected.getDailyRent()).equals(dailyRentField2.getText()))
                        vehicleDAO.updateDaily_rent(selected.getVehicleID(), Double.parseDouble(dailyRentField2.getText()));
                    if (!Double.toString(selected.getMonthlyRent()).equals(monthlyRentField2.getText()))
                        vehicleDAO.updateMonthly_rent(selected.getVehicleID(), Double.parseDouble(monthlyRentField2.getText()));
                    if (!Double.toString(selected.getWeeklyRent()).equals(weeklyRentField2.getText()))
                        vehicleDAO.updateWeekly_rent(selected.getVehicleID(), Double.parseDouble(weeklyRentField2.getText()));
                    if (!Double.toString(selected.getInsurancePayment()).equals(insurancePaymentField2.getText()))
                        vehicleDAO.updateInsurance_payment(selected.getVehicleID(), Double.parseDouble(insurancePaymentField2.getText()));
                    selected.setPower(Integer.parseInt(powerField2.getText()));
                    selected.setColor(colorField2.getText());
                    selected.setPlateID(plateIDField2.getText());
                    selected.setStatus(status2.getValue().toString());
                    selected.setModel(modelField2.getText());
                    selected.setYear(Integer.parseInt(yearField2.getText()));
                    selected.setNumberOfPassengers(Integer.parseInt(passengersField2.getText()));
                    selected.setTrafficDepartmentFees(Double.parseDouble(trafficFeesField2.getText()));
                    selected.setDailyRent(Double.parseDouble(dailyRentField2.getText()));
                    selected.setWeeklyRent(Double.parseDouble(weeklyRentField2.getText()));
                    selected.setMonthlyRent(Double.parseDouble(monthlyRentField2.getText()));
                    selected.setInsurancePayment(Double.parseDouble(insurancePaymentField2.getText()));


                    vehicleTable.refresh();
                    Alert doneUp = new Alert(Alert.AlertType.INFORMATION);
                    doneUp.setTitle("record updated");
                    doneUp.setHeaderText(null);
                    doneUp.setContentText("Record updated successfully :)");
                    doneUp.showAndWait();
                    form2.close();

                }


            });


        });


        //////////////////////////////////// search part

        searchbtn.setOnAction(e2 -> {
            String searchContent = serachBAR.getText();
            String field = comboBox.getValue();
            if (field != null && !searchContent.trim().isEmpty()) {
                String dbField;
                switch (field) {
                    case "Vehicle ID":
                        dbField = "Vehicle_ID";
                        break;
                    case "Plate ID":
                        dbField = "Plate_ID";
                        break;
                    case "Power":
                        dbField = "Power";
                        break;
                    case "Color":
                        dbField = "Color";
                        break;
                    case "Status":
                        dbField = "Vehicles_Status";
                        break;
                    case "Passengers":
                        dbField = "Number_of_passengers";
                        break;
                    case "Model":
                        dbField = "model";
                        break;
                    case "Year":
                        dbField = "Year_of_manufacture";
                        break;
                    case "Traffic Fees":
                        dbField = "Traffic_department_fees";
                        break;
                    case "Daily Rent":
                        dbField = "Daily_Rent";
                        break;
                    case "Weekly Rent":
                        dbField = "Weekly_Rent";
                        break;
                    case "Monthly Rent":
                        dbField = "Monthly_Rent";
                        break;
                    case "Insurance Payment":
                        dbField = "Insurance_payment";
                        break;
                    default:
                        dbField = "";
                        break;
                }
                List<Vehicle> searchResults = vehicleDAO.searchVehicles(dbField, searchContent);
                dataList.setAll(searchResults);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Search");
                alert.setHeaderText(null);
                alert.setContentText("Please specify a field and enter a search term.");
                alert.showAndWait();
            }
        });
        Refresh.setOnAction(e -> {
            try {
                data = vehicleDAO.getData();
                dataList = FXCollections.observableArrayList(data);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            vehicleTable.setItems(dataList);
            vehicleTable.refresh();
            serachBAR.setText("");


        });


        CustomerGUI customerGUI = new CustomerGUI();
        VehicleGUI vehicleGUI = new VehicleGUI();
        PaymentGUI paymentGUI = new PaymentGUI();
        MaintenanceGUI maintenanceGUI = new MaintenanceGUI();
        ContractGUI contractGUI = new ContractGUI();
        EmployeeGUI employeeGUI = new EmployeeGUI();
        SignAcontractGUI signAcontractGUI = new SignAcontractGUI();
        MainPage mainGUI = new MainPage();

        DASHBOARD.setOnAction(e -> {
            Scene s = new MainPage().getDashboardScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");
        });

        CustomersBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new CustomerGUI().getCustomerScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

        EmployeesBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new EmployeeGUI().getEmployeeScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

        PaymentsBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new PaymentGUI().getPaymentScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

        MaintenanceBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new MaintenanceGUI().getMaintenanceScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

        VehiclesBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new VehicleGUI().getVehicleScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

        ContractBtn.setOnAction(e -> {
            // Get the button's scene
            Scene s = new ContractGUI().getContractScene(primaryStage);
            primaryStage.setScene(s);
            primaryStage.setMaximized(true);
             primaryStage.setResizable(true);
            primaryStage.setTitle("Middle East Car Rental");

        });

      /*  dealBtn.setOnAction(e -> {
            // Get the button's scene
            signAcontractGUI.start(stage);
            Scene scene3 = dealBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });*/


       /* DASHBOARD.setOnAction(e -> {
            // Get the button's scene
            mainGUI.start(stage);
            Scene scene2 = DASHBOARD.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });
        CustomersBtn.setOnAction(e -> {
            // Get the button's scene
            customerGUI.start(stage);
            Scene scene2 = CustomersBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });

        EmployeesBtn.setOnAction(e -> {
            // Get the button's scene
            employeeGUI.start(stage);
            Scene scene2 = EmployeesBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });


        PaymentsBtn.setOnAction(e -> {
            // Get the button's scene
            paymentGUI.start(stage);
            Scene scene2 = PaymentsBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });


        MaintenanceBtn.setOnAction(e -> {
            // Get the button's scene
            maintenanceGUI.start(stage);
            Scene scene2 = MaintenanceBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });

        VehiclesBtn.setOnAction(e -> {
            // Get the button's scene
            vehicleGUI.start(stage);
            Scene scene2 = VehiclesBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });


        ContractBtn.setOnAction(e -> {
            // Get the button's scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();
            contractGUI.start(stage);
            Scene scene2 = ContractBtn.getScene();

            // Get the stage from the scene


        });

        dealBtn.setOnAction(e -> {
            // Get the button's scene
            signAcontractGUI.start(stage);
            Scene scene3 = dealBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });*/


        //stage.setScene(scene);
        //stage.setTitle("Vehicle GUI");
        //stage.show();
        logOut.setOnAction(e->{
            LoginGUI loginGUI = new LoginGUI();

            loginGUI.start(stage);
            Scene scene3 = logOut.getScene();
            Stage stage2 = (Stage) scene.getWindow();
            stage2.close();




        });

        return scene;

    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean validPassenger(int pass) {
        if (pass > 8) {
            return false;
        } else if (pass < 2)
            return false;
        else return true;
    }

    public static boolean validYear(int year) {
        if (year > 2024 || year < 2010) {
            return false;
        } else return true;

    }

    public static boolean emptyString(String str) {
        return str.equals("");
    }

    public static boolean isValidPid(String input) {
        return input.matches("\\d{3}-\\d{2}-\\d{3}");
    }
    public static Vehicle gettheRented() {
        return forRent;
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getVehicleScene(primaryStage));
        primaryStage.setTitle("Middle East Car Rental");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();

    }



}
