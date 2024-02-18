module com.luismanuel.cardtoonfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires retrofit2;
    requires retrofit2.converter.gson;
    requires java.sql;
    requires com.google.gson;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires okhttp3;

    opens com.luismanuel.cardtoonfx to javafx.fxml;
    exports com.luismanuel.cardtoonfx;
    exports com.luismanuel.cardtoonfx.modelos;

}