package com.example.projectgui;

import DAO.PaymentDAO;
import entities.Payment;
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

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentGUI extends Application {
    private Stage stage2;

    private ArrayList<Payment> data;
    private ObservableList<Payment> dataList;

    private PaymentDAO paymentDAO;

    public static void main(String[] args) {
        launch(args);
    }

    public Scene getPaymentScene(Stage primaryStage) {
        data = new ArrayList<>();
        //  VBox vBox =null;
        paymentDAO = new PaymentDAO();

        try {
            data = paymentDAO.getData();
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

        current.getChildren().addAll(label,PaymentsBtn);

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
        Menu.getChildren().addAll(logoView,space,DASHBOARD,CustomersBtn,EmployeesBtn,ContractBtn,current,MaintenanceBtn,VehiclesBtn,logOut);
        Menu.setSpacing(3);
        Menu.setPadding(new Insets(2));

        VBox sceneArea = new VBox();
        sceneArea.setStyle("-fx-background-color: #FFFFFF;");
        sceneArea.setSpacing(50);
        sceneArea.setPadding(new Insets(20,20,20,20));
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
                "Payment ID", "Contract ID", "Date", "Amount", "Method"
        );
        comboBox.setItems(items);
        comboBox.setPrefSize(200,40);
        comboBox.setPromptText("Specify the field..");
        comboBox.setStyle("-fx-background-color: #E2DDF8;"+ "-fx-font-family:Comic Sans MS;" + "-fx-font-size: 15px");
        comboBox.setPadding(new Insets(0 ,0 ,0 ,30));

        HBox search = new HBox();
        // search.setPrefSize(495,40);
        // search.setStyle("-fx-background-radius: 20 20 20 20 ;"+"-fx-background-color: #E2DDF8;");
        //  search.setPadding(new Insets(0,0,0,0));
        search.getChildren().addAll(serachBAR,searchbtn);
        search.setAlignment(Pos.CENTER);



        TableView<Payment> paymentTable = new TableView<>();
        paymentTable.setPrefSize(706, 567);
        paymentTable.setPadding(new Insets(5));




        TableColumn<Payment, Integer> paymentIDColumn = new TableColumn<>("Payment ID");
        paymentIDColumn.setCellValueFactory(new PropertyValueFactory<>("paymentID"));

        TableColumn<Payment, Integer> contractIDColumn = new TableColumn<>("Contract ID");
        contractIDColumn.setCellValueFactory(new PropertyValueFactory<>("contractID"));

        TableColumn<Payment, String> dateColumn = new TableColumn<>("Date");
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("date"));

        TableColumn<Payment, Double> amountColumn = new TableColumn<>("Amount");
        amountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        TableColumn<Payment, String> methodColumn = new TableColumn<>("Method");
        methodColumn.setCellValueFactory(new PropertyValueFactory<>("method"));
        paymentTable.getColumns().addAll(paymentIDColumn, contractIDColumn, dateColumn, amountColumn, methodColumn);



        paymentTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY); // Fit columns to the width of the TableView
        Label Clabel = new Label("Payments");
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
        Button Refresh = new Button("Refresh");
        Button Update = new Button("Update");
        Button Select = new Button("Select");
        Button Stat = new Button("Stat");


        Insert.setPrefSize(150,40);
        Update.setPrefSize(150,40);
        Refresh.setPrefSize(150,40);
        Select.setPrefSize(150,40);
        Stat.setPrefSize(150,40);



        Stat.setStyle("-fx-background-color: #E2DDF8; " + // Background color
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
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius: 50;"+
                "-fx-background-radius: 50;"); // Font family

        Select.setStyle("-fx-background-color: #ED5506; " + // Background color
                "-fx-text-fill: #EEF7FF; " + // Text color
                "-fx-font-size: 25px; " + // Font size
                "-fx-font-family: Constantia;"
                +
                "-fx-border-width: 2;" +
                "-fx-border-color: #3F2B63;"
                +
                "-fx-font-weight: BOLD;" +
                "-fx-font-style: ITALIC;"
                +
                "-fx-border-radius:20;"+
                "-fx-background-radius: 20;"); // Font family

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
        buttons.getChildren().addAll(Update,Refresh,Stat);
        buttons.setAlignment(Pos.CENTER);
        buttons.setSpacing(50);
        buttons.setPadding(new Insets(20));

        paymentTable.setStyle("-fx-background-color: #E2DDF8;"+
                "-fx-border-radius: 20;"+
                "-fx-background-radius: 20;"+
                "-fx-border-color: #3F2B63;"+
                "-fx-border-width: 2;"+
                "-fx-font-size: 14px ");

        paymentIDColumn.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        contractIDColumn.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        dateColumn.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        amountColumn.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");
        methodColumn.setStyle("-fx-background-color: #E2DDF8;"+"-fx-text-fill: BLACK;"+"-fx-alignment: CENTER;"+"-fx-font-family: Comic Sans MS;");

        //  GP1.setStyle("-fx-border-color: BLACK;" + "-fx-border-width: 20;");

        sceneArea.getChildren().addAll(Clabel,search,comboBox,paymentTable,buttons);
        paymentTable.setItems(dataList);
        paymentTable.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        paymentTable.setRowFactory(MT -> {
            TableRow<Payment> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 1) {
                    int index = row.getIndex();
                    if (paymentTable.getSelectionModel().isSelected(index)) {
                        paymentTable.getSelectionModel().clearSelection(index);
                    } else {
                        paymentTable.getSelectionModel().select(index);

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

        paymentTable.setEffect(dropShadow);

        DropShadow dropShadow1 = new DropShadow();
        dropShadow1.setColor(Color.GRAY);
        dropShadow1.setRadius(5);
        dropShadow1.setOffsetX(2);
        dropShadow1.setOffsetY(2);

        Clabel.setEffect(dropShadow1);


        Stage form = new Stage();
        form.setTitle("Payment Data");
        form.setResizable(false);

        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);
        root.setStyle("-fx-background-color: #E2DDF8; -fx-border-color: #3F2B63; -fx-border-width: 2;");




        Label label3 = new Label("Date");
        Label label4 = new Label("Amount");
        Label label5 = new Label("Method");


        label3.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label4.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");
        label5.setStyle("-fx-font-family: 'Arial Rounded MT Bold'; -fx-font-size: 15px; -fx-text-fill: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC;");


        DatePicker dateField = new DatePicker();
        dateField.setEditable(false);
        // DatePicker date = new DatePicker();
        TextField amountField = new TextField();
        //TextField methodField = new TextField();

        dateField.setPrefSize(200,20);

        ComboBox methodField = new ComboBox();
        methodField.setPrefSize(200,20);

        methodField.setStyle("-fx-background-color: WHITE;");

        ObservableList<String> items2 = FXCollections.observableArrayList(
                "Cash", "Visa","Bank Checks"
        );
        methodField.setItems(items2);

        Button ok = new Button("Update");
        ok.setPrefSize(200, 60);
        ok.setStyle("-fx-background-color: #E2DDF8; -fx-text-fill: #3F2B63; -fx-font-size: 14px; -fx-font-family: Comic Sans MS; -fx-border-width: 2; -fx-border-color: #3F2B63; -fx-font-weight: BOLD; -fx-font-style: ITALIC; -fx-border-radius: 10; -fx-background-radius: 10;");

        root.add(label3, 0, 0);
        root.add(dateField, 1, 0);
        root.add(label4, 0, 1);
        root.add(amountField, 1, 1);
        root.add(label5, 0, 3);
        root.add(methodField, 1, 3);
        root.add(ok, 1, 5);

        Scene scene1 = new Scene(root, 320, 175);
        form.setScene(scene1);


        ////////////////////////////////////////////



        Stat.setOnAction(e->{
          //  Label sumRES = new Label("");
           // Label sum = new Label("Sum");
            GridPane stat = new GridPane();

            Label sumLabel = new Label("Total Amount of Payments for each year");

            sumLabel.setStyle("-fx-font-family: Helvetica;" +
                    "-fx-font-size: 20;"
                    +
                    "-fx-text-fill: #3F2B63;"+
                    "-fx-font-weight: BOLD;" +
                    "-fx-font-style: ITALIC;"+
                    "-fx-background-color: TRANSPARENT;");
            stat.add(sumLabel, 2, 0);
            int i = 1;
            try {
                List<Payment> payment1 = PaymentDAO.sumOfPayments();
                for (Payment p : payment1) {
                    Label sum = new Label(p.printSum());
                    sum.setStyle("-fx-font-family: Helvetica;" +
                            "-fx-font-size: 17;"
                            +
                            "-fx-text-fill:Black;"+
                            "-fx-font-weight: BOLD;" +
                            "-fx-font-style: ITALIC;"+
                            "-fx-background-color: TRANSPARENT;");
                    System.out.println(sum);
                    stat.add(sum,2,i);
                    i++;

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            Label maxLabel = new Label("The Maximum Payment of all time");

            maxLabel.setStyle("-fx-font-family: Helvetica;" +
                    "-fx-font-size: 20;"
                    +
                    "-fx-text-fill: #3F2B63;"+
                    "-fx-font-weight: BOLD;" +
                    "-fx-font-style: ITALIC;"+
                    "-fx-background-color: TRANSPARENT;");
            stat.add(maxLabel, 2, i+1);

            int j = i+2;
            try {
                List<Payment> payment2 = PaymentDAO.maxPayment();
                for (Payment p : payment2) {
                    Label max = new Label(p.printMax());
                    max.setStyle("-fx-font-family: Helvetica;" +
                            "-fx-font-size: 17;"
                            +
                            "-fx-text-fill:Black;"+
                            "-fx-font-weight: BOLD;" +
                            "-fx-font-style: ITALIC;"+
                            "-fx-background-color: TRANSPARENT;");
                    System.out.println(max);
                    stat.add(max,2,j);
                    j++;

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            Label minLabel = new Label("The Minimum Payment of all time");

            minLabel.setStyle("-fx-font-family: Helvetica;" +
                    "-fx-font-size: 20;"
                    +
                    "-fx-text-fill: #3F2B63;"+
                    "-fx-font-weight: BOLD;" +
                    "-fx-font-style: ITALIC;"+
                    "-fx-background-color: TRANSPARENT;");
            stat.add(minLabel, 2, j+1);

            int k = j+2;
            try {
                List<Payment> payment2 = PaymentDAO.minPayment();
                for (Payment p : payment2) {
                    Label min = new Label(p.printMin());
                    min.setStyle("-fx-font-family: Helvetica;" +
                            "-fx-font-size: 17;"
                            +
                            "-fx-text-fill:Black;"+
                            "-fx-font-weight: BOLD;" +
                            "-fx-font-style: ITALIC;"+
                            "-fx-background-color: TRANSPARENT;");
                    System.out.println(min);
                    stat.add(min,2,k);
                    k++;

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            Label avgLabel = new Label("The Average Payments amount for each year");

            avgLabel.setStyle("-fx-font-family: Helvetica;" +
                    "-fx-font-size: 20;"
                    +
                    "-fx-text-fill: #3F2B63;"+
                    "-fx-font-weight: BOLD;" +
                    "-fx-font-style: ITALIC;"+
                    "-fx-background-color: TRANSPARENT;");
            stat.add(avgLabel, 2, k+1);

            int m = k+2;
            try {
                List<Payment> payment2 = PaymentDAO.avgPayment();
                for (Payment p : payment2) {
                    Label avg = new Label(p.printAVG());
                    avg.setStyle("-fx-font-family: Helvetica;" +
                            "-fx-font-size: 17;"
                            +
                            "-fx-text-fill:Black;"+
                            "-fx-font-weight: BOLD;" +
                            "-fx-font-style: ITALIC;"+
                            "-fx-background-color: TRANSPARENT;");
                    System.out.println(avg);
                    stat.add(avg,2,m);
                    m++;

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }

            Label freqLabel = new Label("The frequency of each method");

            freqLabel.setStyle("-fx-font-family: Helvetica;" +
                    "-fx-font-size: 20;"
                    +
                    "-fx-text-fill: #3F2B63;"+
                    "-fx-font-weight: BOLD;" +
                    "-fx-font-style: ITALIC;"+
                    "-fx-background-color: TRANSPARENT;");
            stat.add(freqLabel, 2, m+1);

            int n = m+2;
            try {
                List<Payment> payment2 = PaymentDAO.methodfreq();
                for (Payment p : payment2) {
                    Label freq = new Label(p.printmethodFreq());
                    freq.setStyle("-fx-font-family: Helvetica;" +
                            "-fx-font-size: 17;"
                            +
                            "-fx-text-fill:Black;"+
                            "-fx-font-weight: BOLD;" +
                            "-fx-font-style: ITALIC;"+
                            "-fx-background-color: TRANSPARENT;");
                    System.out.println(freq);
                    stat.add(freq,2,n);
                    n++;

                }

            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }


            stat.setPadding(new Insets(10));
            stat.setHgap(10);
            stat.setVgap(10);

            stat.setStyle("-fx-background-color:#E2DDF8;");






            Stage form2 = new Stage();
            form2.setTitle("Payment Stats");
            form2.setResizable(false);
            Scene scene5 = new Scene(stat, 500, 800);
            form2.setScene(scene5);
            form2.show();






        });








        Update.setOnAction(e4 -> {
            Payment selected = paymentTable.getSelectionModel().getSelectedItem();

            if (selected != null) {
                form.show();
                amountField.setText(Double.toString(selected.getAmount()));
                dateField.setValue(selected.getDate());
                methodField.setValue(selected.getMethod());

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("No selected row");
                alert.setHeaderText(null);
                alert.setContentText("You must select a row first !!");
                alert.showAndWait();
            }

            ok.setOnAction(e1 -> {
                // String receiptID = receiptIDField.getText();
                boolean err = false;
                if(amountField.getText().equals("")){
                    Alert emptyVID2 = new Alert(Alert.AlertType.ERROR);
                    emptyVID2.setTitle("empty field");
                    emptyVID2.setHeaderText(null);
                    emptyVID2.setContentText("Amount field is empty!!!");
                    emptyVID2.showAndWait();
                    err = true;
                }
                else if (!isDouble(amountField.getText())){
                    Alert notDouble = new Alert(Alert.AlertType.ERROR);
                    notDouble.setTitle("invalid input");
                    notDouble.setHeaderText(null);
                    notDouble.setContentText("Amount must be a double!!!");
                    notDouble.showAndWait();
                    err = true;
                }
                if(!isAfterOpening(dateField.getValue())){
                    Alert old = new Alert(Alert.AlertType.ERROR);
                    old.setTitle("invalid date");
                    old.setHeaderText(null);
                    old.setContentText("date must not be before 2022 !");
                    old.showAndWait();
                    err = true;
                }


                if (!err) {

                    if (!selected.getMethod().equals(methodField.getValue()))
                        paymentDAO.updateMethod(selected.getPaymentID(), methodField.getValue().toString());
                    if (!Double.toString(selected.getAmount()).equals(amountField.getText()))
                        paymentDAO.updateAmount(selected.getPaymentID(), Double.parseDouble(amountField.getText()));
                    if (!selected.getDate().equals(dateField.getValue()))
                        paymentDAO.updateDate(selected.getPaymentID(), dateField.getValue());
                    selected.setAmount(Double.parseDouble(amountField.getText()));
                    selected.setMethod(methodField.getValue().toString());
                    selected.setDate(dateField.getValue());
                    paymentTable.refresh();
                    Alert doneUp = new Alert(Alert.AlertType.INFORMATION);
                    doneUp.setTitle("record updated");
                    doneUp.setHeaderText(null);
                    doneUp.setContentText("Record updated successfully :)");
                    doneUp.showAndWait();
                    form.close();

                }

            });

        });
        Refresh.setOnAction(e->{
            try {
                data = paymentDAO.getData();
                dataList = FXCollections.observableArrayList(data);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
            paymentTable.setItems(dataList);
            paymentTable.refresh();
        });

        ////////////////////////////// search part

        searchbtn.setOnAction(e2 -> {
            String searchContent = serachBAR.getText();
            String field = comboBox.getValue();
            if (field != null && !searchContent.trim().isEmpty()) {
                String dbField;
                switch (field) {
                    case "Payment ID":
                        dbField = "Payment_ID";
                        break;
                    case "Contract ID":
                        dbField = "Contract_ID";
                        break;
                    case "Date":
                        dbField = "Date";
                        break;
                    case "Amount":
                        dbField = "Amount";
                        break;
                    case "Method":
                        dbField = "Method";
                        break;
                    default:
                        dbField = "";
                        break;
                }
                List<Payment> searchResults = paymentDAO.searchPayemnts(dbField, searchContent);
                dataList.setAll(searchResults);
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid Search");
                alert.setHeaderText(null);
                alert.setContentText("Please specify a field and enter a search term.");
                alert.showAndWait();
            }
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

       /* dealBtn.setOnAction(e -> {
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



        dealBtn.setOnAction(e -> {
            // Get the button's scene
            signAcontractGUI.start(stage);
            Scene scene3 = dealBtn.getScene();

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
            contractGUI.start(stage);
            Scene scene2 = ContractBtn.getScene();

            // Get the stage from the scene
            Stage stage2 = (Stage) scene.getWindow();

            // Close the stage
            stage2.close();

        });*/



       // stage.setScene(scene);
        //stage.setTitle("payment GUI");
        //stage.show();


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

    public static boolean isAfterOpening (LocalDate date){
        LocalDate opening = LocalDate.of(2022,1,1);
        return !date.isBefore(opening);
    }

    public void start(Stage primaryStage) throws Exception {
        this.stage2 = primaryStage;

        primaryStage.setScene(getPaymentScene(primaryStage));
        primaryStage.setTitle("Middle East Car Rental");
        //primaryStage.setMaximized(true);
        //  primaryStage.setResizable(true);
        primaryStage.show();
    }


}
