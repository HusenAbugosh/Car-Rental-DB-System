package com.example.projectgui;

import DAO.EmployeeDAO;
import entities.Employee;
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

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class EmployeeGUI extends Application {
private Stage stage2;
    private ObservableList<Employee> employeeData = FXCollections.observableArrayList();
    private EmployeeDAO employeeDAO = new EmployeeDAO();
    private Employee selectedEmployee; // For keeping track of the selected employee

    public static void main(String[] args) {
        launch(args);
    }


    public Scene getEmployeeScene(Stage primaryStage) {
        // Load data from the database
        employeeData.addAll(employeeDAO.getAllEmployees());

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
        Button resetBtn = new Button("Reset");

        HBox current = new HBox();
        current.getChildren().addAll(label, EmployeesBtn);

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
        resetBtn.setPrefSize(150, 40);

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
        resetBtn.setStyle("-fx-background-color: #E2DDF8; " +
                "-fx-text-fill: #3F2B63; " +
                "-fx-font-size: 25px; " +
                "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 50;" +
                "-fx-background-radius: 50;");

        Label space = new Label();
        space.setStyle("-fx-background-color: #3F2B63");
        space.setPrefSize(350, 10);

        Image logo = new Image("/LOGO3.PNG");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(320);
        logoView.setFitHeight(100);

        VBox Menu = new VBox();
        Menu.getChildren().addAll(logoView, space, DASHBOARD, CustomersBtn, current, ContractBtn, PaymentsBtn, MaintenanceBtn, VehiclesBtn, logOut);
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

        DatePicker searchDatePicker = new DatePicker();
        searchDatePicker.setPrefSize(300, 41.2);
        searchDatePicker.setStyle("-fx-background-radius: 20 0 0 20;" + "-fx-background-color: #E2DDF8;" + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2px;" + "-fx-border-radius: 20 0 0 20;");
        searchDatePicker.setVisible(false);

        Image searchimg = new Image(getClass().getResourceAsStream("/searchICON.png"));

        Button searchbtn = new Button("", new ImageView(searchimg));
        searchbtn.setStyle("-fx-background-radius: 0 19 19 0;" + "-fx-background-color: #E2DDF8;" + "-fx-border-color: #3F2B63;" + "-fx-border-radius: 0 19 19 0;");
        searchbtn.setPrefSize(60, 40);

        ComboBox<String> comboBox = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Employee ID", "First Name", "Last Name", "Salary", "Phone", "Gender", "Role", "Address", "Hire Date", "Status"
        );

        comboBox.setItems(items);
        comboBox.setPrefSize(200, 40);
        comboBox.setPromptText("Specify the field..");
        comboBox.setStyle("-fx-background-color: #E2DDF8;" + "-fx-font-family: Comic Sans MS;" + "-fx-font-size: 15px");
        comboBox.setPadding(new Insets(0, 0, 0, 30));

        HBox search = new HBox();
        search.getChildren().addAll(serachBAR, searchbtn);
        search.setAlignment(Pos.CENTER);

        TableView<Employee> employeeTable = new TableView<>();
        employeeTable.setItems(employeeData); // Set the items to the table

        employeeTable.setPrefSize(706, 600);
        employeeTable.setPadding(new Insets(5));

        TableColumn<Employee, String> employeeIDColumn = new TableColumn<>("Employee ID");
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        TableColumn<Employee, Boolean> statusColumn = new TableColumn<>("Active");
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));
        statusColumn.setCellFactory(column -> new TableCell<Employee, Boolean>() {
            @Override
            protected void updateItem(Boolean item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null || empty) {
                    setText(null);
                } else {
                    setText(item ? "Active" : "Inactive");
                }
            }
        });

        TableColumn<Employee, String> firstNameColumn = new TableColumn<>("First Name");
        firstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Employee, String> lastNameColumn = new TableColumn<>("Last Name");
        lastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Employee, Double> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(new PropertyValueFactory<>("salary"));

        TableColumn<Employee, String> phoneColumn = new TableColumn<>("Phone");
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));

        TableColumn<Employee, String> genderColumn = new TableColumn<>("Gender");
        genderColumn.setCellValueFactory(new PropertyValueFactory<>("gender"));

        TableColumn<Employee, String> roleColumn = new TableColumn<>("Role");
        roleColumn.setCellValueFactory(new PropertyValueFactory<>("role"));

        TableColumn<Employee, String> addressColumn = new TableColumn<>("Address");
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Employee, Date> hireDateColumn = new TableColumn<>("Hire Date");
        hireDateColumn.setCellValueFactory(new PropertyValueFactory<>("hireDate"));

        employeeTable.getColumns().addAll(employeeIDColumn, statusColumn, firstNameColumn, lastNameColumn, salaryColumn, phoneColumn, genderColumn, roleColumn, addressColumn, hireDateColumn);

        employeeTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView

        Label Clabel = new Label("Employees");
        Clabel.setPrefSize(500, 70);
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setStyle("-fx-font-family: Helvetica;" + "-fx-font-size: 50;" + "-fx-text-fill: #3F2B63;" + "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;" + "-fx-background-color: TRANSPARENT;");

        Button Insert = new Button("Insert");
        Button Delete = new Button("Delete");
        Button Update = new Button("Update");
        Button Select = new Button("Select");


        comboBox.setOnAction(e -> {
            if ("Hire Date".equals(comboBox.getValue())) {
                search.getChildren().remove(serachBAR);
                search.getChildren().add(0, searchDatePicker);
                searchDatePicker.setVisible(true);
                serachBAR.setVisible(false);
            } else {
                search.getChildren().remove(searchDatePicker);
                search.getChildren().add(0, serachBAR);
                searchDatePicker.setVisible(false);
                serachBAR.setVisible(true);
            }
        });

        searchDatePicker.setOnAction(e -> {
            if (searchDatePicker.getValue() != null) {
                serachBAR.setText(searchDatePicker.getValue().toString());
            }
        });

        searchbtn.setOnAction(e2 -> {
            String searchField = comboBox.getValue();
            String searchContent = serachBAR.getText();

            if (searchField == null || searchField.isEmpty()) {
                showAlert("Search Error", "Please select a search field.");
                return;
            }

            if (searchContent == null || searchContent.isEmpty()) {
                showAlert("Search Error", "Please enter a value to search.");
                return;
            }

            if (searchField.equals("Status")) {
                // Convert "Active" and "Inactive" to boolean values for the search
                if (searchContent.equalsIgnoreCase("Active")) {
                    searchContent = "true";
                } else if (searchContent.equalsIgnoreCase("Inactive")) {
                    searchContent = "false";
                } else {
                    showAlert("Search Error", "Status must be either 'Active' or 'Inactive'.");
                    return;
                }
            }

            List<Employee> foundEmployees = employeeDAO.searchEmployees(searchField, searchContent);
            employeeData.setAll(foundEmployees); // Update the TableView with the search results
        });


        resetBtn.setOnAction(e -> {
            serachBAR.clear();
            searchDatePicker.setValue(null);
            comboBox.setValue(null);
            employeeData.setAll(employeeDAO.getAllEmployees());
        });


        Insert.setPrefSize(150, 40);
        Update.setPrefSize(150, 40);
        Delete.setPrefSize(150, 40);
        Select.setPrefSize(150, 40);

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
        buttons.getChildren().addAll(Insert, Update, resetBtn);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));

        employeeTable.setStyle("-fx-background-color: #E2DDF8;" + "-fx-border-radius: 20;" + "-fx-background-radius: 20;" + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2;" + "-fx-font-size: 14px ");

        employeeIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        firstNameColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        lastNameColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        salaryColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        phoneColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        genderColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        roleColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        addressColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        statusColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        hireDateColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");

        sceneArea.getChildren().addAll(Clabel, search, comboBox, employeeTable, buttons);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setColor(Color.GRAY);
        dropShadow.setRadius(15);
        dropShadow.setOffsetX(5);
        dropShadow.setOffsetY(10);

        employeeTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);

        Stage form = new Stage();
        form.setTitle("Employee Data");
        form.setResizable(false);

        GridPane root = new GridPane();
        Scene scene1 = new Scene(root, 400, 450);
        form.setScene(scene1);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setStyle("-fx-background-color:#E2DDF8; " + "-fx-border-color: #3F2B63;" + "-fx-border-width: 2");

        Label label1 = new Label("Employee ID");
        Label label2 = new Label("First Name");
        Label label3 = new Label("Last Name");
        Label label4 = new Label("Salary");
        Label label5 = new Label("Phone");
        Label label6 = new Label("Role");
        Label label7 = new Label("Gender");
        Label label8 = new Label("Address");
        Label label9 = new Label("Hire Date");
        Label label10 = new Label("Status");
        Label label11 = new Label("Password");

        String labelStyle = "-fx-font-family: 'Arial Rounded MT Bold';" +
                "-fx-font-size: 15px;" + "-fx-text-fill: #3F2B63; " +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;";

        label1.setStyle(labelStyle);
        label2.setStyle(labelStyle);
        label3.setStyle(labelStyle);
        label4.setStyle(labelStyle);
        label5.setStyle(labelStyle);
        label6.setStyle(labelStyle);
        label7.setStyle(labelStyle);
        label8.setStyle(labelStyle);
        label9.setStyle(labelStyle);
        label10.setStyle(labelStyle);
        label11.setStyle(labelStyle);

        TextField employeeIDField = new TextField();
        TextField firstNameField = new TextField();
        TextField lastNameField = new TextField();
        TextField salaryField = new TextField();
        TextField phoneField = new TextField();
        ComboBox<String> roleField = new ComboBox<>(FXCollections.observableArrayList("Sales", "Services", "Marketing", "Manager"));
        ComboBox<String> genderField = new ComboBox<>(FXCollections.observableArrayList("M", "F"));
        TextField addressField = new TextField();
        DatePicker hireDateField = new DatePicker();
        CheckBox statusCheckBox = new CheckBox("Active");
        TextField passwordField = new TextField();

        Button ok = new Button("OK");
        ok.setPrefSize(150, 25);

        ok.setStyle("-fx-background-color: #E2DDF8; " + "-fx-text-fill: #3F2B63; " + "-fx-font-size: 20px; " + "-fx-font-family: Comic Sans MS;" +
                "-fx-border-width: 2;" + "-fx-border-color: #3F2B63;" +
                "-fx-font-weight: BOLD;" + "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 10;" + "-fx-background-radius: 10;");

        root.add(label1, 0, 0);
        root.add(employeeIDField, 1, 0);
        root.add(label2, 0, 1);
        root.add(firstNameField, 1, 1);
        root.add(label3, 0, 2);
        root.add(lastNameField, 1, 2);
        root.add(label4, 0, 3);
        root.add(salaryField, 1, 3);
        root.add(label5, 0, 4);
        root.add(phoneField, 1, 4);
        root.add(label6, 0, 5);
        root.add(roleField, 1, 5);
        root.add(label7, 0, 6);
        root.add(genderField, 1, 6);
        root.add(label8, 0, 7);
        root.add(addressField, 1, 7);
        root.add(label9, 0, 8);
        root.add(hireDateField, 1, 8);
        root.add(label10, 0, 9);
        root.add(statusCheckBox, 1, 9);
        root.add(label11, 0, 10);
        root.add(passwordField, 1, 10);
        root.add(ok, 1, 11);

        Insert.setOnAction(e -> {
            form.show();

            ok.setOnAction(e1 -> {
                String employeeID = employeeIDField.getText();
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String salary = salaryField.getText();
                String phone = phoneField.getText();
                String role = roleField.getValue();
                String gender = genderField.getValue();
                String address = addressField.getText();
                LocalDate hireDate = hireDateField.getValue();
                boolean status = statusCheckBox.isSelected();
                String password = passwordField.getText(); // Get the password

                if (!employeeID.matches("\\d{9}")) {
                    showAlert("Validation Error", "Employee ID must be a 9-digit number.");
                    return;
                }

                if (!firstName.matches("[a-zA-Z]+")) {
                    showAlert("Validation Error", "First Name must contain only characters.");
                    return;
                }

                if (!lastName.matches("[a-zA-Z]+")) {
                    showAlert("Validation Error", "Last Name must contain only characters.");
                    return;
                }

                if (!salary.matches("\\d+")) {
                    showAlert("Validation Error", "Salary must contain only numbers.");
                    return;
                }

                if (!phone.matches("\\d{10}")) {
                    showAlert("Validation Error", "Phone must be a 10-digit number.");
                    return;
                }

                // Check if employee ID already exists
                if (employeeDAO.employeeIDExists(employeeID)) {
                    showAlert("Validation Error", "Employee ID already exists.");
                    return;
                }

                Employee newEmployee = new Employee(
                        employeeID,
                        firstName,
                        lastName,
                        Double.parseDouble(salary),
                        phone,
                        gender,
                        role,
                        address,
                        hireDate != null ? Date.valueOf(hireDate) : null,
                        status,
                        password // Set the password
                );

                // Insert into the database using DAO
                employeeDAO.insertEmployee(newEmployee);

                // Update the TableView
                employeeData.add(newEmployee);
                form.close();
            });
        });


        Update.setOnAction(e -> {
            selectedEmployee = employeeTable.getSelectionModel().getSelectedItem();
            if (selectedEmployee == null) {
                showAlert("Update Error", "Please select an employee to update.");
                return;
            }

            // Populate form fields with selected employee data
            employeeIDField.setText(String.valueOf(selectedEmployee.getEmployeeID()));
            firstNameField.setText(selectedEmployee.getFirstName());
            lastNameField.setText(selectedEmployee.getLastName());
            salaryField.setText(String.valueOf(selectedEmployee.getSalary()));
            phoneField.setText(selectedEmployee.getPhone());
            roleField.setValue(selectedEmployee.getRole());
            genderField.setValue(selectedEmployee.getGender());
            addressField.setText(selectedEmployee.getAddress());
            hireDateField.setValue(selectedEmployee.getHireDate() != null ? selectedEmployee.getHireDate().toLocalDate() : null);
            statusCheckBox.setSelected(selectedEmployee.getStatus());
            passwordField.setVisible(false);
            label11.setVisible(false);

            // Disable Employee ID field as it should not be changed
            employeeIDField.setDisable(true);

            form.show();

            ok.setOnAction(e1 -> {
                String firstName = firstNameField.getText();
                String lastName = lastNameField.getText();
                String salary = salaryField.getText();
                String phone = phoneField.getText();
                String address = addressField.getText();
                boolean status = statusCheckBox.isSelected();

                if (!firstName.matches("[a-zA-Z]+")) {
                    showAlert("Validation Error", "First Name must contain only characters.");
                    return;
                }

                if (!lastName.matches("[a-zA-Z]+")) {
                    showAlert("Validation Error", "Last Name must contain only characters.");
                    return;
                }

                if (!salary.matches("\\d+")) {
                    showAlert("Validation Error", "Salary must contain only numbers.");
                    return;
                }

                if (!phone.matches("\\d{10}")) {
                    showAlert("Validation Error", "Phone must be a 10-digit number.");
                    return;
                }

                // Update employee details
                selectedEmployee.setFirstName(firstName);
                selectedEmployee.setLastName(lastName);
                selectedEmployee.setSalary(Double.parseDouble(salary));
                selectedEmployee.setPhone(phone);
                selectedEmployee.setAddress(address);
                selectedEmployee.setStatus(status);

                // Update in the database using DAO
                employeeDAO.updateEmployee(selectedEmployee);

                // Refresh the TableView
                employeeTable.refresh();
                form.close();
            });
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
//            contractGUI.start(stage);
//            Stage stage2 = (Stage) scene.getWindow();
//            stage2.close();
//        });


       // stage.setScene(scene);
        //stage.setTitle("Employee GUI");
        //stage.show();
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

        primaryStage.setScene(getEmployeeScene(primaryStage));
        primaryStage.setTitle("Customer GUI");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();
    }
}
