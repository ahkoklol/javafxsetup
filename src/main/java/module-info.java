module com.example.javafxtest {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.example.javafxtest to javafx.fxml;
    exports com.example.javafxtest;
}
