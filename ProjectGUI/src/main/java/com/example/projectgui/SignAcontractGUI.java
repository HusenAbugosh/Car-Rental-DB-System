package com.example.projectgui;

import DAO.ContractDAO;
import DAO.VehicleDAO;
import DAO.PaymentDAO;
import entities.Vehicle;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.Period;
import entities.Contract;
import entities.Payment;

public class SignAcontractGUI extends Application {
    private Stage stage2;
    private Vehicle forRENT;
    private VehicleDAO vehicleDAO;
    private String loggedId;
    private CustomerGUI customerGUI;
    private ContractDAO contractDAO;

    public static void main(String[] args) {
        launch(args);
    }

    public Scene getDealScene(Stage primaryStage) {
        contractDAO = new ContractDAO();
        customerGUI = new CustomerGUI();
        loggedId = LoginGUI.getloggedID();
        vehicleDAO = new VehicleDAO();
        forRENT = VehicleGUI.gettheRented();
        if (forRENT == null)
            System.out.println("not selected yet");
        else
            System.out.println(forRENT);

        // UI components setup
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
        logOut.setPrefSize(320, 50);
        dealBtn.setPrefSize(320, 50);

        dealBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 26px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACk;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        CustomersBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACk;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        ContractBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        PaymentsBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        VehiclesBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        EmployeesBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        MaintenanceBtn.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 28px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        DASHBOARD.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family:Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        logOut.setStyle("-fx-background-color: #3F2B63; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        BackBtn.setStyle("-fx-background-color: #ED5506; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 30px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
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
        sceneArea.setStyle("-fx-background-color: #E2DDF8;");
        sceneArea.setSpacing(50);
        sceneArea.setPadding(new Insets(20, 20, 350, 20));

        sceneArea.setAlignment(Pos.TOP_CENTER);
        Pane pane = new Pane();
        Label t1 = new Label("First Name");
        MainPage MP = new MainPage();

        Screen Cscene = Screen.getPrimary();
        GridPane GP1 = new GridPane();
        GP1.add(sceneArea, 1, 0);
        Button close = new Button("Close");

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();
        Stage stage = new Stage();
        Scene scene = new Scene(GP1, 1520, 820);

        column1.setPercentWidth(22);
        column2.setPercentWidth(78);
        GP1.getColumnConstraints().addAll(column1, column2);
        GP1.setBackground(new Background(new BackgroundFill(Color.web("#3F2B63"), null, null)));
        GP1.add(Menu, 0, 0);

        Label Clabel = new Label("Contract");
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setPrefSize(500, 70);
        Clabel.setStyle("-fx-font-family: Helvetica;" +
                "-fx-font-size: 50;" +
                "-fx-text-fill: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-background-color: TRANSPARENT;");

        Label Contract_ID = new Label("Contract ID");
        TextField Contract_ID1 = new TextField();
        Label Employee_ID = new Label("Employee ID");
        TextField Employee_ID1 = new TextField();
        Employee_ID1.setEditable(false);
        if (loggedId != null) {
            Employee_ID1.setText(loggedId);
        }
        Contract_ID.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        Employee_ID.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");
        Contract_ID1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" +
                        "-fx-font-size: 17;"
        );
        Contract_ID1.setPrefWidth(200);

        Employee_ID1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17"
        );

        Label Customer_ID = new Label("Customer ID");
        TextField Customer_ID1 = new TextField();
        Button newCustomer = new Button("New Customer?");
        Button SignUP = new Button("sign up");

        Customer_ID.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        SignUP.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        newCustomer.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 0;" +
                "-fx-background-radius: 0;" +
                "-fx-text-alignment: LEFT;");
        newCustomer.setUnderline(true);

        Customer_ID1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );
        Contract_ID1.setEditable(false);

        Label Vehicle_ID = new Label("Vehicle ID");
        TextField Vehicle_ID1 = new TextField();

        Button specs = new Button("Vehicle specs");
        specs.setPrefSize(150, 30);

        specs.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 0;" +
                "-fx-background-radius: 0;" +
                "-fx-text-alignment: LEFT;");
        specs.setUnderline(true);

        Vehicle_ID.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");
        Label Available = new Label("check if Available");
        Available.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-style: ITALIC;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");
        Button Check = new Button("Check");
        Check.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;");

        Vehicle_ID1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;");

        Label startDate = new Label("Start Date");
        DatePicker startDate1 = new DatePicker();
        startDate1.setEditable(false);
        Label endDate = new Label("End Date");
        DatePicker endDate1 = new DatePicker();
        endDate1.setEditable(false);
        startDate.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        endDate.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        TextField field = startDate1.getEditor();
        field.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );

        field.setPrefWidth(200);

        startDate1.setStyle(
                "-fx-background-color: transparent;"
        );

        TextField field1 = endDate1.getEditor();
        field1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );
        field1.setPrefWidth(200);

        endDate1.setStyle(
                ".combo-box .arrow-button  -fx-background-color: transparent; " +
                        ".combo-box .arrow  -fx-background-color: black; "
        );
        endDate1.setStyle(
                "-fx-background-color: transparent;"
        );

        Button Submit = new Button("Submit");
        Submit.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;");
        Submit.setPrefSize(220, 30);
        Submit.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"); // Font family

        Button Select = new Button("Select a Car");
        Select.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;");
        Select.setPrefSize(220, 30);
        Select.setStyle("-fx-background-color: #E2DDF8; " + // Background color
                "-fx-text-fill: #3F2B63; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;"); // Font family

        SignUP.setStyle("-fx-background-color: #ED7D31; " + // Background color
                "-fx-text-fill: #070F2B; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Constantia;" +
                "-fx-border-width: 5;" +
                "-fx-border-color: #070F2B;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        Check.setStyle("-fx-background-color: #ED7D31; " + // Background color
                "-fx-text-fill: #070F2B; " + // Text color
                "-fx-font-size: 20px; " + // Font size
                "-fx-font-family: Constantia;" +
                "-fx-border-width: 5;" +
                "-fx-border-color: #070F2B;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"); // Font family

        Label cost = new Label("Cost");
        TextField cost1 = new TextField();
        cost1.setEditable(false);
        cost.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");

        cost1.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );

        Label RentType = new Label("Rent Type");
        RentType.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");



        ComboBox<String> Rtype = new ComboBox<>();
        Rtype.setPrefSize(200, 20);
        Rtype.setStyle("-fx-background-color: WHITE;");
        ObservableList<String> items2 = FXCollections.observableArrayList("Daily", "Weekly", "Monthly");
        Rtype.setItems(items2);
        Rtype.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );


        Label PayMethod = new Label("Method");
        PayMethod.setStyle("-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 20;" +
                "-fx-font-weight: BOLD;" +
                "-fx-text-fill: #3F2B63;");



        ComboBox<String> Method = new ComboBox<>();
        Method.setPrefSize(200, 20);
        Method.setStyle("-fx-background-color: WHITE;");
        ObservableList<String> items3 = FXCollections.observableArrayList("Bank Checks", "Cash", "Visa");
        Method.setItems(items3);
        Method.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent transparent black transparent;" +
                        "-fx-border-width: 0 0 1 0;" +
                        "-fx-padding: 5 0 5 0;" + "-fx-font-size: 17;"
        );


        GridPane Contractform = new GridPane();
        Contractform.setAlignment(Pos.CENTER);
        Contractform.setHgap(15);
        Contractform.setVgap(30);
        Contractform.setPadding(new Insets(10, 10, 10, 10));
        Contractform.add(Employee_ID, 2, 0);
        Contractform.add(Employee_ID1, 3, 0);
        Contractform.add(Customer_ID, 2, 1);
        Contractform.add(Customer_ID1, 3, 1);
        Contractform.add(newCustomer, 4, 1);
        Contractform.add(Vehicle_ID, 2, 2);
        Contractform.add(Vehicle_ID1, 3, 2);
        Contractform.add(specs, 4, 2);
        Contractform.add(startDate, 2, 3);
        Contractform.add(startDate1, 3, 3);
        Contractform.add(endDate, 2, 4);
        Contractform.add(endDate1, 3, 4);
        Contractform.add(RentType, 2, 6);
        Contractform.add(Rtype, 3, 6);

        Contractform.add(PayMethod, 2, 7);
        Contractform.add(Method, 3, 7);

        Contractform.add(cost, 2, 8);
        Contractform.add(cost1, 3, 9);
        Contractform.add(Submit, 3, 10);

        sceneArea.getChildren().addAll(Clabel, Contractform);

        Rtype.setOnAction(e -> calculateCost(startDate1.getValue(), endDate1.getValue(), Vehicle_ID1.getText(), Rtype.getValue(), cost1));

        startDate1.valueProperty().addListener((observable, oldValue, newValue) -> calculateCost(newValue, endDate1.getValue(), Vehicle_ID1.getText(), Rtype.getValue(), cost1));
        endDate1.valueProperty().addListener((observable, oldValue, newValue) -> calculateCost(startDate1.getValue(), newValue, Vehicle_ID1.getText(), Rtype.getValue(), cost1));
        Vehicle_ID1.textProperty().addListener((observable, oldValue, newValue) -> calculateCost(startDate1.getValue(), endDate1.getValue(), newValue, Rtype.getValue(), cost1));

        Submit.setOnAction(e -> handleSubmit(Contract_ID1, Vehicle_ID1, Customer_ID1, Employee_ID1, startDate1, endDate1, Rtype, cost1, Method));

        // Additional handlers for other buttons (specs, newCustomer, etc.)

        specs.setOnAction(e -> {






        });

        newCustomer.setOnAction(e -> {

        });

        Vehicle_ID1.setEditable(false);
        if (forRENT != null) {
            if (forRENT.getVehicleID() != 0)
                Vehicle_ID1.setText(Integer.toString(forRENT.getVehicleID()));
        }

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

        logOut.setOnAction(e -> {
            LoginGUI loginGUI = new LoginGUI();
            loginGUI.start(stage);
            Stage stage2 = (Stage) scene.getWindow();
            stage2.close();
        });

        return scene;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;
        primaryStage.setScene(getDealScene(primaryStage));
        primaryStage.setTitle("Middle East Car Rental");
        primaryStage.show();
    }

    private void calculateCost(LocalDate startDate, LocalDate endDate, String vehicleID, String rentType, TextField costField) {
        if (startDate == null || endDate == null || vehicleID == null || vehicleID.isEmpty() || rentType == null || rentType.isEmpty()) {
            return;
        }

        // Validate the interval
        Period period = Period.between(startDate, endDate);
        if (rentType.equals("Weekly") && period.getDays() % 7 != 0) {
            showAlert("Invalid Date Range", "For weekly rent type, the interval should be a multiple of 7 days.");
            costField.setText("");
            return;
        } else if (rentType.equals("Monthly") && period.getDays() % 30 != 0) {
            showAlert("Invalid Date Range", "For monthly rent type, the interval should be a multiple of 30 days.");
            costField.setText("");
            return;
        }

        try {
            Vehicle vehicle = vehicleDAO.returnCar(Integer.parseInt(vehicleID));
            double cost = 0.0;

            if (rentType.equals("Daily")) {
                cost = dailyrent(startDate, endDate, vehicle.getDailyRent());
            } else if (rentType.equals("Weekly")) {
                cost = weeklyRent(startDate, endDate, vehicle.getWeeklyRent());
            } else if (rentType.equals("Monthly")) {
                cost = monthlyRent(startDate, endDate, vehicle.getMonthlyRent());
            }


            costField.setText(String.valueOf(cost) + " + " +  String.valueOf(vehicle.getInsurancePayment() + " (insurance)" ));
        } catch (Exception e) {
            showAlert("Error", "Failed to calculate the cost. Please check the vehicle ID.");
        }
    }

    private void handleSubmit(TextField contractIDField, TextField vehicleIDField, TextField customerIDField, TextField employeeIDField, DatePicker startDateField, DatePicker endDateField, ComboBox<String> rentTypeField, TextField costField, ComboBox<String> method) {
        // Validate and submit the contract
        String contractID = contractIDField.getText();
        String vehicleID = vehicleIDField.getText();
        String customerID = customerIDField.getText();
        String employeeID = employeeIDField.getText();
        LocalDate startDate = startDateField.getValue();
        LocalDate endDate = endDateField.getValue();
        String rentType = rentTypeField.getValue();
        String paymentMthd = method.getValue();
        String cost = costField.getText();

        if (vehicleID.isEmpty() || customerID.isEmpty() || employeeID.isEmpty() || startDate == null || endDate == null || rentType == null || cost.isEmpty()) {
            showAlert("Invalid Input", "All fields are required.");
            return;
        }

        if (!isValidIdd(customerID)) {
            showAlert("Invalid Input", "Customer ID must be a 9-digit number.");
            return;
        }

        try {
            if (!customerGUI.doesCustomerExist(Integer.parseInt(customerID))) {
                showAlert("Invalid Input", "Customer does not exist. Please add the customer first.");
                return;
            }

            if (vehicleDAO.checkContractConflict(Integer.parseInt(vehicleID), startDate, endDate)) {
                showAlert("Conflict", "The dates conflict with other contracts. Please select another car or another date.");
                return;
            }



            String[] parts = cost.split("\\+");
            String baseCostString = parts[0].trim();
            double baseCost = Double.parseDouble(baseCostString);

            // Insert the contract
            Contract contract = new Contract(
                    1,
                    startDate.toString(),
                    endDate.toString(),
                    Integer.parseInt(vehicleID),
                    Integer.parseInt(customerID),
                    "",
                    Integer.parseInt(employeeID),
                    "",
                    baseCost ,
                    "Active",
                    rentType.toString()

            );

            contractDAO.insertContract(contract);


            Payment payment = new Payment(
                    contract.getContractID(),
                    LocalDate.now(),
                    baseCost,
                    paymentMthd.toString() // This should be replaced with the actual payment method
            );

            PaymentDAO paymentDAO = new PaymentDAO();
            paymentDAO.insertPayment(payment);

            showSuccessAlert("Success", "Contract has been inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to insert the contract. Please check the inputs.");
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }


    private void showSuccessAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public boolean isValidIdd(String ID) {
        return ID.matches("\\d{9}");
    }

    public static double dailyrent(LocalDate startDate, LocalDate endDate, double rent) {
        Period period = Period.between(startDate, endDate);
        int daysBetween = period.getDays();
        return daysBetween * rent;
    }

    public static double monthlyRent(LocalDate startDate, LocalDate endDate, double rent) {
        Period period = Period.between(startDate, endDate);
        int monthsBetween = period.getMonths();
        return monthsBetween * rent;
    }

    public static double weeklyRent(LocalDate startDate, LocalDate endDate, double rent) {
        Period period = Period.between(startDate, endDate);
        int weeksBetween = period.getDays() / 7;
        return weeksBetween * rent;
    }
}
