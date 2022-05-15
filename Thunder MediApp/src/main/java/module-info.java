module com.example.thunder_mediapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.thunder_mediapp to javafx.fxml;
    exports com.example.thunder_mediapp;
}