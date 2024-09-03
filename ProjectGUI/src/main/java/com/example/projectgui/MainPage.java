package com.example.projectgui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;
import DAO.MainDAO;
import java.util.Map;


public class MainPage extends Application {
    private Stage stage2;


    public static void main(String[] args) {
        launch(args);
    }

    public Scene getDashboardScene(Stage primaryStage) {

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

        current.getChildren().addAll(label,DASHBOARD);

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
        space.setPrefSize(350,10);


        Image logo = new Image("/LOGO3.PNG");
        ImageView logoView = new ImageView(logo);
        logoView.setFitWidth(320);
        logoView.setFitHeight(100);




        VBox Menu = new VBox();
        Menu.getChildren().addAll(logoView,space,current,CustomersBtn,EmployeesBtn,ContractBtn,PaymentsBtn,MaintenanceBtn,VehiclesBtn,dealBtn);
        Menu.setSpacing(3);
        Menu.setPadding(new Insets(2));

        VBox sceneArea = new VBox();
        sceneArea.setStyle("-fx-background-color: #FFFFFF;");
        sceneArea.setSpacing(50);
        sceneArea.setPadding(new Insets(20,20,100,20));
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
        GP1.getColumnConstraints().addAll(column1,column2);
        GP1.setBackground(new Background(new BackgroundFill(Color.web("#3F2B63"), null, null)));
        GP1.add(Menu,0,0);






        Label Clabel = new Label("DashBoard");
        Clabel.setAlignment(Pos.CENTER);
        Clabel.setPrefSize(500,70);
        Clabel.setStyle("-fx-font-family: Helvetica;" +
                "-fx-font-size: 50;"
                +
                "-fx-text-fill: #3F2B63;"+
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"+
                "-fx-background-color: TRANSPARENT;");


        TextField empNUM = new TextField();
        empNUM.setPrefSize(150,150);

        TextField carNUM = new TextField();
        carNUM.setPrefSize(150,150);

        TextField availableCARS = new TextField();
        availableCARS.setPrefSize(150,150);

        TextField monSalaries = new TextField();
        monSalaries.setPrefSize(150,150);




        Label numberOFEMPS = new Label("Number of Employees");
        Label numberofRentedCARS = new Label("Number of Rented Cars");
        Label numberofAvailableCARS = new Label("Number of Available Cars");
        Label monthlySalaries = new Label("Monthly Salaries");

        numberOFEMPS.setStyle("-fx-text-alignment: CENTER;"+ "-fx-font-size: 14px;"+"-fx-font-family: Helvetica;"+"-fx-text-fill: #3F2B63;"+"-fx-font-weight: BOLD;");
        numberofRentedCARS.setStyle("-fx-text-alignment: CENTER;"+ "-fx-font-size: 14px;"+"-fx-font-family: Helvetica;"+"-fx-text-fill: #3F2B63;"+"-fx-font-weight: BOLD;");

        numberofAvailableCARS.setStyle("-fx-text-alignment: CENTER;"+ "-fx-font-size: 14px;"+"-fx-font-family: Helvetica;"+"-fx-text-fill: #3F2B63;"+"-fx-font-weight: BOLD;");
        monthlySalaries.setStyle("-fx-text-alignment: CENTER;"+ "-fx-font-size: 14px;"+"-fx-font-family: Helvetica;"+"-fx-text-fill: #3F2B63;"+"-fx-font-weight: BOLD;");


        empNUM.setEditable(false);
        carNUM.setEditable(false);
        availableCARS.setEditable(false);
        monSalaries.setEditable(false);


        VBox VBox1 = new VBox();
        VBox VBox2 = new VBox();
        VBox VBox3 = new VBox();
        VBox VBox4 = new VBox();

        VBox1.setAlignment(Pos.CENTER);
        VBox2.setAlignment(Pos.CENTER);
        VBox3.setAlignment(Pos.CENTER);
        VBox4.setAlignment(Pos.CENTER);

        VBox1.setSpacing(7);
        VBox2.setSpacing(7);
        VBox3.setSpacing(7);
        VBox4.setSpacing(7);

        VBox1.getChildren().addAll(empNUM,numberOFEMPS);
        VBox2.getChildren().addAll(carNUM,numberofRentedCARS);
        VBox3.getChildren().addAll(availableCARS,numberofAvailableCARS);
        VBox4.getChildren().addAll(monSalaries,monthlySalaries);

        HBox container = new HBox();
        container.setAlignment(Pos.CENTER);
        container.setSpacing(90);
        container.getChildren().addAll(VBox1,VBox2,VBox3,VBox4);



        empNUM.setStyle(
                "-fx-background-image: url('employeeNEW.png');" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-size: contain;" +
                        "-fx-background-position: center;" + "-fx-background-color: #E2DDF8;"+
                        "-fx-font-size: 65px;"
                        +"-fx-border-width: 3;"+"-fx-border-color: #3F2B63; " + "-fx-background-radius: 20;" + "-fx-border-radius: 20;"
                        +"-fx-alignment: CENTER;" + "-fx-text-fill: #3F2B63;"
        );

        monSalaries.setStyle(
                "-fx-background-image: url('salaryNEWW.png');" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-size: contain;" +
                        "-fx-background-position: center;" + "-fx-background-color: #E2DDF8;"+
                        "-fx-font-size: 30px;" +"-fx-font-weight: BOLD;"
                        +"-fx-border-width: 3;"+"-fx-border-color: #3F2B63; " + "-fx-background-radius: 20;" + "-fx-border-radius: 20;"
                        +"-fx-alignment: CENTER;" + "-fx-text-fill: #3F2B63;"

        );

        carNUM.setStyle(
                "-fx-background-image: url('rental-carNEWW.png');" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-size: contain;" +
                        "-fx-background-position: center;" + "-fx-background-color: #E2DDF8;"+
                        "-fx-font-size: 65px;"
                        +"-fx-border-width: 3;"+"-fx-border-color: #3F2B63; " + "-fx-background-radius: 20;" + "-fx-border-radius: 20;"
                        +"-fx-alignment: CENTER;" + "-fx-text-fill: #3F2B63;"

        );

        availableCARS.setStyle(
                "-fx-background-image: url('accept-car.png');" +
                        "-fx-background-repeat: no-repeat;" +
                        "-fx-background-size: contain;" +
                        "-fx-background-position: center;" + "-fx-background-color: #E2DDF8;"+
                        "-fx-font-size: 65px;"
                        +"-fx-border-width: 3;"+"-fx-border-color: #3F2B63; " + "-fx-background-radius: 20;" + "-fx-border-radius: 20;"
                        +"-fx-alignment: CENTER;" + "-fx-text-fill: #3F2B63;"

        );


        empNUM.setText(String.valueOf(MainDAO.getNumberOfEmployees()));
        carNUM.setText(String.valueOf(MainDAO.getNumberOfRentedCars()));
        availableCARS.setText(String.valueOf(MainDAO.getNumberOfAvailableCars()));
        monSalaries.setText(String.valueOf(MainDAO.getTotalMonthlySalaries()));

        //GP1.setStyle("-fx-border-color: BLACK;" + "-fx-border-width: 20;");


        Map<String, Double> contractCosts = MainDAO.getContractCostForLastFourMonths();


        final CategoryAxis xAxis1 = new CategoryAxis();
        final NumberAxis yAxis1 = new NumberAxis();
        xAxis1.setLabel("Months");
        final LineChart<String, Number> lineChart = new LineChart<>(xAxis1, yAxis1);
        lineChart.setTitle("Income Chart");

        XYChart.Series<String, Number> series1 = new XYChart.Series<>();
        series1.setName("Amount");

        for (Map.Entry<String, Double> entry : contractCosts.entrySet()) {
            series1.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }
        lineChart.getData().add(series1);

        // Customize series color
        series1.getNode().setStyle("-fx-stroke: #3F2B63;");


        Map<String, Double> maintenanceCosts = MainDAO.getMaintenanceCostByMonth();


        // Create a BarChart
        final CategoryAxis xAxis2 = new CategoryAxis();
        final NumberAxis yAxis2 = new NumberAxis();
        xAxis2.setLabel("Months");
        final BarChart<String, Number> barChart = new BarChart<>(xAxis2, yAxis2);
        barChart.setTitle(" Current year Maintenance Spending Chart");

        XYChart.Series<String, Number> series2 = new XYChart.Series<>();
        series2.setName("Amount");


        for (Map.Entry<String, Double> entry : maintenanceCosts.entrySet()) {
            series2.getData().add(new XYChart.Data<>(entry.getKey(), entry.getValue()));
        }

        barChart.getData().add(series2);

        for (XYChart.Data<String, Number> data : series2.getData()) {
            Node node = data.getNode();
            node.setStyle("-fx-bar-fill: #3F2B63;");
        }




        // Create a PieChart


        int numberOfAvailableCars = MainDAO.getNumberOfAvailableCars();
        int numberOfRentedCars = MainDAO.getNumberOfRentedCars();

        final PieChart pieChart = new PieChart();
        pieChart.setTitle("Available vs Rented cars Chart");
        PieChart.Data Rented = new PieChart.Data("Rented (" + numberOfRentedCars + ")", numberOfRentedCars);
        PieChart.Data Available = new PieChart.Data("Available (" + numberOfAvailableCars + ")", numberOfAvailableCars);
        pieChart.getData().addAll(Rented, Available);

        // Customize slice colors
        Rented.getNode().setStyle("-fx-pie-color: #3F2B63;");
        Available.getNode().setStyle("-fx-pie-color: purple;");


        lineChart.setStyle("-fx-background-color: #E2DDF8;"+"-fx-border-color: #3F2B63;"+"-fx-border-width: 3;"
                +"-fx-background-radius: 20;" + "-fx-border-radius: 20;"
        );
        barChart.setStyle("-fx-background-color: #E2DDF8;"+"-fx-border-color: #3F2B63;"+"-fx-border-width: 3;"
                +"-fx-background-radius: 20;" + "-fx-border-radius: 20;");
        pieChart.setStyle("-fx-background-color: #E2DDF8;"+"-fx-border-color: #3F2B63;"+"-fx-border-width: 3;"
                +"-fx-background-radius: 20;" + "-fx-border-radius: 20;");


        // Create HBox and add charts
        HBox hbox = new HBox(10); // spacing = 10
        hbox.getChildren().addAll(lineChart, pieChart, barChart);
        sceneArea.getChildren().addAll(Clabel,container,hbox);



        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);



        CustomerGUI customerGUI = new CustomerGUI();
        VehicleGUI vehicleGUI = new VehicleGUI();
        PaymentGUI paymentGUI = new PaymentGUI();
        MaintenanceGUI maintenanceGUI = new MaintenanceGUI();
        ContractGUI contractGUI = new ContractGUI();
        EmployeeGUI employeeGUI = new EmployeeGUI();
        SignAcontractGUI signAcontractGUI = new SignAcontractGUI();
        /*CustomersBtn.setOnAction(e->{
                customerGUI.start(stage);
                customerGUI.
               });*/
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




        //  stage.setScene(scene);
        // stage.setTitle("Middle East Car Rental");
        // stage.show();

        return scene;

    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getDashboardScene(primaryStage));
        primaryStage.setTitle("Middle East Car Rental");
        primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();

    }


}