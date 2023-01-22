module com.example.juego01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.juego01 to javafx.fxml;
    exports com.example.juego01;
    exports com.example.juego01.controller;
    opens com.example.juego01.controller to javafx.fxml;
}