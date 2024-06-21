module com.example.primedivisorsfindergui {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens com.example.primedivisorsfindergui to javafx.fxml;
    exports com.example.primedivisorsfindergui;
}