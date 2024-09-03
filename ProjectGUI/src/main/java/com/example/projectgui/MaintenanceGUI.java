package com.example.projectgui;

import entities.Maintenance;
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
import  DAO.MaintenanceDAO;
import  DAO.VehicleDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import entities.Connector;

public class MaintenanceGUI extends Application {
    private Stage stage2;

    private ArrayList<Maintenance> data;
    private ObservableList<Maintenance> dataList;
    private MaintenanceDAO maintenanceDAO;
    private VehicleDAO vehicleDAO;



    public static void main(String[] args) {
        launch(args);
    }

    public Scene getMaintenanceScene(Stage primaryStage) {
        data = new ArrayList<>();
        //  VBox vBox =null;
        maintenanceDAO = new MaintenanceDAO();
        vehicleDAO=new VehicleDAO();

        try {
            data = maintenanceDAO.getData();
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

        current.getChildren().addAll(label, MaintenanceBtn);

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
        Menu.getChildren().addAll(logoView, space, DASHBOARD, CustomersBtn, EmployeesBtn, ContractBtn, PaymentsBtn, current, VehiclesBtn, logOut);
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
                "Receipt ID", "Vehicle ID", "Description", "Cost", "Company Email", "Date", "Employee ID"

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


        TableView<Maintenance> maintenanceTable = new TableView<>();
        maintenanceTable.setPrefSize(706, 600);
        maintenanceTable.setPadding(new Insets(5));


        TableColumn<Maintenance, Integer> receiptIDColumn = new TableColumn<>("Receipt ID");
        receiptIDColumn.setCellValueFactory(new PropertyValueFactory<>("receiptID"));

        TableColumn<Maintenance, Integer> vehicleIDColumn = new TableColumn<>("Vehicle ID");
        vehicleIDColumn.setCellValueFactory(new PropertyValueFactory<>("vehicleID"));

        TableColumn<Maintenance, String> descriptionColumn = new TableColumn<>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Maintenance, Double> costColumn = new TableColumn<>("Cost");
        costColumn.setCellValueFactory(new PropertyValueFactory<>("cost"));


        TableColumn<Maintenance, String> companyEmailColumn = new TableColumn<>("company Email");
        companyEmailColumn.setCellValueFactory(new PropertyValueFactory<>("companyEmail"));

        TableColumn<Maintenance, Date> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Maintenance, Integer> employeeIDColumn = new TableColumn<>("Employee ID");
        employeeIDColumn.setCellValueFactory(new PropertyValueFactory<>("employeeID"));

        // Add columns to TableView
        maintenanceTable.getColumns().addAll(receiptIDColumn, vehicleIDColumn, descriptionColumn,
                costColumn, companyEmailColumn, dateColumn, employeeIDColumn);


        maintenanceTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView
        Label Clabel = new Label("Maintenance");
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
        Button Delete = new Button("Delete");
        Button Update = new Button("Update");
        Button Stats = new Button("Stats");

        Insert.setPrefSize(150, 40);
        Update.setPrefSize(150, 40);
        Delete.setPrefSize(150, 40);
        Stats.setPrefSize(150, 40);


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

        Delete.setStyle("-fx-background-color: #E2DDF8; " + // Background color
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

        Stats.setStyle("-fx-background-color: #E2DDF8; " + // Background color
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
        Button Refresh = new Button("Refresh");
        Refresh.setPrefSize(150, 40);
        Refresh.setStyle("-fx-background-color: #E2DDF8; " + // Background color
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
                "-fx-background-radius:50;");//

        HBox buttons = new HBox();
        buttons.getChildren().addAll(Insert, Update, Refresh, Stats);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));

        maintenanceTable.setStyle("-fx-background-color: #E2DDF8;" +
                "-fx-border-radius: 20;" +
                "-fx-background-radius: 20;" +
                "-fx-border-color: #3F2B63;" +
                "-fx-border-width: 2;" +
                "-fx-font-size: 14px ");

        receiptIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        vehicleIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        descriptionColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        costColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        dateColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        employeeIDColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");
        companyEmailColumn.setStyle("-fx-background-color: #E2DDF8;" + "-fx-text-fill: BLACK;" + "-fx-alignment: CENTER;" + "-fx-font-family: Comic Sans MS;");

        // GP1.setStyle("-fx-border-color: BLACK;" + "-fx-border-width: 20;");

        sceneArea.getChildren().addAll(Clabel, search, comboBox, maintenanceTable, buttons);
        maintenanceTable.setItems(dataList);

        maintenanceTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        maintenanceTable.setRowFactory(MT -> {
            TableRow<Maintenance> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    int index = row.getIndex();
                    if (maintenanceTable.getSelectionModel().isSelected(index)) {
                        maintenanceTable.getSelectionModel().clearSelection(index);
                    } else {
                        maintenanceTable.getSelectionModel().select(index);

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

        maintenanceTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);


        Stage form = new Stage();
        form.setTitle("Maintenance Data");
        form.setResizable(false);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setStyle("-fx-background-color: #E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2;");

        // Label label1 = new Label("Receipt ID");
        Label label2 = new Label("Vehicle ID");
        Label label3 = new Label("Description");
        Label label4 = new Label("Cost");
        Label label8 = new Label("Company Email");
        Label label6 = new Label("Date");
        Label label7 = new Label("Employee ID");

        //  label1.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label2.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label3.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label4.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label6.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label7.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label8.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        // TextField receiptIDField = new TextField();
        TextField vehicleIDField = new TextField();
        TextField descriptionField = new TextField();
        TextField costField = new TextField();
        DatePicker dateField = new DatePicker(LocalDate.now());
        dateField.setEditable(false);

        TextField employeeIDField = new TextField();
        TextField companyEmailField = new TextField();

        Button ok = new Button("OK");
        ok.setPrefSize(150, 25);
        ok.setStyle("-fx-background-color: #E2DDF8; -fx-text-fill: #3F2B63; -fx-font-size: 20px; -fx-font-family: Comic Sans MS; -fx-border-width: 2; -fx-border-color: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC; -fx-border-radius: 10; -fx-background-radius: 10;");

        //root.add(label1, 0, 0);
        //  root.add(receiptIDField, 1, 0);
        root.add(label2, 0, 0);
        root.add(vehicleIDField, 1, 0);
        root.add(label3, 0, 1);
        root.add(descriptionField, 1, 1);
        root.add(label4, 0, 2);
        root.add(costField, 1, 2);
//        root.add(label5, 0, 3);
//        root.add(companyNameField, 1, 3);
        root.add(label6, 0, 3);
        root.add(dateField, 1, 3);
        root.add(label7, 0, 4);
        root.add(employeeIDField, 1, 4);
        root.add(label8, 0, 5);
        root.add(companyEmailField, 1, 5);
        root.add(ok, 1, 7);

        Stage form2 = new Stage();
        form2.setTitle("Maintenance Data");
        form2.setResizable(false);

        GridPane root2 = new GridPane();
        root2.setPadding(new Insets(10));
        root2.setHgap(10);
        root2.setVgap(10);
        root2.setStyle("-fx-background-color: #E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2;");

        // Label label1 = new Label("Receipt ID");
        Label label2u = new Label("Vehicle ID");
        Label label3u = new Label("Description");
        Label label4u = new Label("Cost");
        Label label8u = new Label("Company Email");
        Label label6u = new Label("Date");
        Label label7u = new Label("Employee ID");

        //  label1.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label2u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label3u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label4u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label6u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label7u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label8u.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        // TextField receiptIDField = new TextField();
        TextField vehicleIDField2 = new TextField();
        TextField descriptionField2 = new TextField();
        TextField costField2 = new TextField();
        DatePicker dateField2 = new DatePicker();
        dateField2.setEditable(false);
        TextField employeeIDField2 = new TextField();
        TextField companyEmailField2 = new TextField();

        Button ok2 = new Button("update");
        ok2.setPrefSize(150, 25);
        ok2.setStyle("-fx-background-color: #E2DDF8; -fx-text-fill: #3F2B63; -fx-font-size: 20px; -fx-font-family: Comic Sans MS; -fx-border-width: 2; -fx-border-color: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC; -fx-border-radius: 10; -fx-background-radius: 10;");

        //root.add(label1, 0, 0);
        //  root.add(receiptIDField, 1, 0);
        root2.add(label2u, 0, 0);
        root2.add(vehicleIDField2, 1, 0);
        root2.add(label3u, 0, 1);
        root2.add(descriptionField2, 1, 1);
        root2.add(label4u, 0, 2);
        root2.add(costField2, 1, 2);
//        root.add(label5, 0, 3);
//        root.add(companyNameField, 1, 3);
        root2.add(label6u, 0, 3);
        root2.add(dateField2, 1, 3);
        root2.add(label7u, 0, 4);
        root2.add(employeeIDField2, 1, 4);
        root2.add(label8u, 0, 5);
        root2.add(companyEmailField2, 1, 5);
        root2.add(ok2, 1, 7);

        Scene scene1 = new Scene(root, 330, 320);
        form.setScene(scene1);
        Scene sceneUP = new Scene(root2, 330, 320);
        form2.setScene(sceneUP);


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

//        /*dealBtn.setOnAction(e -> {
//            // Get the button's scene
//            signAcontractGUI.start(stage);
//            Scene scene3 = dealBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });*/
//
//
//
//       /* DASHBOARD.setOnAction(e -> {
//            // Get the button's scene
//            mainGUI.start(stage);
//            Scene scene2 = DASHBOARD.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//        dealBtn.setOnAction(e -> {
//            // Get the button's scene
//            signAcontractGUI.start(stage);
//            Scene scene3 = dealBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//
//        CustomersBtn.setOnAction(e -> {
//            // Get the button's scene
//            customerGUI.start(stage);
//            Scene scene2 = CustomersBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//        EmployeesBtn.setOnAction(e -> {
//            // Get the button's scene
//            employeeGUI.start(stage);
//            Scene scene2 = EmployeesBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//
//        PaymentsBtn.setOnAction(e -> {
//            // Get the button's scene
//            paymentGUI.start(stage);
//            Scene scene2 = PaymentsBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//
//        MaintenanceBtn.setOnAction(e -> {
//            // Get the button's scene
//            maintenanceGUI.start(stage);
//            Scene scene2 = MaintenanceBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//
//        VehiclesBtn.setOnAction(e -> {
//            // Get the button's scene
//            vehicleGUI.start(stage);
//            Scene scene2 = VehiclesBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });
//
//
//        ContractBtn.setOnAction(e -> {
//            // Get the button's scene
//            contractGUI.start(stage);
//            Scene scene2 = ContractBtn.getScene();
//
//            // Get the stage from the scene
//            Stage stage2 = (Stage) scene.getWindow();
//
//            // Close the stage
//            stage2.close();
//
//        });*/


        Update.setOnAction(e4 -> {
            Maintenance selected = maintenanceTable.getSelectionModel().getSelectedItem();

            if (selected != null) {
                form2.show();
                vehicleIDField2.setText(Integer.toString(selected.getVehicleID()));
                descriptionField2.setText(selected.getDescription());
                costField2.setText(Double.toString(selected.getCost()));
                //String formattedDate = selected.getDate().toString();
                dateField2.setValue(selected.getDate());
                employeeIDField2.setText(Integer.toString(selected.getEmployeeID()));
                companyEmailField2.setText(selected.getCompanyEmail());

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected row");
                alert.setHeaderText(null);
                alert.setContentText("You must select a row first !!");
                alert.showAndWait();
            }

            ok2.setOnAction(e1 -> {
                // String receiptID = receiptIDField.getText();
                boolean err = false;
                String vehicleID = vehicleIDField2.getText();
                if (vehicleIDField2.getText().equals("")) {
                    Alert emptyVID2 = new Alert(Alert.AlertType.ERROR);
                    emptyVID2.setTitle("empty field");
                    emptyVID2.setHeaderText(null);
                    emptyVID2.setContentText("vehicle Id field is empty!!!");
                    emptyVID2.showAndWait();
                    err = true;
                } else if (!isInteger(vehicleID)) {
                    Alert invalidVId = new Alert(Alert.AlertType.ERROR);
                    invalidVId.setTitle("invalid vehicle Id");
                    invalidVId.setHeaderText(null);
                    invalidVId.setContentText("vehicle id must be an integer!!!");
                    invalidVId.showAndWait();
                    err = true;
                } else {
                    try {
                        if (!maintenanceDAO.doesCarExist(Integer.parseInt(vehicleID))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("invalid Id");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("there are no vehicle with this id !!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                // String description = descriptionField2.getText();
                String cost = costField2.getText();
                if (costField2.getText().equals("")) {
                    Alert emptyc2 = new Alert(Alert.AlertType.ERROR);
                    emptyc2.setTitle("empty field");
                    emptyc2.setHeaderText(null);
                    emptyc2.setContentText("cost field is empty!!!");
                    emptyc2.showAndWait();
                    err = true;
                } else if (!isDouble(cost)) {
                    Alert invalidCost = new Alert(Alert.AlertType.ERROR);
                    invalidCost.setTitle("invalid Cost");
                    invalidCost.setHeaderText(null);
                    invalidCost.setContentText("Cost must be a double !!");
                    invalidCost.showAndWait();
                    err = true;

                }
                if (descriptionField2.getText().equals("")) {
                    Alert emptyd = new Alert(Alert.AlertType.ERROR);
                    emptyd.setTitle("empty field");
                    emptyd.setHeaderText(null);
                    emptyd.setContentText("description field is empty!!!");
                    emptyd.showAndWait();
                    err = true;
                }

                String employeeID = employeeIDField2.getText();
                if (employeeIDField2.getText().equals("")) {
                    Alert emptyE = new Alert(Alert.AlertType.ERROR);
                    emptyE.setTitle("empty field");
                    emptyE.setHeaderText(null);
                    emptyE.setContentText("employee id field is empty!!!");
                    emptyE.showAndWait();
                    err = true;
                } else if (!isValidId(employeeID)) {
                    Alert invalidId = new Alert(Alert.AlertType.ERROR);
                    invalidId.setTitle("invalid Id");
                    invalidId.setHeaderText(null);
                    invalidId.setContentText("Employee id must be 9 digits");
                    invalidId.showAndWait();
                    err = true;

                } else {
                    try {
                        if (!maintenanceDAO.doesEmpExist(Integer.parseInt(employeeID))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("invalid Id");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("there are no employee with this id !!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                }
                String email = companyEmailField2.getText();
                if (companyEmailField2.getText().equals("")) {
                    Alert emptyEm = new Alert(Alert.AlertType.ERROR);
                    emptyEm.setTitle("empty field");
                    emptyEm.setHeaderText(null);
                    emptyEm.setContentText("Email field is empty!!!");
                    emptyEm.showAndWait();
                    err = true;
                } else if (!isValidEmail(email)) {
                    Alert invalidFormat = new Alert(Alert.AlertType.ERROR);
                    invalidFormat.setTitle("invalid email format");
                    invalidFormat.setHeaderText(null);
                    invalidFormat.setContentText("Email format is string@string.com !!");
                    invalidFormat.showAndWait();
                    err = true;

                }
                if (!isAfterOpening(dateField2.getValue())) {
                    Alert invalidDate = new Alert(Alert.AlertType.ERROR);
                    invalidDate.setTitle("invalid Date");
                    invalidDate.setHeaderText(null);
                    invalidDate.setContentText("Date must not be before the year 2022 !!");
                    invalidDate.showAndWait();
                    err = true;
                }
                if (!err) {
                    if (!Integer.toString(selected.getVehicleID()).equals(vehicleIDField2.getText()))
                        maintenanceDAO.updateVehicleID(selected.getReceiptID(), Integer.parseInt(vehicleIDField2.getText()));
                    if (!selected.getDescription().equals(descriptionField2.getText()))
                        maintenanceDAO.updateDescription(selected.getReceiptID(), descriptionField2.getText());
                    if (!Double.toString(selected.getCost()).equals(costField2.getText()))
                        maintenanceDAO.updateCost(selected.getReceiptID(), Double.parseDouble(costField2.getText()));
                    if (!Integer.toString(selected.getEmployeeID()).equals(employeeIDField2.getText()))
                        maintenanceDAO.updateEmployeeID(selected.getReceiptID(), Integer.parseInt(employeeIDField2.getText()));
                    if (!selected.getCompanyEmail().equals(companyEmailField2.getText()))
                        maintenanceDAO.updateCompanyEmail(selected.getReceiptID(), companyEmailField2.getText());
                    if (!selected.getDate().equals(dateField2.getValue()))
                        maintenanceDAO.updateMaintenanceDate(selected.getReceiptID(), dateField2.getValue());
                    selected.setCost(Double.parseDouble(costField2.getText()));
                    selected.setDescription(descriptionField2.getText());
                    selected.setVehicleID(Integer.parseInt(vehicleIDField2.getText()));
                    selected.setCompanyEmail(companyEmailField2.getText());
                    selected.setEmployeeID(Integer.parseInt(employeeIDField2.getText()));
                    selected.setDate(dateField2.getValue());
                    maintenanceTable.refresh();
                    Alert doneUp = new Alert(Alert.AlertType.INFORMATION);
                    doneUp.setTitle("record updated");
                    doneUp.setHeaderText(null);
                    doneUp.setContentText("Record updated successfully :)");
                    doneUp.showAndWait();
                    form2.close();

                }

            });

        });

        //////////////////////////////////////////// Insert part

        Insert.setOnAction(e -> {

            form.show();


            ok.setOnAction(e1 -> {
                boolean err = false;
                String vehicleID = vehicleIDField.getText();
                if (vehicleIDField.getText().equals("")) {
                    Alert emptyVID = new Alert(Alert.AlertType.ERROR);
                    emptyVID.setTitle("empty field");
                    emptyVID.setHeaderText(null);
                    emptyVID.setContentText("vehicle Id field is empty!!!");
                    emptyVID.showAndWait();
                    err = true;
                } else if (!isInteger(vehicleID)) {
                    Alert invalidVId = new Alert(Alert.AlertType.ERROR);
                    invalidVId.setTitle("invalid vehicle Id");
                    invalidVId.setHeaderText(null);
                    invalidVId.setContentText("vehicle id must be an integer!!!");
                    invalidVId.showAndWait();
                    err = true;
                } else {
                    try {
                        if (!maintenanceDAO.doesCarExist(Integer.parseInt(vehicleID))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("invalid Id");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("there are no vehicle with this id !!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                // String description = descriptionField2.getText();
                String cost = costField.getText();
                if (!isAfterOpening(dateField.getValue())) {
                    Alert invalidDate2 = new Alert(Alert.AlertType.ERROR);
                    invalidDate2.setTitle("invalid Date");
                    invalidDate2.setHeaderText(null);
                    invalidDate2.setContentText("Date must not be before the year 2022 !!");
                    invalidDate2.showAndWait();
                    err = true;
                }
                if (costField.getText().equals("")) {
                    Alert emptyC = new Alert(Alert.AlertType.ERROR);
                    emptyC.setTitle("empty field");
                    emptyC.setHeaderText(null);
                    emptyC.setContentText("cost field is empty!!!");
                    emptyC.showAndWait();
                    err = true;
                } else if (!isDouble(cost)) {
                    Alert invalidCost = new Alert(Alert.AlertType.ERROR);
                    invalidCost.setTitle("invalid Cost");
                    invalidCost.setHeaderText(null);
                    invalidCost.setContentText("Cost must be a double !!");
                    invalidCost.showAndWait();
                    err = true;

                }
                // String date = dateField2.getText();
                String employeeID = employeeIDField.getText();
                if (employeeID.equals("")) {
                    Alert emptyemp = new Alert(Alert.AlertType.ERROR);
                    emptyemp.setTitle("empty field");
                    emptyemp.setHeaderText(null);
                    emptyemp.setContentText("employee Id field is empty!!!");
                    emptyemp.showAndWait();
                    err = true;
                } else if (!isValidId(employeeID)) {
                    Alert invalidId = new Alert(Alert.AlertType.ERROR);
                    invalidId.setTitle("invalid Id");
                    invalidId.setHeaderText(null);
                    invalidId.setContentText("Employee id must be 9 digits");
                    invalidId.showAndWait();
                    err = true;

                } else {
                    try {
                        if (!maintenanceDAO.doesEmpExist(Integer.parseInt(employeeID))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("invalid Id");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("there are no employee with this id !!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                if (descriptionField.getText().equals("")) {
                    Alert emptyD = new Alert(Alert.AlertType.ERROR);
                    emptyD.setTitle("empty field");
                    emptyD.setHeaderText(null);
                    emptyD.setContentText("Description field is empty!!!");
                    emptyD.showAndWait();
                    err = true;
                }
                String email = companyEmailField.getText();
                if (email.equals("")) {
                    Alert emptyE = new Alert(Alert.AlertType.ERROR);
                    emptyE.setTitle("empty field");
                    emptyE.setHeaderText(null);
                    emptyE.setContentText("Email field is empty!!!");
                    emptyE.showAndWait();
                    err = true;
                } else if (!isValidEmail(email)) {
                    Alert invalidFormat = new Alert(Alert.AlertType.ERROR);
                    invalidFormat.setTitle("invalid email format");
                    invalidFormat.setHeaderText(null);
                    invalidFormat.setContentText("Email format is string@string.com !!");
                    invalidFormat.showAndWait();
                    err = true;

                }
                if (!err) {
                    try {
                        Maintenance m = new Maintenance(Integer.parseInt(vehicleIDField.getText()),
                                Integer.parseInt(employeeIDField.getText()),
                                Double.parseDouble(costField.getText()),
                                descriptionField.getText(),
                                companyEmailField.getText(),
                                dateField.getValue());
                        if (maintenanceDAO.insertMaintenance(m)) {
                            dataList.add(m);
                            Alert Added = new Alert(Alert.AlertType.INFORMATION);
                            Added.setTitle("insert completed");
                            Added.setHeaderText(null);
                            Added.setContentText("new record has been inserted :)");
                            Added.showAndWait();
                            vehicleDAO.updateVehicles_Status(Integer.parseInt(vehicleIDField.getText()),"At maintenance");
                            vehicleIDField.setText("");
                            employeeIDField.setText("");
                            descriptionField.setText("");
                            dateField.setValue(LocalDate.now());
                            costField.setText("");
                            companyEmailField.setText("");
                            form.close();
                        }

                    } catch (Exception e2) {
                        Connector.showAlert("Error", e2.getMessage());
                    }

                }
            });
        });
        Delete.setOnAction(e -> {
            Maintenance selected = maintenanceTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO);
                confirmDelete.setTitle("Confirm Deletion");
                confirmDelete.setHeaderText(null);
                Optional<ButtonType> choose = confirmDelete.showAndWait();
                if (choose.isPresent() && choose.get() == ButtonType.YES) {
                    try {
                        maintenanceDAO.deleteRow(selected);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    dataList.remove(selected);
                    maintenanceTable.refresh();
                    Alert Deleted = new Alert(Alert.AlertType.INFORMATION, "Maintenance Record deleted successfully.");
                    Deleted.setHeaderText(null);
                    Deleted.showAndWait();

                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected row");
                alert.setHeaderText(null);
                alert.setContentText("You must select a row first !!");
                alert.showAndWait();
            }
        });

        ////////////////////////////// search part
        Refresh.setOnAction(e -> {
            try {
                data = maintenanceDAO.getData();
                dataList = FXCollections.observableArrayList(data);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            maintenanceTable.setItems(dataList);
            maintenanceTable.refresh();
            serachBAR.setText("");
        });
        Stats.setOnAction(e -> {
            double totalMonth = maintenanceDAO.TotalRepairsCostLastMonth();
            int totalMonthTimes = maintenanceDAO.TotalRepairsLastMonth();
            System.out.println(totalMonth);
            System.out.println(totalMonthTimes);
            double totalYear = maintenanceDAO.TotalRepairsCostLastYear();
            int totalYearTimes = maintenanceDAO.TotalRepairsLastYear();
            System.out.println("totalYearTimes = " + totalYearTimes);
            System.out.println("totalYear = " + totalYear);
            int MOSTID = maintenanceDAO.mostRepairedCar();
            double carRepairCost=maintenanceDAO.mostRepairedCarBill(MOSTID);
            System.out.println(MOSTID);
            System.out.println(carRepairCost);
            Vehicle mostRepairedCar = null;

            mostRepairedCar = maintenanceDAO.selectAcar(MOSTID);
            System.out.println(mostRepairedCar.toString());
            int totalNumRe = maintenanceDAO.TotalRepairsAllTime();
            double totalCost = maintenanceDAO.TotalRepairsCostAllTime();
            System.out.println(totalCost);
            System.out.println(totalNumRe);
            String CEMAIL = maintenanceDAO.CompanyWithMostRepairs();
            System.out.println(CEMAIL);
            double COMPtotal = maintenanceDAO.CompanyRepairsCost(CEMAIL);
            System.out.println(COMPtotal);
            int compNum = maintenanceDAO.CompanyNumberOFRepairs(CEMAIL);
            System.out.println(compNum);
            Stage formStat = new Stage();
            formStat.setTitle("Maintenance Stats");
            formStat.setResizable(false);

            GridPane rootStat = new GridPane();
            rootStat.setPrefWidth(250);
            Scene scene1stat = new Scene(rootStat, 325, 680);
            formStat.setScene(scene1stat);
            rootStat.setPadding(new Insets(10));
            rootStat.setHgap(10);
            rootStat.setVgap(10);
            rootStat.setStyle("-fx-background-color:#E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2");


            VBox statsBox = new VBox();
            statsBox.setSpacing(10);
            statsBox.setPadding(new Insets(10));
            statsBox.setAlignment(Pos.TOP_CENTER); // Align the content at the top but centered horizontally

            Label LastMonthStatsLabel = new Label("Last month stats");
            LastMonthStatsLabel.setStyle(
                    "-fx-text-fill: #3F2B63; " +
                            "-fx-font-size: 25px; " +
                            "-fx-font-family: 'Comic Sans MS';" +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);"
            );

            Label LastMonthStats;

            LastMonthStats = new Label("Total Repairs: " + totalMonthTimes + "\nTotal Cost: " + totalMonth + "$");

            LastMonthStats.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" + "-fx-font-weight: bold; ");

            Label lastYear = new Label("Last year stats");
            lastYear.setStyle(
                    "-fx-text-fill: #3F2B63; " +
                            "-fx-font-size: 25px; " +
                            "-fx-font-family: 'Comic Sans MS';" +
                            "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);"
            );

            Label lastYearStats;
            lastYearStats = new Label("Total Repairs: " + totalYearTimes + "\nTotal Cost: " + totalYear + "$");

            lastYearStats.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-font-weight: bold; ");

            Label allTime = new Label("All Time stats");
            allTime.setStyle("-fx-text-fill: #3F2B63; " +
                    "-fx-font-size: 25px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);");

            Label allTimesStats;

            allTimesStats = new Label("Total Repairs: " + totalNumRe + "\nTotal Cost: " + totalCost + "$");

            allTimesStats.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" + "-fx-font-weight: bold; ");

            Label MostrepairedLabel = new Label("Most Repaired Car");
            MostrepairedLabel.setStyle("-fx-text-fill: #3F2B63; " +
                    "-fx-font-size: 25px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);");

            Label repairedStats;
            if (mostRepairedCar != null) {
                repairedStats = new Label("Vehicle ID:" + mostRepairedCar.getVehicleID() +
                        "\nModel:" + mostRepairedCar.getModel() +
                        "\nyear:" + mostRepairedCar.getYear() +
                        "\ncolor:" + mostRepairedCar.getColor() +
                        "\nDaily rent: " + mostRepairedCar.getDailyRent() + "$" +
                        "\nNumber of times Repaired:" + mostRepairedCar.getNumberOfPassengers()+"\nTotal Repair Cost: "+carRepairCost+"$");
            } else {
                repairedStats = new Label("N/A");
            }
            repairedStats.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" + "-fx-font-weight: bold; ");

            Label mostRepairngCompany = new Label("Most Contacted Company");
            mostRepairngCompany.setStyle("-fx-text-fill: #3F2B63; " +
                    "-fx-font-size: 25px; " +
                    "-fx-font-family: 'Comic Sans MS';" +
                    "-fx-effect: dropshadow(gaussian, rgba(0, 0, 0, 0.75), 4, 0.0, 2, 2);");

            Label mostRepairngCompanystats;

            mostRepairngCompanystats = new Label("Company: "+CEMAIL+"\nNumber of Repairs: "+ compNum+"\nTotal cost: "+ COMPtotal+"$");

            mostRepairngCompanystats.setStyle("-fx-text-fill: #000000; " +
                    "-fx-font-size: 16px; " +
                    "-fx-font-family: 'Comic Sans MS';" + "-fx-font-weight: bold; ");


            rootStat.add(LastMonthStatsLabel, 0, 0);
            rootStat.add(LastMonthStats, 0, 1);
            rootStat.add(lastYear, 0, 2);
            rootStat.add(lastYearStats, 0, 3);
            rootStat.add(allTime, 0, 4);
            rootStat.add(allTimesStats, 0, 5);
            rootStat.add(MostrepairedLabel, 0, 6);
            rootStat.add(repairedStats, 0, 7);
            rootStat.add(mostRepairngCompany,0,8);
            rootStat.add(mostRepairngCompanystats,0,9);


            rootStat.setAlignment(Pos.TOP_CENTER); // Align the root content at the top but centered horizontally
            rootStat.add(statsBox, 0, 0);
            formStat.show();
        });


        searchbtn.setOnAction(e2 -> {
            String searchContent = serachBAR.getText();
            String field = comboBox.getValue();
            if (field != null && !searchContent.trim().isEmpty()) {
                String dbField;
                switch (field) {
                    case "Receipt ID":
                        dbField = "Receipt_ID";
                        break;
                    case "Vehicle ID":
                        dbField = "Vehicle_ID";
                        break;
                    case "Description":
                        dbField = "Description";
                        break;
                    case "Cost":
                        dbField = "Cost";
                        break;
                    case "Company Email":
                        dbField = "Company_Email";
                        break;
                    case "Date":
                        dbField = "Date";
                        break;
                    case "Employee ID":
                        dbField = "Employee_ID";
                        break;
                    default:
                        dbField = "";
                        break;
                }
                List<Maintenance> searchResults = maintenanceDAO.searchMaintenace(dbField, searchContent);
                dataList.setAll(searchResults);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Search");
                alert.setHeaderText(null);
                alert.setContentText("Please specify a field and enter a search term.");
                alert.showAndWait();
            }
        });

        logOut.setOnAction(e->{
            LoginGUI loginGUI = new LoginGUI();

            loginGUI.start(stage);
            Scene scene3 = logOut.getScene();
            Stage stage2 = (Stage) scene.getWindow();
            stage2.close();




        });

        // stage.setScene(scene);
        //stage.setTitle("Maintenance GUI");
        // stage.show();
        return scene;



    }


    public boolean isValidId(String ID) {
        return ID.matches("\\d{9}");
    }


    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidEmail(String email) {
        return email.matches("[^@]+@[^@]+\\.com");
    }

    public static boolean isAfterOpening(LocalDate date) {
        LocalDate opening = LocalDate.of(2022, 1, 1);
        return !date.isBefore(opening);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getMaintenanceScene(primaryStage));
        primaryStage.setTitle("Middle East Car Rental");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();
    }

}
