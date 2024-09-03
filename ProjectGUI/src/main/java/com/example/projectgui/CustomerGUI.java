package com.example.projectgui;

import entities.Customer;
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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;
import entities.Connector;


import java.util.ArrayList;

public class CustomerGUI extends Application {
    private Stage stage2;


    private ArrayList<Customer> data;
    private ObservableList<Customer> dataList;
    ObservableList<Customer> customerData = FXCollections.observableArrayList();


    public static void main(String[] args) {
        launch(args);
    }


    public Scene getCustomerScene(Stage primaryStage) {

        data = new ArrayList<>();
        //  VBox vBox =null;
        try {

            getData();

            dataList = FXCollections.observableArrayList(data);


            // vBox = tableView();


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
        label.setPrefSize(10,90);

        Button CustomersBtn = new Button(" Customers ", new ImageView(CustomerICON));
        Button ContractBtn = new Button(" Contract  ", new ImageView(contractICON));
        Button PaymentsBtn = new Button(" Payments", new ImageView(paymentICON));
        Button EmployeesBtn = new Button(" Employees", new ImageView(EMPICON));
        Button MaintenanceBtn = new Button(" Maintenance" , new ImageView(maintenanceICON));
        Button VehiclesBtn = new Button(" Vehicles   ", new ImageView(carICON));
        Button DASHBOARD = new Button("DashBoard" ,new ImageView(DBICON));
        Button BackBtn = new Button("Back To Main Page");
        Button logOut = new Button(" Log Out  ", new ImageView(LOICON));
        Button dealBtn = new Button(" Make a Deal",new ImageView(dealICON));


        HBox current = new HBox();

        current.getChildren().addAll(label,CustomersBtn);

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
        space.setPrefSize(350,30);


        Image logo = new Image("/LOGO3.PNG");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(320);
        logoView.setFitHeight(100);


        VBox Menu = new VBox();
        Menu.getChildren().addAll(logoView,space,DASHBOARD,current,EmployeesBtn,ContractBtn,PaymentsBtn,MaintenanceBtn,VehiclesBtn,logOut);
        // Menu.setSpacing(3);
        Menu.setPadding(new Insets(30,0,250,0));
        Menu.setStyle("-fx-background-color: #3F2B63 ");
        Menu.setPrefSize(320,250);

        VBox sceneArea = new VBox();
        sceneArea.setStyle("-fx-background-color: #FFFFFF;");
        sceneArea.setSpacing(30);
        sceneArea.setPadding(new Insets(20));

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
        GP1.getColumnConstraints().addAll(column1,column2);
        GP1.setBackground(new Background(new BackgroundFill(Color.web("#FFFFFF"), null, null)));
        GP1.add(Menu,0,0);


        TextField serachBAR =new TextField();
        serachBAR.setPromptText("Search...");
        serachBAR.setPrefSize(300,41.2);
        serachBAR.setStyle("-fx-background-radius: 20 0 0 20;" + "-fx-background-color: #E2DDF8;"+
                "-fx-border-color: #3F2B63;" + "-fx-border-width: 2px;" + "-fx-border-radius: 20 0 0 20;");


        Image searchimg = new Image(getClass().getResourceAsStream("/searchICON.png"));

        Button searchbtn = new Button("",new ImageView(searchimg));
        searchbtn.setStyle("-fx-background-radius: 0 19 19 0;"+ "-fx-background-color: #E2DDF8;"+
                "-fx-border-color: #3F2B63;"  + "-fx-border-radius: 0 19 19 0;");
        searchbtn.setPrefSize(60,40);

        ComboBox<String> comboBox = new ComboBox<>();

        // Add items to the ComboBox
        ObservableList<String> items = FXCollections.observableArrayList(
                "Customer ID", "First Name", "Last Name", "Address" ,  "License Number" , "Phone Number"
        );
        comboBox.setItems(items);
        comboBox.setPrefSize(200,40);
        comboBox.setPromptText("Specify the field..");
        comboBox.setStyle("-fx-background-color: #E2DDF8;"+ "-fx-font-family:Comic Sans MS;" + "-fx-font-size: 15px");
        comboBox.setPadding(new Insets(0 ,0 ,0 ,30));

        HBox search = new HBox();

        search.getChildren().addAll(serachBAR,searchbtn);
        search.setAlignment(Pos.CENTER);


        TableView<Customer> CustomerTable = new TableView<>();

        CustomerTable.setPrefSize(200, 400);
        CustomerTable.setPadding(new Insets(15,15,5,15));


        TableColumn<Customer, Integer> columnCustomerID = new TableColumn<>("Customer_ID");
        columnCustomerID.setCellValueFactory(new PropertyValueFactory<>("customerID"));

        TableColumn<Customer, String> columnFirstName = new TableColumn<>("First_name");
        columnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));

        TableColumn<Customer, String> columnLastName = new TableColumn<>("Last_name");
        columnLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        TableColumn<Customer, String> columnAddress = new TableColumn<>("Address");
        columnAddress.setCellValueFactory(new PropertyValueFactory<>("address"));

        TableColumn<Customer, String> columnLicenseNumber = new TableColumn<>("License_number");
        columnLicenseNumber.setCellValueFactory(new PropertyValueFactory<>("licenseNumber"));

        TableColumn<Customer, String> columnPhone = new TableColumn<>("Phone");
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));


        CustomerTable.getColumns().addAll(columnCustomerID, columnFirstName, columnLastName, columnAddress, columnLicenseNumber, columnPhone);
        CustomerTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView
        Label Clabel = new Label("Customers");
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setPrefSize(500,70);
        Clabel.setStyle("-fx-font-family: Helvetica;" +
                "-fx-font-size: 50;"
                +
                "-fx-text-fill: #3F2B63;"+
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"+
                "-fx-background-color: TRANSPARENT;");

        Button Insert = new Button("Insert");
        Button Delete = new Button("Delete");
        Button Update = new Button("Update");
        Button Refresh = new Button("Refresh");


        Insert.setPrefSize(150,40);
        Update.setPrefSize(150,40);
        Delete.setPrefSize(150,40);
        Refresh.setPrefSize(150,40);


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
                "-fx-border-radius: 50;"+
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
                "-fx-font-style: ITALIC;" +
                "-fx-border-radius: 50;"+
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
                "-fx-border-radius: 50;"+
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
                "-fx-border-radius: 50;"+
                "-fx-background-radius: 50;"); // Font family


        HBox buttons = new HBox();
        buttons.getChildren().addAll(Insert,Update,Refresh);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));

        CustomerTable.setStyle("-fx-background-color: #E2DDF8;"+
                "-fx-border-radius: 20;"+
                "-fx-background-radius: 20;"+
                "-fx-border-color: #3F2B63;"+
                "-fx-border-width: 2;"+
                "-fx-font-size: 14px ");

        columnCustomerID.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");

        columnFirstName.setStyle("-fx-background-color:#E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        columnLastName.setStyle("-fx-background-color:#E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        columnAddress.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        // columnJob.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        columnLicenseNumber.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        columnPhone.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK; "+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");

        sceneArea.getChildren().addAll(Clabel,search,comboBox,CustomerTable,buttons);

        CustomerTable.setItems(dataList);
        CustomerTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        CustomerTable.setRowFactory(MT -> {
            TableRow<Customer> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    int index = row.getIndex();
                    if (CustomerTable.getSelectionModel().isSelected(index)) {
                        CustomerTable.getSelectionModel().clearSelection(index);
                    } else {
                        CustomerTable.getSelectionModel().select(index);

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

        CustomerTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);


        Stage form = new Stage();
        form.setTitle("Customer Data");
        form.setResizable(false);

        GridPane root = new GridPane();
        root.setPrefWidth(250);
        Scene scene1 = new Scene(root, 320, 400);
        form.setScene(scene1);
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root. setStyle("-fx-background-color:#E2DDF8; "+ "-fx-border-color: #3F2B63;" + "-fx-border-width: 2");


        Label label1 = new Label("Customer ID");
        TextField customerIDField = new TextField();
        Label label2 = new Label("First Name");
        TextField customerFirstNameField = new TextField();
        Label label3 = new Label("Last Name");
        TextField customerLastNameField = new TextField();
        Label label4 = new Label("Address");
        TextField customerAddressField = new TextField();
        Label label5 = new Label("Job");
        TextField jobField = new TextField();
        Label label6 = new Label("Phone");
        TextField customerPhoneField = new TextField();
        Label label7 = new Label("License Number");
        TextField licenseNumberField = new TextField();

        label1.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label2.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label3.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label4.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label5.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label6.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label7.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        // Create an OK button and style it
        Button ok = new Button("OK");
        ok.setPrefSize(150, 20);
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


        root.add(label1, 0, 0);
        root.add(customerIDField, 1, 0);
        root.add(label2, 0, 1);
        root.add(customerFirstNameField, 1, 1);
        root.add(label3, 0, 2);
        root.add(customerLastNameField, 1, 2);
        root.add(label4, 0, 3);
        root.add(customerAddressField, 1, 3);
        root.add(label6, 0, 4);
        root.add(customerPhoneField, 1, 4);
        root.add(label7, 0, 5);
        root.add(licenseNumberField, 1, 5);
        root.add(ok, 1, 7);



        Stage form2 = new Stage();
        form2.setTitle("Customer Data");
        form2.setResizable(false);

        GridPane root2 = new GridPane();
        root.setPrefWidth(250);
        Scene scene4 = new Scene(root2, 320, 400);
        form2.setScene(scene4);
        root2.setPadding(new Insets(10));
        root2.setHgap(10);
        root2.setVgap(10);
        root2. setStyle("-fx-background-color:#E2DDF8; "+ "-fx-border-color: #3F2B63;" + "-fx-border-width: 2");


        Label label11 = new Label("Customer ID");
        TextField customerIDField2 = new TextField();
        Label label12 = new Label("First Name");
        TextField customerFirstNameField2 = new TextField();
        Label label13 = new Label("Last Name");
        TextField customerLastNameField2 = new TextField();
        Label label14 = new Label("Address");
        TextField customerAddressField2 = new TextField();

        Label label15 = new Label("Phone");
        TextField customerPhoneField2 = new TextField();
        Label label16 = new Label("License Number");
        TextField licenseNumberField2 = new TextField();

        label11.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label12.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label13.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label14.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label15.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        label16.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+
                "-fx-font-size: 15px;" +"-fx-text-fill: #3F2B63; "+
                "-fx-font-weight: BOLD;"+ "-fx-font-style: ITALIC;");

        Button ok2 = new Button("Update");
        ok2.setPrefSize(150, 20);
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


        root2.add(label11, 0, 0);
        root2.add(customerIDField2, 1, 0);
        root2.add(label12, 0, 1);
        root2.add(customerFirstNameField2, 1, 1);
        root2.add(label13, 0, 2);
        root2.add(customerLastNameField2, 1, 2);
        root2.add(label14, 0, 3);
        root2.add(customerAddressField2, 1, 3);
        root2.add(label15, 0, 4);
        root2.add(customerPhoneField2, 1, 4);
        root2.add(label16, 0, 5);
        root2.add(licenseNumberField2, 1, 5);

        // Add OK button to the layout
        root2.add(ok2, 1, 7);



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

       /* dealBtn.setOnAction(e -> {
            // Get the button's scene
            signAcontractGUI.start(stage);
            Scene scene3 = dealBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });*/



        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// Back End

Refresh.setOnAction(e->{

    serachBAR.setText("");
    comboBox.getSelectionModel().clearSelection();
    comboBox.getItems().clear();
    ObservableList<String> items1 = FXCollections.observableArrayList(
            "Customer ID", "First Name", "Last Name", "Address" ,  "License Number" , "Phone Number"
    );
    comboBox.setItems(items1);
    comboBox.setPromptText("Specify the field...");

    data = new ArrayList<>();
    try {
        getData();
        dataList = FXCollections.observableArrayList(data);
    } catch (Exception e1) {
        System.out.println(e1.getMessage());
    }

    CustomerTable.setItems(dataList);
    CustomerTable.refresh();

});





        Update.setOnAction(e->{
            Customer selected = CustomerTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                form2.show();
                customerIDField2.setText(selected.getCustomerID());
                customerFirstNameField2.setText(selected.getFirstName());
                customerLastNameField2.setText(selected.getLastName());
                customerAddressField2.setText(selected.getAddress());
                licenseNumberField2.setText(selected.getLicenseNumber());
                customerPhoneField2.setText(selected.getPhone());

            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected row");
                alert.setHeaderText(null);
                alert.setContentText("You must select a row first !!");
                alert.showAndWait();
            }

            ok2.setOnAction(e1->{
                boolean err = false;
                String customerID = customerIDField2.getText();
                if(customerIDField2.getText().equals("")){
                    Alert emptyCID = new Alert(Alert.AlertType.ERROR);
                    emptyCID.setTitle("empty field");
                    emptyCID.setHeaderText(null);
                    emptyCID.setContentText("customer Id field is empty!!!");
                    emptyCID.showAndWait();
                    err = true;
                }
                else if (!isValidId(customerID)) {
                    Alert invalidCID = new Alert(Alert.AlertType.ERROR);
                    invalidCID.setTitle("invalid customer Id");
                    invalidCID.setHeaderText(null);
                    invalidCID.setContentText("customer id must be an 9 digit length integer!!!");
                    invalidCID.showAndWait();
                    err = true;
                }else{

                    try {
                        if (doesCustomerExist(Integer.parseInt(customerIDField2.getText()))&& !selected.getCustomerID().equals(customerIDField2.getText())) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("Duplicate Customer ID");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("This Cutomer ID already exists in our records!!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }

                String customerFirstName = customerFirstNameField2.getText();
                if (customerFirstNameField2.getText().equals("")){
                    Alert emptyFN = new Alert(Alert.AlertType.ERROR);
                    emptyFN.setTitle("empty field");
                    emptyFN.setHeaderText(null);
                    emptyFN.setContentText("customer first name field is empty!!!");
                    emptyFN.showAndWait();
                    err = true;
                }
                else if (!isOnlyLetters(customerFirstName)) {
                    Alert invalidFN = new Alert(Alert.AlertType.ERROR);
                    invalidFN.setTitle("invalid customer first name");
                    invalidFN.setHeaderText(null);
                    invalidFN.setContentText("customer first name must only contain letters!!!");
                    invalidFN.showAndWait();
                    err = true;
                }



                String customerLastName = customerLastNameField2.getText();

                if (customerLastNameField2.getText().equals("")){
                    Alert emptyLN = new Alert(Alert.AlertType.ERROR);
                    emptyLN.setTitle("empty field");
                    emptyLN.setHeaderText(null);
                    emptyLN.setContentText("customer last name field is empty!!!");
                    emptyLN.showAndWait();
                    err = true;
                }
                else if (!isOnlyLetters(customerLastName)) {
                    Alert invalidLN = new Alert(Alert.AlertType.ERROR);
                    invalidLN.setTitle("invalid customer last name");
                    invalidLN.setHeaderText(null);
                    invalidLN.setContentText("customer last name must only contain letters!!!");
                    invalidLN.showAndWait();
                    err = true;
                }
                String customerAddress = customerAddressField2.getText();
                if (customerAddressField2.getText().equals("")){
                    Alert emptyaddr = new Alert(Alert.AlertType.ERROR);
                    emptyaddr.setTitle("empty field");
                    emptyaddr.setHeaderText(null);
                    emptyaddr.setContentText("customer Address field is empty!!!");
                    emptyaddr.showAndWait();
                    err = true;
                }
                else if (isNumeric(customerAddress)) {
                    Alert invalidaddr = new Alert(Alert.AlertType.ERROR);
                    invalidaddr.setTitle("invalid customer address");
                    invalidaddr.setHeaderText(null);
                    invalidaddr.setContentText("customer address must contain letters!!!");
                    invalidaddr.showAndWait();
                    err = true;
                }


                String customerPhone = customerPhoneField2.getText();
                if (customerPhoneField2.getText().equals("")){
                    Alert emptyPhone = new Alert(Alert.AlertType.ERROR);
                    emptyPhone.setTitle("empty field");
                    emptyPhone.setHeaderText(null);
                    emptyPhone.setContentText("customer Phone field is empty!!!");
                    emptyPhone.showAndWait();
                    err = true;
                }
                else if (!isValidPhoneNumber(customerPhone)) {
                    Alert invalidPhone = new Alert(Alert.AlertType.ERROR);
                    invalidPhone.setTitle("invalid customer phone number");
                    invalidPhone.setHeaderText(null);
                    invalidPhone.setContentText("customer phone number must be 10 digits and starts with 05 !!!");
                    invalidPhone.showAndWait();
                    err = true;
                }

                String licenseNumber = licenseNumberField2.getText();

                if (licenseNumberField2.getText().equals("")){
                    Alert emptyLnum = new Alert(Alert.AlertType.ERROR);
                    emptyLnum.setTitle("empty field");
                    emptyLnum.setHeaderText(null);
                    emptyLnum.setContentText("customer license number field is empty!!!");
                    emptyLnum.showAndWait();
                    err = true;
                }
                else if (!isValidLicenseNumber(licenseNumber)) {
                    Alert invalidaddr = new Alert(Alert.AlertType.ERROR);
                    invalidaddr.setTitle("invalid customer License number");
                    invalidaddr.setHeaderText(null);
                    invalidaddr.setContentText("customer license number length must be 10 and contains only numbers !!!");
                    invalidaddr.showAndWait();
                    err = true;
                }else {

                    try {
                        if (doesExist(licenseNumber) && (!selected.getLicenseNumber().equals(licenseNumberField2.getText()))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("Duplicate license number");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("This license number already exists in our records!!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException e3) {
                        throw new RuntimeException(e3);
                    }

                }


                if (!err){

                    if(!selected.getCustomerID().equals(customerIDField2.getText()))
                        updateCustomerID(selected.getCustomerID(), customerIDField2.getText());

                    if(!selected.getFirstName().equals(customerFirstNameField2.getText()))
                        updateCustomerFirstName(selected.getCustomerID(), customerFirstNameField2.getText());

                    if(!selected.getLastName().equals(customerLastNameField2.getText()))
                        updateCustomerLastName(selected.getCustomerID(), customerLastNameField2.getText());

                    if(!selected.getAddress().equals(customerAddressField2.getText()))
                        updateCustomerAddress(selected.getCustomerID(), customerAddressField2.getText());


                    if(!selected.getLicenseNumber().equals(licenseNumberField2.getText()))
                        updateCustomerLicenseNumber(selected.getCustomerID(), licenseNumberField2.getText());


                    if(!selected.getPhone().equals(customerPhoneField2.getText()))
                        updateCustomerPhone(selected.getCustomerID(), customerPhoneField2.getText());

                    selected.setCustomerID(customerIDField2.getText());
                    selected.setFirstName(customerFirstNameField2.getText());
                    selected.setLastName(customerLastNameField2.getText());
                    selected.setAddress(customerAddressField2.getText());
                    selected.setLicenseNumber(licenseNumberField2.getText());
                    selected.setPhone(customerPhoneField2.getText());

                    CustomerTable.refresh();
                    Alert doneUp = new Alert(Alert.AlertType.INFORMATION);
                    doneUp.setTitle("record updated");
                    doneUp.setHeaderText(null);
                    doneUp.setContentText("Record updated successfully :)");
                    doneUp.showAndWait();
                    form2.close();


                }


            });


        });


//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        Insert.setOnAction(e->{
            form.show();

            ok.setOnAction(e1->{
                boolean err = false;
                String customerID = customerIDField.getText();
                if(customerIDField.getText().equals("")){
                    Alert emptyCID = new Alert(Alert.AlertType.ERROR);
                    emptyCID.setTitle("empty field");
                    emptyCID.setHeaderText(null);
                    emptyCID.setContentText("customer Id field is empty!!!");
                    emptyCID.showAndWait();
                    err = true;
                }
                else if (!isValidId(customerID)) {
                    Alert invalidCID = new Alert(Alert.AlertType.ERROR);
                    invalidCID.setTitle("invalid customer Id");
                    invalidCID.setHeaderText(null);
                    invalidCID.setContentText("customer id must be an 9 digit length integer!!!");
                    invalidCID.showAndWait();
                    err = true;
                }
                else{

                    try {
                        if (doesCustomerExist(Integer.parseInt(customerIDField.getText()))) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("Duplicate Customer ID");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("This Cutomer ID already exists in our records!!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                }

                String customerFirstName = customerFirstNameField.getText();
                if (customerFirstNameField.getText().equals("")){
                    Alert emptyFN = new Alert(Alert.AlertType.ERROR);
                    emptyFN.setTitle("empty field");
                    emptyFN.setHeaderText(null);
                    emptyFN.setContentText("customer first name field is empty!!!");
                    emptyFN.showAndWait();
                    err = true;
                }
                else if (!isOnlyLetters(customerFirstName)) {
                    Alert invalidFN = new Alert(Alert.AlertType.ERROR);
                    invalidFN.setTitle("invalid customer first name");
                    invalidFN.setHeaderText(null);
                    invalidFN.setContentText("customer first name must only contain letters!!!");
                    invalidFN.showAndWait();
                    err = true;
                }



                String customerLastName = customerLastNameField.getText();

                if (customerLastNameField.getText().equals("")){
                    Alert emptyLN = new Alert(Alert.AlertType.ERROR);
                    emptyLN.setTitle("empty field");
                    emptyLN.setHeaderText(null);
                    emptyLN.setContentText("customer last name field is empty!!!");
                    emptyLN.showAndWait();
                    err = true;
                }
                else if (!isOnlyLetters(customerLastName)) {
                    Alert invalidLN = new Alert(Alert.AlertType.ERROR);
                    invalidLN.setTitle("invalid customer last name");
                    invalidLN.setHeaderText(null);
                    invalidLN.setContentText("customer last name must only contain letters!!!");
                    invalidLN.showAndWait();
                    err = true;
                }
                String customerAddress = customerAddressField.getText();
                if (customerAddressField.getText().equals("")){
                    Alert emptyaddr = new Alert(Alert.AlertType.ERROR);
                    emptyaddr.setTitle("empty field");
                    emptyaddr.setHeaderText(null);
                    emptyaddr.setContentText("customer Address field is empty!!!");
                    emptyaddr.showAndWait();
                    err = true;
                }
                else if (isNumeric(customerAddress)) {
                    Alert invalidaddr = new Alert(Alert.AlertType.ERROR);
                    invalidaddr.setTitle("invalid customer address");
                    invalidaddr.setHeaderText(null);
                    invalidaddr.setContentText("customer address must contain letters!!!");
                    invalidaddr.showAndWait();
                    err = true;
                }


                String customerPhone = customerPhoneField.getText();
                if (customerPhoneField.getText().equals("")){
                    Alert emptyPhone = new Alert(Alert.AlertType.ERROR);
                    emptyPhone.setTitle("empty field");
                    emptyPhone.setHeaderText(null);
                    emptyPhone.setContentText("customer Phone field is empty!!!");
                    emptyPhone.showAndWait();
                    err = true;
                }
                else if (!isValidPhoneNumber(customerPhone)) {
                    Alert invalidPhone = new Alert(Alert.AlertType.ERROR);
                    invalidPhone.setTitle("invalid customer phone number");
                    invalidPhone.setHeaderText(null);
                    invalidPhone.setContentText("customer phone number must be 10 digits and starts with 05 !!!");
                    invalidPhone.showAndWait();
                    err = true;
                }

                String licenseNumber = licenseNumberField.getText();

                if (licenseNumberField.getText().equals("")){
                    Alert emptyLnum = new Alert(Alert.AlertType.ERROR);
                    emptyLnum.setTitle("empty field");
                    emptyLnum.setHeaderText(null);
                    emptyLnum.setContentText("customer license number field is empty!!!");
                    emptyLnum.showAndWait();
                    err = true;
                }
                else if (!isValidLicenseNumber(licenseNumber)) {
                    Alert invalidaddr = new Alert(Alert.AlertType.ERROR);
                    invalidaddr.setTitle("invalid customer License number");
                    invalidaddr.setHeaderText(null);
                    invalidaddr.setContentText("customer license number length must be 10 and contains only numbers !!!");
                    invalidaddr.showAndWait();
                    err = true;
                }else {

                    try {
                        if (doesExist(licenseNumber)) {
                            Alert noSuchId = new Alert(Alert.AlertType.ERROR);
                            noSuchId.setTitle("Duplicate license number");
                            noSuchId.setHeaderText(null);
                            noSuchId.setContentText("This license number already exists in our records!!");
                            noSuchId.showAndWait();
                            err = true;

                        }
                    } catch (SQLException e3) {
                        throw new RuntimeException(e3);
                    }

                }


                if (!err) {
                    try {
                        Customer c = new Customer(customerIDField.getText(),
                                customerFirstNameField.getText(),
                                customerLastNameField.getText(),
                                customerAddressField.getText(),
                                licenseNumberField.getText(),
                                customerPhoneField.getText());
                        if (insertCustomer(c)){
                            dataList.add(c);
                            Alert Added = new Alert(Alert.AlertType.INFORMATION);
                            Added.setTitle("insert completed");
                            Added.setHeaderText(null);
                            Added.setContentText("new record has been inserted :)");
                            Added.showAndWait();
                            customerIDField.setText("");
                            customerFirstNameField.setText("");
                            customerLastNameField.setText("");
                            customerAddressField.setText("");
                            licenseNumberField.setText("");
                            customerPhoneField.setText("");
                            form.close();
                        }

                    } catch (Exception e2) {
                        Connector.showAlert("Error", e2.getMessage());
                    }

                }

            });


        });

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// search part

        searchbtn.setOnAction(e2 -> {
            String searchContent = serachBAR.getText();
            String searchField = comboBox.getValue();


            if (comboBox.getValue() != null) {


                 if(serachBAR.getText().equals("")){
                     Alert emptysearch = new Alert(Alert.AlertType.ERROR);
                     emptysearch.setTitle("empty field");
                     emptysearch.setHeaderText(null);
                     emptysearch.setContentText("the search bar is empty!!!");
                     emptysearch.showAndWait();
                } else {
                    if (searchField != null && !searchContent.isEmpty()) {
                        String dbField = "";
                        switch (searchField) {
                            case "Customer ID":
                                dbField = "Customer_ID";
                                break;
                            case "First Name":
                                dbField = "First_name";
                                break;
                            case "Last Name":
                                dbField = "Last_name";
                                break;
                            case "Address":
                                dbField = "Address";
                                break;
                            case "License Number":
                                dbField = "Licenses_number";
                                break;
                            case "Phone Number":
                                dbField = "Phone";
                                break;
                        }

                        if (!dbField.isEmpty()) {
                            List<Customer> filteredList = searchCustomer(dbField, searchContent);
                            customerData.setAll(filteredList);
                            CustomerTable.setItems(customerData);
                        }
                    }
                }
            }else{
                Alert emptycombo = new Alert(Alert.AlertType.ERROR);
                emptycombo.setTitle("empty field");
                emptycombo.setHeaderText(null);
                emptycombo.setContentText("select a field!!!");
                emptycombo.showAndWait();
            }
        });




        Delete.setOnAction(e -> {
            Customer selected = CustomerTable.getSelectionModel().getSelectedItem();
            if (selected != null) {
                Alert confirmDelete = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to delete?", ButtonType.YES, ButtonType.NO);
                confirmDelete.setTitle("Confirm Deletion");
                confirmDelete.setHeaderText(null);
                Optional<ButtonType> choose = confirmDelete.showAndWait();
                if (choose.isPresent() && choose.get() == ButtonType.YES) {
                    try {
                        deleteRow(selected);
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    dataList.remove(selected);
                    CustomerTable.refresh();
                    Alert Deleted = new Alert(Alert.AlertType.INFORMATION, "Customer Record deleted successfully.");
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





        //stage.setScene(scene);
       // stage.setTitle("Customer GUI");
       // stage.show();
        return scene;

    }


    private void getData() throws SQLException, ClassNotFoundException {
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String SQL = "SELECT Customer_ID, First_name, Last_name, Address, Licenses_number, Phone FROM Customers";
            stmt = Connector.getCon().createStatement();
            rs = stmt.executeQuery(SQL);

            while (rs.next()) {

                String Customer_ID = rs.getString("Customer_ID");
                String First_name = rs.getString("First_name");
                String Last_name = rs.getString("Last_name");
                String Address = rs.getString("Address");
                String Licenses_number = rs.getString("Licenses_number");
                String Phone = rs.getString("Phone");


                Customer customer = new Customer(Customer_ID, First_name, Last_name, Address, Licenses_number, Phone);
                data.add(customer);

                System.out.println("from database Customer ID=" + Customer_ID + ", First Name=" + First_name + ", Last Name=" + Last_name +
                        ", Address=" + Address + ", License_number=" + Licenses_number + ", Phone=" + Phone );
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                Connector.getCon().close();

                dataList = FXCollections.observableArrayList(data); // Refresh the ObservableList

                System.out.println("Connection closed. Total Customers reocrds loaded: " + data.size());
                System.out.println("Data " + data);

            } catch (SQLException e) {
                System.out.println("Failed to close database resources.");
            }
        }
    }


    private void deleteRow(Customer row) throws Exception {
        System.out.println("delete from Customers where Customer_ID=" + row.getCustomerID() + ";");
        Connector.connectDB();

        Connector.ExecuteStatement("delete from  Customers where Customer_ID=" + row.getCustomerID() + ";");
        Connector.getCon().close();
        System.out.println("Connection closed");
    }


    public void updateCustomerID(String customer_ID , String custID) {

        try {
            System.out.println("update  Customers set Customer_ID = '" + custID + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set Customer_ID = '" + custID + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }


    public void updateCustomerFirstName(String customer_ID, String first_name) {

        try {
            System.out.println("update  Customers set First_name = '" + first_name + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set First_name = '" + first_name + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }

    public void updateCustomerLastName(String customer_ID, String last_name) {

        try {
            System.out.println("update  Customers set Last_name = '" + last_name + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set Last_name = '" + last_name + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }


    public void updateCustomerAddress(String customer_ID, String address) {

        try {
            System.out.println("update  Customers set Address = '" + address + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set Address = '" + address + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }


    public void updateCustomerPhone(String customer_ID, String phone) {

        try {
            System.out.println("update  Customers set Phone = '" + phone + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set  Phone = '" + phone + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }


    public void updateCustomerLicenseNumber(String customer_ID, String licenseNumber) {

        try {
            System.out.println("update  Customers set Licenses_number = '" + licenseNumber + "' where Customer_ID = " + customer_ID);
            Connector.connectDB();
            Connector.ExecuteStatement("update  Customers set  Licenses_number = '" + licenseNumber + "' where Customer_ID = " + customer_ID + ";");
            Connector.getCon().close();
            System.out.println("Connection closed");

        } catch (SQLException e) {
            Connector.showAlert("Error", e.getMessage());
        }
    }


    public boolean insertCustomer( Customer C) {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            Connector.connectDB();
            String sql = "INSERT INTO Customers (Customer_ID,First_name,Last_name,Address,Licenses_number, Phone) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = Connector.getCon().prepareStatement(sql);
            // pstmt = Connector.getCon().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, C.getCustomerID());
            pstmt.setString(2, C.getFirstName());
            pstmt.setString(3, C.getLastName());
            pstmt.setString(4, C.getAddress());
            pstmt.setString(5, C.getLicenseNumber());
            pstmt.setString(6, C.getPhone());

            pstmt.executeUpdate();
            System.out.println(pstmt.toString());
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

    public static boolean isNumeric(String str) {


        for (char digit : str.toCharArray()) {
            if (!Character.isDigit(digit)) {
                return false;
            }
        }
        return true;
    }

    public boolean isValidId(String ID) {
        return ID.matches("\\d{9}");
    }

    public static boolean isOnlyLetters(String str) {

        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        return  phoneNumber.matches("^05\\d{8}$");
    }


    public static boolean isValidLicenseNumber(String LicenseNumber) {

        return (LicenseNumber.length()==10 && isNumeric(LicenseNumber));

    }


    public static List<Customer> searchCustomer(String field, String searchKey) {
        List<Customer> customers = new ArrayList<>();
        String query = "SELECT * FROM Customers WHERE " + field + " LIKE ?";

        Connector.connectDB();

        try (PreparedStatement preparedStatement = Connector.getCon().prepareStatement(query)) {
            preparedStatement.setString(1, "%" + searchKey + "%");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Customer customer = new Customer(

                        resultSet.getString("Customer_ID"),
                        resultSet.getString("First_name"),
                        resultSet.getString("Last_name"),
                        resultSet.getString("Address"),
                        resultSet.getString("Licenses_number"),
                        resultSet.getString("Phone")
                );
                customers.add(customer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public boolean doesExist(String licenseNUM) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select Licenses_number from Customers where Licenses_number =" + licenseNUM + ";");
        Connector.connectDB();
        String SQL = "select Licenses_number from Customers where Licenses_number = " + licenseNUM;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }
        return true;


    }

    public boolean doesCustomerExist(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select First_name from Customers where Customer_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select First_name from Customers where Customer_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }
        return true;


    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getCustomerScene(primaryStage));
        primaryStage.setTitle("Customer GUI");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();
    }
}




