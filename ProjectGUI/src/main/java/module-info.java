module com.example.projectgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.projectgui to javafx.fxml,javafx.base;
    exports com.example.projectgui;
    exports entities;
    opens entities to javafx.base, javafx.fxml;
    exports DAO;
    opens DAO to javafx.base, javafx.fxml;
    requires java.sql;

}