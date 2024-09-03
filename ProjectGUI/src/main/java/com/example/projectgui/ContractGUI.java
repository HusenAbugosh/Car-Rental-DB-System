package com.example.projectgui;

import DAO.ContractDAO;
import entities.Contract;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

public class ContractGUI extends Application {
    private Stage stage2;

    private ObservableList<Contract> contractData = FXCollections.observableArrayList();
    private ContractDAO contractDAO = new ContractDAO();

    private CustomerGUI customerGUI = new CustomerGUI();
    private VehicleGUI vehicleGUI = new VehicleGUI();
    private PaymentGUI paymentGUI = new PaymentGUI();
    private MaintenanceGUI maintenanceGUI = new MaintenanceGUI();
    private EmployeeGUI employeeGUI = new EmployeeGUI();
    private SignAcontractGUI signAcontractGUI = new SignAcontractGUI();
    private MainPage mainGUI = new MainPage();

    private Contract selectedContract;

    public static void main(String[] args) {
        launch(args);
    }


    public Scene getContractScene(Stage primaryStage) {

        // Load data from the database
        contractData.addAll(contractDAO.getAllContracts());

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
        Button EmployeesBtn = new Button(" Employees ", new ImageView(EMPICON));
        Button MaintenanceBtn = new Button(" Maintenance", new ImageView(maintenanceICON));
        Button VehiclesBtn = new Button(" Vehicles   ", new ImageView(carICON));
        Button DASHBOARD = new Button("DashBoard", new ImageView(DBICON));
        Button BackBtn = new Button("Back To Main Page");
        Button logOut = new Button(" Log Out  ", new ImageView(LOICON));
        Button dealBtn = new Button(" Make a Deal", new ImageView(dealICON));


        HBox current = new HBox();
        current.getChildren().addAll(label, ContractBtn);

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

        // Set styles for buttons
        String buttonStyle = "-fx-background-color: #3F2B63; " +
                "-fx-text-fill: #EEF7FF; " +
                "-fx-font-size: 30px; " +
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;";

        CustomersBtn.setStyle(buttonStyle);
        ContractBtn.setStyle(buttonStyle);
        PaymentsBtn.setStyle(buttonStyle);
        VehiclesBtn.setStyle(buttonStyle);
        EmployeesBtn.setStyle(buttonStyle);
        MaintenanceBtn.setStyle(buttonStyle);
        DASHBOARD.setStyle(buttonStyle);
        logOut.setStyle(buttonStyle);
        dealBtn.setStyle("-fx-background-color: #3F2B63; " +
                "-fx-text-fill: #EEF7FF; " +
                "-fx-font-size: 26px; " +
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 0;" +
                "-fx-border-color: BLACK;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;");

        Label space = new Label();
        space.setStyle("-fx-background-color: #3F2B63");
        space.setPrefSize(350, 10);

        Image logo = new Image("/LOGO3.PNG");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(320);
        logoView.setFitHeight(100);

        VBox Menu = new VBox();
        Menu.getChildren().addAll(logoView, space, DASHBOARD, CustomersBtn, EmployeesBtn, current, PaymentsBtn, MaintenanceBtn, VehiclesBtn, logOut);
        Menu.setSpacing(3);
        Menu.setPadding(new Insets(2));

        VBox sceneArea = new VBox();
        sceneArea.setStyle("-fx-background-color: #FFFFFF;");
        sceneArea.setSpacing(50);
        sceneArea.setPadding(new Insets(20, 20, 100, 20));

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
        serachBAR.setStyle("-fx-background-radius: 20 0 0 20;" + "-fx-background-color: #E2DDF8;" + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2px;" + "-fx-border-radius: 20 0 0 20;");

        DatePicker datePicker = new DatePicker();
        datePicker.setPrefSize(300, 41.2);
        datePicker.setStyle("-fx-background-radius: 20 0 0 20;" +
                "-fx-background-color: #E2DDF8;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-border-width: 2px;" +
                "-fx-border-radius: 20 0 0 20;" +
                "-fx-padding: 10;" +
                "-fx-text-fill: #3F2B63;");

        datePicker.setVisible(false); //<-- Initially hidden

        Image searchimg = new Image(getClass().getResourceAsStream("/searchICON.png"));

        Button searchbtn = new Button("", new ImageView(searchimg));
        searchbtn.setStyle("-fx-background-radius: 0 19 19 0;" + "-fx-background-color: #E2DDF8;" + "-fx-border-color: #3F2B63;" + "-fx-border-radius: 0 19 19 0;");
        searchbtn.setPrefSize(60, 40);

        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Contract ID", "Vehicle ID", "Customer Name", "Employee Name", "Cost", "Status", "Start Date", "End Date", "Contract Type"
        );

        comboBox.setItems(items);
        comboBox.setPrefSize(200, 40);
        comboBox.setPromptText("Specify the field..");
        comboBox.setStyle("-fx-background-color: #E2DDF8;" + "-fx-font-family: Comic Sans MS;" + "-fx-font-size: 15px");
        comboBox.setPadding(new Insets(0, 0, 0, 30));

        HBox search = new HBox();
        search.getChildren().addAll(serachBAR, searchbtn);
        search.setAlignment(Pos.CENTER);

        comboBox.setOnAction(e -> {
            String selectedField = comboBox.getValue();
            if (selectedField != null && (selectedField.equals("Start Date") || selectedField.equals("End Date"))) {
                serachBAR.setVisible(false);
                datePicker.setVisible(true);
                if (!search.getChildren().contains(datePicker)) {
                    search.getChildren().remove(serachBAR);
                    search.getChildren().add(0, datePicker);
                }
            } else {
                datePicker.setVisible(false);
                serachBAR.setVisible(true);
                if (!search.getChildren().contains(serachBAR)) {
                    search.getChildren().remove(datePicker);
                    search.getChildren().add(0, serachBAR);
                }
            }
        });

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        datePicker.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                serachBAR.setText(newValue.format(dateFormatter));
            }
        });

        // Search button event handler
        searchbtn.setOnAction(e2 -> {
            String searchField = comboBox.getValue();
            String searchContent = serachBAR.getText();

            if (searchField == null || searchField.isEmpty()) {
                showAlert("Search Error", "Please select a search field.");
                return;
            }

            if ((searchField.equals("Start Date") || searchField.equals("End Date")) && (datePicker.getValue() == null)) {
                showAlert("Search Error", "Please select a date.");
                return;
            }

            if (searchContent == null || searchContent.isEmpty()) {
                showAlert("Search Error", "Please enter a value to search.");
                return;
            }

            List<Contract> foundContracts = contractDAO.searchContracts(searchField, searchContent);
            contractData.setAll(foundContracts); // Update the TableView with the search results
        });

        TableView<Contract> ContractTable = new TableView<>();
        ContractTable.setItems(contractData); // Set the items to the table

        ContractTable.setPrefSize(706, 900);
        ContractTable.setPadding(new Insets(5));

        TableColumn<Contract, Integer> contractIDColumn = new TableColumn<>("Contract ID");
        contractIDColumn.setCellValueFactory(new PropertyValueFactory<>("contractID"));

        TableColumn<Contract, Integer> vehicleIDColumn = new TableColumn<>("Vehicle ID");
        vehicleIDColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));

        TableColumn<Contract, String> customerNameColumn = new TableColumn<>("Customer Name");
        customerNameColumn.setCellValueFactory(new PropertyValueFactory<>("customerName"));

        TableColumn<Contract, String> employeeNameColumn = new TableColumn<>("Employee Name");
        employeeNameColumn.setCellValueFactory(new PropertyValueFactory<>("employeeName"));

        TableColumn<Contract, Double> costColumn = new TableColumn<>("Cost");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));

        TableColumn<Contract, String> statusColumn = new TableColumn<>("Status");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("contractStatus"));

        TableColumn<Contract, String> startDateColumn = new TableColumn<>("Start Date");
        startDateColumn.setCellValueFactory(new PropertyValueFactory<>("startDate"));

        TableColumn<Contract, String> endDateColumn = new TableColumn<>("End Date");
        endDateColumn.setCellValueFactory(new PropertyValueFactory<>("endDate"));

        TableColumn<Contract, String> contractTypeColumn = new TableColumn<>("Contract Type");
        contractTypeColumn.setCellValueFactory(new PropertyValueFactory<>("contractType"));

        ContractTable.getColumns().addAll(
                contractIDColumn, vehicleIDColumn, customerNameColumn,
                employeeNameColumn, costColumn, statusColumn, startDateColumn, endDateColumn, contractTypeColumn
        );

        ContractTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView

        Label Clabel = new Label("Contracts");
        Clabel.setPrefSize(500, 70);
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setStyle("-fx-font-family: Helvetica;" + "-fx-font-size: 50;" + "-fx-text-fill: #3F2B63;" + "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;" + "-fx-background-color: TRANSPARENT;");

        Button Insert = new Button("Insert");
        Button Delete = new Button("Delete");
        Button Update = new Button("Update");
        Button Select = new Button("Select");
        Button resetbtn = new Button("Reset");
        Button statBtn = new Button("Top 3 Contracts");

        Insert.setPrefSize(150, 40);
        Update.setPrefSize(150, 40);
        Delete.setPrefSize(150, 40);
        Select.setPrefSize(150, 40);
        resetbtn.setPrefSize(150, 40);

        // Set styles for lower buttons
        String buttonStyleLower = "-fx-background-color: #E2DDF8; " +
                "-fx-text-fill: #3F2B63; " +
                "-fx-font-size: 25px; " +
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;";

        Insert.setStyle(buttonStyleLower);
        Delete.setStyle(buttonStyleLower);
        Update.setStyle(buttonStyleLower);
        resetbtn.setStyle(buttonStyleLower);
        statBtn.setStyle(buttonStyleLower);
        Select.setStyle("-fx-background-color: #ED5506; " +
                "-fx-text-fill: #EEF7FF; " +
                "-fx-font-size: 25px; " +
                "-fx-font-family: Constantia;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;");

        HBox buttons = new HBox();
        buttons.getChildren().addAll(Update, resetbtn, statBtn);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));

        ContractTable.setStyle("-fx-background-color: #E2DDF8;" + "-fx-border-radius: 20;" + "-fx-background-radius: 20;" + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2;" + "-fx-font-size: 14px ");

        contractIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        vehicleIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        customerNameColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        employeeNameColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        costColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        statusColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        startDateColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        endDateColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        contractTypeColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");

        sceneArea.getChildren().addAll(Clabel, search, comboBox, ContractTable, buttons);

        resetbtn.setOnAction(e3 -> {
            serachBAR.clear();
            datePicker.setValue(null);
            comboBox.setValue(null); // Reset to null to show the prompt text
            contractData.setAll(contractDAO.getAllContracts()); // Reset to show all contracts
        });

        // Add the event handler for statBtn
        statBtn.setOnAction(e -> {
            List<Contract> topContracts = contractDAO.getTop3ContractsByCost();

            Stage topContractsStage = new Stage();
            topContractsStage.setTitle("Top Contracts");

            VBox vbox = new VBox();
            vbox.setSpacing(10);
            vbox.setPadding(new Insets(10));
            vbox.setStyle("-fx-background-color: #FFFFFF; -fx-border-color: #3F2B63; -fx-border-width: 2;");
            vbox.setAlignment(Pos.CENTER); // Center the cards vertically

            Label titleLabel = new Label("Top 3 Contracts by Cost");
            titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #3F2B63;");
            vbox.getChildren().add(titleLabel);

            for (Contract contract : topContracts) {
                Label contractLabel = new Label(
                        "Contract ID: " + contract.getContractID() + "\n" +
                                "Customer Name: " + contract.getCustomerName() + "\n" +
                                "Employee Name: " + contract.getEmployeeName() + "\n" +
                                "Cost: " + contract.getCost() + "\n" +
                                "Status: " + contract.getContractStatus() + "\n" +
                                "Start Date: " + contract.getStartDate() + "\n" +
                                "End Date: " + contract.getEndDate()
                );
                contractLabel.setStyle("-fx-background-color: #E2DDF8; -fx-padding: 10; -fx-border-color: #3F2B63; -fx-border-width: 2; -fx-border-radius: 10; -fx-background-radius: 10;");
                contractLabel.setPrefWidth(350); // Set preferred width for the card
                contractLabel.setWrapText(true); // Allow text wrapping within the card
                VBox.setMargin(contractLabel, new Insets(10, 0, 10, 0)); // Add margin to each card
                vbox.getChildren().add(contractLabel);
            }

            ScrollPane scrollPane = new ScrollPane(vbox); // Add a ScrollPane to handle overflow
            scrollPane.setFitToWidth(true); // Make sure the ScrollPane fits the width of the VBox
            scrollPane.setStyle("-fx-background-color: transparent;"); // Make the background of the ScrollPane transparent

            Scene topContractsScene = new Scene(scrollPane, 400, 400);
            topContractsStage.setScene(topContractsScene);
            topContractsStage.show();
        });

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(10);

        ContractTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);

        Stage form = new Stage();
        form.setTitle("Update Contract Status");
        form.setResizable(false);

        GridPane updateRoot = new GridPane();
        updateRoot.setPadding(new Insets(10));
        updateRoot.setHgap(10);
        updateRoot.setVgap(10);
        updateRoot.setStyle("-fx-background-color: #E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2;");

        Label statusLabel = new Label("Status");
        statusLabel.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");

        ComboBox<String> statusComboBox = new ComboBox<>();
        statusComboBox.setPrefSize(200, 20);
        statusComboBox.setStyle("-fx-background-color: WHITE;");
        ObservableList<String> statusItems = FXCollections.observableArrayList("Active", "Completed", "Cancelled");
        statusComboBox.setItems(statusItems);

        Button updateOkButton = new Button("OK");
        updateOkButton.setPrefSize(150, 25);
        updateOkButton.setStyle("-fx-background-color: #E2DDF8; -fx-text-fill: #3F2B63; -fx-font-size: 14px; -fx-font-family: Comic Sans MS; -fx-border-width: 2; -fx-border-color: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC; -fx-border-radius: 10; -fx-background-radius: 10;");

        updateRoot.add(statusLabel, 0, 0);
        updateRoot.add(statusComboBox, 1, 0);
        updateRoot.add(updateOkButton, 1, 1);

        Scene updateScene = new Scene(updateRoot, 320, 150);
        form.setScene(updateScene);

        ContractTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            selectedContract = newValue;
        });

        Update.setOnAction(e -> {
            if (selectedContract == null) {
                showAlert("Update Error", "Please select a contract to update.");
                return;
            }

            statusComboBox.setValue(selectedContract.getContractStatus());
            form.show();
        });

        updateOkButton.setOnAction(e -> {
            if (selectedContract != null) {
                selectedContract.setContractStatus(statusComboBox.getValue());
                contractDAO.updateContract(selectedContract);

                contractData.setAll(contractDAO.getAllContracts()); // Refresh the TableView
                form.close();
            }
        });

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

        logOut.setOnAction(e->{
            LoginGUI loginGUI = new LoginGUI();

            loginGUI.start(stage);
            Scene scene3 = logOut.getScene();
            Stage stage2 = (Stage) scene.getWindow();
            stage2.close();




        });

//        DASHBOARD.setOnAction(e -> {
//            mainGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        dealBtn.setOnAction(e -> {
//            signAcontractGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        CustomersBtn.setOnAction(e -> {
//            customerGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        EmployeesBtn.setOnAction(e -> {
//            employeeGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        PaymentsBtn.setOnAction(e -> {
//            paymentGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        MaintenanceBtn.setOnAction(e -> {
//            maintenanceGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        VehiclesBtn.setOnAction(e -> {
//            vehicleGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });
//
//        ContractBtn.setOnAction(e -> {
//            this.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });

//stage.setScene(scene);
  //      stage.setTitle("Contract GUI");
    //    stage.show();
        return scene;
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getContractScene(primaryStage));
        primaryStage.setTitle("Customer GUI");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();
    }
}
