package com.example.projectgui;

import entities.Connector;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginGUI extends Application {
    private static String loggedId;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Login");
        VBox root = new VBox();
        GridPane grid = new GridPane();
        Scene scene = new Scene(root, 400, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        Image loginICON = new Image(getClass().getResourceAsStream("/loginLOGO.png"));
        ImageView logo =  new ImageView(loginICON);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/lock.png")));
        javafx.scene.control.Label welcometxt = new javafx.scene.control.Label("Welcome To Our DataBase System");

        welcometxt.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-size: 15;"+"-fx-font-weight: bold;"+"-fx-text-fill: #00215E;");

        root.getChildren().addAll(logo,welcometxt,grid);
        root.setAlignment(Pos.TOP_CENTER);
        logo.setFitWidth(300);
        logo.setFitHeight(250);
        root.setStyle("-fx-background-color: #D1D8C5");
        root.setSpacing(20);


        javafx.scene.control.Label username = new javafx.scene.control.Label("User ID");
        javafx.scene.control.Label password = new javafx.scene.control.Label("Password");
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        grid.setHgap(7);
        grid.setVgap(10);
        //root.setPadding(new Insets());
        javafx.scene.control.Button loginButton = new javafx.scene.control.Button("Login");
        loginButton.setPrefSize(150,30);


        grid.add(username, 11, 0);
        grid.add(usernameField, 17, 0);
        grid.add(password, 11, 1);
        grid.add(passwordField, 17, 1);
        grid.add(loginButton,17,3);



        username.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-size: 14px;");
        password.setStyle("-fx-font-family: 'Arial Rounded MT Bold';"+"-fx-font-size: 14px;");
        loginButton.setStyle("-fx-border-color: #FC4100;"+"-fx-font-size: 15px;"+"-fx-font-weight: bold;"+"-fx-border-radius: 20;"+"-fx-background-radius: 20;"+"-fx-background-color: #00215E;"+
                "-fx-text-fill: WHITE;"+"-fx-border-width: 0px;");

       // CustomerGUI customerGUI = new CustomerGUI();
        MainPage main = new MainPage();




        loginButton.setOnAction(e->{
            boolean err = false;


               // String user = usernameField.getText();
               // int usern = Integer.parseInt(user);

               // String txt = passwordField.getText();
               // int pass = Integer.parseInt(txt);

                if(usernameField.getText().equals("")){
                    Alert emptyVID = new Alert(Alert.AlertType.ERROR);
                    emptyVID.setTitle("empty field");
                    emptyVID.setHeaderText(null);
                    emptyVID.setContentText("username field is empty!!!");
                    emptyVID.showAndWait();
                    err = true;
                }
                else if(!isValidId(usernameField.getText())){
                    Alert invalidId = new Alert(Alert.AlertType.ERROR);
                    invalidId.setTitle("invalid Id");
                    invalidId.setHeaderText(null);
                    invalidId.setContentText("Employee id must be 9 digits");
                    invalidId.showAndWait();
                    err = true;
                }
                else {
                    try {
                        if (!doesEmpExist(Integer.parseInt(usernameField.getText()))) {
                                    Alert invalidId = new Alert(Alert.AlertType.ERROR);
                                    invalidId.setTitle("Employee does not exist");
                                    invalidId.setHeaderText(null);
                                    invalidId.setContentText("Employee with id = " +Integer.parseInt(usernameField.getText()) + " does not exist");
                                    invalidId.showAndWait();
                                    err = true;

                        } else {
                                    try {
                                        if (!hasPassword(Integer.parseInt(usernameField.getText()))) {
                                            Alert nopass = new Alert(Alert.AlertType.ERROR);
                                            nopass.setTitle("no password");
                                            nopass.setHeaderText(null);
                                            nopass.setContentText("this id has no access to this system!!");
                                            nopass.showAndWait();
                                            err = true;
                                            System.out.println("bye");
                                        }
                                    } catch (SQLException ex) {
                                        throw new RuntimeException(ex);
                                    }


                                }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            if(passwordField.getText().equals("")){
                Alert emptyVID = new Alert(Alert.AlertType.ERROR);
                emptyVID.setTitle("empty field");
                emptyVID.setHeaderText(null);
                emptyVID.setContentText("password field is empty!!!");
                emptyVID.showAndWait();
                err = true;
            }
            else {

                try {
                    String pass = getPassword(Integer.parseInt(usernameField.getText()));
                    if(pass == null){
                        Alert invalidId = new Alert(Alert.AlertType.ERROR);
                        invalidId.setTitle("invalid password");
                        invalidId.setHeaderText(null);
                        invalidId.setContentText("password must be 4 digits");
                        invalidId.showAndWait();
                        err = true;
                    }
                    else{

                        if (pass.equals(passwordField.getText())){
                            loggedId=usernameField.getText();

                            Scene s = new MainPage().getDashboardScene(primaryStage);
                            primaryStage.setScene(s);
                            primaryStage.setMaximized(true);
                            // primaryStage.setResizable(true);
                            primaryStage.setTitle("Middle East Car Rental");

                        }
                        else {

                        passwordField.setText("");
                        passwordField.requestFocus();
                            Label incorrect = new Label("incorrect password");
                            incorrect.setStyle("-fx-text-fill:RED;");
                            incorrect.setStyle("-fx-font-size: 12px;");
                            grid.add(incorrect,17,2);


                        }


                    }


                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }


            }





        });





    }

  /*  public boolean hasPassword(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select password from employees where Employee_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select password from Employees where Employee_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");

            return false;
        }

       // String pass  =rs.getString("password");
        System.out.println("hi");


        return true;


    }*/

    public boolean hasPassword(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select password from employees where Employee_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select password from Employees where Employee_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);

        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }

        rs.next();

        String password = rs.getString("password");
        if (password == null) {
            System.out.println("Password is null.");
            return false;
        }

        return true;
    }


    public String getPassword(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select password from employees where Employee_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select password from Employees where Employee_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);

        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return null;
        }

        rs.next();

        String password = rs.getString("password");
        if (password == null) {
            System.out.println("Password is null.");
            return null;
        }

        return password;
    }




    public boolean isValidId(String ID) {
        return ID.matches("\\d{9}");
    }

    public boolean doesEmpExist(int id) throws SQLException {
        Statement stmt = null;
        ResultSet rs = null;

        System.out.println("select first_name from Employees where Employee_ID =" + id + ";");
        Connector.connectDB();
        String SQL = "select first_name from Employees where Employee_ID = " + id;
        stmt = Connector.getCon().createStatement();
        rs = stmt.executeQuery(SQL);
        if (!rs.isBeforeFirst()) {
            System.out.println("No data found.");
            return false;
        }
        return true;


    }
    public static String getloggedID() {
        return loggedId;
    }



}
